package ejercicio11p;

/*    11) Tenemos una serie de datos de un alumno: nombre, aprobado (boolean), convocatoria (entero) 
y nota (float).
Implemente un método que escriba en un fichero binario los datos del alumno, 
llamando al fichero “alumno.dat”.
Escribe otro método que lea los datos del fichero y los muestre por la pantalla.*/


public class Main {

        public static void main(String[] args) {
            
            Gestion g=new Gestion();
            
            g.anadirLista();
            g.escribirDatosB();
            g.leerDatos();
            
        }

}
