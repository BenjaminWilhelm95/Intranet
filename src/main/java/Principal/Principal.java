package Principal;
import Gui.VentanaBienvenida;
public class Principal {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
                ventanaBienvenida.setVisible(true);
            }
        });
    }
}