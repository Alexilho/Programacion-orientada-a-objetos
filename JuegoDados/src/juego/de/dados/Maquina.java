package juego.de.dados;

public class Maquina extends LogicaJuego {

    public Maquina(int dinero) {
        super(dinero * 10);
    }

    @Override
    public void setDinero(int dinero) throws Exception {
        super.setDinero(dinero * 10);
    }
}