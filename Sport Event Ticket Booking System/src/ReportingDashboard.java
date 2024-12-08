import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;

public class ReportingDashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reporting Dashboard");

        // Labels for dashboard welcome message
        Label dashboardLabel = new Label("Reporting Dashboard");
        dashboardLabel.setFont(new Font("Arial", 30));
        dashboardLabel.setTextFill(Color.WHITE);

        // Logout dropdown menu
        MenuButton logoutMenuButton = new MenuButton("Account");
        logoutMenuButton.setFont(new Font("Arial", 14));
        MenuItem detailsMenuItem = new MenuItem("Details");
        MenuItem settingsMenuItem = new MenuItem("Settings");
        MenuItem logoutMenuItem = new MenuItem("Log Out");
        logoutMenuButton.getItems().addAll(detailsMenuItem, settingsMenuItem, logoutMenuItem);

        HBox topLayout = new HBox(logoutMenuButton);
        topLayout.setAlignment(Pos.TOP_RIGHT);
        topLayout.setPadding(new Insets(10));

        // =================== Dashboard Widgets ===================
        // Ticket Sales Widget
        VBox ticketSalesLabel = createWidgetLabel("Ticket Sales", "1200", "#3498db");

        // Revenue Widget
        VBox revenueLabel = createWidgetLabel("Revenue", "$15,000", "#2ecc71");

        // Available Ticket Count Widget
        VBox availableTicketsLabel = createWidgetLabel("Available Tickets", "500", "#e74c3c");

        // HBox to hold the widgets
        HBox widgetLayout = new HBox(20, ticketSalesLabel, revenueLabel, availableTicketsLabel);
        widgetLayout.setAlignment(Pos.CENTER);
        widgetLayout.setPadding(new Insets(20));

        // =================== Event ID and User Section ===================
        // Event ID input and search button
        Label eventIdLabel = new Label("Event ID:");
        eventIdLabel.setFont(new Font("Arial", 16));
        TextField eventIdField = new TextField();
        eventIdField.setPromptText("Enter Event ID");

        Button searchButton = new Button("Search");

        // View User button
        Button viewUserButton = new Button("View User");

        HBox eventIdBox = new HBox(10, eventIdLabel, eventIdField, searchButton, viewUserButton);
        eventIdBox.setAlignment(Pos.CENTER);
        eventIdBox.setPadding(new Insets(20));

        // =================== Creating TabPane for different reporting sections ===================
        TabPane tabPane = new TabPane();
        Tab salesReportTab = new Tab("Sales Reports");
        Tab revenueAnalysisTab = new Tab("Revenue Analysis");
        Tab userInsightsTab = new Tab("User Insights");

        // =================== Sales Reports Tab ===================
        // ComboBox for event/category selection
        ComboBox<String> salesFilterCombo = new ComboBox<>();
        salesFilterCombo.getItems().addAll("By Event", "By Category");
        salesFilterCombo.setValue("By Event");

        // BarChart for event-wise or category-wise ticket sales
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Event/Category");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tickets Sold");

        BarChart<String, Number> salesChart = new BarChart<>(xAxis, yAxis);
        salesChart.setTitle("Ticket Sales Data");

        VBox salesLayout = new VBox(10, salesFilterCombo, salesChart);
        salesLayout.setPadding(new Insets(10));
        salesLayout.setAlignment(Pos.CENTER);
        salesReportTab.setContent(salesLayout);

        // =================== Revenue Analysis Tab ===================
        // ComboBox for different deduction options (e.g., platform fees, taxes)
        ComboBox<String> revenueFilterCombo = new ComboBox<>();
        revenueFilterCombo.getItems().addAll("After Taxes", "After Platform Fees");
        revenueFilterCombo.setValue("After Taxes");

        // LineChart for revenue analysis (with deductions)
        NumberAxis revXAxis = new NumberAxis();
        revXAxis.setLabel("Event");

        NumberAxis revYAxis = new NumberAxis();
        revYAxis.setLabel("Revenue (in $)");

        LineChart<Number, Number> revenueChart = new LineChart<>(revXAxis, revYAxis);
        revenueChart.setTitle("Revenue Analysis");

        VBox revenueLayout = new VBox(10, revenueFilterCombo, revenueChart);
        revenueLayout.setPadding(new Insets(10));
        revenueLayout.setAlignment(Pos.CENTER);
        revenueAnalysisTab.setContent(revenueLayout);

        // =================== User Insights Tab ===================
        // ComboBox for different user behavior metrics
        ComboBox<String> userInsightsFilterCombo = new ComboBox<>();
        userInsightsFilterCombo.getItems().addAll("Peak Booking Times", "Popular Events");
        userInsightsFilterCombo.setValue("Peak Booking Times");

        // LineChart for user behavior analysis (peak booking times)
        NumberAxis userXAxis = new NumberAxis();
        userXAxis.setLabel("Time of Day");

        NumberAxis userYAxis = new NumberAxis();
        userYAxis.setLabel("Number of Bookings");

        LineChart<Number, Number> userInsightsChart = new LineChart<>(userXAxis, userYAxis);
        userInsightsChart.setTitle("User Behavior Analysis");

        VBox userInsightsLayout = new VBox(10, userInsightsFilterCombo, userInsightsChart);
        userInsightsLayout.setPadding(new Insets(10));
        userInsightsLayout.setAlignment(Pos.CENTER);
        userInsightsTab.setContent(userInsightsLayout);

        // Adding all tabs to the TabPane
        tabPane.getTabs().addAll(salesReportTab, revenueAnalysisTab, userInsightsTab);

        // Main layout
        VBox mainLayout = new VBox(10, topLayout, dashboardLabel, widgetLayout, eventIdBox, tabPane);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        // Set background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#2c3e50"), CornerRadii.EMPTY, Insets.EMPTY);
        mainLayout.setBackground(new Background(backgroundFill));

        // Scene setup
        Scene scene = new Scene(mainLayout, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create a styled widget label
    private VBox createWidgetLabel(String title, String value, String color) {
        // Label for title
        Label titleLabel = new Label(title);
        titleLabel.setFont(new Font("Arial", 18));
        titleLabel.setTextFill(Color.WHITE);

        // Label for value
        Label valueLabel = new Label(value);
        valueLabel.setFont(new Font("Arial", 24));
        valueLabel.setTextFill(Color.WHITE);

        // Create a VBox for each widget (Ticket Sales, Revenue, Available Tickets)
        VBox widgetBox = new VBox(10, titleLabel, valueLabel);
        widgetBox.setAlignment(Pos.CENTER);
        widgetBox.setPadding(new Insets(20));
        widgetBox.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 15;");
        
        // Apply drop shadow for a floating effect
        DropShadow shadow = new DropShadow(10, Color.GRAY);
        widgetBox.setEffect(shadow);

        // Add hover effect for smooth interaction
        widgetBox.setOnMouseEntered(e -> widgetBox.setStyle("-fx-background-color: #2980b9; -fx-background-radius: 15;"));
        widgetBox.setOnMouseExited(e -> widgetBox.setStyle("-fx-background-color: " + color + "; -fx-background-radius: 15;"));

        return widgetBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
