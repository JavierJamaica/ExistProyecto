package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 19:22
 */
public class VentanaEmpleados extends JFrame {
    public JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton atrasButton;
    private JLabel imagenEmpleados;

    public VentanaEmpleados() {
        setContentPane(contenedorPrincipal);
        CargarImagen(imagenEmpleados);

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
    public static void CargarImagen(JLabel imagenEmpleados) {
        imagenEmpleados.setSize(80, 80);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/EmpleadoLogo.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenEmpleados.getWidth(), imagenEmpleados.getHeight(), Image.SCALE_DEFAULT));
        imagenEmpleados.setIcon(icon);
    }
}
