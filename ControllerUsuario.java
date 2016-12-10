/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.Component;
import models.ModelUsuario;
import views.ViewUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sax.DBConnection;

/**
 *
 * @author Karla Terrazas
 */
public class ControllerUsuario implements ActionListener {
    private final ModelUsuario modelusuario;
    private final ViewUsuario viewusuario;
    
    private final DBConnection conection = new DBConnection(3306,"localhost", "dulceria","root", "1234");
    private Component rootPane;
    
public ControllerUsuario(ViewUsuario viewUsuario, ModelUsuario modelUsuario){
    this.viewusuario = viewUsuario;
    this.modelusuario = modelUsuario;
    
    this.viewusuario.jB_primero.addActionListener(this);
    this.viewusuario.jB_anterior.addActionListener(this);
    this.viewusuario.jB_siguiente.addActionListener(this);
    this.viewusuario.jB_ultimo.addActionListener(this);
    this.viewusuario.jB_nuevo.addActionListener(this);
    this.viewusuario.jB_editar.addActionListener(this);
    this.viewusuario.jB_eliminar.addActionListener(this);
    
    initview();
    
}

private void showData() {
//        viewusuario.jT_usuario.setModel(modelusuario.tableModel);
//        modelusuario.Tabla();   
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == viewusuario.jB_primero){
        jB_primeroActionPerformed();
    } else if(e.getSource() == viewusuario.jB_anterior){
        jB_anteriorActionPerformed();
    } else if(e.getSource() == viewusuario.jB_siguiente){
        jB_siguienteActionPerformed();
    } else if(e.getSource() == viewusuario.jB_ultimo){
        jB_ultimoActionPerformed();
    } else if(e.getSource()== viewusuario.jB_nuevo){
        jB_nuevo();
    } else if(e.getSource() == viewusuario.jB_editar){
        jB_editar();
    } else if(e.getSource() == viewusuario.jB_eliminar){
        jB_eliminar();
    } else if(e.getSource() == viewusuario.jB_guardar) {
        jB_guardar();
    }
}

public void jB_nuevo(){
//    this.viewusuario.jtf_nombre.setText("");
//    this.viewusuario.jtf_usuario.setText("");
//    this.viewusuario.jtf_password.setText("");
//    this.viewusuario.jcb_nivel.addItem("");
//    this.viewusuario.jcb_estado.addItem("");
}

public void jB_editar(){
//    String nombre = this.viewusuario.jtf_nombre.getText();
//    String user = this.viewusuario.jtf_usuario.getText();
//    String contraseña = this.viewusuario.jtf_password.getText();
//    String nivel = this.viewusuario.jcb_nivel.getActionCommand();
//    String estado = this.viewusuario.jcb_estado.getActionCommand();
}

public void jB_guardar(){
//    String nombre = this.viewusuario.jtf_nombre.getText();
//    String user = this.viewusuario.jtf_usuario.getText();
//    String contraseña = this.viewusuario.jtf_password.getText();
//    String nivel = this.viewusuario.jcb_nivel.getActionCommand();
//    String estado = this.viewusuario.jcb_estado.getActionCommand();
}

public void jB_eliminar(){      
    
}

private void jB_primeroActionPerformed(){
    modelusuario.moveFirst();
    showValues();
}

private void jB_anteriorActionPerformed(){
    modelusuario.movePrevious();
    showValues();
}

private void jB_siguienteActionPerformed(){
    modelusuario.moveNext();
    showValues();
}

private void jB_ultimoActionPerformed(){
    modelusuario.moveLast();
    showValues();
}

 private void initview() {
// modelusuario.initValues();
// this.viewusuario.setVisible(true);
// showValues();
// showData();
 }   
  
 void limpiar() {
//        while (viewusuario.jT_usuario.getRowCount() != 0) {
//            ((DefaultTableModel) viewusuario.jT_usuario.getModel()).removeRow(0);
//        }
 }

 private void showValues(){
//    viewusuario.jtf_nombre.setText(modelusuario.getNombre());
//    viewusuario.jtf_usuario.setText(modelusuario.getUser());
//    viewusuario.jtf_password.setText(modelusuario.getContraseña());
//    viewusuario.jcb_nivel.setActionCommand(modelusuario.getNivel());
//    viewusuario.jcb_estado.setActionCommand(modelusuario.getEstado());
 }
 
}
