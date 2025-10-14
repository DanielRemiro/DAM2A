package ejercicio3;

/**
 *
 * @author dremi
 */

import java.util.ArrayList;
import java.util.Random;

public class CrearFicha {

    private Random random = new Random();
    private ArrayList<Ficha> listaFichas = new ArrayList<>();

    Ficha crearFicha() {
        int lado1 = random.nextInt(7);
        int lado2 = random.nextInt(7);
        return new Ficha(lado1, lado2);
    }

    boolean fichaExiste(Ficha fichaAux) {
        for (Ficha ficha : listaFichas) {
            
            if ((ficha.getLado1() == fichaAux.getLado1() && ficha.getLado2() == fichaAux.getLado2()) ||
                (ficha.getLado1() == fichaAux.getLado2() && ficha.getLado2() == fichaAux.getLado1())) {
                return true; 
            }
        }
        return false;
    }

    void anadirFicha() {
        Ficha fichaAux = crearFicha();
        if (!fichaExiste(fichaAux)) {
            listaFichas.add(fichaAux);
        }
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void verFichas() {
        for (Ficha ficha : listaFichas) {
            System.out.println("[" + ficha.getLado1() + "|" + ficha.getLado2() + "]");
        }
    }
}
