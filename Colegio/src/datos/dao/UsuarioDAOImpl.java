/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import app.app.Env;
import app.conexion.Conexion;
import app.interfaces.IDao;
import java.sql.Statement;
import datos.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administracion
 */
public class UsuarioDAOImpl implements IDao<Usuario> {
    
    private PreparedStatement ps;
    private ResultSet rs;
 
    
    
    private final Connection con;
    public UsuarioDAOImpl() {
        con=Conexion.conectar();
    }
    
    @Override
    public Usuario findById(int idUsuario) throws SQLException{
        ps=con.prepareStatement("SELECT * FROM usuarios WHERE rut=? LIMIT 1;");
        ps.setInt(1,idUsuario);
        rs=ps.executeQuery();
        if(rs.next()){
            Usuario usuario=new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3));
            return usuario;
        }
        return null;
    }
    
    public boolean autenticar(int rut, String clave) throws SQLException {
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE rut=? AND clave=? LIMIT 1;");
        ps.setInt(1, rut);
        ps.setString(2, clave.trim());
        rs = ps.executeQuery();
        while (rs.next()) {
            RolDAOImpl rolDao = new RolDAOImpl();
            Env.usuarioActivo = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rolDao.findById(rs.getInt("rol_id")));
            
            return true;
        }
        return false;
    }

    @Override
    public boolean create(Usuario usuario) throws SQLException {
        int respuesta = 0;
        try {
            ps = con.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?);");
            ps.setInt(1, usuario.getRut());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getClave());
            ps.setInt(5, usuario.getCelular());
            ps.setString(6, usuario.getCorreo());
            ps.setInt(7, usuario.getRol().getId());
            ps.setInt(8, usuario.getColegio());
            ps.setBoolean(9, usuario.esActivo());
            respuesta = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar registro : " + ex.getMessage());
        }
        return respuesta > 0;
    }

    @Override
    public boolean update(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean drop(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> findAll() throws SQLException {
        Usuario usuario;
        ArrayList<Usuario> lista = new ArrayList();
        Statement st = con.createStatement();
        try (ResultSet res = st.executeQuery("SELECT rut,nombre,apellido FROM usuarios WHERE activo=1 ORDER BY usuario;")) {
            while (res.next()) {
                usuario = new Usuario();
                usuario.setRut(res.getInt(1));
                usuario.setNombre(res.getString(2));
                usuario.setApellido(res.getString(3));
                lista.add(usuario);
                System.out.println(usuario.getNombre());
            }
        }
        return lista;
    }

    @Override
    public boolean activate(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> findAllLike(String param) throws SQLException {
        Usuario usuario;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE nombre LIKE ? AND activo=1 ORDER BY rut;");
        ps.setString(1, param + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            usuario = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3));
            usuarios.add(usuario);
        }
        return usuarios;
   
    }

    @Override
    public int last() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
