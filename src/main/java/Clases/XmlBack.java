package Clases;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.IDN;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 17:01
 */
public class XmlBack {
    public static final String nombrefichero = "AleatorioEmple.dat"; //Si tuviéramos que usar un fichero
    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8081/exist/xmlrpc/db/Exit%20colecciones/Proyecto"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "12345Abcde"; //Clave
    static Collection col = null;

    public static Collection conectar() {

        try {
            Class cl = Class.forName(driver); //Cargar del driver
            Database database = (Database) cl.getDeclaredConstructor().newInstance(); //Instancia de la BD
            DatabaseManager.registerDatabase(database); //Registro del driver
            col = (Collection) DatabaseManager.getCollection(URI, usu, usuPwd);
            return col;
        } catch (XMLDBException e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar el servidor!", "Error!", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error en el driver!", "Error!", JOptionPane.ERROR_MESSAGE);

            //e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error al instanciar la BD!", "Error!", JOptionPane.ERROR_MESSAGE);

            //e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            JOptionPane.showMessageDialog(null, "Error de tipo: " + e, "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void insertarEmpleado(int id, String nombre, String apellido, Date fechaContratacion) {

        //Caso concreto: sabemos cuáles son los nodos
        String nuevoEmpleado = "<EMPLEADO><ID>" + id + "</ID>"
                + "<NOMBRE>" + nombre + "</NOMBRE><APELLIDO>" + apellido + "</APELLIDO>" + "<FECHA_CONTRATACION>" + fechaContratacion
                + "</FECHA_CONTRATACION>" + "</EMPLEADO>";

        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                System.out.printf("Inserto: %s \n", nuevoEmpleado);
                //Consulta para insertar --> update insert ... into
                ResourceSet result = servicio.query("update insert " + nuevoEmpleado + " into /empleados");
                col.close(); //borramos
                System.out.println("Empleado insertado.");
            } catch (Exception e) {
                System.out.println("Error al insertar empleado.");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }
}


