package TableModels;

import Clases.Empleado;
import Clases.Pedido;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 15/12/2022 - 19:03
 */
public class TableModelPedido extends AbstractTableModel {
    String[] cabecera = {"ID", "NOMBRE"};
    private final List<Pedido> pedidos;

    /**
     * Funciona igual que la clase TableModelEmpleado
     */
    public TableModelPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> pedidos.get(rowIndex).getId();
            case 1 -> pedidos.get(rowIndex).getNombre();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }
}
