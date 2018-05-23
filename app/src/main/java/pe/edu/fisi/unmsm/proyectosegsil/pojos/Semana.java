package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Semana {
    private int numero;
    private String unidad;

    public Semana(int numero, String unidad) {
        this.numero = numero;
        this.unidad = unidad;
    }

    public Semana() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
