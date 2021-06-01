package juego.de.dados;

public class LogicaJuego {

    public final int INICIA_JUEGO = 0;
    public final int MODO_PRUEBA = 1;
    public final int PERDIÓ = 0;
    public final int GANÓ = 0;
    private int estado = INICIA_JUEGO;
    private static int apuesta = 0;
    private int dinero = 0;
    private int sumaDados = 0;

    public LogicaJuego(int dinero) {
        this.dinero = dinero;
    }

    public static int getApuesta() {
        return apuesta;
    }

    public void ganarApuesta() {
        this.dinero += this.getApuesta() * 2;
        this.apuesta = 0;
    }

    public void hacerApuesta(int apuesta) throws Exception {
        if (apuesta > this.dinero) {
            throw new Exception("la apuesta es mayor que el dinero");
        }
        this.apuesta = apuesta;
    }

    public Dado lanzarDado(Dado dado) {
        dado.lanzarDado();
        return dado;
    }

    public void restarDinero(int dinero) throws Exception {
        if (this.apuesta > this.dinero) {
            throw new Exception("No se puede apostar mas "
                    + "que el dinero de uno de los jugadores");
        }
        this.dinero -= dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) throws Exception {
        if (dinero == 0) {
            throw new Exception("debe empezar con algo de dinero");
        }
        this.dinero = dinero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getSumaDados() {
        return sumaDados;
    }

    public void setSumaDados(int sumaDados) {
        this.sumaDados = sumaDados;
    }

    @Override
    public String toString() {
        return this.getDinero() + "";
    }
}
