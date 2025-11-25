import javafx.application.Application;

import javafx.geometry.Insets;//javafx imports
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;//javafx imports
import javafx.scene.paint.Color;//javafx imports
import javafx.stage.Stage;//gui class for login system

public class gui extends Application { //gui classhis means the gui class inherits from the JavaFX Application class.
    private Authentication auth = new Authentication(); //auth object handles all login and signup logic.

    @Override //override confirms you’re modifying a method from the superclass correctly.
    public void start(Stage stage) {//start method
        stage.setTitle("Login System - *xXx* System"); //title
        stage.setScene(createLoginScene(stage)); //Sets the initial scene to the login screen.
        stage.show(); //show stage
    }
//var2 → login title label.
//var3 → username input field.
//var4 → password input field (hides text).
//var5 → label for messages (errors like “wrong password”).
//var6 → login button

    //login scene 
    private Scene createLoginScene(Stage stage) { 
        Label title = new Label("Welcome to *xXx* System"); //Creates a label that displays text at the top of the screen.
        TextField usernameField = new TextField(); //Creates an empty text box.
        usernameField.setPromptText("Username"); //makes faded placeholder text appear inside.
        PasswordField passwordField = new PasswordField();//Special input box that hides typed characters.
        passwordField.setPromptText("Password"); //Placeholder text
        Label message = new Label();//Empty label used to show errors or messages (like wrong password)
        Button loginBtn = new Button("Sign In");//Creates the button for logging in
        loginBtn.setOnAction(e -> { //Runs whenever the button is clicked.
            String username = usernameField.getText(); //
            String password = passwordField.getText();//Reads whatever the user typed.
            String result = auth.login(username, password);//Sends the input to your Authentication class.
            switch (result) {//handle results
                case "EMPTY": //empty fields
                    message.setText("Please enter both username and password."); //empty fields message
                    break;//empty fields
                case "USER_NOT_FOUND": //user not found
                    message.setText("Username not found. Please sign up first.");//user not found message
                    break;//wrong password
                case "WRONG_PASSWORD"://wrong password
                    message.setText("Password is incorrect. Please try again.");//wrong password message
                    break;//success
                case "SUCCESS"://successful login
                    message.setText("");//success message
                    stage.setScene(createWelcomeScene(username.trim(), stage));//switch to welcome scene
                    break;//default
                    
            }
        });
        Button signupBtn = new Button("Sign Up");
        signupBtn.setOnAction(e -> stage.setScene(createSignupScene(stage))); //When clicked it takes user to the Sign Up page.

        VBox layout = new VBox(10, title, usernameField, passwordField, loginBtn, signupBtn, message);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 400, 400); //Creates a screen sized 400×400.
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
