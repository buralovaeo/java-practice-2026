package Task4.app;

import Task4.user.api.UserConsoleOperations;
import Task4.user.application.UserService;
import Task4.user.infrastructure.persistence.UserJdbcRepository;

public class Main {
    public static void main(String[] args) {
        UserJdbcRepository userJdbcRepository = new UserJdbcRepository();
        UserService userService = new UserService(userJdbcRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}