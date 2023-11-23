package co.edu.uniquindio.Heladeria;
import co.edu.uniquindio.Heladeria.enumeraciones.PuestoTrabajo;
import co.edu.uniquindio.Heladeria.model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Heladeria heladeria = inicializarDatos("nombre");
        mostrarMenuPrincipal(heladeria);
    }


    //CRUD DE LA CLASE CLIENTE---------------------------
    private static void crearCliente(Heladeria heladeria) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente que desea registrar");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente que desea registrar");
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea registrar"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente que desea registrar"));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la fecha de compra (año-mes-dia)");
        boolean exitoso = heladeria.crearCliente(nombre, apellido, documento, edad, fechaCompra, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Cliente creado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
    }
    private static void actualizarCliente(Heladeria heladeria) {
        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea actualizar"));
        int nuevoDocumento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo documento del cliente"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
        String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del cliente"));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la nueva fecha de compra (año-mes-dia)");
        boolean exitoso = heladeria.actualizarCliente(nombre, apellido, documento, edad, fechaCompra, nuevoDocumento, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Cliente actualizado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
    }
    private static void eliminarCliente(Heladeria heladeria) {
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del cliente que desea eliminar: "));
        boolean exitoso = heladeria.eliminarCliente(idCliente, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Cliente eliminado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no encontrado, intentelo nuevamente");
        }
    }
    private static void mostrarClientes(Heladeria heladeria) {
        JOptionPane.showMessageDialog(null, heladeria.mostrarClientes(heladeria));
    }
    private static void buscarClienteID(Heladeria heladeria){
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente que ddesea buscar: "));
        Cliente cliente = heladeria.buscarCliente(idCliente, heladeria);
        if (cliente==null){
            JOptionPane.showMessageDialog(null, "No se pudo encontar el cliente, intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null, cliente.toString());
        }
    }
    private static void mostarClienteMasReciente(Heladeria heladeria){
        JOptionPane.showMessageDialog(null, heladeria.mostrarClienteMasReciente(heladeria));
    }

    //CRUD DE LA CLASE EMPLEADO-------------------------
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

        boolean exitoso = heladeria.crearEmpleado( nombre,  apellido,  documento,  edad, horario, antiguedad, puestoTrabajo, salario, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Empleado creado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
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

        boolean exitoso = heladeria.actualizarEmpleado( nombre,  apellido,  documento,  edad, horario, antiguedad, puestoTrabajo, salario, nuevoDocumento, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Empleado actualizado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
    }
    private static void eliminarEmpleado(Heladeria heladeria) {
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del empleado que desea eliminar: "));
        boolean exitoso = heladeria.eliminarEmpleado(idEmpleado, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Empleado eliminado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Empleado no encontrado, intentelo nuevamente");
        }
    }
    private static void mostrarEmpleados(Heladeria heladeria) {
        JOptionPane.showMessageDialog(null,heladeria.mostrarEmpleados(heladeria));
    }
    private static void buscarEmpleadoID(Heladeria heladeria){
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empleado que ddesea buscar: "));
        Empleado empleado = heladeria.buscarEmpleado(idEmpleado, heladeria);
        if (empleado==null){
            JOptionPane.showMessageDialog(null, "No se pudo encontar el empleadp, intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null, empleado.toString());
        }
    }
    private static void mostrarEmpleadoMasVentas(Heladeria heladeria){
        JOptionPane.showMessageDialog(null, heladeria.mostrarEmpleadoMasVentas(heladeria));
    }

    //CRUD DE LA CLASE PRODUCTO-------------------------------
    public static void crearProducto(Heladeria heladeria) {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor del producto a registrar: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a registrar: ");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional de producto a registrar: ");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto a registrar: ");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible del producto a registrar: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de el producto: "));
        int  idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a registrar"));
        boolean exitoso = heladeria.crearProducto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Producto creado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
    }
    private static void actualizarProducto(Heladeria heladeria) {
        String sabor = JOptionPane.showInputDialog("Ingrese el sabor que desea actualizar: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre que desea actualizar: ");
        String adicionalTopping = JOptionPane.showInputDialog("Ingrese el topping adicional que desea actualizar: ");
        String tipoProducto = JOptionPane.showInputDialog("Ingrese el tipo de producto que desea actualizar: ");
        int stockAlmacen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible que desea actualizar: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio que desea actualizar:o: "));
        int  idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actulizar"));
        int  nuevoIdProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto (este puede ser el anterior)"));
        boolean exitoso = heladeria.actualizarProducto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, nuevoIdProducto, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Producto actualizado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal, intentelo nuevamente");
        }
    }
    private static void eliminarProducto(Heladeria heladeria) {
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea eliminar: "));
        boolean exitoso = heladeria.eliminarProducto(idProducto, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "Producto eliminado de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto, intentelo nuevamente");
        }
    }
    private static void mostrarProductos(Heladeria heladeria) {
        JOptionPane.showMessageDialog(null, heladeria.mostrarProductos(heladeria));
    }
    private static void buscarProductoID(Heladeria heladeria){
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto que ddesea buscar: "));
        Producto producto = heladeria.buscarProducto(idProducto, heladeria);
        if (producto==null){
            JOptionPane.showMessageDialog(null, "No se pudo encontar el producto, intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null, producto.toString());
        }
    }
    private static void buscarProductoStockMenor100(Heladeria heladeria){
        JOptionPane.showMessageDialog(null, heladeria.buscarProductoStockMenor100(heladeria));
    }

    //CRUD DE LA TRANSACCION VENTA
    public static void crearVenta(Heladeria heladeria){
        int idVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la venta: "));
        int idClienteAsociado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente que realiza la compra: "));
        int idProductoAsociado = Integer.parseInt(JOptionPane.showInputDialog("Infrese el ID del producto que se vendera: "));
        int idEmpleadoAsociado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado que realiza la venta: "));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que el cliente desea compar del producto: "));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la fecha de compra (año-mes-dia)");
        boolean exitoso = heladeria.crearVenta(idVenta,idEmpleadoAsociado, idClienteAsociado, idProductoAsociado, cantidad, fechaCompra, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "La venta fue creada de manera exitosa");
            JOptionPane.showMessageDialog(null, heladeria.buscarVenta(idVenta, heladeria).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error, intentelo nuevamente");
        }
    }
    public static void actualizarVenta(Heladeria heladeria){
        int idVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la venta que desea actualizar: "));
        int nuevoIdVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la venta (este puede ser el anterior): "));
        int idClienteAsociado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID actualizado del cliente que realiza la compra: "));
        int idProductoAsociado = Integer.parseInt(JOptionPane.showInputDialog("Infrese el ID actualizado del producto que se vendera: "));
        int idEmpleadoAsociado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID actualizado del empleado que realiza la venta: "));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad actualizada que el cliente desea compar del producto: "));
        String fechaCompra = JOptionPane.showInputDialog("Ingrese la fecha actualizada de compra (año-mes-dia)");
        boolean exitoso = heladeria.actualizarVenta(idVenta, nuevoIdVenta, idEmpleadoAsociado, idClienteAsociado, idProductoAsociado, cantidad, fechaCompra, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "La venta fue actualizada de manera exitosa");
            JOptionPane.showMessageDialog(null, heladeria.buscarVenta(idVenta, heladeria).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error, intentelo nuevamente");
        }
    }
    public static void eliminarVenta(Heladeria heladeria){
        int idVenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del producto que desea eliminar: "));
        boolean exitoso = heladeria.eliminarVenta(idVenta, heladeria);
        if (exitoso){
            JOptionPane.showMessageDialog(null, "La venta fue eliminada de manera exitosa");
        }else{
            JOptionPane.showMessageDialog(null, "Venta no encontrada, intentelo nuevamente");
        }
    }
    public static  void mostrarVentas(Heladeria heladeria){
        JOptionPane.showMessageDialog(null, heladeria.mostrarVentas(heladeria));
    }
    private static void buscarVentaID(Heladeria heladeria){
        int idVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del venta que ddesea buscar: "));
        Venta venta = heladeria.buscarVenta(idVenta, heladeria);
        if (venta==null){
            JOptionPane.showMessageDialog(null, "No se pudo encontar la venta, intentelo nuevamente");
        }else{
            JOptionPane.showMessageDialog(null, venta.toString());
        }
    }
    private static void buscarVentaDia(Heladeria heladeria) {
        String fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de la cual desea saber las ventas: ");
        JOptionPane.showMessageDialog(null, heladeria.buscarVentasRealizadasFecha(fechaVenta, heladeria));
    }

    //MENUS DE LOS DIFERENTES CRUDS Y TRANSACCIONES-----------------
    public static void mostrarMenuProducto(Heladeria heladeria){
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
                    buscarProductoID(heladeria);
                    break;
                case 6:
                    buscarProductoStockMenor100(heladeria);
                    break;
            }
        } while (opcion != 7);
    }

    public static void mostrarMenuEmpleado(Heladeria heladeria){
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
                    buscarEmpleadoID(heladeria);
                    break;
                case 6:
                    mostrarEmpleadoMasVentas(heladeria);
                    break;
            }
        } while (opcion != 7);
    }

    public static void mostrarMenuCliente(Heladeria heladeria){
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
                    buscarClienteID(heladeria);
                    break;
                case 6:
                    mostarClienteMasReciente(heladeria);
                    break;
            }
        } while (opcion != 7);
    }

    public static void mostrarMenuVenta(Heladeria heladeria){
        int opcion = 0;
        do {
            opcion = heladeria.menuVenta();
            switch (opcion){
                case 1:
                    crearVenta(heladeria);
                    break;
                case 2:
                    actualizarVenta(heladeria);
                    break;
                case 3:
                    mostrarVentas(heladeria);
                    break;
                case 4:
                    eliminarVenta(heladeria);
                    break;
                case 5:
                    buscarVentaID(heladeria);
                    break;
                case 6:
                    buscarVentaDia(heladeria);
                    break;
            }
        } while (opcion != 7);
    }

    public static void mostrarMenuPrincipal(Heladeria heladeria){
        int opcion = 0;
        do {
            opcion = heladeria.menuPrincipal();
            switch (opcion){
                case 1:
                    mostrarMenuCliente(heladeria);
                    break;
                case 2:
                    mostrarMenuEmpleado(heladeria);
                    break;
                case 3:
                    mostrarMenuProducto(heladeria);
                    break;
                case 4:
                    mostrarMenuVenta(heladeria);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa");
                    break;
            }
        } while (opcion != 5);
    }

    //INICIALIZACION DE DATOS----------------------------------------
    private static Heladeria inicializarDatos(String nombre) {
        Heladeria heladeria = new Heladeria(nombre);
        heladeria.crearProducto("Vainilla", "", "Chispas", "Paleta", 600, 1000, 12345, heladeria);
        heladeria.crearProducto("Chocolate", "Galleta", "Chispas", "Helado", 100, 12000, 1234, heladeria);
        heladeria.crearEmpleado("Juan", "Gonzales", 1234, 19, "12:00 p.m - 8:00p.m", 1, 3, 10000, heladeria);
        heladeria.crearEmpleado("Maria", "Perez", 12345, 24, "12:00 p.m - 8:00p.m", 1, 2, 20000, heladeria);
        heladeria.crearCliente("Valentina", "Naranjo", 1234, 17, "2023-11-20", heladeria);
        heladeria.crearVenta(1234, 1234, 1234, 1234, 20, "2023-11-20", heladeria);
        return heladeria;
    }
}



