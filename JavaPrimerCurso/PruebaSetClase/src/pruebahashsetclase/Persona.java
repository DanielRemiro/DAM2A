/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebahashsetclase;

import java.util.Objects;



/**
 *
 * @author alu
 */
public class Persona {
    private int id;
    private String nombre;

    Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "\nID: " + id + "\tNombre: " + nombre + "\t|";
    }
    
   
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Persona)){
            return false;
        }
        Persona p=(Persona)obj;
        return (id==p.id && nombre.equalsIgnoreCase(p.nombre));
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(id, nombre);
    }
    
}
