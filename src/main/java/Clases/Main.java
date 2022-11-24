package Clases;
import Ventanas.Principal;
import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Main {
    public static void main(String[] args) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        JFrame frame = new JFrame("Principal");
        frame.setLocation( width /3 , height/3 );
        frame.setContentPane(new Principal().contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
