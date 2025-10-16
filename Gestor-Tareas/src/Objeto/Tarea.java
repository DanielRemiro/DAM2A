package Objeto;

public class Tarea {

    private String mensaje;
    private int id;

    public Tarea(String mensaje, int id){
        this.mensaje = mensaje;
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "mensaje='" + mensaje + '\'' +
                ", id=" + id +
                '}';
    }
}
