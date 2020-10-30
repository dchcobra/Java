package ServerInterop;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Exception;
import org.json.JSONObject;

public class MySQLServerConnector implements ServerConector {
	private final String FORNAME = "com.mysql.jdbc.Driver";
	private final String CONSTRFORMAT = "jdbc:mysql://%s/%s?user=%s&password=%s";
	private String serverName;
	private String dbName;
	private String userName;
	private String password;

	public MySQLServerConnector(String path, String dbconnectionkey) throws IOException {
		if (path == null || path.length() == 0) {
			throw new IllegalArgumentException("Must include a valid path");
		}
		if (dbconnectionkey == null || dbconnectionkey.length() == 0) {
			throw new IllegalArgumentException("Must include a valid path");
		}

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String nextLine;
		StringBuilder sb = new StringBuilder();
		while ((nextLine = br.readLine()) != null) {
			sb.append(nextLine);
		}
		if (br != null) {
			br.close();
			br = null;
		}

		if (fr != null) {
			fr.close();
			fr = null;
		}

		JSONObject obj = new JSONObject(sb.toString());
		serverName = obj.getJSONObject(dbconnectionkey).getString("server");
		dbName = obj.getJSONObject(dbconnectionkey).getString("database");
		userName = obj.getJSONObject(dbconnectionkey).getString("username");
		password = obj.getJSONObject(dbconnectionkey).getString("password");
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName(FORNAME);
			Connection cn = DriverManager.getConnection(getConnectionURL());
			return cn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getTablesSchemaQuery() {
		return String.format("select table_name from information_schema.tables where tables_schema = '%s'", dbName);
	}

	@Override
	public String getDBName() {
		return dbName;
	}

	@Override
	public String getServername() {
		return serverName;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getConnectionURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConnectionDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
