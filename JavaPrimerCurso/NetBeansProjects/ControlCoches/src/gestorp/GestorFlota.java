package gestorp;

import cochep.Coche;
import java.util.ArrayList;
import java.util.Scanner;
import viajep.Viaje;



public class GestorFlota {

    private ArrayList <Coche>flotaCoches=new ArrayList<>();
    private ArrayList <Viaje>listaViajes=new ArrayList<>();
    private Scanner teclado=new Scanner(System.in);
    
    public void cochesBasicos(){
        
        Coche c1 =new Coche("134",0.3,50,30.5,"Zaragoza");
        flotaCoches.add(c1);
        
        Coche c2 =new Coche("154",0.3,50,30.5,"Zaragoza");
        flotaCoches.add(c2);
        
        Coche c3 =new Coche("111",0.3,50,30.5,"Zaragoza");
        flotaCoches.add(c3);
        
    }
    
    
    public void anadirCoche(){
        
        System.out.println("ID del vehiculo.");
        String id=teclado.nextLine();
        
        System.out.println("Consumo por km : ");
        double consumo=teclado.nextDouble();
        teclado.nextLine();
        
        System.out.println("Capacidad de combustible: ");
        double deposito=teclado.nextDouble();
        teclado.nextLine();
        
        System.out.println("Combustible actual: ");
        double combustibleActual=teclado.nextDouble();
        teclado.nextLine();
        
        System.out.println("Ubicacion: ");
        String ubicacion=teclado.nextLine();
        
        Coche c =new Coche(id,consumo,deposito,combustibleActual,ubicacion);
        
        flotaCoches.add(c);
        
    }
    
    public void pedirViaje(){
        
        System.out.println("Origen: ");
        String origen=teclado.nextLine();
        
        System.out.println("Destino: ");
        String destino=teclado.nextLine();
        
        System.out.println("Distancia(km): ");
        int km=teclado.nextInt();
        teclado.nextLine();
        
        Viaje v=new Viaje(origen,destino,km);
        listaViajes.add(v);
        
        gestionarViajes();
        
    }

    public ArrayList<Coche> getFlotaCoches() {
        return flotaCoches;
    }

    public ArrayList<Viaje> getListaViajes() {
        return listaViajes;
    }
    
    public void gestionarViajes(){
        
        for(Viaje vj:listaViajes){
            
            vj.getDistancia();
            
            for(Coche ch:flotaCoches){
                
                boolean puede=((ch.getCombustibleActual()/ch.getConsumoKm())-vj.getDistancia())>0;
                
                if(puede){
                    
                    
                     
                }
                
            }
            
        }
        
    }
    
    
    
    
}
