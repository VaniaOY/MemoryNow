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
    ResultSet rs = null;
    cDatos sql = new cDatos();
    ResultSet Nombres = null;
    ResultSet Cuantos = null;
    Statement s = null;

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
        Nu.setBounds(1000, 350, 200, 40);
        Fondo.add(Nu);

        Nu2 = new JLabel();
        Nu2.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu2.setBounds(1000, 370, 200, 40);
        Fondo.add(Nu2);

        Nu3 = new JLabel();
        Nu3.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu3.setBounds(1000, 390, 200, 40);
        Fondo.add(Nu3);

        Nu4 = new JLabel();
        Nu4.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu4.setBounds(1000, 410, 200, 40);
        Fondo.add(Nu4);

        Nu5 = new JLabel();
        Nu5.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu5.setBounds(1000, 430, 200, 40);
        Fondo.add(Nu5);

        Nu6 = new JLabel();
        Nu6.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu6.setBounds(1000, 450, 200, 40);
        Fondo.add(Nu6);

        Nu7 = new JLabel();
        Nu7.setFont(new java.awt.Font("Century Gothic", 0, 15));
        Nu7.setBounds(1000, 470, 200, 40);
        Fondo.add(Nu7);
        //----------------------------------INFORMACIÓN DEL ALUMNO-----------------------------------//

//enlistar los radio botones con sus nombres
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            String query = "SELECT count(nombre) FROM alumno;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            if (Cuantos.next()) {
                _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                String query2 = "SELECT alumno_id, nombre, apellido FROM alumno;";
                Statement stament = conexion.createStatement();
                rs = stament.executeQuery(query2);
                if (rs.next()) {

                    JLabel[] Nus = new JLabel[_cuantos];
                    NuR = new JRadioButton[_cuantos];
                    grupo = new ButtonGroup();
                    for (int i = 0; i < _cuantos; i++) {

                        JLabel info = Nus[i];
                        //System.out.println(rs.getObject("nombre"));
                        //pendiente= rs.getObject("nombre").toString()+" "+ rs.getObject("apellido").toString();

                        NuR[i] = new JRadioButton();
                        NuR[i].setBounds(80, (155 + (i * 30)), 16, 16);
                        NuR[i].setActionCommand(rs.getObject("alumno_id").toString());
                        grupo.add(NuR[i]);
                        Fondo.add(NuR[i]);

                        Nus[i] = new JLabel();
                        Nus[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
                        Nus[i].setFont(new java.awt.Font("Century Gothic", 0, 15));
                        Nus[i].setBounds(100, (150 + (i * 30)), 200, 40);

                        Fondo.add(Nus[i]);
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

        /*      try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            for (int j = 0; j < _cuantos; j++) {
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
                        _palabras.setText("No se encontraron alumnos registros");
                        
                    }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         */
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
            String insertcom;
            int alumno=0;
            for (int j = 0; j < _cuantos; j++) {
                    if (NuR[j].isSelected()) {
                        alumno = Integer.parseInt(NuR[j].getActionCommand());
                    }
            }
            try{
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");                
                Statement stament = conexion.createStatement();
                insertcom = "insert INTO comentario(FechaC, alumco,comentario) values (NOW(), "+alumno+", '"+_txtMsj.getText()+"');";
                stament.executeUpdate(insertcom);
            } catch(SQLException ex){
                 Logger.getLogger(Expediente2.class.getName()).log(Level.SEVERE, null, ex);
            }
            _txtMsj.setText("");
            _txtMsj.setCaretColor(Color.BLACK);
            _txtChat.setText(_txtChat.getText() + "\n" + msj);
            
        } else if (e.getSource() == _elegir) {
            
            
            String query2;
            String query22;
            ResultSet Come;
            try {
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");                
                Statement stament = conexion.createStatement();
                Statement stament2 = conexion.createStatement();

                 for (int j = 0; j < _cuantos; j++) {
                    if (NuR[j].isSelected()) {
                        query2 = "SELECT alumno.nombre, alumno.apellido, alumno.edad, alumno.nacimiento, alumno.padre_de_familia, alumno.sexo, grupo.nombreG FROM alumno INNER JOIN grupo ON alumno.grupo_id = grupo.grupo_id where alumno_id='"+ NuR[j].getActionCommand() +"';";
                        Nombres = stament.executeQuery(query2);
                        if(Nombres.next()){
                            Nu.setText("Nombre: "+Nombres.getNString("nombre"));
                            Nu2.setText("Apellido: "+Nombres.getNString("apellido"));
                            Nu3.setText("Edad: "+Nombres.getNString("edad"));
                            Nu4.setText("Cumpleaños: "+Nombres.getObject("nacimiento"));
                            Nu5.setText("Tutor: "+Nombres.getNString("padre_de_familia"));
                            Nu6.setText("Sexo: "+Nombres.getNString("sexo"));
                            Nu7.setText("Grupo: "+Nombres.getNString("nombreG"));
                            _txtChat.setText("");
                        }
                        query22 = "SELECT * FROM comentario where alumco ='"+ NuR[j].getActionCommand() +"';";
                        Come = stament.executeQuery(query22);
                            if(Come.next()){
                                while(Come.next()){
                                    _txtChat.setText(_txtChat.getText()+"\n"+Come.getNString("comentario"));
                                    Come.next();
                                }
                            }
                            
                    }
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Expediente2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            

        }
    }

}
