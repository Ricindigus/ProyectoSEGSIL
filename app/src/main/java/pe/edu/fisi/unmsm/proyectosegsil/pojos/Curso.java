package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Curso {
    private String nombre;
    private String idEap;
    private String nombrePlan;
    private String codigoCoordinador;

    public Curso(String nombre, String idEap, String nombrePlan, String codigoCoordinador) {
        this.nombre = nombre;
        this.idEap = idEap;
        this.nombrePlan = nombrePlan;
        this.codigoCoordinador = codigoCoordinador;
    }

    public Curso() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEap() {
        return idEap;
    }

    public void setIdEap(String idEap) {
        this.idEap = idEap;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getCodigoCoordinador() {
        return codigoCoordinador;
    }

    public void setCodigoCoordinador(String codigoCoordinador) {
        this.codigoCoordinador = codigoCoordinador;
    }
}
