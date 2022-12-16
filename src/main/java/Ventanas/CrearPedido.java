package Ventanas;

import Clases.Empleado;
import Clases.Producto;
import Clases.XmlBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica
 * 14/12/2022 - 3:20
 */
public class CrearPedido extends JFrame {
    private JPanel contenedorPrincipal;
    private JComboBox<Empleado> comboBox1;
    private JList<Producto> listaProductos;
    private JSpinner id;
    private JTextField nombrePedido;
    private JList<Producto> listaProdPedido;
    private JButton agregarButton;
    private JButton quitarButton;
    private JButton crearPedidoButton;
    private JButton atrasButton;
    private JLabel aviso;
    static DefaultListModel<Producto> listModel = new DefaultListModel<>();
    static DefaultListModel<Producto> modelProdPedido = new DefaultListModel<>();
    static DefaultComboBoxModel<Empleado> comboBoxModel = new DefaultComboBoxModel<>();
    DefaultListModel<Producto> modelo;

    public CrearPedido() {
        listModel.clear();
        modelProdPedido.clear();
        setContentPane(contenedorPrincipal);
        initModels(listaProdPedido, listaProductos, comboBox1);

        crearPedidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((int) id.getValue() == 0 || nombrePedido.getText().equals("") || modelProdPedido.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios o iguales a 0", "Error!", JOptionPane.ERROR_MESSAGE);

                } else {
                    if (!XmlBack.ComprobarIdPedido((int) id.getValue())) {
                        List<Producto> productosL = new ArrayList<>();
                        for (int i = 0; i < modelo.size(); i++) {
                            productosL.add(modelo.get(i));
                        }
                        XmlBack.insertarPedido((int) id.getValue(), nombrePedido.getText(), comboBox1.getSelectedItem(), productosL);
                            limpiar(id,nombrePedido);
                    } else {
                        JOptionPane.showMessageDialog(null, "Este id ya lo tiene un pedido, pruebe con otro!", "Cuidado!", JOptionPane.WARNING_MESSAGE);

                    }

                }
            }


        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new VentanaPedidos();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modelo = (DefaultListModel<Producto>) listaProdPedido.getModel();
                if (modelo.isEmpty()) {
                    modelo.addElement(listaProductos.getSelectedValue());
                } else {

                    if (modelo.contains(listaProductos.getSelectedValue())) {
                        aviso.setVisible(true);
                    } else {

                        modelo.addElement(listaProductos.getSelectedValue());
                        aviso.setVisible(false);
                        // JOptionPane.showMessageDialog(null, "Este producto ya esta en el pedido!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }


                }


            }

        });
        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<Producto> modelo = (DefaultListModel<Producto>) listaProdPedido.getModel();
                modelo.removeElement(listaProdPedido.getSelectedValue());
            }
        });
    }

    public void initModels(JList<Producto> listaProdPedido, JList<Producto> listaProductos, JComboBox<Empleado> comboBox1) {
        if (listaProdPedido.getModel().getSize() == 0) {
            listaProdPedido.setModel(modelProdPedido);
            //Recorrer el contenido del ArrayList
            if (XmlBack.LeerProductos().isEmpty() || XmlBack.LeerEmpleados().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay empleados o productos, inserta 1 de cada!", "Error!", JOptionPane.ERROR_MESSAGE);

            } else {
                for (int i = 0; i < XmlBack.LeerProductos().size(); i++) {
                    listModel.add(i, XmlBack.LeerProductos().get(i));
                }

                //Asociar el modelo de lista al JList
                if (listaProductos.getModel().getSize() == 0) {
                    listaProductos.setModel(listModel);
                    comboBoxModel = new DefaultComboBoxModel<>();
                    for (Empleado emp : XmlBack.LeerEmpleados()) {
                        comboBoxModel.addElement(emp);
                    }
                    comboBox1.setModel(comboBoxModel);
                }
            }

        }

    }

    public static void limpiar(JSpinner id ,JTextField nombre){
        modelProdPedido.clear();
        id.setValue(0);
        nombre.setText("");
    }


}
