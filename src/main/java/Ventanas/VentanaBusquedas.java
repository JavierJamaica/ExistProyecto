package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:21
 */
public class VentanaBusquedas extends JFrame {

    public JPanel contenedorPrincipal;
    private JButton productosButton;
    private JButton atrasButton;
    private JButton empleadosBoton;
    private JButton pedidosButton;
    private JLabel imagenBusqueda;


    public VentanaBusquedas() {
        imagenBusqueda.setSize(60, 60);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/LupaBusqueda.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenBusqueda.getWidth(), imagenBusqueda.getHeight(), Image.SCALE_DEFAULT));
        imagenBusqueda.setIcon(icon);
        pedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        empleadosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(Arrays.toString(VentanaBusquedas.getFrames()));

                VentanaBusquedas.this.dispose();
            }
        });
    }
}
