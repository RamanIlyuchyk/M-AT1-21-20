package statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepStatement extends BaseStatement {
    Connection connection;
    PreparedStatement preparedStatement;
    String query;

    public PrepStatement(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    public void getPreparedStatement() throws SQLException {
        this.preparedStatement = this.connection.prepareStatement(query);
    }

    public void executeUpdateStatement(String login, String password) throws SQLException {
        getPreparedStatement();
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.executeUpdate();
    }

    public void closeStatement() throws SQLException {
        super.closeStatement(this.preparedStatement);
    }
}