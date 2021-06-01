package Reloj;


public class Reloj {

    private Hora hor;
    private Minuto min;
    private Segundo seg;

    public Hora getHor() {
        return hor;
    }

    public Minuto getMin() {
        return min;
    }

    public Segundo getSeg() {
        return seg;
    }

    public Reloj() {
        hor = new Hora();
        min = new Minuto();
        seg = new Segundo();
    }

    public Reloj(int h, int m, int s) {
        hor = new Hora(h);
        min = new Minuto(m);
        seg = new Segundo(s);
    }

    public void avanzar() {
        seg.avanzar();
        if (seg.getUnidad() == 0) {
            min.avanzar();
            if (min.getUnidad() == 0) {
                hor.avanzar();
            }
            if (hor.getUnidad() == 0) {
            }
        }
    }

    public void reiniciar() {
        hor.reiniciar();
        min.reiniciar();
        seg.reiniciar();
    }


    @Override
    public String toString() {
        return hor.getUnidad() + ":" + min.getUnidad() + ":" + seg.getUnidad();
    }
}
