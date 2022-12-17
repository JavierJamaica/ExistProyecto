package Ventanas;

import Clases.Empleado;
import Clases.XmlBack;
import TableModels.TableModelEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 16/12/2022 - 21:00
 */
public class BuscarEmpPedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner spinner1;
    private JButton verButton;
    private JTable table1;
    private JButton atrasButton;


    public BuscarEmpPedido() {
        setContentPane(contenedorPrincipal);
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() == 0) {
                    JOptionPane.showMessageDialog(null, "El id no puede ser igual a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    List<Empleado> empleados = new ArrayList<>();
                    Empleado empleado = XmlBack.consultarEmpPedido((int) spinner1.getValue());
                    if (XmlBack.consultarIdPedido((int) spinner1.getValue()) != null) {
                        empleados.add(empleado);
                        table1.setModel(new TableModelEmpleado(empleados));}

                }

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaPedido();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
