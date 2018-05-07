package ns.javaschool.dao;

import ns.javaschool.conf.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoItemDAO {

    private static ToDoItemDAO instance;

    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS to_do_items; CREATE TABLE to_do_items ( id INT PRIMARY KEY AUTO_INCREMENT, description VARCHAR(100), is_done BOOLEAN)";
    private static final String INSERT = "INSERT INTO to_do_items(description) VALUES (?)";

    private ToDoItemDAO() {
        init();
    }

    private void init() {
        try {
            Connection connection = DataBaseManager.getConnection();
            PreparedStatement query = connection.prepareStatement(CREATE_TABLE);
            query.executeUpdate();
            query = connection.prepareStatement(INSERT);
            query.setString(1, "Ir a la tienda.");
            query.executeUpdate();
            query.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ToDoItemDAO getInstance() {
        if (instance == null) {
            instance = new ToDoItemDAO();
        }
        return instance;
    }

    public List<String> getItems()  {
        List<String> items = new ArrayList<>();
        try{
            Connection connection = DataBaseManager.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM TO_DO_ITEMS");
            while(resultSet.next()){
                items.add(resultSet.getString("description"));
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            items = Collections.EMPTY_LIST;
        }
        return items;
    }

    public void addItem(String item)  {
        try{
            Connection connection = DataBaseManager.getConnection();
            final PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1,item);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
