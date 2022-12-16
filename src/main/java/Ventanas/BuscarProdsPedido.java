package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 16/12/2022 - 22:44
 */
public class BuscarProdsPedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner spinner1;
    private JButton verProductosButton;
    private JButton atrasButton;
    private JTable table1;

    public BuscarProdsPedido() {
        setContentPane(contenedorPrincipal);
        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() == 0){
                    JOptionPane.showMessageDialog(null, "El id no puede ser igual a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    table1.setModel(new TableModelProducto(XmlBack.consultarProdsPedido((int) spinner1.getValue())));

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
