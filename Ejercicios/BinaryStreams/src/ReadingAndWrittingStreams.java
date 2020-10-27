import java.io.*;
import java.util.*;

public class ReadingAndWrittingStreams {

	public static String inFilePath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\BinaryStreams\\src\\MyData.dat";
	public static String outFliePath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\BinaryStreams\\src\\MyDataR.dat";

	public static void main(String[] args) {
		try {
			File inFile = new File(inFilePath);
			FileInputStream fis = new FileInputStream(inFile);
			InputStreamReader ir = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(ir);
			ArrayList<String> lines = new ArrayList<String>();
			String nextLine = null;
			while ((nextLine = br.readLine()) != null) {
				lines.add(nextLine);
			}
			br.close();
			br = null;
			ir.close();
			ir = null;
			fis.close();
			fis = null;
			
			File outFile = new File(outFliePath);
			FileOutputStream fos = new FileOutputStream(outFile);
			PrintStream ps = new PrintStream(fos);
			for (String s : lines) {
				StringBuilder sb = new StringBuilder(s);
				ps.println(sb.reverse().toString());
			}
			ps.close();
			ps = null;
			fos.close();
			fos = null;
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
}
