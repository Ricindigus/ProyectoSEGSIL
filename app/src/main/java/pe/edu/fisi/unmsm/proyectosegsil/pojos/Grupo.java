package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Grupo {
    private int numero;
    private String idEap;
    private String nombrePlan;
    private String nombreCurso;
    private String codigoTipo;
    private String codigoProfesor;
    private String codigoDelegado;

    public Grupo(int numero, String idEap, String nombrePlan, String nombreCurso, String codigoTipo, String codigoProfesor, String codigoDelegado) {
        this.numero = numero;
        this.idEap = idEap;
        this.nombrePlan = nombrePlan;
        this.nombreCurso = nombreCurso;
        this.codigoTipo = codigoTipo;
        this.codigoProfesor = codigoProfesor;
        this.codigoDelegado = codigoDelegado;
    }

    public Grupo() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getCodigoDelegado() {
        return codigoDelegado;
    }

    public void setCodigoDelegado(String codigoDelegado) {
        this.codigoDelegado = codigoDelegado;
    }
}
