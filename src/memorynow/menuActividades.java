package memorynow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menuActividades extends JFrame implements ActionListener {

    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo, Rompe, Ajedrez, Historia, Historia2, Tangram, Sonidos, Sonidos2, Columnas, Columnas2;
    JButton _Regresar;

    public menuActividades() {

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
        _palabras.setText("ACTIVIDADES");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 40));
        _palabras.setBounds(550, 130, 600, 40);
        Fondo.add(_palabras);

       
        
        Columnas = new JLabel();
        Columnas.setText("Relaciona columnas 1");
        Columnas.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Columnas.setBounds(300, 250, 200, 40);
        Columnas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Columnas) {
                    Actividades.Columnas columna = new Actividades.Columnas();
                    columna.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });        
        Fondo.add(Columnas);
        
        Columnas2 = new JLabel();
        Columnas2.setText("Relaciona columnas 2");
        Columnas2.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Columnas2.setBounds(900, 250, 200, 40);
        Columnas2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Columnas2) {
                    Actividades.Columnas2 columna2 = new Actividades.Columnas2();
                    columna2.verColumnas();
                    _ventana.setVisible(false);
                }
            }
        });        
        Fondo.add(Columnas2);

        Sonidos = new JLabel();
        Sonidos.setText("Silabas");
        Sonidos.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Sonidos.setBounds(300, 375, 200, 40);
        Sonidos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Sonidos) {
                    Actividades.Sonidos son = new Actividades.Sonidos();
                    son.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });        
        Fondo.add(Sonidos);
        
        Sonidos2 = new JLabel();
        Sonidos2.setText("Silabas 2");
        Sonidos2.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Sonidos2.setBounds(900, 375, 200, 40);
        Sonidos2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Sonidos2) {
                    Actividades.Sonidos2 son2 = new Actividades.Sonidos2();
                    son2.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });        
        Fondo.add(Sonidos2);

        Historia = new JLabel();
        Historia.setText("Historia 1");
        Historia.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Historia.setBounds(300, 500, 200, 40);
        Historia.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Historia) {
                    Actividades.Lectora leer = new Actividades.Lectora();
                    leer.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(Historia);
        
        Historia2 = new JLabel();
        Historia2.setText("Historia 2");
        Historia2.setFont(new java.awt.Font("Century Gothic", 0, 18));
        Historia2.setBounds(900, 500, 200, 40);
        Historia2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Historia2) {
                    Actividades.Historia2 h = new Actividades.Historia2();
                    h.verHistoria2();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(Historia2);

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

            Inicio i = new Inicio();
            i.verInicio();
            _ventana.setVisible(false);

        }
    }

}
