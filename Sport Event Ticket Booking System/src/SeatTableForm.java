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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SeatTableForm extends Application {

    // Create an ObservableList to hold seat data (S_ID, Venue, SeatCount)
    ObservableList<Seat> seatData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Enter Seat Details");

        // Create GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);

        // Components for Seat Table Form with labels and inputs
        Label titleLabel = new Label("Seat Table Details");
        titleLabel.setFont(new Font("Arial", 30));
        titleLabel.setTextFill(Color.WHITE);

        Label sIDLabel = new Label("S_ID:");
        sIDLabel.setTextFill(Color.WHITE);
        TextField sIDField = new TextField();
        sIDField.setPromptText("S_ID");
        sIDField.setDisable(true);  // Make S_ID text box inactive

        Label venueLabel = new Label("Venue:");
        venueLabel.setTextFill(Color.WHITE);
        TextField venueField = new TextField();
        venueField.setPromptText("Enter Venue");

        Label seatCountLabel = new Label("Seat Count:");
        seatCountLabel.setTextFill(Color.WHITE);
        TextField seatCountField = new TextField();
        seatCountField.setPromptText("Enter Seat Count");

        // Buttons
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        Button clearButton = new Button("Clear");
        clearButton.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold;");
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");

        // Drop shadow effect for buttons
        DropShadow shadow = new DropShadow();
        submitButton.setEffect(shadow);
        clearButton.setEffect(shadow);
        cancelButton.setEffect(shadow);

        // Table view to display Seat Table data
        TableView<Seat> tableView = new TableView<>();
        tableView.setItems(seatData);

        // Columns for the TableView
        TableColumn<Seat, String> sIDColumn = new TableColumn<>("S_ID");
        sIDColumn.setCellValueFactory(cellData -> cellData.getValue().sIDProperty());
        sIDColumn.setMinWidth(100);

        TableColumn<Seat, String> venueColumn = new TableColumn<>("Venue");
        venueColumn.setCellValueFactory(cellData -> cellData.getValue().venueProperty());
        venueColumn.setMinWidth(150);

        TableColumn<Seat, String> seatCountColumn = new TableColumn<>("Seat Count");
        seatCountColumn.setCellValueFactory(cellData -> cellData.getValue().seatCountProperty());
        seatCountColumn.setMinWidth(150);

        tableView.getColumns().addAll(sIDColumn, venueColumn, seatCountColumn);

        // Add components to the grid pane
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(sIDLabel, 0, 1);
        gridPane.add(sIDField, 1, 1);
        gridPane.add(venueLabel, 0, 2);
        gridPane.add(venueField, 1, 2);
        gridPane.add(seatCountLabel, 0, 3);
        gridPane.add(seatCountField, 1, 3);
        gridPane.add(submitButton, 0, 4);
        gridPane.add(clearButton, 1, 4);
        gridPane.add(cancelButton, 2, 4);

        // Add TableView to the grid pane
        gridPane.add(tableView, 0, 5, 3, 1);

        // Actions for buttons
        submitButton.setOnAction(e -> {
            // Logic to handle form submission
            String venue = venueField.getText();
            String seatCount = seatCountField.getText();

            // Create a new Seat entry and add to the seatData ObservableList
            Seat newSeat = new Seat("S" + (seatData.size() + 1), venue, seatCount);
            seatData.add(newSeat);

            // Clear input fields after submission
            venueField.clear();
            seatCountField.clear();
        });

        clearButton.setOnAction(e -> {
            // Clear all fields
            sIDField.clear();
            venueField.clear();
            seatCountField.clear();
        });

        cancelButton.setOnAction(e -> {
            // Close the window
            primaryStage.close();
        });

        // Set the scene and show the stage
        Scene scene = new Scene(gridPane, 800, 600);

        // Set background color for the gridPane
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        gridPane.setBackground(new Background(backgroundFill));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Seat class to represent data for the TableView
    public static class Seat {
        private final StringProperty sID;
        private final StringProperty venue;
        private final StringProperty seatCount;

        public Seat(String sID, String venue, String seatCount) {
            this.sID = new SimpleStringProperty(sID);
            this.venue = new SimpleStringProperty(venue);
            this.seatCount = new SimpleStringProperty(seatCount);
        }

        public String getS_ID() {
            return sID.get();
        }

        public StringProperty sIDProperty() {
            return sID;
        }

        public String getVenue() {
            return venue.get();
        }

        public StringProperty venueProperty() {
            return venue;
        }

        public String getSeatCount() {
            return seatCount.get();
        }

        public StringProperty seatCountProperty() {
            return seatCount;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
