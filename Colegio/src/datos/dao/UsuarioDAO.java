package datos.dao;

import app.interfaces.IDao;
import app.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import datos.dto.Usuario;
import java.sql.ResultSet;
import java.sql.Statement;
import app.ayudantes.Componentes;

///**
// *
// * @author Jorge
// */
public class UsuarioDAO implements IDao<Usuario> {

    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private final Connection con;
    private int respuesta;
    private String sql;

    //Consultas
    private final String FIND_ALL = "SELECT * FROM usuarios WHERE activo=1 ORDER BY usuario;";
    private final String FIND_BY_ID = "SELECT * FROM usuarios WHERE id=? LIMIT 1;";
    private final String CREATE = "INSERT INTO usuarios VALUES (null,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE usuarios SET usuario=?,rut=?,clave=?,idrol=? WHERE id=?;";
    private final String DROP = "UPDATE usuarios SET activo=0 WHERE id=?;";
    private final String FIND_BY_LIKE = "SELECT * FROM usuarios WHERE activo=1 AND usuario LIKE ? ORDER BY usuario;";
    private final String FIND_ALL_SMALL = "SELECT id,usuario FROM usuarios WHERE activo=1 AND usuario LIKE '?%' ORDER BY usuario;";

    public UsuarioDAO() throws SQLException {
        con = Conexion.conectar();
    }

    @Override
    public boolean create(Usuario usuario) {
        respuesta = 0;
        try {
            ps = con.prepareStatement(CREATE);
            ps.setString(1, usuario.getNombre());
            //ps.setString(2, usuario.getRut());
            ps.setString(3, usuario.getClave());
            //ps.setInt(4, usuario.getRol().getPk());
            //ps.setInt(5, usuario.getActivo());
            respuesta = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar registro : " + ex.getMessage());
        }
        return respuesta > 0;

    }

    @Override
    public boolean update(Usuario usuario) throws SQLException {
        respuesta = 0;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, usuario.getNombre());
            //ps.setString(2, usuario.getRut());
            ps.setString(3, usuario.getClave());
            //ps.setInt(4, usuario.getRol().getPk());
           // ps.setInt(5, usuario.getId());
            respuesta = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar registro : " + ex.getMessage());
        }
        return respuesta > 0;
    }

    @Override
    public boolean drop(int pkey) throws SQLException {
        respuesta = 0;
        try {
            ps = con.prepareStatement(DROP);
            ps.setInt(1, pkey);
            respuesta = ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar registro : " + ex.getMessage());
        }
        return respuesta > 0;
    }

    /**
     *
     * @param pk
     * @return
     * @throws SQLException
     */
    @Override
    public Usuario findById(int pk) throws SQLException {
        Usuario usuario;
        try {
            ps = con.prepareStatement(FIND_BY_ID);
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
               // usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
               // usuario.setRut(rs.getString(3));
               // usuario.setActivo(rs.getInt(3));
                rs.close();
                return usuario;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage());
        }

        return null;
    }

    @Override
    public ArrayList<Usuario> findAll() throws SQLException {
        Usuario usuario;
        ArrayList<Usuario> lista = new ArrayList();
        st = con.createStatement();
        rs = st.executeQuery(FIND_ALL);
        while (rs.next()) {
            usuario = new Usuario();
            //usuario.setId(rs.getInt(1));
            usuario.setNombre(rs.getString(2));
            //usuario.setActivo(rs.getInt(3));
            lista.add(usuario);
        }
        rs.close();
        return lista;
    }

    public JComboBox fillCombo(JComboBox<Usuario> cmbUsuario) throws SQLException {
        st = con.createStatement();
        rs = st.executeQuery(FIND_ALL_SMALL);
        cmbUsuario.addItem(new Usuario(0, "<Seleccionar>"));
        while (rs.next()) {
            cmbUsuario.addItem(new Usuario(rs.getInt(1), rs.getString(2)));
        }
        rs.close();
        return cmbUsuario;
    }

    public DefaultTableModel fillTable(DefaultTableModel modelo, String like) throws SQLException {
        Componentes botones = new Componentes();
        ps = con.prepareStatement(FIND_BY_LIKE);
        ps.setString(1, like + "%");
        rs = ps.executeQuery();
//        Object columnName[] = {"id", "Usuario"};
//        modelo.setColumnIdentifiers(columnName);
        while (rs.next()) {
            modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3),botones.getBotonEditar(),botones.getBotonQuitar()});
        }
        return modelo;
    }

    @Override
    public boolean activate(int pk) throws SQLException {
        respuesta = 0;
        try {
            sql = "update usuarios set activo=1 where id=?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pk);
            respuesta = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar registro : " + ex.getMessage());
        }
        return respuesta > 0;
    }

    @Override
    public int last() throws SQLException {
        sql = "SELECT MAX(id) FROM usuarios;";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        return rs.getInt(1);
    }

    public Usuario consultaLogin(int user, String clave) throws SQLException {
        Usuario usuarioLogeado;
        st = con.createStatement();
        sql = "Select * from usuarios where rut=" + user + " and clave='" + clave + "';";
        rs = st.executeQuery(sql);
        if (rs.next()) {
            usuarioLogeado = new Usuario();
            //usuarioLogeado.setId(rs.getInt(1));
            usuarioLogeado.setNombre(rs.getString(2));
            //usuarioLogeado.setRut(rs.getString(3));
            usuarioLogeado.setClave(rs.getString(4));
            //RolDAO rolDao = new RolDAO();
            //usuarioLogeado.setRol(rolDao.findById(rs.getInt(5)));
            //usuarioLogeado.setActivo(rs.getInt(6));
            return usuarioLogeado;

        }

        return null;
    }

    public boolean cambiarClave(int pk, String claveNueva) {
        try {
            sql = "update usuarios set clave='" + claveNueva + "' where id=" + pk + ";";
            st = con.createStatement();
            respuesta = st.executeUpdate(sql);
            if (respuesta > 0) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar registro : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Usuario> findAllLike(String param) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
