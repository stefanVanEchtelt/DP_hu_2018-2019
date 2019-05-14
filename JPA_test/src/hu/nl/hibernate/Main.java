package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	public static void main(String[] args) throws SQLException, ParseException {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Reiziger r = new Reiziger();
		r.setReizigerId(51);
		r.setAchternaam("Dijkstra");
		r.setGeboortedatum(new SimpleDateFormat("dd-mm-yy").parse("06-12-80"));
		r.setVoorletters("JW");

		session.save(r);
		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}
}