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

    private LoginController controller;
    private ToDoListController toDoListController;

    @Override
    public void init() throws ServletException {
        Logger.getAnonymousLogger().log(Level.INFO, "Initializing JavaSchool Application...");
        controller = LoginController.getInstance();
        toDoListController = ToDoListController.getInstance();
        controller.save(new User("Perla Ruiz", "pruiz", "c690370286a1e8c9de5fb1ed2a2e0f3f"));
        controller.save(new User("Omar Bautista", "obautista", "70153a7dac38814f2f9545a6fe82d7ba"));
        controller.save(new User("Yander Caceres", "ycaceres", "78ea905bd1b100d9d77324c6f2f7be66"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/javaschool-web");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user");
        String pass = req.getParameter("password");

        if(controller.canLogin(name, pass)){
            req.getSession().setAttribute("user", controller.load(name));
            req.getSession().setAttribute("userList", controller.loadAll());
            req.getSession().setAttribute("toDoListItems", toDoListController.getToDoItems());
            resp.sendRedirect("/javaschool-web/dashboard.jsp");
        } else {
            resp.sendRedirect("/javaschool-web/login");
        }
    }


}
