/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorynow;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Validaciones {

    public Validaciones() {

    }

    public static boolean validaMail(String strMail) {
        boolean salida = false;
        String[] strTmp = strMail.split("@");

        if (strTmp.length == 2) {

            if (strTmp[1].indexOf(".") > -1) {
                //validar que despues del punto tenga datos
                if (strMail.lastIndexOf('.') != (strMail.length() - 1)) {
                    salida = true;
                }
            }
        }
        return salida;
    }

    
}
