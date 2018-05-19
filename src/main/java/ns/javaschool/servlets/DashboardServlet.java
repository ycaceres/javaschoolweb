package ns.javaschool.servlets;

import ns.javaschool.controller.LoginController;
import ns.javaschool.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DashboardServlet extends HttpServlet {

    LoginController controller = LoginController.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("logout") != null) {
            req.getSession().invalidate();
            resp.sendRedirect("/javaschool-web");
        }else {
            String action = req.getParameter("action");
            switch (action) {
                case "add":
                    resp.sendRedirect("/javaschool-web/userform.jsp");
                    break;
                case "save":
                    String name = req.getParameter("name");
                    String user = req.getParameter("user");
                    String password = req.getParameter("password");
                    LoginController.getInstance().save(new User(name, user, password));
                default:
                    req.getSession().setAttribute("userList", LoginController.getInstance().loadAll());
                    resp.sendRedirect("/javaschool-web/dashboard.jsp");
            }
        }
    }
}
