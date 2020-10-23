import java.io.*;
import java.util.Scanner;

public class FileProcessor {
	public static void  main(String[] args)  {
		String invalid = "Try it";
		Validate.StringHasContent(invalid);
		
		try {
			Validate.StringHasContentChecked(invalid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String path = "C:\\Users\\david\\eclipse-workspace\\CheckedExceptions\\data.txt";
		File f = new File(path);
		FileWriter fw = null;
		try {
			Scanner input = new Scanner(f);
			int count = 0;
			while (input.hasNextLine()) {
				System.out.println(input.nextLine());
				count++;
			}
			
			input.close();
			
			fw = new FileWriter(path, true);
			fw.write("I have modified the data " + (count - 1) + " time!\n");
		} catch (IOException ioex) {
			System.out.println("No funciona");;
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
	}
}
