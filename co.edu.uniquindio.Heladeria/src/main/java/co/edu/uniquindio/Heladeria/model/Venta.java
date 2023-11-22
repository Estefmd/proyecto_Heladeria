package co.edu.uniquindio.Heladeria.model;
import co.edu.uniquindio.Heladeria.service.IVenta;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Venta implements IVenta {

    private int idVenta;
    private Empleado empleadoAsociado;
    private Cliente clienteAsociado;
    private DetalleVenta detalleVenta;
    private Heladeria ownedByHeladeria;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Venta() {
    }
    public Venta(int idVenta, Empleado empleadoAsociado, Cliente clienteAsociado, Heladeria ownedByHeladeria) {
        this.idVenta = idVenta;
        this.empleadoAsociado = empleadoAsociado;
        this.clienteAsociado = clienteAsociado;
        this.ownedByHeladeria = ownedByHeladeria;
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

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    @Override
    public String toString() {
        double total = getDetalleVenta().getCantidad() * getDetalleVenta().getProductoAsociado().getPrecioTotal();
        return
                "idVenta:" + idVenta + '\n' +
                "Nombre empleado asociado: " + empleadoAsociado.getNombre()+" "+empleadoAsociado.getApellido()+ '\n' +
                "Cc. empleado asociado: " + empleadoAsociado.getDocumento() + '\n' +
                "Nombre cliente asociado: " + clienteAsociado.getNombre()+" "+clienteAsociado.getApellido() + '\n' +
                "Cc. cliente asociado: " + clienteAsociado.getDocumento() + '\n' +
                "Producto: " + getDetalleVenta().getProductoAsociado().getNombre() + '\n' +
                "Cantidad comprada: " + getDetalleVenta().getCantidad()+ '\n' +
                "Fecha compra: " + getDetalleVenta().getFechaCompra()+ '\n' +
                "Total: " + total + '\n' +
                "_____\n";
    }
    @Override
    public void crearDetalleVenta(int cantidad, String fechaCompra, int idProductoAsosiado) {
        Producto producto = ownedByHeladeria.buscarProducto(idProductoAsosiado, ownedByHeladeria);
        LocalDate fechaConvertida;
        if (producto!=null && (producto.getStockAlmacen()-cantidad)>0){
            try {
                int cantidadActual = producto.getStockAlmacen();
                producto.setStockAlmacen(cantidadActual-cantidad);
                fechaConvertida = LocalDate.parse(fechaCompra, formato);
                this.detalleVenta = new DetalleVenta();
                this.detalleVenta.setCantidad(cantidad);
                this.detalleVenta.setFechaCompra(fechaConvertida);
                this.detalleVenta.setProductoAsociado(producto);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Algo ha salido mal con la fecha, inténtelo nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
          JOptionPane.showMessageDialog(null, "Revise e id del producto, este no fue encontrado o el stock no esta disponible");
        }

    }


}
