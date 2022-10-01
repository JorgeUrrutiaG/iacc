
package app.ayudantes;

/**
 *
 * @author Administracion
 */
public class ValidarRut {
    
    private final char dv;
    private int rut;

    public ValidarRut(String rut){
        String digito = rut.substring(rut.length() - 1);
        this.dv=digito.charAt(0);
        this.rut=Integer.parseInt(rut.substring(0,rut.length()-1));
    }
    
    public boolean validar() {

    boolean validacion = false;
    
    try {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

    } catch (java.lang.NumberFormatException e) {
    } catch (Exception e) {
    }
    return validacion;
}
    
}
