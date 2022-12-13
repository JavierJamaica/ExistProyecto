package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:21
 */
public class BuscarIdProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner id;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTextArea tabla;

    public BuscarIdProducto() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!XmlBack.consultarIdProductos((int) id.getValue()).equals("")) {
                    tabla.setText(XmlBack.consultarIdProductos((int) id.getValue()));

                }

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaProducto();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
