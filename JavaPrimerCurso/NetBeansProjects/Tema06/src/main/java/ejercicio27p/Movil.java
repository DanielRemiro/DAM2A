package ejercicio27p;

/**
 *
 * @author dremi
 */
import java.util.Scanner;

public class Movil {
    
    String contactos[] = new String[] {"Jorge", "Dani","Jhon","Carlos","Ainhoa","Diego","Oscar1","Oscar2","Agustin","JD","Lucia","Dante"};
    int numeros[]= new int[]{1111,2222,3333,4444,5555,6666,7777,8888,9999,0000};
    String correo[]= new String[] {"hola@correo.com","adios@correo.com","buenas@correo.com","genial@correo.com"};
    
    void interfaz(){
        
        System.out.println("**********************");
        System.out.println("    1- Whatsapp       ");
        System.out.println("**********************");
        System.out.println("    2- Sms            ");
        System.out.println("**********************");
        System.out.println("    3- Email          ");
        System.out.println("**********************");
        
        elegirApp();
        
    }
    
    void elegirApp(){
        
        Scanner teclado= new Scanner(System.in);
        
        System.out.print("¿Que app quieres usar?(0 para salir) ");
        int appElegida = teclado.nextInt();
        System.out.println("");
        
        switch(appElegida){
            
            case 1:
                
                Whatsapp whatsapp = new Whatsapp();
                whatsapp.interfaz();
                break;
                
            case 2:
                
                Sms sms = new Sms();
                sms.interfaz();
                break;
                
            case 3:
                
                Email email = new Email();
                email.interfaz();
                break;
                
            case 0:
                
                System.out.println("Has salido correctamente");
                break;
                
            default:
                
                System.out.println("Elige una app existente.");
                interfaz();
                break;
                
        }
        
    }
    
    void verContactos(){
        
        for (int i=0;i<contactos.length;i++){
            
            System.out.println(i+1+".- "+contactos[i]+".");
            
        }
        
    }
    
    void verContactoExacto(int contacto){
        
        System.out.println(contactos[contacto]);
        
    }
    
    void verNumeros(){
        
        for (int i=0;i<numeros.length;i++){
            
            System.out.println(i+1+".- "+numeros[i]+".");
            
        }
        
    }
    
    void verNumeroExacto(int numeroTel){
        
        System.out.println(numeros[numeroTel]);
        
    }
    
    void verCorreo(){
        
        for (int i=0;i<correo.length;i++){
            
            System.out.println(i+1+".- "+correo[i]+".");
            
        }
        
    }
    
    void verCorreoExacto(int correoEx){
        
        System.out.println(correo[correoEx]);
        
    }

}
