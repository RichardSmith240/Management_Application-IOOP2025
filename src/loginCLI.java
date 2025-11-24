import java.util.Scanner;
import java.lang.InterruptedException;

class loginCLI {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Authentication auth = new Authentication();
	
		boolean authenticated = false;

		while (!authenticated) {
			System.out.println("========================================");
			System.out.println("    Welcome to *xXx* System!");
			System.out.println("Would you like to Log-in or Sign-Up? [L/s]");
			String input = scnr.nextLine();
			if (input.isEmpty()) {
				System.out.println("Please enter L to log-in or S to sign-up.");
				continue;
			}
			char loginSign = Character.toLowerCase(input.charAt(0));

			if (loginSign == 'l') {
				System.out.print("Enter username: ");
				String username = scnr.nextLine().trim();
				System.out.print("Enter password: ");
				String password = scnr.nextLine();

				String result = auth.login(username, password);
				switch (result) {
					case "SUCCESS":
						System.out.println("========================================");
						System.out.println("    Welcome to *xXx* System!");
						System.out.println("    Welcome, " + username + "!");
						System.out.println("========================================");
						authenticated = true;
						break;
					case "EMPTY":
						System.out.println("Please enter both username and password.");
						break;
					case "USER_NOT_FOUND":
						System.out.println("Username not found. Please sign up first.");
						break;
					case "WRONG_PASSWORD":
						System.out.println("Password is incorrect. Please try again.");
						break;
				}
			} else if (loginSign == 's') {
				System.out.print("Enter a new username: ");
				String username = scnr.nextLine().trim();
				System.out.print("Enter a password: ");
				String password = scnr.nextLine();

				String result = auth.signUp(username, password);

				switch (result) {
					case "SUCCESS":
						System.out.println("Congratulations!");
						System.out.println("You have successfully registered with *xXx* Systems.");
						System.out.println("Please proceed to the log-in screen.");
						break;
					case "EMPTY":
						System.out.println("Username and password cannot be empty.");
						break;
					case "USERNAME_TAKEN":
						System.out.println("Username already exists. Please choose another one.");
						break;
				}
			} else {
				System.out.println("Please try again");
			}
		}

		System.out.println("You have successfully logged-in.");
		scnr.close();
	}

	public static void clearScreen() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

