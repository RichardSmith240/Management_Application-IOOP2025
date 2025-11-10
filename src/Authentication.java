import java.util.ArrayList;

public class Authentication{
	//authenication method
	public static boolean Authenticate(){
		return true;
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


