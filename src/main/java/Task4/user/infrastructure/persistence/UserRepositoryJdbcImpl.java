package Task4.user.infrastructure.persistence;

import Task4.user.domain.User;
import Task4.user.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_2026";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Buralova2007";

    @Override
    public void save(User user) {
        // Заглушка
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT id, email, password, profile_description, first_name, last_name, age FROM users";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String profileDescription = resultSet.getString("profile_description");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");

                User user = new User(id, email, password, profileDescription, firstName, lastName, age);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при получении пользователей: " + e.getMessage(), e);
        }

        return users;
    }
}