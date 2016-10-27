/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import models.ModelProducto;
import views.ViewProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Andromeda
 */
public class controllerProducto implements ActionListener {

    private ModelProducto modelProducto;
    private ViewProducto viewProducto;
    private Statement st;
    private ResultSet rs;

    public controllerProducto(ViewProducto viewProducto, ModelProducto modelProducto) {
        this.viewProducto = viewProducto;
        this.modelProducto = modelProducto;

        this.viewProducto.jbtnFirst.addActionListener(this);
        this.viewProducto.jbtnPrevious.addActionListener(this);
        this.viewProducto.jbtnNext.addActionListener(this);
        this.viewProducto.jbtnLast.addActionListener(this);

        initView();
    }

    private void initView() {
        modelProducto.initValues();        
        this.viewProducto.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewProducto.jbtnFirst) {
            jbtnFirstActionPerformed();
        } else if (e.getSource() == viewProducto.jbtnPrevious) {
            jbtnPreviousActionPerformed();
        } else if (e.getSource() == viewProducto.jbtnNext) {
            jbtnNextActionPerformed();
        } else if (e.getSource() == viewProducto.jbtnLast) {
            jbtnLastActionPerformed();
        }
    }

    private void jbtnFirstActionPerformed() {
        modelProducto.moveFirst();
        showValues();
    }

    private void jbtnPreviousActionPerformed() {
        modelProducto.movePreviousActionPerformed();
        showValues();
    }

    private void jbtnNextActionPerformed() {
        modelProducto.moveNext();
        showValues();
    }

    private void jbtnLastActionPerformed() {
        modelProducto.moveLast();
        showValues();
    }

    private void showValues() {
        viewProducto.jtf_id_producto.setText("" + modelProducto.getId_producto());
        viewProducto.jtf_nombre.setText(modelProducto.getNombre());
        viewProducto.jtf_precio.setText(modelProducto.getPrecio());
        viewProducto.jtf_existencias.setText(modelProducto.getStock());
        viewProducto.jtf_descripcion.setText(modelProducto.getDescripcion());
    }

    private void jbtn_agregarMouseClicked(java.awt.event.MouseEvent evt) {
        String id_producto;
        String nombre;
        String precio;
        String stock;
        String descripcion;

        try {
            id_producto = this.viewProducto.jtf_id_producto.getText();
            nombre = this.viewProducto.jtf_nombre.getText();
            precio = this.viewProducto.jtf_precio.getText();
            stock = this.viewProducto.jtf_existencias.getText();
            descripcion = this.viewProducto.jtf_descripcion.getText();

            String sql = "insert into producto(id_producto,nombre,precio,stock,descripcion) values ('" + id_producto + "','" + nombre + "','" + precio + "','" + stock + "','" + descripcion + "');";
            System.out.println(sql);
            st.executeUpdate(sql);

        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos" + err.getLocalizedMessage());
        }
    }

}
