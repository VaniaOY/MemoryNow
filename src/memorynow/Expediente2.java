package memorynow;

import Chat.Cliente;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Expediente2 extends JFrame implements ActionListener {

    JFrame _ventana;
    JButton _Regresar, _btnEnviar, _elegir;
    Container _cont;
    JLabel _palabras, Fondo, Nu, Foto, Nu2, Nu3, Nu4, Nu5, Nu6, Nu7;
    JTextArea _txtChat, Info;
    JTextField _txtMsj;
    JRadioButton[] NuR;
    private ButtonGroup grupo;
     int _cuantos = 0;

    public Expediente2() {
        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();
    }

    public void verExpediente() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        _palabras = new JLabel();
        _palabras.setText("Expediente");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 28));
        _palabras.setBounds(600, 25, 200, 40);
        Fondo.add(_palabras);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);
        
        _elegir = new JButton();
        _elegir.setBounds(800, 650, 100, 20);
        _elegir.setText("Ver");
        _elegir.addActionListener(this);
        Fondo.add(_elegir);

        Nu = new JLabel();
        Nu.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu.setBounds(600, 25, 200, 40);
        Fondo.add(Nu);

        Nu2 = new JLabel();
        Nu2.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu2.setBounds(600, 75, 200, 40);
        Fondo.add(Nu2);

        Nu3 = new JLabel();
        Nu3.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu3.setBounds(600, 105, 200, 40);
        Fondo.add(Nu3);

        Nu4 = new JLabel();
        Nu4.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu4.setBounds(600, 125, 200, 40);
        Fondo.add(Nu4);

        Nu5 = new JLabel();
        Nu5.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu5.setBounds(600, 155, 200, 40);
        Fondo.add(Nu5);

        Nu6 = new JLabel();
        Nu6.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu6.setBounds(600, 185, 200, 40);
        Fondo.add(Nu6);

        Nu7 = new JLabel();
        Nu7.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu7.setBounds(600, 225, 200, 40);
        Fondo.add(Nu7);
        //----------------------------------INFORMACIÓN DEL ALUMNO-----------------------------------//
        Connection con = null;
        PreparedStatement pstatement = null;
        PreparedStatement psta = null;

        ResultSet Cuantos = null;
        Statement s = null;

        ResultSet Nombres = null;
        Statement sS = null;
       

        Statement stament = null;
        ResultSet rs = null;
        cDatos sql = new cDatos();

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            String query = "SELECT count(nombre) FROM alumno;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            if (Cuantos.next()) {
                _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                String query2 = "SELECT nombre, apellido FROM alumno;";
                stament = conexion.createStatement();
                rs = stament.executeQuery(query2);
                if (rs.next()) {

                    JLabel[] Nu = new JLabel[_cuantos];
                    JRadioButton[] NuR = new JRadioButton[_cuantos];
                    grupo = new ButtonGroup();
                    for (int i = 0; i < _cuantos; i++) {

                        JLabel info = Nu[i];
                        //System.out.println(rs.getObject("nombre"));
                        //pendiente= rs.getObject("nombre").toString()+" "+ rs.getObject("apellido").toString();

                        NuR[i] = new JRadioButton();
                        NuR[i].setBounds(80, (155 + (i * 30)), 16, 16);
                        grupo.add(NuR[i]);
                        Fondo.add(NuR[i]);

                        Nu[i] = new JLabel();
                        Nu[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
                        Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 15));
                        Nu[i].setBounds(100, (150 + (i * 30)), 200, 40);
                        

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

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            for (int j = 0; j < _cuantos; j++) {
                if (NuR[j].isSelected()) {
                    String query = "SELECT count(nombre) FROM alumno;";
                    s = conexion.createStatement();
                    Cuantos = s.executeQuery(query);
                    if (Cuantos.next()) {
                        _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                        String query2 = "SELECT alumno.nombre, alumno.apellido, alumno.edad, alumno.nacimiento, alumno.padre_de_familia, alumno.sexo, grupo.nombreG FROM alumno INNER JOIN grupo ON alumno.grupo_id = grupo.grupo_id;";
                        stament = conexion.createStatement();
                        rs = stament.executeQuery(query2);
                        if (rs.next()) {
                            Nu2.setText(rs.getString("nombre"));
                        }
                    } else {
                        _palabras.setText("No se encontraron registros");
                        
                    }

                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //----------------------------------INFORMACIÓN DEL ALUMNO-----------------------------------//
        //----------------------------------COMENTARIOS-----------------------------------//
        _txtChat = new JTextArea();
        _txtChat.setBounds(350, 150, 470, 300);
        _txtChat.setEnabled(false);
        Fondo.add(_txtChat);

        _txtMsj = new JTextField();
        _txtMsj.setBounds(350, 500, 470, 30);
        Fondo.add(_txtMsj);

        _btnEnviar = new JButton();
        _btnEnviar.setBounds(600, 550, 100, 20);
        _btnEnviar.setText("Enviar");
        _btnEnviar.addActionListener(this);
        Fondo.add(_btnEnviar);

        //----------------------------------COMENTARIOS-----------------------------------//
        Foto = new JLabel();
        Foto.setIcon(new ImageIcon(getClass().getResource("/img1/niño2.jpg")));
        Foto.setBounds(1000, 60, 200, 400);
        Fondo.add(Foto);

        _ventana.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == _Regresar) {
            Profesor pro = new Profesor();
            pro.verProfesor();
            _ventana.setVisible(false);

        } else if (e.getSource() == _btnEnviar) {
            String msj = "";
            msj = _txtMsj.getText();
            _txtMsj.setText("");
            _txtMsj.setCaretColor(Color.BLACK);
            _txtChat.setText(_txtChat.getText() + "\n" + msj);
        }else if(e.getSource() == _elegir){
            for (int j = 0; j < _cuantos; j++) {
                if (NuR[j].isSelected()) {
                    
                }
            }
        }
            

    }

}

/*info.addMouseListener(new MouseAdapter() {

 public void mouseClicked(MouseEvent e) {
                                
 if (e.getSource() == info) {
 Connection conex = null;
 Statement sql = null;
 ResultSet resultado = null;
 ResultSet Cuan = null;
 Statement si = null;
 ResultSet rs;
 try {
 conex = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
 sql = conex.createStatement();
 resultado = sql.executeQuery("SELECT count(nombre) FROM alumno;");
 si = conexion.createStatement();
 Cuan = si.executeQuery(query);

 if (Cuan.next()) {
 int _cuantos1 = 0;
 _cuantos1 = Integer.parseInt((Cuan.getObject("count(nombre)").toString()));
 String query2 = "select nombre, apellido, edad FROM alumno;";
 sql = conexion.createStatement();
 rs = sql.executeQuery(query2);

 if (rs.next()) {
 JLabel[] Nu1 = new JLabel[_cuantos1];
                                                    
 for (int i = 0; i < _cuantos1; i++) {
                                                        
                                                        
                                                        
 Nu1[i] = new JLabel();
 Nu1[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
 Nu1[i].setFont(new java.awt.Font("Century Gothic", 0, 25));
 Nu1[i].setBounds(100, (150 + (i * 30)), 200, 40);
 Fondo.add(Nu1[i]);
 rs.next();
 }

 }
 //900 y 450
 }

 } catch (SQLException ex) {
 ex.printStackTrace();
 }

 }

 }
 }

 );*/
 /*Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            String query = "SELECT count(nombre) FROM alumno;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            for (int j = 0; j < _cuantos; j++) {
                if (NuR[j].isSelected()) {
                    String query2 = "SELECT nombre, apellido, edad, nacimiento, padre_de_familia, sexo FROM alumno WHERE nombre = '" + NuR[j].getName() + "';";
                    stament = conexion.createStatement();
                    stament.executeUpdate(query2);

                    JLabel[] Nu = new JLabel[_cuantos];
                    JLabel[] Nu2 = new JLabel[_cuantos];
                    JLabel[] Nu3 = new JLabel[_cuantos];
                    JLabel[] Nu4 = new JLabel[_cuantos];
                    JLabel[] Nu5 = new JLabel[_cuantos];
                    JLabel[] Nu6 = new JLabel[_cuantos];
                    JLabel[] Nu7 = new JLabel[_cuantos];

                    for (int i = 0; i < _cuantos; i++) {

                        Nu[i] = new JLabel();
                        Nu2[i] = new JLabel();
                        Nu3[i] = new JLabel();
                        Nu4[i] = new JLabel();
                        Nu5[i] = new JLabel();
                        Nu6[i] = new JLabel();
                        Nu7[i] = new JLabel();
                        
         Nu[i].setText(rs.getObject("nombre").toString());
         Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu[i].setBounds(10, (180 + (i * 30)), 500, 40);
         
         Nu2[i].setText(rs.getObject("apellido").toString());
         Nu2[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu2[i].setBounds(250, (180 + (i * 30)), 500, 40);
         
         Nu3[i].setText(rs.getObject("edad").toString());
         Nu3[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu3[i].setBounds(450, (180 + (i * 30)), 500, 40);
         
         Nu4[i].setText(rs.getObject("nacimiento").toString());
         Nu4[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu4[i].setBounds(600, (180 + (i * 30)), 500, 40);
         
         Nu5[i].setText(rs.getObject("padre_de_familia").toString());
         Nu5[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu5[i].setBounds(800, (180 + (i * 30)), 500, 40);
         
         Nu6[i].setText(rs.getObject("sexo").toString());
         Nu6[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu6[i].setBounds(1000, (180 + (i * 30)), 500, 40);
         
         Nu7[i].setText(rs.getObject("nombreG").toString());
         Nu7[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu7[i].setBounds(1200, (180 + (i * 30)), 500, 40);
         
         Fondo.add(Nu[i]);
         Fondo.add(Nu2[i]);
         Fondo.add(Nu3[i]);
         Fondo.add(Nu4[i]);
         Fondo.add(Nu5[i]);
         Fondo.add(Nu6[i]);
         Fondo.add(Nu7[i]);
         rs.next();

                    }

                }

            }*/
