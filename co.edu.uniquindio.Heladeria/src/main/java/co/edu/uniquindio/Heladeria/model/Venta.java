package co.edu.uniquindio.Heladeria.model;
import co.edu.uniquindio.Heladeria.service.IVenta;

import java.time.LocalDate;

public class Venta implements IVenta {

    private int idVenta;
    private Empleado empleadoAsociado;
    private Cliente clienteAsociado;
    private Producto productoAsociado;
    private DetalleVenta detalleVenta;

    public Venta(int idVenta, int idEmpleadoAsociado, int idClienteAsociado, int idProductoAsociado) {
    }
    public Venta(int idVenta, Empleado empleadoAsociado, Cliente clienteAsociado, Producto productoAsociado) {
        this.idVenta = idVenta;
        this.empleadoAsociado = empleadoAsociado;
        this.clienteAsociado = clienteAsociado;
        this.productoAsociado = productoAsociado;
    }
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public Producto getProductoAsociado() {
        return productoAsociado;
    }

    public void setProductoAsociado(Producto productoAsociado) {
        this.productoAsociado = productoAsociado;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    @Override
    public String toString() {
        return "Venta" +
                "idVenta:" + idVenta + '\n' +
                "empleadoAsociado:" + empleadoAsociado.getDocumento() + '\n' +
                "clienteAsociado:" + clienteAsociado.getDocumento() + '\n' +
                "productoAsociado:" + productoAsociado.getTipoProducto() + '\n' +
                "_____";
    }
    @Override
    public void crearDetalleVenta(int cantidad, LocalDate fechaCompra) {

        this.detalleVenta = new DetalleVenta();
        this.detalleVenta.setCantidad(cantidad);
        this.detalleVenta.setFechaCompra(fechaCompra);

    }
    @Override
    public void eliminarDetalleVenta(String idVenta) {

    }

}
