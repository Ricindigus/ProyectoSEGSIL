package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Eaps {
    private boolean ss;
    private boolean sw;

    public Eaps(boolean ss, boolean sw) {
        this.ss = ss;
        this.sw = sw;
    }

    public Eaps() {
    }

    public boolean isSs() {
        return ss;
    }

    public void setSs(boolean ss) {
        this.ss = ss;
    }

    public boolean isSw() {
        return sw;
    }

    public void setSw(boolean sw) {
        this.sw = sw;
    }
}
