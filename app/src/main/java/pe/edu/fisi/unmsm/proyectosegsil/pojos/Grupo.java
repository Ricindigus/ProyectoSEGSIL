package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Grupo {
    private String id;
    private int numero;
    private String eap;
    private NombreCurso nombreCurso;
    private String tipo;
    private Profesor profesor;
    private Delegado delegado;

    public Grupo(String id, int numero, String eap, NombreCurso nombreCurso, String tipo, Profesor profesor, Delegado delegado) {
        this.id = id;
        this.numero = numero;
        this.eap = eap;
        this.nombreCurso = nombreCurso;
        this.tipo = tipo;
        this.profesor = profesor;
        this.delegado = delegado;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Delegado getDelegado() {
        return delegado;
    }

    public void setDelegado(Delegado delegado) {
        this.delegado = delegado;
    }
}
