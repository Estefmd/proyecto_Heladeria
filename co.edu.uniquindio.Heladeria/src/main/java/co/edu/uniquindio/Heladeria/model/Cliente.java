package co.edu.uniquindio.Heladeria.model;

public class Cliente extends Persona{
    private String fechaCompra;

    private Heladeria ownedByHeladeria;

    public Cliente() {
    }
    public Cliente(String nombre, String apellido, int documento, int edad, String fechaCompra, Heladeria ownedByHeladeria) {
        super(nombre, apellido, documento, edad);
        this.fechaCompra = fechaCompra;
        this.ownedByHeladeria = ownedByHeladeria;
    }
    public Heladeria getOwnedByHeladeria() {
        return ownedByHeladeria;
    }
    public void setOwnedByHeladeria(Heladeria ownedByHeladeria) {
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "fechaCompra='" + fechaCompra + '\'' +
                '}';
    }
}
