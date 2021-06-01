
package juego.de.dados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Archivo implements Serializable {

    public File file;

    public Archivo() {
        file = new File("registros.txt");
    }

    public boolean guardarJugador(Jugador jugador) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            pw.println(jugador);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public Jugador iniciarSesion(String nombreUsuario, String password) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linea = "";
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
                String[] atributo = linea.split(",");
                if (atributo[2].equals(nombreUsuario) && atributo[3].equals(password)) {
                    Jugador jugador = new Jugador(atributo[0], atributo[1], atributo[2],
                            atributo[3], Integer.parseInt(atributo[4]));
                    return jugador;
                } else{
                if (linea.equals(null)) {
                    JOptionPane.showMessageDialog(null,
                            "Error",
                            "Nombre de Usuario / Contrasena Incorrecta",
                            JOptionPane.ERROR_MESSAGE);
                }
                }

            }

            
            
            
        } catch (IOException e) {
            System.out.println(e.getCause() + " " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
