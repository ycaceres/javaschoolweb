package ns.javaschool.repository;

import ns.javaschool.conf.HibernateUtils;
import ns.javaschool.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserRepository {

    private static UserRepository instance;

    private UserRepository(){ }

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public List<User> listAll(){
        Session session = HibernateUtils.openSession();
        List<User> users = session.createQuery("FROM User").list();
        session.close();
        System.out.println("Found " + users.size() + " Users");
        return users;
    }

    public void create(User user){
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + user.toString());

    }

    public User findByUsernameAndPassword(final String username, final String password){
        Session session = HibernateUtils.openSession();
        Query query = session.createQuery("FROM User WHERE username = :username AND password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<User> users = query.list();
        session.close();
        return users.size() > 0 ? users.get(0) : null;
    }

    public User findByID(Long id) {
        Session session = HibernateUtils.openSession();
        User user = session.load(User.class, id);
        session.close();
        return user;
    }

    public void delete(Long id) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + user.toString());
    }

    public void update(User u) {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, u.getId());
        user.setName(u.getName());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + user.toString());
    }
}
