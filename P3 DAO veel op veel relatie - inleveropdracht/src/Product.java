import java.util.ArrayList;

public class Product {
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private int productnummer;
	private ArrayList<OvChipkaart> ovChipkaarten = new ArrayList<OvChipkaart>();
	
	public Product() {}
	
	public void setProductnummer(int productnummer) {
		this.productnummer = productnummer;
	}
	
	public int getProductnummer() {
		return this.productnummer;
	}
	
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	
	public String getProductNaam() {
		return this.productNaam;
	}
	
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	
	public String getBescrijving() {
		return this.beschrijving;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public double getPrijs() {
		return this.prijs;
	}
	
	public ArrayList<OvChipkaart> getOvChipkaarten() {
		return this.ovChipkaarten;
	}
	
	public void voegOvToe(OvChipkaart o) {
		if (!this.ovChipkaarten.contains(o)) {
			this.ovChipkaarten.add(o);
		}
	}
}
