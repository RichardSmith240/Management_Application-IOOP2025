import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class gui extends Application {

    // Use the Authentication class for all login / sign-up logic
    private Authentication auth = new Authentication();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Login System - *xXx* System");
        stage.setScene(createLoginScene(stage));
        stage.show();
    }

    private Scene createLoginScene(Stage stage) {
        Label title = new Label("Welcome to *xXx* System");
        title.setFont(new Font(20));

        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        userField.setPromptText("Enter username");

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter password");

        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        Button loginBtn = new Button("Sign In");
        loginBtn.setPrefWidth(120);
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userField.getText();
                String password = passField.getText();

                String result = auth.login(username, password);

                switch (result) {
                    case "EMPTY":
                        messageLabel.setTextFill(Color.RED);
                        messageLabel.setText("Please enter both username and password.");
                        break;
                    case "USER_NOT_FOUND":
                        messageLabel.setTextFill(Color.RED);
                        messageLabel.setText("Username not found. Please sign up first.");
                        break;
                    case "WRONG_PASSWORD":
                        messageLabel.setTextFill(Color.RED);
                        messageLabel.setText("Password is incorrect. Please try again.");
                        break;
                    case "SUCCESS":
                        messageLabel.setText("");
                        stage.setScene(createWelcomeScene(username.trim(), stage));
                        break;
                }
            }
        });

        Button signUpBtn = new Button("Sign Up");
        signUpBtn.setPrefWidth(120);
        signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(createSignupScene(stage));
            }
        });

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(loginBtn, signUpBtn);

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(
                title,
                userLabel, userField,
                passLabel, passField,
                buttonBox,
                messageLabel
        );

        return new Scene(layout, 400, 400);
    }

    private Scene createSignupScene(Stage stage) {
        Label title = new Label("Sign Up");
        title.setFont(new Font(20));

        Label userLabel = new Label("Create Username:");
        TextField userField = new TextField();
        userField.setPromptText("Enter username");

        Label passLabel = new Label("Create Password:");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter password");

        Label messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        Button createBtn = new Button("Create Account");
        createBtn.setPrefWidth(150);
        createBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
<<<<<<< HEAD
            public void handle(ActionEvent event){
                String username=userField.getText();
                String password=passField.getText();
                if(signup(username,password)){
                    stage.setScene(successScene());
                } else {
                    messageLabel.setText("Username already exists. Please choose another one.");
=======
            public void handle(ActionEvent event) {
                String username = userField.getText();
                String password = passField.getText();

                String result = auth.signUp(username, password);

                switch (result) {
                    case "EMPTY":
                        messageLabel.setTextFill(Color.RED);
                        messageLabel.setText("Username and password cannot be empty.");
                        break;
                    case "USERNAME_TAKEN":
                        messageLabel.setTextFill(Color.RED);
                        messageLabel.setText("Username already exists. Please choose another.");
                        break;
                    case "SUCCESS":
                        messageLabel.setTextFill(Color.GREEN);
                        messageLabel.setText("Account created successfully! Please sign in.");
                        userField.clear();
                        passField.clear();
                        break;
>>>>>>> c64c168272039e296b93a5c5851dcad716cb07c7
                }
            }
        });

        Button backBtn = new Button("Back to Sign In");
        backBtn.setPrefWidth(150);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(createLoginScene(stage));
            }
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(
                title,
                userLabel, userField,
                passLabel, passField,
                createBtn,
                backBtn,
                messageLabel
        );

        return new Scene(layout, 400, 400);
    }

    private Scene createWelcomeScene(String username, Stage stage) {
        Label welcomeTitle = new Label("Welcome to *xXx* System!");
        welcomeTitle.setFont(new Font(24));
        welcomeTitle.setTextFill(Color.GREEN);

        Label welcomeUser = new Label("Welcome, " + username + "!");
        welcomeUser.setFont(new Font(18));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setPrefWidth(120);
        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(createLoginScene(stage));
            }
        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.getChildren().addAll(
                welcomeTitle,
                welcomeUser,
                logoutBtn
        );

        return new Scene(layout, 400, 400);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
