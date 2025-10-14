package ejercicio16p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Main {
    
    public static void main(String args[]){
        
        Scanner teclado = new Scanner(System.in);
        
        double sueldoEmpleado,sueldoJefe;
        String nombreEmpleado,nombreJefe;
        String tituloUniversitarioJefe, departamentoResponsableJefe;
        
        System.out.println("****VAMOS A REGISTRAR AL EMPLEADO ****");
        
        System.out.print("Nombre del empleado a registrar: ");
        nombreEmpleado=teclado.nextLine();
        System.out.println("");
        
        System.out.print("Sueldo del empleado a registrar: ");
        sueldoEmpleado=teclado.nextDouble();
        teclado.nextLine();
        System.out.println("");
        
        Empleado empleado1=new Empleado(sueldoEmpleado,nombreEmpleado);
        
        System.out.println("****VAMOS A REGISTRAR AL JEFE****");
        
        System.out.print("Nombre del jefe a registrar: ");
        nombreJefe=teclado.nextLine();
        System.out.println("");
        
        System.out.print("Sueldo del jefe a registrar: ");
        sueldoJefe=teclado.nextDouble();
        teclado.nextLine();
        System.out.println("");
        
        System.out.print("Que titulo tiene el jefe: ");
        tituloUniversitarioJefe=teclado.nextLine();
        System.out.println("");
        
        System.out.print("Departamento al que es responsable: ");
        departamentoResponsableJefe=teclado.nextLine();
        System.out.println("");
        
        Jefe jefe1=new Jefe(sueldoJefe,nombreJefe,tituloUniversitarioJefe, departamentoResponsableJefe);
        
        System.out.println("************************************");
        System.out.println("Procesando .....");
        System.out.println("************************************");
        
        System.out.println("****Datos guardados correctamente****");
        System.out.println("----------------------------");
        
        System.out.println("-Empleado-");
        System.out.println("Nombre: "+ empleado1.nombre);
        System.out.println("Saldo: "+ empleado1.sueldo);
        
        System.out.println("----------------------------");
        
        System.out.println("-Jefe-");
        System.out.println("Nombre: "+jefe1.nombre);
        System.out.println("Sueldo: "+jefe1.sueldo);
        System.out.println("Titulo universitario: " +jefe1.tituloUniversitario);
        System.out.println("Departamento que responsabiliza: "+jefe1.departamentoResponsable);
        
        
    }
}
