/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import models.ModelProveedor;
import views.ViewProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Karla
 */
public class ControllerProveedor implements ActionListener {
    
    private ModelProveedor modelproveedor;
    private ViewProveedor viewproveedor;
    private Statement st;
    private ResultSet rs;
    
public ControllerProveedor(ViewProveedor viewProveedor, ModelProveedor modelProveedor){
    this.viewproveedor = viewProveedor;
    this.modelproveedor = modelProveedor;
    
    this.viewproveedor.jB_primero.addActionListener(this);
    this.viewproveedor.jB_anterior.addActionListener(this);
    this.viewproveedor.jB_siguiente.addActionListener(this);
    this.viewproveedor.jB_ultimo.addActionListener(this);
    
    initview();
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == viewproveedor.jB_primero){
        jB_primeroActionPerformed();
    } else if(e.getSource() == viewproveedor.jB_anterior){
        jB_anteriorActionPerformed();
    } else if(e.getSource() == viewproveedor.jB_siguiente){
        jB_siguienteActionPerformed();
    } else if(e.getSource() == viewproveedor.jB_ultimo){
        jB_ultimoActionPerformed();
    }
}

private void jB_primeroActionPerformed(){
    modelproveedor.moveFirst();
    showValues();
}

private void jB_anteriorActionPerformed(){
    modelproveedor.movePrevious();
    showValues();
}

private void jB_siguienteActionPerformed(){
    modelproveedor.moveNext();
    showValues();
}

private void jB_ultimoActionPerformed(){
    modelproveedor.moveLast();
    showValues();
}

private void showValues(){
    viewproveedor.jtf_id.setText("" + modelproveedor.getId_proveedor());
    viewproveedor.jtf_nombre.setText(modelproveedor.getNombre());
    viewproveedor.jtf_rfc.setText(modelproveedor.getRfc());
    viewproveedor.jtf_calle.setText(modelproveedor.getCalle());
    viewproveedor.jtf_no.setText(""+modelproveedor.getNo());
    viewproveedor.jtf_colonia.setText(modelproveedor.getColonia());
    viewproveedor.jtf_ciudad.setText(modelproveedor.getCiudad());
    viewproveedor.jtf_estado.setText(modelproveedor.getEstado());
    viewproveedor.jtf_nombre_contacto.setText(modelproveedor.getNombrecontacto());
    viewproveedor.jtf_telefono.setText(""+modelproveedor.getTelefono());
    viewproveedor.jtf_email.setText(modelproveedor.getEmail());
}
 private void initview() {
    modelproveedor.initValues();
 this.viewproveedor.setVisible(true);
 }
 
    
 private void jB_agregarMouseClicked(java.awt.event.MouseEvent evt) {
    String id;
    String nombre;
    String rfc;
    String calle;
    int no;
    String colonia;
    String ciudad;
    String estado;
    String nombre_contacto;
    int telefono;
    String email;

    try {
    id = this.viewproveedor.jtf_id.getText();
    nombre = this.viewproveedor.jtf_nombre.getText();
    rfc = this.viewproveedor.jtf_rfc.getText();
    calle = this.viewproveedor.jtf_calle.getText();
    //no = this.viewproveedor.jtf_no.getText();
    colonia = this.viewproveedor.jtf_colonia.getText();
    ciudad = this.viewproveedor.jtf_ciudad.getText();
    estado = this.viewproveedor.jtf_estado.getText();
    nombre_contacto = this.viewproveedor.jtf_nombre_contacto.getText();
    //telefono = this.viewproveedor.jtf_telefono.getText();
    email = this.viewproveedor.jtf_email.getText();

    //String sql = "insert into proveedor(id,nombre,rfc,calle,no,colonia,ciudad,estado,nombre_contacto,telefono,email) values ('" + id_proveedor + "','" + nombre + "','" + rfc + "','" + calle + "','" + no + "','" + colonia + '",'" + ciudad + "','" + estado + "','" + nombre_contacto + "','" + telefono + "','" + email + "');";
  //  System.out.println(sql);
    //st.executeUpdate(sql);

    } catch (Exception err) {
    JOptionPane.showMessageDialog(null, "Llena los campos correctamente" + err.getLocalizedMessage());
    }
 }
}
