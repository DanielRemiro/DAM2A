package ficherop;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {

    public MiObjectOutputStream(OutputStream o) throws IOException {
        
        super(o);
        
    }

    @Override
    protected void writeStreamHeader() throws IOException {
       
    }
    
}

