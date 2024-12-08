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

public class EditMatchForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Edit Cricket Match Form");

        // Create GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);

        // Components for Edit Match Form with labels and inputs
        Label titleLabel = new Label("Edit Cricket Match");
        titleLabel.setFont(new Font("Arial", 30));
        titleLabel.setTextFill(Color.WHITE);

        Label matchIdLabel = new Label("Match ID:");
        matchIdLabel.setTextFill(Color.WHITE);
        TextField matchIdField = new TextField();
        matchIdField.setEditable(false); // Match ID is non-editable

        Label team1Label = new Label("Team 1:");
        team1Label.setTextFill(Color.WHITE);
        ComboBox<String> team1ComboBox = new ComboBox<>();
        team1ComboBox.getItems().addAll("India", "Australia", "England", "Pakistan", "South Africa");
        team1ComboBox.setPromptText("Select Team 1");

        Label team2Label = new Label("Team 2:");
        team2Label.setTextFill(Color.WHITE);
        ComboBox<String> team2ComboBox = new ComboBox<>();
        team2ComboBox.getItems().addAll("India", "Australia", "England", "Pakistan", "South Africa");
        team2ComboBox.setPromptText("Select Team 2");

        Label dateLabel = new Label("Match Date:");
        dateLabel.setTextFill(Color.WHITE);
        DatePicker datePicker = new DatePicker();

        Label venueLabel = new Label("Venue:");
        venueLabel.setTextFill(Color.WHITE);
        TextField venueField = new TextField();
        venueField.setPromptText("Enter Venue");

        Label matchTypeLabel = new Label("Match Type:");
        matchTypeLabel.setTextFill(Color.WHITE);
        ComboBox<String> matchTypeComboBox = new ComboBox<>();
        matchTypeComboBox.getItems().addAll("ODI", "T20", "Test");
        matchTypeComboBox.setPromptText("Select Match Type");

        Label statusLabel = new Label("Match Status:");
        statusLabel.setTextFill(Color.WHITE);
        ToggleGroup statusGroup = new ToggleGroup();
        RadioButton ongoingRadio = new RadioButton("Ongoing");
        RadioButton postponedRadio = new RadioButton("Postponed");
        RadioButton completedRadio = new RadioButton("Completed");
        ongoingRadio.setTextFill(Color.WHITE);
        postponedRadio.setTextFill(Color.WHITE);
        completedRadio.setTextFill(Color.WHITE);
        ongoingRadio.setToggleGroup(statusGroup);
        postponedRadio.setToggleGroup(statusGroup);
        completedRadio.setToggleGroup(statusGroup);

        Label rainDelayLabel = new Label("Rain Delay:");
        rainDelayLabel.setTextFill(Color.WHITE);
        CheckBox rainDelayCheckbox = new CheckBox("Match affected by rain");
        rainDelayCheckbox.setTextFill(Color.WHITE);

        Label notesLabel = new Label("Additional Notes:");
        notesLabel.setTextFill(Color.WHITE);
        TextArea notesArea = new TextArea();
        notesArea.setPromptText("Add any comments about the match or delays...");

        // Buttons
        Button saveButton = new Button("Save Changes");
        saveButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        Button resetButton = new Button("Reset");
        resetButton.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold;");
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");

        // Drop shadow effect for buttons
        DropShadow shadow = new DropShadow();
        saveButton.setEffect(shadow);
        resetButton.setEffect(shadow);
        cancelButton.setEffect(shadow);

        // Add components to the grid pane
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(matchIdLabel, 0, 1);
        gridPane.add(matchIdField, 1, 1);
        gridPane.add(team1Label, 0, 2);
        gridPane.add(team1ComboBox, 1, 2);
        gridPane.add(team2Label, 0, 3);
        gridPane.add(team2ComboBox, 1, 3);
        gridPane.add(dateLabel, 0, 4);
        gridPane.add(datePicker, 1, 4);
        gridPane.add(venueLabel, 0, 5);
        gridPane.add(venueField, 1, 5);
        gridPane.add(matchTypeLabel, 0, 6);
        gridPane.add(matchTypeComboBox, 1, 6);

        gridPane.add(statusLabel, 0, 7);
        HBox statusBox = new HBox(10, ongoingRadio, postponedRadio, completedRadio);
        gridPane.add(statusBox, 1, 7);

        gridPane.add(rainDelayLabel, 0, 8);
        gridPane.add(rainDelayCheckbox, 1, 8);
        gridPane.add(notesLabel, 0, 9);
        gridPane.add(notesArea, 1, 9);

        gridPane.add(saveButton, 0, 10);
        gridPane.add(resetButton, 1, 10);
        gridPane.add(cancelButton, 2, 10);

        // Set action for buttons (for demo purposes, no backend logic here)
        saveButton.setOnAction(e -> {
            // Logic to handle saving the match updates
            String team1 = team1ComboBox.getValue();
            String team2 = team2ComboBox.getValue();
            String matchDate = datePicker.getValue().toString();
            String venue = venueField.getText();
            String matchType = matchTypeComboBox.getValue();
            String matchStatus = ((RadioButton) statusGroup.getSelectedToggle()).getText();
            boolean rainDelay = rainDelayCheckbox.isSelected();
            String additionalNotes = notesArea.getText();

            System.out.println("Match Updated: " + team1 + " vs " + team2 + " on " + matchDate + 
                               ". Venue: " + venue + ". Match Type: " + matchType + 
                               ". Status: " + matchStatus + ". Rain Delay: " + rainDelay + 
                               ". Notes: " + additionalNotes);
        });

        resetButton.setOnAction(e -> {
            // Clear fields and reset choices
            team1ComboBox.setValue(null);
            team2ComboBox.setValue(null);
            datePicker.setValue(null);
            venueField.clear();
            matchTypeComboBox.setValue(null);
            statusGroup.selectToggle(null);
            rainDelayCheckbox.setSelected(false);
            notesArea.clear();
        });

        cancelButton.setOnAction(e -> primaryStage.close());

        // Set the scene and show the stage
        Scene scene = new Scene(gridPane, 900, 700);

        // Set background color for the gridPane
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        gridPane.setBackground(new Background(backgroundFill));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
