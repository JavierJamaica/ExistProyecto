package Clases;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.base.Collection;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static void modificarEmpleado(int id, String nuevoNombre, String nuevoApellido, Date nuevaFecha, int op) {
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


    public static List<Producto> consultarIdProductos(int id) {
        if (ComprobarIdProducto(id)) {
            List<Producto> productos = new ArrayList<>();
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                    ResourceSet result = servicio.query("for $producto in /ListaProductos/DatosProducto[id='" + id + "']\n" +
                            "let $id:=data($producto/id)\n" +
                            "let $nombre:=data($producto/nombre)\n" +
                            "let $descripcion:=data($producto/descripcion)\n" +
                            "let $precio:=data($producto/precio)\n" +
                            "return <p>,{$id},{$nombre},{$descripcion},{$precio},</p>");
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }

                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        String resultado = (String) r.getContent();
                        String[] arrayString = resultado.split(",");
                        Producto producto = new Producto(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], Double.parseDouble(arrayString[4]));
                        productos.add(producto);
                    }
                } catch (XMLDBException e) {
                    throw new RuntimeException(e);
                }
            }


            return productos;
        } else {
            JOptionPane.showMessageDialog(null, "El producto no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static boolean ComprobarIdProducto(int id) {
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

    public static List<Empleado> consultarFechaEmpleado(String fecha) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaContratacion = format.parse(fecha);
        List<Empleado> empleados = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $empleado in /ListaEmpleados/DatosEmpleado[fechaContratacion='" + fechaContratacion + "']\n" +
                        "let $id:=data($empleado/id)\n" +
                        "let $nombre:=data($empleado/nombre)\n" +
                        "let $apellido:=data($empleado/apellido)\n" +
                        "let $fechaContratacion:=data($empleado/fechaContratacion)\n" +
                        "return <p>,{$id},{$nombre},{$apellido},{$fechaContratacion},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    Date date = (Date) formatter.parse(arrayString[4]);

                    Empleado empleado = new Empleado(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], date);
                    empleados.add(empleado);
                }
            } catch (XMLDBException | ParseException e) {
                JOptionPane.showMessageDialog(null, "La fecha no es valida!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        return empleados;
    }


    public static List<Producto> consultarPrecioProducto(double precio) {
        List<Producto> productos = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $producto in /ListaProductos/DatosProducto[precio='" + precio + "']\n" +
                        "let $id:=data($producto/id)\n" +
                        "let $nombre:=data($producto/nombre)\n" +
                        "let $descripcion:=data($producto/descripcion)\n" +
                        "let $precio:=data($producto/precio)\n" +
                        "return <p>,{$id},{$nombre},{$descripcion},{$precio},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    Producto producto = new Producto(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], Double.parseDouble(arrayString[4]));
                    productos.add(producto);
                }
            } catch (XMLDBException e) {
                throw new RuntimeException(e);
            }
        }


        return productos;
    }


    public static List<Producto> consultarNombreProducto(String nombre) {
        List<Producto> productos = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $producto in /ListaProductos/DatosProducto[nombre='" + nombre + "']\n" +
                        "let $id:=data($producto/id)\n" +
                        "let $nombre:=data($producto/nombre)\n" +
                        "let $descripcion:=data($producto/descripcion)\n" +
                        "let $precio:=data($producto/precio)\n" +
                        "return <p>,{$id},{$nombre},{$descripcion},{$precio},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    Producto producto = new Producto(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], Double.parseDouble(arrayString[4]));
                    productos.add(producto);
                }
            } catch (XMLDBException e) {
                throw new RuntimeException(e);
            }
        }


        return productos;
    }

    public static List<Empleado> consultarNombreEmpleado(String nombre) {
        List<Empleado> empleados = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $empleado in /ListaEmpleados/DatosEmpleado[nombre='" + nombre + "']\n" +
                        "let $id:=data($empleado/id)\n" +
                        "let $nombre:=data($empleado/nombre)\n" +
                        "let $apellido:=data($empleado/apellido)\n" +
                        "let $fechaContratacion:=data($empleado/fechaContratacion)\n" +
                        "return <p>,{$id},{$nombre},{$apellido},{$fechaContratacion},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    Date date = (Date) formatter.parse(arrayString[4]);

                    Empleado empleado = new Empleado(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], date);
                    empleados.add(empleado);
                }
            } catch (XMLDBException | ParseException e) {
                throw new RuntimeException(e);
            }
        }


        return empleados;
    }

    public static List<Empleado> consultarIdEmpleado(int id) {
        if (ComprobarIdEmpleado(id)) {
            List<Empleado> empleados = new ArrayList<>();
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                    ResourceSet result = servicio.query("for $empleado in /ListaEmpleados/DatosEmpleado[id='" + id + "']\n" +
                            "let $id:=data($empleado/id)\n" +
                            "let $nombre:=data($empleado/nombre)\n" +
                            "let $apellido:=data($empleado/apellido)\n" +
                            "let $fechaContratacion:=data($empleado/fechaContratacion)\n" +
                            "return <p>,{$id},{$nombre},{$apellido},{$fechaContratacion},</p>");
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }

                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        String resultado = (String) r.getContent();
                        String[] arrayString = resultado.split(",");
                        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                        Date date = (Date) formatter.parse(arrayString[4]);

                        Empleado empleado = new Empleado(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], date);
                        empleados.add(empleado);
                    }
                } catch (XMLDBException | ParseException e) {
                    throw new RuntimeException(e);
                }
            }


            return empleados;
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static boolean ComprobarIdEmpleado(int id) {
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

    public static List<Producto> LeerProductos() {
        List<Producto> productos = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $producto in /ListaProductos/DatosProducto\n" +
                        "let $id:=data($producto/id)\n" +
                        "let $nombre:=data($producto/nombre)\n" +
                        "let $descripcion:=data($producto/descripcion)\n" +
                        "let $precio:=data($producto/precio)\n" +
                        "return <p>,{$id},{$nombre},{$descripcion},{$precio},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    Producto producto = new Producto(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], Double.parseDouble(arrayString[4]));
                    productos.add(producto);
                }
            } catch (XMLDBException e) {
                throw new RuntimeException(e);
            }
        }


        return productos;

    }

    public static List<Empleado> LeerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $empleado in /ListaEmpleados/DatosEmpleado\n" +
                        "let $id:=data($empleado/id)\n" +
                        "let $nombre:=data($empleado/nombre)\n" +
                        "let $apellido:=data($empleado/apellido)\n" +
                        "let $fechaContratacion:=data($empleado/fechaContratacion)\n" +
                        "return <p>,{$id},{$nombre},{$apellido},{$fechaContratacion},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    Date date = (Date) formatter.parse(arrayString[4]);

                    Empleado empleado = new Empleado(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], date);
                    empleados.add(empleado);
                }
            } catch (XMLDBException | ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error interno perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        }

        return empleados;
    }

    public static void insertarPedido(int id, String nombre, Object empleado, List<Producto> productos) {
        Empleado emp = (Empleado) empleado;
        String xmlProd = "";
        //Caso concreto: sabemos cuáles son los nodos
        for (Producto p : productos) {
            xmlProd = xmlProd + "<producto id='" + p.getId() + "'>" + "<nombreProducto>" + p.getNombre() + "</nombreProducto>" + "<descripcion>" + p.getDescripcion()
                    + "</descripcion>" + "<precio>" + p.getPrecio() + "</precio>" + "</producto>";

        }
        System.out.println(xmlProd);
        String nuevoPedido = "<DatosPedido><id>" + id + "</id>"
                + "<nombre>" + nombre + "</nombre><empleado id ='" + emp.getId() + "'>" + "<nombreEmp>" + emp.getNombre()
                + "</nombreEmp>" + "<apellido>" + emp.getApellidos() + "</apellido>" + "<fechaContrato>" + emp.getFechaContratacion() + "</fechaContrato>" + "</empleado>"
                + "<productos>" + xmlProd + "</productos>" + "</DatosPedido>\n";


        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                System.out.printf("Inserto: %s \n", nuevoPedido);
                //Consulta para insertar --> update insert ... into
                String result = "update insert " + nuevoPedido + " into /ListaPedidos";
                servicio.setProperty("indent", "yes");
                servicio.query(result);

                col.close(); //borramos
                JOptionPane.showMessageDialog(null, "Pedido insertado!", "Insertado!", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar el pedido!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

        }


    }

    public static List<Pedido> LeerPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $pedido in /ListaPedidos/DatosPedido\n" +
                        "let $id:=data($pedido/id)\n" +
                        "let $nombre:=data($pedido/nombre)\n" +
                        "return <p>,{$id},{$nombre},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    Pedido pedido = new Pedido(Integer.parseInt(arrayString[1]), arrayString[2], null, null);
                    pedidos.add(pedido);
                }

            } catch (XMLDBException e) {
                throw new RuntimeException(e);
            }
        }


        return pedidos;

    }

    public static List<Pedido> BuscarNombrePedido(String nombre) {
        List<Pedido> pedidos = new ArrayList<>();
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $pedido in /ListaPedidos/DatosPedido[nombre='" + nombre + "']\n" +
                        "let $id:=data($pedido/id)\n" +
                        "let $nombre:=data($pedido/nombre)\n" +
                        "return <p>,{$id},{$nombre},</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    Pedido pedido = new Pedido(Integer.parseInt(arrayString[1]), arrayString[2], null, null);
                    pedidos.add(pedido);
                }

            } catch (XMLDBException e) {
                throw new RuntimeException(e);
            }
        }


        return pedidos;

    }

    public static List<Producto> consultarProdsPedido(int idPe) {
        List<Producto> productos = new ArrayList<>();
        if (ComprobarIdPedido(idPe)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                    ResourceSet result = servicio.query("for $pedidoProd in /ListaPedidos/DatosPedido[id ='" + idPe + "']/productos\n" +
                            "let $idProd:=data($pedidoProd/producto/@id)\n" +
                            "let $precio :=data($pedidoProd/producto/precio)\n" +
                            "return <producto>,{$idProd},{$precio},</producto>");


                    ResourceIterator i;

                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }


                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();


                        String resultado = (String) r.getContent();
                        String[] arrayString = resultado.split(",");
                        String[] arrayIds = arrayString[1].split(" ");
                        String[] arrayPrecios = arrayString[2].split(" ");

                        for (int j = 0; j < arrayIds.length; j++) {
                            int id = Integer.parseInt(arrayIds[j]);
                            double precio = Double.parseDouble(arrayPrecios[j]);
                            ResourceSet result2 = servicio.query("for $pedidoProd in /ListaPedidos/DatosPedido[id ='" + idPe + "']/productos\n" +
                                    "let $nombre:=data($pedidoProd/producto[@id='" + id + "']/nombreProducto)\n" +
                                    "let $descripcion:=data($pedidoProd/producto[@id='" + id + "']/descripcion)\n" +
                                    "return <producto>,{$nombre},{$descripcion},</producto>");
                            ResourceIterator i2;
                            i2 = result2.getIterator();
                            if (!i2.hasMoreResources()) {
                                JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                            }

                            while (i2.hasMoreResources()) {
                                Resource r2 = i2.nextResource();
                                String resultado2 = (String) r2.getContent();
                                String[] arraysString = resultado2.split(",");
                                Producto producto = new Producto(id, arraysString[1], arraysString[2], precio);
                                productos.add(producto);
                            }

                        }

                    }
                } catch (XMLDBException e) {
                    JOptionPane.showMessageDialog(null, "Error interno perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese pedido!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

        return productos;

    }

    public static Empleado consultarEmpPedido(int idPe) {
        Empleado emp = null;


        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                ResourceSet result = servicio.query("for $pedidoEmp in /ListaPedidos/DatosPedido[id ='" + idPe + "']/empleado\n" +
                        "let $idEmp:=data($pedidoEmp/@id)\n" +
                        "let $nombreEmp:=data($pedidoEmp/nombreEmp)\n" +
                        "let $apellidoEmp:=data($pedidoEmp/apellido)\n" +
                        "let $fechaContrato:=data($pedidoEmp/fechaContrato)\n" +
                        "return <p>,{$idEmp},{$nombreEmp},{$apellidoEmp},{$fechaContrato}</p>");
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                }

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    String resultado = (String) r.getContent();
                    String[] arrayString = resultado.split(",");
                    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
                    Date date = (Date) formatter.parse(arrayString[4]);

                    emp = new Empleado(Integer.parseInt(arrayString[1]), arrayString[2], arrayString[3], date);

                }
            } catch (XMLDBException | ParseException e) {
                JOptionPane.showMessageDialog(null, "Error interno perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        }


        return emp;
    }


    public static void borrarPedido(int id) {
        if (ComprobarIdPedido(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    //Consulta para borrar un departamento --> update delete
                    ResourceSet result = servicio.query(
                            "update delete //DatosPedido[id=" + id + "]");
                    col.close();
                    JOptionPane.showMessageDialog(null, "Pedido borrado!", "Borrado!", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al borrar", "Borrado!", JOptionPane.PLAIN_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pedido no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static boolean ComprobarIdPedido(int id) {
        //Devuelve true si el dep existe
        if (conectar() != null) {
            try {
                XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                //Consulta para consultar la información de un departamento
                ResourceSet result = servicio.query("/ListaPedidos/DatosPedido[id=" + id + "]");
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

    public static void modificarPedidoEmp(int id, Object nuevoEmpleado, int op) {
        Empleado emp = (Empleado) nuevoEmpleado;
        ResourceSet result;
        ResourceSet result2;
        ResourceSet result3;
        ResourceSet result4;
        if (ComprobarIdPedido(id)) {
            if (conectar() != null) {
                try {
                    List<Pedido> pedidos = consultarIdPedido(id);
                    boolean comp = false;
                    assert pedidos != null;
                    for (Pedido p : pedidos) {
                        p.setEmpleado(consultarEmpPedido(id));
                        System.out.println(p);
                        comp = p.getEmpleado().getId() != emp.getId();
                    }
                    if (comp) {
                        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                        if (op == 1) {//Consulta para modificar/actualizar un valor --> update value
                            result = servicio.query(
                                    "for $empleado in /ListaPedidos/DatosPedido[id='" + id + "']/empleado\n " +
                                            "let $nombreEmp := $empleado/nombreEmp\n" +
                                            "return\n" +
                                            "update value $nombreEmp with'" + emp.getNombre() + "'");
                            result2 = servicio.query(
                                    "for $empleado in /ListaPedidos/DatosPedido[id='" + id + "']/empleado\n " +
                                            "let $apellido := $empleado/apellido\n" +
                                            "return\n" +
                                            "update value $apellido with'" + emp.getApellidos() + "'");
                            result3 = servicio.query(
                                    "for $empleado in /ListaPedidos/DatosPedido[id='" + id + "']/empleado\n " +
                                            "let $id := $empleado/@id\n" +
                                            "return\n" +
                                            "update value $id with'" + emp.getId() + "'");
                            result4 = servicio.query(
                                    "for $empleado in /ListaPedidos/DatosPedido[id='" + id + "']/empleado\n " +
                                            "let $fecha := $empleado/fechaContrato\n" +
                                            "return\n" +
                                            "update value $fecha with'" + emp.getFechaContratacion() + "'");
                            //update value //*[id="2"]/nombre with "dd"

                            JOptionPane.showMessageDialog(null, "Empleado actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                            col.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error interno!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes cambiar el empleado por el mismo, usa otro!!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el pedido!", "Error!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El pedido no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static List<Pedido> consultarIdPedido(int id) {
        if (ComprobarIdPedido(id)) {
            List<Pedido> pedidos = new ArrayList<>();
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");

                    ResourceSet result = servicio.query("for $pedido in /ListaPedidos/DatosPedido[id='" + id + "']\n" +
                            "let $id:=data($pedido/id)\n" +
                            "let $nombre:=data($pedido/nombre)\n" +
                            "return <p>,{$id},{$nombre},</p>");
                    ResourceIterator i;
                    i = result.getIterator();
                    if (!i.hasMoreResources()) {
                        JOptionPane.showMessageDialog(null, "No hay datos para mostrar!", "Error!", JOptionPane.ERROR_MESSAGE);

                    }

                    while (i.hasMoreResources()) {
                        Resource r = i.nextResource();
                        String resultado = (String) r.getContent();
                        String[] arrayString = resultado.split(",");
                        Empleado empPed = consultarEmpPedido(Integer.parseInt(arrayString[1]));
                        Pedido pedido = new Pedido(Integer.parseInt(arrayString[1]), arrayString[2], empPed, null);
                        pedidos.add(pedido);
                    }
                } catch (XMLDBException e) {
                    throw new RuntimeException(e);
                }
            }


            return pedidos;
        } else {

            JOptionPane.showMessageDialog(null, "El pedido no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }
        return null;
    }


    public static void modificarPedido(int id, String nuevoNombre, int op) {
        ResourceSet result;
        if (ComprobarIdPedido(id)) {
            if (conectar() != null) {
                try {
                    XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
                    if (op == 1) {//Consulta para modificar/actualizar un valor --> update value
                        result = servicio.query(
                                "update value //*[id=" + id + "]/nombre with '" + nuevoNombre + "'");
                        //update value //*[id="2"]/nombre with "dd"

                        JOptionPane.showMessageDialog(null, "Pedido actualizado!", "Actualizado!!", JOptionPane.PLAIN_MESSAGE);
                        col.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error interno!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el pedido!", "Error!", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexion perdona las molestias!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El pedido no existe!", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

}


