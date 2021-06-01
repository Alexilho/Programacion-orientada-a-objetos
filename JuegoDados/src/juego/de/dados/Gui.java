
package juego.de.dados;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import juego.de.dados.NuemerosGanadores;
import juego.de.dados.LogicaJuego;
import juego.de.dados.Maquina;


public class Gui extends JFrame implements ActionListener {

    private JLabel dado1;
    private JLabel dado2;
    private ImageIcon cara1, cara2, cara3, cara4, cara5, cara6, dado;
    private JLabel dineroJugador, dineroMaquina;
    private JTextArea texto;
    private JButton accion;
    private NuemerosGanadores juego;
    private LogicaJuego jugador;
    private Maquina maquina;

    public Gui() {

        super("Juego de Dados");
        this.setSize(500, 450);
        this.setResizable(false);

        jugador = new LogicaJuego(0);
        maquina = new Maquina(0);
        juego = new NuemerosGanadores(jugador, maquina);
        dado1 = new JLabel(dado);
        dado2 = new JLabel(dado);
        dineroJugador = new JLabel("APOSTADOR = 0");
        dineroJugador.setFont(new Font("comic sans ms", 2, 9));
        dineroMaquina = new JLabel(" BOLSA = 0");
        dineroMaquina.setFont(new Font("comic sans ms", 2, 9));
        texto = new JTextArea("");
        texto.setForeground(Color.WHITE);
        texto.setBackground(Color.black);
        texto.setLineWrap(true);
        accion = new JButton("Ingesar dinero");
        accion.addActionListener(this);
        accion.setActionCommand("dinero");

        this.getContentPane().setLayout(new GridLayout(2, 2));

        add(dineroJugador);
        add(dineroMaquina);
        add(texto);
        add(accion);
        add(dado1);
        add(dado2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static String darNumeros(int[] numeros) {
        String strNumeros = "";
        for (int i = 0; i < numeros.length; i++) {
            strNumeros += numeros[i] + ",";
        }
        return strNumeros;
    }

    public void parametrosJuego() {
        if (jugador.getEstado() == jugador.INICIA_JUEGO) {
            this.texto.setText("gana con los numeros: " + darNumeros(NuemerosGanadores.NUMEROS_GANADORES) + "\n"
                    + "pierde con los numeros: " + darNumeros(NuemerosGanadores.NUMEROS_PERDEDORES) + "\n");
        } else if (jugador.getEstado() == jugador.MODO_PRUEBA) {
            this.texto.setText("gana con el numero: " + jugador.getSumaDados() + "\n"
                    + "pierde con el numero: " + NuemerosGanadores.NUMEROS_GANADORES[0] + "\n");
        }
        if (maquina.getEstado() == maquina.INICIA_JUEGO) {
            this.texto.setText(texto.getText() + "\nla casa gana con los numeros: " + darNumeros(NuemerosGanadores.NUMEROS_GANADORES) + "\n"
                    + "la casa pierde con los numeros: " + darNumeros(NuemerosGanadores.NUMEROS_PERDEDORES) + "\n");
        } else if (maquina.getEstado() == maquina.MODO_PRUEBA) {
            this.texto.setText(texto.getText() + "\nla casa gana con el numero: " + maquina.getSumaDados() + "\n"
                    + "la casa pierde con el numero: " + NuemerosGanadores.NUMEROS_GANADORES[0] + "\n");
        }
    }

    public void actualizarDinero() {
        this.dineroJugador.setText(" Dinero Jugador = " + this.jugador.getDinero());
        this.dineroMaquina.setText(" Dinero casa = " + this.maquina.getDinero());
    }

    public void cambiarCaraDados() {
        switch (juego.getDado1().getCara()) {
            case 1:
                dado1.setIcon(cara1);
                break;
            case 2:
                dado1.setIcon(cara2);
                break;
            case 3:
                dado1.setIcon(cara3);
                break;
            case 4:
                dado1.setIcon(cara4);
                break;
            case 5:
                dado1.setIcon(cara5);
                break;
            case 6:
                dado1.setIcon(cara6);
                break;
        }
        switch (juego.getDado2().getCara()) {
            case 1:
                dado2.setIcon(cara1);
                break;
            case 2:
                dado2.setIcon(cara2);
                break;
            case 3:
                dado2.setIcon(cara3);
                break;
            case 4:
                dado2.setIcon(cara4);
                break;
            case 5:
                dado2.setIcon(cara5);
                break;
            case 6:
                dado2.setIcon(cara6);
                break;
        }
    }

    public void empezarJuego() {
        try {
            int dinero = Integer.parseInt(texto.getText());
            this.jugador.setDinero(dinero);
            this.maquina.setDinero(dinero);
            actualizarDinero();
            this.accion.setText("Apostar");
            this.accion.setActionCommand("apostar");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se manejan valores numericos, no caracteres");
            this.texto.setText("100");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.texto.setText("100");
        }
    }

    public void apostar() {
        try {
            int apuesta = Integer.parseInt(texto.getText());
            jugador.hacerApuesta(apuesta);
            jugador.restarDinero(apuesta);
            maquina.restarDinero(apuesta);
            actualizarDinero();
            this.texto.setText("");
            this.texto.setEditable(false);
            parametrosJuego();
            this.accion.setText("Lanzar Dados");
            this.accion.setActionCommand("jugar");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se manejan valores numericos, no caracteres");
            this.texto.setText("100");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.texto.setText("100");
        }
    }

    public void ganarMaquina() {
        actualizarDinero();
        this.texto.setText(texto.getText() + "\nLA CASA GANA: "
                + LogicaJuego.getApuesta() + " $ !!!");
        maquina.ganarApuesta();
        actualizarDinero();
        this.accion.setText("Nuevo Juego");
        this.accion.setActionCommand("nuevoJuego");
    }

    public void ganarJugador() {
        this.texto.setText(texto.getText() + "\nUSTED GANO: " + LogicaJuego.getApuesta()
                + " $ !!!");
        jugador.ganarApuesta();
        actualizarDinero();
        this.accion.setText("Nuevo Juego");
        this.accion.setActionCommand("nuevoJuego");
    }

    public void nuevoJuego() {
        try {
            if (jugador.getDinero() == 0) {
                texto.setText("100");
                this.accion.setText("Empezar Nuevo juego");
                texto.setEditable(true);
                this.accion.setActionCommand("dinero");
            } else if (maquina.getDinero() == 0) {
                texto.setText("La Casa perdio todo su dinero, puede seguir"
                        + " jugando contra la Casas.\n"
                        + "la Casa obtuvo su mismo dinero ");
                this.maquina.setDinero(jugador.getDinero());
                parametrosJuego();
                this.accion.setText("Lanzar Dados");
                texto.setEditable(true);
                this.accion.setActionCommand("jugar");
            } else {
                texto.setText("100");
                texto.setEditable(true);
                this.accion.setText("Apostar");
                this.accion.setActionCommand("apostar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.texto.setText("100");
        }
    }

    public void lanzarDados() {
        this.parametrosJuego();
        juego.Jugar();
        this.cambiarCaraDados();
        this.texto.setText(texto.getText() + "\nSuma de dados= " + juego.getDado1().sumarCaras(juego.getDado2()));
        if (juego.mirarAcierto(jugador)) {
            ganarJugador();
        } else if (jugador.getEstado() == jugador.PERDIÓ) {
            ganarMaquina();
        } else {
            this.texto.setText(texto.getText() + "\nes el turno de la Casa.\n");
            this.accion.setActionCommand("jugarCasa");
            this.accion.setText("Juego de Casa");
        }
    }

    public void lanzarDadosMaquina() {
        this.parametrosJuego();
        juego.JugarMaquina();
        this.cambiarCaraDados();
        this.texto.setText(texto.getText() + "\nsuma de dados= " + juego.getDado1().sumarCaras(juego.getDado2()));
        if (juego.mirarAcierto(maquina)) {
            ganarMaquina();
        } else if (maquina.getEstado() == maquina.PERDIÓ) {
            ganarJugador();
        } else {
            this.texto.setText(texto.getText() + "\nvolver a intentarlo\n");
            this.accion.setActionCommand("jugar");
            this.accion.setText("Lanzar Dados");
        }
    }

    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "jugar":
                this.lanzarDados();
                break;
            case "jugarCasa":
                lanzarDadosMaquina();
                break;
            case "dinero":
                this.empezarJuego();
                break;
            case "apostar":
                this.apostar();
                break;
            case "nuevoJuego":
                nuevoJuego();
                break;
        }

    }
}
