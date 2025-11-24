public class Authentication {

    public String login(String username, String password) {
        RWtext.read();
        if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {
            return "EMPTY";
        }

        username = username.trim();

        int usernameIndex = -1;

        for (int i = 0; i < RWtext.userNames.size(); i++) {
            if (RWtext.userNames.get(i).equals(username)) {
                usernameIndex = i;
                break;
            }
        }
        if (usernameIndex <= -1) {
            return "USER_NOT_FOUND";
        }
        if (RWtext.PWDs.get(usernameIndex).equals(password)) {
            return "SUCCESS";
        } else {
            return "WRONG_PASSWORD";
        }
    }

    public String signUp(String username, String password) {
        RWtext.read();
        if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {
            return "EMPTY";
        }

        username = username.trim();

        if (RWtext.userNames.contains(username)) {
            return "USERNAME_TAKEN";
        }

		RWtext.write(username, password);
        RWtext.userNames.add(username);
        RWtext.PWDs.add(password);
        return "SUCCESS";
    }
}
