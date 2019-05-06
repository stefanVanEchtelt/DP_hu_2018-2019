import java.util.Date;

public class OvChipkaart {
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private float saldo;
	private int reizigerId;
	
	public void setKaartNummer(int kaartnummer) {
		this.kaartNummer = kaartnummer;
	}
	
	public int getKaartNummer() {
		return this.kaartNummer;
	}
	
	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}
	
	public Date getGeldigTot() {
		return this.geldigTot;
	}
	
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	
	public int getKlasse() {
		return this.klasse;
	}
	
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void setReizigerId(int reizigerId) {
		this.reizigerId = reizigerId;
	}
	
}
