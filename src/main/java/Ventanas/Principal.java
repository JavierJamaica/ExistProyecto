package Ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Principal {
    public JPanel contenedorPrincipal;
    private JLabel tituloPrincipal;
    public JButton entrarButton;
    private JButton entrarButton4;
    private JButton entrarButton2;
    private JButton entrarButton3;
    private JLabel tituloPedidos;
    private JLabel tituloProductos;
    private JLabel tituloEmpleados;
    private JLabel tituloBusquedas;
    private JLabel imagenLabel;


    public Principal() {
        imagenLabel.setSize(300, 300);
        tituloPrincipal.setText("<html><body>Bienvenido a mi <br>gran <br>aplicacion!</body></html>");
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/MiAplicacion.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
        imagenLabel.setIcon(icon);
    }

}
