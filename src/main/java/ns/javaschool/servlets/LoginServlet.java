package ns.javaschool.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ns.javaschool.controller.LoginController;
import ns.javaschool.controller.ToDoListController;
import ns.javaschool.domain.User;


public class LoginServlet extends HttpServlet {

    private LoginController loginController;
    private ToDoListController toDoListController;

    @Override
    public void init() throws ServletException {
        Logger.getAnonymousLogger().log(Level.INFO, "Initializing JavaSchool Application...");
        loginController = LoginController.getInstance();
        toDoListController = ToDoListController.getInstance();
        loginController.save(new User("Perla Ruiz", "pruiz", "c690370286a1e8c9de5fb1ed2a2e0f3f"));
        loginController
                .save(new User("Omar Bautista", "obautista", "70153a7dac38814f2f9545a6fe82d7ba"));
        loginController
                .save(new User("Yander Caceres", "ycaceres", "78ea905bd1b100d9d77324c6f2f7be66"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/javaschool-web");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        String pass = req.getParameter("password");
        User user = loginController.canLogin(name, pass);

        if(user != null){
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("userList", loginController.loadAll());
            req.getSession().setAttribute("toDoListItems", toDoListController.getToDoItems());
            resp.sendRedirect("/javaschool-web/dashboard.jsp");
        } else {
            resp.sendRedirect("/javaschool-web/login");
        }
    }


}
