/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.ViewCliente;
/**
 *
 * @author Andro
 */
public class ModelCliente {
    private DBConnection conection = new DBConnection(3306, "localhost", "dulceria", "root", "");
   
    
    
   private Integer id=0; 
   private String nombre= "";
   private String apellido= "";
   private String Direccion= "";
   private String telefono = "";
   private String ciudad= "";
   private String fecha_nacimiento= "";
   private String email= "";
ViewCliente viewClientes = new ViewCliente();
    /**
     * @return the nombre
     */
   
   public DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_cliente","nombre","apellido","Direccion","fecha_naciemiento","Telefono","email"}, 0);
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
        conection.executeQuery("SELECT id_producto, nombre, precio, stock, descripcion FROM producto;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.setId(conection.getInteger("id"));
        this.setNombre(conection.getString("nombre"));
        this.setTelefono(conection.getString("Telefono"));
        this.setDireccion(conection.getString("Direccion"));
        this.setCiudad(conection.getString("ciudad"));
                
    }
    
    public void Tabla(){
        while (conection.moveNext()){
            SetValues();
                tableModel.addRow(new Object []{id,nombre,telefono,Direccion,ciudad});
        }
    }
    public String getNombre() {
        return nombre;
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
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    private void SetValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the apellido
     */
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
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
}
