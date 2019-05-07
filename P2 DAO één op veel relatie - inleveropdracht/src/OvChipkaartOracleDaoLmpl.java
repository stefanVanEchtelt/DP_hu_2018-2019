import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OvChipkaartOracleDaoLmpl extends OracleBaseDao implements OvChipkaartDao {

	public List<OvChipkaart> findByReiziger(int reizigerId) {
		List<OvChipkaart> ovs = new ArrayList<OvChipkaart>();
		
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = " + reizigerId;
			ResultSet rs = myStmt.executeQuery(strQuery);
			
			while(rs.next()) {
				OvChipkaart ov = new OvChipkaart();
				ov.setSaldo(rs.getFloat("SALDO"));
				ov.setReizigerId(rs.getInt("REIZIGERID"));
				ov.setKaartNummer(rs.getInt("KAARTNUMMER"));
				ovs.add(ov);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ovs;
	}
	
	public OvChipkaart save(OvChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement insertStmt = myConn.createStatement();
			String q = "INSERT INTO "
					+ "ov_chipkaart(KAARTNUMMER, KLASSE, SALDO, REIZIGERID, GELDIGTOT) "
					+ "VALUES('" + ovChipkaart.getKaartNummer() + "','" + ovChipkaart.getKlasse() + "', " + ovChipkaart.getSaldo() + ",'" + ovChipkaart.getReizigerId() + "', to_date('31-12-2017', 'DD-MM-YYYY'))";
			ResultSet myRs = insertStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return ovChipkaart;
	}
	
	public OvChipkaart update(OvChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			
			String q = "Update OV_CHIPKAART SET "
					+ "KAARTNUMMER = '" + ovChipkaart.getKaartNummer() + "' "
					+ "KLASSE = '" + ovChipkaart.getKlasse() + "' "
					+ "SALDO = '" + ovChipkaart.getSaldo() + "' "
					+ "REIZIGERID = '" + ovChipkaart.getReizigerId() + "' ";
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return ovChipkaart;
	}
	
	public boolean delete(OvChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("delete from OV_CHIPKAART "
					+ "where KAARTNUMMER = " + ovChipkaart.getKaartNummer());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
