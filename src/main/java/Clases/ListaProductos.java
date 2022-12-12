package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 07/12/2022 - 22:18
 */
public class ListaProductos {
    private List<Producto> lista = new ArrayList<>();

    public ListaProductos() {
    }

    public void add(Producto producto) {
        lista.add(producto);
    }

    public List<Producto> getListaProductos() {
        return lista;
    }
}
