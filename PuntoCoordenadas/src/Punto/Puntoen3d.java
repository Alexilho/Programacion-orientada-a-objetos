package Punto;
//***
//Autor Cristian Alexander Bravo Ruiz (20142020074)
//
//
//
//***

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;


public class Puntoen3d extends Punto {
    
  
    public Puntoen3d(){
        this.z = 0;
    }
    public void leerZ(){
        Scanner a = new Scanner(System.in);
        super.leer();
        System.out.println("Ingrese la Coordenada en Z= ");
        this.z= a.nextFloat();
        System.out.println("La Punto elegido es= "+x+","+y+","+z);
    }
        public void moverZ(){
        Scanner r = new Scanner(System.in);
        System.out.println("Ingrese el valor al cual desea que se desplaze Z= ");
        z1= r.nextDouble();
        zf=z+z1;
        System.out.println("La coordenada ahora (X,Y,Z) es ("+x+","+y+","+zf+")");        
    }
    
    public double distancia3d(){
        df= sqrt(pow(this.x, 2) + pow(this.y, 2) + pow(this.z, 2));
        System.out.println("La Distancia 3D es= "+df);
        return 0;
    }
    public void moverXYZ(){
    Scanner j = new Scanner(System.in);
        System.out.println("Ingrese la distancia a la cual dese que la coordenada se desplaze: \n -En X= ");
        this.d1=j.nextDouble();
        System.out.println(" -En Y= ");
        this.d2=j.nextDouble();
        System.out.println(" -En Z= ");
        this.d3=j.nextDouble();
        System.out.println("La Coordenada final es= ("+(x+d1)+","+(y+d2)+","+(z+d3)+")");
        
    }
    protected double z,z1,zf,t,d1,d2,d3,df;

    
}
