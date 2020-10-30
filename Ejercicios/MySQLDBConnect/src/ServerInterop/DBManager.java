package ServerInterop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	Connection cn = null;
	ServerConector scb = null;
	
	public DBManager() {
		
	}
	
	public DBManager(ServerConector connector) {
		scb = connector;
	}
	
	public boolean setConnectionBehavior(ServerConector connector) {
		if (connector == null) {
			throw new IllegalArgumentException("Server Connector cannot be ");
		}
		scb = connector;
		return true;
	}
	
	public boolean openConnection() {
		try {
			if (scb == null) throw new IllegalStateException("Cannot open");
			if (cn != null) closeConnection(false);
			cn = scb.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		if (cn == null) return false;
		return true;
	}
	
	public boolean closeConnection(boolean keepAlive) {
		try {
			if (cn != null) {
				if (!cn.isClosed()) {
					cn.close();
				}
			}
			if (!keepAlive) {
				cn = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
		
		public boolean isConnected() {
			return cn != null;
		}
		
		public boolean ExecuteNonQuery(String query) {
			try {
				Statement st = null;
				st = cn.createStatement();
				int i = st.executeUpdate(query);
				if (i == -1) {
					System.out.println("db error : " + query);
					return false;
				}
				st.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
			return true;
		}
		
		public ResultSet ExecuteRSGetTableSchema() {
			try {
				PreparedStatement pst = cn.prepareStatement(GetTablesSchemaQuery());
				return pst.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean ExecuteTableExists(String query, String col_name) {
			try {
				PreparedStatement pst = cn.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					int val = rs.getInt(col_name);
					if (val > 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public Connection GetConnection() {
			return cn;
		}
		
		public String GetConnectionURL() {
			return scb.getConnectionURL();
		}
		
		public String GetTablesSchemaQuery() {
			return scb.getTablesSchemaQuery();
		}
		
		public String GetDBName() {
			return scb.getDBName();
		}
		
		public String GetServerName() {
			return scb.getServername();
		}
		
		
		public String GetUserName() {
			return scb.getUserName();
		}
	}

