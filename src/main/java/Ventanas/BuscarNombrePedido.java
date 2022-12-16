package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 16/12/2022 - 23:01
 */
public class BuscarNombrePedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField textField1;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTable table1;

    public BuscarNombrePedido() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    table1.setModel(new TableModelPedido(XmlBack.BuscarNombrePedido(textField1.getText())));

                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaPedido();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
