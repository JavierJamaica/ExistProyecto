package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Principal {
    public JPanel contenedorPrincipal;
    private JLabel tituloPrincipal;
    public JButton botonPedidos;
    private JButton botonProductos;
    private JButton botonEmpleados;
    private JButton botonBusquedas;
    private JLabel tituloPedidos;
    private JLabel tituloProductos;
    private JLabel tituloEmpleados;
    private JLabel tituloBusquedas;
    private JLabel imagenLabel;


    public Principal() {
        imagenLabel.setSize(300, 300);
        tituloPrincipal.setText("<html><body>Bienvenido a mi <br>gran aplicacion! 🙂</body></html>");
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/MiAplicacion.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
        imagenLabel.setIcon(icon);
        botonPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;

                JFrame frame = new JFrame("Principal");
                frame.setLocation(width / 3, height / 3);
                frame.setContentPane(new VentanaPedidos().contenedorPrincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonBusquedas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
