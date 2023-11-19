package co.edu.uniquindio.Heladeria.model;

import co.edu.uniquindio.Heladeria.enumeraciones.PuestoTrabajo;

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
     * Crear un nuevo producto
     * @param sabor
     * @param tipoCono
     * @param adicionalTopping
     * @param tipoProducto
     * @param stockAlmacen
     * @param precio
     * @param idProducto
     */
    public void crearProducto(String sabor, String tipoCono, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto) {
        if (buscarProducto(idProducto) == null){
            Producto producto = new Producto(sabor, tipoCono, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto);
            productosList.add(producto);
        }else{
            JOptionPane.showMessageDialog(null,"Algo ha salido mal, intentalo de nuevo");
        }
    }

    /**
     * Actualizar un producto existente
     * @param sabor
     * @param tipoCono
     * @param adicionalTopping
     * @param tipoProducto
     * @param stockAlmacen
     * @param precio
     * @param idProducto
     * @param nuevoIdProducto
     */
    public void actualizarProducto(String sabor, String tipoCono, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto, int nuevoIdProducto){
        Producto producto = buscarProducto(idProducto);
        if (producto==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el producto, intentelo de nuevo");
        }else{
            if (buscarProducto(nuevoIdProducto)==null||idProducto==nuevoIdProducto){
                    producto.setIdProducto(nuevoIdProducto);
                    producto.setTipoCono(tipoCono);
                    producto.setTipoProducto(tipoProducto);
                    producto.setSabor(sabor);
                    producto.setAdicionalTopping(adicionalTopping);
                    producto.setPrecioTotal(precio);
                    producto.setStockAlmacen(stockAlmacen);
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un producto registrgado con el nuevo id, intentelo nuevamente");
            }
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
    public void eliminarProducto(int idProducto) {
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


    public void crearEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario) {
        if (buscarEmpleado(documento) != null){
            JOptionPane.showMessageDialog(null, "Es posible que exista un empleado con este documento, intentelo nuevamente");
        }else {
            Empleado empleado = new Empleado();
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setAntiguedad(antiguedad);
            empleado.setDocumento(documento);
            empleado.setEdad(edad);
            empleado.setHorario(horario);
            empleado.setSalario(salario);

            switch (puestoTrabajo){
                case 1:
                    empleado.setPuestoTrabajo(PuestoTrabajo.CAJERA);
                    break;
                case 2:
                    empleado.setPuestoTrabajo(PuestoTrabajo.MESERA);
                    break;
                case 3:
                    empleado.setPuestoTrabajo(PuestoTrabajo.VENDEDORA);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida. Intente nuevamente");
            }
            empleadosList.add(empleado);
            JOptionPane.showMessageDialog(null, "El empleado ha sido creado con Exito!");
        }
    }

    public void actualizarEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario, int nuevoIdEmpleado) {
        Empleado empleado = buscarEmpleado(documento);
        if (empleado==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el empleado, intentelo de nuevo");
        }else{
            if (buscarProducto(nuevoIdEmpleado)==null||documento==nuevoIdEmpleado){
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setAntiguedad(antiguedad);
                empleado.setDocumento(nuevoIdEmpleado);
                empleado.setEdad(edad);
                empleado.setHorario(horario);
                empleado.setSalario(salario);

                switch (puestoTrabajo){
                    case 1:
                        empleado.setPuestoTrabajo(PuestoTrabajo.CAJERA);
                        break;
                    case 2:
                        empleado.setPuestoTrabajo(PuestoTrabajo.MESERA);
                        break;
                    case 3:
                        empleado.setPuestoTrabajo(PuestoTrabajo.VENDEDORA);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida. Intente nuevamente");
                }
                JOptionPane.showMessageDialog(null, "El empleado ha sido actualizado con Exito!");
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un empleado registrgado con el nuevo documento, intentelo nuevamente");
            }
        }
    }

    public Empleado buscarEmpleado(int documento){
        for (Empleado empleado : empleadosList) {
            if (empleado.getDocumento() == documento){
              return empleado;
            }
        }
        return null;
    }

    public void eliminarEmpleado(int idEmpleado) {
        Empleado empleadoEliminar = buscarEmpleado(idEmpleado);
        if (empleadoEliminar == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
        } else {
            empleadosList.remove(empleadoEliminar);
        }
    }

    public void mostrarEmpleados(){
        String mensaje = "";
        for (Empleado empleado:empleadosList) {
            mensaje += empleado.toString() +"\n___________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    public int menuEmpleado(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear empleado. \n"+
                "2. Actualizar empleado. \n"+
                "3. Listar empleados. \n"+
                "4. Elimiar empleado. \n"+
                "5. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }
}
