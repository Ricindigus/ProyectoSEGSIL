package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Persona {
    private String id;
    private NombrePersona nombrePersona;
    private String correo;
    private String telefono;

    public Persona(String id, NombrePersona nombrePersona, String correo, String telefono) {
        this.id = id;
        this.nombrePersona = nombrePersona;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NombrePersona getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(NombrePersona nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
