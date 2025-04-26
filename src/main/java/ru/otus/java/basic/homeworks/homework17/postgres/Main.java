package ru.otus.java.basic.homeworks.homework17.postgres;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceJdbc userServiceJdbc = new UserServiceJdbc();
        List<User> userByQuery = userServiceJdbc.getAll();
        System.out.println("userByQuery = " + userByQuery);
        for (User user : userByQuery) {
            System.out.println("Пользователь с id "+user.getId() +
                    " является админом ?  " + userServiceJdbc.isAdmin(user.getId()));
        }
    }
}