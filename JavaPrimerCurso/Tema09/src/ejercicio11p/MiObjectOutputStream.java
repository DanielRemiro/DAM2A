package ejercicio11p;

import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream o) throws IOException {
        
        super(o);
        
    }

    @Override
    protected void writeStreamHeader() throws IOException {
       
    }
    
}
