package raceManagerSystem;
import raceManagerObjects.*;

public interface Race {
	String getName();
	void setName();
	double getDistance();
	void setDistance(double distance);
	String getLocation();
	void setLocation(String Location);
	Athlete getWinner();
	boolean addRacer(Athlete a);
	boolean removeRacer(String name);
	int getCurrentNumberOfRacers();
	Athlete getRacer(String name);
	Athlete[] getRacers(); 
}
