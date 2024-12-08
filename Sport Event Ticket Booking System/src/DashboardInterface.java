import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DashboardInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Admin Dashboard");

        // Labels for dashboard welcome message
        Label dashboardLabel = new Label("Admin Dashboard");
        dashboardLabel.setFont(new Font("Arial", 30));
        dashboardLabel.setTextFill(Color.WHITE);

        // Top layout for logout drop-down
        HBox topLayout = new HBox();
        topLayout.setAlignment(Pos.CENTER);
        topLayout.setSpacing(20);
        topLayout.setPadding(new Insets(10));

        // Logout dropdown menu
        MenuButton logoutMenuButton = new MenuButton("Account");
        logoutMenuButton.setFont(new Font("Arial", 14));

        MenuItem detailsMenuItem = new MenuItem("Details");
        MenuItem settingsMenuItem = new MenuItem("Settings");
        MenuItem logoutMenuItem = new MenuItem("Log Out");

        logoutMenuButton.getItems().addAll(detailsMenuItem, settingsMenuItem, logoutMenuItem);

        // Adding logout menu to the top layout
        topLayout.getChildren().add(logoutMenuButton);
        HBox.setHgrow(logoutMenuButton, Priority.ALWAYS);
        topLayout.setAlignment(Pos.TOP_RIGHT);

        // Buttons for dashboard options
        Button createEventButton = createDashboardButton("Create Event");
        Button eventManagementButton = createDashboardButton("Event Management");
        Button ticketManagementButton = createDashboardButton("Ticket Management");
        Button userManagementButton = createDashboardButton("User Management");
        Button reportingButton = createDashboardButton("Reporting");
        Button settingsButton = createDashboardButton("Settings");

        // Actions for buttons (for now, just print to console)
        createEventButton.setOnAction(e -> System.out.println("Create Event button clicked"));
        eventManagementButton.setOnAction(e -> System.out.println("Event Management button clicked"));
        ticketManagementButton.setOnAction(e -> System.out.println("Ticket Management button clicked"));
        userManagementButton.setOnAction(e -> System.out.println("User Management button clicked"));
        reportingButton.setOnAction(e -> System.out.println("Reporting button clicked"));
        settingsButton.setOnAction(e -> System.out.println("Settings button clicked"));

        // Layout for buttons in a responsive grid
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);  // Horizontal gap between buttons
        gridPane.setVgap(20);  // Vertical gap between buttons

        // Adding buttons to the grid (2 columns, 3 rows if necessary)
        gridPane.add(createEventButton, 0, 0);  // "Create Event" button at the top
        gridPane.add(eventManagementButton, 1, 0);
        gridPane.add(ticketManagementButton, 0, 1);
        gridPane.add(userManagementButton, 1, 1);
        gridPane.add(reportingButton, 0, 2);
        gridPane.add(settingsButton, 1, 2);

        // Main layout
        VBox mainLayout = new VBox(10, topLayout, dashboardLabel, gridPane);
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

    // Helper method to create styled buttons for the dashboard
    private Button createDashboardButton(String text) {
        Button button = new Button(text);
        button.setFont(new Font("Arial", 16));
        button.setMinWidth(200);  // Set a minimum width for buttons to keep them uniform
        button.setMinHeight(100); // Set a minimum height
        button.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");  // Button color and text color
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;")); // Hover effect
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;"));
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
