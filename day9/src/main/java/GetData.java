import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import statements.SimpleStatement;
import statements.PrepStatement;

public class GetData {
    private static final int QUANTITY = 10;

    public static void main(String[] args) throws SQLException {
        String dropUsers = "DROP TABLE users;";
        String createUsers = "CREATE TABLE IF NOT EXISTS `users` (\n" +
                " `user_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                " `user_login` varchar(255) NOT NULL,\n" +
                " `user_password` char(40) NOT NULL,\n" +
                " PRIMARY KEY (`user_id`)\n" +
                ");";
        String insertUsers = "INSERT INTO `users` (`user_login`, `user_password`) VALUES (?, ?);";
        String selectUsers = "SELECT * FROM users;";
        ConnectionOptions connectionOptions = new ConnectionOptions();
        Connection connection = connectionOptions.createConnection();
        SimpleStatement simpleStatement = new SimpleStatement(connection);
        simpleStatement.executeUpdateStatement(dropUsers);
        simpleStatement.executeUpdateStatement(createUsers);
        PrepStatement prepStatement = new PrepStatement(connection, insertUsers);
        Map<String, String> listOfUsers = Generator.getListOfUsers(QUANTITY);
        listOfUsers.forEach((k, v) -> {
            try {
                prepStatement.executeUpdateStatement(k, v);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        ResultSet rs = simpleStatement.executeStatement(selectUsers);
        printUsers(rs);
        simpleStatement.closeStatement();
        prepStatement.closeStatement();
        connectionOptions.closeConnection();
    }

    private static void printUsers(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}