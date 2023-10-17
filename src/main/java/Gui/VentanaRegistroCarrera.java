package Gui;
import Controller.CarreraController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaRegistroCarrera extends JFrame {
    private JTextField txtNombreCarrera;
    private JTextField txtCodigo;
    private JTextField txtCantidadSemestres;
    private CarreraController carreraController;

    public VentanaRegistroCarrera() {
        carreraController = new CarreraController();
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Registro de Carrera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        JLabel lblNombreCarrera = new JLabel("Nombre de la Carrera:");
        txtNombreCarrera = new JTextField(20);
        JLabel lblCodigo = new JLabel("Código de la Carrera:");
        txtCodigo = new JTextField(10);
        JLabel lblCantidadSemestres = new JLabel("Cantidad de Semestres:");
        txtCantidadSemestres = new JTextField(2);
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCarrera();
            }
        });
        panel.add(lblNombreCarrera);
        panel.add(txtNombreCarrera);
        panel.add(lblCodigo);
        panel.add(txtCodigo);
        panel.add(lblCantidadSemestres);
        panel.add(txtCantidadSemestres);
        panel.add(new JLabel());
        panel.add(btnRegistrar);
        add(panel);
    }
    private void registrarCarrera() {
        String nombreCarrera = txtNombreCarrera.getText();
        String codigo = txtCodigo.getText();
        int cantidadSemestres = Integer.parseInt(txtCantidadSemestres.getText());

        carreraController.crearCarrera(nombreCarrera, codigo, cantidadSemestres);
        JOptionPane.showMessageDialog(this, "Carrera registrada con éxito.");

        // Limpiar los campos después de registrar
        txtNombreCarrera.setText("");
        txtCodigo.setText("");
        txtCantidadSemestres.setText("");
    }
}