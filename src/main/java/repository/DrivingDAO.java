package repository;


import entity.DrivingEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class DrivingDAO {
    public void addNewDriving(List<DrivingEntity> drivingEntities) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            drivingEntities.forEach(session::save);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            assert session != null;
            session.close();
        }
    }
}
