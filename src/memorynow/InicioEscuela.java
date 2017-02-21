package memorynow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class InicioEscuela extends JFrame implements ActionListener {
    
    JFrame _ventana;
    Container _cont;
    JLabel _palabras, Fondo;
    JPasswordField _Contra;
    JButton _Enviar;
    
    public InicioEscuela() {
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
    }
    
    public void verInicioES() {
        
        _palabras = new JLabel();
        _palabras.setText("Ingresa la contraseña de la escuela: ");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 14));
        _palabras.setBounds(800, 300, 400, 40);
        _cont.add(_palabras);
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/Portada.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);
        
        _Contra = new JPasswordField();
        _Contra.setBounds(800, 350, 400, 30);
        Fondo.add(_Contra);
        
        _Enviar = new JButton();
        _Enviar.setBounds(1100, 400, 100, 20);
        _Enviar.setText("Enviar");
        _Enviar.addActionListener(this);
        Fondo.add(_Enviar);
        
        _ventana.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == _Enviar) {
            String contra = "CECYT-9";
            if (_Contra.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa la contraseña de tu escuela.");
            } else if (_Contra.getText().equals(contra)) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido!");
                Inicio i = new Inicio();
                i.verInicio();
                _ventana.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intentalo de nuevo.");
                _Contra.setText("");
            }
            
        }
        
    }
    
}
