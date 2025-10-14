package ejercicio14p;



public class Aparcabicis {

    
    private String title;
    private int anclajes;
    private int plazas;
    private double distanciaAUsuario;
    
    public Aparcabicis(String title,int anclajes,int plazas,double distanciaAUsuario){
        
        this.title=title;
        this.anclajes=anclajes;
        this.plazas=plazas;
        this.distanciaAUsuario=distanciaAUsuario;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnclajes() {
        return anclajes;
    }

    public void setAnclajes(int anclajes) {
        this.anclajes = anclajes;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public double getDistanciaAUsuario() {
        return distanciaAUsuario;
    }

    public void setDistanciaAUsuario(double distanciaAUsuario) {
        this.distanciaAUsuario = distanciaAUsuario;
    }
    
    public String toString(){
        
        return "\nCalle: "+title+".\nNumero de anclajes: "+anclajes+".\nNumero de plazas: "+plazas+".\nDistancia a ti: "+distanciaAUsuario+".";
        
    }
}
