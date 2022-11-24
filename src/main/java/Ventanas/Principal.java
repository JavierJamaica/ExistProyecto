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
    JFrame framePro = new JFrame("Productos");

    JFrame frameEmp = new JFrame("Empleados");
    JFrame framePedi = new JFrame("Pedidos");
    JFrame frameBuscar = new JFrame("Buscar");

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


                framePedi.setLocation(width / 3, height / 3);
                framePedi.setContentPane(new VentanaPedidos().contenedorPrincipal);
                framePedi.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                framePedi.pack();
                framePedi.setVisible(true);

            }
        });
        botonProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;


                framePro.setLocation(width / 3, height / 3);
                framePro.setContentPane(new VentanaProductos().contenedorPrincipal);
                framePro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                framePro.pack();
                framePro.setVisible(true);
            }
        });
        botonEmpleados.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;


                frameEmp.setLocation(width / 3, height / 3);
                frameEmp.setContentPane(new VentanaEmpleados().contenedorPrincipal);
                frameEmp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frameEmp.pack();
                frameEmp.setVisible(true);
            }
        });
        botonBusquedas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;


                frameBuscar.setLocation(width / 3, height / 3);
                frameBuscar.setContentPane(new VentanaBusquedas().contenedorPrincipal);
                frameBuscar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frameBuscar.pack();
                frameBuscar.setVisible(true);

            }
        });
    }

}
