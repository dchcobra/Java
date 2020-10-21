public class Runner {
	private int ID;
	//nombre == name
	private String nombre;
	
	public Runner() {

	}
// getID == racerID
	public int getID() {
		return ID;
	}
// setID == setraceID
	public void setID (int value) {
		ID = value;
	}
// getName == getRaceID
	public String getName() {
		return nombre;
	}
// setName == setRaceID
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
