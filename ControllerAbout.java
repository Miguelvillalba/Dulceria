/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewAbout;
import models.ModelAbout;
/**
 *
 * @author Karla Terrazas
 */
public class ControllerAbout implements ActionListener{
    
    private final ViewAbout viewAbout;
    private final ModelAbout modelAbout;
    public ControllerAbout(ViewAbout viewAbout, ModelAbout modelAbout){
        this.viewAbout = viewAbout;
        this.modelAbout = modelAbout;
        initView();
    }
    
    public void initView(){
        viewAbout.jtf_clientes.setText(modelAbout.getClientes());
        viewAbout.jtf_productos.setText(modelAbout.getProductos());
        viewAbout.jtf_proveedores.setText(modelAbout.getProveedores());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
