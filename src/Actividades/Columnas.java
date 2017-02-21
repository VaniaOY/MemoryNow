package Actividades;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import memorynow.Fotolario;
import memorynow.Sugerencias;
import memorynow.login;

public class Columnas extends JFrame implements ActionListener {

    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo, foto, foto2, foto3, foto4, foto5, foto6, lineaA, fotoo, fotoo2, fotoo3, lineaB, lineaC;
    JButton _Regresar;

    public Columnas() {

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
        _palabras.setText("RELACIONA LAS IMAGENES");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 18));
        _palabras.setBounds(450, 15, 400, 40);
        Fondo.add(_palabras);

        foto = new JLabel();
        foto.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/cerdo.png")));
        foto.setBounds(200, 50, 200, 200);
        foto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto) {
                    foto.setVisible(false);
                    fotoo = new JLabel();
                    fotoo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/cerdito.png")));
                    fotoo.setBounds(200, 50, 200, 200);
                    Fondo.add(fotoo);
                    lineaA.setVisible(true);
                }
            }
        });
        Fondo.add(foto);

        foto2 = new JLabel();
        foto2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/moto.png")));
        foto2.setBounds(200, 250, 200, 200);        
        foto2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto2) {
                    foto2.setVisible(false);
                    fotoo2 = new JLabel();
                    fotoo2.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/motoo.png")));
                    fotoo2.setBounds(200, 250, 200, 200);
                    Fondo.add(fotoo2);
                    lineaB.setVisible(true);
                }
            }
        });
        Fondo.add(foto2);

        foto3 = new JLabel();
        foto3.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/pollo.png")));
        foto3.setBounds(200, 450, 200, 200);        
        foto3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto3){
                    foto3.setVisible(false);
                    fotoo3 = new JLabel();
                    fotoo3.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/polloo.png")));
                    fotoo3.setBounds(200, 450, 200, 200);
                    Fondo.add(fotoo3);
                    lineaC.setVisible(true);
                }
            }
        });
        Fondo.add(foto3);

        foto4 = new JLabel();
        foto4.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/granja.jpg")));
        foto4.setBounds(800, 50, 200, 200);
        Fondo.add(foto4);

        foto5 = new JLabel();
        foto5.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/huevo.png")));
        foto5.setBounds(800, 250, 200, 200);
        Fondo.add(foto5);

        foto6 = new JLabel();
        foto6.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/carre.jpg")));
        foto6.setBounds(800, 450, 200, 200);
        Fondo.add(foto6);

        lineaA = new JLabel();
        lineaA.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/LINA.png")));
        lineaA.setBounds(400, 50, 500, 200);
        Fondo.add(lineaA);
        lineaA.setVisible(false);
        
        lineaB = new JLabel();
        lineaB.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/LINBA.png")));
        lineaB.setBounds(400, 350, 500, 200);
        Fondo.add(lineaB);
        lineaB.setVisible(false);
        
        lineaC = new JLabel();
        lineaC.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/LINCE.png")));
        lineaC.setBounds(400, 370, 500, 200);
        Fondo.add(lineaC);
        lineaC.setVisible(false);

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
