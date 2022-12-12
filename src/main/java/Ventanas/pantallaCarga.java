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


        CargarImagen(gifLabel);
        setContentPane(contenedorPrincipal);
        XmlBack.cargar_en_coleccion();
        botonConectar.setEnabled(false);
        new HiloCarga(progressBar1, botonConectar, gifLabel).start();

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

}
