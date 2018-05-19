package ns.javaschool.repository;

import ns.javaschool.conf.HibernateUtils;
import ns.javaschool.domain.ToDoItem;
import org.hibernate.Session;

import java.util.List;

public class ToDoItemRepository {

    private static ToDoItemRepository instance;

    private ToDoItemRepository() {

    }

    public static ToDoItemRepository getInstance() {
        if (instance == null) {
            instance = new ToDoItemRepository();
        }
        return instance;
    }

    public List<ToDoItem> getItems()  {
        Session session = HibernateUtils.openSession();
        @SuppressWarnings("unchecked")
        List<ToDoItem> items = session.createQuery("FROM ToDoItem").list();
        session.close();
        System.out.println("Found " + items.size() + " Items");
        return items;
    }

    public void addItem(String description)  {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setDescription(description);
        session.save(toDoItem);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + toDoItem.toString());

    }
}
