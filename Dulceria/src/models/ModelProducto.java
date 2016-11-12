/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import sax.DBConnection;
import views.ViewProducto;

/**
 *
 * @author Andro
 */
public class ModelProducto {

    private String id_producto;
    private String nombre;
    private String precio;
    private String stock;
    private String descripcion;

    ViewProducto viewProductos = new ViewProducto();

    private String maquina = "locahost";
    private String usuario = "root";
    private String clave = "";
    private int puerto = 3306;
    private String servidor = "";
    private static Connection conexion = null;

    private DBConnection conection = new DBConnection(3306, "localhost", "dulceria", "root", "");

    public DefaultTableModel tableModel = new DefaultTableModel(new String[]{"id_producto", "nombre", "precio", "stock", "descripcion"}, 0);

    public void moveNext() {
        conection.moveNext();
        setValues();
    }

    public void movePrevious() {
        conection.movePrevious();
        setValues();
    }

    public void moveFirst() {
        conection.moveFirst();
        setValues();
    }

    public void moveLast() {
        conection.moveLast();
        setValues();
    }

    public void initValues() {
        conection.executeQuery("SELECT id_producto, nombre, precio, stock, descripcion FROM productos;");
        //conection.moveFirst();
        setValues();

    }

    public void setValues() {
        this.setId_producto(conection.getString("id_producto"));
        this.setNombre(conection.getString("nombre"));
        this.setPrecio(conection.getString("precio"));
        this.setStock(conection.getString("stock"));
        this.setDescripcion(conection.getString("descripcion"));

    }

    public void Tabla() {
        while (conection.moveNext()) {
            setValues();
            tableModel.addRow(new Object[]{id_producto, nombre, precio, stock, descripcion});
        }
    }

    /**
     * @return the id_producto
     */
    public String getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(String id_producto) {
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
