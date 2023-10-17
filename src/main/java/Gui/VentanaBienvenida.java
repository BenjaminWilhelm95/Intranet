package Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaBienvenida extends JFrame {
    public VentanaBienvenida() {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Bienvenido a la Aplicación");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        JLabel lblBienvenida = new JLabel("¡Bienvenido a la Aplicación!");
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        JButton btnRegistroCarrera = new JButton("Registrar Carrera");
        JButton btnRegistroEstudiante = new JButton("Registrar Estudiante");
        JButton btnBuscarEstudiante = new JButton("Buscar Estudiante");
        btnRegistroCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroCarrera();
            }
        });
        btnRegistroEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroEstudiante();
            }
        });
        btnBuscarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaBusquedaEstudiante();
            }
        });
        panel.add(lblBienvenida);
        panel.add(btnRegistroCarrera);
        panel.add(btnRegistroEstudiante);
        panel.add(btnBuscarEstudiante);
        add(panel);
    }
    private void abrirVentanaRegistroCarrera() {
        VentanaRegistroCarrera ventanaRegistroCarrera = new VentanaRegistroCarrera();
        ventanaRegistroCarrera.setVisible(true);
    }
    private void abrirVentanaRegistroEstudiante() {
        VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
        ventanaRegistroEstudiante.setVisible(true);
    }
    private void abrirVentanaBusquedaEstudiante() {
        VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante();
        ventanaBusquedaEstudiante.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                ventanaBienvenida.setVisible(true);
            }
        });
    }
}