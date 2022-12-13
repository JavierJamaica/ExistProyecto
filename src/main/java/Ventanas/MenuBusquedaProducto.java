package Ventanas;

import Clases.XmlBack;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.XMLDBException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Javier Jamaica
 * 09/12/2022 - 20:00
 */
public class MenuBusquedaProducto extends JFrame {
    private JPanel contenedorPrincipal;
    private JButton idButton;
    private JButton nombreButton;
    private JButton precioButton;
    private JButton atrasButton;
    private JButton verButton;
    private JTextArea textArea1;

    public MenuBusquedaProducto() {
    setContentPane(contenedorPrincipal);
    idButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new BuscarIdProducto();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            dispose();
        }
    });
    nombreButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new BuscarNombreProducto();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            dispose();
        }
    });
    precioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new BuscarPrecioProducto();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            dispose();
        }
    });
    atrasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            int height = pantalla.height;
            int width = pantalla.width;
            JFrame frame = new VentanaBusquedas();
            frame.setLocation(width / 3, height / 3);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            dispose();
        }
    });

        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourceIterator i =  XmlBack.consultarProductos();
                String datos = "";
                try {

                    if (i!=null) {
                        while (i.hasMoreResources()) {
                            Resource r = i.nextResource();
                            datos = datos +"\n"+ (String) r.getContent();
                            System.out.println((String) r.getContent());
                        }
                        textArea1.setText(datos);
                    }

                } catch (XMLDBException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
