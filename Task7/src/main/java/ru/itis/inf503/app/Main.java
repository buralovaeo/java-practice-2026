package ru.itis.inf503.app;

import ru.itis.inf503.infrastructure.persistence.jdbc.DriverManagerDataSource;
import ru.itis.inf503.user.api.UserConsoleOperations;
import ru.itis.inf503.user.application.UserService;
import ru.itis.inf503.user.infrastructure.persistence.UserRepositoryJdbcImpl;
import ru.itis.inf503.user.repository.UserRepository;
import ru.itis.inf503.util.PropertiesReader;

import javax.sql.DataSource;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        PropertiesReader propertiesReader = new PropertiesReader("application.properties");
        Properties properties = propertiesReader.loadProperties();

        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");

        DataSource dataSource = new DriverManagerDataSource(dbUrl, dbUser, dbPassword);
        UserRepository userRepository = new UserRepositoryJdbcImpl(dataSource);
        UserService userService = new UserService(userRepository);

        UserConsoleOperations consoleOperations = new UserConsoleOperations(userService);

        while (true) {
            consoleOperations.showMenu();
        }
    }
}