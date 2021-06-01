package Punto;
//***
//Autor Cristian Alexander Bravo Ruiz (20142020074)
//
//
//
//***
import java.util.Scanner;

public class Punto {


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void leer() {
        Scanner r = new Scanner(System.in);
        System.out.println("Digite la coordenada X ");
        this.x = r.nextDouble();
        System.out.println("Digite la coordenada Y ");
        this.y = r.nextDouble();
        System.out.println("El punto deseado es (" + x + "," + y + ")");
    }

    public void H() {
        Scanner r = new Scanner(System.in);
        System.out.println("Digite la distancia a la cual desplazara X ");
        this.h = r.nextDouble();
        this.hh = x + h;
        System.out.println("La coordenada moviendo deseada X es  (" + hh + "," + y + ")");
    }

    public void V() {
        Scanner r = new Scanner(System.in);
        System.out.println("Digite la distancia a la cual desplazara Y ");
        this.v = r.nextDouble();
        this.vv = y + v;
        System.out.println("La coordenada moviendo deseada Y es  (" + x + "," + vv + ")");
    }

    public void D() {
        Scanner r = new Scanner(System.in);
        System.out.println("Digite la distancia a la cual desplazara X ");
        this.h = r.nextDouble();
        System.out.println("Digite la distancia a la cual desplazara Y ");
        this.v = r.nextDouble();
        this.d1 = x + h;
        this.d2 = y + v;
        System.out.println("La coordenada final es  (" + d1 + "," + d2 + ")");

    }

    public void O() {
        this.o = Math.sqrt(x * x + y * y);
        System.out.println("La distancia al origen de (" + x + "," + y + ") es " + o);
    }

    public void distancia() {
        Punto b = new Punto();
        System.out.println(" Digite el nuevo punto");
        b.leer();
        this.s1 = Math.sqrt(Math.pow(x, 2) + (Math.pow(y, 2)));
        this.s2 = Math.sqrt(Math.pow(x - b.x, 2) + (Math.pow(y - b.y, 2)));
        System.out.println(" La distancia es =" + s2);

    }
     private double h, hh;
    private double v, vv;
    private double d1, d2;
    private double o;
    private double s1, s2;
    protected double x;
    protected double y;

    public static void main(String[] args) {
        Punto a = new Punto();
        Puntoen3d f = new Puntoen3d();
        Scanner c = new Scanner(System.in);
        int e;
        int w;
        int op;
        System.out.println("Elija una opcion: \n 1-Punto 2D \n 2-Punto 3D");
        w = c.nextInt();
        switch (w) {
            case 1: {
                a.leer();
                System.out.println("ingrese la operacion deseada \n 1-mover Horizontalmente \n 2-Mover Verticalemtente\n 3-Mover Diagonal \n 4-Calcular distancia al origen \n 5-Calcular distancia a otro punto");
                op = c.nextInt();
                switch (op) {
                    case 1: {
                        a.H();
                        break;
                    }
                    case 2: {
                        a.V();
                        break;
                    }
                    case 3: {
                        a.D();
                        break;
                    }
                    case 4: {
                        a.O();
                        break;
                    }
                    case 5: {
                        a.distancia();
                        break;
                    }
                    default: {
                        System.out.println("OPCION ERRONEA");
                        break;
                    }
                }
                break;
            }

            case 2: {
                f.leerZ();
                System.out.println("Ejecute la operacion a realizar: \n 1-Mover Z \n 2-Distacia 3D \n 3-Mover XYZ");
                e = c.nextInt();
                switch (e) {
                    case 1: {
                        f.moverZ();
                        break;
                    }
                    case 2: {
                        f.distancia3d();
                        break;
                    }
                    case 3: {
                        f.moverXYZ();
                        break;
                    }
                    default: {
                        System.out.println("OPCION ERRONEA");
                        break;
                    }
                }
            }
            defult:
            {
                System.out.println("OPCION ERRONEA");
                break;
            }

        }

    }
}
