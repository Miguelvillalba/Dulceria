/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import views.ViewUsuario;
import sax.DBConnection;

/**
 *
 * @author Karla Terrazas
 */
public class ModelUsuario {
   private String nombre = "";
   private String user = "";
   private String contraseña = "";
   private String nivel = "";
   private String estado = "";
   
   private String maquina = "locahost";
   private String usuario = "root";
   private String clave = "1234";
   private int puerto = 3306;
   private String servidor="";
   private static Connection conexion = null;
   private DBConnection conection = new DBConnection(3306,"localhost", "dulceria", "root", "1234");
    
    ViewUsuario viewUsuario = new ViewUsuario();
    
//    public DefaultTableModel tableModel = new DefaultTableModel(new String [] {"nombre","user","contraseña","nivel","estado"},0);
//     
    
    public void moveNext(){
        conection.moveNext();
        setValues();
    }
    
    public void movePrevious(){
        conection.movePrevious();
        setValues();
    }
    
    public void moveFirst(){
        conection.moveFirst();
        setValues();
    }
    
    public void moveLast(){
        conection.moveLast();
        setValues();
    }
    
    public void initValues(){
        conection.moveNext();
        setValues();
    }
    
    public void setValues(){
//        this.setNombre(conection.getString("nombre"));
//        this.setUser(conection.getString("user"));
//        this.setContraseña(conection.getString("contraseña"));
//        this.setNivel(conection.getString("nivel"));
//        this.setEstado(conection.getString("estado"));
    }
    
    public void Tabla(){
//        while (conection.moveNext()){
//            setValues();
//                tableModel.addRow(new Object []{getNombre(), getUser(), getContraseña(), getNivel(), getEstado()});
//        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
