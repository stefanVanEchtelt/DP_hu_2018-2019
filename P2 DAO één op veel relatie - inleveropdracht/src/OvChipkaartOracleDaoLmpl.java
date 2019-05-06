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
		return ovChipkaart;
	}
	
	public OvChipkaart update(OvChipkaart ovChipkaart) {
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
