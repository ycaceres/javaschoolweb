package ns.javaschool.controller;

import ns.javaschool.repository.ToDoItemRepository;
import ns.javaschool.domain.ToDoItem;

import java.util.List;

public class ToDoListController {

    private ToDoItemRepository toDoItemRepository;

    private static ToDoListController instance;

    public static ToDoListController getInstance(){
        if(instance == null) {
            instance = new ToDoListController();
        }
        return instance;
    }

    private ToDoListController() {
        this.toDoItemRepository = ToDoItemRepository.getInstance();
    }

    public List<ToDoItem> getToDoItems() {
        return toDoItemRepository.getItems();
    }

    public void addToDoItem(String item) {
        toDoItemRepository.addItem(item);
    }
}
