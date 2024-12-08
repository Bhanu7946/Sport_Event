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

public class LoginRegistrationUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cricket Match Ticket Booking");

        // Create the Search Bar at the top
        Label searchLabel = new Label("Search User by NIC:");
        searchLabel.setFont(new Font("Arial", 16));
        searchLabel.setTextFill(Color.WHITE);

        TextField searchField = new TextField();
        searchField.setPromptText("Enter NIC");

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold;");
        searchButton.setPrefWidth(100);

        // HBox for search bar layout
        HBox searchBox = new HBox(10, searchLabel, searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.setPadding(new Insets(20));
        
        // Create the Login Form components
        Label loginLabel = new Label("Login");
        loginLabel.setFont(new Font("Arial", 30));
        loginLabel.setTextFill(Color.WHITE);

        Label emailLabel = new Label("NIC:");
        emailLabel.setTextFill(Color.WHITE);
        TextField emailField = new TextField();
        emailField.setPromptText("Enter the NIC");

        Label passwordLabel = new Label("Mobile:");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter the Mobile No");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        loginButton.setPrefWidth(150);

        // Create the Registration Form components
        Label registerLabel = new Label("New User? Register Now");
        registerLabel.setFont(new Font("Arial", 30));
        registerLabel.setTextFill(Color.WHITE);

        Label nameLabel = new Label("Name:");
        nameLabel.setTextFill(Color.WHITE);
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Label newEmailLabel = new Label("NIC:");
        newEmailLabel.setTextFill(Color.WHITE);
        TextField newEmailField = new TextField();
        newEmailField.setPromptText("Enter your NIC");

        Label newPasswordLabel = new Label("Mobile:");
        newPasswordLabel.setTextFill(Color.WHITE);
        PasswordField newPasswordField = new PasswordField();
        newPasswordField.setPromptText("Enter Mobile No");

        Button registerButton = new Button("Register");
        registerButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        registerButton.setPrefWidth(150);

        // Adding Drop Shadow Effect for buttons
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        shadow.setColor(Color.GRAY);

        loginButton.setEffect(shadow);
        registerButton.setEffect(shadow);

        // Layout for Login Form
        VBox loginBox = new VBox(10);
        loginBox.getChildren().addAll(loginLabel, emailLabel, emailField, passwordLabel, passwordField, loginButton);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));

        // Layout for Registration Form
        VBox registrationBox = new VBox(10);
        registrationBox.getChildren().addAll(registerLabel, nameLabel, nameField, newEmailLabel, newEmailField, newPasswordLabel, newPasswordField, registerButton);
        registrationBox.setAlignment(Pos.CENTER);
        registrationBox.setPadding(new Insets(20));

        // HBox to hold both forms
        HBox mainFormBox = new HBox(50);
        mainFormBox.getChildren().addAll(loginBox, registrationBox);
        mainFormBox.setAlignment(Pos.CENTER);
        mainFormBox.setPadding(new Insets(40));

        // Button panel for Edit, Update, Remove at the bottom
        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #f1c40f; -fx-text-fill: white; -fx-font-weight: bold;");
        editButton.setPrefWidth(100);

        Button updateButton = new Button("Update");
        updateButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        updateButton.setPrefWidth(100);

        Button removeButton = new Button("Remove");
        removeButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        removeButton.setPrefWidth(100);

        HBox buttonPanel = new HBox(20, editButton, updateButton, removeButton);
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setPadding(new Insets(20));

        // Main vertical layout to hold the search bar, forms, and button panel
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(searchBox, mainFormBox, buttonPanel);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(40));

        // Adding Background color and styling
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#34495e"), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);

        // Set the action for the Search button
        searchButton.setOnAction(e -> {
            String searchNIC = searchField.getText();
            // Implement the search logic here to check if user is already registered by NIC
            System.out.println("Searching user with NIC: " + searchNIC);
        });

        // Set actions for Edit, Update, and Remove buttons
        editButton.setOnAction(e -> {
            System.out.println("Edit button clicked");
            // Implement the logic for editing the user's information
        });

        updateButton.setOnAction(e -> {
            System.out.println("Update button clicked");
            // Implement the logic for updating the user's information
        });

        removeButton.setOnAction(e -> {
            System.out.println("Remove button clicked");
            // Implement the logic for removing the user
        });

        // Creating Scene and setting the stage
        Scene scene = new Scene(mainLayout, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
