package Gui;
import Controller.CarreraController;
import Controller.EstudianteController;
import Model.Carrera;
import Model.Estudiante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class VentanaBusquedaEstudiante extends JFrame {
    private JTextField txtNombre;
    private JComboBox<String> cmbCarrera;
    private JTextArea txtResultado;
    private EstudianteController estudianteController;
    public VentanaBusquedaEstudiante() {
        estudianteController = new EstudianteController();
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Búsqueda de Estudiantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        JLabel lblNombre = new JLabel("Nombre del Estudiante:");
        txtNombre = new JTextField(20);
        JLabel lblCarrera = new JLabel("Carrera:");
        cmbCarrera = new JComboBox<>();
        cargarCarreras();
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEstudiantes();
            }
        });
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblCarrera);
        panel.add(cmbCarrera);
        panel.add(new JLabel());
        panel.add(btnBuscar);
        panel.add(scrollPane);
        add(panel);
    }
    private void cargarCarreras() {
        CarreraController carreraController = new CarreraController();
        List<Carrera> carreras = carreraController.obtenerTodasLasCarreras();

        for (Carrera carrera : carreras) {
            cmbCarrera.addItem(carrera.getNombreCarrera());
        }
    }
    private void buscarEstudiantes() {
        String nombre = txtNombre.getText();
        String nombreCarrera = cmbCarrera.getSelectedItem().toString();
        if (nombre.isEmpty() && nombreCarrera.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar al menos un criterio de búsqueda.");
            return;
        }
        List<Estudiante> estudiantes = estudianteController.buscarEstudiantesPorNombreYCarrera(nombre, nombreCarrera);
        if (estudiantes.isEmpty()) {
            txtResultado.setText("No se encontraron estudiantes que coincidan con los criterios de búsqueda.");
        } else {
            txtResultado.setText("Estudiantes encontrados:\n");
            for (Estudiante estudiante : estudiantes) {
                txtResultado.append(estudiante.getNombre() + " " + estudiante.getApellido() + " - Carrera: " + estudiante.getCarrera().getNombreCarrera() + "\n");
            }
        }
    }
}