import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaoLmpl extends OracleBaseDao implements ProductDao {
	
	public List<Product> findByKaartnummer(int kaartnummer) {
		List<Product> producten = new ArrayList<Product>();
		
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART_PRODUCT o " + 
					"left join PRODUCT p on (o.PRODUCTNUMMER = p.PRODUCTNUMMER) " + 
					"WHERE o.KAARTNUMMER = " + kaartnummer;
			ResultSet rs = myStmt.executeQuery(strQuery);
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductnummer(rs.getInt("PRODUCTNUMMER"));
				p.setProductNaam(rs.getString("PRODUCTNAAM"));
				p.setBeschrijving(rs.getString("BESCHRIJVING"));
				p.setPrijs(rs.getFloat("PRIJS"));
				producten.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producten;
	}
	
	public Product save(Product product) {
		try {
			Connection myConn = getConnection();
			Statement insertStmt = myConn.createStatement();
			String q = "INSERT INTO "
					+ "PRODUCT(PRODUCTNUMMER, PRODUCTNAAM, BESCHRIJVING, PRIJS) "
					+ "VALUES('" + product.getProductnummer() + "','" 
					+ product.getProductNaam() + "','" 
					+ product.getBescrijving() + "'," 
					+ product.getPrijs() + ")";
			ResultSet myRs = insertStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return product;
	}
	
	public Product update(Product product) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			
			String q = "Update PRODUCT SET "
					+ "PRODUCTNUMMER = '" + product.getProductnummer() + "' "
					+ "PRODUCTNAAM = '" + product.getProductNaam() + "' "
					+ "BESCHRIJVING = '" + product.getBescrijving() + "' "
					+ "PRIJS = '" + product.getPrijs() + "' ";
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return product;
	}
	
	public boolean delete(Product product) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("delete from PRODUCT "
					+ "where PRODUCTNUMMER = " + product.getProductnummer());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
