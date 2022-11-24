package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:20
 */
public class VentanaPedidos {
    public JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JLabel imagenPedidos;

    public VentanaPedidos() {

        imagenPedidos.setSize(80, 80);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/PedidosLogo.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenPedidos.getWidth(), imagenPedidos.getHeight(), Image.SCALE_DEFAULT));
        imagenPedidos.setIcon(icon);

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
