package pe.edu.fisi.unmsm.proyectosegsil.pojos;

public class Planes {
    private boolean ss2009;
    private boolean ss2014;
    private boolean sw2009;
    private boolean sw2015;


    public Planes() {
    }

    public Planes(boolean ss2009, boolean ss2014, boolean sw2009, boolean sw2015) {
        this.ss2009 = ss2009;
        this.ss2014 = ss2014;
        this.sw2009 = sw2009;
        this.sw2015 = sw2015;
    }

    public boolean isSs2009() {
        return ss2009;
    }

    public void setSs2009(boolean ss2009) {
        this.ss2009 = ss2009;
    }

    public boolean isSs2014() {
        return ss2014;
    }

    public void setSs2014(boolean ss2014) {
        this.ss2014 = ss2014;
    }

    public boolean isSw2009() {
        return sw2009;
    }

    public void setSw2009(boolean sw2009) {
        this.sw2009 = sw2009;
    }

    public boolean isSw2015() {
        return sw2015;
    }

    public void setSw2015(boolean sw2015) {
        this.sw2015 = sw2015;
    }
}
