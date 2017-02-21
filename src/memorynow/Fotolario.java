
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


public class Fotolario extends JFrame implements ActionListener{
    
    JFrame _ventana;
    JButton _Regresar;
    Container _cont;
    JLabel _palabras, foto1, foto2, foto3, foto4, foto5, foto6, Fondo;
    
    public Fotolario(){
        
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
        
    }
    
    public void verFotoNiño(){
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);
        
        _palabras = new JLabel();
        _palabras.setText("Usuarios");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 28));
        _palabras.setBounds(600, 25, 200, 40);
        Fondo.add(_palabras);
        
        foto1 = new JLabel();
        foto1.setIcon(new ImageIcon(getClass().getResource("/img1/niño1.jpg")));
        foto1.setBounds(300, 100, 200, 200);
        foto1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto1) {
                    menuActividades MAct = new menuActividades();
                    MAct.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(foto1);
        
        foto2 = new JLabel();
        foto2.setIcon(new ImageIcon(getClass().getResource("/img1/niño2.jpg")));
        foto2.setBounds(700, 100, 200, 200);
        foto2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto2) {
                    menuActividades MAct = new menuActividades();
                    MAct.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(foto2);
        
        foto3 = new JLabel();
        foto3.setIcon(new ImageIcon(getClass().getResource("/img1/niño3.jpg")));
        foto3.setBounds(300, 400, 200, 200);
        foto3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto3) {
                    menuActividades MAct = new menuActividades();
                    MAct.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(foto3);
        
        foto4 = new JLabel();
        foto4.setIcon(new ImageIcon(getClass().getResource("/img1/niño4.jpg")));
        foto4.setBounds(700, 400, 200, 200);
        foto4.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == foto4) {
                    menuActividades MAct = new menuActividades();
                    MAct.verMenuActividades();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(foto4);
        
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

            Profesor p = new Profesor();
            p.verProfesor();
            _ventana.setVisible(false);

        }
    }
    
}
