package Ventanas;

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
    private JTextField textoId;
    private JTextField textoNombre;
    private JTextField textoDescripcion;
    private JTextField textoPrecio;
    private JButton atrasButton;
    private JButton crearRegistroButton;

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
                if (ComprobarTextos(textoId, textoNombre, textoDescripcion, textoPrecio)) {
                    int id = comprobarId(textoId);
                    if (id != -1) {
                        double precio = comprobarPrecio(textoPrecio);

                        if (precio != -1) {
                            String nombre = textoNombre.getText();
                            String descripcion = textoDescripcion.getText();
                            if (!comprobarDescripcion(descripcion).equals(" ")) {
                                System.out.println("id:" + id + "nombre: " + nombre + "precio: " + precio + "descripcion: " + descripcion);
                            }
                        }
                    }

                }

            }
        });
    }

    public static boolean ComprobarTextos(JTextField textoId, JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio) {
        if (textoId.getText().equals("") || textoNombre.getText().equals("") || textoDescripcion.getText().equals("") || textoPrecio.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Todos los datos deben estar completos!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static int comprobarId(JTextField textoId) {
        int id = -1;
        try {
            id = Integer.parseInt(textoId.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El id tiene que ser un numero!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
        return id;
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
            precio = Integer.parseInt(textoPrecio.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio tiene que ser un numero!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
        return precio;
    }
}
