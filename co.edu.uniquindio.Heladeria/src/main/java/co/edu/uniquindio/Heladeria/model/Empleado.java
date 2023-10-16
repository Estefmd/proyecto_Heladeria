package co.edu.uniquindio.Heladeria.model;

public class Empleado {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String horario;
    private String antiguedad;
    private String puestoTrabajo;
    private double salario;
    private int cantHorasExtra;

    private Heladeria ownedByHeladeria;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String identificacion, String horario, String antiguedad, String puestoTrabajo, double salario, int cantHorasExtra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.horario = horario;
        this.antiguedad = antiguedad;
        this.puestoTrabajo = puestoTrabajo;
        this.salario = salario;
        this.cantHorasExtra = cantHorasExtra;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCantHorasExtra() {
        return cantHorasExtra;
    }

    public void setCantHorasExtra(int cantHorasExtra) {
        this.cantHorasExtra = cantHorasExtra;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", horario='" + horario + '\'' +
                ", antiguedad='" + antiguedad + '\'' +
                ", puestoTrabajo='" + puestoTrabajo + '\'' +
                ", salario=" + salario +
                ", cantHorasExtra=" + cantHorasExtra;
    }
}
