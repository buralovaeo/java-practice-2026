package Task6.app;

import Task6.infrastructure.persistence.jdbc.DriverManagerDataSource;
import Task6.user.api.UserConsoleOperations;
import Task6.user.application.UserService;
import Task6.user.infrastructure.persistence.UserRepositoryJdbcImpl;
import Task6.user.repository.UserRepository;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/shop_db",
                "postgres",
                "Buralova2007"
        );

        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);
        UserService userService = new UserService(userRepository);
        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}