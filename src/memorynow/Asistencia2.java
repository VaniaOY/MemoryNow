package memorynow;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Asistencia2 extends JFrame implements ActionListener {

    JFrame _ventana;
    JButton _Regresar, _Aceptar;
    Container _cont;
    JLabel _palabras, Fondo, Nu, Foto;
    JTextArea Alumno;
    JTextField _txtMsj;
    JScrollPane scroll;

    public Asistencia2() {
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
    }

    public void verAsistencia() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        _palabras = new JLabel();
        _palabras.setText("Asistencia");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 28));
        _palabras.setBounds(600, 25, 200, 40);
        Fondo.add(_palabras);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

        _Aceptar = new JButton();
        _Aceptar.setBounds(550, 650, 100, 20);
        _Aceptar.setText("Aceptar");
        _Aceptar.addActionListener(this);
        Fondo.add(_Aceptar);

        Connection con = null;
        PreparedStatement pstatement = null;
        PreparedStatement psta = null;

        ResultSet Cuantos = null;
        Statement s = null;

        ResultSet Nombres = null;
        Statement sS = null;
        int _cuantos = 0;

        Statement stament = null;
        ResultSet rs;
        cDatos sql = new cDatos();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            String query = "SELECT count(nombre) FROM alumno;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            if (Cuantos.next()) {
                System.out.println(Cuantos.getObject("count(nombre)"));
                _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                String query2 = "select nombre, apellido FROM alumno;";
                stament = conexion.createStatement();
                rs = stament.executeQuery(query2);
                if (rs.next()) {

                    JLabel[] Nu = new JLabel[_cuantos];
                    JButton[] Presente = new JButton[_cuantos];
                    JButton[] Ausente = new JButton[_cuantos];
                    for (int i = 0; i < _cuantos; i++) {

                        Presente[i] = new JButton();
                        Presente[i].setBounds(520, (155 + (i * 40)), 100, 20);
                        Presente[i].setText("Presente");
                        Presente[i].addActionListener(this);
                        Fondo.add(Presente[i]);
                        
                        Ausente[i] = new JButton();
                        Ausente[i].setBounds(720, (155 + (i * 40)), 100, 20);
                        Ausente[i].setText("Ausente");
                        Ausente[i].addActionListener(this);
                        Fondo.add(Ausente[i]);

                        Nu[i] = new JLabel();
                        Nu[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
                        Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
                        Nu[i].setBounds(150, (150 + (i * 40)), 200, 40);
                        Fondo.add(Nu[i]);
                        rs.next();

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        _ventana.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _Regresar) {
            Profesor pro = new Profesor();
            pro.verProfesor();
            _ventana.setVisible(false);
        } else if (e.getSource() == _Aceptar) {

            Connection con = null;

            PreparedStatement pstatement = null;
            PreparedStatement psta = null;

            Statement sS = null;
            Statement s = null;

            ResultSet Cuantos = null;
            ResultSet r = null;

            Statement stament = null;
            ResultSet rs;
            cDatos sql = new cDatos();
            int _cuantos = 0;

            try {

                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                String query = "SELECT count(nombre) FROM alumno;";
                s = conexion.createStatement();
                Cuantos = s.executeQuery(query);

                if (Cuantos.next()) {

                    _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                    String query2 = "INSERT INTO alumno(nombre, apellido);";
                    stament = conexion.createStatement();
                    rs = stament.executeQuery(query2);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");

                    if (rs.next()) {

                        JLabel[] Nu = new JLabel[_cuantos];
                        for (int i = 0; i < _cuantos; i++) {
                            Nu[i] = new JLabel();
                            JLabel info = Nu[i];
                            Nu[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
                            Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 15));
                            Nu[i].setBounds(100, (150 + (i * 30)), 200, 40);
                            JOptionPane.showMessageDialog(null, "Registro exitoso x2");
                        }
                    }

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
