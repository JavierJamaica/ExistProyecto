package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:22
 */
public class VentanaEmpleados {
    public JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JLabel imagenEmpleados;

    public VentanaEmpleados() {
        imagenEmpleados.setSize(90, 90);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/EmpleadoLogo.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenEmpleados.getWidth(), imagenEmpleados.getHeight(), Image.SCALE_DEFAULT));
        imagenEmpleados.setIcon(icon);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
