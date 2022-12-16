package Clases;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Javier Jamaica
 * 01/12/2022 - 20:16
 */
public class Empleado implements Serializable {
    private int id;
    private String nombre;
    private String apellidos;
    private Date fechaContratacion;

    public Empleado(int id, String nombre, String apellidos, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return   id +
                ", " + nombre + '\'' +
                ", " + apellidos + '\'' +
                "," + fechaContratacion;
    }
}
