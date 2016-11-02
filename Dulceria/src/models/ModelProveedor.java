package models;
import sax.DBConnection;
/**
 *
 * @author Karla
 */
public class ModelProveedor {
    private int id_proveedor;
    private String nombre;
    private String rfc;
    private String calle;
    private int no;
    private String colonia;
    private String ciudad;
    private String estado;
    private String nombrecontacto;
    private int telefono;
    private String email;


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
        conection.executeQuery("SELECT id_proveedor, nombre, rfc, calle, no, colonia, ciudad, estado, nombrecontacto, telefono, email FROM proveedor;");
        conection.moveNext();
        setValues();
    }
    public void setValues(){
        this.setId_proveedor(conection.getInteger("id_proveedor"));
        this.setNombre(conection.getString("nombre"));
        this.setRFC(conection.getString("rfc"));
        this.setCalle(conection.getString("calle"));
        this.setNo(conection.getInteger("no"));
        this.setColonia(conection.getString("colonia"));
        this.setEstado(conection.getString("estado"));
        this.setNombre_contacto(conection.getString("Nombre_contacto"));
        this.setTelefono(conection.getInteger("Telefono"));
        this.setEmail(conection.getString("Email"));       
    }
    
    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setNombre_contacto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setRFC(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

