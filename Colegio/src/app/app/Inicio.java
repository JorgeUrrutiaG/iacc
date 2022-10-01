/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.app;

import datos.dao.UsuarioDAOImpl;
import datos.dto.Usuario;
import java.sql.SQLException;
import presentacion.controladores.LoginController;
import presentacion.vistas.LoginView;

/**
 *
 * @author Administracion
 */


public class Inicio {
    
    public static void main(String[] args) throws SQLException {
        
        LoginView vistaLogin = new LoginView();
        Usuario usuario = new Usuario();
        UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();
        LoginController controladorLogin = new LoginController(vistaLogin, usuario, usuarioDao);
        controladorLogin.inicio();
    }
    
    
}
