import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	private int reizigerId;
	private String naam;
	private Date gbdatum;
	private ArrayList<OvChipkaart> ovKaarten = new ArrayList<OvChipkaart>();
	
	public Reiziger() {}
	
	public int getReizigerId() {
		return reizigerId;
	}
	
	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public Date getGBdatum() {
		return gbdatum;
	}
	
	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}
	
	public void voegOvToe(OvChipkaart ov) {
		if (!this.ovKaarten.contains(ov)) {
			this.ovKaarten.add(ov);
		}
	}
}
