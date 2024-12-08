import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class AdminDashboardInterface extends Application {

    // Simulated database of event types and IDs
    private final Map<String, String> eventDatabase = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Admin Dashboard");

        // Populate event database (for simulation)
        populateEventDatabase();

        // Labels for admin welcome message
        Label dashboardLabel = new Label("Admin Dashboard");
        dashboardLabel.setFont(new Font("Arial", 30));
        dashboardLabel.setTextFill(Color.WHITE);

        // Label and TextField for Event ID input
        Label eventIDLabel = new Label("Enter Event ID:");
        eventIDLabel.setTextFill(Color.WHITE);
        eventIDLabel.setFont(new Font("Arial", 16));

        TextField eventIDField = new TextField();
        eventIDField.setPromptText("Enter Event ID");

        // Label and TextField to display Event Type based on Event ID
        Label eventTypeLabel = new Label("Event Type:");
        eventTypeLabel.setTextFill(Color.WHITE);
        eventTypeLabel.setFont(new Font("Arial", 16));

        TextField eventTypeField = new TextField();
        eventTypeField.setEditable(false);  // Read-only field to display event type
        eventTypeField.setPromptText("Event Type will be displayed here");

        // Button to search for the Event Type based on Event ID
        Button searchButton = new Button("Search Event Type");
        searchButton.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold;");

        // Action for Search Button
        searchButton.setOnAction(e -> {
            String enteredEventID = eventIDField.getText();
            if (eventDatabase.containsKey(enteredEventID)) {
                eventTypeField.setText(eventDatabase.get(enteredEventID));
            } else {
                eventTypeField.setText("Event ID not found");
            }
        });

        // Tabs for Matches and Reports
        TabPane tabPane = new TabPane();
        Tab matchesTab = new Tab("Manage Matches");
        Tab reportsTab = new Tab("View Reports");

        // TableView for managing matches
        TableView<String> matchesTable = new TableView<>();
        matchesTable.setPlaceholder(new Label("No matches available"));

        // Buttons to add/edit/delete matches
        Button addMatchButton = new Button("Add Match");
        Button editMatchButton = new Button("Edit Match");
        Button deleteMatchButton = new Button("Delete Match");

        // Handle Add, Edit, and Delete Match actions (placeholders)
        addMatchButton.setOnAction(e -> System.out.println("Add Match button clicked"));
        editMatchButton.setOnAction(e -> System.out.println("Edit Match button clicked"));
        deleteMatchButton.setOnAction(e -> System.out.println("Delete Match button clicked"));

        HBox matchButtons = new HBox(10, addMatchButton, editMatchButton, deleteMatchButton);
        matchButtons.setAlignment(Pos.CENTER);

        VBox matchesLayout = new VBox(10, matchesTable, matchButtons);
        matchesLayout.setPadding(new Insets(10));
        matchesLayout.setAlignment(Pos.CENTER);

        matchesTab.setContent(matchesLayout);

        // BarChart for revenue reports (placeholder chart)
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Match");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue");

        BarChart<String, Number> revenueChart = new BarChart<>(xAxis, yAxis);
        revenueChart.setTitle("Ticket Sales and Revenue");

        VBox reportsLayout = new VBox(10, revenueChart);
        reportsLayout.setPadding(new Insets(10));
        reportsLayout.setAlignment(Pos.CENTER);

        reportsTab.setContent(reportsLayout);

        // Adding tabs to the tabPane
        tabPane.getTabs().addAll(matchesTab, reportsTab);

        // Main layout for event ID and type input
        VBox eventLayout = new VBox(10, eventIDLabel, eventIDField, eventTypeLabel, eventTypeField, searchButton);
        eventLayout.setPadding(new Insets(20));
        eventLayout.setAlignment(Pos.CENTER);

        // Main layout for the entire dashboard
        VBox mainLayout = new VBox(20, dashboardLabel, eventLayout, tabPane);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.TOP_CENTER);

        // Set background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#2c3e50"), CornerRadii.EMPTY, Insets.EMPTY);
        mainLayout.setBackground(new Background(backgroundFill));

        // Scene setup
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Populate a simulated event database
    private void populateEventDatabase() {
        eventDatabase.put("E001", "Cricket");
        eventDatabase.put("E002", "Football");
        eventDatabase.put("E003", "Volleyball");
        eventDatabase.put("E004", "Rugby");
        eventDatabase.put("E005", "Golf");
        eventDatabase.put("E006", "Badminton");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
