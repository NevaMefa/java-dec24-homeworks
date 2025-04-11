package ru.otus.java.basic.homeworks.homework17.server;

import ru.otus.java.basic.homeworks.homework17.postgres.Role;
import ru.otus.java.basic.homeworks.homework17.postgres.UserServiceJdbc;
import ru.otus.java.basic.homeworks.homework17.postgres.User;
import java.sql.SQLException;
import java.util.List;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {
    private Server server;
    private UserServiceJdbc userServiceJdbc;


    private class AuthUser {
        private String login;
        private String password;
        private String username;
        private String role;

        public AuthUser(String login, String password, String username, String role) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.role = role;
        }


    }
    private List<AuthUser> users;

    public InMemoryAuthenticatedProvider(Server server) {
//        this.server = server;
//        this.users = new CopyOnWriteArrayList<>();
//        this.users.add(new User("qwe", "qwe", "qwe1", "ADMIN"));
//        this.users.add(new User("asd", "asd", "asd1", "USER"));
//        this.users.add(new User("zxc", "zxc", "zxc1", "USER"));
        this.server = server;
        try {
            this.userServiceJdbc = new UserServiceJdbc(); // Подключаемся к базе данных
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        System.out.println("initialize InMemoryAuthenticatedProvider");
    }

    private String getRoleByUser(int userId) {
        try {
            List<Role> roles = userServiceJdbc.getRolesForUser(userId);
            for (Role role : roles) {
                if (role.getName().equals("ADMIN")) {
                    return "ADMIN";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "USER";
    }

//    private String getUsernameByLoginAndPassword(String login, String password) {
//        for (User user : users) {
//            if (user.login.equals(login) && user.password.equals(password)) {
//                return user.username;
//            }
//        }
//        return null;
//    }
//
//    private boolean isLoginAlreadyExist(String login) {
//        for (User user : users) {
//            if (user.login.equals(login)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isUsernameAlreadyExist(String username) {
//        for (User user : users) {
//            if (user.username.equals(username)) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean authenticate(ClientHand clientHandler, String login, String password) {
//        String authUsername = getUsernameByLoginAndPassword(login, password);
//        if (authUsername == null) {
//            clientHandler.sendMsg("Некорректный логин/пароль");
//            return false;
//        }
//        if (server.isUsernameBusy(authUsername)) {
//            clientHandler.sendMsg("Данная учетная запись уже занята");
//            return false;
//        }
//
//        clientHandler.setUsername(authUsername);
//        clientHandler.setRole(getRoleByUser(authUsername));
//
//        System.out.println(authUsername + " вошел с ролью: " + clientHandler.getRole());
//
//        server.subscribe(clientHandler);
//        clientHandler.sendMsg("/authok " + authUsername);
//        return true;
        User user = userServiceJdbc.getUserByLoginAndPassword(login, password);
        if (user == null) {
            clientHandler.sendMsg("Некорректный логин/пароль");
            return false;
        }

        // Проверяем, если этот username занят
        if (server.isUsernameBusy(user.getEmail())) {
            clientHandler.sendMsg("Данная учетная запись уже занята");
            return false;
        }

        clientHandler.setUsername(user.getEmail());
        clientHandler.setRole(getRoleByUser(user.getId()));

        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + user.getEmail());
        return true;
    }

    @Override
    public boolean registration(ClientHand clientHandler, String login, String password, String username) {
//        if (login.trim().length() < 3 || password.trim().length() < 3 || username.trim().length() < 3) {
//            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
//            return false;
//        }
//        if (isLoginAlreadyExist(login)) {
//            clientHandler.sendMsg("Указанный логин уже занят");
//            return false;
//        }
//        if (isUsernameAlreadyExist(username)) {
//            clientHandler.sendMsg("Указанное имя пользователя уже занято");
//            return false;
//        }
//        users.add(new User(login, password, username, "USER"));
//        clientHandler.setUsername(username);
//        server.subscribe(clientHandler);
//        clientHandler.sendMsg("/regok " + username);
//        return true;

        if (login.trim().length() < 3 || password.trim().length() < 3 || username.trim().length() < 3) {
            clientHandler.sendMsg("Логин, пароль и имя пользователя должны быть длиной 3+ символа");
            return false;
        }

        // Проверка на существование логина или имени
        if (userServiceJdbc.isLoginExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (userServiceJdbc.isUsernameExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }

        // Добавляем нового пользователя в БД
        try {
            int userId = userServiceJdbc.registerUser(login, password, username);  // Записываем в БД
            clientHandler.setUsername(username);  // Устанавливаем имя пользователя

            // Присваиваем роль по умолчанию
            userServiceJdbc.assignUserRole(userId, "USER");

            // Уведомляем об успешной регистрации
            server.subscribe(clientHandler);
            clientHandler.sendMsg("/regok " + username);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            clientHandler.sendMsg("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }
}
