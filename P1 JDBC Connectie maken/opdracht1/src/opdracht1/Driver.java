package opdracht1;

import java.sql.*;

public class Driver {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String username = "STEFAN";
		String password = "Hallo123";
		
		try {
			Connection myConn = DriverManager.getConnection(url, username, password);
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet myRs = myStmt.executeQuery("select * from CURSUSSEN");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("CODE"));
			}
			
			Statement myStmt2 = myConn.createStatement();
			String createSql = "insert into CURSUSSEN "
					+ " (CODE, OMSCHRIJVING, TYPE, LENGTE)"
					+ " values ('XXX', 'Stefan', 'ALG', 4)";
			
			myStmt2.executeUpdate(createSql);
			
			System.out.println("complete");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
