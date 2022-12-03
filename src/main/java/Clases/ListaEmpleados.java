package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 29/10/2022
 */
// Clase que usamos para la creacion del xml de juegos
public class ListaEmpleados {

    private List<Empleado> lista = new ArrayList<>();

    public ListaEmpleados() {
    }

    public void add(Empleado empleado) {
        lista.add(empleado);
    }

    public List<Empleado> getListaEmpleados() {
        return lista;
    }
}
