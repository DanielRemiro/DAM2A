package ejercicio09;

/*    9) Escribe un programa que, dados dos ficheros, 
genere otro cogiendo la primera línea del primer fichero, 
luego la primera del segundo, luego la segunda línea del primer fichero, 
luego la segunda línea del segundo fichero y así sucesivamente. 
Los ficheros no tienen por qué tener el mismo número de líneas.*/

public class Main {

        public static void main(String[] args) {
            
            String fichero1,fichero2;
            fichero1="fichero1.txt";
            fichero2="fichero2.txt";
            AlternarFicheros a = new AlternarFicheros();
            a.imprimirLineas(fichero1, fichero2);
            
        }

}
