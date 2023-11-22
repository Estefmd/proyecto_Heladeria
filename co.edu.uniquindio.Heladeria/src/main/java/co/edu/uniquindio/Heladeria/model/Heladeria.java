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


    //CRUD PRODUCTO -----------------------------------------
    /**
     * Crear un nuevo producto
     * @param sabor
     * @param nombre
     * @param adicionalTopping
     * @param tipoProducto
     * @param stockAlmacen
     * @param precio
     * @param idProducto
     * @param heladeria
     * @return boolean
     */
    public boolean crearProducto(String sabor, String nombre, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto, Heladeria heladeria) {
        if (buscarProducto(idProducto, heladeria) == null){
            Producto producto = new Producto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, heladeria);
            heladeria.productosList.add(producto);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Actualizar un producto existente
     * @param sabor
     * @param nombre
     * @param adicionalTopping
     * @param tipoProducto
     * @param stockAlmacen
     * @param precio
     * @param idProducto
     * @param nuevoIdProducto
     * @param heladeria
     * @return boolean
     */
    public boolean actualizarProducto(String sabor, String nombre, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto, int nuevoIdProducto, Heladeria heladeria){
        Producto producto = buscarProducto(idProducto, heladeria);
        if (producto==null){
            return false;
        }else{
            if (buscarProducto(nuevoIdProducto, heladeria)==null||idProducto==nuevoIdProducto){
                    producto.setIdProducto(nuevoIdProducto);
                    producto.setNombre(nombre);
                    producto.setTipoProducto(tipoProducto);
                    producto.setSabor(sabor);
                    producto.setAdicionalTopping(adicionalTopping);
                    producto.setPrecioTotal(precio);
                    producto.setStockAlmacen(stockAlmacen);
                    return true;
            }else{
                return false;
            }
        }
    }

    /**
     * Mostrar productos existentes
     * @param heladeria
     * @return String
     */
    public String mostrarProductos(Heladeria heladeria){
        String mensaje = "";
        for (Producto producto:heladeria.productosList) {
            mensaje += producto.toString() +"\n_________________\n";
        }
        return mensaje;
    }

    /**
     * Eliminar producto existente
     * @param idProducto
     * @param heladeria
     * @return boolean
     */
    public boolean eliminarProducto(int idProducto, Heladeria heladeria) {
        Producto productoAEliminar = buscarProducto(idProducto, heladeria);
        if (productoAEliminar == null) {
            return false;
        } else {
            productosList.remove(productoAEliminar);
            return true;
        }
    }

    /**
     * Buscar producto por su ID
     * @param idProducto
     * @return Producto
     */
    public Producto buscarProducto(int idProducto, Heladeria heladeria){
        for (Producto producto:heladeria.productosList) {
            if(producto.getIdProducto()==idProducto){
                return producto;
            }
        }
        return null;
    }

    /**
     * Buscar productos con un stock menor a 100
     * @param heladeria
     * @return String
     */
    public String buscarProductoStockMenor100(Heladeria heladeria){
        String mensaje = "";
        for (Producto producto: heladeria.productosList) {
            if (producto.getStockAlmacen()<100){
                mensaje+=producto.toString();
            }
        }
        return mensaje;
    }

    //CRUD EMPLEADO----------------------------

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
     * @param heladeria
     * @return boolean
     */
    public boolean crearEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad,int puestoTrabajo, double salario, Heladeria heladeria) {
        if (buscarEmpleado(documento, heladeria) != null){
            return false;
        }else {
            Empleado empleado = new Empleado();
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setAntiguedad(antiguedad);
            empleado.setDocumento(documento);
            empleado.setEdad(edad);
            empleado.setHorario(horario);
            empleado.setSalario(salario);
            empleado.setOwnedByHeladeria(heladeria);

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
                    return false;
            }
            empleadosList.add(empleado);
            return true;
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
     * @param heladeria
     * @return boolean
     */
    public boolean actualizarEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario, int nuevoIdEmpleado, Heladeria heladeria) {
        Empleado empleado = buscarEmpleado(documento, heladeria);
        if (empleado==null){
            return false;
        }else{
            if (buscarProducto(nuevoIdEmpleado, heladeria)==null||documento==nuevoIdEmpleado){
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
                        return false;
                }
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * eliminar empleado
     * @param idEmpleado
     * @param heladeria
     * @return boolean
     */
    public boolean eliminarEmpleado(int idEmpleado, Heladeria heladeria) {
        Empleado empleadoEliminar = buscarEmpleado(idEmpleado, heladeria);
        if (empleadoEliminar == null) {
            return false;
        } else {
            heladeria.empleadosList.remove(empleadoEliminar);
            return true;
        }
    }

    /**
     * Mostrar lista empleados
     * @param heladeria
     * @return String
     */
    public String mostrarEmpleados(Heladeria heladeria){
        String mensaje = "";
        for (Empleado empleado:heladeria.empleadosList) {
            mensaje += empleado.toString() +"\n___________\n";
        }
        return mensaje;
    }

    /**
     * Buscar empleado
     * @param documento
     * @return
     */
    public Empleado buscarEmpleado(int documento, Heladeria heladeria){
        for (Empleado empleado : heladeria.empleadosList) {
            if (empleado.getDocumento() == documento){
                return empleado;
            }
        }
        return null;
    }

    /**
     * Mostrar el empleado con mas ventas
     * @param heladeria
     * @return String
     */
    public String mostrarEmpleadoMasVentas(Heladeria heladeria){
        int ventas =0;
        Empleado empleadoMasVentas = null;
        for (Empleado empleado: heladeria.empleadosList) {
            if (empleado.getVentasAsociadas().size() > ventas){
             ventas= empleado.getVentasAsociadas().size();
             empleadoMasVentas=empleado;
            }
        }
        String mensaje = "El empleado con mas ventas es: \n"+
                empleadoMasVentas.toString()+"\n"+
                "El numero de ventas realizadas por este empleado: "+ventas;
        return mensaje;
    }

    //CRUD CLIENTE -------------------------------

    /**
     * Crear un cliente nuevo
     * @param nombre
     * @param apellido
     * @param documento
     * @param edad
     * @param fechaCompra
     * @param heladeria
     * @return boolean
     */
    public boolean crearCliente(String nombre, String apellido, int documento, int edad, String fechaCompra, Heladeria heladeria) {
        if (buscarCliente(documento, heladeria) == null) {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDocumento(documento);
            cliente.setEdad(edad);
            cliente.setOwnedByHeladeria(heladeria);

            LocalDate fechaConvertida;
            try {
                fechaConvertida = LocalDate.parse(fechaCompra, formato);
                cliente.setFechaCompra(fechaConvertida);
                heladeria.clientesList.add(cliente);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Actualizar un cliente existente
     * @param nombre
     * @param apellido
     * @param documento
     * @param edad
     * @param fechaCompra
     * @param nuevoDocumento
     * @param heladeria
     * @return boolean
     */
    public boolean actualizarCliente(String nombre, String apellido, int documento, int edad, String fechaCompra, int nuevoDocumento, Heladeria heladeria) {
        Cliente cliente = buscarCliente(documento, heladeria);
        if (cliente==null){
            return false;
        }else{
            if (buscarCliente(nuevoDocumento, heladeria)==null||documento==nuevoDocumento){
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDocumento(nuevoDocumento);
                cliente.setEdad(edad);
                LocalDate fechaConvertida;
                try {
                    fechaConvertida = LocalDate.parse(fechaCompra, formato);
                    cliente.setFechaCompra(fechaConvertida);
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    /**
     * Mostrar la lista de clientes
     * @param heladeria
     * @return String
     */
    public String mostrarClientes(Heladeria heladeria){
        String mensaje = "";
        for (Cliente cliente:heladeria.clientesList) {
            mensaje += cliente.toString() +"\n___________\n";
        }
        return mensaje;
    }

    /**
     * Eliminar un cliente exixtente
     * @param idCliente
     * @param heladeria
     * @return bolean
     */
    public boolean eliminarCliente(int idCliente, Heladeria heladeria) {
        Cliente clienteEliminar = buscarCliente(idCliente, heladeria);
        if (clienteEliminar == null) {
            return false;
        } else {
            heladeria.clientesList.remove(clienteEliminar);
            return true;
        }
    }

    /**
     * Buscar un cliente por su ID
     * @param idCliente
     * @param heladeria
     * @return Cliente
     */
    public Cliente buscarCliente(int idCliente, Heladeria heladeria) {
        for (Cliente cliente : heladeria.clientesList) {
            if (cliente.getDocumento() == idCliente){
                return cliente;
            }
        }
        return null;
    }

    /**
     * Mostrar cliente mas reciente
     * @param heladeria
     * @returnv String
     */
    public String mostrarClienteMasReciente(Heladeria heladeria){
        LocalDate fechaClienteMasReciente = clientesList.get(0).getFechaCompra();
        Cliente clienteMasReciente = clientesList.get(0);
        for (Cliente cliente: heladeria.clientesList) {
            LocalDate fechaCliente = cliente.getFechaCompra();
            if (fechaCliente.isAfter(fechaClienteMasReciente)){
                fechaClienteMasReciente=fechaCliente;
                clienteMasReciente=cliente;
            }
        }

        String mensaje = "El cliente mas reciente es: \n"+clienteMasReciente.toString();
        return mensaje;

    }

   //CRUD TRANSACCION VENTA-----------------

    /**
     * Crear una nueva transaccion (venta)
     * @param idVenta
     * @param idEmpleadoAsociado
     * @param idClienteAsociado
     * @param idProductoAsociado
     * @param cantidad
     * @param fechaCompra
     * @param heladeria
     * @return boolean
     */
    public boolean crearVenta(int idVenta, int idEmpleadoAsociado, int idClienteAsociado, int idProductoAsociado, int cantidad, String fechaCompra, Heladeria heladeria){
        Empleado empleadoAsociado;
        Cliente clienteAsociado;
        if (buscarVenta(idVenta, heladeria) == null){
            empleadoAsociado = buscarEmpleado(idEmpleadoAsociado, heladeria);
            clienteAsociado = buscarCliente(idClienteAsociado, heladeria);
            if (empleadoAsociado == null || clienteAsociado == null){
                return false;
            }else if (empleadoAsociado.getPuestoTrabajo() == PuestoTrabajo.VENDEDORA){
                Venta venta = new Venta(idVenta,empleadoAsociado,clienteAsociado, heladeria);
                heladeria.ventasList.add(venta);
                empleadoAsociado.getVentasAsociadas().add(venta);
                clienteAsociado.getVentasAsociadas().add(venta);
                venta.crearDetalleVenta(cantidad, fechaCompra, idProductoAsociado);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * Actualizar una venta existente
     * @param idVenta
     * @param nuevoIdVenta
     * @param idEmpleadoAsociado
     * @param idClienteAsociado
     * @param idProductoAsociado
     * @param cantidad
     * @param fechaCompra
     * @param heladeria
     * @return boolean
     */
    public boolean actualizarVenta(int idVenta, int nuevoIdVenta, int idEmpleadoAsociado, int idClienteAsociado, int idProductoAsociado, int cantidad, String fechaCompra, Heladeria heladeria){
        Empleado empleadoAsociado;
        Cliente clienteAsociado;
        if (buscarVenta(nuevoIdVenta, heladeria) == null || nuevoIdVenta==idVenta){
            empleadoAsociado = buscarEmpleado(idEmpleadoAsociado, heladeria);
            clienteAsociado = buscarCliente(idClienteAsociado, heladeria);
            if (empleadoAsociado == null || clienteAsociado == null){
                return false;
            }else if (empleadoAsociado.getPuestoTrabajo() == PuestoTrabajo.VENDEDORA){
                Venta venta = buscarVenta(nuevoIdVenta, heladeria);
                venta.setIdVenta(nuevoIdVenta);
                venta.setClienteAsociado(clienteAsociado);
                venta.setEmpleadoAsociado(empleadoAsociado);
                venta.crearDetalleVenta(cantidad, fechaCompra, idProductoAsociado);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Eliminar una venta existente
     * @param idVenta
     * @param heladeria
     * @return boolean
     */
    public boolean eliminarVenta(int idVenta,  Heladeria heladeria) {
        Venta venta = buscarVenta(idVenta, heladeria);
        if (venta == null) {
            return false;
        } else {
            venta.getClienteAsociado().getVentasAsociadas().remove(venta);
            venta.getEmpleadoAsociado().getVentasAsociadas().remove(venta);
            heladeria.ventasList.remove(venta);
            return true;
        }
    }

    /**
     * Mostrar la lista de ventas
     * @param heladeria
     */
    public String mostrarVentas(Heladeria heladeria){
        String mensaje = "";
        for (Venta venta : heladeria.ventasList) {
            mensaje += venta.toString();
        }
        return mensaje;
    }

    /**
     * Buscar una venta por du ID
     * @param idVenta
     * @param heladeria
     * @return Venta
     */
    public Venta buscarVenta(int idVenta, Heladeria heladeria){
        for (Venta venta : heladeria.ventasList) {
            if (venta.getIdVenta() == idVenta){
                return venta;
            }
        }
        return null;
    }
    public String buscarVentasRealizadasFecha(String fechaVenta, Heladeria heladeria){
        String mensaje = "";
        LocalDate fechaConvertida;
        try {
            fechaConvertida = LocalDate.parse(fechaVenta, formato);
            for (Venta venta: heladeria.ventasList) {
                if (venta.getDetalleVenta().getFechaCompra().equals(fechaConvertida)){
                    mensaje+=venta.toString();
                }
            }
            return mensaje;
        } catch (DateTimeParseException e) {
            return "Algo ha salido mal con la fecha, inténtelo nuevamente";
        }

    }

    //MENUS-------------------------
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
                "5. Buscar producto por id. \n"+
                "6. Buscar producto con stock menor a 100. \n"+
                "7. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }

    /**
     * Menu empleado
     * @return
     */
    public int menuEmpleado(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear empleado. \n"+
                "2. Actualizar empleado. \n"+
                "3. Listar empleados. \n"+
                "4. Elimiar empleado. \n"+
                "5. Buscar empleado por ID. \n"+
                "6. Buscar empleado con mas ventas. \n"+
                "7. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }

    /**
     * Menu con las opciones del crud cliente
     * @return int
     */
    public int menuCliente(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear cliente. \n"+
                "2. Actualizar cliente. \n"+
                "3. Listar cliente. \n"+
                "4. Elimiar cliente. \n"+
                "5. Buscar cliente por ID. \n"+
                "6. Buscar cliente mas reciente. \n"+
                "7. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }

    /**
     * Menu con las opciones de la transaccion venta
     * @return
     */
    public int menuVenta(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Crear venta. \n"+
                "2. Actualizar venta. \n"+
                "3. Listar venta. \n"+
                "4. Elimiar venta. \n"+
                "5. Buscar venta por ID. \n"+
                "6. Buscar ventas realizadas x dia. \n"+
                "7. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }

    /**
     * Menu con opciones para acceder a los otros menus
     * @return int
     */
    public int menuPrincipal(){
        String mensaje = "Seleccione una opcion: \n"+
                "1. Mostrar Opciones cliente \n"+
                "2. Mostrar Opciones empleado \n"+
                "3. Mostrar Opciones producto \n"+
                "4. Mostrar Opciones venta \n"+
                "5. Salir \n";
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return opcion;
    }
}
