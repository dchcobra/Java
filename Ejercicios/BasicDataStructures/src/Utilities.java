
public class Utilities {
	public static boolean nullSafeEquals(Object one, Object two) {
		return one == null ? two == null : one.equals(two);
	}
}
