package ServerInterop;

public class MySQLOperations {
	public static String CREATE_TABLE_QUERY(String tableName, String fieldList) {
		return String.format("CREATE TABLE %s (%s) ENGINE=MyISAM", tableName, fieldList);
	}
	
	public static String DELETE_TABLE_QUERY(String tableName) {
		return "DROP TABLE" + tableName;
	}
	
	public static String TABLE_EXISTS_QUERY(String dbName, String tableName) {
		return String.format("SELECT count(*) as ExistsCount from informatin_schema.tables"
				+ "WHERE table_schema = '%s"
				+ "AND table_name = '%s", dbName, tableName);
	}
}
