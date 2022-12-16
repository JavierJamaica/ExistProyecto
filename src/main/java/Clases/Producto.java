package Clases;

import java.io.Serializable;

/**
 * @author Javier Jamaica
 * 01/12/2022 - 20:16
 */
public class Producto implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    /**
     * Construcor del objeto Producto
     *
     * @param id          se usa para asignarlo en el objeto
     * @param nombre      se usa para asignarlo en el objeto
     * @param descripcion se usa para asignarla en el objeto
     * @param precio      se usa para asiganorlo en el objeto
     */
    public Producto(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Constructor vacio del objeto
     */
    public Producto() {

    }

    /**
     * Getters y Setters del objeto Producto
     */
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return devuelve todos los atributos del objeto Producto
     */

    @Override
    public String toString() {
        return id +
                ", " + nombre +
                ", " + descripcion +
                ", " + precio;
    }
}
