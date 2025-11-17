import java.util.ArrayList;
import java.util.Scanner;

public class Authentication {
	private static ArrayList<String> usernames = new ArrayList<String>();
	private static ArrayList<String> passwords = new ArrayList<String>();

	static {
		usernames.add("user1");
		passwords.add("abcd1234");
	}

	public static boolean Authenticate() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scnr.nextLine();
		System.out.print("Enter password: ");
		String password = scnr.nextLine();

		for (int i = 0; i < usernames.size(); i++) {
			if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
				System.out.println("Login successful! Welcome, " + username + ".");
				return true;
			}
		}
		System.out.println("Invalid username or password.");
		return false;
	}

	public static void SignUp() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Choose a username: ");
		String username = scnr.nextLine().trim();
		System.out.print("Choose a password: ");
		String password = scnr.nextLine();

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("Username and password cannot be empty.");
			return;
		}

		if (usernames.contains(username)) {
			System.out.println("Username already exists. Please choose another one.");
			return;
		}

		usernames.add(username);
		passwords.add(password);
		System.out.println("Account created successfully! Please log in.");
	}
}