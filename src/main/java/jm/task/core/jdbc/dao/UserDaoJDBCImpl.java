package jm.task.core.jdbc.dao;

import com.mysql.cj.jdbc.ConnectionGroupManager;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {
      }
      Connection connection = getConnect();

    public void createUsersTable() {
        String sql = "Create table IF NOT EXISTS kata(" +
                " id INT PRIMARY KEY AUTO_INCREMENT," +
                " name VARCHAR(40) NOT NULL," +
                " lastName VARCHAR(40) NOT NULL," +
                " age int(3) NOT NULL);";
        try(Statement statement = connection.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void dropUsersTable() {
        String sql = """
        DROP TABLE IF EXISTS kata;
         """;
           try(Statement statement = connection.createStatement()){
              statement.execute(sql);
          } catch (SQLException e) {
               throw new RuntimeException(e);
    }

        }


    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO kata(name, lastName, age) values (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeUserById(long id) {
        String sql = " DELETE  FROM kata where id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM kata;";
List<User> users = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next() ){
                User user1 = new User(resultSet.getString("name"),resultSet.getString("lastName")
                        ,resultSet.getByte("age"));
                user1.setId(resultSet.getLong("id"));
                users.add(user1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = """
               TRUNCATE kata;
                """;
        try(Statement statement = connection.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
