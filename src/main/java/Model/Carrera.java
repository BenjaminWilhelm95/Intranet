package Model;
import java.util.ArrayList;
import java.util.List;
public class Carrera {
    private int id;
    private String nombreCarrera;
    private String codigo;
    private int cantidadSemestres;
    private List<Estudiante> estudiantes;
    public Carrera() {
        estudiantes = new ArrayList<>();
    }
    public Carrera(String nombreCarrera, String codigo, int cantidadSemestres) {
        this.nombreCarrera = nombreCarrera;
        this.codigo = codigo;
        this.cantidadSemestres = cantidadSemestres;
        estudiantes = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getCantidadSemestres() {
        return cantidadSemestres;
    }
    public void setCantidadSemestres(int cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }
}