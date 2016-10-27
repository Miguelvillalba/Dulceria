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
import views.ViewMain;
import views.ViewProducto;
import models.ModelMain;

public class ControllerMain implements ActionListener{
    private final ViewMain viewMain;
    private final ViewProducto viewProducto;
    private final ModelMain modelMain;
    
    public ControllerMain(ViewMain viewMain, ViewProducto viewProducto, ModelMain modelMain){
        this.viewMain = viewMain;
        this.viewProducto = viewProducto;
        this.modelMain = modelMain;
        
        this.viewMain.jmi_productos.addActionListener(this);
        
        initView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewMain.jmi_productos)
            jmiContactsActionPerformed();
    }
    
    public void jmiContactsActionPerformed(){
        viewMain.setContentPane(viewProducto);
        viewMain.revalidate();
        viewMain.repaint();
    }
    
    private void initView(){
        viewMain.setTitle("Dulceria Acme");
        viewMain.setLocationRelativeTo(null);
        viewMain.setVisible(true);
    } 
}
