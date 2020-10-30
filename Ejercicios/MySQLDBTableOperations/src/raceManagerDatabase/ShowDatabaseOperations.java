package raceManagerDatabase;
import java.util.Scanner;

import ServerInterop.DBManager;
import ServerInterop.MySQLOperations;

import java.io.*;
import java.sql.SQLException;

public class ShowDatabaseOperations {
	private static final String CONFIG_PATH = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\MySQLDBTableOperations\\src\\ServerInterop\\dataconfig.json";
	private static final String DB_KEY = "racemanagerdb";
	
	public static void main(String[] args) {
		try {
			ServerConnector sc = new MySQLServerConnector(CONFIG_PATH, DB_KEY);
			
			DBMaanager dbm = new DBManager(sc);
			dbm.openCoonnection();
			Scanner input = new Scanner(System.in);
			String tableName;
			boolean allDone = false;
			while (!allDone) {
				int option = printMenu();
				switch(option) {
				case 1:
					listAllTables(dbm);
					break;
				case 2:
					System.out.println("Please enter the name of the table for which to verify existence: ");
					tableName = input.nextLine();
					verifyTableExists(dbm, tableName);
					break;
				case 3:
					System.out.println("Enter 1 to create the Athlete Table, 2 to create the Athlete Type Table:");
					tableName =input.nextLine();
					if (tableName.equals("1")) {
						createTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME
								, RaceManagerOperations.CreateAthleteTableDetails();
					} else if (tableName.equals("2")) {
						createTable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME
								, RaceManagerOperations.CreateAthleteTableDetails();
					} else {
						System.out.println("Invalid choice");
					}
					break;
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
				choice = Integer.parseInt(input.nextLine());
				if (choice >= 1 && choice < 4) {
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
			System.out.println("The Tablle: " + tableName + " does not exist!");
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
}
