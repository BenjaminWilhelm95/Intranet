package Model.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnector {
    private static final String JDBC_URL = "jdbc:sqlite:tu_base_de_datos.db";
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos");
        }
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
