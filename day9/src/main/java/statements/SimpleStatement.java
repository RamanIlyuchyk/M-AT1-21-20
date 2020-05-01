package statements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleStatement extends BaseStatement {
    Connection connection;
    Statement statement;

    public SimpleStatement(Connection connection) {
        this.connection = connection;
    }

    public void getStatement() throws SQLException {
        this.statement = this.connection.createStatement();
    }

    public ResultSet executeStatement(String query) throws SQLException {
        getStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdateStatement(String query) throws SQLException {
        getStatement();
        statement.executeUpdate(query);
    }

    public void closeStatement() throws SQLException {
        super.closeStatement(this.statement);
    }
}