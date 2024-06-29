package vetclinic;

import vetclinic.model.User;

public class Session {
    private static User user;

    public static void setUser(User user) {
        Session.user = user;
    }

    public static int getUserId() {
        return user.getUserId();
    }

    public static String getUserPhone() {
        return user.getPhoneNumber();
    }

    public static boolean validate(User user) {
        return user.getLogin().equals(Session.user.getLogin()) && user.getPasswordHash().equals(Session.user.getPasswordHash());
    }

    public static boolean validate(String login, String passwordHash) {
        return user.getLogin().equals(login) && user.getPasswordHash().equals(passwordHash);
    }
}
