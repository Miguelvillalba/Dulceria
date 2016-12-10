/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Karla Terrazas
 */

public class ModelAbout {
    private String clientes = "Miguel Angel Villaba Lechuga";
    private String productos = "Atahualtpa Flores Rocha";
    private String proveedores = "Karla Samantha Terrazas López";

    /**
     * @return the clientes
     */
    public String getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the productos
     */
    public String getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(String productos) {
        this.productos = productos;
    }

    /**
     * @return the proveedores
     */
    public String getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }
    
}