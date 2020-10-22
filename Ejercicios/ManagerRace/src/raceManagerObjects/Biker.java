package raceManagerObjects;

public class Biker extends Athlete{
	
	private boolean usesClips;
	
	public Biker() {
		
	}
	
	public Biker (String namel, int agel, int racerIdl, boolean usesClipsl) {
		super(namel, agel, racerIdl);
		usesClips = usesClipsl;
	}
	
	public String performRaceActivity() {
		return "Biking...";
	}
	
	public void setUsingClips(boolean value) {
		usesClips = value;
	}
	
	public boolean getUsingClips() {
		return usesClips;
	}
	
	public String toString() {
		return String.format("%s %s]\tActivity: %s\tIs Running with shoes: %s\n"
				, super.toString()
				, getClass()
				, performRaceActivity()
				, getUsingClips());
	}

}
