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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Expediente extends JFrame implements ActionListener {

    JFrame _ventana;
    JButton _Regresar, _btnEnviar;
    Container _cont;
    JLabel _palabras, Fondo, nombre, apellido, edad, nacimiento, padre, sex, grupo;
    JTextArea _txtChat, Info;
    JTextField _txtMsj;
    JScrollPane _scroll = new JScrollPane(_cont);;

    public Expediente() {
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
        _cont.add(_scroll);
        
        _palabras = new JLabel();
        _palabras.setText("Alumnos Registrados");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 28));
        _palabras.setBounds(600, 25, 500, 40);
        Fondo.add(_palabras);
        
        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setFont(new java.awt.Font("Century Gothic", 0, 20));
        nombre.setBounds(100, 125, 500, 40);
        Fondo.add(nombre);
        
                
        apellido = new JLabel();
        apellido.setText("Apellido");
        apellido.setFont(new java.awt.Font("Century Gothic", 0, 20));
        apellido.setBounds(250, 125, 500, 40);
        Fondo.add(apellido);
        
        edad = new JLabel();
        edad.setText("Edad");
        edad.setFont(new java.awt.Font("Century Gothic", 0, 20));
        edad.setBounds(450, 125, 500, 40);
        Fondo.add(edad);
        
        nacimiento = new JLabel();
        nacimiento.setText("Nacimiento");
        nacimiento.setFont(new java.awt.Font("Century Gothic", 0, 20));
        nacimiento.setBounds(600, 125, 500, 40);
        Fondo.add(nacimiento);
        
        padre = new JLabel();
        padre.setText("Padre de Familia");
        padre.setFont(new java.awt.Font("Century Gothic", 0, 20));
        padre.setBounds(800, 125, 500, 40);
        Fondo.add(padre);
        
        sex = new JLabel();
        sex.setText("Sexo");
        sex.setFont(new java.awt.Font("Century Gothic", 0, 20));
        sex.setBounds(1000, 125, 500, 40);
        Fondo.add(sex);
        
        grupo = new JLabel();
        grupo.setText("Grupo");
        grupo.setFont(new java.awt.Font("Century Gothic", 0, 20));
        grupo.setBounds(1200, 125, 500, 40);
        Fondo.add(grupo);
        
        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

        //-----------------------------------TABLA-----------------------------------------
        //----------------------------------INFORMACIÓN DEL ALUMNO-----------------------------------//
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
         _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
         String query2 = "SELECT alumno.nombre, alumno.apellido, alumno.edad, alumno.nacimiento, alumno.padre_de_familia, alumno.sexo, grupo.nombreG FROM alumno INNER JOIN grupo ON alumno.grupo_id = grupo.grupo_id;";
         stament = conexion.createStatement();
         rs = stament.executeQuery(query2);
         if (rs.next()) {

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
         JLabel info = Nu[i];
         //System.out.println(rs.getObject("nombre"));
         //pendiente= rs.getObject("nombre").toString()+" "+ rs.getObject("apellido").toString();
         Nu[i].setText(rs.getObject("nombre").toString());
         Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
         Nu[i].setBounds(100, (180 + (i * 30)), 500, 40);
         
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
         
        /* info.addMouseListener(new MouseAdapter() {

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
         JOptionPane.showMessageDialog(null, "Bien");
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
         } else {
         _palabras.setText("No se encontraron registros");
         return;
         }
         } catch (SQLException ex) {
         ex.printStackTrace();
         }
        //----------------------------------INFORMACIÓN DEL ALUMNO-----------------------------------//
        //----------------------------------COMENTARIOS-----------------------------------//
       /* _txtChat = new JTextArea();
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
         Fondo.add(Foto);*/
        _ventana.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == _Regresar) {
            Profesor p = new Profesor();
            p.verProfesor();
            _ventana.setVisible(false);

        } /*else if (e.getSource() == _btnEnviar) {
         String msj = "";
         msj = _txtMsj.getText();
         _txtMsj.setText("");
         _txtMsj.setCaretColor(Color.BLACK);
         _txtChat.setText(_txtChat.getText() + "\n" + msj);
         }*/

    }

}
