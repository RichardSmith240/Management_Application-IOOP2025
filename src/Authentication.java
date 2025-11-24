import java.util.ArrayList;

public class Authentication {

    private static ArrayList<String> usernames = RWtext.userNames;
    private static ArrayList<String> passwords = RWtext.PWDs;
    private static boolean initialized = false;

    /*
     * Attempts to log in with given username and password.
     * Returns:
     *  "SUCCESS"        - login ok
     *  "EMPTY"          - username or password is empty
     *  "USER_NOT_FOUND" - username does not exist
     *  "WRONG_PASSWORD" - password does not match
     */

    public String login(String username, String password) {
        RWtext.read();
		if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {
            return "EMPTY";
        }

        username = username.trim();

        int usernameIndex = -1;

        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username)) {
                usernameIndex = i;
                break;
            }
        }
        if (usernameIndex <= -1) {
            return "USER_NOT_FOUND";
        }
        if (passwords.get(usernameIndex).equals(password)) {
            return "SUCCESS";
        } else {
            return "WRONG_PASSWORD";
        }
    }

    /*
     * Attempts to create a new account.
     * Returns:
     *  "SUCCESS"        - account created
     *  "EMPTY"          - username or password is empty
     *  "USERNAME_TAKEN" - username already exists
     */

    public String signUp(String username, String password) {
        if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {
            return "EMPTY";
        }

        username = username.trim();

        if (usernames.contains(username)) {
            return "USERNAME_TAKEN";
        }
		
		RWtext.write(username, password);
        usernames.add(username);
        passwords.add(password);
        return "SUCCESS";
    }
}
