package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 07/12/2022 - 22:18
 */
public class ListaProductos {
    private List<Producto> lista = new ArrayList<>();

    /**
     * Constructor vacio de ListaProductos
     */
    public ListaProductos() {
    }

    /**
     * @param producto se usa para guardarlo en la lista
     */
    public void add(Producto producto) {
        lista.add(producto);
    }

    /**
     * @return devuelve la lista con los productos guardados
     */

    public List<Producto> getListaProductos() {
        return lista;
    }
}
