package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:20
 */
public class VentanaPedidos extends JFrame {
    public JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JLabel imagenPedidos;


    public VentanaPedidos() {

        setContentPane(contenedorPrincipal);
        CargarImagen(imagenPedidos);

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
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new Principal();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });

    }

    public static void CargarImagen(JLabel imagenPedidos) {
        imagenPedidos.setSize(80, 80);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/PedidosLogo.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenPedidos.getWidth(), imagenPedidos.getHeight(), Image.SCALE_DEFAULT));
        imagenPedidos.setIcon(icon);
    }
}
