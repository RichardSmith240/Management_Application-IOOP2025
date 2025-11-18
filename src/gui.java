import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.util.ArrayList;
/* *
* /these are some other imports we could use after we have the base gui
import javafx.geometry.Pos;         
import javafx.scene.text.Font;      
import javafx.scene.paint.Color;
 */
public class gui extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login GUI");
        //test data for usernames and passwords
        ArrayList<String> usernames = new ArrayList<String>();
        ArrayList<String> passwords = new ArrayList<String>();
        usernames.add("user1");
        passwords.add("abcd1234");

        auth = new Authentication(usernames, passwords);

        //Username and label text fields
        Label userLabel = new Label("Username:");
        TextField userTextField = new TextField();
        
        //Password
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        //button
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up");

        Label messageLabel = new Label();
        // completeted the layout and the button actions for now ~ Vaidehi

        


