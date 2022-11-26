package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Principal extends JFrame {
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
        setContentPane(contenedorPrincipal);
        tituloPrincipal.setText("<html><body>Bienvenido a mi <br>gran aplicacion! 🙂</body></html>");
        CargarImagen(imagenLabel);


        botonPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaPedidos();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();

            }
        });
        botonProductos.addActionListener(new ActionListener() {
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
        botonEmpleados.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaEmpleados();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        botonBusquedas.addActionListener(new ActionListener() {
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

    public static void CargarImagen(JLabel imagenLabel) {
        imagenLabel.setSize(300, 300);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/MiAplicacion.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
        imagenLabel.setIcon(icon);
    }

}
