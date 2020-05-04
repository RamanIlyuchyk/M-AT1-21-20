import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {
    Connect connect = new Connect();

    public void dropTable() throws SQLException {
        connect.statement(Query.DROP_TABLE).executeUpdate();
    }

    public void createTable() throws SQLException {
        connect.statement(Query.CREATE_TABLE).executeUpdate();
    }

    public void insertUsers(int quantity,
                            int loginInclusiveMinimum,
                            int loginExclusiveMaximum,
                            int passwordInclusiveMinimum,
                            int passwordExclusiveMaximum) throws SQLException {
        PreparedStatement statement = connect.statement(Query.INSERT_USERS);
        for (int i = 0; i < quantity; i++) {
            statement.setString(1, Generator.generateLogin(loginInclusiveMinimum, loginExclusiveMaximum));
            statement.setString(2, Generator.generatePassword(passwordInclusiveMinimum, passwordExclusiveMaximum));
            statement.executeUpdate();
        }
    }

    public void selectUsers(String query) {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = connect.resultSet(query);
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        users.forEach(user -> System.out.println(user.toString()));
    }
}