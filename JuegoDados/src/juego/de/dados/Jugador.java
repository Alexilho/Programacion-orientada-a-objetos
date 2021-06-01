
package juego.de.dados;

import java.io.Serializable;

public class Jugador extends Registrate{
    
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    private int apuestaInicial;

    public Jugador() {
        this.nombre = null;
        this.apellido = null;
        this.nombreUsuario = null;
        this.password = null;
        this.apuestaInicial = ((int)apostador.getValue());
    }

    public Jugador(String nombre, String apellido, String nombreUsuario, 
                   String password, int apuesta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.apuestaInicial = apuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getApuestaInicial() {
        return apuestaInicial;
    }

    public void setApuestaInicial(int apuestaInicial) {
        this.apuestaInicial = apuestaInicial;
    }

    

    @Override
    public String toString() {
        return nombre + "," + apellido + "," + nombreUsuario + "," 
                + password + "," + apuestaInicial;
    }
    
    
    
    
    
}
