package insumos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class Insumo implements Serializable  {
    
    private int id;//Identificador unico para cada insumo
    private String nombre;
    private int cantidadStock;//Cantidad total en el hospital
    private LocalDate fechaCaducidad;
    private int stockMinimo;//Cantidad minima necesaria antes de hacer un pedido
    private boolean esEspecial;//Si es de alto consumo o algo especial lo guarda true
    
    public Insumo(int id,String nombre,int cantidadStock,int stockMinimo,LocalDate fechaCaducidad,boolean esEspecial){
        
        this.id=id;
        this.nombre=nombre;
        this.cantidadStock=cantidadStock;
        this.stockMinimo=stockMinimo;
        this.fechaCaducidad=fechaCaducidad;
        this.esEspecial=esEspecial;
        
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

    public int getCantidadStock() {
        
        return cantidadStock;
        
    }

    public void setCantidadStock(int cantidadStock) {
        
        this.cantidadStock = cantidadStock;
        
    }

    public LocalDate getFechaCaducidad() {
        
        return fechaCaducidad;
        
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        
        this.fechaCaducidad = fechaCaducidad;
        
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }

    @Override
    public int hashCode(){//Devuelve el hashcode del ID del insumo
        
        return Objects.hash(id);
        
    }
    
    @Override
    public boolean equals(Object i) {//Compara los ID de objeto para saber si son iguales
        
        if (this == i) return true;
        
        if (i == null || getClass() != i.getClass()) return false;
        
        Insumo insumo = (Insumo) i;
        
        return id == insumo.id;
        
    }
    
    @Override
    public String toString(){//Devuelve la informacion de los insumos
        
        return "ID: "+id+",nombre: "+nombre+",stock: "+cantidadStock;
        
    }
    
    public boolean necesitaPedido() {//Operacion para saber si se necesita hacer pedido por falta de stock
        
        return cantidadStock <= stockMinimo;
        
    }
    
    public boolean estaCaducado(){//Compara la fecha actual con la de caducidad para ver si esta caducado
        
        return !fechaCaducidad.isAfter(LocalDate.now());
        
    }
    
}
