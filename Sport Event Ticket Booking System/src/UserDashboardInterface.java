import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDashboardInterface extends Application {

    private Label dateTimeLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Dashboard");

        // Labels for user welcome message
        Label dashboardLabel = new Label("User Dashboard");
        dashboardLabel.setFont(new Font("Arial", 30));
        dashboardLabel.setTextFill(Color.WHITE);

        // Top layout for date-time picker and logout drop-down
        HBox topLayout = new HBox();
        topLayout.setAlignment(Pos.CENTER);
        topLayout.setSpacing(20);
        topLayout.setPadding(new Insets(10));

        // Date-time picker (real-time update)
        dateTimeLabel = new Label();
        dateTimeLabel.setFont(new Font("Arial", 16));
        dateTimeLabel.setTextFill(Color.WHITE);
        updateDateTime();
        // Timer to update every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateDateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Logout dropdown
        MenuButton logoutMenuButton = new MenuButton("Account");
        logoutMenuButton.setFont(new Font("Arial", 14));

        MenuItem detailsMenuItem = new MenuItem("Details");
        MenuItem settingsMenuItem = new MenuItem("Settings");
        MenuItem logoutMenuItem = new MenuItem("Log Out");

        logoutMenuButton.getItems().addAll(detailsMenuItem, settingsMenuItem, logoutMenuItem);

        // Adding date-time picker and logout to top layout
        topLayout.getChildren().addAll(dateTimeLabel, logoutMenuButton);
        HBox.setHgrow(logoutMenuButton, Priority.ALWAYS);
        topLayout.setAlignment(Pos.TOP_RIGHT);

        // Buttons for user actions
        Button bookSeatButton = new Button("Book a Seat");
        Button viewBookingButton = new Button("View Booking");
        Button myQRButton = new Button("My QR");

        bookSeatButton.setFont(new Font("Arial", 16));
        viewBookingButton.setFont(new Font("Arial", 16));
        myQRButton.setFont(new Font("Arial", 16));

        // Actions for buttons (for now, just print to console)
        bookSeatButton.setOnAction(e -> System.out.println("Book a Seat button clicked"));
        viewBookingButton.setOnAction(e -> System.out.println("View Booking button clicked"));
        myQRButton.setOnAction(e -> System.out.println("My QR button clicked"));

        // Layout for buttons
        VBox userOptionsLayout = new VBox(20, bookSeatButton, viewBookingButton, myQRButton);
        userOptionsLayout.setAlignment(Pos.CENTER);
        userOptionsLayout.setPadding(new Insets(20));

        // Main layout
        VBox mainLayout = new VBox(10, topLayout, dashboardLabel, userOptionsLayout);
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

    // Method to update date-time in real-time
    private void updateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTimeLabel.setText(LocalDateTime.now().format(formatter));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
