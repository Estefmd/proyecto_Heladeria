package co.edu.uniquindio.Heladeria.service;

import co.edu.uniquindio.Heladeria.model.Producto;

import java.time.LocalDate;

public interface IVenta {
    void crearDetalleVenta(int cantidad, String fechaCompra, int idProductoAsosiado);

}
