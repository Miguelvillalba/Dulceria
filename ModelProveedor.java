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
import views.ViewProveedor;
import sax.DBConnection;
/**
/**
 *
 * @author Karla Terrazas
 */

public class ModelProveedor {
    private static String id_proveedor;
    private String nombre="";
    private String rfc="";
    private String calle="";
    private String no="";
    private String colonia="";
    private String ciudad="";
    private String estado="";
    private String nombre_contacto="";
    private String telefono="";
    private String email="";

    private String maquina = "locahost";
    private String usuario = "root";
    private String clave = "1234";
    private int puerto = 3306;
    private String servidor="";
    private static Connection conexion = null;
    private DBConnection conection = new DBConnection(3306,"localhost", "dulceria", "root", "1234");
    
    ViewProveedor viewProveedor = new ViewProveedor();
    
    public DefaultTableModel tableModel = new DefaultTableModel(new String [] {"id_proveedor","nombre","rfc","calle","no","colonia","ciudad","estado","nombre_contacto","telefono","email"},0);
     
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
        conection.executeQuery("SELECT  id_proveedor, nombre, rfc, calle, no, colonia, ciudad, estado, nombre_contacto, telefono, email FROM proveedores;");
        conection.moveNext();
        setValues();
    }
    
    public void setValues(){
        this.setId_proveedor(conection.getString("id_proveedor"));
        this.setNombre(conection.getString("nombre"));
        this.setRfc(conection.getString("rfc"));
        this.setCalle(conection.getString("calle"));
        this.setNo(conection.getString("no"));
        this.setColonia(conection.getString("colonia"));
        this.setEstado(conection.getString("estado"));
        this.setCiudad(conection.getString("ciudad"));
        this.setNombrecontacto(conection.getString("nombre_contacto"));
        this.setTelefono(conection.getString("telefono"));
        this.setEmail(conection.getString("email"));       
    }
    
    public void Tabla(){
        while (conection.moveNext()){
            setValues();
                tableModel.addRow(new Object []{getId_proveedor(),nombre,rfc,calle, no,colonia,estado,ciudad,nombre_contacto,telefono,email});
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombrecontacto() {
        return nombre_contacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombre_contacto = nombrecontacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public String getNo() {
        return no;
    }

    public String getTelefono() {
        return telefono;
    }
}
