package calculadoracomplejos;
//***
//Autor Cristian Alexander Bravo Ruiz (20142020074)

import java.util.Scanner;

//
//
//
//***
public class Calculadora {

    private double Real;
    private double Imag;

    public double getReal() {
        return Real;
    }

    public void setReal(double Real) {
        this.Real = Real;
    }

    public double getImag() {
        return Imag;
    }

    public void SetImag(double Imag) {
        this.Imag = Imag;
    }

    public Calculadora() {
        this.Real = 0;
        this.Imag = 0;
    }
    public void leer(){
        Scanner r = new Scanner(System.in);
        System.out.println("Digite la parte real y la imaginaria= ");
        System.out.println("Real = ");
        this.Real=r.nextDouble();
        System.out.println("Imag = ");
        this.Imag=r.nextDouble();
        
    }
    public Calculadora Suma(Calculadora c) {
        Calculadora res = new Calculadora();
        res.Real = c.Real + this.Real;
        res.Imag = c.Imag + this.Imag;
        return res;
    }

    public Calculadora Resta(Calculadora c) {
        Calculadora res = new Calculadora();
        res.Real = c.Real - this.Real;
        res.Imag = c.Imag - this.Imag;
        return res; 
    }

    public Calculadora Mult(Calculadora c) {
        Calculadora res = new Calculadora();
        res.Real = (c.Real * this.Real - c.Imag * this.Imag);
        res.Imag = (c.Real * this.Imag + c.Imag * this.Real);
        return res;
    }

    public Calculadora Div(Calculadora c) {
        Calculadora res = new Calculadora();
        res.Real = ((this.Real * c.Real) + (this.Imag * c.Imag)) / ((Math.pow(c.Real, 2)) + (Math.pow(c.Imag, 2)));
        res.Imag = ((c.Real * this.Imag) - (this.Real * c.Imag)) / ((Math.pow(c.Real, 2)) + (Math.pow(c.Imag, 2)));
        return res;
    }

    public Calculadora Norma(Calculadora c) {
        Calculadora res = new Calculadora();
        res.Real = Math.pow(c.Real, 2);
        res.Imag = Math.pow(c.Imag, 2);
        return res;
    
    }
    public Calculadora Conjugado(Calculadora c){
        Calculadora res = new Calculadora();
        res.Real=c.Real*-1;
        res.Imag=c.Imag*-1;
        return res;
    }

    public static void main(String[] args) {
        Calculadora a = new Calculadora();
        Calculadora b = new Calculadora();
        a.leer();
        b.leer();
        Calculadora c = a.Suma(b);
        System.out.println("Suma= \n " + c.getReal() + "+" + c.getImag() + "i");

        Calculadora d = a.Resta(b);
        System.out.println("Resta= \n " + d.getReal() + "+" + d.getImag() + "i");

        Calculadora e = a.Mult(b);
        System.out.println("Mult= \n " + e.getReal() + "+" + e.getImag() + "i");

        Calculadora f = a.Div(b);
        System.out.println("Div= \n " + f.getReal() + "+" + f.getImag() + "i");

        Calculadora g = a.Norma(b);
        System.out.println("Norma= \n " + Math.sqrt(g.getReal() + g.getImag()));
        
        Calculadora h = a.Conjugado(a);
        System.out.println("Conjugago= \n " +h.getReal()+"+"+h.getImag());

    }

}
