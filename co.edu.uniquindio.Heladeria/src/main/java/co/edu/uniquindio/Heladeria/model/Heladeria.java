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
     */
    public void crearProducto(String sabor, String nombre, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto, Heladeria heladeria) {
        if (buscarProducto(idProducto, heladeria) == null){
            Producto producto = new Producto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, heladeria);
            heladeria.productosList.add(producto);
        }else{
            JOptionPane.showMessageDialog(null,"Algo ha salido mal, intentalo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
     */
    public void actualizarProducto(String sabor, String nombre, String adicionalTopping, String tipoProducto, int stockAlmacen, double precio, int idProducto, int nuevoIdProducto, Heladeria heladeria){
        Producto producto = buscarProducto(idProducto, heladeria);
        if (producto==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el producto, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            if (buscarProducto(nuevoIdProducto, heladeria)==null||idProducto==nuevoIdProducto){
                    producto.setIdProducto(nuevoIdProducto);
                    producto.setNombre(nombre);
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
    public void eliminarProducto(int idProducto, Heladeria heladeria) {
        Producto productoAEliminar = buscarProducto(idProducto, heladeria);
        if (productoAEliminar == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            productosList.remove(productoAEliminar);
            JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
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
     */
    public void buscarProductoStockMenor100(Heladeria heladeria){
        String mensaje = "";
        for (Producto producto: heladeria.productosList) {
            if (producto.getStockAlmacen()<100){
                mensaje+=producto.toString();
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
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
     */
    public void crearEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad,int puestoTrabajo, double salario, Heladeria heladeria) {
        if (buscarEmpleado(documento, heladeria) != null){
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
    public void actualizarEmpleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, int puestoTrabajo, double salario, int nuevoIdEmpleado, Heladeria heladeria) {
        Empleado empleado = buscarEmpleado(documento, heladeria);
        if (empleado==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el empleado, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
                        JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida. Intente nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "El empleado ha sido actualizado con Exito!");
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un empleado registrgado con el nuevo documento, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * eliminar empleado
     * @param idEmpleado
     */
    public void eliminarEmpleado(int idEmpleado, Heladeria heladeria) {
        Empleado empleadoEliminar = buscarEmpleado(idEmpleado, heladeria);
        if (empleadoEliminar == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            heladeria.empleadosList.remove(empleadoEliminar);
            JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");

        }
    }

    /**
     * Mostrar lista empleados
     */
    public void mostrarEmpleados(Heladeria heladeria){
        String mensaje = "";
        for (Empleado empleado:heladeria.empleadosList) {
            mensaje += empleado.toString() +"\n___________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
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
     */
    public void mostrarEmpleadoMasVentas(Heladeria heladeria){
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
                "El nuemo de ventas realizadas por este empleado: "+ventas;
        JOptionPane.showMessageDialog(null, mensaje);
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
     */
    public void crearCliente(String nombre, String apellido, int documento, int edad, String fechaCompra, Heladeria heladeria) {
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
                JOptionPane.showMessageDialog(null, "El cliente ha sido creado con éxito!");
                heladeria.clientesList.add(cliente);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente.","Error!", JOptionPane.ERROR_MESSAGE);
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
     */
    public void actualizarCliente(String nombre, String apellido, int documento, int edad, String fechaCompra, int nuevoDocumento, Heladeria heladeria) {
        Cliente cliente = buscarCliente(documento, heladeria);
        if (cliente==null){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el cliente, intentelo de nuevo",  "Error!", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado con Exito!");
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que ya haya un cliente registrgado con el nuevo documento, intentelo nuevamente",  "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
     * Mostrar la lista de clientes
     * @param heladeria
     */
    public void mostrarClientes(Heladeria heladeria){
        String mensaje = "";
        for (Cliente cliente:heladeria.clientesList) {
            mensaje += cliente.toString() +"\n___________\n";
        }
        JOptionPane.showMessageDialog(null,mensaje);
    }

    /**
     * Eliminar un cliente exixtente
     * @param idCliente
     * @param heladeria
     */
    public void eliminarCliente(int idCliente, Heladeria heladeria) {
        Cliente clienteEliminar = buscarCliente(idCliente, heladeria);
        if (clienteEliminar == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado",  "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            heladeria.clientesList.remove(clienteEliminar);
            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
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

    public void mostrarClienteMasReciente(Heladeria heladeria){
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
     */
    public void crearVenta(int idVenta, int idEmpleadoAsociado, int idClienteAsociado, int idProductoAsociado, int cantidad, String fechaCompra, Heladeria heladeria){
        Empleado empleadoAsociado;
        Cliente clienteAsociado;
        if (buscarVenta(idVenta, heladeria) == null){
            empleadoAsociado = buscarEmpleado(idEmpleadoAsociado, heladeria);
            clienteAsociado = buscarCliente(idClienteAsociado, heladeria);
            if (empleadoAsociado == null || clienteAsociado == null){
                JOptionPane.showMessageDialog(null, "Alguno de los Id ingresados no se encuentra en el sistema");
            }else if (empleadoAsociado.getPuestoTrabajo() == PuestoTrabajo.VENDEDORA){
                Venta venta = new Venta(idVenta,empleadoAsociado,clienteAsociado, heladeria);
                heladeria.ventasList.add(venta);
                empleadoAsociado.getVentasAsociadas().add(venta);
                clienteAsociado.getVentasAsociadas().add(venta);
                venta.crearDetalleVenta(cantidad, fechaCompra, idProductoAsociado);
                JOptionPane.showMessageDialog(null, venta.toString());
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que el empleado que ha ingresado no sea un(a) vendedor(a)");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya se encuentra registrada una venta con este ID");
        }
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
     */
    public void actualizarVenta(int idVenta, int nuevoIdVenta, int idEmpleadoAsociado, int idClienteAsociado, int idProductoAsociado, int cantidad, String fechaCompra, Heladeria heladeria){
        Empleado empleadoAsociado;
        Cliente clienteAsociado;
        if (buscarVenta(nuevoIdVenta, heladeria) == null || nuevoIdVenta==idVenta){
            empleadoAsociado = buscarEmpleado(idEmpleadoAsociado, heladeria);
            clienteAsociado = buscarCliente(idClienteAsociado, heladeria);
            if (empleadoAsociado == null || clienteAsociado == null){
                JOptionPane.showMessageDialog(null, "Alguno de los Id ingresados no se encuentra en el sistema");
            }else if (empleadoAsociado.getPuestoTrabajo() == PuestoTrabajo.VENDEDORA){
                Venta venta = buscarVenta(nuevoIdVenta, heladeria);
                venta.setIdVenta(nuevoIdVenta);
                venta.setClienteAsociado(clienteAsociado);
                venta.setEmpleadoAsociado(empleadoAsociado);
                venta.crearDetalleVenta(cantidad, fechaCompra, idProductoAsociado);
                JOptionPane.showMessageDialog(null, venta.toString());
            }else{
                JOptionPane.showMessageDialog(null, "Es posible que el empleado que ha ingresado no sea un(a) vendedor(a)");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya se encuentra registrada una venta con este nuevo ID");
        }
    }

    /**
     * Eliminar una venta existente
     * @param idVenta
     * @param heladeria
     */
    public void eliminarVenta(int idVenta,  Heladeria heladeria) {
        Venta venta = buscarVenta(idVenta, heladeria);
        if (venta == null) {
            JOptionPane.showMessageDialog(null, "La venta no fue encontrada");
        } else {
            venta.getClienteAsociado().getVentasAsociadas().remove(venta);
            venta.getEmpleadoAsociado().getVentasAsociadas().remove(venta);
            heladeria.ventasList.remove(venta);
            JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente!");
        }
    }

    /**
     * Mostrar la olista de ventas
     * @param heladeria
     */
    public void mostrarVentas(Heladeria heladeria){
        String mensaje = "";
        for (Venta venta : heladeria.ventasList) {
            mensaje += venta.toString();
        }
        JOptionPane.showMessageDialog(null,mensaje);
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
    public void buscarVentasRealizadasFecha(String fechaVenta, Heladeria heladeria){
        String mensaje = "";
        LocalDate fechaConvertida;
        try {
            fechaConvertida = LocalDate.parse(fechaVenta, formato);
            for (Venta venta: heladeria.ventasList) {
                if (venta.getDetalleVenta().getFechaCompra().equals(fechaConvertida)){
                    mensaje+=venta.toString();
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
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
