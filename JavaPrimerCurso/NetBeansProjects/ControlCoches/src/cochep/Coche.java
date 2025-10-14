package cochep;

import java.io.Serializable;
import java.util.Objects;

public class Coche implements Serializable{

    private String id;
    private double consumoKm;
    private double capacidadCombustible;
    private double combustibleActual;
    private String ubicacion;

    public Coche(String id, double consumoKm, double capacidadCombustible, double combustibleActual, String ubicacion) {
        this.id = id;
        this.consumoKm = consumoKm;
        this.capacidadCombustible = capacidadCombustible;
        this.combustibleActual = combustibleActual;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getConsumoKm() {
        return consumoKm;
    }

    public void setConsumoKm(double consumoKm) {
        this.consumoKm = consumoKm;
    }

    public double getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(double capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCombustibleActual() {
        return combustibleActual;
    }

    public void setCombustibleActual(double combustibleActual) {
        this.combustibleActual = combustibleActual;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", consumoKm=" + consumoKm + ", capacidadCombustible=" + capacidadCombustible + ", combustibleActual=" + combustibleActual + ", ubicacion=" + ubicacion + '}';
    }
    
}
