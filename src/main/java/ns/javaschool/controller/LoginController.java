package ns.javaschool.controller;


import ns.javaschool.domain.User;
import ns.javaschool.service.LoginService;
import ns.javaschool.service.TokenService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
        return loginService.loadAll();
    }

    public void save(User user) {
        loginService.save(user);
    }

    public void delete(Long id) {
        loginService.delete(id);
    }

    public void update(User user) {
        loginService.update(user);
    }

    public User canLogin(String user, String password) {
        return loginService.canLogin(user, password);
    }

    public void canLoginApi(String name, String pass, HttpSession session, HttpServletResponse resp) throws IOException {
        User user = loginService.canLogin(name, pass);
        ServletOutputStream sout = resp.getOutputStream();
        if (user != null) {
            String token = TokenService.generateToken();
            session.setAttribute("token", token);
            resp.setContentType("text/plain;charset=UTF-8");
            resp.setStatus(200);
            sout.print(token);
        } else {
            resp.setStatus(403);
            sout.print("UNAUTHORIZED");
        }
    }
}
