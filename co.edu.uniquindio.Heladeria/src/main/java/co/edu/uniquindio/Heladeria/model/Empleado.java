package co.edu.uniquindio.Heladeria.model;

public class Empleado extends Persona{
    private String horario;
    private String antiguedad;
    private String puestoTrabajo;
    private double salario;
    private int cantHorasExtra;
    private Heladeria ownedByHeladeria;

    public Empleado() {
    }
    public Empleado(String nombre, String apellido, int documento, int edad, String horario, String antiguedad, String puestoTrabajo, double salario, int cantHorasExtra, Heladeria ownedByHeladeria) {
        super(nombre, apellido, documento, edad);
        this.horario = horario;
        this.antiguedad = antiguedad;
        this.puestoTrabajo = puestoTrabajo;
        this.salario = salario;
        this.cantHorasExtra = cantHorasExtra;
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public Heladeria getOwnedByHeladeria() {
        return ownedByHeladeria;
    }
    public void setOwnedByHeladeria(Heladeria ownedByHeladeria) {
        this.ownedByHeladeria = ownedByHeladeria;
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
        return "Empleado{" +
                "horario='" + horario + '\'' +
                ", antiguedad='" + antiguedad + '\'' +
                ", puestoTrabajo='" + puestoTrabajo + '\'' +
                ", salario=" + salario +
                ", cantHorasExtra=" + cantHorasExtra +
                '}';
    }
}
