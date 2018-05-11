package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Perfiles {
    private boolean administrador;
    private boolean decanato;
    private boolean director_sw;
    private boolean director_ss;
    private boolean coordinador;
    private boolean profesor;
    private boolean delegado;

    public Perfiles(boolean administrador, boolean decanato, boolean director_sw, boolean director_ss, boolean coordinador, boolean profesor, boolean delegado) {
        this.administrador = administrador;
        this.decanato = decanato;
        this.director_sw = director_sw;
        this.director_ss = director_ss;
        this.coordinador = coordinador;
        this.profesor = profesor;
        this.delegado = delegado;
    }

    public Perfiles() {
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isDecanato() {
        return decanato;
    }

    public void setDecanato(boolean decanato) {
        this.decanato = decanato;
    }

    public boolean isDirector_sw() {
        return director_sw;
    }

    public void setDirector_sw(boolean director_sw) {
        this.director_sw = director_sw;
    }

    public boolean isDirector_ss() {
        return director_ss;
    }

    public void setDirector_ss(boolean director_ss) {
        this.director_ss = director_ss;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    public boolean isProfesor() {
        return profesor;
    }

    public void setProfesor(boolean profesor) {
        this.profesor = profesor;
    }

    public boolean isDelegado() {
        return delegado;
    }

    public void setDelegado(boolean delegado) {
        this.delegado = delegado;
    }
}
