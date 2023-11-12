package co.edu.uniquindio.Heladeria;
import co.edu.uniquindio.Heladeria.model.Heladeria;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Heladeria heladeria = inicializarDatos("nombre");
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

    private static Heladeria inicializarDatos(String nombre) {
        Heladeria heladeria = new Heladeria(nombre);
        heladeria.crearProducto("Vainilla", "", "Chispas", "Paleta", 600, 1000, 12345);
        heladeria.crearProducto("Chocolate", "Galleta", "Chispas", "Helado", 100, 12000, 1234);
        return heladeria;
    }

    private static void mostrarProductos(Heladeria heladeria) {
        heladeria.mostrarProductos();
    }
    private static void eliminarProducto(Heladeria heladeria) {
        heladeria.eliminarProducto();
    }

    private static void actualizarProducto(Heladeria heladeria) {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor que desea actualizar: ");
        String tipoCono = JOptionPane.showInputDialog("Ingrese el tipo de cono que desea actualizar: ");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional que desea actualizar: ");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto que desea actualizar: ");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible que desea actualizar: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio que desea actualizar:o: "));
        int  idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actulizar"));
        int  nuevoIdProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto (este puede ser el anterior)"));
        heladeria.actualizarProducto(sabor, tipoCono, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, nuevoIdProducto);
    }

    public static void crearProducto(Heladeria heladeria) {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor del producto a registrar: ");
        String tipoCono = JOptionPane.showInputDialog("Ingrese el tipo de cono del producto a registrar: ");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional de producto a registrar: ");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto a registrar: ");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto a registrar: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de el producto: "));
        int  idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a registrar"));
        heladeria.crearProducto(sabor, tipoCono, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto);
    }
}
