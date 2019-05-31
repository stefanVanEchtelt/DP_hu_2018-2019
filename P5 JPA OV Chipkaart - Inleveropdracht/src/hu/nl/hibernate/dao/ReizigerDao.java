package hu.nl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hu.nl.hibernate.HibernateUtil;
import hu.nl.hibernate.Reiziger;

import java.util.List;

public class ReizigerDao {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Reiziger entity) {
        getCurrentSession().save(entity);
    }

    public void update(Reiziger entity) {
        getCurrentSession().update(entity);
    }

    public Reiziger findById(int id) {
        return getCurrentSession().get(Reiziger.class, id);
    }

    public void delete(Reiziger entity) {
        getCurrentSession().delete(entity);
    }

    public List<Reiziger> findAll() {
        return (List<Reiziger>) getCurrentSession().createQuery("from Reiziger").list();
    }

    public void deleteAll() {
        List<Reiziger> entityList = findAll();
        for (Reiziger entity : entityList) {
            delete(entity);
        }
    }

}
