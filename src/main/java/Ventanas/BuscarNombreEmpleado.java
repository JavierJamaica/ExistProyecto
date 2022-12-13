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
public class BuscarNombreEmpleado extends JFrame {
    private JButton buscarButton;
    private JButton atrasButton;
    private JTextField nombreBuscar;
    private JTextArea textArea1;
    private JPanel contenedorPrincipal;

    public BuscarNombreEmpleado() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!XmlBack.consultarNombreEmpleado(nombreBuscar.getText()).equals("")) {
                    textArea1.setText(XmlBack.consultarNombreEmpleado(nombreBuscar.getText()));

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
