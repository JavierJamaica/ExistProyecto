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

    /**
     * Constructor de la clase empleado que recibe
     *
     * @param id                identificador del empleado es un valor unico
     * @param nombre            nombre del empleado
     * @param apellidos         apellido del empleado
     * @param fechaContratacion fecha que es de tipo date para asegurarnos de recibir una fecha
     */

    public Empleado(int id, String nombre, String apellidos, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Getter del id del empleado
     * @return devuelve el id del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id del empelado
     * @param id asigna el id del empleado por medio del parametro recibido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
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
        return id +
                ", " + nombre + '\'' +
                ", " + apellidos + '\'' +
                "," + fechaContratacion;
    }
}
