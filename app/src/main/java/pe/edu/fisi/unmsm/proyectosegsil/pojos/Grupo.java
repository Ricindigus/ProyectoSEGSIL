package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Grupo {
    private String id;
    private int numero;
    private String eap;
    private NombreCurso nombreCurso;
    private String tipo;
    private String codProfesor;
    private String nomProfesor;
    private String codDelegado;
    private String nomDelegado;

    public Grupo(String id, int numero, String eap, NombreCurso nombreCurso, String tipo, String codProfesor, String nomProfesor, String codDelegado, String nomDelegado) {
        this.id = id;
        this.numero = numero;
        this.eap = eap;
        this.nombreCurso = nombreCurso;
        this.tipo = tipo;
        this.codProfesor = codProfesor;
        this.nomProfesor = nomProfesor;
        this.codDelegado = codDelegado;
        this.nomDelegado = nomDelegado;
    }

    public Grupo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEap() {
        return eap;
    }

    public void setEap(String eap) {
        this.eap = eap;
    }

    public NombreCurso getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(NombreCurso nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public String getCodDelegado() {
        return codDelegado;
    }

    public void setCodDelegado(String codDelegado) {
        this.codDelegado = codDelegado;
    }

    public String getNomDelegado() {
        return nomDelegado;
    }

    public void setNomDelegado(String nomDelegado) {
        this.nomDelegado = nomDelegado;
    }
}
