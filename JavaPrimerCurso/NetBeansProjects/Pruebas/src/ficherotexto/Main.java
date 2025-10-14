package ficherotexto;


public class Main {

    public static void main(String[] args) {
            
    FicheroTextoClase ft= new FicheroTextoClase();
            
    //ft.escribirFicheroTexto("prueba1.txt", true, "Es el primer archivo que hago.");//true lo añade al final y false lo sobreescribe
            
    //ft.leerFichero("prueba1.txt");
    
    //ft.escribirFicheroPrintWriter("prueba_printwriter.txt", true);
        
    ft.leerFicheroScanner("prueba_printwriter.txt");
        
    
    }

}
