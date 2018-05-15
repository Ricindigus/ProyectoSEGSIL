package pe.edu.fisi.unmsm.proyectosegsil.pojos;

import java.util.ArrayList;

public class NombreCurso {
    private String nombrePlan1;
    private String nombrePlan2;

    public NombreCurso(String nombrePlan1, String nombrePlan2) {
        this.nombrePlan1 = nombrePlan1;
        this.nombrePlan2 = nombrePlan2;
    }

    public NombreCurso() {
    }

    public String getNombrePlan1() {
        return nombrePlan1;
    }

    public void setNombrePlan1(String nombrePlan1) {
        this.nombrePlan1 = nombrePlan1;
    }

    public String getNombrePlan2() {
        return nombrePlan2;
    }

    public void setNombrePlan2(String nombrePlan2) {
        this.nombrePlan2 = nombrePlan2;
    }
}
