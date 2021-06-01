package calcu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author CRISTIAN UNIVERSIDAD
 */
public class Calculadora extends JFrame implements ActionListener {

    JTextField Real1, Real2;
    JTextField Imag1, Imag2;
    JLabel etiqueta;
    JButton botonsuma;
    JButton botonresta;
    JButton botonmul;
    JButton botondiv;
    JButton botonnor;
    JButton botoncon;

    public Calculadora() {

        Real1 = new JTextField();
        Real2 = new JTextField();
        Imag1 = new JTextField();
        Imag2 = new JTextField();
        etiqueta = new JLabel();
        botonsuma = new JButton("SUMAR");
        botonresta = new JButton("RESTAR");
        botonmul = new JButton("MULTIPLICAR");
        botondiv = new JButton("DIVIDIR");
        botonnor = new JButton("NORMA");
        botoncon = new JButton("CONJUGADO");
        this.getContentPane().setLayout(new GridLayout(10, 2));
        this.getContentPane().add(Real1);
        this.getContentPane().add(Imag1);
        this.getContentPane().add(Real2);
        this.getContentPane().add(Imag2);
        this.getContentPane().add(botonsuma);
        this.getContentPane().add(botonresta);
        this.getContentPane().add(botonmul);
        this.getContentPane().add(botondiv);
        this.getContentPane().add(botonnor);
        this.getContentPane().add(botoncon);
        this.getContentPane().add(etiqueta);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonsuma.addActionListener(this);
        botonresta.addActionListener(this);
        botonmul.addActionListener(this);
        botondiv.addActionListener(this);
        botonnor.addActionListener(this);
        botoncon.addActionListener(this);
        botonsuma.setActionCommand("SUMAR");
        botonresta.setActionCommand("RESTAR");
        botonmul.setActionCommand("MULTIPLICAR");
        botondiv.setActionCommand("DIVIDIR");
        botonnor.setActionCommand("NORMA");
        botoncon.setActionCommand("CONJUGADO");

    }

    public static void main(String[] args) {
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SUMAR")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(v1 + v2);
            String total2 = Double.toString(v3 + v4);
            etiqueta.setText(total + "+" + total2 + "i");
        }

        if (e.getActionCommand().equals("RESTAR")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(v1 - v2);
            String total2 = Double.toString(v3 - v4);
            etiqueta.setText(total + "+" + total2 + "i");
        }

        if (e.getActionCommand().equals("MULTIPLICAR")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(((v1 * v2) - (v3 * v4)));
            String total2 = Double.toString(((v1 * v4) + (v1 * v2)));
            etiqueta.setText(total + "+" + total2 + "i");

        }
        if (e.getActionCommand().equals("DIVIDIR")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(((v2 * v1) + (v4 * v3)) / ((Math.pow(v1, 2)) + (Math.pow(v3, 2))));
            String total2 = Double.toString(((v1 * v4) - (v2 * v3)) / ((Math.pow(v1, 2)) + (Math.pow(v3, 2))));
            etiqueta.setText(total + "+" + total2 + "i");
        }
        if (e.getActionCommand().equals("NORMA")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(Math.sqrt((Math.pow(v1, 2)) + (Math.pow(v2, 2))));
            etiqueta.setText(total);

        }
        if (e.getActionCommand().equals("CONJUGADO")) {
            String t1 = Real1.getText();
            String t2 = Real2.getText();
            String t3 = Imag1.getText();
            String t4 = Imag2.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total = Double.toString(v1 * -1);
            String total2 = Double.toString(v2 * -1);
            etiqueta.setText(total + "+" + total2);
        }
    }
}
