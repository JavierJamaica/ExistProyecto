package Clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author Javier Jamaica
 * 28/10/2022
 */

// Creamos una subclase de ObjectOutputStream
public class MyObjectOutputStream extends ObjectOutputStream {

    // Constructor
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    // Funcion para crear los objetos sin cabecera de bytes en el fichero
    protected void writeStreamHeader() throws IOException {
        // do not write a header, but reset:
        // this line added after another question
        // showed a problem with the original
        reset();
    }
}