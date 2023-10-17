package Controller;
import Model.data.DAO.EstudianteDAO;
import Model.Estudiante;
import java.util.List;
import Model.Carrera;
import java.util.ArrayList;
public class EstudianteController {
    private EstudianteDAO estudianteDAO;

    public EstudianteController() {
        estudianteDAO = new EstudianteDAO();
    }
    public void crearEstudiante(String nombre, String apellido, String rut, String numeroMatricula, Carrera carrera) {
        Estudiante estudiante = new Estudiante(nombre, apellido, rut, numeroMatricula, carrera);
        estudianteDAO.create(estudiante);
    }
    public Estudiante buscarEstudiante(int estudianteId) {
        return estudianteDAO.read(estudianteId);
    }
    public void actualizarEstudiante(int estudianteId, String nombre, String apellido, String rut, String numeroMatricula, Carrera carrera) {
        Estudiante estudiante = estudianteDAO.read(estudianteId);
        if (estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setRut(rut);
            estudiante.setNumeroMatricula(numeroMatricula);
            estudiante.setCarrera(carrera);
            estudianteDAO.update(estudiante);
        }
    }
    public void eliminarEstudiante(int estudianteId) {
        estudianteDAO.delete(estudianteId);
    }
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteDAO.getAllEstudiantes();
    }
    public List<Estudiante> buscarEstudiantesPorNombreYCarrera(String nombre, String nombreCarrera) {
        List<Estudiante> estudiantesEncontrados = new ArrayList<>();
        List<Estudiante> todosLosEstudiantes = estudianteDAO.getAllEstudiantes();
        for (Estudiante estudiante : todosLosEstudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre) &&
                    estudiante.getCarrera().getNombreCarrera().equalsIgnoreCase(nombreCarrera)) {
                estudiantesEncontrados.add(estudiante);
            }
        }
        return estudiantesEncontrados;
    }
}
