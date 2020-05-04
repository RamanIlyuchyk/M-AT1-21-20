import org.apache.commons.lang3.RandomStringUtils;

public class Generator {
    public static String generateLogin(int loginInclusiveMinimum, int loginExclusiveMaximum) {
        return RandomStringUtils.randomAlphabetic(loginInclusiveMinimum, loginExclusiveMaximum);
    }

    public static String generatePassword(int passwordInclusiveMinimum, int passwordExclusiveMaximum) {
        return RandomStringUtils.randomAlphabetic(passwordInclusiveMinimum, passwordExclusiveMaximum);
    }
}