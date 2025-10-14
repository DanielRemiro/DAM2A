package ejercicio12p;

/**
 *
 * @author dremi
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GestionBiblioteca {
    
    Scanner teclado = new Scanner(System.in);
    
    int objetoElegido;
    
    ArrayList <Material> listaMaterial=new ArrayList<>();
    ArrayList <Usuario> listaUsuario=new ArrayList<>();
    
    void inicializarMateriales() {
    
        Libro libro = new Libro("Don Quijote de la Mancha", 1605, "Miguel de Cervantes", 1072);
        listaMaterial.add(libro);
    
        Dvd dvd = new Dvd("Star Wars", 1977, "George Lucas", 121);
        listaMaterial.add(dvd);
    
        Revista revista = new Revista("La Pronto", 2023, "Grupo de Comunicación Pronto", 123);
        listaMaterial.add(revista);
    
    }
    
    void inicializarUsuarios() {
    
        Usuario usuario1 = new Usuario("Daniel", 1);
        Usuario usuario2 = new Usuario("Jhon", 2);
        Usuario usuario3 = new Usuario("Quique", 3);
    
        listaUsuario.add(usuario1);
        listaUsuario.add(usuario2);
        listaUsuario.add(usuario3);
    
    }

    void altaMaterial(){
        
        elegirMaterial();
        
        if(objetoElegido==1){
            
            crearLibro();
            
        }else if(objetoElegido==2){
           
            crearDvd();
            
        }else if(objetoElegido==3){
            
            crearRevista();
            
        }
        
        ordenarListaMaterialAnno();
        
    }
    
    void bajaMaterial(){
        
        System.out.println("¿Que material quieres dar de baja?(Otro numero para salir): ");
        
        verMaterial();
        
        System.out.print("--> ");
        int numeroElegido = teclado.nextInt();
        teclado.nextLine();
        
        if(numeroElegido>=1&&numeroElegido<=listaMaterial.size()){
            
            listaMaterial.remove(numeroElegido-1);
            
        }
        
    }
    
    void altaUsuario() {
    
        Usuario u = crearUsuario();
    
        if (comprobarUsuario(u) == false) {
        
            listaUsuario.add(u);
            
            System.out.println("Usuario creado correctamente.");
        
        } else {
        
            System.out.println("Ya existe un usuario con ese id.");
            
        }
    
    }

    void prestarMaterial(){
        
        System.out.println("¿Que material quieres que se te preste?(Otro numero para cerrar): ");
        verMaterial();
        System.out.print("--> ");
        
        int materialPrestar= teclado.nextInt();
        teclado.nextLine();
        
        if(materialPrestar<=listaMaterial.size() && materialPrestar>=1){
            
            if(listaMaterial.get(materialPrestar-1) instanceof Revista ){
            
                System.out.println("No se pueden prestar las revistas");
            
            }else if(listaMaterial.get(materialPrestar-1) instanceof Dvd){
            
                Prestable materialPrestable = (Prestable) listaMaterial.get(materialPrestar-1);
                materialPrestable.estaPrestado();
                
                System.out.println("Su Dvd ha sido prestado al usuario "+ listaUsuario.get(usuarioSolicitaPrestar()).getNombre()+", la fecha "+fechaReserva()+".");
            
            
            }else if(listaMaterial.get(materialPrestar-1) instanceof Libro){
            
                Prestable materialPrestable = (Prestable) listaMaterial.get(materialPrestar-1);
                materialPrestable.estaPrestado();
                
                System.out.println("Su libro ha sido prestado al usuario "+ listaUsuario.get(usuarioSolicitaPrestar()).getNombre()+", la fecha "+fechaReserva()+".");
                
            }
            
        }
        
    }
    
    void elegirMaterial(){
        
        System.out.println("1. Libro");
        System.out.println("2. Dvd");
        System.out.println("3. Revista");
        System.out.println("Otro. Salir");
        
        System.out.println("¿Que tipo de objeto quieres crear?");
        objetoElegido = teclado.nextInt();
        teclado.nextLine();
        
    }
    
    boolean comprobarMaterial(Material l){
        
        boolean existe=false;
        
        for(int i=0;i<listaMaterial.size();i++){
            
            if(listaMaterial.get(i).equals(l)){
                
                existe=true;
                
            }
            
        }
        
        return existe;
        
    }
    
    void crearLibro(){
        
        System.out.println("Escribe el titulo del libro: ");
        String titulo=teclado.nextLine();
            
        System.out.println("Escribe el anno de publicacion del libro: ");
        int anno_publicacion=teclado.nextInt();
        teclado.nextLine();
            
        System.out.println("Escribe el autor: ");
        String autor=teclado.nextLine();
                    
        System.out.println("Escribe el numero de paginas: ");
        int numeroPaginas=teclado.nextInt();
        teclado.nextLine();
            
        Libro l=new Libro(titulo,anno_publicacion,autor,numeroPaginas);
            
        if(comprobarMaterial(l)==false){
                
            listaMaterial.add(l);
                
        }else{
                
            System.out.println("El libro ya esta en la biblioteca.");
                
        }        
        
    }
    
    void crearDvd(){
        
        System.out.println("Escribe el titulo del dvd: ");
        String titulo=teclado.nextLine();
            
        System.out.println("Escribe el anno de publicacion del dvd: ");
        int anno_publicacion=teclado.nextInt();
        teclado.nextLine();
            
        System.out.println("Escribe el director: ");
        String director=teclado.nextLine();
                    
        System.out.println("Escribe la duracion: ");
        int duracion=teclado.nextInt();
        teclado.nextLine();
            
        Dvd d=new Dvd(titulo,anno_publicacion,director,duracion);
            
        if(comprobarMaterial(d)==false){
                
            listaMaterial.add(d);
                
        }else{
                
            System.out.println("El dvd ya esta en la biblioteca.");
                
        }    
        
    }
    
    void crearRevista(){
        
        System.out.println("Escribe el titulo de la revista: ");
        String titulo=teclado.nextLine();
            
        System.out.println("Escribe el anno de publicacion de la revista: ");
        int anno_publicacion=teclado.nextInt();
        teclado.nextLine();
            
        System.out.println("Escribe la editorial: ");
        String editorial=teclado.nextLine();
                    
        System.out.println("Escribe el numero de edicion: ");
        int numeroEdicion=teclado.nextInt();
        teclado.nextLine();
            
        Revista r=new Revista(titulo,anno_publicacion,editorial,numeroEdicion);
            
        if(comprobarMaterial(r)==false){
                
            listaMaterial.add(r);
                
        }else{
                
            System.out.println("La revista ya esta en la biblioteca.");
                
        }
        
    }
    
    Usuario crearUsuario(){
        
        System.out.println("Nombre del usuario: ");
        String nombre = teclado.nextLine();
        
        System.out.println("Id del usuario: ");
        int id= teclado.nextInt();
        teclado.nextLine();
        
        Usuario u = new Usuario(nombre,id);
        
        return u;
        
    }
    
    boolean comprobarUsuario(Usuario u){
        
        boolean existeUsuario= false;
        
        for(int i=0;i<listaUsuario.size();i++){
            
            if(listaUsuario.get(i).getId() == u.getId()){
                
                existeUsuario=true;
                
            }
            
        }
        
        return existeUsuario;
        
    }
    
    void verMaterial(){
        
        for (int i = 0; i<listaMaterial.size(); i++) {
            
            System.out.println(i+1+". "+listaMaterial.get(i).getTitulo());
            
        }
        
    }
    
    void ordenarListaMaterialAnno(){
        
        for (int i = 0; i < listaMaterial.size() - 1; i++) {
            
            for (int j = i + 1; j < listaMaterial.size(); j++) {
            
                Material m1 = listaMaterial.get(i);
                Material m2 = listaMaterial.get(j);

                if (m1.getAnno_publicacion() > m2.getAnno_publicacion()) {
                
                    listaMaterial.set(i, m2);
                    listaMaterial.set(j, m1);
                    
                }
                
            }
            
        }
        
    }
    
    void verUsuario(){
        
        for (int i = 0; i<listaUsuario.size(); i++) {
            
            System.out.println(i+1+". "+listaUsuario.get(i).getNombre()+": "+listaUsuario.get(i).getId()+".");
            
        }
        
    }
    
    int usuarioSolicitaPrestar(){
        
        System.out.println("¿A que usuario se le presta?");
        
        verUsuario();
        
        System.out.print("--> ");
        int usuarioElegido= teclado.nextInt();
        teclado.nextLine();
        
        if(usuarioElegido<1||usuarioElegido>listaUsuario.size()){
            
            usuarioSolicitaPrestar();
            
        }
        
        return usuarioElegido-1;
        
    }
    
    String fechaReserva(){
        
        String fechaR;
        
        System.out.println("Escribe la fecha de la reserva: ");
        fechaR= teclado.nextLine();
        
        return fechaR;
        
    }
    
}