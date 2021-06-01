package juego.de.dados;

import java.util.Random;


public class Dado {

    private int cara = 1;
    private int lados = 6;
    private static Random rdm;

    public Dado() {
        this.rdm = new Random();
    }

    public void lanzarDado() {
        this.setCara((int) (this.rdm.nextDouble() * 6 + 1));
    }

    public int sumarCaras(Dado dado2) {
        return this.getCara() + dado2.getCara();
    }

    public int getCara() {
        return cara;
    }

    
    public void setCara(int cara) {
        this.cara = cara;
    }

    @Override
    public String toString() {
        return this.getCara() + "";
    }
}