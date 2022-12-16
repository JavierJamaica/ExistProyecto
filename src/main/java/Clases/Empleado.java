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
     *
     * @return devuelve el id del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id del empelado
     *
     * @param id asigna el id del empleado por medio del parametro recibido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del atributo nombre del empleado
     *
     * @return devuelve el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre
     *
     * @param nombre asigna este parametro al nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo apellido del empleado
     *
     * @return nos devuelve el apellido del empleado
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter del apellido del empleado
     *
     * @param apellidos recibe un apellido que se asigna al empleado
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter de la fecha de contratacion del empleado
     *
     * @return devuelve la fecha de contratacion del empleado
     */
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Setter de la fecha del empleado
     *
     * @param fechaContratacion asigna la fecha del empleado
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * @return devuelve todos los atributos del empleado
     */
    @Override
    public String toString() {
        return id +
                ", " + nombre + '\'' +
                ", " + apellidos + '\'' +
                "," + fechaContratacion;
    }
}
