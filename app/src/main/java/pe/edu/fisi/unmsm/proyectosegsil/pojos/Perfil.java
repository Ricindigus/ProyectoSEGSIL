package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Perfil {
    private int id;
    private String descripcion;

    public Perfil(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Perfil() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
