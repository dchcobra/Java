package raceManagerDatabase;

public class RaceManagerOperations {

	public static final String ATHLETE_TABLE_NAME = "Athlete";
	public static final String ATHLETE_TYPE_TABLE_NAME = "AtheleteType";
	
	public static String CreateAthleteTableDetails() {
		return "`RacerID` INT NOT NULL AUTO_INCREMENT, "
				+ "`Name` VARCHAR(100) NOT NULL, "
				+ "`Age` INT NOT NULL, "
				+ "`IsInjured` BIT NOT NULL, "
				+ "`TypeId` IS NOT NULL, "
				+ "`Shoes` VARCHAR(45) NULL, "
				+ "`UsesClips` BIT NULL, "
				+ "PRIMARY KEY (`RacerID`)";
	}
	
	public static String CreateAthleteTypeTableDetails() {
		return "`ID` INT NOT NULL AUTO_INCREMENT, "
				+ "`AtheleteType` VARCHAR(45) NOT NULL, "
				+ "PRIMARY KEY (`RacerID`)";
	}
}
