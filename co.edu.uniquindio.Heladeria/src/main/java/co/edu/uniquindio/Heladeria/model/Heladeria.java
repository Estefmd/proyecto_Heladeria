package co.edu.uniquindio.Heladeria.model;

import co.edu.uniquindio.Heladeria.enumeraciones.PuestoTrabajo;

import javax.swing.*;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Heladeria {
    private String nombre;

    public Heladeria(String nombre) {
        this.nombre = nombre;
    }
    List<Producto>productosList = new ArrayList<Producto>();
    List<Empleado>empleadosList = new ArrayList<Empleado>();
    List<Cliente>clientesList = new ArrayList<Cliente>();
    List<Venta>ventasList = new ArrayList<Venta>();

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");


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
            JOptionPane.showMessageDialog(null,"Algo ha salido mal, intentalo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"No se ha encontrado el producto, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un producto registrgado con el nuevo id, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "Producto no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            productosList.remove(productoAEliminar);
            JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
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

    //CRUD EMPLEADO

    /**
     * Funcion para crear un empleado
     * @param nombre
     * @param apellido
     * @param documento
     * @param edad
     * @param horario
     * @param antiguedad
     * @param puestoTrabajo
     * @param salario
     */
    public void crearEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario) {
        if (buscarEmpleado(documento) != null){
            JOptionPane.showMessageDialog(null, "Es posible que exista un empleado con este documento, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);

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
                    JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida. Intente nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            empleadosList.add(empleado);
            JOptionPane.showMessageDialog(null, "El empleado ha sido creado con Exito!");
        }
    }

    /**
     * Actualizar un empleado existente
     * @param nombre
     * @param apellido
     * @param documento
     * @param edad
     * @param horario
     * @param antiguedad
     * @param puestoTrabajo
     * @param salario
     * @param nuevoIdEmpleado
     */
    public void actualizarEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario, int nuevoIdEmpleado) {
        Empleado empleado = buscarEmpleado(documento);
        if (empleado==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el empleado, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida. Intente nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "El empleado ha sido actualizado con Exito!");
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un empleado registrgado con el nuevo documento, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Buscar empleado
     * @param documento
     * @return
     */
    public Empleado buscarEmpleado(int documento){
        for (Empleado empleado : empleadosList) {
            if (empleado.getDocumento() == documento){
              return empleado;
            }
        }
        return null;
    }

    /**
     * eliminar empleado
     * @param idEmpleado
     */
    public void eliminarEmpleado(int idEmpleado) {
        Empleado empleadoEliminar = buscarEmpleado(idEmpleado);
        if (empleadoEliminar == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            empleadosList.remove(empleadoEliminar);
            JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");

        }
    }

    /**
     * Mostrar lista empleados
     */
    public void mostrarEmpleados(){
        String mensaje = "";
        for (Empleado empleado:empleadosList) {
            mensaje += empleado.toString() +"\n___________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Menu emplead
     * @return
     */
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

    public void mostrarClientes(){
        String mensaje = "";
        for (Cliente cliente:clientesList) {
            mensaje += cliente.toString() +"\n___________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void eliminarCliente(int idCliente) {
        Cliente clienteEliminar = buscarCliente(idCliente);
        if (clienteEliminar == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            clientesList.remove(clienteEliminar);
            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
        }
    }
    private Cliente buscarCliente(int idCliente) {
        for (Cliente cliente : clientesList) {
            if (cliente.getDocumento() == idCliente){
                return cliente;
            }
        }
        return null;
    }
    public void crearCliente(String nombre, String apellido, int documento, int edad, String fechaCompra) {
        if (buscarCliente(documento) == null) {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDocumento(documento);
            cliente.setEdad(edad);

            LocalDate fechaConvertida;
            try {
                fechaConvertida = LocalDate.parse(fechaCompra, formato);
                cliente.setFechaCompra(fechaConvertida);
                JOptionPane.showMessageDialog(null, "El cliente ha sido creado con éxito!");
                clientesList.add(cliente);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente.","Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarCliente(String nombre, String apellido, int documento, int edad, String fechaCompra, int nuevoDocumento) {
        Cliente cliente = buscarCliente(documento);
        if (cliente==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el cliente, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            if (buscarCliente(nuevoDocumento)==null||documento==nuevoDocumento){
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDocumento(nuevoDocumento);
                cliente.setEdad(edad);
                LocalDate fechaConvertida;
                try {
                    fechaConvertida = LocalDate.parse(fechaCompra, formato);
                    cliente.setFechaCompra(fechaConvertida);
                    JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado con Exito!");
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un cliente registrgado con el nuevo documento, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public int menuCliente(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear cliente. \n"+
                "2. Actualizar cliente. \n"+
                "3. Listar cliente. \n"+
                "4. Elimiar cliente. \n"+
                "5. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }
}
