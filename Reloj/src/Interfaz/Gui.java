package Interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Gui extends JFrame {

    private static Cronometroi cronometro;
    private Opciones botones;

    public Gui() {
        setTitle("Reloj");
        setVisible(true);

        cronometro = new Cronometroi();
        botones = new Opciones();

        this.getContentPane().setLayout(new BorderLayout());

        add(cronometro, BorderLayout.PAGE_START);
        add(botones, BorderLayout.CENTER);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(280, 180);
        this.setResizable(false);

    }

    public static void Iniciar() {
        cronometro.Iniciar();
    }

    public static void Detener() {
        cronometro.Detener();
    }

    public static void Reiniciar() {
        cronometro.Reiniciar();
    }

    public static void main(String[] args) {
        new Gui();
    }
}
