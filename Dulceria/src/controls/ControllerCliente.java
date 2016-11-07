/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.ModelCliente;
import views.ViewCliente;
import sax.DBConnection;


public class ControllerCliente implements ActionListener{
    private final ModelCliente modelCliente;
    private final ViewCliente viewCliente;
    private final DBConnection conection = new DBConnection(3306,"localhost", "dulceria","root", "1234");

    public ControllerCliente(ViewCliente viewCliente, ModelCliente modelCliente){
        this.modelCliente=modelCliente;
        this.viewCliente=viewCliente;
        
        this.viewCliente.jbAnadir.addActionListener(this);
        this.viewCliente.jbanterior.addActionListener(this);
        this.viewCliente.jbeditar.addActionListener(this);
        this.viewCliente.jbeliminar.addActionListener(this);
        this.viewCliente.jbprimero.addActionListener(this);
        this.viewCliente.jbsiguiente.addActionListener(this);
        this.viewCliente.jbultimo.addActionListener(this);
        this.viewCliente.jbbuscar.addActionListener(this);
        this.viewCliente.jbguardar.addActionListener(this);
        
        initView();
//        showData();
    }
        private void initView(){
        modelCliente.initValues();
        showValues();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==viewCliente.jbprimero){
          jbtnFirstActionPerformed();
        }
        else if(ae.getSource()==viewCliente.jbanterior){
          jbtnPreviousActionPerformed();  
        }
        else if(ae.getSource()==viewCliente.jbsiguiente){
          jbtnNextActionPerformed();  
        }
        else if(ae.getSource()==viewCliente.jbultimo){
          jbtnLastActionPerformed();  
        }
        else if(ae.getSource()==viewCliente.jbAnadir){
         agregarRegistro(); 
        }
        else if(ae.getSource()==viewCliente.jbguardar){
         guadarRegistro();   
        }
        /*else if(ae.getSource()==viewCliente.jbeliminar){
            jbEliminar();
        }*/
        else if(ae.getSource()==viewCliente.jbeditar)
          editarValues();   
        }
   
    
    
    
    private void jbtnFirstActionPerformed(){
        modelCliente.moveFirst();
        showValues();
    }
    
    private void jbtnPreviousActionPerformed(){
         modelCliente.movePrevious();
        showValues();
    }
    
    private void jbtnNextActionPerformed(){
         modelCliente.moveNext();
        showValues();
    }
    
    private void jbtnLastActionPerformed(){
         modelCliente.moveLast();
        showValues();
    }
    
     public void agregarRegistro(){
        this.viewCliente.jtfid.setText("");
        this.viewCliente.jtfNombre.setText("");
        this.viewCliente.jtfApellido.setText("");
        this.viewCliente.jtfDireccion.setText("");
        this.viewCliente.jtfTelefono.setText("");
        this.viewCliente.jtfFecha_nacimiento.setText("");
        this.viewCliente.jtfEmail.setText("");
    }
     public void guadarRegistro() {        
             String id_cliente=this.viewCliente.jtfid.getText();
             String nombre=this.viewCliente.jtfNombre.getText();
             String apellido=this.viewCliente.jtfApellido.getText();
             String fecha_nac=this.viewCliente.jtfFecha_nacimiento.getText();
             String direccion=this.viewCliente.jtfDireccion.getText();
             String telefono=this.viewCliente.jtfTelefono.getText();
             String email=this.viewCliente.jtfEmail.getText();
             
             
             
            

            conection.executeUpdate("insert into clientes (id_cliente,nombre,apellido,direccion,fecha_nac,telefono,email)"+" values "
                    + "('"+ id_cliente +"','"+ nombre +"','"+apellido+"','"+fecha_nac+"','"+direccion+"','"+telefono+"','"+email+"');"); 
            
           this.modelCliente.setValues();
           showValues();
       

    }
     private void showData() {
        viewCliente.jTable.setModel(modelCliente.tableModel);
        modelCliente.Tabla();
    }
     public void editarValues(){
             String nombre=this.viewCliente.jtfNombre.getText();
             String apellido=this.viewCliente.jtfApellido.getText();
             String telefono=this.viewCliente.jtfTelefono.getText();
             String direccion=this.viewCliente.jtfDireccion.getText();
             String fecha_nac=this.viewCliente.jtfFecha_nacimiento.getText();
             String email=this.viewCliente.jtfEmail.getText();
             
             conection.executeUpdate ( "update clientes set nombre='"+nombre+"',apellido='"+apellido+"' ,telefono='"+telefono+"',fecha_nac='"+fecha_nac+"',Email='"+email+"',Direccion='"+direccion+"' where id='"+this.viewCliente.jtfid.getText()+"';");
       
       this.modelCliente.setValues();

     }
    
     
    
    private void showValues(){
        this.viewCliente.jtfid.setText(""+modelCliente.getId_cliente());
        this.viewCliente.jtfNombre.setText(modelCliente.getNombre());
        this.viewCliente.jtfApellido.setText(modelCliente.getApellido());
        this.viewCliente.jtfDireccion.setText(modelCliente.getDireccion());
        this.viewCliente.jtfTelefono.setText(""+modelCliente.getTelefono());
        this.viewCliente.jtfFecha_nacimiento.setText(""+modelCliente.getFecha_nac());
        this.viewCliente.jtfEmail.setText(""+modelCliente.getEmail());
        
    }

  

   
}


