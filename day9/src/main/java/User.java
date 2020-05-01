public class User {
    private int userId;
    private String userLogin;
    private String userPassword;

    public User(int id, String login, String password) {
        setUserId(id);
        setUserLogin(login);
        setUserPassword(password);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User #" + this.userId + ": login - " + this.userLogin + ", password - " + this.userPassword;
    }
}