/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.interfaces;

import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Administracion
 * @param <T>
 */
public interface IGestion<T>{

public void crear();
public void actualizar();
public void quitar();
public void buscarPorId(int id);
public void buscarTodos();
public void llenaCombo(JComboBox<T> combo);
public void llenaTabla(JTable tabla,String param);

    
}
