package Actividades;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import memorynow.Fotolario;

public class Lectora extends JFrame implements ActionListener {

    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo, foto, foto2, fotoo, fotoo2;
    JButton _Regresar;

    public Lectora() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    public void verMenuActividades() {
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/P.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        _palabras = new JLabel();
        _palabras.setText("Había un jardinero y él plantaba cebollas, ¿Qué plantaba el jardinero?");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 24));
        _palabras.setBounds(300, 50, 1000, 80);
        Fondo.add(_palabras);

        foto = new JLabel();
        foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/cebolla.png")));
        foto.setBounds(200, 300, 200, 200);
        foto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto) {
                    foto.setVisible(false);
                    fotoo = new JLabel();
                    fotoo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/cebollaa.png")));
                    fotoo.setBounds(200, 300, 200, 200);
                    Fondo.add(fotoo);
                    JOptionPane.showMessageDialog(null, "¡FELICIDADES! Lo hiciste muy bien.");
                    memorynow.menuActividades menu = new memorynow.menuActividades();
                    menu.verMenuActividades();
                }
            }
        });
        Fondo.add(foto);
        
        foto2 = new JLabel();
        foto2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/naranja.png")));
        foto2.setBounds(800, 300, 200, 200);
        foto2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto2) {
                    foto2.setVisible(false);
                    fotoo2 = new JLabel();
                    fotoo2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/naranjaa.png")));
                    fotoo2.setBounds(800, 300, 200, 200);
                    Fondo.add(fotoo2);
                    JOptionPane.showMessageDialog(null, "Intentalo de nuevo, tú puedes");
                }
            }
        });
        Fondo.add(foto2);
        
        _Regresar = new JButton();
        _Regresar.setBounds(600, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);
        
        _ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _Regresar) {

            memorynow.menuActividades menu = new memorynow.menuActividades();
            menu.verMenuActividades();
            _ventana.setVisible(false);

        }
    }

}