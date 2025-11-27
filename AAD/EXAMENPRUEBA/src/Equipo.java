public class Equipo {
    private int id; // Se llenará tras insertar en BBDD
    private String nombre;
    private String estadio;

    public Equipo(String nombre, String estadio) {
        this.nombre = nombre;
        this.estadio = estadio;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEstadio() { return estadio; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}