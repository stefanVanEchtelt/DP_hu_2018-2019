package hu.nl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hu.nl.hibernate.HibernateUtil;
import hu.nl.hibernate.OVChipkaart;

import java.util.List;

public class OVChipkaartDao {

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

    public void persist(OVChipkaart entity) {
        getCurrentSession().save(entity);
    }

    public void update(OVChipkaart entity) {
        getCurrentSession().update(entity);
    }

    public OVChipkaart findById(int id) {
        return getCurrentSession().get(OVChipkaart.class, id);
    }

    public void delete(OVChipkaart entity) {
        getCurrentSession().delete(entity);
    }

    public List<OVChipkaart> findAll() {
        return (List<OVChipkaart>) getCurrentSession().createQuery("from OVChipkaart").list();
    }

    public void deleteAll() {
        List<OVChipkaart> entityList = findAll();
        for (OVChipkaart entity : entityList) {
            delete(entity);
        }
    }

}
