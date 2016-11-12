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
import javax.swing.table.DefaultTableModel;

import sax.DBConnection;

/**
 *
 * @author Andromeda
 */
public class controllerProducto implements ActionListener {

    private ModelProducto modelProducto;
    private ViewProducto viewProducto;

    private final DBConnection conection = new DBConnection(3306, "localhost", "dulceria", "root", "");

    public controllerProducto(ViewProducto viewProducto, ModelProducto modelProducto) {
        this.viewProducto = viewProducto;
        this.modelProducto = modelProducto;

        this.viewProducto.jbtnFirst.addActionListener(this);
        this.viewProducto.jbtnLast.addActionListener(this);
        this.viewProducto.jbtnNext.addActionListener(this);
        this.viewProducto.jbtnPrevious.addActionListener(this);
        this.viewProducto.jbtn_agregar.addActionListener(this);
        this.viewProducto.jbtn_editar.addActionListener(this);
        this.viewProducto.jbtn_eliminar.addActionListener(this);
        this.viewProducto.jB_buscar.addActionListener(this);
        this.viewProducto.jB_guardar.addActionListener(this);

        initView();
        
    }

    private void initView() {
        modelProducto.initValues();
        this.viewProducto.setVisible(true);
        showValues();
        showData();
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
        } else if (e.getSource() == viewProducto.jbtn_agregar) {
            agregarRegistro();
        } else if (e.getSource() == viewProducto.jB_guardar) {
            guardarRegistro();
        } else if (e.getSource() == viewProducto.jbtn_editar) {
            editarValues();
        } else if (e.getSource() == viewProducto.jbtn_eliminar) {
            eliminarRegistro();
        }
    }

    private void jbtnFirstActionPerformed() {
        modelProducto.moveFirst();
        showValues();
    }

    private void jbtnPreviousActionPerformed() {
        modelProducto.movePrevious();
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
        viewProducto.jtf_id_producto.setText(modelProducto.getId_producto());
        viewProducto.jtf_nombre.setText(modelProducto.getNombre());
        viewProducto.jtf_precio.setText(modelProducto.getPrecio());
        viewProducto.jtf_stock.setText(modelProducto.getStock());
        viewProducto.jtf_descripcion.setText(modelProducto.getDescripcion());
    }

    public void eliminarRegistro() {
        conection.executeUpdate("delete from productos where id_producto=" + this.viewProducto.jtf_id_producto.getText());
        JOptionPane.showMessageDialog(null, "Registro Borrado");

        limpiar();
        initView();

        

    }

    public void agregarRegistro() {
        this.viewProducto.jtf_id_producto.setText("");
        this.viewProducto.jtf_nombre.setText("");
        this.viewProducto.jtf_precio.setText("");
        this.viewProducto.jtf_descripcion.setText("");
        this.viewProducto.jtf_stock.setText("");

    }

    public void guardarRegistro() {
        String id_producto = this.viewProducto.jtf_id_producto.getText();
        String nombre = this.viewProducto.jtf_nombre.getText();
        String descripcion = this.viewProducto.jtf_descripcion.getText();
        String precio = this.viewProducto.jtf_precio.getText();
        String stock = this.viewProducto.jtf_stock.getText();

        conection.executeUpdate("insert into productos (nombre,precio,descripcion,stock)" + " values "
                + "('" + nombre + "','" + precio + "','" + descripcion + "','" + stock + "');");
        JOptionPane.showMessageDialog(null, "Registro Insertado");
        this.modelProducto.setValues();

        limpiar();
        initView();

       

    }

    private void showData() {
        viewProducto.jT_tabla.setModel(modelProducto.tableModel);
        modelProducto.Tabla();
    }

    public void editarValues() {

        String nombre = this.viewProducto.jtf_nombre.getText();
        String precio = this.viewProducto.jtf_precio.getText();
        String descripcion = this.viewProducto.jtf_descripcion.getText();
        String stock = this.viewProducto.jtf_stock.getText();

        conection.executeUpdate("update productos set nombre='" + nombre + "',precio='" + precio + "',descripcion= '" + descripcion + "',stock= '" + stock + "' where id_producto=" + this.viewProducto.jtf_id_producto.getText());
        JOptionPane.showMessageDialog(null, "Registro Editado");
        this.modelProducto.setValues();

        limpiar();
        initView();

        

    }

    void limpiar() {
        while (viewProducto.jT_tabla.getRowCount() != 0) {
            ((DefaultTableModel) viewProducto.jT_tabla.getModel()).removeRow(0);
        }
    }

}
