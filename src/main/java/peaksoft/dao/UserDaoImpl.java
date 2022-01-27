package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("Таблица курулду");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Таблицы жок болду");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Юзер кошулду");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println(users.size());
        return users;
    }

    @Override
    public void removeUserByName() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("DELETE FROM User WHERE name = 'Aza'");
            query.executeUpdate();

            session.getTransaction().commit();
            session.close();
            System.out.println("Юзер жок болду ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void UpdateUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        String SQL = "UPDATE User SET age = 18 WHERE name = 'Aza'";
        session.createQuery(SQL).executeUpdate();

        session.getTransaction().commit();
        session.close();
        System.out.println("Юзер жаныртылды ");
    }

    @Override
    public List<User> getAllUser() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> user = session.createQuery("FROM User WHERE age > 20 AND name LIKE 'Aza'").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println(user.size());
        return user;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DELETE users").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Таблица тазаланды");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
