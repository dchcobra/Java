package raceManagerDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import ServerInterop.DBManager;
import ServerInterop.MySQLOperations;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConnector;
import raceManagerObjects.Athlete;
import raceManagerObjects.Biker;
import raceManagerObjects.Runner;
import raceManagerObjects.Swimmer;

public class ShowDatabaseOperations {
	private static final String CONFIG_PATH = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\MySQLDBTableOperations\\src\\ServerInterop\\dataconfig.json";
	private static final String DB_KEY = "racemanagerdb";
	
	private static final String	RUNNER = "Runner";
	private static final String BIKER = "Biker";
	private static final String SWIMMER = "Swimmer";
	
	public static void main(String[] args) {
		try {
			ServerConnector sc = new MySQLServerConnector(CONFIG_PATH, DB_KEY);
			
			DBManager dbm = new DBManager(sc);
			dbm.openConnection();
			Scanner input = new Scanner(System.in);
			String tableName;
			boolean allDone = false;
			while (!allDone) {
				int option = printMenu();
				switch(option) {
				case 1: //muestra las tablas de la base de datos
					listAllTables(dbm);
					break;
				case 2: //verifica las tablas que estan creadas
					System.out.println("Please enter the name of the table for which to verify existence: ");
					tableName = input.nextLine();
					verifyTableExists(dbm, tableName);
					break;
				case 3: //crea tablas
					System.out.println("Enter 1 to create the Athlete Table, 2 to create the Athlete Type Table:");
					tableName =input.nextLine();
					if (tableName.equals("1")) {
						createtable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME
								, RaceManagerOperations.CreateAthleteTableDetails());
					} else if (tableName.equals("2")) {
						createtable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME
								, RaceManagerOperations.CreateAthleteTableDetails());
					} else {
						System.out.println("Invalid choice");
					}
					break;
				case 4://elimna tablas
					System.out.println("Please enter 1 to delete the Athlete table, 2 to delete the Athlete type table.");
					tableName = input.nextLine();
					if (tableName.equals("1")) {
						deleteTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME);
					} else if (tableName.equals("2")) {
						deleteTable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME);
					} else {
						System.out.println("Invalid choice");
					}
					break;
				case 5:
					insertAthleteTypes(dbm);
					System.out.println("Inserted Athlete Types!");
					break;
				case 6:
					System.out.println("Please enter 1 to insert a new Runner , 2 to insert a new Biker or 3 to insert a new Swimmer. ");
					tableName = input.nextLine();
					Athlete a = null;
					if (tableName.equals("1")) {
						a = new Runner();
					} else if (tableName.equals("2")) {
						a = new Biker();
					} else if (tableName.equals("3")) {
						a = new Swimmer();
					}
					buildAthlete(a);
					insertAthlete(a, dbm);
					break;
				case 7:
					printAthletes(dbm);
					break;
				case 8:
					printAthletes(dbm);
					System.out.println("Please enter the racerID to update: ");
					tableName = input.nextLine();
					updateAthlete(dbm, Integer.parseInt(tableName));
					System.out.println("Updated the Athlete Data!");
				case 9:
					printAthletes(dbm);
					System.out.println("Please enter the racerId to delete: ");
					tableName = input.nextLine();
					deleteAthlete(dbm, Integer.parseInt(tableName));
					System.out.println("Deleted the Athlete Data!");
				default:
					break;
				}
				System.out.println("Would you like to do another operation [y/n]?");
				String choice = input.nextLine();
				if (choice.toLowerCase().charAt(0) == 'n') {
					allDone = true;
				}
			}
			
			dbm.closeConnection(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thank you for using the database manager!");
	}
	
	private static void updateAthlete(DBManager dbm, int racerId) throws SQLException {
		Athlete a = getAthlete(dbm, racerId);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 to update name, 2 to update age");
		int userChoice = Integer.parseInt(input.nextLine());
		if (userChoice == 1) {
			System.out.println("Please enter the new name: ");
			a.setName(input.nextLine());
		} else if (userChoice == 2) {
			System.out.println("Please enter the new age: ");
			a.setAge(Integer.parseInt(input.nextLine()));
		}
		String updateSyntax = RaceManagerOperations.UpdateAthleteString(a);
		return;		
	}

	private static Athlete getAthlete(DBManager dbm, int racerId) throws SQLException {
		String query = RaceManagerOperations.GetAthleteData();
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteData());
		ResultSet rs = pst.executeQuery();
		Athlete a = null;
		while (rs.next()) {
			int nextID = rs.getInt("RacerId");
			if (nextID == racerId) {
				int type = rs.getInt("TypeID");
				HashMap athleteTypes = getAthleteTypes(dbm);
				if ((int)athleteTypes.get(RUNNER) == type) {
					a = new Runner();
				} else if ((int)athleteTypes.get(BIKER) == type) {
					a = new Biker();
				} else if ((int)athleteTypes.get(SWIMMER) == type) {
					a = new Swimmer();}
			}
			a.setRacerId(nextID);
			a.setName(rs.getString("Name"));
			a.setAge(rs.getInt("Age"));
			a.setIsInjured(rs.getBoolean("IsInjured"));
			if (a instanceof Runner) {
				((Runner)a).setShoeBrand(rs.getString("Shoes"));
			} else if (a instanceof Biker) {
				((Biker)a).setUsingClips(rs.getBoolean("UsesClips"));
			}
		}
		rs.close();
		return a;
		}

	public static int printMenu() {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int choice = -1;
		while (!valid) {
			try {
				System.out.println("Please chose a valid operation: ");
				System.out.println("Enter 1 to list all tables: ");
				System.out.println("Enter 2 to verify a specific table exists: ");
				System.out.println("Enter 3 to add a new table: ");
				System.out.println("Enter 4 to delete a table: ");
				System.out.println("Enter 5 to insert the athlete types: ");
				System.out.println("Enter 6 to insert a new athlete: ");
				System.out.println("Enter 7 to list athletes: ");
				System.out.println("Enter 8 to update ahtletes");
				System.out.println("Enter 9 to delete ahtlete");

				choice = Integer.parseInt(input.nextLine());
				if (choice >= 1 && choice <= 9) {
					valid = true;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return choice;
	}
	
	public static void listAllTables(DBManager dbm) throws SQLException {
		ResultSet rs = dbm.ExecuteRSGetTableSchema();
		while (rs.next()) {
			System.out.println("Table Found: " + rs.getString("TABLE_NAME"));
		}
		rs.close();
	}
	
	public static void verifyTableExists(DBManager dbm, String tableName) throws SQLException {
		String query = MySQLOperations.TABLE_EXISTS_QUERY(dbm.GetDBName(), tableName);
		boolean exists = dbm.ExecuteTableExists(query, "ExistsCount");
		if (exists) {
			System.out.println("The Table: " + tableName + " exists!");
		} else {
			System.out.println("The Table: " + tableName + " does not exist!");
		}
	}
	
	public static void deleteTable(DBManager dbm, String tableName) throws SQLException {
		String query = MySQLOperations.DELETE_TABLE_QUERY(tableName);
		dbm.ExecuteNonQuery(query);
		System.out.println("Dropped table: " + tableName);
	}
	
	public static void createtable(DBManager dbm, String tableName, String details) throws SQLException {
		String query = MySQLOperations.CREATE_TABLE_QUERY(tableName, details);
		dbm.ExecuteNonQuery(query);
		System.out.println("Created table: " + tableName);
	}
	
	public static void buildAthlete(Athlete a) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the athlete's name: ");
		a.setName(input.nextLine());
		System.out.println("Please enter the athlete's age: ");
		a.setAge(Integer.parseInt(input.nextLine()));
		System.out.println("Is the athlete injured [y/n]?");
		String isInjured = input.nextLine();
		boolean Injured = false;
		if (isInjured.toLowerCase().charAt(0) == 'y') {
			Injured = true;
		}
		a.setIsInjured(Injured);
		if (a instanceof Runner) {
			System.out.println("Please enter the brand of shoes:");
			((Runner) a).setShoeBrand(input.nextLine());
		} else if (a instanceof Biker) {
			System.out.println("Does the biker wear clips [y/n]?");
			String clips = input.nextLine();
			if (clips.toLowerCase().charAt(0) == 'y') {
				((Biker)a).setUsingClips(true);
			}
		}
	}
	
	public static void insertAthlete (Athlete a, DBManager dbm) throws SQLException {
		HashMap<String, Integer> athleteTypes = getAthleteTypes(dbm);
		int typeID = 0;
		if (a instanceof Runner) {
			typeID = athleteTypes.get(RUNNER);
		} else if (a instanceof Biker) {
			typeID = athleteTypes.get(BIKER);
		} else if (a instanceof Swimmer) {
			typeID = athleteTypes.get(SWIMMER);
		}
		
		String insertAthlete = RaceManagerOperations.InsertAthleteString(a, typeID);
		dbm.ExecuteNonQuery(insertAthlete);
	}
	
	public static void printAthletes(DBManager dbm) throws SQLException {
		System.out.println("********************");
		System.out.println("ATHLETES: ");
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteData());
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println("RacerID: " + rs.getInt("RacerID") + " Name: " + rs.getString("Name") + " Age: " + rs.getInt("Age"));
		}
		rs.close();
		System.out.println("********************");
	}
	
	public static HashMap<String, Integer> getAthleteTypes(DBManager dbm) throws SQLException {
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteTypeData());
		ResultSet rs = pst.executeQuery();
		HashMap<String, Integer> types = new HashMap<String, Integer>();
		while (rs.next()) {
			types.put(rs.getString("AthleteType"), rs.getInt("ID"));
		}
		rs.close();
		return types;
	}
	
	public static void insertAthleteTypes(DBManager dbm) throws SQLException {
		HashMap<String, Integer> types = getAthleteTypes(dbm);
		if (types.size() == 0) {
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(RUNNER));
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(BIKER));
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(SWIMMER));

		}
	}
	public static void deleteAthlete (DBManager dbm, int racerId) throws SQLException {
		String deleteSyntax = RaceManagerOperations.DeleteAthleteByRacerID(racerId);
		dbm.ExecuteNonQuery(deleteSyntax);
	}
}
