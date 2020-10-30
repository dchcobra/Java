package raceManagerDatabase;
import java.util.Scanner;

import ServerInterop.DBManager;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConector;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowDatabaseOperations {
	private static final String CONFIG_PATH = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\MySQLDBTableOperations\\src\\ServerInterop\\dataconfig.json";
	private static final String DB_KEY = "racemanagerdb";
	
	public static void main(String[] args) {
		try {
			ServerConector sc = new MySQLServerConnector(CONFIG_PATH, DB_KEY);
			DBManager dbm = new DBManager(sc);
			dbm.openConnection();
			ResultSet rs = dbm.ExecuteRSGetTableSchema();
			while (rs.next() ) {
				System.out.println("Table Found:  " + rs.getString("TABLE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
