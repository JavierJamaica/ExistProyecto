package Clases;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * @author Javier Jamaica
 * 28/10/2022
 */
// Creamos una subclase de ObjectInputStream
public class MyInputObjectStream extends ObjectInputStream {

    /**
     * Constructor de la clase MyInputObjectStream la cual se hereda de ObjectInputStream, la uso para poder leer
     * objetos en un fichero.dat sin ningun problema de tipo Serializable
     *
     * @param in
     * @throws IOException
     */
    public MyInputObjectStream(InputStream in) throws IOException {
        super(in);
    }

    /**
     * Funcion parra asignar cuantos bytes puede leer esta clase
     *
     * @throws IOException
     */
    protected void readStreamHeader() throws IOException {
        // do not write a header, but reset:
        // this line added after another question
        // showed a problem with the original
        mark(2000000);
    }
}