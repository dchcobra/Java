public class Swimmer {
	private int ID = 2;
	
	public Swimmer () {
		
	}
	
	/* Permite pasarle un parametro al constructor */
	public Swimmer(int IdCorredor) {
		ID = IdCorredor;
	}
	
	public String performSport() {
		return "Nadando";
	}
	
	public String toString() {
		return String.format("%d esta %s\n", this.ID, performSport());
	}
}
