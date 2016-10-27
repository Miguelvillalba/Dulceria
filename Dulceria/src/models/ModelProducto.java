/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import sax.DBConnection;

/**
 *
 * @author Andro
 */
public class ModelProducto {

    private int id_producto;
    private String nombre;
    private String precio;
    private String stock;  
    private String descripcion;
   
   

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
        this.setId_producto(conection.getInteger("idContacto"));
        this.setNombre(conection.getString("nombre"));
        this.setPrecio(conection.getString("precio"));
        this.setStock(conection.getString("stock"));
        this.setDescripcion(conection.getString("descripcion"));
                
    }

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the nombre
     */
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void movePreviousActionPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public String getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

}
