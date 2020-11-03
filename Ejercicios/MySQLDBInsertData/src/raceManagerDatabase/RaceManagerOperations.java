package raceManagerDatabase;
import raceManagerObjects.*;

public class RaceManagerOperations {
	public static final String ATHLETE_TABLE_NAME = "Athlete";
	public static final String ATHLETE_TYPE_TABLE_NAME = "AthleteType";
	
	public static String CreateAthleteTableDetails() {
		return "RacerID INT NOT NULL AUTO_INCREMENT, "
				+ "Name VARCHAR(100) NOT NULL,"
				+ "Age INT NOT NULL,"
				+ "IsInjured BIT NOT NULL,"
				+ "TypeId INT NOT NULL,"
				+ "Shoes VARCHAR(45) NULL,"
				+ "UsesClips BIT NULL,"
				+ "PRIMARY KEY (RacerID)";
	}
	
	public static String CreateAthleteTypeTableDetails() {
		return "ID INT NOT NULL AUTO_INCREMENT,"
				+ "AthleteType VARCHAR(45) NOT NULL,"
				+ "PRIMARY KEY (ID)";
	}
	
	public static String InsertAthleteTypeString(String aType) {
		return "INSERT INTO " + ATHLETE_TYPE_TABLE_NAME + " (AtheleteType) "
				+ " VALUES('" + aType + "')";
	}
	
	public static String InsertAthleteString(Athlete a, int typeID) {
		String atheleteInsert = "Insert into Athlete (Name, Age, IsInjured, TypeId, Shoes, UsesClips, VALUES,(" + a.getName() 
				+ a.getAge() + a.getIsInjured() + typeID;
		String athleteInsert = null;
		if (a instanceof Runner) {
			athleteInsert += ((Runner)a).getShoeBrand();
		} else {
			athleteInsert += "NULL, ";
		}
		if (a instanceof Biker) {
			athleteInsert +=((Biker)a).getUsingClips();
		} else {
			athleteInsert += "NULL";
		}
		athleteInsert += ");";
		return atheleteInsert;
	}
	
	public static String GetAthleteTypeData() {
		return "SELECT * FROM " + ATHLETE_TYPE_TABLE_NAME;
	}
	
	public static String GetAthleteData() {
		return "SELECT * FROM " + ATHLETE_TABLE_NAME;
	}
	
	public static String UpdateAthleteString(Athlete a) {
		return "UPDATE " + ATHLETE_TABLE_NAME + " SET name='" + a.getName() + "', age=" + a.getAge()  + " WHERE RacerID=" + a.getRacerId();
	}
	
	public static String DeleteAthleteByRacerID(int racerID) {
		return "DELETE FROM " + ATHLETE_TABLE_NAME + " WHERE RacerId=" + racerID + ";";
	}

	}

