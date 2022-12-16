package Ventanas;

import Clases.XmlBack;
import TableModels.TableModelEmpleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

/**
 * @author Javier Jamaica
 * 13/12/2022 - 6:17
 */
public class BuscarFechaEmpleado extends JFrame {
    private JPanel contenedorPrincipal;
    private JTextField fechaBuscar;
    private JButton buscarButton;
    private JButton atrasButton;
    private JTable tabla;
    private JTextArea textArea1;

    public BuscarFechaEmpleado() {
        setContentPane(contenedorPrincipal);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new MenuBusquedaEmpleado();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!fechaBuscar.getText().equals("")) {
                    try {
                        tabla.setModel(new TableModelEmpleado(XmlBack.consultarFechaEmpleado(fechaBuscar.getText())));
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "La fecha no tiene un formato valido dd/MM/yyyy!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La fecha no puede estar vacia!", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }
}
