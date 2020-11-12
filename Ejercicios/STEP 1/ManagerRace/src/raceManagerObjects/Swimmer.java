package raceManagerObjects;

public class Swimmer extends Athlete{
	
	public Swimmer() {
		
	}
	
	public Swimmer (String namel, int agel, int racerIdl) {
		super(namel, agel, racerIdl);
	}
	
	public  String performRaceActivity() {
		return "Swimming...";
	}
	
	public String toString() {
		return String.format("%s %s]\tActivity: %s\n"
				, super.toString()
				, getClass()
				, performRaceActivity());
	}

}

