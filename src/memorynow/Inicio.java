package memorynow;

import Chat.Cliente;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    JFrame _ventana;
    Container _cont;
    JLabel _Maestro, _Alumno, _palabras, Fondo, _palabrasS, _palabrasS1, atras;

    public Inicio() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    public void verInicio() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/P.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);
        
        
        _Maestro = new JLabel();
        _Maestro.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/maestro.png")));
        _Maestro.setBounds(400, 200, 300, 300);
        //Metodo para que al hacer click a un JLabel, lo redireccione a otra pantalla
        _Maestro.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == _Maestro) {
                    login LOG = new login();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(_Maestro);

        _Alumno = new JLabel();
        _Alumno.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/ninosf.png")));
        _Alumno.setBounds(800, 200, 300, 300);
        //Metodo para que al hacer click a un JLabel, lo redireccione a otra pantalla
        _Alumno.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == _Alumno) {
                    menuActividades MAct = new menuActividades();
                    MAct.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(_Alumno);

        _ventana.setVisible(true);

    }

}
