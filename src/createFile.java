import java.io.IOException;
import java.io.File;

public class createFile{
	public static void makeFile(String makeDir, String fileName) {
		try {
			File newFile = new File(makeDir+"/"+fileName);
			if (newFile.createNewFile()) {
				System.out.println("File Succesfully Created");
			} else {
				System.out.println("There was a error creating the file. If it already exists, please remove it and try again.");
			}
		} catch (IOException e) {
			System.out.println("Error Occured | " + e);
		}	
	}
}
