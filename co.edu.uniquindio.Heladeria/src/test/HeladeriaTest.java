import static org.junit.jupiter.api.Assertions.*;

import co.edu.uniquindio.Heladeria.model.*;
import org.junit.jupiter.api.Test;

public class HeladeriaTest {

    @Test
    public void testCrearClienteExitoso() {

        Heladeria heladeria = new Heladeria();
        Cliente cliente = new Cliente();

        String nombre = "Juan";
        String apellido = "Perez";
        int documento = 123456789;
        int edad = 30;
        String fechaCompra = "2023-01-01";

        boolean resultado = heladeria.crearCliente(nombre, apellido, documento, edad, fechaCompra, heladeria);

        assertTrue(resultado);
        assertEquals(1, heladeria.getClientesList().size());
    }
    @Test
    public void testCrearProductoExitoso() {

        Heladeria heladeria = new Heladeria();
        Producto producto = new Producto();

        String sabor = "Chocolate";
        String nombre = "Helado de Chocolate";
        String adicionalTopping = "Nuez";
        String tipoProducto = "Helado";
        int stockAlmacen = 50;
        double precio = 3.5;
        int idProducto = 1;

        boolean resultado = heladeria.crearProducto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, heladeria);

        assertTrue(resultado);
        assertEquals(1, heladeria.getProductosList().size());
    }
    @Test
    public void testEliminarProductoExistente() {

        Heladeria heladeria = new Heladeria();

        String sabor = "Chocolate";
        String nombre = "Helado de Chocolate";
        String adicionalTopping = "Nuez";
        String tipoProducto = "Helado";
        int stockAlmacen = 100;
        double precio = 5.8;
        int idProducto = 1;

        Producto producto = new Producto(sabor, nombre, adicionalTopping, tipoProducto, stockAlmacen, precio, idProducto, heladeria);
        heladeria.getProductosList().add(producto);

        boolean resultado = heladeria.eliminarProducto(idProducto, heladeria);

        assertTrue(resultado);
        assertEquals(0, heladeria.getProductosList().size());
    }
    @Test
    public void testEliminarProductoNoExistente() {

        Heladeria heladeria = new Heladeria();
        Producto producto = new Producto();

        int idProductoNoExistente = 1000;

        boolean resultado = heladeria.eliminarProducto(idProductoNoExistente, heladeria);

        assertFalse(resultado);
        assertEquals(0, heladeria.getProductosList().size());
    }
    @Test
    public void testCrearVentaConEmpleadoNoExistente() {

        Heladeria heladeria = new Heladeria();
        Venta venta = new Venta();

        int idVenta = 3;
        int idEmpleadoAsociadoNoExistente = 12345678;
        int idClienteAsociado = 1234;
        int idProductoAsociado = 2;
        int cantidad = 3;
        String fechaCompra = "2023-03-02";

        boolean resultado = heladeria.crearVenta(idVenta, idEmpleadoAsociadoNoExistente,idClienteAsociado, idProductoAsociado, cantidad, fechaCompra, heladeria);

        assertFalse(resultado);
        assertEquals(0, heladeria.getVentasList().size());
    }
    @Test
    public void testBuscarEmpleadoExistente() {

        Heladeria heladeria = new Heladeria();

        int documentoBuscado = 123456789;

        Empleado empleado = new Empleado();
        empleado.setDocumento(documentoBuscado);
        heladeria.getEmpleadosList().add(empleado);

        Empleado resultado = heladeria.buscarEmpleado(documentoBuscado, heladeria);

        assertNotNull(resultado);
        assertEquals(documentoBuscado, resultado.getDocumento());
    }
}

