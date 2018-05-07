package ns.javaschool.dao;

import ns.javaschool.conf.DataBaseManager;
import ns.javaschool.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {

    private static final String SELECT = "SELECT * FROM user";
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS user; CREATE TABLE user ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), username VARCHAR(100), password VARCHAR(100))";
    private static final String INSERT = "INSERT INTO user (name, username, password) VALUES (?,?,?)";
    private static final String SELECT_BY_USERNAME_PASSWORD = "SELECT * FROM user WHERE username=? and password=?";

    private static UserDAO instance;

    private UserDAO(){
        init();
    }

    private void init() {
        try{
            Connection connection = DataBaseManager.getConnection();
            PreparedStatement query = connection.prepareStatement(CREATE_TABLE);
            query.executeUpdate();
            query.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static UserDAO getInstance(){
        if(instance == null){
            instance = new UserDAO();
        }
        return instance;
    }

    public List<User> listAll(){
        List<User> users = new ArrayList<>();
        try{
            Connection connection = DataBaseManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                users.add(parseResultSet(resultSet));
            }
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            users = Collections.EMPTY_LIST;
        }
        return users;
    }

    public void create(User user){
        try{
            Connection connection = DataBaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User findByUsernameAndPassword(final String username, final String password){
        User user = null;
        try{
            Connection connection = DataBaseManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SELECT_BY_USERNAME_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = parseResultSet(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    private User parseResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("name"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    public void delete(User user) {
        // TODO implementation
    }

    public void update(User user) {
        // TODO implementation
    }
}
