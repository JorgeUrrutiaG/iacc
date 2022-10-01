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
import datos.dao.RolDAOImpl;
import datos.dto.Rol1;
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
public class GestionRoles implements IGestion<Rol1> {

    private Rol1 rol;
    private final RolDAOImpl rolDao;

    public GestionRoles() {
        this.rol = new Rol1();
        this.rolDao = new RolDAOImpl();
    }

    @Override
    public void crear() {
        try {
            boolean esCreado=rolDao.create(rol);
            if(esCreado){
                JOptionPane.showMessageDialog(null,"Registro creado exitosamente ");
            }else{
                JOptionPane.showMessageDialog(null,"Error al crear el registro "+rol.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar() {
        try {
            boolean esEditado=rolDao.update(rol);
            if(esEditado){
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void quitar() {
        try {
            boolean esBorrado=rolDao.drop(rol.getId());
            if(esBorrado){
                JOptionPane.showMessageDialog(null,"Registro borrado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al borrar el registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarPorId(int id) {
        try {
            rol=rolDao.findById(id);
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void buscarTodos() {
        
    }

    @Override
    public void llenaCombo(JComboBox<Rol1> combo) {
    }

    @Override
    public void llenaTabla(JTable tabla, String param) {
        try {
            Componentes botones=new Componentes();
            ArrayList<Rol1> roles;
            tabla.removeAll();
            DefaultTableModel modelo = null;
            limpiarTabla(tabla);
            tabla.setDefaultRenderer(Object.class, new Render());
            modelo = (DefaultTableModel) tabla.getModel();
            roles = rolDao.findAllLike(param);
            for(Rol1 item:roles){
                modelo.addRow(new Object[]{item.getId(),item.toString(),botones.getBotonEditar(),botones.getBotonQuitar()});
            }
            tabla.setModel(modelo);
            ajustarAnchoColumnas(tabla);
            tabla.setRowHeight(23);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRoles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Rol1 getRol() {
        return rol;
    }

    public void setRol(Rol1 rol) {
        this.rol = rol;
    }

}

