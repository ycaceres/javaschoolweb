package ns.javaschool.servlets;

import ns.javaschool.controller.LoginController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//This is behaving as a pseudo dispatcher servlet
public class ApiServlet extends HttpServlet {
    private static final String LOGIN_URI = "/login";
    private static final String DASHBOARD_URI = "/dashboard";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()) {
            case DASHBOARD_URI:
                resp.setStatus(200);
                resp.getOutputStream().print(LoginController.getInstance().loadAll().toString());
                break;
            default:
                resp.setStatus(404);
                resp.getOutputStream().print("Oops, not found");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()) {
            case LOGIN_URI:
                LoginController loginController = LoginController.getInstance();
                String name = req.getParameter("user");
                String pass = req.getParameter("password");
                loginController.canLoginApi(name, pass, req.getSession(), resp);
                break;
            default:
                resp.setStatus(404);
                resp.getOutputStream().print("Oops, not found");
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
