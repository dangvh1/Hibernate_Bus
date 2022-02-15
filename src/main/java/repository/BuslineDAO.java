package repository;

import entity.Busline;
import org.hibernate.Session;
import util.CollectionUtil;
import util.HibernateUtil;

import java.util.List;

public class BuslineDAO {
    public void addNewBusline(List<Busline> buslines) {
        if (CollectionUtil.isEmpty(buslines)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            buslines.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        }
    }
}
