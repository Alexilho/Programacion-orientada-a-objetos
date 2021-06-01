package CoordenadasGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Coor extends JFrame implements ActionListener {

    JTextField x, y;
    JTextField newx, newy;
    JLabel etiqueta;
    JButton botonmx;
    JButton botonmy;
    JButton botonmd;
    JButton botonorigen;
    JButton botondis;

    public Coor() {

        x = new JTextField();
        y = new JTextField();
        newx = new JTextField();
        newy = new JTextField();
        etiqueta = new JLabel();
        botonmx = new JButton("MOVER X");
        botonmy = new JButton("MOVER Y");
        botonmd = new JButton("MOVER PUNTO");
        botonorigen = new JButton("ORIGEN");
        botondis = new JButton("DISTANCIAS");
        this.getContentPane().setLayout(new GridLayout(10, 2));
        this.getContentPane().add(x);
        this.getContentPane().add(y);
        this.getContentPane().add(newx);
        this.getContentPane().add(newy);
        this.getContentPane().add(botonmx);
        this.getContentPane().add(botonmy);
        this.getContentPane().add(botonmd);
        this.getContentPane().add(botonorigen);
        this.getContentPane().add(botondis);
        this.getContentPane().add(etiqueta);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonmx.addActionListener(this);
        botonmy.addActionListener(this);
        botonmd.addActionListener(this);
        botonorigen.addActionListener(this);
        botondis.addActionListener(this);
        botonmx.setActionCommand("MOVER X");
        botonmy.setActionCommand("MOVER Y");
        botonmd.setActionCommand("MOVER PUNTO");
        botonorigen.setActionCommand("ORIGEN");
        botondis.setActionCommand("DISTANCIAS");

    }

    public static void main(String[] args) {
        new Coor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("MOVER X")) {
            String t1 = x.getText();
            String t2 = y.getText();
            String t3 = newx.getText();
            String t4 = newy.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total1 = Double.toString(v1 + v3);
            String total2 = Double.toString(v2);
            etiqueta.setText("X=" + total1 + ", Y=" + total2);
        }
        if (e.getActionCommand().equals("MOVER Y")) {
            String t1 = x.getText();
            String t2 = y.getText();
            String t3 = newx.getText();
            String t4 = newy.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total1 = Double.toString(v1);
            String total2 = Double.toString(v2 + v4);
            etiqueta.setText("X=" + total1 + ", Y=" + total2);
        }
        if (e.getActionCommand().equals("MOVER PUNTO")) {
            String t1 = x.getText();
            String t2 = y.getText();
            String t3 = newx.getText();
            String t4 = newy.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total1 = Double.toString(v1 + v3);
            String total2 = Double.toString(v2 + v4);
            etiqueta.setText("X=" + total1 + ", Y=" + total2);
        }
        if (e.getActionCommand().equals("ORIGEN")) {
            String t1 = x.getText();
            String t2 = y.getText();
            String t3 = newx.getText();
            String t4 = newy.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total1 = Double.toString(Math.sqrt((v1*v1)+(v2*v2)));
            etiqueta.setText("ORIGEN= "+total1);
        }
        if (e.getActionCommand().equals("DISTANCIAS")) {
            String t1 = x.getText();
            String t2 = y.getText();
            String t3 = newx.getText();
            String t4 = newy.getText();
            double v1 = Double.parseDouble(t1);
            double v2 = Double.parseDouble(t2);
            double v3 = Double.parseDouble(t3);
            double v4 = Double.parseDouble(t4);
            String total1 = Double.toString((Math.sqrt(Math.pow(v1, 2)+(Math.pow(v2, 2)))));
            String total2 = Double.toString(Math.sqrt(Math.pow(v1 - v3, 2) + (Math.pow(v2 - v4, 2))));
            etiqueta.setText(total1+","+total2);
        }
    }
}
