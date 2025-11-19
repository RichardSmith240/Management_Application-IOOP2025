import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.Vbox;
import java.util.ArrayList;

public class gui extends Application {

    @Override
      public void start(Stage stage) {
        //test data for usernames and passwords
        primaryStage.setTitle("Login GUI");
        //test data for usernames and passwords
        usernames.add("user1");
        passwords.add("abcd1234");
        stage.setTitle("Login System");
        stage.setScene(createLoginScene(stage));
        stage.show();
    }
    
    //Sign in page
    private Scene createSigninScene(Stage stage){
        Label title = new Label("Sign In"));
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        Label messageLabel = new Label();

        // create buttons
        Button signInBtn = new Button("Sign In");
        Button signUpBtn = new Button("Sign Up");
        signInBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String username = userField.getText();
                String password = passField.getText();
                if(signin(username,password)){
                    stage.setScene(successScene());
                } else {
                    messageLabel.setText("Invalid username or password. Please try again.");
                }
            }
        });
        goToSignUpBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                stage.setScene(createSignupScene(stage));
            }
        });
        VBox layout = new Vbox (10);
        layout.getChildren().addAll(title, userLabel, userField, passLabel, passField, signInBtn, signUpBtn, messageLabel);
        layout.setPadding(new Insets(20));      
        return new Scene(layout, 300, 350);
    }

    //Sign up page
    private Scene createSignupScene(Stage stage){
        Label title=new Label("Sign Up");
        Label userLabel= new Label("Create Username:");
        TextField userField=new TextField();
        Label passLabel=new Label("Create Password:");
        PasswordField passField=new PasswordField();
        Label messageLabel=new Label();
        Button createBtn=new Button("Create Account");
        Button backBtn=new Button("Back to Sign In");

        createBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String username=userField.getText();
                String password=passField.getText();
                if(signup(username,password)){
                    stage.setScene(successScene());
                } else {
                    messageLabel.setText("Username already exists. Please choose another.");
                }
            }
        });

        VBox layout = new Vbox (10);
        layout.getChildren().addAll(title, userLabel, userField, passLabel, passField, createBtn, backBtn, messageLabel);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        return new Scene(layout, 300, 350);
    }


    //success page
private Scene successScene(){
    Label successLabel = new Label("Your Login was Successful.");
    Vbox layout = new VBox(10);
    layout.getChildren().add(successLabel);
    layout.setPadding(new Insets(20));
    layout.setAlignment(Pos.CENTER);
    return new Scene(layout, 300, 200);


}

}