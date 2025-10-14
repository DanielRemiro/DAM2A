package Ejercicio9;

public class Mesa {
    
    private int sillas;

    public Mesa() {
        
        this.sillas = 0; 
        
    }

    public int getSillas() {
        
        return sillas;
        
    }

    public void setSillas(int sillas) {
        
        this.sillas = sillas;
        
    }

    public boolean estaLibre() {
        
        return sillas == 0;
        
    }

    public void liberarMesa() {
        
        this.sillas = 0;
        
    }
    
}
