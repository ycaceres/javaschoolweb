package ns.javaschool.servlets;

import ns.javaschool.controller.LoginController;
import ns.javaschool.controller.ToDoListController;
import ns.javaschool.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginServlet extends HttpServlet {

    private LoginController loginController;
    private ToDoListController toDoListController;

    @Override
    public void init() throws ServletException {
        Logger.getAnonymousLogger().log(Level.INFO, "Initializing JavaSchool Application...");
        loginController = LoginController.getInstance();
        toDoListController = ToDoListController.getInstance();
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
