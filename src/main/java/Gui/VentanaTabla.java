package Gui;
import Controller.EstudianteController;
import Model.Estudiante;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
public class VentanaTabla extends JFrame {
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;

    public VentanaTabla() {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Tabla de Estudiantes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Rut");
        modeloTabla.addColumn("Número de Matrícula");
        modeloTabla.addColumn("Carrera");
        tablaEstudiantes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEstudiantes);
        panel.add(scrollPane, BorderLayout.CENTER);
        cargarDatosEnTabla();
        add(panel);
    }
    private void cargarDatosEnTabla() {
        EstudianteController estudianteController = new EstudianteController();
        List<Estudiante> estudiantes = estudianteController.obtenerTodosLosEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            modeloTabla.addRow(new Object[]{
                    estudiante.getNombre(),
                    estudiante.getApellido(),
                    estudiante.getRut(),
                    estudiante.getNumeroMatricula(),
                    estudiante.getCarrera().getNombreCarrera()
            });
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaTabla ventanaTabla = new VentanaTabla();
                ventanaTabla.setVisible(true);
            }
        });
    }
}