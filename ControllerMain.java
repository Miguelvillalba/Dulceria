/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import models.*;
import java.sql.*;
import javax.swing.JOptionPane;
import sql.Conexion;


/**
 *
 * @author Karla Terrazas
 */


public class ControllerMain implements ActionListener{
    private final ViewMain viewMain;
    private final ViewProveedor viewProveedor;
    private final ModelMain modelMain;
    private final ViewAbout viewAbout;
    private final ViewUsuario viewUsuario;
    private final ViewReportes viewReportes;
    
    boolean InicioSesion = false;
    Conexion conexion = new Conexion();
    
    public ControllerMain(ViewMain viewMain, ViewProveedor viewProveedor, ModelMain modelMain, ViewAbout viewAbout, ViewUsuario viewUsuario, ViewReportes viewReportes){
        this.viewMain = viewMain;
        this.viewProveedor = viewProveedor;
        this.modelMain = modelMain;
        this.viewAbout = viewAbout;
        this.viewUsuario = viewUsuario;
        this.viewReportes = viewReportes;
        this.viewMain.jmi_proveedores.addActionListener(this);
        this.viewMain.jmi_acerca_de.addActionListener(this);
        this.viewMain.jmi_usuarios.addActionListener(this);
        this.viewMain.jmi_proveedoress.addActionListener(this);
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewMain.jmi_proveedores){
            jmiProveedoresActionPerformed();
        } else if (e.getSource() == viewMain.jmi_acerca_de) {
            jmiAcercadeActionPerformed();
        } else if (e.getSource() == viewMain.jmi_usuarios) {
            jmiUsuariosActionPerformed();
        } else if (e.getSource() == viewMain.jmi_proveedoress) {
            jmiProveedoressActionPerformed();
    }
    }

    public void jmiProveedoresActionPerformed(){
        viewMain.setContentPane(viewProveedor);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    public void jmiUsuariosActionPerformed(){
        viewMain.setContentPane(viewUsuario);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    public void jmiProveedoressActionPerformed() {
        viewMain.setContentPane(viewReportes);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    public void jmiAcercadeActionPerformed() {
        this.viewMain.setContentPane(viewAbout);
        this.viewMain.revalidate();
        this.viewMain.repaint();
    }
    
    private void initView(){
        viewMain.setTitle("Dulceria Acme");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    } 
    
    public void tryLogg(){
        if(0<=viewMain.jmi_usuarios.getText().length() && 0<=viewMain.jtf_password.getText().length()){
        try{
            String usuario = viewMain.jft_usuario.getText();
            String contrasena = new String(viewMain.jtf_password.getText());
            String sql = "SELECT * FROM usuarios WHERE nombre='"+usuario+"' AND contrasena='"+contrasena+"';";
 
            ResultSet resultadosConsulta = conexion.getExecuteQuery(sql);
 
            if( resultadosConsulta.first()){
                JOptionPane.showMessageDialog(viewMain, "Acceso Correcto");
                viewMain.jB_entrar.setText(usuario);
                InicioSesion = true;
            }else{
                JOptionPane.showMessageDialog(viewMain, "Error: Usuario o Contraseña Incorrecto");
            }
        }catch(SQLException | HeadlessException e){
            System.out.println("error: "+e);
        }
        }else{
            JOptionPane.showMessageDialog(viewMain, "No debes dejar campos vacios");        
        }
    }
}
