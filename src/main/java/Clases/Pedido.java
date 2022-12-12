package Clases;

import java.io.Serializable;
import java.util.List;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 22:30
 */
public class Pedido implements Serializable {

    private int id;
    private String nombre;
    private String empleado;
    private List<Producto> productos;

    public Pedido(int id, String nombre, String empleado, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.empleado = empleado;
        this.productos = productos;
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

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleado='" + empleado + '\'' +
                ", productos=" + productos +
                '}';
    }
}
