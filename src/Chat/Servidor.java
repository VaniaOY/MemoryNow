package Chat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import memorynow.Inicio;


public class Servidor extends JFrame implements ActionListener {

    //Variables para crear la conexion
    Socket clientSocket;
    Socket socket;
    int puertoReceptor = 5000;
    int puertoEmisor = 4000;
    ServerSocket serverSocket;
    
     //Variables para hacer la interfaz
    JFrame _ventana;
    JTextField _txtMsj;
    JTextArea _txtChat;
    JButton _btnEnviar, _Regresar;
    JLabel Fondo;
    Container _cont;

    //Se hace la interfaz
    public Servidor() {
        _ventana = new JFrame("CHAT DEL SERVIDOR EN JAVA SWING");
        _ventana.setSize(1400, 750);
        _ventana.setLayout(null);
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _ventana.getLocation(null);
        _cont = _ventana.getContentPane();
        
        Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(getClass().getResource("/IMAGENES/PP.jpg")));
        Fondo.setBounds(0, 5, 1400, 700);
        _cont.add(Fondo);

    }
public void verVentanaChat0() throws IOException {

        _txtChat = new JTextArea();
        _txtChat.setBounds(10, 10, 470, 300);
        _txtChat.disable();
        Fondo.add(_txtChat);

        _txtMsj = new JTextField();
        _txtMsj.setBounds(10, 400, 470, 30);
        _txtMsj.disable();
        Fondo.add(_txtMsj);

        _btnEnviar = new JButton();
        _btnEnviar.setBounds(45, 500, 100, 20);
        _btnEnviar.setText("Enviar");
        _btnEnviar.addActionListener(this);
        _btnEnviar.disable();
        Fondo.add(_btnEnviar);
        
        _Regresar = new JButton();
        _Regresar.setBounds(1100, 650, 100, 20);
        _Regresar.setText("Regresar");
        _Regresar.addActionListener(this);
        Fondo.add(_Regresar);

        _ventana.setVisible(true);
        //verVentanaChat();
}
    public void verVentanaChat() throws IOException {

        IniciarConexion();
        Escuchador();
        if (RecibirMensaje()) {
            _txtChat.setText("Conexion Establecida");
            _txtChat.setText(_txtChat.getText() + "\n Escribe tu mensaje");
            _txtMsj.enable();
            _btnEnviar.enable();
        }
    }

    
    //Se inicia cconexion con el servidor
    public void IniciarConexion() {
        _txtChat.setText(_txtChat.getText() + "\n Esperando conexion...");
        _txtMsj.disable();
        _btnEnviar.disable();
    }

    public void Escuchador() throws IOException {
        serverSocket = new ServerSocket(puertoReceptor);
        //el socketServer acpeta el socket cliente

    }

    public boolean RecibirMensaje() throws IOException {
        boolean condicion = true;
        clientSocket = serverSocket.accept();
        try {
            Scanner entrada = new Scanner(clientSocket.getInputStream());
            String msjRecibido = entrada.nextLine();
            if (msjRecibido.equals("CERRAR")) {
                clientSocket.close();
                condicion = false;
            } else {
                condicion = true;
            }
            this._txtChat.setText(_txtChat.getText() + "\n Cliente: \t" + msjRecibido);        
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            condicion = true;
        }
        return condicion;
    }

    public PrintStream ConnecToSend() throws IOException {
        String ipServidor = "127.0.0.1";
        //Se abre el socket al puerto elegido
        socket = new Socket(ipServidor, puertoEmisor);  
        PrintStream salidaServer = new PrintStream(socket.getOutputStream());
        return salidaServer;
    }

    public boolean EnviarMensaje() throws IOException {
        _txtMsj.enable();
        _btnEnviar.enable();
        boolean condicion = true;
        try {
            PrintStream salidaServer = ConnecToSend();
            String msj = "";
            msj = _txtMsj.getText();
            _txtMsj.setText("");
            salidaServer.println(msj);
            condicion = !msj.equals("CERRAR");
            _txtChat.setText(_txtChat.getText() + "\n Yo: \t" + msj);
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
        try {
            EnviarMensaje();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        if (e.getSource() == _Regresar) {

            Inicio INICIO = new Inicio();
            INICIO.verInicio();
            _ventana.setVisible(false);

        }
    }

}
