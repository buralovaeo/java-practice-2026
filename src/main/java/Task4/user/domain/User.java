package Task4.user.domain;

public class User {

    private String id;
    private String email;
    private String password;
    private String profileDescription;
    private String firstName;
    private String lastName;
    private int age;

    public User(String id, String email, String password, String profileDescription,
                String firstName, String lastName, int age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profileDescription = profileDescription;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Старый конструктор (для обратной совместимости)
    public User(String id, String email, String password, String profileDescription) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profileDescription = profileDescription;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    public User(String email, String password, String profileDescription) {
        this.email = email;
        this.password = password;
        this.profileDescription = profileDescription;
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    // Геттеры и сеттеры
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getProfileDescription() { return profileDescription; }
    public void setProfileDescription(String profileDescription) { this.profileDescription = profileDescription; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}