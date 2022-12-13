package Clases;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.swing.*;

/**
 * @author Javier Jamaica
 * 20/11/2022 - 17:01
 */
public class XmlBack {
    static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
    static String URI = "xmldb:exist://localhost:8081/exist/xmlrpc/db/Proyecto/FicherosXML"; //URI colección
    static String usu = "admin"; //Usuario
    static String usuPwd = "12345Abcde"; //Clave
    static Collection col = null;


    public static void cargar_en_coleccion() throws XMLDBException {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {



                // Inicializamos el recurso
                XMLResource res = null;
                XMLResource res2 = null;
                XMLResource res3 = null;

                // Creamos el recurso -> recibe 2 parámetros tipo String:
                // s: nombre.xml (si lo dejamos null, pondrá un nombre aleatorio)
                // s1: tipo recurso (en este caso, siempre será XMLResource)
                res = (XMLResource) col.createResource("Productos.xml", "XMLResource");
                res2 = (XMLResource) col.createResource("Empleados.xml", "XMLResource");
                res3 = (XMLResource) col.createResource("Pedidos.xml", "XMLResource");

                // Elegimos el fichero .xml que queremos añadir a la colección
                File f = new File(".//src/main/java/FicherosXML/Productos.xml");
                File f2 = new File(".//src/main/java/FicherosXML/Empleados.xml");
                File f3 = new File(".//src/main/java/FicherosXML/Pedidos.xml");


                // Fijamos como contenido ese archivo .xml elegido
                res.setContent(f);
                res2.setContent(f2);
                res3.setContent(f3);

                col.storeResource(res); // lo añadimos a la colección
                col.storeResource(res2); // lo añadimos a la colección
                col.storeResource(res3); // lo añadimos a la colección

                // Listamos la colección para ver que en efecto se ha añadido
                for (String colRe : col.listResources())
                    System.out.println(colRe);

                col.close();
            } catch (Exception e) {
                System.out.println("Error al consultar.");
                // e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión. Comprueba datos.");
        }
    }

    public static Collection conectar() {

        try {
            Class<?> cl = Class.forName(driver); //Cargar del driver
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


    public static void modificarProducto(int id, String nuevoNombre, double nuevoPrecio, String nuevaDescripcion, int op) {
        ResourceSet result;
        if (ComprobarIdProducto(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    switch (op) {
                        case 1 -> {

                            //Consulta para modificar/actualizar un valor --> update value
                            result = servicio.query(
                                    "update value //*[id=" + id + "]/nombre with '" + nuevoNombre + "'");
                            //update value //*[id="2"]/nombre with "dd"

                            JOptionPane.showMessageDialog(null, "Producto actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        case 2 -> {
                            result = servicio.query(
                                    "update value //*[id=" + id + "]/descripcion with '" + nuevaDescripcion + "'");

                            JOptionPane.showMessageDialog(null, "Producto actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        case 3 -> {
                            result = servicio.query(
                                    "update value //*[id=" + id + "]/precio with '" + nuevoPrecio + "'");

                            JOptionPane.showMessageDialog(null, "Producto actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        default ->
                                JOptionPane.showMessageDialog(null, "Error interno!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el producto!", "Error!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void modificarEmpleado(int id, String nuevoNombre, String nuevoApellido,Date nuevaFecha, int op) {
        ResourceSet result;
        if (ComprobarIdEmpleado(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    switch (op) {
                        case 1 -> {

                            //Consulta para modificar/actualizar un valor --> update value
                            result = servicio.query(
                                    "update value //*[id=" + id + "]/nombre with '" + nuevoNombre + "'");
                            //update value //*[id="2"]/nombre with "dd"

                            JOptionPane.showMessageDialog(null, "Empleado actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        case 2 -> {
                            result = servicio.query(
                                    "update value //*[id=" + id + "]/apellido with '" + nuevoApellido + "'");

                            JOptionPane.showMessageDialog(null, "Empleado actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        case 3 -> {

                            result = servicio.query(
                                    "update value //*[id=" + id + "]/fechaContratacion with '" + nuevaFecha + "'");

                            JOptionPane.showMessageDialog(null, "Empleado actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        }
                        default ->
                                JOptionPane.showMessageDialog(null, "Error interno!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el producto!", "Error!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void borrarEmpleado(int id) {
        if (ComprobarIdEmpleado(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Consulta para borrar un departamento --> update delete
                    ResourceSet result = servicio.query(
                            "update delete //DatosEmpleado[id=" + id + "]");
                    col.close();
                    JOptionPane.showMessageDialog(null, "Empleado borrado!", "Borrado!", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al borrar", "Borrado!", JOptionPane.PLAIN_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }
    public static void borrarProducto(int id) {
        if (ComprobarIdProducto(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Consulta para borrar un departamento --> update delete
                    ResourceSet result = servicio.query(
                            "update delete //DatosProducto[id=" + id + "]");
                    col.close();
                    JOptionPane.showMessageDialog(null, "Producto borrado!", "Borrado!", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al borrar", "Borrado!", JOptionPane.PLAIN_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static void insertarEmpleado(int id, String nombre, String apellido, Date fechaContratacion) {

        //Caso concreto: sabemos cuáles son los nodos
        String nuevoEmpleado = "<DatosEmpleado><id>" + id + "</id>"
                + "<nombre>" + nombre + "</nombre><apellido>" + apellido + "</apellido>" + "<fechaContratacion>" + fechaContratacion
                + "</fechaContratacion>" + "</DatosEmpleado>\n";

        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para insertar --> update insert ... into
                String result = "update insert " + nuevoEmpleado + " into /ListaEmpleados";
                servicio.setProperty("indent", "yes");
                servicio.query(result);
                col.close(); //borramos
                JOptionPane.showMessageDialog(null, "Empleado insertado", "Insertado!", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar el empledado", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }
    public static void insertarProducto(int id, String nombre, String descripcion, double precio) {

        //Caso concreto: sabemos cuáles son los nodos
        String nuevoProducto = "<DatosProducto><id>" + id + "</id>"
                + "<nombre>" + nombre + "</nombre><descripcion>" + descripcion + "</descripcion>" + "<precio>" + precio
                + "</precio>" + "</DatosProducto>\n";

        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                System.out.printf("Inserto: %s \n", nuevoProducto);
                //Consulta para insertar --> update insert ... into
                String result = "update insert " + nuevoProducto + " into /ListaProductos";
                servicio.setProperty("indent", "yes");
                servicio.query(result);

                col.close(); //borramos
                JOptionPane.showMessageDialog(null, "Producto insertado!", "Insertado!", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar el producto!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static ResourceIterator consultarEmpleados() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("/ListaEmpleados/DatosEmpleado");

                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos insertados!", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    return i;

                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

        return null;
    }

    public static ResourceIterator consultarProductos() {
        if (conectar() != null) {
            try {
                XPathQueryService servicio;
                servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Preparamos la consulta
                ResourceSet result = servicio.query("/ListaProductos/DatosProducto");

                // recorrer los datos del recurso.
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos insertados!", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    return i;

                }
                col.close();
            } catch (XMLDBException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar el documento!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

        return null;
    }

    public static String consultarIdProductos(int id) {
        if (ComprobarIdProducto(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta
                    ResourceSet result = servicio.query("/ListaProductos/DatosProducto[id=" + id + "]");

                    // recorrer los datos del recurso.
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos insertados!", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Resource r = i.nextResource();
                        return (String) r.getContent();
                    }
                    col.close();
                } catch (XMLDBException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar el documento!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    private static boolean ComprobarIdProducto(int id) {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaProductos/DatosProducto[id=" + id + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar con ese id!", "Error!", JOptionPane.ERROR_MESSAGE);

                // e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

        return false;

    }


    public static String consultarIdEmpleado(int id ) {
        if (ComprobarIdEmpleado(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio;
                    servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Preparamos la consulta
                    ResourceSet result = servicio.query("/ListaEmpleados/DatosEmpleado[id=" + id + "]");

                    // recorrer los datos del recurso.
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos insertados!", "Error!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Resource r = i.nextResource();
                        return (String) r.getContent();
                    }
                    col.close();
                } catch (XMLDBException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar el documento!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    private static boolean ComprobarIdEmpleado(int id) {
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaEmpleados/DatosEmpleado[id=" + id + "]");
                ResourceIterator i;
                i = result.getIterator();
                col.close();
                if (!i.hasMoreResources()) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar con ese id!", "Error!", JOptionPane.ERROR_MESSAGE);

                // e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
}


