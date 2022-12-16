package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelProducto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 6:17
 */
public class BuscarPrecioProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTextField precioBuscar;
    private JTable table1;
    private JTextArea textArea1;

    public BuscarPrecioProducto() {
        setContentPane(contenedorPrincipal);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!precioBuscar.getText().equals("")) {
                        if (Double.parseDouble(precioBuscar.getText()) <= 0) {
                            JOptionPane.showMessageDialog(null, "El precio tiene que ser mayor que 0!!", "Error!", JOptionPane.ERROR_MESSAGE);
                        } else {
                            table1.setModel(new TableModelProducto(XmlBack.consultarPrecioProducto(Double.parseDouble(precioBuscar.getText()))));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes poner un precio!!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero!!", "Error!", JOptionPane.ERROR_MESSAGE);

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
