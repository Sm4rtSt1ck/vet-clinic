package vetclinic.model;

public class User {
    private int userId;
    private String name;
    private String address;
    private String phoneNumber;
    private String login;
    private String passwordHash;
    private int accessLevel;



    public User(int id, String name, String address, String phoneNumber, String login, String passwordHash, int accessLevel) {
        this.userId = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.passwordHash = passwordHash;
        this.accessLevel = accessLevel;
    }

    public String getLogin() {
        return login;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public int getAccessLevel() {
        return accessLevel;
    }
    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
