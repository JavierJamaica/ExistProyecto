package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 3:20
 */
public class BorrarProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner spinner1;
    private JButton borrarButton;
    private JButton atrasButton;

    public BorrarProducto() {
        setContentPane(contenedorPrincipal);
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() != 0) {
                    XmlBack.borrarProducto((int) spinner1.getValue());

                } else {
                    JOptionPane.showMessageDialog(null, "El id no puede ser igual a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaProductos();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
