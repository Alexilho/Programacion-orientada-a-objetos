package Interfaz;

import Reloj.Reloj;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class Cronometroi extends JPanel {

    private Reloj crono;
    private JLabel hora;
    private Timer timer = new Timer();

    public Cronometroi() {

        crono = new Reloj();
        hora = new JLabel(crono.toString());

        setLayout(new FlowLayout());
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Reloj:")));
        setSize(100, 200);

        add(hora);

    }

    public void Iniciar() {
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                hora.setText(crono.toString());

                crono.avanzar();
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void Detener() {
        timer.cancel();
        timer = new Timer();
    }

    public void Reiniciar() {
        crono.getHor().reiniciar();
        crono.getMin().reiniciar();
        crono.getSeg().reiniciar();
        hora.setText(crono.toString());
    }

}