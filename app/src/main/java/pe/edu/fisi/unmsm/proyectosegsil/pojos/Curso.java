package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Curso {
    private String eap;
    private NombreCurso nombre;
    private Coordinador coordinador;

    public Curso(String eap, NombreCurso nombre, Coordinador coordinador) {
        this.eap = eap;
        this.nombre = nombre;
        this.coordinador = coordinador;
    }

    public Curso() {
    }

    public String getEap() {
        return eap;
    }

    public void setEap(String eap) {
        this.eap = eap;
    }

    public NombreCurso getNombre() {
        return nombre;
    }

    public void setNombre(NombreCurso nombre) {
        this.nombre = nombre;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}

