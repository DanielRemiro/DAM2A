package ejercicio5p;

import ejercicio6p.GestorFichero;

/*a) Crea un método que lea un archivo y devuelva la cantidad de palabras de este. 
Usa un buffer para que sea más eficiente. 
Pista: investiga los métodos de la clase String para ver si alguno puede servirte de ayuda.

b) Envuelve el buffered con la clase scanner y modifica el programa para que haga lo mismo.*/

public class Main {

        public static void main(String[] args) {
            
            GestorFichero gf=new GestorFichero();
            
            gf.leerArchivo("prueba1.txt");
            
        }

}
