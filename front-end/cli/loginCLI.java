//dependancies
import package.Authentication.java
import java.util.Scanner;
import java.lang.InterruptedException;

class loginCLI{
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
	
		boolean auth = false;

		//Asking whether the user wants to login with an existing account or create a new account
		while (auth == false){
			System.out.println("Would you like to Login or Sign-Up for *xXx* System? [L/s]");
			char loginSign = scnr.nextLine().charAt(0);
			loginSign = Character.toLowerCase(loginSign);
			//checks for option value with login as the default
			if (loginSign == 'l'){
				auth = Authentication.Authenticate();
				System.out.println("You have Successfully Logged in");
			} else if (loginSign == 's'){
				Authentication.SignUp();
				System.out.println("Congradulation. \nYou have Successfully registered with *xXx* Systems. \nPlease proceed to the login screen.");
				clearScreen();
			} else {
				System.out.println("Please try again");
			}
		}
		scnr.close();
	}

	//Method to clear the screen for the cli
	public static void clearScreen(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e){
			Thread.currentThread().interrupt();
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
