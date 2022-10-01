
package app.interfaces;

/**
 *
 * @author Jorge
 */
public abstract class  Persona {
    private int id;
    private String rut;
    private String nombres;
    private String apellidos;
    private String nombreCompleto;
    private String correo;
    private String celular;
    private boolean activo;
    
    
    public Persona(){}

    public Persona(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    
    
    public Persona(int id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Persona(int id, String rut, String nombres, String apellidos, String correo, String celular, boolean activo) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.activo = activo;
        this.nombreCompleto=nombres+" "+apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        if(nombreCompleto==null || nombreCompleto.equals("")){
            nombreCompleto=nombres+" "+apellidos;
        }
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }

    

    

   
}
