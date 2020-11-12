public class Swimmer {
	private int raceID;
	private String name;
	
	public Swimmer () {
		
	}
	
	/* Permite pasarle un parametro al constructor */
	public Swimmer(int racerID,  String swimmername) {
		raceID = racerID;
		name = swimmername;
	}
	
	public int getRaceID() {
		return raceID;
	}
	
	public void setRaceID(int value) {
		raceID = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public String performSport() {
		return "Nadando";
	}
	
	public String toString() {
		return String.format("%s:\t%d esta %s\n"
				, getName()
				, getRaceID()
				, performSport());
	}
}
