import java.io.IOException;

public class Validate {
	public static void StringHasContent(String test) throws IllegalArgumentException {
		if (test == null || test.length() == 0) {
			throw new IllegalArgumentException("Null or Empty String encountered");
		}
	}
	
	public static void StringHasContentChecked(String test) throws IOException {
		if (test == null || test.length() == 0) {
			throw new IOException("Null or Emptu Strinng encountered");
		}
	}
}
