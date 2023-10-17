package co.edu.uniquindio.Heladeria.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Heladeria {
    private String nombre;

    public Heladeria(String nombre) {
        this.nombre = nombre;
    }
    List<Producto>productosList = new ArrayList<Producto>();
    List<Empleado>empleadosList = new ArrayList<Empleado>();
    List<Cliente>clientesList = new ArrayList<Cliente>();
    List<Venta>ventasList = new ArrayList<Venta>();

    /**
     * Crear nuevo producto
     */
    public void crearProducto() {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor del producto a registrar: ");
        String tipoCono = JOptionPane.showInputDialog("Ingrese el tipo de cono del producto a registrar: ");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional de producto a registrar: ");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto a registrar: ");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto a registrar: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de el producto: "));
        int idProducto;
        boolean seguir = true;
        do{
            idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a registrar"));
            if(buscarProducto(idProducto)==null){
                seguir = false;
            }
        }while(seguir);

        Producto producto = new Producto(sabor, tipoCono, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto);
        productosList.add(producto);
    }

    /**
     * Actualizar un producto existente
     */
    public void actualizarProducto(){
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto que desea actualizar: "));
        if (buscarProducto(idProducto)!= null){
            int contador = 0;
            for (Producto producto: productosList) {
                if (producto.getIdProducto()==idProducto){
                    String sabor = JOptionPane.showInputDialog("Ingrese el sabor del producto a registrar: ");
                    String tipoCono = JOptionPane.showInputDialog("Ingrese el tipo de cono del producto a registrar: ");
                    String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional de producto a registrar: ");
                    String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto a registrar: ");
                    int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto a registrar: "));
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
                    int nuevoIdProducto=0;
                    boolean seguir = true;
                    do {
                        nuevoIdProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto a registrar: "));
                        if (buscarProducto(nuevoIdProducto) == null || nuevoIdProducto == producto.getIdProducto()) {
                            seguir = false;
                        }
                    } while (seguir);
                    Producto productoActualizado = new Producto(sabor, tipoCono, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto);
                    productosList.set(contador, productoActualizado);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no encontrado, intentelo nuevamente");
        }
    }

    /**
     * Buscar producto por su ID
     * @param idProducto
     * @return Producto
     */
    public Producto buscarProducto(int idProducto){
        for (Producto producto:productosList) {
            if(producto.getIdProducto()==idProducto){
                return producto;
            }
        }
        return null;
    }
    /**
     * Mostrar productos existentes
     */
    public void mostrarProductos(){
        String mensaje = "";
        for (Producto producto:productosList) {
            mensaje += producto.toString() +"\n_________________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Eliminar producto existente
     */
    public void eliminarProducto() {
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea eliminar: "));
        Producto productoAEliminar = buscarProducto(idProducto);
        if (productoAEliminar == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        } else {
            productosList.remove(productoAEliminar);
        }
    }

    /**
     * Obtener menú con las opciones del producto
     * @return
     */
    public int menuProducto(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear producto. \n"+
                "2. Actualizar producto. \n"+
                "3. Listar productos. \n"+
                "4. Elimiar producto. \n"+
                "5. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }
}
