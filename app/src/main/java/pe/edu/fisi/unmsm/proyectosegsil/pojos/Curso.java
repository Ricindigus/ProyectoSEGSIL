package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Curso {
    private String id;
    private String eap;
    private NombreCurso nombre;
    private String idCoordinador;
    private String nombreCoordinador;

    public Curso(String id, String eap, NombreCurso nombre, String idCoordinador, String nombreCoordinador) {
        this.id = id;
        this.eap = eap;
        this.nombre = nombre;
        this.idCoordinador = idCoordinador;
        this.nombreCoordinador = nombreCoordinador;
    }

    public Curso() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }
}

