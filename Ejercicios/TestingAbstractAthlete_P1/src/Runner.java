
public class Runner extends Athlete{
	private String shoeBrand;
	
	public Runner() {
		
	}
	
	public Runner (String namel, int agel, int racerIdl, String shoeBrandl) {
		super(namel, agel, racerIdl);
		shoeBrand = shoeBrandl;
	}
	
	public String getShoeBrand() {
		return shoeBrand;
	}
	
	public void setShoeBrand(String value) {
		shoeBrand = value;
	}
	
	public String performRaceActivity() {
		return "Corriendo...";
	}
	
	public String toString() {
		return String.format("%s %s]\tActivity: %s\tIs Running with shoes: %s\n"
				, super.toString()
				, getClass()
				, performRaceActivity()
				, getShoeBrand());
	}

}
