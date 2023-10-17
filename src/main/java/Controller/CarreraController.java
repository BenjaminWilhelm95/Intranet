package Controller;
import Model.data.DAO.CarreraDAO;
import Model.Carrera;
import java.util.List;
public class CarreraController {
    private CarreraDAO carreraDAO;
    public CarreraController() {
        carreraDAO = new CarreraDAO();
    }
    public void crearCarrera(String nombreCarrera, String codigo, int cantidadSemestres) {
        Carrera carrera = new Carrera(nombreCarrera, codigo, cantidadSemestres);
        carreraDAO.create(carrera);
    }
    public Carrera buscarCarrera(int carreraId) {
        return carreraDAO.read(carreraId);
    }
    public void actualizarCarrera(int carreraId, String nombreCarrera, String codigo, int cantidadSemestres) {
        Carrera carrera = carreraDAO.read(carreraId);
        if (carrera != null) {
            carrera.setNombreCarrera(nombreCarrera);
            carrera.setCodigo(codigo);
            carrera.setCantidadSemestres(cantidadSemestres);
            carreraDAO.update(carrera);
        }
    }
    public Carrera buscarCarrera(String nombreCarrera) {
        List<Carrera> carreras = obtenerTodasLasCarreras();
        for (Carrera carrera : carreras) {
            if (carrera.getNombreCarrera().equals(nombreCarrera)) {
                return carrera;
            }
        }
        return null;
    }
    public void eliminarCarrera(int carreraId) {
        carreraDAO.delete(carreraId);
    }
    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraDAO.getAllCarreras();
    }
}