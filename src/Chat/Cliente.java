package Chat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import memorynow.Inicio;

public class Cliente extends JFrame implements ActionListener {

    //Variables para crear la conexion
    Socket clientSocket;
    Socket socket;
    int puertoReceptor = 4000;
    int puertoEmisor = 5000;
    ServerSocket serverSocket;

    //Variables para hacer la interfaz
    JFrame _ventana;
    JTextField _txtMsj;
    JTextArea _txtChat;
    JButton _btnEnviar, _Regresar;
    JLabel Fondo;
    Container _cont;

    //Se hace la interfaz
    public Cliente() {
        _ventana = new JFrame("CHAT DEL CLIENTE EN JAVA SWING");
        _ventana.setSize(1400, 750);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _cont = _ventana.getContentPane();

        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

    }

    public void verVentanaChat0() throws IOException {

        _txtChat = new JTextArea();
        _txtChat.setBounds(400, 30, 600, 320);
        _txtChat.setEditable(false);
        Fondo.add(_txtChat);

        _txtMsj = new JTextField();
        _txtMsj.setBounds(400, 430, 600, 30);
        Fondo.add(_txtMsj);

        _btnEnviar = new JButton();
        _btnEnviar.setBounds(630, 530, 100, 20);
        _btnEnviar.setText("Enviar");
        _btnEnviar.addActionListener(this);
        Fondo.add(_btnEnviar);

        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

        _ventana.setVisible(true);
    }

    public void verVentanaChat() throws IOException {

        IniciarConexion();
        Escuchador();
        if (EnviarMensaje()) {
            _txtChat.setText("Conexion Establecida");
            _txtChat.setText("Escribe tu mensaje:");

        }

    }

    //Se inicia cconexion con el servidor
    public void IniciarConexion() {
        _txtChat.setText(_txtChat.getText() + "\n Manda un mensaje...");
        
    }

    public void Escuchador() throws IOException {
        serverSocket = new ServerSocket(puertoReceptor);
    }

    public boolean RecibirMensaje() throws IOException {
        boolean condicion = true;
        try {
            //Se aceptar la conexion del cliente al servidor
            clientSocket = serverSocket.accept();
            Scanner entrada = new Scanner(clientSocket.getInputStream());
            
            String msjRecibido = entrada.nextLine();
            if (msjRecibido.equals("CERRAR")) {
                clientSocket.close();
                condicion = true;
                Inicio ini = new Inicio();
                ini.verInicio();     
                _ventana.setVisible(false);
            } else {
                condicion = true;
            }
            
            this._txtChat.setText(_txtChat.getText() + "\n Servidor: \t" + msjRecibido);
            //this._txtChat.setForeground(Color.BLUE);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            condicion = true;
        }
        return condicion;
    }

    public PrintStream ConnecToSend() throws IOException {
        String ipServidor = "localhost";
        //Se abre el socket al puerto elegido
        socket = new Socket(ipServidor, puertoEmisor);
        PrintStream salidaServer = new PrintStream(socket.getOutputStream());
        return salidaServer;
    }

    public boolean EnviarMensaje() throws IOException {
        boolean condicion = true;
        try {
            //Se envia mensaje al servidor
            PrintStream salidaServer = ConnecToSend();
            String msj = "";
            msj = _txtMsj.getText();
            _txtMsj.setText("");
            salidaServer.println(msj);
            _txtChat.setText(_txtChat.getText() + "\n Yo: \t" + msj);
            condicion = !msj.equals("CERRAR");
            if (!condicion) {
                socket.close();
            }
        } catch (IOException ex) {
            System.err.println("Cliente> " + ex.getMessage());
        }
        RecibirMensaje();
        return condicion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == _Regresar) {

            memorynow.Inicio INICIO = new memorynow.Inicio();
            INICIO.verInicio();
            _ventana.setVisible(false);

        }
        
        try {
            EnviarMensaje();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

}
