/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dto;

/**
 *
 * @author Administracion
 */
public class Usuario {

    private int rut;
    private String nombre;
    private String apellido;
    private String clave;
    private int celular;
    private String correo;
    private Rol1 rol;
    private int colegio;
    private boolean activo;
    

    public Usuario() {
    }

    public Usuario(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }
    
    public Usuario(int rut, String nombre,String apellido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido=apellido;
    }

    public Usuario(int rut, String nombre, String clave, boolean activo, Rol1 rol) {
        this.rut = rut;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = activo;
        this.rol = rol;
    }

    public Usuario(int rut, String nombre, String apellido, String clave, int celular, String correo, Rol1 rol) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.celular = celular;
        this.correo = correo;
        this.rol = rol;
    }

    public Usuario(int rut, String nombre, String apellido, String clave, int celular, String correo, Rol1 rol, int colegio, boolean activo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.celular = celular;
        this.correo = correo;
        this.rol = rol;
        this.colegio = colegio;
        this.activo = activo;
    }
    
    

    public Usuario(int rut, String nombre, String clave, boolean activo) {
        this.rut = rut;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = activo;
    }
    
    

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    

    public Rol1 getRol() {
        return rol;
    }

    public void setRol(Rol1 idrol) {
        this.rol = idrol;
    }

    public int getColegio() {
        return colegio;
    }

    public void setColegio(int colegio) {
        this.colegio = colegio;
    }

    public boolean esActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
