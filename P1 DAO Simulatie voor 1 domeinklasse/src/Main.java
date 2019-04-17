import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) {
		try {
			ReizigerOracleDaolmpl db = new ReizigerOracleDaolmpl();
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			Reiziger r3 = new Reiziger();
			
			Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
			r1.setNaam("stefan van Echtelt");
			r1.setGBdatum(datum1);
			db.save(r1);
			
			r2.setNaam("testert der test");
			db.save(r2);

			r3.setNaam("Heyyy");
			db.save(r3);
			
			
			for (Reiziger r : db.findAll()) {
				System.out.println(r.getNaam());
			}
			System.out.println("all done");
			
			r1.setNaam("Stefan2");
			db.update(r1);
			
			for (Reiziger r : db.findAllByGBdatum(datum1.toString())) {
				System.out.println(r.getNaam());
				
			}
			System.out.println("by date done");
			
			db.delete(r3);
			for (Reiziger r : db.findAll()) {
				System.out.println(r.getNaam());
			}
			System.out.println("all done");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
