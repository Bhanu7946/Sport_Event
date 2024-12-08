import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BookingConfirmationInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Booking Confirmation");

        // Labels for booking confirmation details
        Label confirmationLabel = new Label("Booking Confirmed!");
        confirmationLabel.setFont(new Font("Arial", 30));
        confirmationLabel.setTextFill(Color.WHITE);

        Label detailsLabel = new Label("Booking ID: 123456\nMatch: India vs Australia\nSeats: A1, A2\nPayment Status: Paid");
        detailsLabel.setFont(new Font("Arial", 16));
        detailsLabel.setTextFill(Color.WHITE);

        // QR code display (Example ImageView)
        ImageView qrCodeView = new ImageView(new Image("file:qr_code.png")); // Add your QR image here
        qrCodeView.setFitWidth(150);
        qrCodeView.setFitHeight(150);

        // Buttons
        Button downloadButton = new Button("Download Ticket");
        downloadButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");

        Button homeButton = new Button("Return to Home");
        homeButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");

        // Optional email notification
        CheckBox emailNotification = new CheckBox("Send ticket details via email");
        emailNotification.setTextFill(Color.WHITE);

        // Layout setup
        VBox confirmationBox = new VBox(10);
        confirmationBox.getChildren().addAll(confirmationLabel, detailsLabel, qrCodeView, downloadButton, homeButton, emailNotification);
        confirmationBox.setAlignment(Pos.CENTER);
        confirmationBox.setPadding(new Insets(20));

        // Set background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        confirmationBox.setBackground(new Background(backgroundFill));

        // Scene setup
        Scene scene = new Scene(confirmationBox, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
