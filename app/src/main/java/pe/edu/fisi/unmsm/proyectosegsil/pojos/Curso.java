package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Curso {
    private Eap eap;
    private Plan plan;
    private String nombre;
    private Coordinador coordinador;

    public Curso(Eap eap, Plan plan, String nombre, Coordinador coordinador) {
        this.eap = eap;
        this.plan = plan;
        this.nombre = nombre;
        this.coordinador = coordinador;
    }

    public Curso() {
    }

    public Eap getEap() {
        return eap;
    }

    public void setEap(Eap eap) {
        this.eap = eap;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
