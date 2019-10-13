package by.it;

import by.it.entity.Person;
import by.it.entity.Status;
import by.it.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

public class SessionFactoryTest {

    @Test
    public void save() {
        Session session = HibernateUtil.getSession();
        Person person = new Person(null, 50, "Test", "Test", null);
        person.setStatus(Status.OPEN);
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void update() {
        final Person person = savePerson();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        person.setAge(29);
        session.saveOrUpdate(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void delete() {
        Person person = savePerson();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        person = session.get(Person.class, person.getId());
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void read() {
        final Person person = savePerson();

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.get(Person.class, person.getId());
        session.getTransaction().commit();
        session.close();
    }

    private Person savePerson() {
        Session session = HibernateUtil.getSession();
        Person person = new Person(null, 50, "Test", "Test", null);
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }
}
