package ejercicio9p;

/*Escribe un programa que, dados dos ficheros, genere otro cogiendo la primera línea del primer fichero, 
luego la primera del segundo, luego la segunda línea del primer fichero, 
luego la segunda línea del segundo fichero y así sucesivamente. 
Los ficheros no tienen por qué tener el mismo número de líneas.*/

public class Main {

        public static void main(String[] args) {
            
            FicheroAOtro f=new FicheroAOtro();
            
            f.leerFicheros("ejemplo1.txt", "prueba1.txt");
            
        }

}
