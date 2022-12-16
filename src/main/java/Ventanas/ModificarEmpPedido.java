package Ventanas;

import Clases.Empleado;
import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier Jamaica
 * 16/12/2022 - 18:18
 */
public class ModificarEmpPedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton atrasButton;
    private JButton actualizarButton;
    private JComboBox<Empleado> nuevoEmp;
    private JLabel pedido;

    public ModificarEmpPedido(int id) {
        init();
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
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XmlBack.modificarPedidoEmp(id, nuevoEmp.getSelectedItem(), 1);
            }
        });
    }

    public void init() {
        DefaultComboBoxModel<Empleado> comboBoxModel = new DefaultComboBoxModel<>();
        for (Empleado emp : XmlBack.LeerEmpleados()) {
            comboBoxModel.addElement(emp);
        }
        nuevoEmp.setModel(comboBoxModel);
    }
}
