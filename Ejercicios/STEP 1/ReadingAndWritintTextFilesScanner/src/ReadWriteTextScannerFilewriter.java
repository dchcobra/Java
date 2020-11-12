import java.io.*;
import java.util.*;

public class ReadWriteTextScannerFilewriter {
	public static final String inputPath = "C:\\Users\\david\\eclipse-workspace\\ReadingAndWritintTextFilesScanner\\Racers.txt";
	public static final String outputPath = "C:\\Users\\david\\eclipse-workspace\\ReadingAndWritintTextFilesScanner\\RacersModified.txt";

	public static void main(String[] args) {
		File inputFile = new File(inputPath);
		Scanner input = null;
		
		FileWriter fw = null;
		
		ArrayList<String> racers = new ArrayList<String>();
		try {
			input = new Scanner(inputFile);
			while (input.hasNextLine()) {
				String nextRacer = input.nextLine();
				racers.add(nextRacer);
				System.out.println(nextRacer + " added...");
			}
			if (input != null) {
				input.close();
				input = null;
			}
			
			fw = new FileWriter(outputPath);
			Random r = new Random();
			int max = 85;
			int min = 18;
			for (String s : racers) {
				int age = r.nextInt((max - min)) + min + 1;
				
				String output = s + "|" + age + "\n";
				fw.write(output);
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
					fw = null;
				} catch (IOException ioex2) {
					ioex2.printStackTrace();
				}
			}
		}
	}

}
