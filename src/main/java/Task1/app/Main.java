package Task1.app;


import Task1.user.api.UserConsoleOperations;
import Task1.user.infrostructure.persistence.UserDatabaseRepository;
import Task1.user.infrostructure.persistence.UserFileRepository;

public class Main {
    public static void main(String[] args) {
        UserFileRepository userFileRepository = new UserFileRepository("user.txt");
        UserDatabaseRepository userDatabaseRepository = new UserDatabaseRepository();
        UserConsoleOperations operations = new UserConsoleOperations(userFileRepository);

        while (true) {
            operations.showMenu();
        }
    }
}
