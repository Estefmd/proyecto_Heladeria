package co.edu.uniquindio.Heladeria;
import co.edu.uniquindio.Heladeria.model.Heladeria;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Heladeria heladeria = inicializarDatos("nombre");
        mostrarMeunProducto(heladeria);
        mostrarMeunEmpleado(heladeria);
        mostrarMeunCliente(heladeria);

    }



    private static void crearCliente(Heladeria heladeria) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente que desea registrar");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente que desea registrar");
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea registrar"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente que desea registrar"));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la fecha de compra (año-mes-dia)");
        heladeria.crearCliente(nombre, apellido, documento, edad, fechaCompra);
    }

    private static void actualizarCliente(Heladeria heladeria) {
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea actualizar"));
        int nuevoDocumento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento del cliente"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
        String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del cliente"));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la nueva fecha de compra (año-mes-dia)");
        heladeria.actualizarCliente(nombre, apellido, documento, edad, fechaCompra, nuevoDocumento);
    }

    private static void eliminarCliente(Heladeria heladeria) {
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea eliminar: "));
        heladeria.eliminarCliente(idCliente);
    }

    private static void mostrarClientes(Heladeria heladeria) {
        heladeria.mostrarClientes();
    }


    private static void crearEmpleado(Heladeria heladeria) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado que desea registrar");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado que desea registrar");
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del empleado que desea registrar"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado que desea registrar"));
        String horario = JOptionPane.showInputDialog("Ingrese el horario del empleado que desea registrar");
        int antiguedad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguedad del empleado que desea registrar (en años)"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado que desea registrar"));
        int puestoTrabajo;
        do {
            puestoTrabajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puesto de trabajo del empleado que desea registrar \n 1. Cajera \n 2. Mesera \n 3. Vendedora"));
        }while(puestoTrabajo!=1 && puestoTrabajo!=2 && puestoTrabajo!=3);

        heladeria.crearEmpleado( nombre,  apellido,  documento,  edad, horario, antiguedad, puestoTrabajo, salario);
    }

    private static void actualizarEmpleado(Heladeria heladeria) {
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del empleado que desea actualizar"));
        int nuevoDocumento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento del empleado que desea actualizar (este puede ser el mismo)"));
        String nombre = JOptionPane.showInputDialog("Ingrese nuevo el nombre del empleado que desea actualizar");
        String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del empleado que desea actualizar");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del empleado que desea actualizar"));
        String horario = JOptionPane.showInputDialog("Ingrese el nuevo horario del empleado que desea actualizar");
        int antiguedad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la antiguedad del empleado que desea actualizar (en años)"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo salario del empleado que desea actualizar"));
        int puestoTrabajo;
        do {
            puestoTrabajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puesto de trabajo del empleado que desea registrar \n 1. Cajera \n 2. Mesera \n 3. Vendedora"));
        }while(puestoTrabajo!=1 && puestoTrabajo!=2 && puestoTrabajo!=3);

        heladeria.actualizarEmpleado( nombre,  apellido,  documento,  edad, horario, antiguedad, puestoTrabajo, salario, nuevoDocumento);
    }

    private static void eliminarEmpleado(Heladeria heladeria) {
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del empleado que desea eliminar: "));
        heladeria.eliminarEmpleado(idEmpleado);
    }

    private static void mostrarEmpleados(Heladeria heladeria) {
        heladeria.mostrarEmpleados();
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
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea eliminar: "));
        heladeria.eliminarProducto(idProducto);
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

    public static void mostrarMeunProducto(Heladeria heladeria){
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

    public static void mostrarMeunEmpleado(Heladeria heladeria){
        int opcion = 0;
        do {
            opcion = heladeria.menuEmpleado();
            switch (opcion){
                case 1:
                    crearEmpleado(heladeria);
                    break;
                case 2:
                    actualizarEmpleado(heladeria);
                    break;
                case 3:
                    mostrarEmpleados(heladeria);
                    break;
                case 4:
                    eliminarEmpleado(heladeria);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
                    break;
            }
        } while (opcion != 5);
    }

    public static void mostrarMeunCliente(Heladeria heladeria){
        int opcion = 0;
        do {
            opcion = heladeria.menuCliente();
            switch (opcion){
                case 1:
                    crearCliente(heladeria);
                    break;
                case 2:
                    actualizarCliente(heladeria);
                    break;
                case 3:
                    mostrarClientes(heladeria);
                    break;
                case 4:
                    eliminarCliente(heladeria);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
                    break;
            }
        } while (opcion != 5);
    }
}



