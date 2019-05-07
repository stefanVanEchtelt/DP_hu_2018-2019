import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
		try {
			ReizigerOracleDaolmpl db = new ReizigerOracleDaolmpl();		
			OvChipkaartOracleDaoLmpl dbo = new OvChipkaartOracleDaoLmpl();	
			
			OvChipkaart o1 = new OvChipkaart();
			o1.setKaartNummer(1231234);
			o1.setKlasse(1);
			o1.setReizigerId(2);
			o1.setSaldo(11.11);
			dbo.save(o1);
			
			for (OvChipkaart ov : dbo.findByReiziger(2)) {
				System.out.println(ov.getKaartNummer());
			}
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			Reiziger r3 = new Reiziger();
			
			Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
			r1.setNaam("S Echtelt");
			r1.setGBdatum(datum1);
			r1 = db.save(r1);
			
			r2.setNaam("T test");
			r2 = db.save(r2);

			r3.setNaam("Y Test2");
			r3 = db.save(r3);

			for (Reiziger r : db.findAll()) {
				System.out.println(r.getNaam());
			}

			System.out.println("all done");
			
			r1.setNaam("X Echtelt");
			db.update(r1);

			for (Reiziger r : db.findAllByGBdatum("03-12-2002")) {
				System.out.println(r.getNaam());
			}
			System.out.println("by date done");
			
			db.delete(r3);
			System.out.println("all done");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
