package TableModels;

import Clases.Empleado;
import Clases.Producto;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author Javier Jamaica
 * 14/12/2022 - 1:56
 */
public class TableModelEmpleado extends AbstractTableModel {
    String[] cabecera = {"ID", "NOMBRE", "APELLIDO", "FECHA"};
    private final List<Empleado> empleados;

    public TableModelEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> empleados.get(rowIndex).getId();
            case 1 -> empleados.get(rowIndex).getNombre();
            case 2 -> empleados.get(rowIndex).getApellidos();
            case 3 -> empleados.get(rowIndex).getFechaContratacion();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }
}
