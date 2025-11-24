import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RWtext {

    public static ArrayList<String> userNames = new ArrayList<>();
    public static ArrayList<String> PWDs = new ArrayList<>();

    private static final String uNameDir = System.getProperty("user.dir")+"/dbs/userName.txt";
    private static final String uPWDDir = System.getProperty("user.dir")+"/dbs/userPassword.txt";

    public static void read() {
	
		//temp lines for testing
		System.out.println("Working dir: " + System.getProperty("user.dir"));
		System.out.println("Reading: " + new java.io.File(uNameDir).getAbsolutePath());
		//

        userNames = readFile(uNameDir);
        PWDs = readFile(uPWDDir);
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
        writeLine(uNameDir, newUser);
        writeLine(uPWDDir, newPwd);
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
