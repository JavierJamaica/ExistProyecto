package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 6:17
 */
public class BuscarPrecioProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTextField precioBuscar;
    private JTextArea textArea1;

    public BuscarPrecioProducto() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!XmlBack.consultarPrecioProducto(Double.parseDouble(precioBuscar.getText())).equals("")) {
                    textArea1.setText(XmlBack.consultarPrecioProducto(Double.parseDouble(precioBuscar.getText())));

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
