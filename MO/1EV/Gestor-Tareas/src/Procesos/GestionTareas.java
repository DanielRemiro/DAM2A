package Procesos;

import Objeto.Tarea;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionTareas {

    Scanner sc = new Scanner(System.in);
    ArrayList<Tarea> listaTareas=new ArrayList<Tarea>();

    public void agregarTareasProvisional(){

        listaTareas.add(new Tarea("Crear el programa",1));
        listaTareas.add(new Tarea("Eliminar el programa",2));
        listaTareas.add(new Tarea("Cambiar el programa",3));

    }

    /**
     * Metodo para agregar una tarea llamando al metodo crearTarea
     */
    public void agregarTarea(){
        Tarea tarea = crearTarea();
        if(listaTareas.contains(tarea)) {
            System.out.println("Esa tarea ya está agregada");
        }else{
            listaTareas.add(tarea);
        }
    }

    /**
     * Metodo para crear una tarea por scanner
     * @return devuelve una tarea creada
     */
    public Tarea crearTarea(){
        System.out.print("Introduce el id de la tarea: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce la descripcion de la tarea: ");
        String descripcion = sc.nextLine();

        return new Tarea(descripcion, id);
    }

    public void eliminarTarea(){
        System.out.println("Introduce el id de la tarea a eliminar");
        int id = sc.nextInt();
        for(Tarea t: listaTareas){
            if(id==t.getId()){
                listaTareas.remove(t);
                System.out.println("Se ha eliminado la tarea");
            }else{
                System.out.println("No se ha encontrado la tarea");
            }
        }
    }
}
