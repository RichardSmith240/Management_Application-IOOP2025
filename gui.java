import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class gui extends Application {

    private Authentication auth;
    private TextField usernameField;
    private PasswordField passwordField;
    private Label messageLabel;
    private StackPane root;
    private VBox loginPane;
    private VBox welcomePane;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login GUI - *xXx* System");

        ArrayList<String> usernames = new ArrayList<String>();
        ArrayList<String> passwords = new ArrayList<String>();
        usernames.add("user1");
        passwords.add("abcd1234");

        auth = new Authentication(usernames, passwords);

        root = new StackPane();
        createLoginPane();
        createWelcomePane();

        root.getChildren().add(loginPane);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createLoginPane() {
        loginPane = new VBox(15);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setPadding(new Insets(40));

        Label titleLabel = new Label("Welcome to *xXx* System");
        titleLabel.setFont(new Font(20));

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setPrefWidth(240);

        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefWidth(240);

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin();
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setPrefWidth(100);
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignUp();
            }
        });

        buttonRow.getChildren().addAll(loginButton, signUpButton);

        messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        loginPane.getChildren().addAll(
                titleLabel,
                usernameLabel,
                usernameField,
                passwordLabel,
                passwordField,
                buttonRow,
                messageLabel
        );
    }

    private void createWelcomePane() {
        welcomePane = new VBox(20);
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.setPadding(new Insets(40));

        Label welcomeTitle = new Label("Welcome to *xXx* System!");
        welcomeTitle.setFont(new Font(24));
        welcomeTitle.setTextFill(Color.GREEN);

        Label welcomeUser = new Label();
        welcomeUser.setId("welcomeUserLabel");
        welcomeUser.setFont(new Font(18));

        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(100);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usernameField.clear();
                passwordField.clear();
                messageLabel.setText("");
                messageLabel.setTextFill(Color.RED);
                root.getChildren().setAll(loginPane);
            }
        });

        welcomePane.getChildren().addAll(welcomeTitle, welcomeUser, logoutButton);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Please enter both username and password.");
            return;
        }

        Authentication.SignInStatus status = auth.signIn(username, password);
        switch (status) {
            case SUCCESS:
                messageLabel.setText("");
                Label welcomeUserLabel = (Label) welcomePane.lookup("#welcomeUserLabel");
                if (welcomeUserLabel != null) {
                    welcomeUserLabel.setText("Welcome, " + username + "!");
                }
                root.getChildren().setAll(welcomePane);
                break;
            case INVALID_PASSWORD:
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("Password is incorrect. Please try again.");
                break;
            case USER_NOT_FOUND:
            default:
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("Username not found. Please sign up first.");
                break;
        }
    }

    private void handleSignUp() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Please enter both username and password.");
            return;
        }

        boolean created = auth.signUp(username, password);
        if (created) {
            messageLabel.setTextFill(Color.GREEN);
            messageLabel.setText("Account created! You can log in now.");
            passwordField.clear();
        } else {
            messageLabel.setTextFill(Color.RED);
            messageLabel.setText("Username already exists. Please choose another.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
