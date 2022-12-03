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

    // Constructor
    public MyInputObjectStream(InputStream in) throws IOException {
        super(in);
    }

    // Y la funcion que nos permite leer tantos bytes despues de la marca
    protected void readStreamHeader() throws IOException {
        // do not write a header, but reset:
        // this line added after another question
        // showed a problem with the original
        mark(2000000);
    }
}
