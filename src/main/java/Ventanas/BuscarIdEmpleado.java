package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:20
 */
public class BuscarIdEmpleado extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTable table1;

    public BuscarIdEmpleado() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (XmlBack.consultarIdEmpleado((int) spinner1.getValue())!=null) {
                    table1.setModel(new TableModelEmpleado(XmlBack.consultarIdEmpleado((int)spinner1.getValue())));

                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaEmpleado();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
