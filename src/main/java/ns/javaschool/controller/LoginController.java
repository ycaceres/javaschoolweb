package ns.javaschool.controller;


import java.util.List;

import ns.javaschool.dao.LoginDAO;
import ns.javaschool.domain.User;

public class LoginController {

    private LoginDAO dao;

    private static LoginController instance;

    public static LoginController getInstance(){
        if(instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    private LoginController(){
        dao = LoginDAO.getInstance();
    }

    public User load(String userName) {
        return this.dao.load(userName);
    }

    public List<User> loadAll() {
        return this.dao.loadAll();
    }

    public void save(User user) {
        this.dao.save(user);
    }

    public void delete(User user) {
        this.dao.delete(user);
    }

    public void update(User user) {
        this.dao.update(user);
    }

    public boolean canLogin(String user, String password) {
        return dao.canLogin(user, password);
    }
}
