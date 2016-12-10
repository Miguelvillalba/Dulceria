/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.Component;
import models.ModelReportes;
import views.ViewReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sax.DBConnection;

/**
 *
 * @author Karla Terrazas
 */

public class ControllerReportes implements ActionListener {
    private final ModelReportes modelreportes;
    private final ViewReportes viewreportes;
    
    private final DBConnection conection = new DBConnection(3306,"localhost", "dulceria","root", "1234");
    private Component rootPane;
    
public ControllerReportes (ViewReportes viewReportes, ModelReportes modelReportes) {
    this.viewreportes = viewReportes;
    this.modelreportes = modelReportes;
    this.viewreportes.jB_todos.addActionListener(this);
    this.viewreportes.jB_id.addActionListener(this);
    this.viewreportes.jB_nombre.addActionListener(this);
    this.viewreportes.jB_rfc.addActionListener(this);
    this.viewreportes.jB_estado.addActionListener(this);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == viewreportes.jB_todos){
       } else if (e.getSource() == viewreportes.jB_id){
       } else if (e.getSource() == viewreportes.jB_nombre){
       } else if (e.getSource() == viewreportes.jB_rfc){
       } else if (e.getSource() == viewreportes.jB_estado){
        }
} 
}
