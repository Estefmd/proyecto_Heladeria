package co.edu.uniquindio.Heladeria;
import co.edu.uniquindio.Heladeria.model.Heladeria;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Heladeria heladeria = new Heladeria("Prueba");
        int opcion = 0;
        do {
            opcion = heladeria.menuProducto();
            switch (opcion){
                case 1:
                    crearProducto(heladeria);
                    break;
                case 2:
                    actualizarProducto(heladeria);
                    break;
                case 3:
                    mostrarProductos(heladeria);
                    break;
                case 4:
                    eliminarProducto(heladeria);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
                    break;
            }
        } while (opcion != 5);
    }
    private static void mostrarProductos(Heladeria heladeria) {
        heladeria.mostrarProductos();
    }
    private static void eliminarProducto(Heladeria heladeria) {
        heladeria.eliminarProducto();
    }

    private static void actualizarProducto(Heladeria heladeria) {
        heladeria.actualizarProducto();
    }

    public static void crearProducto(Heladeria heladeria) {
        heladeria.crearProducto();
    }
}
