
public class PlayerColor {
	private String name;
	private String color;
	
	public PlayerColor(String n, String c) {
		name = n;
		color = c;
	}
	
	public String toString() {
		return String.format("%s: %s", name ,color);
	}
}
