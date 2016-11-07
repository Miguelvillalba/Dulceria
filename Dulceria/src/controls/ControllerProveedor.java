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
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import sax.DBConnection;
/**
 *
 * @author Karla
 */
public class ControllerProveedor implements ActionListener {
    private final ModelProveedor modelproveedor;
    private final ViewProveedor viewproveedor;
    private final DBConnection conection = new DBConnection(3306,"localhost", "dulceria","root", "1234");
    
public ControllerProveedor(ViewProveedor viewProveedor, ModelProveedor modelProveedor){
    this.viewproveedor = viewProveedor;
    this.modelproveedor = modelProveedor;
    
    this.viewproveedor.jB_primero.addActionListener(this);
    this.viewproveedor.jB_anterior.addActionListener(this);
    this.viewproveedor.jB_siguiente.addActionListener(this);
    this.viewproveedor.jB_ultimo.addActionListener(this);
    this.viewproveedor.jB_agregar.addActionListener(this);
    this.viewproveedor.jB_buscar.addActionListener(this);
    this.viewproveedor.jB_editar.addActionListener(this);
    this.viewproveedor.jB_quitar.addActionListener(this);
    this.viewproveedor.jB_guardar.addActionListener(this);
    
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
    } else if(e.getSource()== viewproveedor.jB_agregar){
        jB_agregar();
    } else if(e.getSource() == viewproveedor.jB_buscar){
        jB_buscar();
    } else if(e.getSource() == viewproveedor.jB_editar){
        jB_editar();
    } else if(e.getSource() == viewproveedor.jB_guardar){
        jB_guardar();
    } else if(e.getSource() == viewproveedor.jB_quitar){
        jB_quitar();
    }
}

public void jB_agregar(){
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
    
    
       
       this.modelproveedor.setValues();

}

public void jB_guardar(){
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
    
    
            
    this.modelproveedor.setValues();
    showValues();
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

public void jB_quitar(){
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
 showValues();
 }
 
 private void showData() {
        viewproveedor.jT_tabla.setModel(modelproveedor.tableModel);
        modelproveedor.Tabla();
    }   
 
    }
