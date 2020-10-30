package ServerInterop;
import java.sql.*;

public interface ServerConector {
	Connection getConnection();
	String getConnectionURL();
	String getConnectionDetails();
	String getTablesSchemaQuery();
	String getDBName();
	String getServername();
	String getUserName();
}
