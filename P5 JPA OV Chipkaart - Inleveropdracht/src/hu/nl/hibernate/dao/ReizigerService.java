package hu.nl.hibernate.dao;

import java.util.List;
import hu.nl.hibernate.Reiziger;

public class ReizigerService {

    private static ReizigerService instance;

    private ReizigerDao reizigerDao;

    public static ReizigerService getInstance() {
        if (instance == null)
            instance = new ReizigerService();
        return instance;
    }

    public ReizigerService() {
        reizigerDao = new ReizigerDao();
    }

    public void persist(Reiziger entity) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.persist(entity);
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public void update(Reiziger entity) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.update(entity);
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public Reiziger findById(int id) {
        reizigerDao.openCurrentSession();
        Reiziger reiziger = reizigerDao.findById(id);
        reizigerDao.closeCurrentSession();
        return reiziger;
    }

    public void delete(int id) {
        reizigerDao.openCurrentSessionwithTransaction();
        Reiziger reiziger = reizigerDao.findById(id);
        reizigerDao.delete(reiziger);
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public void delete(Reiziger reiziger) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.delete(reiziger);
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public List<Reiziger> findAll() {
        reizigerDao.openCurrentSession();
        List<Reiziger> reizigers = reizigerDao.findAll();
        reizigerDao.closeCurrentSession();
        return reizigers;
    }

    public void deleteAll() {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.deleteAll();
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public ReizigerDao getReizigerDao() {
        return reizigerDao;
    }
}
