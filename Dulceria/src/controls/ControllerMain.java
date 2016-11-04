/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

/**
 *
 * @author Andro
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import models.*;

public class ControllerMain implements ActionListener{
    private final ViewMain viewMain;
    private final ViewProducto viewProducto;
    private final ViewCliente viewCliente;
    private final ViewProveedor viewProveedor;
    private final ModelMain modelMain;
    
    
    public ControllerMain(ViewMain viewMain, ViewProducto viewProducto,ViewCliente viewCliente,ViewProveedor viewProveedor, ModelMain modelMain){
        this.viewMain = viewMain;
        this.viewProducto = viewProducto;
        this.viewCliente = viewCliente;
        this.viewProveedor = viewProveedor;
        this.modelMain = modelMain;
        
        this.viewMain.jmi_clientes.addActionListener(this);
        this.viewMain.jmi_productos.addActionListener(this);
        this.viewMain.jmi_proveedores.addActionListener(this);
        this.viewMain.jmi_productos.addActionListener(this);
        
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewMain.jmi_productos)
            jmiContactsActionPerformed();
        if(e.getSource()==viewMain.jmi_clientes){
          jmiClientessActionPerformed(); 
        }
        else if(e.getSource()==viewMain.jmi_proveedores){
            jmiProveedoresActionPerformed();
        }
    }
    
    public void jmiContactsActionPerformed(){
        viewMain.setContentPane(viewProducto);
        viewMain.revalidate();
        viewMain.repaint();
    }
    public void jmiClientessActionPerformed(){
        viewMain.setContentPane(viewCliente);
        viewMain.revalidate();
        viewMain.repaint();
    }

    public void jmiProveedoresActionPerformed(){
        viewMain.setContentPane(viewProveedor);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    private void initView(){
        viewMain.setTitle("Dulceria Acme");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    } 
}
