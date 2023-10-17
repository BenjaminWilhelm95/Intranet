package Model.data.DAO;
import Model.Carrera;
import Model.data.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CarreraDAO {
    public void create(Carrera carrera) {
        String insertSQL = "INSERT INTO Carreras (nombreCarrera, codigo, cantidadSemestres) VALUES (?, ?, ?)";

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, carrera.getNombreCarrera());
            preparedStatement.setString(2, carrera.getCodigo());
            preparedStatement.setInt(3, carrera.getCantidadSemestres());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la carrera.");
        }
    }
    public Carrera read(int carreraId) {
        String selectSQL = "SELECT * FROM Carreras WHERE id = ?";

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, carreraId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Carrera carrera = new Carrera();
                carrera.setId(resultSet.getInt("id"));
                carrera.setNombreCarrera(resultSet.getString("nombreCarrera"));
                carrera.setCodigo(resultSet.getString("codigo"));
                carrera.setCantidadSemestres(resultSet.getInt("cantidadSemestres"));
                return carrera;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Carrera carrera) {
        String updateSQL = "UPDATE Carreras SET nombreCarrera = ?, codigo = ?, cantidadSemestres = ? WHERE id = ?";

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setString(1, carrera.getNombreCarrera());
            preparedStatement.setString(2, carrera.getCodigo());
            preparedStatement.setInt(3, carrera.getCantidadSemestres());
            preparedStatement.setInt(4, carrera.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la carrera.");
        }
    }
    public void delete(int carreraId) {
        String deleteSQL = "DELETE FROM Carreras WHERE id = ?";

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setInt(1, carreraId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la carrera.");
        }
    }
    public List<Carrera> getAllCarreras() {
        List<Carrera> carreras = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM Carreras";
        try (Connection connection = DBconnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Carrera carrera = new Carrera();
                carrera.setId(resultSet.getInt("id"));
                carrera.setNombreCarrera(resultSet.getString("nombreCarrera"));
                carrera.setCodigo(resultSet.getString("codigo"));
                carrera.setCantidadSemestres(resultSet.getInt("cantidadSemestres"));
                carreras.add(carrera);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }
}
