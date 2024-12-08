import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.UUID;

public class AddSportEventUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add Sport Event");

        // Home Button at top left
        Button homeButton = new Button("Home");
        homeButton.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold;");
        homeButton.setPrefWidth(100);
        homeButton.setPadding(new Insets(10));

        // Add DropShadow effect to the home button
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        shadow.setColor(Color.GRAY);
        homeButton.setEffect(shadow);

        // Label for heading
        Label headingLabel = new Label("Create a New Event");
        headingLabel.setFont(new Font("Arial", 30));
        headingLabel.setTextFill(Color.WHITE);

        // Auto-generated Event ID
        Label eventIDLabel = new Label("Event ID: " + generateEventID());
        eventIDLabel.setFont(new Font("Arial", 20));
        eventIDLabel.setTextFill(Color.WHITE);

        // Dropdown for selecting sports events
        Label sportLabel = new Label("Select Sport:");
        sportLabel.setTextFill(Color.WHITE);
        ComboBox<String> sportComboBox = new ComboBox<>();
        sportComboBox.setPromptText("Select Sport");
        sportComboBox.getItems().addAll("Cricket", "Football", "Volleyball", "Rugby", "Golf", "Badminton");

        // Dropdown for selecting categories
        Label selectCategoryLabel = new Label("Select the Category:");
        selectCategoryLabel.setTextFill(Color.WHITE);
        selectCategoryLabel.setFont(new Font("Arial", 16));

        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("Men's", "Women's", "Under 21", "Mixed");
        categoryComboBox.setValue("Men's");  // Set default category

        // Venue input
        Label venueLabel = new Label("Venue:");
        venueLabel.setTextFill(Color.WHITE);
        TextField venueField = new TextField();
        venueField.setPromptText("Enter Venue");

        // Date Picker
        Label dateLabel = new Label("Event Date:");
        dateLabel.setTextFill(Color.WHITE);
        DatePicker datePicker = new DatePicker();

        // Time Picker (Using a TextField for simplicity)
        Label timeLabel = new Label("Event Time:");
        timeLabel.setTextFill(Color.WHITE);
        TextField timeField = new TextField();
        timeField.setPromptText("Enter Time (e.g., 14:00)");

        // Button to add the event
        Button addEventButton = new Button("Add Event");
        addEventButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        addEventButton.setPrefWidth(150);

        // Add shadow effect to the add button
        addEventButton.setEffect(shadow);

        // Layout for event creation form
        VBox formLayout = new VBox(10);
        formLayout.getChildren().addAll(
                headingLabel, eventIDLabel, sportLabel, sportComboBox, selectCategoryLabel, categoryComboBox, 
                venueLabel, venueField, dateLabel, datePicker, timeLabel, timeField, addEventButton);
        formLayout.setAlignment(Pos.CENTER);
        formLayout.setPadding(new Insets(20));

        // Top layout with Home button
        HBox topLayout = new HBox();
        topLayout.getChildren().add(homeButton);
        topLayout.setAlignment(Pos.TOP_LEFT);
        topLayout.setPadding(new Insets(10, 0, 0, 10));

        // Main layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(topLayout, formLayout);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(40));

        // Background color and styling
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);

        // Scene and stage setup
        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to generate a unique event ID
    private String generateEventID() {
        return UUID.randomUUID().toString().substring(0, 8);  // Generate a short UUID for the Event ID
    }

    public static void main(String[] args) {
        launch(args);
    }
}
