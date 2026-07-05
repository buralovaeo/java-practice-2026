package Task4.app;


import Task4.user.api.UserConsoleOperations;
import Task4.user.application.UserService;
import Task4.user.infrastructure.persistence.UserFileRepository;
import Task4.user.infrastructure.persistence.UserMapper;

public class Main {
    public static void main(String[] args) {
        UserFileRepository userFileRepository = new UserFileRepository("users.txt", new UserMapper());
        UserService userService = new UserService(userFileRepository);

        UserConsoleOperations operations = new UserConsoleOperations(userService);

        while (true) {
            operations.showMenu();
        }
    }
}
