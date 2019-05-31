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
	
	public Product findByProductNummer(int productNummer) {
		Product producten = new Product();
		
		try {
			Connection myConn = getConnection();
			Statement stmt = myConn.createStatement();
			String query = "SELECT * FROM product WHERE productNummer =" + productNummer;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Product mijnProduct = new Product();
				mijnProduct.setBeschrijving(rs.getString("beschrijving"));
				mijnProduct.setPrijs(rs.getDouble("prijs"));
				mijnProduct.setProductNaam(rs.getString("productNaam"));
				mijnProduct.setProductnummer(rs.getInt("productNummer"));
				return mijnProduct;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return producten;
	}
	
	public ArrayList<OvChipkaart> findOvChipkaartByProductNummer(int productNummer) {
		ArrayList<OvChipkaart> alleKaarten = new ArrayList<OvChipkaart>();
		Product p = this.findByProductNummer(productNummer);
		
		try {
			Connection myConn = getConnection();
			Statement stmt = myConn.createStatement();
			String query = "SELECT kaartnummer FROM ov_chipkaart_product WHERE productNummer ="+ productNummer;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int kaartnummer = rs.getInt("kaartNummer");
				Statement ovstmt = myConn.createStatement();
				String ovQuery = "SELECT * FROM ov_chipkaart WHERE kaartNummer="+ kaartnummer;
				ResultSet result = ovstmt.executeQuery(ovQuery);
				while(result.next()) {
					OvChipkaart ov = new OvChipkaart();
					ov.setKaartNummer(kaartnummer);
					ov.setKlasse(result.getInt("klasse"));
					ov.setReizigerId(result.getInt("reizigerID"));
					ov.setSaldo(result.getDouble("saldo"));
					ov.setGeldigTot(result.getDate("geldigTot"));
					ov.voegProductToe(p);
					p.voegOvToe(ov);
					alleKaarten.add(ov);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return alleKaarten;
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
