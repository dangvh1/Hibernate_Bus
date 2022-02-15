package repository;

import entity.Driver;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.CollectionUtil;
import util.HibernateUtil;

import java.util.List;

public class DriverDAO {
    public void addNewDriver(List<Driver> drivers) {
        if (CollectionUtil.isEmpty(drivers)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            drivers.forEach(session::save);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        }
    }
}
