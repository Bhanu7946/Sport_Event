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

public class SeatSelectionUI extends Application {

    private final int rows = 5; // Number of rows in the stadium layout
    private final int cols = 10; // Number of seats per row

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cricket Match Ticket Booking - Seat Selection");

        // Match Details
        Label matchDetailsLabel = new Label("Match: Team A vs Team B\nDate: 2024-11-20\nVenue: Cricket Stadium");
        matchDetailsLabel.setFont(new Font("Arial", 20));
        matchDetailsLabel.setTextFill(Color.WHITE);

        // GridPane for Seat Layout
        GridPane seatGrid = new GridPane();
        seatGrid.setHgap(10);
        seatGrid.setVgap(10);
        seatGrid.setPadding(new Insets(20));
        seatGrid.setAlignment(Pos.CENTER);

        // Create buttons for seats
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Button seatButton = new Button();
                seatButton.setPrefSize(40, 40);
                seatButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                seatButton.setTooltip(new Tooltip("Section: A, Row: " + (row + 1) + ", Seat: " + (col + 1) + "\nPrice: $50"));

                // Example of booked seats (can be dynamic based on data)
                if ((row == 1 && col == 2) || (row == 2 && col == 5)) {
                    seatButton.setStyle("-fx-background-color: red;");
                    seatButton.setDisable(true); // Disable button for booked seats
                }

                // Add event to change seat to "Selected" (Yellow) when clicked
                seatButton.setOnAction(e -> {
                    if (seatButton.getStyle().contains("green")) {
                        seatButton.setStyle("-fx-background-color: yellow;");
                    } else if (seatButton.getStyle().contains("yellow")) {
                        seatButton.setStyle("-fx-background-color: green;");
                    }
                });

                seatGrid.add(seatButton, col, row); // Add button to grid
            }
        }

        // Confirm Selection Button
        Button confirmButton = new Button("Confirm Selection");
        confirmButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        confirmButton.setPrefWidth(150);
        confirmButton.setEffect(new DropShadow());

        // Legend explaining seat colors
        HBox legend = new HBox(20);
        legend.setAlignment(Pos.CENTER);
        Label availableLabel = new Label("Available");
        availableLabel.setTextFill(Color.GREEN);
        Label bookedLabel = new Label("Booked");
        bookedLabel.setTextFill(Color.RED);
        Label selectedLabel = new Label("Selected");
        selectedLabel.setTextFill(Color.YELLOW);

        legend.getChildren().addAll(new Label("Legend:"), availableLabel, bookedLabel, selectedLabel);
        legend.setPadding(new Insets(10));

        // Layout for the entire interface
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(matchDetailsLabel, seatGrid, legend, confirmButton);

        // Adding Background color and styling
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);
        mainLayout.setPadding(new Insets(20));

        // Set the scene and show the stage
        Scene scene = new Scene(mainLayout, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
