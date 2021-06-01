package Reloj;


public class Minuto extends Manecilla {

    public Minuto() {
        this.setLimite(60);
        this.setUnidad(0);
    }

    public Minuto(int m) {
        this.setLimite(60);
        this.setUnidad(m);
    }
}
