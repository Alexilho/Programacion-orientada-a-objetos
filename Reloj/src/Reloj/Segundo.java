
package Reloj;


public class Segundo extends Manecilla {

    public Segundo() {
        this.setLimite(60);
        this.setUnidad(0);
    }

    public Segundo(int s) {
        this.setLimite(60);
        this.setUnidad(s);
    }

}
