/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.interfaces;

import java.awt.event.ActionListener;

/**
 *
 * @author Administracion
 */
public interface IController extends ActionListener{
    
    public void activarVista();
    public void escucharComponentes();
    public void estadoInicialComponentes();
    public void fillCombos();
    public void fillTabla();
    
}