package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 26/11/2022 - 2:21
 */
public class crearProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField textoNombre;
    private JTextField textoDescripcion;
    private JTextField textoPrecio;
    private JButton atrasButton;
    private JButton crearRegistroButton;
    private JSpinner idProducto;

    public crearProducto() {
        setContentPane(contenedorPrincipal);

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
        crearRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!XmlBack.ComprobarIdProducto((int) idProducto.getValue())) {
                    if (ComprobarTextos(idProducto, textoNombre, textoDescripcion, textoPrecio)) {
                        int id = (int) idProducto.getValue();
                        if (id != -1) {
                            double precio = comprobarPrecio(textoPrecio);

                            if (precio != -1) {
                                String nombre = textoNombre.getText();
                                String descripcion = textoDescripcion.getText();
                                if (!comprobarDescripcion(descripcion).equals(" ")) {
                                  XmlBack.insertarProducto(id, nombre, descripcion, precio);
                                    Limpiar(idProducto, textoNombre, textoDescripcion, textoPrecio);
                                }
                            }
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este id ya lo tiene un producto, pruebe con otro!", "Cuidado!", JOptionPane.WARNING_MESSAGE);

                }


            }
        });
    }

    public static boolean ComprobarTextos(JSpinner idProducto, JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio) {
        if ((int) idProducto.getValue() == 0 || textoNombre.getText().equals("") || textoDescripcion.getText().equals("") || textoPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los datos deben estar completos y el id debe ser mayor que 0!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    public static String comprobarDescripcion(String descripcion) {
        if (descripcion.length() > 20) {
            JOptionPane.showMessageDialog(null, "La descripcion es muy larga!", "Error!", JOptionPane.ERROR_MESSAGE);
            return " ";
        }
        return descripcion;

    }

    public static double comprobarPrecio(JTextField textoPrecio) {
        double precio = -1;
        try {
            precio = Double.parseDouble(textoPrecio.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
        return precio;
    }

    public static void Limpiar(JSpinner idProducto, JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio) {
        textoNombre.setText("");
        textoDescripcion.setText("");
        textoPrecio.setText("");
        idProducto.setValue(0);
    }
}
