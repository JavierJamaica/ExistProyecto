package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 22:39
 */
public class ListaPedidos {
    private List<Pedido> lista = new ArrayList<>();

    public ListaPedidos() {
    }

    public void add(Pedido pedido) {
        lista.add(pedido);
    }

    public List<Pedido> getListaPedidos() {
        return lista;
    }
}
