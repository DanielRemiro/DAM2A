package ejercicio3;

/**
 *
 * @author dremi
 */

public class Ficha {
    
    private int lado1,lado2;
    
    public Ficha(int lado1,int lado2){
        
        this.lado1=lado1;
        this.lado2=lado2;
        
    }

    public int getLado1() {
        return lado1;
    }

    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }

    public int getLado2() {
        return lado2;
    }

    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    
    public boolean equals(Ficha f) {
        if (this == f) return true;
        if (f == null || getClass() != f.getClass()) return false;
        Ficha ficha = (Ficha) f;
        return (lado1 == ficha.lado1 && lado2 == ficha.lado2) ||
               (lado1 == ficha.lado2 && lado2 == ficha.lado1);
    }
}
