import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private static final String PASS_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final int LOGIN_LENGTH = 5;
    private static final int PWD_LENGTH = 12;

    public static Map<String, String> getListOfUsers(int quantity) {
        Map<String, String> listOfUsers = new HashMap<>();
        String login;
        String password;
        for (int i = 0; i < quantity; i++) {
            login = generateLogin();
            password = generatePassword();
            listOfUsers.put(login, password);
        }
        return listOfUsers;
    }

    public static String generateLogin() {
        StringBuilder login = new StringBuilder(LOGIN_LENGTH);
        for (int i = 0; i < LOGIN_LENGTH; i++) {
            login.append(PASS_CHARS.charAt(ThreadLocalRandom.current().nextInt(0, PASS_CHARS.length())));
        }
        return login.toString();
    }

    public static String generatePassword() {
        String password = UUID.randomUUID().toString().substring(0, PWD_LENGTH);
        password = password.replace("-", "");
        return password;
    }
}