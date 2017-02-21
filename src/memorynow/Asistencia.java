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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Asistencia extends JFrame implements ActionListener {

    JFrame _ventana;
    JButton _Regresar, _Aceptar;
    Container _cont;
    JLabel _palabras, Fondo, Nu, Foto;
    JTextArea Alumno;
    JTextField _txtMsj;
    JScrollPane scroll;
    JComboBox[] combo;
    JCheckBox[] Nuc;
    JLabel[] NuC;
    int _cuantos = 0;

    public Asistencia() {
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

        

        ResultSet Cuantos = null;
        Statement s = null;
        Statement stament = null;
        ResultSet rs;

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
            String query = "SELECT count(nombre) FROM alumno;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            if (Cuantos.next()) {
                System.out.println(Cuantos.getObject("count(nombre)"));
                _cuantos = Integer.parseInt((Cuantos.getObject("count(nombre)").toString()));
                String query2 = "select nombre, apellido, alumno_id FROM alumno;";
                stament = conexion.createStatement();
                rs = stament.executeQuery(query2);
                if (rs.next()) {

                    
                    NuC = new JLabel[_cuantos];
                    
                    Nuc = new JCheckBox[_cuantos];
                    for (int i = 0; i < _cuantos; i++) {

                        Nuc[i] = new JCheckBox();
                        Nuc[i].setBounds(120, (155 + (i * 40)), 17, 17);
                        Fondo.add(Nuc[i]);

                        NuC[i] = new JLabel();
                        NuC[i].setText(rs.getObject("nombre").toString() + " " + rs.getObject("apellido").toString());
                        System.out.println(Integer.toString(rs.getInt("alumno_id")));
                        NuC[i].setName(Integer.toString(rs.getInt("alumno_id")));
                        NuC[i].setFont(new java.awt.Font("Century Gothic", 0, 20));
                        NuC[i].setBounds(150, (150 + (i * 40)), 200, 40);
                        Fondo.add(NuC[i]);
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
            String query = "SELECT count(nombreG) FROM grupo;";
            s = conexion.createStatement();
            Cuantos = s.executeQuery(query);
            if (Cuantos.next()) {
                System.out.println(Cuantos.getObject("count(nombreG)"));
                _cuantos = Integer.parseInt((Cuantos.getObject("count(nombreG)").toString()));
                String query2 = "SELECT nombreG FROM grupo;";
                stament = conexion.createStatement();
                rs = stament.executeQuery(query2);
                if (rs.next()) {

                    
                    combo = new JComboBox[_cuantos];
                    for (int i = 0; i < _cuantos; i++) {

                        combo[i] = new JComboBox();
                        combo[i].setBounds(720, 155, 200, 20); 
                        combo[i].addItem(rs.getObject("nombreG"));
                        Fondo.add(combo[i]);

                         
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

            Statement stament = null;
            

            try {

                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/memorynow", "root", "n0m3l0");
                for (int j = 0; j<_cuantos; j++) {
                    if(Nuc[j].isSelected()){
                        String query2 = "INSERT INTO alumnopru (asistencia, alumasis) VALUES (NOW(), '"+NuC[j].getName()+"');";
                        stament = conexion.createStatement();
                        stament.executeUpdate(query2); 
                                                
                    }
                    
                }                
                JOptionPane.showMessageDialog(null, "Registro de asistencia exitoso");
                Profesor pro = new Profesor();
                pro.verProfesor();
                _ventana.setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}

