import java.sql.*;

public class OracleBaseDao {
	private Connection myConnection = null;
	
	protected Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String username = "OV";
		String password = "Hallo123";
		
		if (myConnection == null) {
			try {
				myConnection = DriverManager.getConnection(url, username, password);
			} catch (Exception exc) {
				exc.printStackTrace();
			}	
		}
		
		return myConnection;
	};
	
	public void closeConnection() {
		try {
			myConnection.close();
			myConnection = null;
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
