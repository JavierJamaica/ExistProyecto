package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Jamaica
 * 26/11/2022 - 16:20
 */
public class CrearEmpleado extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField textoNombre;
    private JTextField textoApellidos;
    private JButton atrasButton;
    private JButton crearRegistroButton;
    private JSpinner idEmpleado;
    private JTextField textoFecha;

    public CrearEmpleado() {
        setContentPane(contenedorPrincipal);
        crearRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ComprobarTextos(textoNombre, textoApellidos, textoFecha, idEmpleado)) {
                        int id = (int) idEmpleado.getValue();
                        if (id != -1) {
                            String nombre = textoNombre.getText();
                            String apellido = textoApellidos.getText();
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date fechaContratacion = format.parse(textoFecha.getText());
                            System.out.println("idEmpleado:" + id + "nombre: " + nombre + "apellido: " + apellido + "fecha contratacion: " + fechaContratacion.toString());
                        }

                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error la fecha tiene que ser con el formato: dd/MM/yyyy!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
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


    }

    public static boolean ComprobarTextos(JTextField textoNombre, JTextField textoDescripcion, JTextField textoPrecio, JSpinner idEmpleado) {
        if (textoNombre.getText().equals("") || textoDescripcion.getText().equals("") || textoPrecio.getText().equals("") || (int) idEmpleado.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "Todos los datos deben estar completos y el id debe ser mayor que 0!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
}
