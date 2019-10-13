package by.it.util;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("by.it");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public static Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }

    public static void close() {
        emFactory.close();
    }

}
