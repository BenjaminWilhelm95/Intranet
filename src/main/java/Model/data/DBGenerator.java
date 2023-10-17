package Model.data;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
public class DBGenerator {
    public static void createTables() {
        try (Connection connection = DBconnector.getConnection(); Statement statement = connection.createStatement()) {
            String createCarrerasTable = "CREATE TABLE IF NOT EXISTS Carreras (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombreCarrera TEXT NOT NULL," +
                    "codigo TEXT NOT NULL," +
                    "cantidadSemestres INTEGER NOT NULL" +
                    ")";
            statement.execute(createCarrerasTable);
            String createEstudiantesTable = "CREATE TABLE IF NOT EXISTS Estudiantes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT NOT NULL," +
                    "apellido TEXT NOT NULL," +
                    "rut TEXT NOT NULL," +
                    "numeroMatricula TEXT NOT NULL," +
                    "carrera_id INTEGER," +
                    "FOREIGN KEY (carrera_id) REFERENCES Carreras (id)" +
                    ")";
            statement.execute(createEstudiantesTable);
            System.out.println("Tablas creadas con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear las tablas de la base de datos.");
        }
    }
    public static void main(String[] args) {
        createTables();
    }
}