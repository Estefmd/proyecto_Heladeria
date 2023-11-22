package co.edu.uniquindio.Heladeria.model;

import java.time.LocalDate;

public class DetalleVenta {
    private int cantidad;
    private LocalDate fechaCompra;
    private Venta OwnedByVenta;
    private Producto productoAsociado;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, LocalDate fechaCompra, Venta ownedByVenta, Producto productoAsociado) {
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        OwnedByVenta = ownedByVenta;
        this.productoAsociado = productoAsociado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Venta getOwnedByVenta() {
        return OwnedByVenta;
    }

    public void setOwnedByVenta(Venta ownedByVenta) {
        OwnedByVenta = ownedByVenta;
    }

    public Producto getProductoAsociado() {
        return productoAsociado;
    }

    public void setProductoAsociado(Producto productoAsociado) {
        this.productoAsociado = productoAsociado;
    }

    @Override
    public String toString() {
        return "DetalleVenta " +
                "cantidad :" + cantidad + '\n'+
                "fechaCompra :" + fechaCompra +'\n'+
                "_____";
    }
}
