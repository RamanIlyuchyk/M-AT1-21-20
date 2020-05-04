import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getSha1Password() {
        return DigestUtils.sha1Hex(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User #" + getId() + ": login - " + getLogin() + ", Sha1 password - " + getSha1Password() + ", normal password - " + getPassword();
    }
}