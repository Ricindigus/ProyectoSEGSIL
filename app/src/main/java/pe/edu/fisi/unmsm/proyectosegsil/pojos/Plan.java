package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Plan {
    private String id;
    private String nombre;
    private String id_eap;

    public Plan(String id, String nombre, String id_eap) {
        this.id = id;
        this.nombre = nombre;
        this.id_eap = id_eap;
    }


    public Plan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_eap() {
        return id_eap;
    }

    public void setId_eap(String id_eap) {
        this.id_eap = id_eap;
    }
}
