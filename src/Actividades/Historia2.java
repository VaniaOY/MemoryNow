package Actividades;

import java.awt.Color;
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

public class Historia2 extends JFrame implements ActionListener {

    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo, foto, foto2, fotoo, fotoo2, foto3;
    JButton _Regresar;

    public Historia2() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    public void verHistoria2() {
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/P.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        _palabras = new JLabel();
        _palabras.setText("Pedro compró 5 manzanas, 2 sandias y 8 naranjas. ¿Cuántas manzanas compró Pedro?");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 24));
        _palabras.setBounds(100, 50, 1300, 80);
        Fondo.add(_palabras);

        foto = new JLabel();
        foto.setFont(new java.awt.Font("Century Gothic", 0, 40));
        foto.setText("5");
        foto.setBounds(350, 300, 200, 200);
        foto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto) {
                    foto.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "¡FELICIDADES! Lo hiciste muy bien.");
                    memorynow.menuActividades menu = new memorynow.menuActividades();
                    menu.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(foto);
        
        foto2 = new JLabel();
        foto2.setFont(new java.awt.Font("Century Gothic", 0, 40));
        foto2.setText("8");
        foto2.setBounds(650, 300, 200, 200);
        foto2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto2) {
                    foto2.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Intentalo de nuevo, tú puedes");
                }
            }
        });
        Fondo.add(foto2);
        
        foto3 = new JLabel();
        foto3.setFont(new java.awt.Font("Century Gothic", 0, 40));
        foto3.setText("2");
        foto3.setBounds(950, 300, 200, 200);
        foto3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto3) {
                    foto3.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Intentalo de nuevo, tú puedes");
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