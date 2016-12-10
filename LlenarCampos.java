/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;
import javax.swing.JOptionPane;

/**
 *
 * @author Karla Terrazas
 */
public class LlenarCampos {
        public void campoVacioMensaje(String texto){
        if(texto.length()==0){
            JOptionPane.showInputDialog("No deje espacios en blanco");
        }
    }
}
