
public class Utilities {
	public static boolean nullSafeEquals(Object one, Object two) {
	/*	
		if (one == null) {
			return two == null;
		} else {
			return one.equals(two);
		}
		*/
	return one == null ? two == null : one.equals(two);
	}
}
