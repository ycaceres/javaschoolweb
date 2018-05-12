package ns.javaschool.repository;

import ns.javaschool.dao.UserDAO;
import ns.javaschool.domain.User;

import java.util.List;

public class LoginRepository {

    private static LoginRepository instance;
    private static UserDAO userDAO;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    private LoginRepository() {
        userDAO = UserDAO.getInstance();
    }

    public List<User> loadAll() {
        return userDAO.listAll();
    }

    public void save(User user) {
        userDAO.create(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public User canLogin(String userName, String password) {
        return userDAO.findByUsernameAndPassword(userName, password);
    }
}
