package proveedoresp;

import java.util.ArrayList;



public class Proveedor {
    
    private int ID;
    private int nombre;
    private ArrayList<InsumoProveedor>listaInsumos=new ArrayList<>();

    public Proveedor(int ID, int nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public ArrayList<InsumoProveedor> getListaInsumos() {
        return listaInsumos;
    }

    public void setListaInsumos(ArrayList<InsumoProveedor> listaInsumos) {
        this.listaInsumos = listaInsumos;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "ID=" + ID + ", nombre=" + nombre + '}';
    }
    
}
