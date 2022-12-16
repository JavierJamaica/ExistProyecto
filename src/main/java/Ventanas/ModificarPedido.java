package Ventanas;

import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 15/12/2022 - 19:52
 */
public class ModificarPedido extends JFrame {
    private JSpinner spinner1;
    private JRadioButton nombreRadioButton;
    private JRadioButton empleadoRadioButton;
    private JRadioButton productosRadioButton;
    private JButton atrasButton;
    private JButton actualizarButton;
    private JTextField nuevoNombre;
    private JComboBox comboNuevoEmpleado;
    private JButton editarButton;
    private JPanel contenedorPrincipal;
    private JButton editarEmp;

    public ModificarPedido() {
        setContentPane(contenedorPrincipal);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaPedidos();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editarEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) spinner1.getValue() == 0) {
                    JOptionPane.showMessageDialog(null, "El id del pedido no puede ser igual a 0", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                    int height = pantalla.height;
                    int width = pantalla.width;
                    JFrame frame = new ModificarEmpPedido((int) spinner1.getValue());
                    frame.setLocation(width / 3, height / 3);
                    frame.pack();
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                    dispose();
                }

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XmlBack.modificarPedido((int) spinner1.getValue(), nuevoNombre.getText(), 1);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(true);
                    editarEmp.setEnabled(false);
                    editarButton.setEnabled(false);


                } else if (empleadoRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(false);
                    editarEmp.setEnabled(true);
                    editarButton.setEnabled(false);


                } else if (productosRadioButton.isSelected()) {
                    nuevoNombre.setEnabled(false);
                    editarEmp.setEnabled(false);
                    editarButton.setEnabled(true);


                }
            }
        };
        nombreRadioButton.addActionListener(listener);
        empleadoRadioButton.addActionListener(listener);
        productosRadioButton.addActionListener(listener);

    }
}
