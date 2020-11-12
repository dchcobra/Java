public class Runner {
	private int ID;
	
	public Runner() {

	}
	
	public int getID() {
		return ID;
	}
	
	public void setID (int value) {
		ID = value;
	}
	
	public String performSport() {
		return "Corriendo";
	}
	
	public String toString() {
		return String.format("%d esta %s", getID(), performSport());
	}
}
