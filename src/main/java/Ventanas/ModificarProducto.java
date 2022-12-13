package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 1:01
 */
public class ModificarProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner spinner1;
    private JTextField nombreNuevo;
    private JTextField descripcionNueva;
    private JButton actualizarButton;
    private JButton atrasButton;
    private JRadioButton nombreRadioButton;
    private JRadioButton descripcionRadioButton;
    private JRadioButton precioRadioButton;
    private JTextField precioNuevo;


    public ModificarProducto() {
        setContentPane(contenedorPrincipal);
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() == 0) {

                    JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    if (nombreRadioButton.isSelected()) {
                        if (nombreNuevo.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                        } else {
                            XmlBack.modificarProducto((int) spinner1.getValue(), nombreNuevo.getText(), -1, "", 1);

                        }


                    } else if (descripcionRadioButton.isSelected()) {

                        if (descripcionNueva.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                        } else {
                            XmlBack.modificarProducto((int) spinner1.getValue(), "", -1, descripcionNueva.getText(), 2);

                        }
                    } else if (precioRadioButton.isSelected()) {
                        try {
                            double precioN = Double.parseDouble(precioNuevo.getText());

                            if (precioN == 0) {
                                JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                            } else {
                                XmlBack.modificarProducto((int) spinner1.getValue(), "", precioN, "", 3);

                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                Limpiar(precioNuevo, descripcionNueva, nombreNuevo, spinner1);
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaProductos();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreRadioButton.isSelected()) {
                    nombreNuevo.setEnabled(true);
                    descripcionNueva.setEnabled(false);
                    precioNuevo.setEnabled(false);


                } else if (descripcionRadioButton.isSelected()) {
                    nombreNuevo.setEnabled(false);
                    descripcionNueva.setEnabled(true);
                    precioNuevo.setEnabled(false);


                } else if (precioRadioButton.isSelected()) {
                    nombreNuevo.setEnabled(false);
                    descripcionNueva.setEnabled(false);
                    precioNuevo.setEnabled(true);


                }
            }
        };
        nombreRadioButton.addActionListener(listener);
        descripcionRadioButton.addActionListener(listener);
        precioRadioButton.addActionListener(listener);
    }

    public static void Limpiar(JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio, JSpinner idProducto) {
        textoNombre.setText("");
        textoDescripcion.setText("");
        textoPrecio.setText("");
        idProducto.setValue(0);
    }
}
