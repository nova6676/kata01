package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();
       userService.createUsersTable();
       userService.saveUser("USER","ISEsaR", (byte) 23);
        userService.saveUser("va","va", (byte) 22);
        userService.saveUser("Uss","ss", (byte) 13);
  //userService.cleanUsersTable();
       // userService.dropUsersTable();
        List<User> allUsers = userService.getAllUsers();
        for (User i : allUsers) {
            System.out.println(i);

        }
    }
        // реализуйте алгоритм здесь
    }

