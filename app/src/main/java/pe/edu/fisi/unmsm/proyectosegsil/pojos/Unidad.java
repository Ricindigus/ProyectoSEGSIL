package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Unidad {
    private int numero;
    private String nombre;
    private int semanas;

    public Unidad(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Unidad() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }
}
