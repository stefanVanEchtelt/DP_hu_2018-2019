import java.util.List;

public interface OvChipkaartDao {
	public List<OvChipkaart> findByReiziger(int reizigerId);
	public OvChipkaart save(OvChipkaart ovChipkaart);
	public OvChipkaart update(OvChipkaart ovChipkaart);
	public boolean delete(OvChipkaart ovChipkaart);
}
