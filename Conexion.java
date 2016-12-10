/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Karla Terrazas
 */
public class Conexion {
    private Connection con = null;
    public Connection conexion(){
        try{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dulceria","root","1234");                     

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
        return con;
    }
    public void executeUpdate(String sql) throws SQLException{
        con=conexion();
        System.out.println(sql);
        Statement stmt = con.prepareStatement(sql);
        stmt.executeUpdate(sql);
    }
    
    public void executeQuery(String sql) throws SQLException{
        con=conexion();
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        us.executeQuery();
    }
    
    public ResultSet getExecuteQuery(String sql) throws SQLException{
        con=conexion();
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        ResultSet executeQuery = us.executeQuery(sql);
        return executeQuery;
    }
    
    public ResultSet getExecuteUpdate(String sql) throws SQLException{
        con=conexion();
        System.out.println(sql);
        PreparedStatement us = con.prepareStatement(sql);
        ResultSet executeUpdate = us.executeQuery(sql);
        return executeUpdate;
    }
}
