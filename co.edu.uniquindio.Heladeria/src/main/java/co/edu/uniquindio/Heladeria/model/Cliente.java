package co.edu.uniquindio.Heladeria.model;

public class Cliente {
    private String nombre;
    private String apellido;
    private int documento;
    private int edad;
    private String fechaCompra;

    private Heladeria ownedByHeladeria;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int documento, int edad, String fechaCompra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.fechaCompra = fechaCompra;
    }

    public Heladeria getOwnedByHeladeria() {
        return ownedByHeladeria;
    }

    public void setOwnedByHeladeria(Heladeria ownedByHeladeria) {
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
