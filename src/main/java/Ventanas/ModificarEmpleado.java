package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 4:57
 */
public class ModificarEmpleado extends JFrame {
    private JPanel contenedorPrincipal;
    private JSpinner spinner1;
    private JRadioButton nombreRadioButton;
    private JRadioButton apellidoRadioButton;
    private JRadioButton fechaRadioButton;
    private JButton atrasButton;
    private JButton actualizarButton;
    private JTextField nuevoNombre;
    private JTextField nuevoApellido;
    private JTextField nuevaFecha;


    public ModificarEmpleado() {
        setContentPane(contenedorPrincipal);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(true);
                    nuevoApellido.setEnabled(false);
                    nuevaFecha.setEnabled(false);


                } else if (apellidoRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(false);
                    nuevoApellido.setEnabled(true);
                    nuevaFecha.setEnabled(false);


                } else if (fechaRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(false);
                    nuevoApellido.setEnabled(false);
                    nuevaFecha.setEnabled(true);


                }
            }
        };
        nombreRadioButton.addActionListener(listener);
        apellidoRadioButton.addActionListener(listener);
        fechaRadioButton.addActionListener(listener);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaEmpleados();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() == 0) {

                    JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    if (nombreRadioButton.isSelected()) {
                        if (nuevoNombre.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                        } else {
                            XmlBack.modificarEmpleado((int) spinner1.getValue(), nuevoNombre.getText(), "", new Date(), 1);

                        }


                    } else if (apellidoRadioButton.isSelected()) {

                        if (nuevoApellido.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                        } else {
                            XmlBack.modificarEmpleado((int) spinner1.getValue(), "", nuevoApellido.getText(), new Date(), 2);

                        }
                    } else if (fechaRadioButton.isSelected()) {
                        try {

                            if (nuevaFecha.getText().equals("")) {

                                JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0!", "Error!", JOptionPane.ERROR_MESSAGE);

                            } else {
                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                Date fechaContratacion = format.parse(nuevaFecha.getText());
                                XmlBack.modificarEmpleado((int) spinner1.getValue(), "", "", fechaContratacion, 3);

                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Error interno !", "Error!", JOptionPane.ERROR_MESSAGE);
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(null, "La fecha tiene que ser en el formato: dd/MM/yyyy!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                Limpiar(nuevoNombre, nuevoApellido, nuevaFecha, spinner1);
            }

        });

    }

    public static void Limpiar(JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio, JSpinner idEmpleado) {
        textoNombre.setText("");
        textoDescripcion.setText("");
        textoPrecio.setText("");
        idEmpleado.setValue(0);
    }
}



