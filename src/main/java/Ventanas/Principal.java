package Ventanas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 16:52
 */
public class Principal {
    public JPanel ContenedorPrincipal;
    public JLabel tituloPrincipal;
    public JButton button1;

    public Principal(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("siiiu");
            }
        });
    }

}
