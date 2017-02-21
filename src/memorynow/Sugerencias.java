
package memorynow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Sugerencias extends JFrame implements ActionListener{
    
    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo;
    JTextField _Sug;
    JButton _Enviar, _Regresar;
    
    public Sugerencias(){
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
    }
    
    public void verSugerencias(){
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);
        
        _palabras = new JLabel();
        _palabras.setText("Sugerencias");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 20));
        _palabras.setBounds(10, 20, 200, 40);
        Fondo.add(_palabras);
        
        _palabras = new JLabel();
        _palabras.setText("Si tienes alguna sugerencia para la mejora de éste programa, apórtanos tu opinión aquí: ");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 14));
        _palabras.setBounds(300, 100, 800, 40);
        Fondo.add(_palabras);
        
        _Sug = new JTextField();
        _Sug.setBounds(300, 150, 650, 300);
        Fondo.add(_Sug);
        
        _Enviar = new JButton();
        _Enviar.setBounds(850, 500, 100, 20);
        _Enviar.setText("Enviar");
        _Enviar.addActionListener(this);
        Fondo.add(_Enviar);
        
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

           Inicio INI = new Inicio();
           INI.verInicio();
           _ventana.setVisible(false);

        }
    }
    
}
