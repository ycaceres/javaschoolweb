package ns.javaschool.dao;

import java.util.ArrayList;
import java.util.List;

import ns.javaschool.domain.User;

public class LoginDAO {

    private static LoginDAO instance;

    private List<User> users;

    public static LoginDAO getInstance() {
        if (instance == null) {
            instance = new LoginDAO();
        }
        return instance;
    }

    private LoginDAO() {
        this.users = new ArrayList<User>();
    }

    public User load(String userName) {
        for(User u : this.users) {
            if(u.getUserName().equals(userName)) {
                return u;
            }
        }
        return null;
    }

    public List<User> loadAll() {
        return this.users;
    }

    public void save(User user) {
        this.users.add(user);
    }

    public void delete(User user) {
        this.users.remove(user);
    }

    public void update(User user) {

    }

    public boolean canLogin(String userName, String password) {
        for(User u : this.users) {
            if(u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
