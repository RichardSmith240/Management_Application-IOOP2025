import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class gui extends Application {

    private Authentication auth = new Authentication();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Login System - *xXx* System");
        stage.setScene(createLoginScene(stage));
        stage.show();
    }


    private Scene createLoginScene(Stage stage) {
        Label title = new Label("Welcome to *xXx* System");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Label message = new Label();
        Button loginBtn = new Button("Sign In");
        loginBtn.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String result = auth.login(username, password);
            switch (result) {
                case "EMPTY":
                    message.setText("Please enter both username and password.");
                    break;
                case "USER_NOT_FOUND":
                    message.setText("Username not found. Please sign up first.");
                    break;
                case "WRONG_PASSWORD":
                    message.setText("Password is incorrect. Please try again.");
                    break;
                case "SUCCESS":
                    message.setText("");
                    stage.setScene(createWelcomeScene(username.trim(), stage));
                    break;
            }
        });
        Button signupBtn = new Button("Sign Up");
        signupBtn.setOnAction(e -> stage.setScene(createSignupScene(stage)));

        VBox layout = new VBox(10, title, usernameField, passwordField, loginBtn, signupBtn, message);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 400, 400);
    }

    //sign up
    private Scene createSignupScene(Stage stage) {
        Label title = new Label("Sign Up");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Create username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Create password");
        Label message = new Label();
    // Sign Up 
    // Here is the sign up scene creation method
     private Scene createSignupScene(Stage stage) { 
        Label title = new Label("Sign Up"); 
        TextField usernameField = new TextField(); // Username input field
        usernameField.setPromptText("Create username"); // Placeholder text
        PasswordField passwordField = new PasswordField(); // Password input field
        passwordField.setPromptText("Create password"); // Placeholder text
        Label message = new Label(); 

        Button createBtn = new Button("Create Account");
        createBtn.setOnAction(e -> { // Handle account creation
            String username = usernameField.getText();
            String password = passwordField.getText();
            String result = auth.signUp(username, password);
            switch (result) { // Display appropriate messages based on the result
                // the cases for all possible outcomes
                case "EMPTY":
                    message.setTextFill(Color.RED); // Set text color to red for errors
                    message.setText("Username and password cannot be empty.");
                    break;
                case "USERNAME_TAKEN":
                    message.setTextFill(Color.RED); // Same thing as above
                    message.setText("Username already exists. Please choose another.");
                    break;
                case "SUCCESS":
                    message.setTextFill(Color.GREEN); //Green for success
                    message.setText("Account created successfully! Please sign in.");
                    usernameField.clear();
                    passwordField.clear();
                    break; 
            }
        });
        // Back to login button
        Button backBtn = new Button("Back to Sign In");
        backBtn.setOnAction(e -> stage.setScene(createLoginScene(stage)));
        // Layout setup 
        VBox layout = new VBox(10, title, usernameField, passwordField, createBtn, backBtn, message); // Vertical layout with spacing
        layout.setPadding(new Insets(20)); // Padding around the layout
        layout.setAlignment(Pos.CENTER);    // Center alignment
        return new Scene(layout, 400, 400); // Return the scene with specified dimensions
    }


    private Scene createWelcomeScene(String username, Stage stage) {
        Label welcomeTitle = new Label("Welcome to *xXx* System!");
        Label welcomeUser = new Label("Welcome, " + username + "!");
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> stage.setScene(createLoginScene(stage)));

        VBox layout = new VBox(15, welcomeTitle, welcomeUser, logoutBtn);// same thing as before
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 400, 400);
    }

    public static void main(String[] args) { // Main method to launch the application
        launch(); //this is so the javafx application can actually run
    }
}
