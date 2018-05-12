package ns.javaschool.controller;


import ns.javaschool.domain.User;
import ns.javaschool.repository.LoginRepository;
import ns.javaschool.service.TokenService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginController {

    private LoginRepository loginRepository;

    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
            //this ugliness is for practical purposes of the class.
            instance.save(new User("Perla Ruiz", "pruiz", "c690370286a1e8c9de5fb1ed2a2e0f3f"));
            instance
                    .save(new User("Omar Bautista", "obautista", "70153a7dac38814f2f9545a6fe82d7ba"));
            instance
                    .save(new User("Yander Caceres", "ycaceres", "78ea905bd1b100d9d77324c6f2f7be66"));

        }
        return instance;
    }

    private LoginController() {
        loginRepository = LoginRepository.getInstance();
    }

    public List<User> loadAll() {
        return this.loginRepository.loadAll();
    }

    public void save(User user) {
        this.loginRepository.save(user);
    }

    public void delete(User user) {
        this.loginRepository.delete(user);
    }

    public void update(User user) {
        this.loginRepository.update(user);
    }

    public User canLogin(String user, String password) {
        return loginRepository.canLogin(user, password);
    }

    public void canLoginApi(String name, String pass, HttpSession session, HttpServletResponse resp) throws IOException {
        User user = loginRepository.canLogin(name, pass);
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
