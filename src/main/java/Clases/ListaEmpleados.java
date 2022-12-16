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

    /**
     * Constructor de ListaEmpleados el cual no recibe nada
     */
    public ListaEmpleados() {
    }

    /**
     * Funciona que agrega a la lista un objeto de tipo Empleado
     *
     * @param empleado este se usa para guardarse en la lista
     */
    public void add(Empleado empleado) {
        lista.add(empleado);
    }

    /**
     * @return devuelve la lista con los empleados que se guardaron en ella
     */
    public List<Empleado> getListaEmpleados() {
        return lista;
    }
}
