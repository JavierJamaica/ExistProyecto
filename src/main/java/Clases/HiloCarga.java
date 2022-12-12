package Clases;

import Ventanas.pantallaCarga;

import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Jamaica
 * 03/12/2022 - 1:15
 */
public class HiloCarga extends Thread {

    JProgressBar jProgressBar;
    JButton jButton;
    JLabel giflabel;
    boolean comprobar = false;
    int[] progressValues = {5, 13, 27, 36, 47, 58, 62, 79, 81, 99, 100};

    public HiloCarga(JProgressBar jProgressBar, JButton jButton, JLabel giflabel) {
        this.jProgressBar = jProgressBar;
        this.jButton = jButton;
        this.giflabel = giflabel;
    }

    public void run() {
        for (int i = 0; i < progressValues.length; i++) {
            try {
                Thread.sleep(240);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Establecer el progreso de actualización de la barra de progreso
            jProgressBar.setValue(progressValues[i]);

        }
        // Establece la barra de progreso en modo indeterminado
        jProgressBar.setIndeterminate(false);
        if (jProgressBar.getValue() == 100) {
            comprobar = true;
            JOptionPane.showMessageDialog(null, "Carga de datos completada!!", "Mensaje 🖋️!", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Fallo en la carga de datos!!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
        if (comprobar) {
            pantallaCarga.CargarImagenTermino(giflabel);
        }

        jButton.setEnabled(true);
    }

}
