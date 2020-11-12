import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class ReadWriteTextBufferedReaderWriter {
	public static final String inputPath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\ReadingAndWritintTextFilesBuffered\\Racers.txt";
	public static final String outputPath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\ReadingAndWritintTextFilesBuffered\\RacersModified.txt";

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(inputPath);
			br = new BufferedReader(fr);
			String nextLine = null;
			ArrayList<String> racers = new ArrayList<String>();
			while ((nextLine= br.readLine()) != null) {
				racers.add(nextLine);
				System.out.println("Added " + nextLine);
			}
			fw = new FileWriter(outputPath);
			bw = new BufferedWriter(fw);
			Random r = new Random();
			int max = 85;
			int min = 18;
			
			for (String s : racers) {
				int age = r.nextInt((max - min)) + min + 1;
				
				String output = s + "|" + age;
				bw.write(output);
				bw.newLine();
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
				try {
					if (fr != null) {
						if (br != null) {
							br.close();
							br = null;
						}
						fr.close();
						fr = null;
					}
					if (fw != null) {
						if (bw != null) {
							bw.close();
							bw = null;
						}
						fw.close();
						fw = null;
					} 
				} catch (IOException ioex2) {
					ioex2.printStackTrace();
				}
			}
		}
	}
 