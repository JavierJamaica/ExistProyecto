package Clases;

import Ventanas.Principal;

import javax.swing.*;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().ContenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
