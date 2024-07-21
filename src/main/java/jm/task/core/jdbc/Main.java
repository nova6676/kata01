package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vladislav", "Gusto", (byte)34);
        userService.saveUser("Oleg", "Franklin", (byte)43);
        userService.saveUser("Fedor", "Lens", (byte)23);
        userService.saveUser("Aleksandr", "Kouch", (byte)13);
        List<User> allUsers = userService.getAllUsers();
        for (User i : allUsers) {
            System.out.println(i);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
        // реализуйте алгоритм здесь


