
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author data1
 */
public class HibernateConnection {

    private static SessionFactory sessionFactory;

    private HibernateConnection() {
    }

    public static SessionFactory getSessionInstance() {
        if (sessionFactory == null) {
            return new Configuration().configure().buildSessionFactory();
        } else {
            return sessionFactory;
        }

    }
}
