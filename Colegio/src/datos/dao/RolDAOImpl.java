/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import app.conexion.Conexion;
import app.interfaces.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import datos.dto.Rol1;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administracion
 */
public class RolDAOImpl implements IDao<Rol1> {

    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection con;

    public RolDAOImpl() {
        this.con = Conexion.conectar();
    }

    @Override
    public boolean create(Rol1 rol) throws SQLException {
        ps = con.prepareStatement("INSERT INTO roles VALUES(null,?,1);");
        ps.setString(1, rol.getNombre());
        int resp = ps.executeUpdate();
        return resp > 0;
    }

    @Override
    public boolean update(Rol1 rol) throws SQLException {
        ps = con.prepareStatement("UPDATE roles SET nombre=? WHERE id=?;");
        ps.setString(1, rol.getNombre());
        System.out.println(rol.getId());
        ps.setInt(2, rol.getId());
        int resp = ps.executeUpdate();
        return resp > 0;
    }

    @Override
    public boolean drop(int id) throws SQLException {
        ps = con.prepareStatement("UPDATE roles SET activo=0 WHERE id=?;");
        ps.setInt(1, id);
        int resp = ps.executeUpdate();
        return resp > 0;
    }

    @Override
    public Rol1 findById(int id) throws SQLException {
        ps = con.prepareStatement("SELECT * FROM roles WHERE id=? LIMIT 1;");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            Rol1 rol = new Rol1(rs.getInt(1), rs.getString(2));
            return rol;
        }
        return null;
    }

    @Override
    public ArrayList<Rol1> findAll() throws SQLException {
        ArrayList<Rol1> roles = new ArrayList<>();
        Rol1 rol;
        ps = con.prepareStatement("SELECT * FROM roles WHERE activo=1 ORDER BY id;");
        rs = ps.executeQuery();
        while (rs.next()) {
            rol = new Rol1(rs.getInt(1), rs.getString(2));
            roles.add(rol);
        }
        return roles;
    }

    @Override
    public boolean activate(int id) throws SQLException {
        ps = con.prepareStatement("UPDATE roles SET activo=1 WHERE id=?;");
        ps.setInt(1, id);
        int resp = ps.executeUpdate();
        return resp > 0;
    }

   
    @Override
    public ArrayList<Rol1> findAllLike(String param) throws SQLException {
        Rol1 rol;
        ArrayList<Rol1> roles = new ArrayList<>();
        ps = con.prepareStatement("SELECT * FROM roles WHERE nombre LIKE ? AND activo=1 ORDER BY id;");
        ps.setString(1, param + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            rol = new Rol1(rs.getInt(1), rs.getString(2));
            roles.add(rol);
        }
        return roles;
    }

    @Override
    public int last() throws SQLException {
        ps = con.prepareStatement("SELECT MAX(id) FROM roles;");
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

}
