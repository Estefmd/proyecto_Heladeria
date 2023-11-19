package co.edu.uniquindio.Heladeria.model;

import java.util.Date;

public class Cliente extends Persona{
    private Date fechaCompra;

    private Heladeria ownedByHeladeria;

    public Cliente() {
    }
    public Cliente(String nombre, String apellido, int documento, int edad, Date fechaCompra, Heladeria ownedByHeladeria) {
        super(nombre, apellido, documento, edad);
        this.fechaCompra = fechaCompra;
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Heladeria getOwnedByHeladeria() {
        return ownedByHeladeria;
    }

    public void setOwnedByHeladeria(Heladeria ownedByHeladeria) {
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public String toString() {
        return
                "nombre: " + nombre + '\n'+
                "apellido:" + apellido + '\n' +
                "documento:" + documento + '\n'+
                "edad:" + edad + '\n'+
                "fecha de compra: " +fechaCompra;
    }
}
