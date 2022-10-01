/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import app.ayudantes.Componentes;
import app.ayudantes.Render;
import static app.ayudantes.Tablas.ajustarAnchoColumnas;
import static app.ayudantes.Tablas.limpiarTabla;
import app.interfaces.IGestion;
import datos.dao.UsuarioDAOImpl;
import datos.dto.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administracion
 */
public class GestionUsuarios implements IGestion<Usuario> {

    private Usuario usuario;
    private final UsuarioDAOImpl usuarioDao;

    public GestionUsuarios() {
        this.usuario = new Usuario();
        this.usuarioDao = new UsuarioDAOImpl();
    }

    @Override
    public void crear() {
        try {
            boolean esCreado=usuarioDao.create(usuario);
            if(esCreado){
                JOptionPane.showMessageDialog(null,"Registro creado exitosamente ");
            }else{
                JOptionPane.showMessageDialog(null,"Error al crear el registro "+usuario.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar() {
        try {
            boolean esEditado=usuarioDao.update(usuario);
            if(esEditado){
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void quitar() {
        try {
            boolean esBorrado=usuarioDao.drop(usuario.getRut());
            if(esBorrado){
                JOptionPane.showMessageDialog(null,"Registro borrado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al borrar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarPorId(int id) {
        try {
            usuario=usuarioDao.findById(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarTodos() {
        
    }

    @Override
    public void llenaCombo(JComboBox<Usuario> combo) {
    }

    @Override
    public void llenaTabla(JTable tabla, String param) {
        try {
            Componentes botones=new Componentes();
            ArrayList<Usuario> usuarioes;
            tabla.removeAll();
            DefaultTableModel modelo = null;
            limpiarTabla(tabla);
            tabla.setDefaultRenderer(Object.class, new Render());
            modelo = (DefaultTableModel) tabla.getModel();
            usuarioes = usuarioDao.findAllLike(param);
            for(Usuario item:usuarioes){
                modelo.addRow(new Object[]{item.getRut(),item.getNombre(),item.getApellido(),botones.getBotonEditar(),botones.getBotonQuitar()});
            }
            tabla.setModel(modelo);
            ajustarAnchoColumnas(tabla);
            tabla.setRowHeight(23);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
