package TableModels;

import Clases.Producto;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 14/12/2022 - 0:24
 */
public class TableModelProducto extends AbstractTableModel {

    String[] cabecera = {"ID", "NOMBRE", "DESCRIPCION", "PRECIO"};
    private final List<Producto> productos;

    public TableModelProducto(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> productos.get(rowIndex).getId();
            case 1 -> productos.get(rowIndex).getNombre();
            case 2 -> productos.get(rowIndex).getDescripcion();
            case 3 -> productos.get(rowIndex).getPrecio();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }
}
