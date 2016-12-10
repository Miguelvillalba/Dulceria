/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mains;
import views.*;
import models.*;
import controllers.*;
import controllers.ControllerMain;

/**
 *
 * @author Karla Terrazas
 */

public class Main {
    public static void main(String[] kstl) {
        
        ViewProveedor viewProveedor = new ViewProveedor();
        ModelProveedor modelProveedor = new ModelProveedor();
        ControllerProveedor controllerProveedor = new ControllerProveedor(viewProveedor, modelProveedor);

        ViewAbout viewAbout = new ViewAbout();
        ModelAbout modelAbout = new ModelAbout();
        ControllerAbout controllerAbout = new ControllerAbout(viewAbout, modelAbout);
        
        ViewUsuario viewUsuario = new ViewUsuario();
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario(viewUsuario, modelUsuario);
        
        ViewReportes viewReportes = new ViewReportes();
        ModelReportes modelReportes = new ModelReportes();
        ControllerReportes controllerReportes = new ControllerReportes(viewReportes, modelReportes);
        
        ViewMain viewMain = new ViewMain();
        ModelMain modelMain = new ModelMain();
        ControllerMain controllerMain = new ControllerMain(viewMain, viewProveedor, modelMain, viewAbout, viewUsuario, viewReportes);
    }
}