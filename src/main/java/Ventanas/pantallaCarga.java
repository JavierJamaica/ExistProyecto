package Ventanas;

import Clases.*;
import com.thoughtworks.xstream.XStream;
import org.xmldb.api.base.XMLDBException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Javier Jamaica
 * 03/12/2022 - 1:10
 */
public class pantallaCarga extends JFrame {
    private JPanel contenedorPrincipal;
    private JProgressBar progressBar1;
    private JButton botonConectar;
    private JButton salirButton;
    private JLabel gifLabel;

    private static final ArrayList<Empleado> empleados = new ArrayList<>();
    private static final ArrayList<Producto> productos = new ArrayList<>();
    private static final ArrayList<Pedido> pedidos = new ArrayList<>();

    public pantallaCarga() throws IOException, ParseException, XMLDBException {
        cargarDatosProducto();
        cargarDatosPedido();
        cargarDatosEmpleados();
        CargarImagen(gifLabel);
        setContentPane(contenedorPrincipal);
        botonConectar.setEnabled(false);
        new HiloCarga(progressBar1, botonConectar, gifLabel).start();
        XmlBack.cargar_en_coleccion();

        botonConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                int height = pantalla.height;
                int width = pantalla.width;
                JFrame frame = new Principal();
                frame.setLocation(width / 3, height / 3);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                dispose();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void CargarImagen(JLabel imagenLabel) {
        imagenLabel.setSize(60, 60);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/cargaGif.gif");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
        imagenLabel.setIcon(icon);
    }

    public static void CargarImagenTermino(JLabel imagenLabel) {
        imagenLabel.setSize(60, 60);
        ImageIcon imagen = new ImageIcon("src/main/java/Imagenes/chulito.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
        imagenLabel.setIcon(icon);
    }

    public static void cargarXmlProducto(File fichero) throws IOException {

        FileInputStream fileIn = new FileInputStream(fichero);

        MyInputObjectStream dataIS = new MyInputObjectStream(fileIn);
        System.out.println("Comienza el proceso de creacion a XML..");
        ListaProductos listaProductos = new ListaProductos();
        try {
            while (true) {
                Producto producto = (Producto) dataIS.readObject();
                listaProductos.add(producto);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leido");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        dataIS.close();
        try {
            XStream xStream = new XStream();
            xStream.alias("ListaProductos", ListaProductos.class);
            xStream.alias("DatosProducto", Producto.class);
            xStream.addImplicitCollection(ListaProductos.class, "lista");
            xStream.toXML(listaProductos, new FileOutputStream(".//src/main/java/FicherosXML/Productos.xml"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void cargarDatosProducto() throws IOException {
        File fichero = new File(".//src/main/java/Ficheros/Productos.dat");
        if (fichero.exists()) {
            cargarXmlProducto(fichero);
        } else {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            MyObjectOutputStream dataOs = new MyObjectOutputStream(fileout);
            for (Producto producto : productos) {

                dataOs.writeObject(producto);

            }
            dataOs.close();
            System.out.println("Datos productos escritos");
            cargarXmlProducto(fichero);
        }
    }

    public static void cargarXmlEmpleado(File fichero) throws IOException {

        FileInputStream fileIn = new FileInputStream(fichero);

        MyInputObjectStream dataIS = new MyInputObjectStream(fileIn);
        System.out.println("Comienza el proceso de creacion a XML..");
        ListaEmpleados listaEmpleados = new ListaEmpleados();
        try {
            while (true) {
                Empleado empleado = (Empleado) dataIS.readObject();
                listaEmpleados.add(empleado);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leido");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        dataIS.close();
        try {
            XStream xStream = new XStream();
            xStream.alias("ListaEmpleados", ListaEmpleados.class);
            xStream.alias("DatosEmpleado", Empleado.class);
            xStream.addImplicitCollection(ListaEmpleados.class, "lista");
            xStream.toXML(listaEmpleados, new FileOutputStream(".//src/main/java/FicherosXML/Empleados.xml"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void cargarDatosEmpleados() throws IOException {
        File fichero = new File(".//src/main/java/Ficheros/Empleados.dat");
        if (fichero.exists()) {
            cargarXmlEmpleado(fichero);
        } else {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            MyObjectOutputStream dataOs = new MyObjectOutputStream(fileout);
            for (Empleado empleado : empleados) {

                dataOs.writeObject(empleado);

            }
            dataOs.close();
            System.out.println("Datos empleado escritos");
            cargarXmlEmpleado(fichero);
        }
    }

    public static void cargarXmlPedido(File fichero) throws IOException {

        FileInputStream fileIn = new FileInputStream(fichero);

        MyInputObjectStream dataIS = new MyInputObjectStream(fileIn);
        System.out.println("Comienza el proceso de creacion a XML..");
        ListaPedidos listaPedidos = new ListaPedidos();
        try {
            while (true) {
                Pedido pedido = (Pedido) dataIS.readObject();
                listaPedidos.add(pedido);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leido");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        dataIS.close();
        try {
            XStream xStream = new XStream();
            xStream.alias("ListaPedidos", ListaPedidos.class);
            xStream.alias("DatosPedido", Pedido.class);
            xStream.addImplicitCollection(ListaPedidos.class, "lista");
            xStream.toXML(listaPedidos, new FileOutputStream(".//src/main/java/FicherosXML/Pedidos.xml"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void cargarDatosPedido() throws IOException {
        File fichero = new File(".//src/main/java/Ficheros/Pedidos.dat");
        if (fichero.exists()) {
            cargarXmlPedido(fichero);
        } else {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            MyObjectOutputStream dataOs = new MyObjectOutputStream(fileout);
            for (Pedido pedido : pedidos) {

                dataOs.writeObject(pedido);

            }
            dataOs.close();
            System.out.println("Datos pedidol escritos");
            cargarXmlPedido(fichero);
        }
    }



}
