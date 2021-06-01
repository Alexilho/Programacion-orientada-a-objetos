
package Interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Opciones extends JPanel implements ActionListener {

    private JButton iniciar;
    private JButton reiniciar;
    private JButton detener;

    public Opciones() {
        iniciar = new JButton("Inicio");
        iniciar.setToolTipText("Inicio del Reloj");

        reiniciar = new JButton("Reinicio");
        reiniciar.setToolTipText("Reinicio del Reloj");

        detener = new JButton("Pausar");
        detener.setToolTipText("Pausar el Reloj");


        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Elija la opcio a desear:")));
        setLayout(new FlowLayout());

        add(iniciar);
        add(detener);
        add(reiniciar);
 
        iniciar.addActionListener(this);
        iniciar.setActionCommand("Inicio");

        detener.addActionListener(this);
        detener.setActionCommand("Pausar");

        reiniciar.addActionListener(this);
        reiniciar.setActionCommand("Reinicio");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Inicio")) {
            Gui.Iniciar();
            iniciar.setEnabled(false);
        }
        if (e.getActionCommand().equals("Pausa")) {
            Gui.Detener();
            iniciar.setEnabled(true);
        }
        if (e.getActionCommand().equals("Reinicio")) {
            Gui.Reiniciar();
        }

    }
}
