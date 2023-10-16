package co.edu.uniquindio.Heladeria.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Heladeria {

    private String nombre;

    List<Producto>productosList = new ArrayList<Producto>();
    List<Empleado>empleadosList = new ArrayList<Empleado>();
    List<Cliente>clientesList = new ArrayList<Cliente>();
    List<Venta>ventasList = new ArrayList<Venta>();

    public void crearProducto() {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor del producto a registrar");
        String tipoCono = JOptionPane.showInputDialog("Ingrese el tipo de cono del producto a registrar");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional de producto a registrar");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto a registrar");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto a registrar"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio dell producto: "));
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

    public Producto buscarProducto(int idProducto){
        for (Producto producto:productosList) {
            if(producto.getIdProducto()==idProducto){
                return producto;
            }
        }
        return null;
    }

    public void mostrarProductos(){
        String mensaje = "";
        for (Producto producto:productosList) {
            mensaje += producto.toString() +"\n_________________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    public void eliminarProdcuto(int idProducto){
        int i = 0;
        if(buscarProducto(idProducto)== null){
            JOptionPane.showMessageDialog(null,"Producto no encontrado");
        } else {
            for (Producto producto:productosList) {
                if(producto.getIdProducto()==idProducto){
                    productosList.remove(i);
                }
                i++;
            }
        }
    }
}
