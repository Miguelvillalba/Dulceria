/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mains;
import views.*;
import models.*;
import controls.*;

public class Main {
    public static void main(String[] args) {
        ViewCliente viewCliente = new ViewCliente();
        ModelCliente modelCliente = new ModelCliente();
        ControllerCliente controllerCliente = new ControllerCliente(viewCliente, modelCliente);
        
        ViewProveedor viewProveedor = new ViewProveedor();
        ModelProveedor modelProveedor = new ModelProveedor();
        ControllerProveedor controllerProveedor = new ControllerProveedor(viewProveedor, modelProveedor);
        
        ViewProducto viewProducto = new ViewProducto();
        ModelProducto modelProducto = new ModelProducto();
        controllerProducto controllerProducto = new controllerProducto(viewProducto, modelProducto);
        
        ViewMain viewMain = new ViewMain();
        ModelMain modelMain = new ModelMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, viewProducto, modelMain);
    }
}
