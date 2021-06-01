package juego.de.dados;

public class NuemerosGanadores {

    public final static int[] NUMEROS_GANADORES = {7, 11};
    public final static int[] NUMEROS_PERDEDORES = {2, 3, 12};
    private Dado dado1;
    private Dado dado2;
    private LogicaJuego jugador;
    private Maquina maquina;

    public NuemerosGanadores(LogicaJuego jugador, Maquina maquina) {
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.jugador = jugador;
        this.maquina = maquina;
    }

    public void Jugar() {
        this.setDado1(this.jugador.lanzarDado(getDado1()));
        this.setDado2(this.jugador.lanzarDado(getDado2()));
    }

    public void JugarMaquina() {
        this.setDado1(this.maquina.lanzarDado(getDado1()));
        this.setDado2(this.maquina.lanzarDado(getDado2()));
    }

   public boolean mirarAcierto(LogicaJuego jugador) {
        boolean indicadorAcierto = false;

        switch (jugador.getEstado()) {
            case 0:
                jugador.setSumaDados(getDado1().sumarCaras(getDado2()));

                if (jugador.getSumaDados() == this.NUMEROS_GANADORES[0]
                        || jugador.getSumaDados() == this.NUMEROS_GANADORES[1]) {
                    indicadorAcierto = true;
                } else if (jugador.getSumaDados() == this.NUMEROS_PERDEDORES[0]
                        || jugador.getSumaDados() == this.NUMEROS_PERDEDORES[1]
                        || jugador.getSumaDados() == this.NUMEROS_PERDEDORES[2]) {
                    jugador.setEstado(jugador.PERDIÓ);
                } else {
                    jugador.setEstado(jugador.MODO_PRUEBA);
                }

                break;

            case 1:
                if (jugador.getSumaDados() == getDado1().sumarCaras(getDado2())) {
                    indicadorAcierto = true;
                } else if (getDado1().sumarCaras(getDado2()) == this.NUMEROS_GANADORES[0]) {
                    jugador.setEstado(jugador.PERDIÓ);
                }
                break;
        }
        return indicadorAcierto;
        //return this.indicadorAsierto;
    }

    /**
     * @return the dado1
     */
    public Dado getDado1() {
        return dado1;
    }

    /**
     * @param dado1 the dado1 to set
     */
    public void setDado1(Dado dado1) {
        this.dado1 = dado1;
    }

    /**
     * @return the dado2
     */
    public Dado getDado2() {
        return dado2;
    }

    /**
     * @param dado2 the dado2 to set
     */
    public void setDado2(Dado dado2) {
        this.dado2 = dado2;
    }

    /**
     * @return the jugador
     */
    public LogicaJuego getJugador() {
        return jugador;
    }

    public void setJugador(LogicaJuego jugador) {
        this.jugador = jugador;
    }

    

    @Override
    public String toString() {
        return "dado 1: " + this.dado1.toString() + "\n"
                + "dado 2: " + this.dado2.toString() + "\n";

    }

    public String toString2() {
        return "dinero del jugador: " + this.jugador.toString()
                + "\ndinero de la maquina: " + this.maquina.toString();

    }
}