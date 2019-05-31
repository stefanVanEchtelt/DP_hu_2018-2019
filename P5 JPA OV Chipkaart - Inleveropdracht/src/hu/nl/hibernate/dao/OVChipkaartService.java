package hu.nl.hibernate.dao;


import java.util.List;
import hu.nl.hibernate.OVChipkaart;

public class OVChipkaartService {

    private static OVChipkaartService instance;

    private OVChipkaartDao ovChipkaartDao;

    public static OVChipkaartService getInstance() {
        if (instance == null)
            instance = new OVChipkaartService();
        return instance;
    }

    public OVChipkaartService() {
        ovChipkaartDao = new OVChipkaartDao();
    }

    public void persist(OVChipkaart entity) {
        ovChipkaartDao.openCurrentSessionwithTransaction();
        ovChipkaartDao.persist(entity);
        ovChipkaartDao.closeCurrentSessionwithTransaction();
    }

    public void update(OVChipkaart entity) {
        ovChipkaartDao.openCurrentSessionwithTransaction();
        ovChipkaartDao.update(entity);
        ovChipkaartDao.closeCurrentSessionwithTransaction();
    }

    public OVChipkaart findById(int id) {
        ovChipkaartDao.openCurrentSession();
        OVChipkaart ovChipkaart = ovChipkaartDao.findById(id);
        ovChipkaartDao.closeCurrentSession();
        return ovChipkaart;
    }

    public void delete(int id) {
        ovChipkaartDao.openCurrentSessionwithTransaction();
        OVChipkaart ovChipkaart = ovChipkaartDao.findById(id);
        ovChipkaartDao.delete(ovChipkaart);
        ovChipkaartDao.closeCurrentSessionwithTransaction();
    }

    public void delete(OVChipkaart ovChipkaart) {
        ovChipkaartDao.openCurrentSessionwithTransaction();
        ovChipkaartDao.delete(ovChipkaart);
        ovChipkaartDao.closeCurrentSessionwithTransaction();
    }

    public List<OVChipkaart> findAll() {
        ovChipkaartDao.openCurrentSession();
        List<OVChipkaart> ovChipkaarts = ovChipkaartDao.findAll();
        ovChipkaartDao.closeCurrentSession();
        return ovChipkaarts;
    }

    public void deleteAll() {
        ovChipkaartDao.openCurrentSessionwithTransaction();
        ovChipkaartDao.deleteAll();
        ovChipkaartDao.closeCurrentSessionwithTransaction();
    }

    public OVChipkaartDao getOvChipkaartDao() {
        return ovChipkaartDao;
    }
}
