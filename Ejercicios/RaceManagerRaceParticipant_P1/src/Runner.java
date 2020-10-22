
public class Runner implements RaceParticipant {
	
	private int racerId;
	
	public Runner() {
		
	}
	
	public Runner (int racerId1) {
		racerId = racerId1;
	}
	
	public void setRacerId (int racerId1) {
		racerId = racerId1;
	}
	
	public int getRacerId() {
		return racerId;
	}
	
	public String performRaceActivity() {
		return "Corriendo...";
	}
	
	public String toString() {
		return String.format("%s]\tRacerID: %d\tActivity: %s\n"
				, getClass()
				, getRacerId()
				, performRaceActivity());
	}
}
