package ns.javaschool.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ns.javaschool.controller.LoginController;
import ns.javaschool.domain.User;


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
        } else {
            printPageHeader(req, resp);
            printPageBody(req, resp);
        }
    }

    private void printPageBody(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = controller.loadAll();
        PrintWriter page = resp.getWriter();
        for (User u : users) {
            page.print(u + "<br/>");
        }
    }

    private void printPageHeader(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        resp.setContentType("text/html");
        PrintWriter page = resp.getWriter();
        String welcomeMessage = String.format("Welcome %s...", user);
        page.print(welcomeMessage);
        page.print(" [<a href='/javaschool-web/dashboard?logout'>logout</a>]");
        page.print("<br/> <br/>");
    }
}
