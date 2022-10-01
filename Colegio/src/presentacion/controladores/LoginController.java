package presentacion.controladores;

import app.app.Env;
import datos.dao.UsuarioDAOImpl;
import datos.dto.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import presentacion.vistas.LoginView;
import presentacion.vistas.MainView;


public class LoginController implements ActionListener {

    LoginView vistaLogin;
    UsuarioDAOImpl usuarioDao;

    public LoginController(LoginView vistaLogin, Usuario usuario, UsuarioDAOImpl usuarioDao) {
        this.vistaLogin = vistaLogin;
        this.usuarioDao = usuarioDao;
    }

    public void inicio() throws SQLException {
        //Escuhar componentes
        this.vistaLogin.btnIngresar.addActionListener(this);

        //Mostrar Ventana de Login
        vistaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == vistaLogin.btnIngresar) {
                /*boolean esAdmin = false;*/
                if (validaDatos()) {
                    if (validarUsuario()) {
                        if (Env.usuarioActivo.getRol().getId() == 1) {
                            Env.esAdmin = true;
                        }
                        
                        MainView vistaPrincipal = new MainView();
                        MainController controlPrincipal = new MainController(vistaPrincipal);
                        this.vistaLogin.dispose();
                        controlPrincipal.activarVista();
                    } else {
                        vistaLogin.lblMensaje.setText("No se encontro el usuario");
                    }
                }
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean validarUsuario() throws SQLException {
        int rut =Integer.parseInt(vistaLogin.txtUsuario.getText());
        String clave = String.valueOf(vistaLogin.txtClave.getPassword());
        boolean encontrado=usuarioDao.autenticar(rut, clave);
        return encontrado;
    }

    public boolean validaDatos() throws SQLException {
        String clave = String.valueOf(vistaLogin.txtClave.getPassword());
        if (vistaLogin.txtUsuario.getText().equals("") || clave.equals("")) {
            vistaLogin.lblMensaje.setText("Falta usuario y/o contraseña");
        } else {
            return true;
        }
        return false;
    }
}
