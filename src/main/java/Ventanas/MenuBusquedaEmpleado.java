package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:04
 */
public class MenuBusquedaEmpleado extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton idButton;
    private JButton nombreButton;
    private JButton fechaButton;
    private JButton atrasButton;
public MenuBusquedaEmpleado() {
    setContentPane(contenedorPrincipal);
    idButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    nombreButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    fechaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new VentanaBusquedas();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            dispose();
        }
    });
}
}
