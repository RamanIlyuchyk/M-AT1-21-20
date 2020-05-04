import java.sql.SQLException;

public class GetData {
    private static final int QUANTITY_OF_USERS = 10;
    private static final int LOGIN_INCLUSIVE_MINIMUM = 3;
    private static final int LOGIN_EXCLUSIVE_MAXIMUM = 6;
    private static final int PASSWORD_INCLUSIVE_MINIMUM = 8;
    private static final int PASSWORD_EXCLUSIVE_MAXIMUM = 15;

    public static void main(String[] args) throws SQLException {
        Operation operation = new Operation();
        operation.dropTable();
        operation.createTable();
        operation.insertUsers(QUANTITY_OF_USERS,
                LOGIN_INCLUSIVE_MINIMUM,
                LOGIN_EXCLUSIVE_MAXIMUM,
                PASSWORD_INCLUSIVE_MINIMUM,
                PASSWORD_EXCLUSIVE_MAXIMUM);
        operation.selectUsers(Query.SELECT_USERS);
    }
}