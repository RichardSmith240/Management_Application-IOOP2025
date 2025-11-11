import java.util.ArrayList;
import java.util.Scanner;

public class Authentication{
	//authenication method
	public boolean Authenticate(){
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scnr.nextLine();
		System.out.print("Enter password: ");
		String password = scnr.nextLine();
		//searches for username and password
		for(int i=0; i<usernames.size(); i++){
			if(usernames.get(i).equals(username) && passwords.get(i).equals(password)){
				System.out.println("Login successful! Welcome, " + username + ".");
				return true;
			}
		}
		System.out.println("Invalid username or password.");
		return false;
	}

	//sign-up method
	public static void SignUp(){
		System.out.println("lol");
	}

	// Array list for the user name and the password - Vaidehi 
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	
	public Authentication(ArrayList<String> usernames, ArrayList<String> passwords) {
	this.usernames = usernames;
	this.passwords = passwords;
} 


	}


