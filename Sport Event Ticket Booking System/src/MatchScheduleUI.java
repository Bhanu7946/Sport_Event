import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MatchScheduleUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cricket Match Ticket Booking - Match Schedule");

        // Label for heading
        Label headingLabel = new Label("Upcoming Matches");
        headingLabel.setFont(new Font("Arial", 30));
        headingLabel.setTextFill(Color.WHITE);

        // TableView for displaying match details
        TableView<Match> matchTable = new TableView<>();
        matchTable.setPrefSize(600, 300);

        // Table columns
        TableColumn<Match, String> idColumn = new TableColumn<>("Match ID");
        TableColumn<Match, String> teamsColumn = new TableColumn<>("Teams");
        TableColumn<Match, String> dateColumn = new TableColumn<>("Date");
        TableColumn<Match, String> timeColumn = new TableColumn<>("Time");
        TableColumn<Match, String> venueColumn = new TableColumn<>("Venue");

        // Add columns to the table
        matchTable.getColumns().addAll(idColumn, teamsColumn, dateColumn, timeColumn, venueColumn);

        // ComboBox for filtering matches
        ComboBox<String> filterComboBox = new ComboBox<>();
        filterComboBox.setPromptText("Filter by...");

        ObservableList<String> filterOptions = FXCollections.observableArrayList(
                "Date", "Teams", "Venue");
        filterComboBox.setItems(filterOptions);

        // Search Bar (optional)
        TextField searchField = new TextField();
        searchField.setPromptText("Search matches by team or date");

        // Button to select match
        Button selectMatchButton = new Button("Select Match");
        selectMatchButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        selectMatchButton.setPrefWidth(150);

        // Add shadow effect to button
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        shadow.setColor(Color.GRAY);

        selectMatchButton.setEffect(shadow);

        // Layout for filtering and search
        HBox filterBox = new HBox(10);
        filterBox.getChildren().addAll(filterComboBox, searchField);
        filterBox.setAlignment(Pos.CENTER);

        // Main layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(headingLabel, matchTable, filterBox, selectMatchButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(40));

        // Background color and styling (similar to first interface)
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);

        // Scene and stage setup
        Scene scene = new Scene(mainLayout, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Class to represent a Match (for TableView)
    public static class Match {
        private final String matchId;
        private final String teams;
        private final String date;
        private final String time;
        private final String venue;

        public Match(String matchId, String teams, String date, String time, String venue) {
            this.matchId = matchId;
            this.teams = teams;
            this.date = date;
            this.time = time;
            this.venue = venue;
        }

        public String getMatchId() {
            return matchId;
        }

        public String getTeams() {
            return teams;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public String getVenue() {
            return venue;
        }
    }
}
