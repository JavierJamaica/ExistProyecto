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
    private Empleado empleado;
    private List<Producto> productos;

    /**
     * Constructor de la clase pedido
     *
     * @param id        que recibe el constructor para aignarlo al objeto pedido
     * @param nombre    que recibe el constructor para asignarlo al objeto pedido
     * @param empleado  es un objeto que recibe el constructor para asignarlo al pedido
     * @param productos una lista de objetos de tipo Producto para asignarlos en el pedido
     */
    public Pedido(int id, String nombre, Empleado empleado, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.empleado = empleado;
        this.productos = productos;
    }

    /**
     * Getters y Setter del objeto Pedido, se usan para ver o asignar los atributos del objeto
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return nos devuleve todos los atributos del objeto
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleado=" + empleado +
                ", productos=" + productos +
                '}';
    }
}
