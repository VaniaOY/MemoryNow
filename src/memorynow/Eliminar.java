package memorynow;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Eliminar extends JFrame implements ActionListener {

    JFrame _ventana;
    JTextField _Nombre;
    JButton _Enviar, _Regresar;
    Container _cont;
    JLabel _palabras, Fondo;

    public Eliminar() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    public void ventanaEliminar() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        Font font = new Font("Arial", Font.BOLD, 35);
        _palabras = new JLabel();
        _palabras.setText("Eliminar");
        _palabras.setFont(font);
        _palabras.setBounds(100, 15, 300, 40);
        Fondo.add(_palabras);

        Font font1 = new Font("Arial", Font.BOLD, 15);
        _palabras = new JLabel();
        _palabras.setText("Nombre: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 150, 300, 20);
        Fondo.add(_palabras);

        _Nombre = new JTextField();
        _Nombre.setBounds(150, 150, 250, 30);
        Fondo.add(_Nombre);

        _Enviar = new JButton();
        _Enviar.setBounds(150, 220, 100, 20);
        _Enviar.setText("Enviar");
        _Enviar.addActionListener(this);
        Fondo.add(_Enviar);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
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

        if (e.getSource() == _Enviar) {
            String usuario = _Nombre.getText();

            if (usuario.equals("Gpicazo03@hotmail.com")) {

                try {
                    BD.cDatos sql = new BD.cDatos();
                    ResultSet rs = null;
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                    Statement comando = conexion.createStatement();
                    
                    if (usuario.equals(_Nombre.getText())) {
                        rs = sql.borrar("DELETE * FROM profesor");
                        JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                    }
                } catch (Exception ev) {
                    JOptionPane.showMessageDialog(null, "ERROR");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido encontrar al Usuario");
            }
        }

    }

}
