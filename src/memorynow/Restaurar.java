
package memorynow;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Restaurar extends JFrame implements ActionListener{
    
    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo;
    JTextField _Sug;
    JButton _Enviar, _Regresar;
    
    public Restaurar(){
        
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
        
    }
    
    public void verRestaurar(){
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);
        
        _palabras = new JLabel();
        _palabras.setText("Restaurar contraseña");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 25));
        _palabras.setBounds(350, 20, 500, 40);
        _palabras.setForeground(Color.BLACK);
        Fondo.add(_palabras);
        
        _palabras = new JLabel();
        _palabras.setText("Para restaurar su contraseña le solicitamos que ingrese el Correo Electrónico con el que fue registrado.");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 12));
        _palabras.setForeground(Color.BLACK);
        _palabras.setBounds(350, 100, 700, 40);
        Fondo.add(_palabras);
        
        _palabras = new JLabel();
        _palabras.setText("Correo Electrónico: ");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 20));
        _palabras.setForeground(Color.BLACK);
        _palabras.setBounds(350, 170, 200, 40);
        Fondo.add(_palabras);
        
        _Sug = new JTextField();
        _Sug.setBounds(350, 210, 300, 30);
        Fondo.add(_Sug);
        
        _Enviar = new JButton();
        _Enviar.setBounds(350, 300, 100, 20);
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

            login LOG = new login();      
            _ventana.setVisible(false);

        }
    }
    
}
