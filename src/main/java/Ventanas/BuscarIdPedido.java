package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelEmpleado;
import TableModels.TableModelPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 16/12/2022 - 19:13
 */
public class BuscarIdPedido extends JFrame {
    private JSpinner spinner1;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTable table1;
    private JPanel contenedorPrincipal;

    public BuscarIdPedido() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (XmlBack.consultarIdPedido((int) spinner1.getValue()) != null) {
                    table1.setModel(new TableModelPedido(XmlBack.consultarIdPedido((int) spinner1.getValue())));

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
