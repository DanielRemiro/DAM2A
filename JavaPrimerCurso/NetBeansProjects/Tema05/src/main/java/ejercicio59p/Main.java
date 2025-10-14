package ejercicio59p;

public class Main {

    public static void main(String args[]) {
        
        Carton carton = new Carton();
        carton.rellenarCarton();

        Bombo bombo = new Bombo();
        bombo.setCarton(carton.linea1, carton.linea2, carton.linea3);
        bombo.tirarDelBombo();
    }
}
