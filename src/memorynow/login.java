package memorynow;

import Chat.Cliente;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {

    JFrame _ventana;
    JTextField _txtMsj;
    JPasswordField _Contraseña;
    JButton _btnEnviar, _Regresar, _Registra;
    Container _cont;
    JPanel _ventanita;
    JLabel _palabras, _palabrasS, _fondo, _palabrasO, Fondo;

    /*Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/fondoaje.jpg"));*/
    public login() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setLayout(null);
        _ventana.setResizable(false);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        Font font = new Font("Arial", Font.BOLD, 35);
        Font font1 = new Font("Arial", Font.BOLD, 25);
        _palabras = new JLabel();
        _palabras.setText("Iniciar Sesión");
        _palabras.setFont(font);
        _palabras.setBounds(500, 50, 300, 40);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Correo Electronico: ");
        _palabras.setFont(font1);
        _palabras.setBounds(500, 100, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Contraseña: ");
        _palabras.setFont(font1);
        _palabras.setBounds(500, 350, 300, 20);
        Fondo.add(_palabras);

        _txtMsj = new JTextField();
        _txtMsj.setBounds(500, 200, 250, 30);
        Fondo.add(_txtMsj);

        _Contraseña = new JPasswordField();
        _Contraseña.setBounds(500, 400, 250, 30);
        Fondo.add(_Contraseña);

        _btnEnviar = new JButton();
        _btnEnviar.setBounds(500, 500, 100, 20);
        _btnEnviar.setText("Enviar");
        _btnEnviar.addActionListener(this);
        Fondo.add(_btnEnviar);

        _Registra = new JButton();
        _Registra.setBounds(230, 625, 150, 20);
        _Registra.setText("REGISTRATE");
        _Registra.addActionListener(this);

        Fondo.add(_Registra);

        Font font2 = new Font("Arial", Font.BOLD, 12);
        _palabras = new JLabel();
        _palabras.setText("¿No tienes una cuenta?");
        _palabras.setFont(font2);
        _palabras.setBounds(100, 600, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("¡Registrate aqui!");
        _palabras.setFont(font2);
        _palabras.setBounds(100, 625, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("¿Tienes alguna duda?");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 17));
        _palabras.setForeground(Color.BLACK);
        _palabras.setBounds(1000, 500, 200, 40);
        Fondo.add(_palabras);

        _palabrasS = new JLabel();
        _palabrasS.setText("¡Ponte en contácto con nosotros!");
        _palabrasS.setFont(new java.awt.Font("Century Gothic", 0, 17));
        _palabrasS.setForeground(Color.BLACK);
        _palabrasS.setBounds(950, 530, 350, 40);
        _palabrasS.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == _palabrasS) {

                    try {
                        Cliente Ser = new Cliente();
                        Ser.verVentanaChat0();
                        Ser.IniciarConexion();
                        Ser.Escuchador();
                    } catch (IOException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(_palabrasS);

        _palabrasO = new JLabel();
        _palabrasO.setText("¿Olvidaste tu contraseña?");
        _palabrasO.setFont(font2);
        _palabrasO.setBounds(500, 550, 300, 20);
        _palabrasO.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == _palabrasO) {
                    Restaurar res = new Restaurar();
                    res.verRestaurar();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(_palabrasO);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

        _ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _btnEnviar) {

            //valida el correo 
            if (memorynow.Validaciones.validaMail(_txtMsj.getText())) {
                //valida la contraseña
                if (_Contraseña.getText().length() != 0) {

                    /* String usuario = _txtMsj.getText();
                     String password = _Contraseña.getText();

                     if (usuario.equals("Bernardo87@hotmail.com") && password.equals("FidelV")) {

                     JOptionPane.showMessageDialog(null, "Bienvenido");
                     Opciones OP = new Opciones();
                     OP.verOpciones();
                     _ventana.setVisible(false);

                     } else {
                     _txtMsj.setText("");
                     _Contraseña.setText("");
                     JOptionPane.showMessageDialog(null, "Error, por favor ingresa nuevamente tus datos.");
                     }*/
                    Connection con = null;
                    PreparedStatement pstatement = null;
                    Statement sS = null;
                    ResultSet rR = null;
                    PreparedStatement psta = null;
                    Statement s = null;
                    ResultSet r = null;

                    String correo = _txtMsj.getText();
                    String contrasena = _Contraseña.getText();
                    Statement stament = null;
                    ResultSet rs;
                    cDatos sql = new cDatos();

                    try {
                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                        String query = "SELECT * FROM profesor WHERE correo='" + correo + "' AND password='" + contrasena + "'";
                        stament = conexion.createStatement();
                        rs = stament.executeQuery(query);
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Haz Iniciado Sesión: " + rs.getObject("nombre"));
                            Profesor p = new Profesor();
                            p.verProfesor();
                            _ventana.setVisible(false);

                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron registros");
                            return;
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, escriba su contraseña.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un correo valido");
            }

        } else if (e.getSource()
                == _Regresar) {

            Inicio INICIO = new Inicio();
            INICIO.verInicio();
            _ventana.setVisible(false);

        } else if (e.getSource()
                == _Registra) {

            Formulario form = new Formulario();
            form.ventanaRegistro();
            _ventana.setVisible(false);

        }

    }
}
