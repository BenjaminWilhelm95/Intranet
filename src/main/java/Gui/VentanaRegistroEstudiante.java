package Gui;
import Controller.CarreraController;
import Controller.EstudianteController;
import Model.Carrera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaRegistroEstudiante extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtRut;
    private JTextField txtNumeroMatricula;
    private JComboBox<String> cmbCarrera;
    private EstudianteController estudianteController;

    public VentanaRegistroEstudiante() {
        estudianteController = new EstudianteController();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Registro de Estudiante");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);

        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField(20);

        JLabel lblRut = new JLabel("Rut:");
        txtRut = new JTextField(10);

        JLabel lblNumeroMatricula = new JLabel("Número de Matrícula:");
        txtNumeroMatricula = new JTextField(11);

        JLabel lblCarrera = new JLabel("Carrera:");
        cmbCarrera = new JComboBox<>();
        cargarCarreras();

        JButton btnRegistrar = new JButton("Registrar");

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstudiante();
            }
        });

        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblRut);
        panel.add(txtRut);
        panel.add(lblNumeroMatricula);
        panel.add(txtNumeroMatricula);
        panel.add(lblCarrera);
        panel.add(cmbCarrera);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(btnRegistrar);

        add(panel);
    }

    private void cargarCarreras() {
        CarreraController carreraController = new CarreraController();
        List<Carrera> carreras = carreraController.obtenerTodasLasCarreras();

        for (Carrera carrera : carreras) {
            cmbCarrera.addItem(carrera.getNombreCarrera());
        }
    }

    private void registrarEstudiante() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String rut = txtRut.getText();
        String numeroMatricula = txtNumeroMatricula.getText();

        if (cmbCarrera.getItemCount() > 0) {
            String nombreCarrera = cmbCarrera.getSelectedItem().toString();
            CarreraController carreraController = new CarreraController();
            Carrera carrera = carreraController.buscarCarrera(nombreCarrera);
            estudianteController.crearEstudiante(nombre, apellido, rut, numeroMatricula, carrera);
            JOptionPane.showMessageDialog(this, "Estudiante registrado con éxito.");
            txtNombre.setText("");
            txtApellido.setText("");
            txtRut.setText("");
            txtNumeroMatricula.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No hay carreras disponibles. Debes registrar al menos una carrera antes de registrar un estudiante.");
        }
    }
}