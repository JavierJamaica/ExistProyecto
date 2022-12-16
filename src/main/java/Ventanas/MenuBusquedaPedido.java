package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 15/12/2022 - 18:55
 */
public class MenuBusquedaPedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton verButton;
    private JButton idButton;
    private JButton nombreButton;
    private JButton productosButton;
    private JButton atrasButton;
    private JTable table1;
    private JScrollPane tabla;
    private JButton empleadoButton;

    public MenuBusquedaPedido() {
        setContentPane(contenedorPrincipal);
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(new TableModelPedido(XmlBack.LeerPedido()));

            }
        });
        idButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        productosButton.addActionListener(new ActionListener() {
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
                JFrame frame = new VentanaBusquedas();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
