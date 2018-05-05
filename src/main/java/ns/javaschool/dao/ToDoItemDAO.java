package ns.javaschool.dao;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class ToDoItemDAO {

    private static ToDoItemDAO instance;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/javaschool";

    static final String USER = "username";
    static final String PASS = "password";

    private Connection connection;
    private Statement statement;

    private static final String fileName = "resources/to_do_items.txt";

    private ToDoItemDAO() {
        init();
    }

    private void init() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ToDoItemDAO getInstance() {
        if (instance == null) {
            instance = new ToDoItemDAO();
        }
        return instance;
    }

    public List<String> getItems() {
        //ToDo implement this
        return Collections.emptyList();
    }

    public void addItem(String item) {
        //ToDo implement this
    }
}
