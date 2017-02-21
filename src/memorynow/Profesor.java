package memorynow;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Profesor extends JFrame implements ActionListener {

    JLabel Consulta, Registra, Modifica, SalirC, Fondo, _palabras, Asistencia;
    JButton _Enviar, _Regresar;
    JTextField Grupo, Ciclo;
    JButton Iniciar, Salir, Registro;
    JFrame _ventana;
    Container _cont;

    public Profesor() {

        _ventana = new JFrame("MEMORY NOW");
        _ventana.setSize(1400, 750);
        _ventana.setResizable(false);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

    }

    public void verProfesor() {

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

        Consulta = new JLabel();
        Consulta.setText("Alumnos Registrados");
        Consulta.setFont(new java.awt.Font("Century Gothic", 0, 20));
        Consulta.setBounds(400, 20, 300, 40);
        Consulta.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Consulta) {
                    Expediente ex = new Expediente();
                    ex.verExpediente();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(Consulta);  
        
        Asistencia = new JLabel();
        Asistencia.setText("Asistencia");
        Asistencia.setFont(new java.awt.Font("Century Gothic", 0, 20));
        Asistencia.setBounds(700, 20, 300, 40);
        Asistencia.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Asistencia) {
                    Asistencia as = new Asistencia();
                    as.verAsistencia();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(Asistencia);

        Registra = new JLabel();
        Registra.setText("Registrar Alumnos");
        Registra.setFont(new java.awt.Font("Century Gothic", 0, 20));
        Registra.setBounds(80, 20, 300, 40);
        Registra.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == Registra) {
                    FormularioAlum FAlum = new FormularioAlum();
                    FAlum.ventanaRegistroAlum();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(Registra);

        SalirC = new JLabel();
        SalirC.setText("Salir");
        SalirC.setFont(new java.awt.Font("Century Gothic", 0, 20));
        SalirC.setBounds(1140, 20, 200, 40);
        SalirC.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == SalirC) {
                    login log = new login();
                    _ventana.setVisible(false);
                }
            }
        });
        Fondo.add(SalirC);

        _palabras = new JLabel();
        _palabras.setText("Bienvenido");
        _palabras.setFont(new java.awt.Font("Century Gothic", 0, 60));
        _palabras.setBounds(500, 200, 500, 80);
        Fondo.add(_palabras);
        
        
        
                    Connection con = null;
                    PreparedStatement pstatement = null;
                    PreparedStatement psta = null;
                    
                    ResultSet Cuantos = null;
                    Statement s = null;
                    
                    ResultSet Nombres = null;
                    Statement sS = null;
                    int  _cuantos = 0;

                    
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
                            String query2 =  "select nombre, apellido FROM profesor;";
                            stament = conexion.createStatement();
                            rs = stament.executeQuery(query2);                        
                            if (rs.next()) {
                                
                                JLabel[] Nu = new JLabel[_cuantos];
                                for (int i = 0; i < _cuantos; i++) {
                                    Nu[i] = new JLabel();
                                    Nu[i].setText(rs.getObject("nombre").toString()+" "+ rs.getObject("apellido").toString());
                                    Nu[i].setFont(new java.awt.Font("Century Gothic", 0, 60));
                                    Nu[i].setBounds(420, 350, 800, 80); 
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
        
        
        
        
        

        

        _Enviar = new JButton();
        _Enviar.setBounds(80, 630, 100, 20);
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
        if (e.getSource() == _Enviar) {

        }

        if (e.getSource() == _Regresar) {

            Inicio INICIO = new Inicio();
            INICIO.verInicio();
            _ventana.setVisible(false);

        }
    }

}
