/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
/**
 *
 * @author Andro
 */
public class ModelCliente {
   private Integer id=0; 
   private String nombre= "";  
   private String Direccion= "";
   private String telefono = "";
   private String ciudad= "";
    /**
     * @return the nombre
     */
   
   private DBConnection conection = new DBConnection(3306, "localhost", "dulceria", "root", "");
    
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
}
