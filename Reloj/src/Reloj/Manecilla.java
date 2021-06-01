package Reloj;

public class Manecilla {

    private int unidad;
    private int limite;

    public int getLimite() {
        return limite;
    }

    protected void setLimite(int limite) {
        this.limite = Math.abs(limite);
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = Math.abs(unidad);
        if (this.unidad >= limite) {
            this.unidad = 0;
        }
    }

    public void avanzar() {
        unidad += 1;
        if (unidad == limite) {
            unidad = 0;
        }
    }
    public void reiniciar() {
        unidad = 0;
    }
}
