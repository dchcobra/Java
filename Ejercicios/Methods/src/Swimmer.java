public class Swimmer {
	private int ID;
	
	public Swimmer () {
		
	}
	
	/* Permite pasarle un parametro al constructor */
	public Swimmer(int IdCorredor) {
		ID = IdCorredor;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int value) {
		ID = value;
	}
	
	public String performSport() {
		return "Nadando";
	}
	
	public String toString() {
		return String.format("%d esta %s\n", getID(), performSport());
	}
}
