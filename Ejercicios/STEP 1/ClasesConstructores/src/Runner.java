public class Runner {
	private int ID = 1;
	
	public Runner() {

	}
	
	/* Permite pasarle un parametro al constructor */
	public Runner(int IdCorredor) {
		ID = IdCorredor;
	}
	
	public String performSport() {
		return "Corriendo";
	}
	
	public String toString() {
		return String.format("%d esta %s\n", this.ID, performSport());
	}
}
