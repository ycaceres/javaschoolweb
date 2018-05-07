package ns.javaschool.controller;


import java.util.List;

import ns.javaschool.service.LoginService;
import ns.javaschool.domain.User;

public class LoginController {

    private LoginService loginService;

    private static LoginController instance;

    public static LoginController getInstance(){
        if(instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    private LoginController(){
        loginService = LoginService.getInstance();
    }

    public List<User> loadAll() {
        return this.loginService.loadAll();
    }

    public void save(User user) {
        this.loginService.save(user);
    }

    public void delete(User user) {
        this.loginService.delete(user);
    }

    public void update(User user) {
        this.loginService.update(user);
    }

    public User canLogin(String user, String password) {
        return loginService.canLogin(user, password);
    }
}
