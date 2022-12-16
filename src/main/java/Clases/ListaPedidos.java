package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 22:39
 */
public class ListaPedidos {

    private List<Pedido> lista = new ArrayList<>();

    /**
     * Constructor vacio de ListaPedidos
     */
    public ListaPedidos() {
    }

    /**
     * @param pedido se usa para guardarlo en la lista
     */
    public void add(Pedido pedido) {
        lista.add(pedido);
    }

    /**
     * @return devuelve la lista con los pedidos guardados
     */
    public List<Pedido> getListaPedidos() {
        return lista;
    }
}
