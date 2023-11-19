package co.edu.uniquindio.Heladeria.model;

import co.edu.uniquindio.Heladeria.enumeraciones.PuestoTrabajo;

public class Empleado extends Persona{
    private String horario;
    private int antiguedad;
    private PuestoTrabajo puestoTrabajo;
    private double salario;
    private Heladeria ownedByHeladeria;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int documento, int edad, String horario, int antiguedad, PuestoTrabajo puestoTrabajo, double salario, Heladeria ownedByHeladeria) {
        super(nombre, apellido, documento, edad);
        this.horario = horario;
        this.antiguedad = antiguedad;
        this.puestoTrabajo = puestoTrabajo;
        this.salario = salario;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public PuestoTrabajo getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return
                "nombre: " + nombre + '\n' +
                "apellido:" + apellido + '\n' +
                "documento:" + documento + '\n'+
                "edad:" + edad + '\n'+
                "horario:'" + horario + '\n'+
                "antiguedad:" + antiguedad + '\n'+
                "puestoTrabajo:" + puestoTrabajo + '\n'+
                "salario:" + salario;
    }
}
