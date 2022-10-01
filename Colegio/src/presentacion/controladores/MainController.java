/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import app.app.Env;
import app.ayudantes.Respaldo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.vistas.MainView;
import presentacion.vistas.VGRoles;
import presentacion.vistas.VGUsuarios;

/**
 *
 * @author Administracion
 */
public class MainController implements ActionListener {

    MainView vista;

    public MainController(MainView vista) {
        this.vista = vista;
    }

    public void activarVista() throws SQLException {
        escucharComponentes();
        this.vista.setLocationRelativeTo(null);
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setVisible(true);
        vista.lblUsuario.setText(Env.usuarioActivo.getNombre()+" "+Env.usuarioActivo.getApellido()+" - "+Env.usuarioActivo.getRol().getNombre());
    }

    public void escucharComponentes() throws SQLException {
        //menu gestión
        
        vista.itmGRoles.addActionListener(this);
        vista.itmGUsuarios.addActionListener(this);
        vista.itmRespaldar.addActionListener(this);
        vista.itmRestaurar.addActionListener(this);

        //Salir
        vista.itmSalir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.itmSalir == e.getSource()) {
            vista.dispose();
        }

        if(vista.itmGRoles==e.getSource()){
            try {
                VGRoles vistaRoles=new VGRoles(vista,true);
                CGRol controladorRol=new CGRol(vistaRoles);
                controladorRol.activarVista();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(vista.itmGUsuarios==e.getSource()){
            try{
                VGUsuarios vistaUsuarios=new VGUsuarios(vista, true);
                CGUsuario controladorUsuario=new CGUsuario(vistaUsuarios);
                controladorUsuario.activarVista();
            }catch (SQLException ex){
                
            }
        }
        
        if(vista.itmRespaldar==e.getSource()){
            int respuesta=JOptionPane.showConfirmDialog(null,"Está seguro de realizar el respaldo?","Atención",JOptionPane.YES_NO_OPTION);
            if(respuesta==0){
                try {
                    Respaldo.respaldar();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(vista.itmRestaurar==e.getSource()){
            int respuesta=JOptionPane.showConfirmDialog(null,"Está seguro de realizar la restauración de la Base de Datos?","Atención",JOptionPane.YES_NO_OPTION);
            if(respuesta==0){
                try {
                    Respaldo.restaurar();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        

        

        

        

        

        

        
        
        

        

        

    }

}
