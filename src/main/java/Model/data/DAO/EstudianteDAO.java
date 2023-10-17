package Model.data.DAO;
import Model.Estudiante;
import Model.data.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EstudianteDAO {
    public void create(Estudiante estudiante) {
        String insertSQL = "INSERT INTO Estudiantes (nombre, apellido, rut, numeroMatricula, carrera_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getApellido());
            preparedStatement.setString(3, estudiante.getRut());
            preparedStatement.setString(4, estudiante.getNumeroMatricula());
            preparedStatement.setInt(5, estudiante.getCarrera().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el estudiante.");
        }
    }
    public Estudiante read(int estudianteId) {
        String selectSQL = "SELECT * FROM Estudiantes WHERE id = ?";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, estudianteId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getInt("id"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("apellido"));
                estudiante.setRut(resultSet.getString("rut"));
                estudiante.setNumeroMatricula(resultSet.getString("numeroMatricula"));
                return estudiante;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Estudiante estudiante) {
        String updateSQL = "UPDATE Estudiantes SET nombre = ?, apellido = ?, rut = ?, numeroMatricula = ? WHERE id = ?";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, estudiante.getNombre());
            preparedStatement.setString(2, estudiante.getApellido());
            preparedStatement.setString(3, estudiante.getRut());
            preparedStatement.setString(4, estudiante.getNumeroMatricula());
            preparedStatement.setInt(5, estudiante.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el estudiante.");
        }
    }
    public void delete(int estudianteId) {
        String deleteSQL = "DELETE FROM Estudiantes WHERE id = ?";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, estudianteId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el estudiante.");
        }
    }
    public List<Estudiante> getAllEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM Estudiantes";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultSet.getInt("id"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellido(resultSet.getString("apellido"));
                estudiante.setRut(resultSet.getString("rut"));
                estudiante.setNumeroMatricula(resultSet.getString("numeroMatricula"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }
}