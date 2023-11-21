package co.edu.uniquindio.Heladeria.model;

import java.time.LocalDate;

public class DetalleVenta {
    private int cantidad;
    private LocalDate fechaCompra;
    private Venta OwnedByVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, LocalDate fechaCompra, Venta ownedByVenta) {
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        OwnedByVenta = ownedByVenta;
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

    @Override
    public String toString() {
        return "DetalleVenta " +
                "cantidad :" + cantidad +
                "fechaCompra :" + fechaCompra +
                "OwnedByVenta :" + OwnedByVenta +
                "_____";
    }
}
