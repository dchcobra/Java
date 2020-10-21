public class Runner {
	private int ID;
	private String nombre;
	
	public Runner() {

	}
	
	public int getID() {
		return ID;
	}
	
	public void setID (int value) {
		ID = value;
	}
	
	public String getName() {
		return nombre;
	}
	
	public void setName(String value) {
		nombre = value;
	}
	
	public String performSport() {
		return "Corriendo";
	}
	
	public String toString() {
		return String.format("%s:\t%d esta %s\n"
				, getName()
				, getID()
				, performSport());
	}
}
