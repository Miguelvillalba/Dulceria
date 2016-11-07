/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import views.ViewCliente;
/**
 *
 * @author Andro
 */
public class ModelCliente {
    private String maquina = "locahost";
    private String usuario = "root";
    private String clave = "1234";
    private int puerto = 3306;
    private String servidor="";
    private static Connection conexion = null;
    private DBConnection conection = new DBConnection(3306,"localhost", "dulceria", "root", "1234");
   
    
    
   private String id_cliente=""; 
   private String nombre= "";
   private String apellido= "";
   private String fecha_nac= "";
   private String direccion= "";
   private String telefono = "";
   private String email= "";
   
ViewCliente viewClientes = new ViewCliente();
    /**
     * @return the nombre
     */
   
   public DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_cliente","nombre","apellido","fecha_nac","direccion","telefono","email"}, 0);
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
        conection.executeQuery("SELECT id_cliente, nombre, apellido, fecha_nac,direccion,telefono,email FROM clientes;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.id_cliente=conection.getString("id_cliente");
        this.nombre=conection.getString("nombre");
        this.apellido=conection.getString("apellido");
        this.fecha_nac=conection.getString("fecha_nac");
        this.direccion=conection.getString("direccion");
        this.telefono=conection.getString("telefono");
        this.email=conection.getString("email");
                
    }
    
    public void Tabla(){
        while (conection.moveNext()){
            setValues();
                tableModel.addRow(new Object []{id_cliente, nombre, apellido, fecha_nac,direccion,telefono,email});
        }
    }
    public void eliminarValues()
    {
        conection.executeUpdate ("delete from clientes where id_cliente="+id_cliente);

           this.viewClientes.jtfNombre.setText("");
             this.viewClientes.jtfApellido.setText(""); 
             this.viewClientes.jtfFecha_nacimiento.getText();
             this.viewClientes.jtfDireccion.setText("");
             this.viewClientes.jtfTelefono.setText("");
             this.viewClientes.jtfEmail.setText("");
          
             initValues();
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getId_cliente() {
        return id_cliente;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    

    /**
     * @param telefono the telefono to set
     */
    

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.direccion = Direccion;
    }
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nac() {
        return fecha_nac;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
  
    
   
}
