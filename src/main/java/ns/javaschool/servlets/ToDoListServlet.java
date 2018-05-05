package ns.javaschool.servlets;

import ns.javaschool.controller.ToDoListController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToDoListServlet extends HttpServlet {

    private static ToDoListController toDoListController;

    @Override
    public void init() throws ServletException {
        toDoListController = ToDoListController.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        toDoListController.addToDoItem(req.getParameter("item"));
        setToDoListItems(req);
        resp.sendRedirect("/javaschool-web/toDoList.jsp");
    }

    private void setToDoListItems(HttpServletRequest req) {
        req.getSession().setAttribute("toDoListItems", toDoListController.getToDoItems());
    }
}
