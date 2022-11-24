package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:21
 */
public class VentanaProductos {
    public JPanel contenedorPrincipal;
    private JButton crearBoton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JLabel imagenProductos;

    public VentanaProductos() {
        imagenProductos.setSize(80, 80);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/ProductosLogo.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenProductos.getWidth(), imagenProductos.getHeight(), Image.SCALE_DEFAULT));
        imagenProductos.setIcon(icon);
        crearBoton.addActionListener(new ActionListener() {
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
