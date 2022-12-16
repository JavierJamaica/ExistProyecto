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

    /**
     * Constructor del model empleado
     *
     * @param empleados recibe una lista para poder mostrarla luego en una tabla
     */
    public TableModelEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * funcion para saber cuantas filas tendra la tabla
     *
     * @return devuelve el numero de empleados de la lista
     */
    @Override
    public int getRowCount() {
        return empleados.size();
    }

    /**
     * Mediante el array cabecera asigna las columnas de la tabla
     *
     * @return devuelve el numero de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return cabecera.length;
    }

    /**
     * Funcion para escribir los datos
     *
     * @param rowIndex    las filas que seran escritas
     * @param columnIndex las columnas que seran escritas
     * @return
     */
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

    /**
     *
     * @param column  the column being queried
     * @return
     */
    @Override
    public String getColumnName(int column) {
        return cabecera[column];
    }
}
