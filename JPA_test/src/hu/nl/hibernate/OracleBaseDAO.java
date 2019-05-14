package hu.nl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OracleBaseDAO {
	@SuppressWarnings("unused")

	private static StandardServiceRegistry ssr = null;
	private static Metadata meta = null;
	private static SessionFactory factory = null;
	private static Session session = null;

	private static StandardServiceRegistry getSSRInstance() {
		if (ssr == null) {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		}

		return ssr;
	}

	private static Metadata getMetaInstance() {
		if (meta == null) {
			meta = new MetadataSources(getSSRInstance()).getMetadataBuilder().build();
		}
		return meta;
	}

	private static SessionFactory getFactoryInstance() {
		if (factory == null) {
			factory = getMetaInstance().getSessionFactoryBuilder().build();
		}
		return factory;
	}

	protected static Session getSession() {
		return getFactoryInstance().openSession();
	}

	protected void CloseConnection() {
		if (session != null) {
			session.close();
		}
	}
}