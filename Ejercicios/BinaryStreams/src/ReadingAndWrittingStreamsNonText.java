import java.io.*;
import java.util.*;

public class ReadingAndWrittingStreamsNonText {
	public static String imgFilePath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\BinaryStreams\\src\\MIM_BINAY_NAME.jpg";
	public static String imgFilePath2 = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\BinaryStreams\\src\\data.bin";
	public static String imgFilePath3 = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\BinaryStreams\\src\\MIM_BINAY_NAME_Decrypted.jpg";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a shift to encryt/decrypt the file");
		int shift = Integer.parseInt(input.nextLine());
		
		try {
			FileInputStream fis = null;
			FileOutputStream fos = null;
			PrintStream ps = null;
			
			if (shift > 0) {
				fis = new FileInputStream(imgFilePath);
				fos = new FileOutputStream(imgFilePath2);
				ps = new PrintStream(fos);
			} else {
				fis = new FileInputStream(imgFilePath2);
				fos = new FileOutputStream(imgFilePath3);
				ps = new PrintStream(fos);
			}
			
			boolean done = false;
			while (!done) {
				int next = fis.read();
				if (next == -1) {
					done = true;
				} else {
					ps.write (((byte) next) + shift);
				}
			}
			
			ps.close();
			ps = null;
			fos.close();
			fos = null;
			fis.close();
			fis = null;
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} 
		System.out.println("Operation Completed!");
	}

}
