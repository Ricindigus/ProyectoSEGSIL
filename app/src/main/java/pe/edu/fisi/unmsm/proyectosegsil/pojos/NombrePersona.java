package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class NombrePersona {
    private String nombres;
    private String apellidos;

    public NombrePersona(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public NombrePersona() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
