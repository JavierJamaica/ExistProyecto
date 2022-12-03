package Ventanas;

import Clases.*;
import com.thoughtworks.xstream.XStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public pantallaCarga() throws IOException, ParseException {
        cargarListaEmpleados(empleados);
        cargarDatosEmpleados();
        CargarImagen(gifLabel);
        setContentPane(contenedorPrincipal);
        botonConectar.setEnabled(false);
        new HiloCarga(progressBar1, botonConectar,gifLabel).start();

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

    public static void cargarListaEmpleados(ArrayList<Empleado> empleados) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String fecha1 = "28/02/2001";
        Date fechaContratacion = format.parse(fecha1);
        Empleado empleado = new Empleado(1, "Javier", "Jamaica", fechaContratacion);
        empleados.add(empleado);

        String fecha2 = "12/01/1998";
        Date fechaContratacion2 = format.parse(fecha2);
        Empleado empleado2 = new Empleado(2, "Luisa", "Lopez", fechaContratacion2);
        empleados.add(empleado2);


        String fecha3 = "23/12/2009";
        Date fechaContratacion3 = format.parse(fecha3);
        Empleado empleado3 = new Empleado(3, "Miguel", "Angel", fechaContratacion3);
        empleados.add(empleado3);

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
}
