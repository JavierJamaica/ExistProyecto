package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:20
 */
public class BuscarNombreProducto extends JFrame {
    private JButton atrasButton;
    private JButton buscarButton;
    private JTextField nombreBuscar;
    private JTextArea textArea1;
    private JPanel contenedorPrincipal;

    public BuscarNombreProducto() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!XmlBack.consultarNombreProducto(nombreBuscar.getText()).equals("")) {
                    textArea1.setText(XmlBack.consultarNombreProducto(nombreBuscar.getText()));

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
