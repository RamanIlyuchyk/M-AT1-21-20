import java.sql.*;

public class Connect {
    public Connection connectDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/megaapp" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "753RoMeO91");
    }

    public PreparedStatement statement(String query) throws SQLException {
        return connectDB().prepareStatement(query);
    }

    public ResultSet resultSet(String query) throws SQLException {
        Statement statement = connectDB().createStatement();
        return statement.executeQuery(query);
    }
}