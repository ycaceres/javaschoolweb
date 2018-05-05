package ns.javaschool.controller;

import ns.javaschool.dao.ToDoItemDAO;

import java.util.List;

public class ToDoListController {

    private ToDoItemDAO toDoItemDAO;

    private static ToDoListController instance;

    public static ToDoListController getInstance(){
        if(instance == null) {
            instance = new ToDoListController();
        }
        return instance;
    }

    private ToDoListController() {
        this.toDoItemDAO = ToDoItemDAO.getInstance();
    }

    public List<String> getToDoItems() {
        return toDoItemDAO.getItems();
    }

    public void addToDoItem(String item) {
        toDoItemDAO.addItem(item);
    }
}
