package memorynow;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioAlum extends JFrame implements ActionListener {

    JFrame _ventana;
    JTextField _Nombre, _Apellido, _Padre, _Escuela, _Edad, _Nacimiento, _Gpo;
    JTextArea _txtChat;
    JButton _Enviar, _Regresar;
    JFileChooser _Foto;
    Container _cont;
    JLabel _palabras, Fondo;
    JComboBox _Sexo;
    Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/fondoaje.jpg"));

    public FormularioAlum() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

        //ImageIcon _fondo = new ImageIcon(getClass().getResource("IMAGENES/fondo.JPG"));
        //_ventana.add(_fondo);
    }

    public void ventanaRegistroAlum() {

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
        Font font10 = new Font("Arial", Font.BOLD, 10);
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
        _palabras.setText("Tutor: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 250, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Edad: ");
        _palabras.setFont(font1);
        _palabras.setBounds(50, 350, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Fecha de Nacimiento: ");
        _palabras.setFont(font1);
        _palabras.setBounds(625, 250, 300, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Ejemplo:   año/mes/dia    1999/05/21 ");
        _palabras.setFont(font10);
        _palabras.setBounds(800, 285, 200, 20);
        Fondo.add(_palabras);

        _palabras = new JLabel();
        _palabras.setText("Grupo ID: ");
        _palabras.setFont(font1);
        _palabras.setBounds(700, 350, 300, 20);
        Fondo.add(_palabras);

        //CAMPOS DE TEXTO DEL FORMULARIO
        _Nombre = new JTextField();
        _Nombre.setBounds(150, 150, 250, 30);
        _Nombre.setTransferHandler(null);
        _Nombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                if ((letra < 'a' || letra > 'z') && (letra < 'A') | letra > 'Z') {
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

        _Padre = new JTextField();
        _Padre.setBounds(150, 250, 250, 30);

        _Padre.setTransferHandler(null);
        _Padre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char letra = evt.getKeyChar();
                if ((letra < 'a' || letra > 'z') && (letra < 'A') | letra > 'Z') {
                    evt.consume();
                }
            }
        });
        Fondo.add(_Padre);

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

        _Nacimiento = new JTextField();
        _Nacimiento.setBounds(800, 250, 250, 30);
        Fondo.add(_Nacimiento);

        _Gpo = new JTextField();
        _Gpo.setBounds(800, 350, 250, 30);
        _Gpo.setTransferHandler(null);
        _Gpo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();
                }
                if (_Gpo.getText().length() == 1) {
                    e.consume();
                }
            }
        });
        Fondo.add(_Gpo);

        _Enviar = new JButton();
        _Enviar.setBounds(900, 650, 100, 20);
        _Enviar.setText("Enviar");
        _Enviar.addActionListener(this);
        Fondo.add(_Enviar);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

//Radio Botones para definir el sexo del niño
        _Sexo = new JComboBox();
        _Sexo.setBounds(450, 470, 300, 30);
        _Sexo.addItem("Seleccione el sexo");
        _Sexo.addItem("Masculino");
        _Sexo.addItem("Femenino");
        Fondo.add(_Sexo);

        _ventana.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Enviar")) {
            //if (memorynow.Validaciones.validaMail(_Correo.getText())) {
            if (true) {

                if (_Nombre.getText().length() != 0) {

                    if (_Apellido.getText().length() != 0) {

                        if (_Padre.getText().length() != 0) {

                            if (_Edad.getText().length() != 0) {

                                if (_Nacimiento.getText().length() != 0) {

                                    if (_Gpo.getText().length() != 0) {

                                        try {
                                            cDatos sql = new cDatos();
                                            ResultSet rs = null;
                                            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                                            Statement comando = conexion.createStatement();
                                        //sql.conectar();
                                            //sql.insertar("insert into profesor(nombre, apellido, direccion, escuela, edad, correo, password) values ('" + _Nombre.getText() + "'," + _Apellido.getText() + "'," + _Direccion.getText() + "'," + _Escuela.getText() + "'," + _Edad.getText() + "'," + _Pass.getText() + "'," + _Correo.getText() + ")");
                                            comando.executeUpdate("insert into alumno(nombre, apellido, edad, nacimiento, padre_de_familia, sexo, grupo_id) values ('" + _Nombre.getText() + "','" + _Apellido.getText() + "','" + _Edad.getText() + "','" + _Nacimiento.getText() + "','" + _Padre.getText() + "', '" + _Sexo.getSelectedItem() + "', '" + _Gpo.getText() + "')");
                                            _Nombre.setText("");
                                            _Apellido.setText("");
                                            _Edad.setText("");
                                            _Nacimiento.setText("");
                                            _Padre.setText("");
                                            _Gpo.setText("");
                                            JOptionPane.showMessageDialog(null, "Registro exitoso");
                                            conexion.close();
                                            Profesor pro = new Profesor();
                                            pro.verProfesor();
                                            _ventana.setVisible(false);

                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }

                                    }

                                }  else {
                                    JOptionPane.showMessageDialog(null, "Llena el campo Fecha de Nacimiento");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Llena el campo Edad");
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
            Profesor p = new Profesor();
            p.verProfesor();
            _ventana.setVisible(false);

        }
    }
}
