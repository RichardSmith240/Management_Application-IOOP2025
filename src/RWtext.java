import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class RWtext {

    public static ArrayList<String> userNames = new ArrayList<>();
    public static ArrayList<String> PWDs = new ArrayList<>();

	static String workingDir = System.getProperty("user.dir");
	private static final String dbDir = System.getProperty("user.dir")+ "/src/dbs/"; 
    private static final String uName= "userName.txt";
    private static final String uPWD= "userPassword.txt";

    public static void read() {
		System.out.println("Working dir: " + workingDir);
		System.out.println("Reading Files in : " + new java.io.File(dbDir).getAbsolutePath());

		check(uName);
		check(uPWD);
    }
	
	private static void check(String target) {
		File dbDirFile = new File(dbDir);
		File targetFile = new File(dbDir+target);

		System.out.println("Reading : " + new java.io.File(dbDir).getAbsolutePath());
		
		if (!dbDirFile.exists()) {
			dbDirFile.mkdirs();
		}
		
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				System.err.println("Error creating file | " + e.getMessage());
			}
		}
		
		if (targetFile.exists()) {
			System.out.println(targetFile);
			ArrayList<String> lines = readFile(dbDir+target);
			if (target.equals(uName)) {
				userNames = lines;
			} else if (target.equals(uPWD)) {
				PWDs = lines;
			}
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
        writeLine(dbDir + uName, newUser);
        writeLine(dbDir + uPWD, newPwd);
    }

    private static void writeLine(String filePath, String text) {
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println(text);

        } catch (IOException e) {
            System.err.println("Error writing file | " + e.getMessage());
        }
    }
}
