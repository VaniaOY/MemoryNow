package memorynow;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Formulario extends JFrame implements ActionListener {

    JFrame _ventana;
    JTextField _Nombre, _Apellido, _Direccion, _Escuela, _Edad, _Telefono, _Pass, _Correo;
    JTextArea _txtChat;
    JButton _Enviar, _Regresar;
    JFileChooser _Foto;
    Container _cont;
    JLabel _palabras, Fondo;
    JRadioButton _SexoM, _SexoF;
    private String nombre, apellido, correo, escuela;
    private Integer telefono, edad;

    public Formulario() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    Connection con = null;
    PreparedStatement pstatement = null;
    Statement sS = null;
    ResultSet rR = null;
    PreparedStatement psta = null;
    Statement s = null;
    ResultSet r = null;
    int d2 = 0;

    public void ventanaRegistro() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        //FORMULARIO
        Font font = new Font("Arial", Font.BOLD, 35);
        _palabras = new JLabel();
        _palabras.setText("Formulario");
        _palabras.setFont(font);
        _palabras.setBounds(100, 15, 300, 40);
        Fondo.add(_palabras);

        //PARTES DEL FORMULARIO (TEXTO)
        Font font1 = new Font("Arial", Font.BOLD, 15);
        _palabras = new JLabel();
        _palabras.setText("Nombre: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 150, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Apellido: ");
        _palabras.setFont(font1);
        _palabras.setBounds(700, 150, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Direccion: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 250, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Escuela: ");
        _palabras.setFont(font1);
        _palabras.setBounds(700, 250, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Edad: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 350, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Telefono: ");
        _palabras.setFont(font1);
        _palabras.setBounds(700, 350, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Password: ");
        _palabras.setFont(font1);
        _palabras.setBounds(500, 550, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Correo: ");
        _palabras.setFont(font1);
        _palabras.setBounds(500, 450, 300, 20);
        Fondo.add(_palabras);

        //CAMPOS DE TEXTO DEL FORMULARIO
        _Nombre = new JTextField();
        _Nombre.setBounds(150, 150, 250, 30);
        _Nombre.setTransferHandler(null);
        _Nombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                if ((letra < 'a' || letra > 'z') && (letra < 'A') | letra > 'Z' ) {
                    evt.consume();
                }
            }
        });
        Fondo.add(_Nombre);

        _Apellido = new JTextField();
        _Apellido.setBounds(800, 150, 250, 30);
        _Apellido.setTransferHandler(null);
        _Apellido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                if ((letra < 'a' || letra > 'z') && (letra < 'A') | letra > 'Z') {
                    evt.consume();
                }
            }
        });
        Fondo.add(_Apellido);

        _Direccion = new JTextField();
        _Direccion.setBounds(150, 250, 250, 30);
        _Direccion.setTransferHandler(null);
        _Direccion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                if ((letra < 'a' || letra > 'z') && (letra < 'A') | letra > 'Z' && ((letra < '0') || (letra > '9')) && (letra == KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }
        });
        Fondo.add(_Direccion);

        _Escuela = new JTextField();
        _Escuela.setBounds(800, 250, 250, 30);
        Fondo.add(_Escuela);

        _Edad = new JTextField();
        _Edad.setBounds(150, 350, 250, 30);
        _Edad.setTransferHandler(null);
        _Edad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
                if (_Edad.getText().length() == 2) {
                    e.consume();
                }
            }
        });
        Fondo.add(_Edad);

        _Telefono = new JTextField();
        _Telefono.setBounds(800, 350, 250, 30);
        _Telefono.setTransferHandler(null);
        _Telefono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
                if (_Telefono.getText().length() == 10) {
                    e.consume();
                }
            }
        });
        Fondo.add(_Telefono);

        _Pass = new JTextField();
        _Pass.setBounds(650, 550, 250, 30);
        Fondo.add(_Pass);

        _Correo = new JTextField();
        _Correo.setBounds(650, 450, 250, 30);
        Fondo.add(_Correo);

        //Botones       
        _Enviar = new JButton("Enviar");
        _Enviar.setBounds(900, 650, 100, 20);
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

        if (e.getActionCommand().equals("Enviar")) {
            //if (memorynow.Validaciones.validaMail(_Correo.getText())) {
            if (true) {

                if (_Nombre.getText().length() != 0) {

                    if (_Apellido.getText().length() != 0) {

                        if (_Direccion.getText().length() != 0) {

                            if (_Escuela.getText().length() != 0) {

                                if (_Edad.getText().length() != 0) {

                                    if (_Telefono.getText().length() != 0) {

                                        if (_Correo.getText().length() != 0) {

                                            if (memorynow.Validaciones.validaMail(_Correo.getText())) {

                                                if (_Pass.getText().length() != 0) {

                                                    try {
                                                        cDatos sql = new cDatos();
                                                        ResultSet rs = null;
                                                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                                                        Statement comando = conexion.createStatement();
                                                        //sql.conectar();
                                                        //sql.insertar("insert into profesor(nombre, apellido, direccion, escuela, edad, correo, password) values ('" + _Nombre.getText() + "'," + _Apellido.getText() + "'," + _Direccion.getText() + "'," + _Escuela.getText() + "'," + _Edad.getText() + "'," + _Pass.getText() + "'," + _Correo.getText() + ")");
                                                        comando.executeUpdate("insert into profesor(nombre, apellido, direccion, escuela, edad, correo, password) values ('" + _Nombre.getText() + "','" + _Apellido.getText() + "','" + _Direccion.getText() + "','" + _Escuela.getText() + "'," + _Edad.getText() + ",'" + _Correo.getText() + "','" + _Pass.getText() + "')");
                                                        _Nombre.setText("");
                                                        _Apellido.setText("");
                                                        _Direccion.setText("");
                                                        _Escuela.setText("");
                                                        _Edad.setText("");
                                                        _Telefono.setText("");
                                                        _Correo.setText("");
                                                        _Pass.setText("");
                                                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                                                        conexion.close();
                                                        login log = new login();
                                                        _ventana.setVisible(false);

                                                    } catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Llena el campo Contraseña");
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Ingresa un correo electrónico válido");
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Llena el campo Correo Electronico");
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Llena el campo Telefono");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Llena el campo Edad");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Llena el campo Escuela");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Llena el campo Direccion");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Llena el campo Apellido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Llena el campo Nombre");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingresa un correo válido");
            }

        }

        if (e.getSource() == _Regresar) {
            login LOG = new login();
            _ventana.setVisible(false);

        }
    }
}
