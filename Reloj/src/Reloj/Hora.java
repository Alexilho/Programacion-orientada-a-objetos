package Reloj;


public class Hora extends Manecilla {

    public Hora() {
        this.setLimite(24);
        this.setUnidad(0);
    }

    public Hora(int h) {
        this.setLimite(24);
        this.setUnidad(h);

    }
}
