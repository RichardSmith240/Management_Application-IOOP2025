import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class RWtext {

    public static ArrayList<String> userNames = new ArrayList<>();
    public static ArrayList<String> PWDs = new ArrayList<>();

	private static final String dbDir = System.getProperty("user.dir")+ "/src/dbs/"; 
    private static final String uName= "userName.txt";
    private static final String uPWD= "userPassword.txt";

    public static void read() {
		System.out.println("Reading Files in | " + dbDir);

		if (check(uName) == true) {
			userNames = readFile(uName);
			if (check(uPWD) == true) {
				PWDs = readFile(uPWD);
			}
		}else {
			System.out.println("Unable to Read");
		}
	}
	
	private static boolean check(String target) {
		File dbDirFile = new File(dbDir);
		File targetFile = new File(dbDir+target);

		//temp lines for testing
		System.out.println("Searching for File | " + new java.io.File(dbDir+target).getAbsolutePath());
		if (targetFile.exists() && dbDirFile.isDirectory()) {
			// temp lines for testing
			System.out.println(targetFile);
			return true;
		} else {
			System.out.println("File Created | "+target);
			createFile.makeFile(dbDir, target);
			read();
			return false;
		}
	}
    private static ArrayList<String> readFile(String dir) {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(dir));

            while (true) {
                String line = reader.readLine();
                if (line == null || line.trim().isEmpty()) break;
                lines.add(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading file | " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ignored) {}
        }
        return lines;
    }
	public static void write(String newUser, String newPwd) {
	    userNames.add(newUser);
	    PWDs.add(newPwd);

	    writeAllLines(userNames, dbDir + uName);
	    writeAllLines(PWDs, dbDir + uPWD);
	}

	private static void writeAllLines(ArrayList<String> list, String dir) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir))) {
		    for (String content : list) {
		        writer.write(content);
		        writer.newLine();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
