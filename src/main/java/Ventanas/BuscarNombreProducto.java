package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:20
 */
public class BuscarNombreProducto extends JFrame {
    private JButton atrasButton;
    private JButton buscarButton;
    private JTextField nombreBuscar;
    private JTextArea textArea1;
    private JPanel contenedorPrincipal;
    private JTable table1;

    public BuscarNombreProducto() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nombreBuscar.getText().equals("")) {
                 table1.setModel(new TableModelProducto(XmlBack.consultarNombreProducto(nombreBuscar.getText())));
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio!", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaProducto();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();

            }
        });
    }
}
