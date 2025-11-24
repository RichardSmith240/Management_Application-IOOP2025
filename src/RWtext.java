import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
//import java.io.FilenameFilter;

public class RWtext {

    public static ArrayList<String> userNames = new ArrayList<>();
    public static ArrayList<String> PWDs = new ArrayList<>();

	static String workingDir = System.getProperty("user.dir");
	private static final String dbDir = System.getProperty("user.dir")+ "/src/dbs/"; 
    private static final String uName= "userName.txt";
    private static final String uPWD= "userPassword.txt";

    public static void read() {
	
		//temp lines for testing
		System.out.println("Working dir: " + workingDir);
		System.out.println("Reading Files in : " + new java.io.File(dbDir).getAbsolutePath());
		//

		check(uName);
		check(uPWD);
    }
	
	private static void check(String target) {
		File dbDirFile = new File(dbDir);
		File targetFile = new File(dbDir+target);

		//temp lines for testing
		System.out.println("Reading : " + new java.io.File(dbDir).getAbsolutePath());
		if (targetFile.exists() && dbDirFile.isDirectory()) {
			// temp lines for testing
			System.out.println(targetFile);
			userNames = readFile(target);
		} else {
			createFile.makeFile(dbDir, uName);
			read();
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
        writeLine(uName, newUser);
        writeLine(uPWD, newPwd);
    }

    private static void writeLine(String dir, String text) {
        try (FileWriter fw = new FileWriter(dir, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(text);

        } catch (IOException e) {
            System.err.println("Error writing file | " + e.getMessage());
        }
    }
}
