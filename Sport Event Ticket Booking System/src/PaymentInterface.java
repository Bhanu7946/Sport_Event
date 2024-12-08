import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PaymentInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Payment");

        // Labels for booking details
        Label bookingDetailsLabel = new Label("Booking Details");
        bookingDetailsLabel.setFont(new Font("Arial", 30));
        bookingDetailsLabel.setTextFill(Color.WHITE);

        Label matchDetails = new Label("Match: India vs Australia\nSeats: A1, A2\nTotal Price: $120");
        matchDetails.setFont(new Font("Arial", 16));
        matchDetails.setTextFill(Color.WHITE);

        // ComboBox for payment methods
        Label paymentMethodLabel = new Label("Payment Method:");
        paymentMethodLabel.setTextFill(Color.WHITE);
        ComboBox<String> paymentMethodCombo = new ComboBox<>();
        paymentMethodCombo.getItems().addAll("Cash", "QR");
        paymentMethodCombo.setValue("Cash");

        // QR Code display space (initially empty)
        ImageView qrCodeImageView = new ImageView();
        qrCodeImageView.setFitWidth(150);  // Fixed width for QR code
        qrCodeImageView.setFitHeight(150); // Fixed height for QR code
        qrCodeImageView.setVisible(false);  // Initially hidden

        // Buttons
        Button payButton = new Button("Pay Now");
        payButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");

        // Adding Drop Shadow Effect
        DropShadow shadow = new DropShadow();
        payButton.setEffect(shadow);
        cancelButton.setEffect(shadow);

        // Layout setup
        VBox paymentForm = new VBox(10);
        paymentForm.getChildren().addAll(bookingDetailsLabel, matchDetails, paymentMethodLabel, paymentMethodCombo, 
            payButton, cancelButton, qrCodeImageView);
        paymentForm.setAlignment(Pos.CENTER);
        paymentForm.setPadding(new Insets(20));

        // Set background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        paymentForm.setBackground(new Background(backgroundFill));

        // Event handling for payment method selection
        paymentMethodCombo.setOnAction(e -> {
            if (paymentMethodCombo.getValue().equals("QR")) {
                // Display sample QR code when QR is selected
                qrCodeImageView.setVisible(true);
                qrCodeImageView.setImage(new Image("file:square_qr_code.png")); // Replace with actual QR image
            } else {
                // Hide QR code when Cash is selected
                qrCodeImageView.setVisible(false);
            }
        });

        // Scene setup
        Scene scene = new Scene(paymentForm, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
