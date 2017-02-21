
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
import memorynow.Fotolario;

public class Sonidos extends JFrame implements ActionListener {

    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo, foto, foto2, foto3, fotoo, fotoo2, fotoo3;
    JButton _Regresar;

    public Sonidos() {

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
        _palabras.setText("SILABAS LOCAS");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 22));
        _palabras.setBounds(550, 50, 200, 40);
        Fondo.add(_palabras);
        
        _palabras = new JLabel();
        _palabras.setText("ELIJE LA PALABRA QUE TENGA LA SILABA 'PA'");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 18));
        _palabras.setBounds(400, 200, 500, 40);
        Fondo.add(_palabras);
               
        foto = new JLabel();
        foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pelota.png")));
        foto.setBounds(100, 400, 200, 200);
        foto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto) {
                    foto.setVisible(false);
                    fotoo = new JLabel();
                    fotoo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pelotaa.png")));
                    fotoo.setBounds(100, 400, 200, 200);
                    Fondo.add(fotoo);
                    JOptionPane.showMessageDialog(null, "Inténtalo de nuevo, tú puedes");
                }
            }
        });
        Fondo.add(foto);
        
        foto2 = new JLabel();
        foto2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pajaro.png")));
        foto2.setBounds(600, 400, 200, 200);
        foto2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto2) {
                    foto2.setVisible(false);
                    fotoo2 = new JLabel();
                    fotoo2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pajaroo.png")));
                    fotoo2.setBounds(600, 400, 200, 200);
                    Fondo.add(fotoo2);
                    JOptionPane.showMessageDialog(null, "¡FELICIDADES! Lo hiciste muy bien.");
                    memorynow.menuActividades menu = new memorynow.menuActividades();
                    menu.verMenuActividades();
                }
            }
        });
        Fondo.add(foto2);
        
        foto3 = new JLabel();
        foto3.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pinguino.png")));
        foto3.setBounds(1100, 400, 200, 200);
        foto3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto3) {
                    foto3.setVisible(false);
                    fotoo3 = new JLabel();
                    fotoo3.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pinguinoo.png")));
                    fotoo3.setBounds(1100, 400, 200, 200);
                    Fondo.add(fotoo3);
                    JOptionPane.showMessageDialog(null, "Inténtalo de nuevo, tú puedes");
                }
            }
        });
        Fondo.add(foto3);

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