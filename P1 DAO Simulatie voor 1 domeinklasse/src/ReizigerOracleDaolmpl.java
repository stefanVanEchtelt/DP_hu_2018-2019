import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao {
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();
	
	public List<Reiziger> findAll() {
		return reizigers;
	}
	
	public List<Reiziger> findAllByGBdatum(String GBdatum) {
		List<Reiziger> GbReiziger = new ArrayList<Reiziger>();
		for (Reiziger reiziger : this.reizigers) {
			if (reiziger.getGBdatum() != null) {
				if (reiziger.getGBdatum().toString().equals(GBdatum)) { // TODO check if tostringis good
					GbReiziger.add(reiziger);
				}	
			}
		}
		
		return GbReiziger;
	}
	
	public Reiziger save(Reiziger reiziger) {
		if (!this.reizigers.contains(reiziger)) {
			this.reizigers.add(reiziger);	
		}
		
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		if (this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			this.reizigers.add(reiziger);
			return reiziger;
		}
		
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		if (this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			return true;
		}
		
		return false;
	}
}
