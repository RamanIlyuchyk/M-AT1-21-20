import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOptions {
    Connection connection;
    final static String url = "jdbc:mysql://localhost:3306/megaapp2" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";

    public ConnectionOptions() throws SQLException {
        this.connection = DriverManager.getConnection(url, "root", "753RoMeO91");
    }

    public Connection createConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}