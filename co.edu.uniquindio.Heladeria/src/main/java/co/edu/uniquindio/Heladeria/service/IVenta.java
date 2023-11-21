package co.edu.uniquindio.Heladeria.service;

import java.time.LocalDate;

public interface IVenta {
    void crearDetalleVenta(int cantidad, LocalDate fechaCompra);
    void eliminarDetalleVenta(String idVenta);

    // double calcularTotal(String idVenta);
}
