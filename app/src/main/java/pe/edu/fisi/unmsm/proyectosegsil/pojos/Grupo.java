package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Grupo {
    private int numero;
    private String tipo;
    private Profesor profesor;
    private Delegado delegado;

    public Grupo(int numero, String tipo, Profesor profesor, Delegado delegado) {
        this.numero = numero;
        this.tipo = tipo;
        this.profesor = profesor;
        this.delegado = delegado;
    }

    public Grupo() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
