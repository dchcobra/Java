package raceManagerSystem;
import java.util.ArrayList;
import java.util.Random;
import raceManagerObjects.*;

public class InfiniteSkillsRace {
	ArrayList<Athlete> racers;
	int nextRacerId;
	String name;
	double distance;
	String location;
	Athlete winner;

	public InfiniteSkillsRace() {
		racers = new ArrayList<Athlete>();
		Random r = new Random();
		nextRacerId = r.nextInt(99999);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String namel) {
		name = namel;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distancel) {
		distance = distancel;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String locationl) {
		location = locationl;
	}
	
	public Athlete getWinner() {
		calculateWinner();
		return winner;
	}
	
	private void calculateWinner() {
		Random r = new Random();
		int winnerIndex = r.nextInt(racers.size());
		winner = racers.get(winnerIndex);
	}
	
	public boolean addRacer(Athlete a) {
		if (a == null) return false;
		if (a.getName() == null) return false;
		int racerIndex = findRacer(a.getName());
		if (racerIndex >= 0) return false;
		racers.add(a);
		a.setRacerId(nextRacerId);
		return true;
	}
	
	public boolean removeRacer(String name) {
		if(name == null) return false;
		int racerPosition = findRacer(name);
		if (racerPosition < 0) return false;
		racers.remove(racerPosition);
		return true;
	}
	
	public int getCurrentNumberOfRacers() {
		return racers.size();
	}
	
	public Athlete getRacer(String name) {
		int index = findRacer(name);
		if (index < 0) return null;
		return racers.get(index);
	}
	
	private int findRacer(String name) {
		if (name == null) return -1;
		for (int i = 0; i < racers.size(); i++) {
			Athlete a = racers.get(i);
			if (a.getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public Athlete[] getRacers() {
		if (racers.size() > 0) {
			Athlete[] racers = new Athlete[racers.size()];
			for (int i = 0; i < racers.size(); i++) {
				racers[i] = (Athlete)racers.get(i);
			}
			return racers;
		} else {
			return null;
		}
	}
	
}
