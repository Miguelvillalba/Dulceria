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
    private DBConnection conection = new DBConnection(3306,"localhost", "dulceria", "root", "1234");

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
        showData();
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
        this.viewCliente.jtfNombre.setText("");
        this.viewCliente.jtfDireccion.setText("");
         this.viewCliente.jtfTelefono.setText("");
        this.viewCliente.jtfCiudad.setText("");
          
    }
     public void guadarRegistro() {        
       
             String nombre=this.viewCliente.jtfNombre.getText();
             Integer telefono=Integer.parseInt(viewCliente.jtfTelefono.getText());
             String Direccion=this.viewCliente.jtfDireccion.getText();
             String ciudad=this.viewCliente.jtfCiudad.getText();
            

            conection.executeUpdate("insert into clientes (nombre,Direccion,telefono,ciudad)"+" values "
                    + "('"+ nombre +"','"+Direccion+"','"+telefono+"','"+ciudad+"');"); 
            
           this.modelCliente.setValues();
           //showValues();
       

    }
     /*private void showData() {
        viewCliente.jTable.setModel(modelCliente.tableModel);
        modelCliente.Tabla();
    }*/
     public void editarValues(){
         Integer id_cliente=Integer.parseInt(viewCliente.jtfid.getText());
         String nombre=this.viewCliente.jtfNombre.getText();
             Integer telefono=Integer.parseInt(viewCliente.jtfTelefono.getText());
             String ciudad=this.viewCliente.jtfCiudad.getText();
             String direccion=this.viewCliente.jtfDireccion.getText();
             
             conection.executeUpdate ( "update clientes set nombre='"+nombre+"',telefono='"+telefono+"',Ciudad='"+ciudad+"',Direccion='"+direccion+"' where id='"+this.viewCliente.jtfid.getText()+"';");
       
       this.modelCliente.setValues();

     }
    
     
    
    private void showValues(){
        viewCliente.jtfid.setText(""+modelCliente.getId());
        viewCliente.jtfNombre.setText(modelCliente.getNombre());
        viewCliente.jtfDireccion.setText(modelCliente.getDireccion());
        viewCliente.jtfTelefono.setText(""+modelCliente.getTelefono());
        viewCliente.jtfCiudad.setText(""+modelCliente.getCiudad());
        
    }

    private void showData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   
}


