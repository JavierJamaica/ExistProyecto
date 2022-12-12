package Clases;

import Ventanas.Principal;
import Ventanas.pantallaCarga;
import org.xmldb.api.base.XMLDBException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException, XMLDBException {
        int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿Deseas reiniciar la base de datos?", "Mi programa pai", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (ventanaYesNotCancel == 0) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new pantallaCarga();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else if (ventanaYesNotCancel == 1) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new Principal();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
}
