import java.util.List;

public interface ReizigerDao {
	public List<Reiziger> findAll();
	public List<Reiziger> findAllByGBdatum(String GBdatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
}
	