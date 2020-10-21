public class Swimmer {
	private int ID;
	private String nombre;
	
	public Swimmer () {
		
	}
	
	/* Permite pasarle un parametro al constructor */
	public Swimmer(int IdCorredor,  String nombreNadador) {
		ID = IdCorredor;
		nombre = nombreNadador;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int value) {
		ID = value;
	}
	
	public String getName() {
		return nombre;
	}
	
	public void setName(String value) {
		nombre = value;
	}
	
	public String performSport() {
		return "Nadando";
	}
	
	public String toString() {
		return String.format("%s:\t%d esta %s\n"
				, getName()
				, getID()
				, performSport());
	}
}
