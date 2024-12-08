import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicketManagementDashboard extends Application {

    private VBox availabilityBox; // Dynamic VBox for showing availability fields

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ticket Management Dashboard");

        // Main layout (Horizontal Split - Left 20% and Right 80%)
        HBox mainLayout = new HBox();
        mainLayout.setPadding(new Insets(20));
        mainLayout.setSpacing(20);

        // Left Side (20%): Venue Input Section
        VBox leftPane = new VBox(10);
        leftPane.setPrefWidth(200); // 20% of 1000px window width
        Label venueLabel = new Label("Event ID:");
        venueLabel.setFont(new Font("Arial", 16));
        TextField venueField = new TextField();
        venueField.setPromptText("Enter Event ID");

        // Add Match ID section
        Label matchIdLabel = new Label("Match ID:");
        matchIdLabel.setFont(new Font("Arial", 16));
        TextField matchIdField = new TextField();
        matchIdField.setPromptText("Match ID");

        // Add Date section
        Label dateLabel = new Label("Date:");
        dateLabel.setFont(new Font("Arial", 16));
        TextField dateField = new TextField();
        dateField.setPromptText("Date");

        // Add Team 1 vs Team 2 section
        HBox teamBox = new HBox(10);
        TextField team1Field = new TextField();
        team1Field.setPromptText("Team 1");
        TextField team2Field = new TextField();
        team2Field.setPromptText("Team 2");
        Label vsLabel = new Label("vs");
        teamBox.getChildren().addAll(team1Field, vsLabel, team2Field);
        teamBox.setAlignment(Pos.CENTER_LEFT);

        leftPane.getChildren().addAll(venueLabel, venueField, matchIdLabel, matchIdField, dateLabel, dateField, teamBox);
        leftPane.setAlignment(Pos.TOP_LEFT);

        // Right Side (80%): Ticket Management Section
        VBox rightPane = new VBox(10);
        rightPane.setPrefWidth(800); // 80% of 1000px window width
        rightPane.setPadding(new Insets(10));

        Label totalTicketsLabel = new Label("Total Tickets:");
        totalTicketsLabel.setFont(new Font("Arial", 16));
        TextField totalTicketsField = new TextField();
        totalTicketsField.setPromptText("Enter total tickets");

        // Ticket categories with their count and price fields (without checkboxes)
        Label availableCategoriesLabel = new Label("Ticket Categories and Pricing:");
        availableCategoriesLabel.setFont(new Font("Arial", 16));

        availabilityBox = new VBox(10); // Holds the availability fields dynamically

        // Add ticket categories (VIP, Balcony, General, Student Pass) directly
        addCategoryField("VIP");
        addCategoryField("Balcony");
        addCategoryField("General");
        addCategoryField("Student Pass");

        // Save and Reset buttons
        Button saveButton = new Button("Save");
        Button resetButton = new Button("Reset");

        HBox saveResetBox = new HBox(10, saveButton, resetButton);
        saveResetBox.setAlignment(Pos.CENTER);

        // Add elements to the rightPane
        rightPane.getChildren().addAll(totalTicketsLabel, totalTicketsField, availableCategoriesLabel,
                availabilityBox, saveResetBox);

        // Add the left and right panes to the main layout
        mainLayout.getChildren().addAll(leftPane, rightPane);

        // Scene setup
        Scene scene = new Scene(mainLayout, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to add category fields with ticket count and price
    private void addCategoryField(String categoryName) {
        Label categoryLabel = new Label(categoryName + ":");
        TextField countField = new TextField();
        countField.setPromptText("Enter count");
        TextField priceField = new TextField();
        priceField.setPromptText("Enter price");

        HBox categoryAvailabilityBox = new HBox(10, categoryLabel, countField, new Label("Price:"), priceField);
        categoryAvailabilityBox.setAlignment(Pos.CENTER_LEFT);

        availabilityBox.getChildren().add(categoryAvailabilityBox);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
