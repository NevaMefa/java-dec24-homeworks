package ru.otus.java.basic.homeworks.homework17.postgres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJdbc implements UserExample {
    private static final String USERS_QUERY = "select * from users";
    private static final String USERS_ROLES_QUERY = """
            select r.id, r.name from roles r
            join users_to_roles ur on r.id = ur.role_id
            where user_id = ?
            """;
    private static final String IS_ADMIN_QUERY = """
            select count(1) from roles r
            join users_to_roles ur on r.id = ur.role_id
            where user_id = ? and r.name = 'admin'
            """;
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD =
            "SELECT id, email, password FROM users WHERE email = ? AND password = ?";
    private static final String GetCHECK_IF_EMAIL_EXISTSUsers =
            "SELECT COUNT(1) FROM users WHERE email = ?";
    private static final String CHECK_IF_USERNAME_EXISTS =
            "SELECT COUNT(1) FROM users WHERE username = ?";
    private static final String INSERT_NEW_USER =
            "INSERT INTO users (email, password, username) VALUES (?, ?, ?) RETURNING id";
    private static final String ASSIGN_ROLE_TO_USER =
            "INSERT INTO users_to_roles (user_id, role_id) " + "SELECT ?, id FROM roles WHERE name = ?";
    private static final String InsertUsersRolesId =
            "SELECT r.id, r.name FROM roles r " +
                    "JOIN users_to_roles ur ON r.id = ur.role_id WHERE ur.user_id = ?";
    private final Connection connection;
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

    public UserServiceJdbc() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, "testuser", "testpass");
    }


    public User getUserByLoginAndPassword(String login, String password) {
        try (PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("password"),
                            rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting user: " + e.getMessage());
        }
        return null;
    }

    public boolean isLoginExists(String login) {
        try (PreparedStatement stmt = connection.prepareStatement(GetCHECK_IF_EMAIL_EXISTSUsers)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean isUsernameExists(String username) {

        try (PreparedStatement stmt = connection.prepareStatement(CHECK_IF_USERNAME_EXISTS)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int registerUser(String login, String password, String username) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_NEW_USER)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            stmt.setString(3, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        throw new SQLException("Ошибка при регистрации пользователя");
    }

    public void assignUserRole(int userId, String role) throws SQLException {

        try (PreparedStatement stmt = connection.prepareStatement(ASSIGN_ROLE_TO_USER)) {
            stmt.setInt(1, userId);
            stmt.setString(2, role);
            stmt.executeUpdate();
        }
    }


    public List<Role> getRolesForUser(int userId) throws SQLException {
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(InsertUsersRolesId)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    roles.add(new Role(rs.getInt("id"), rs.getString("name")));
                }
            }
        }
        return roles;
    }

    @Override
    public List<User> getAll() {
        List<User> allUser = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(USERS_QUERY)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String password = rs.getString(2);
                    String email = rs.getString(3);
                    User newUserByQuery = new User(id, password, email);
                    allUser.add(newUserByQuery);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement ps = connection.prepareStatement(USERS_ROLES_QUERY)) {
            for (User currentUser : allUser) {
                ps.setInt(1, currentUser.getId());
                List<Role> roleUserByQuery = new ArrayList<>();
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        Role currentRole = new Role(id, name);
                        roleUserByQuery.add(currentRole);
                    }
                    currentUser.setRoles(roleUserByQuery);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUser;
    }

    @Override
    public boolean isAdmin(int userId) {
        int flag = 0;
        try (PreparedStatement ps = connection.prepareStatement(IS_ADMIN_QUERY)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag == 1;
    }
}
