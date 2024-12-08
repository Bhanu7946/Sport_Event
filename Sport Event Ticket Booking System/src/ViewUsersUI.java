import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewUsersUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("View Registered Users");

        // Label for heading
        Label headingLabel = new Label("Registered Users");
        headingLabel.setFont(new Font("Arial", 30));
        headingLabel.setTextFill(Color.WHITE);

        // TableView for displaying user details
        TableView<User> userTable = new TableView<>();
        userTable.setPrefSize(600, 300);

        // Table columns
        TableColumn<User, String> nicColumn = new TableColumn<>("NIC");
        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        TableColumn<User, String> mobileColumn = new TableColumn<>("Mobile");
        TableColumn<User, String> eventColumn = new TableColumn<>("Event");

        // Add columns to the table
        userTable.getColumns().addAll(nicColumn, nameColumn, mobileColumn, eventColumn);

        // ComboBox for filtering users by event
        ComboBox<String> eventFilterComboBox = new ComboBox<>();
        eventFilterComboBox.setPromptText("Filter by Event");

        ObservableList<String> eventOptions = FXCollections.observableArrayList(
                "Cricket", "Football", "Volleyball", "Rugby", "Golf", "Badminton");
        eventFilterComboBox.setItems(eventOptions);

        // Search Bar for searching by NIC
        TextField searchField = new TextField();
        searchField.setPromptText("Search by NIC");

        // Layout for filtering and search
        HBox filterBox = new HBox(10);
        filterBox.getChildren().addAll(eventFilterComboBox, searchField);
        filterBox.setAlignment(Pos.CENTER);

        // Main layout
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(headingLabel, userTable, filterBox);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(40));

        // Background color and styling
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

    // Class to represent a User (for TableView)
    public static class User {
        private final String nic;
        private final String name;
        private final String mobile;
        private final String event;

        public User(String nic, String name, String mobile, String event) {
            this.nic = nic;
            this.name = name;
            this.mobile = mobile;
            this.event = event;
        }

        public String getNic() {
            return nic;
        }

        public String getName() {
            return name;
        }

        public String getMobile() {
            return mobile;
        }

        public String getEvent() {
            return event;
        }
    }
}
