package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Usuario {
    private String id;
    private int perfil;

    public Usuario(String id, int perfil) {
        this.id = id;
        this.perfil = perfil;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
}
