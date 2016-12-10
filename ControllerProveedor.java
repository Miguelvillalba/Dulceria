/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.Component;
import models.ModelProveedor;
import views.ViewProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sax.DBConnection;

/**
/**
 *
 * @author Karla Terrazas
 */

public class ControllerProveedor implements ActionListener {
    private final ModelProveedor modelproveedor;
    private final ViewProveedor viewproveedor;
    
    private final DBConnection conection = new DBConnection(3306,"localhost", "dulceria","root", "1234");
    private Component rootPane;
    
public ControllerProveedor(ViewProveedor viewProveedor, ModelProveedor modelProveedor){
    this.viewproveedor = viewProveedor;
    this.modelproveedor = modelProveedor;
    
    this.viewproveedor.jB_primero.addActionListener(this);
    this.viewproveedor.jB_anterior.addActionListener(this);
    this.viewproveedor.jB_siguiente.addActionListener(this);
    this.viewproveedor.jB_ultimo.addActionListener(this);
    this.viewproveedor.jB_nuevo.addActionListener(this);
    this.viewproveedor.jB_buscar.addActionListener(this);
    this.viewproveedor.jB_editar.addActionListener(this);
    this.viewproveedor.jB_eliminar.addActionListener(this);
    this.viewproveedor.jB_guardar.addActionListener(this);
    
    initview();
    
}

private void showData() {
        viewproveedor.jT_tabla.setModel(modelproveedor.tableModel);
        modelproveedor.Tabla();   
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
    } else if(e.getSource()== viewproveedor.jB_nuevo){
        jB_nuevo();
    } else if(e.getSource() == viewproveedor.jB_buscar){
        jB_buscar();
    } else if(e.getSource() == viewproveedor.jB_editar){
        jB_editar();
    } else if(e.getSource() == viewproveedor.jB_guardar){
        jB_guardar();
    } else if(e.getSource() == viewproveedor.jB_eliminar){
        jB_eliminar();
    }
}

public void jB_nuevo(){
    this.viewproveedor.jtf_id.setText("");
    this.viewproveedor.jtf_nombre.setText("");
    this.viewproveedor.jtf_rfc.setText("");
    this.viewproveedor.jtf_calle.setText("");
    this.viewproveedor.jtf_no.setText("");
    this.viewproveedor.jtf_colonia.setText("");
    this.viewproveedor.jtf_ciudad.setText("");
    this.viewproveedor.jtf_estado.setText("");
    this.viewproveedor.jtf_nombre_contacto.setText("");
    this.viewproveedor.jtf_telefono.setText("");
    this.viewproveedor.jtf_email.setText(""); 
}

public void jB_editar(){
    String nombre = this.viewproveedor.jtf_nombre.getText();
    String rfc = this.viewproveedor.jtf_rfc.getText();
    String calle = this.viewproveedor.jtf_calle.getText();
    String no = this.viewproveedor.jtf_no.getText();
    String colonia = this.viewproveedor.jtf_colonia.getText();
    String ciudad = this.viewproveedor.jtf_ciudad.getText();
    String estado = this.viewproveedor.jtf_estado.getText();
    String nombre_contacto = this.viewproveedor.jtf_nombre_contacto.getText();
    String telefono = this.viewproveedor.jtf_telefono.getText();
    String email = this.viewproveedor.jtf_email.getText(); 
    
    conection.executeUpdate ("update proveedores set nombre='"+nombre+"',rfc='"+rfc+"',calle='"+calle+"',no='"+no+"',colonia='"+colonia+"',ciudad='"+ciudad+"',estado='"+estado+"',nombre_contacto='"+nombre_contacto+"',telefono='"+telefono+"',email='"+email+"' where id_proveedor='"+this.viewproveedor.jtf_id.getText()+"';");
    this.modelproveedor.setValues();
    int resp=JOptionPane.showConfirmDialog(null,"¿Deseas editar este registro?");
      if (JOptionPane.OK_OPTION == resp){
    System.out.println("Selecciona opción Afirmativa");
    JOptionPane.showMessageDialog(null, "Editado");
    limpiar();
    initview();
    }
      else{
    System.out.println("No selecciona una opción afirmativa");
    limpiar();
    initview();
    }
}

public void jB_guardar(){
    String id_proveedor = this.viewproveedor.jtf_id.getText();
    String nombre = this.viewproveedor.jtf_nombre.getText();
    String rfc = this.viewproveedor.jtf_rfc.getText();
    String calle = this.viewproveedor.jtf_calle.getText();
    String no = this.viewproveedor.jtf_no.getText();
    String colonia = this.viewproveedor.jtf_colonia.getText();
    String ciudad = this.viewproveedor.jtf_ciudad.getText();
    String estado = this.viewproveedor.jtf_estado.getText();
    String nombre_contacto = this.viewproveedor.jtf_nombre_contacto.getText();
    String telefono = this.viewproveedor.jtf_telefono.getText();
    String email = this.viewproveedor.jtf_email.getText(); 
    
    conection.executeUpdate("insert into proveedores (id_proveedor, nombre, rfc, calle, no, colonia, ciudad, estado, nombre_contacto, telefono, email)"+" values "
                    + "('"+id_proveedor+"','"+nombre+"','"+rfc+"','"+calle+"','"+no+"','"+colonia+"','"+ciudad+"','"+estado+"','"+nombre_contacto+"','"+telefono+"','"+email+"');"); 
    this.modelproveedor.setValues();
    int resp=JOptionPane.showConfirmDialog(null,"¿Deseas guardar este registro?");
      if (JOptionPane.OK_OPTION == resp){
    System.out.println("Selecciona opción Afirmativa");
    JOptionPane.showMessageDialog(null, "Guardado");
    limpiar();
    initview();
    }
      else{
    System.out.println("No selecciona una opción afirmativa");
    limpiar();
    initview();
    }
}

public void jB_buscar(){
    this.viewproveedor.jtf_id.setText("");
    this.viewproveedor.jtf_nombre.setText("");
    this.viewproveedor.jtf_rfc.setText("");
    this.viewproveedor.jtf_calle.setText("");
    this.viewproveedor.jtf_no.setText("");
    this.viewproveedor.jtf_colonia.setText("");
    this.viewproveedor.jtf_ciudad.setText("");
    this.viewproveedor.jtf_estado.setText("");
    this.viewproveedor.jtf_nombre_contacto.setText("");
    this.viewproveedor.jtf_telefono.setText("");
    this.viewproveedor.jtf_email.setText(""); 
}

public void jB_eliminar(){
    conection.executeUpdate("delete from proveedores where id_proveedor=" + this.viewproveedor.jtf_id.getText());
    int resp=JOptionPane.showConfirmDialog(null,"¿Deseas eliminar este registro?");
      if (JOptionPane.OK_OPTION == resp){
    System.out.println("Selecciona opción Afirmativa");
    JOptionPane.showMessageDialog(null, "Eliminado"); 
    limpiar();
    initview();
    }
      else{
    System.out.println("No selecciona una opción afirmativa");
    limpiar();
    initview();
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
    viewproveedor.jtf_id.setText(""+modelproveedor.getId_proveedor());
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
 showValues();
 showData();
 }   
  
 void limpiar() {
        while (viewproveedor.jT_tabla.getRowCount() != 0) {
            ((DefaultTableModel) viewproveedor.jT_tabla.getModel()).removeRow(0);
        }
 }
}
