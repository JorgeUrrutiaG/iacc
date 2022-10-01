/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ayudantes;

/**
 *
 * @author Administracion
 */
public class FabricaCodigos {

    private static String GC = "GC";
    private static String GE = "GE";

    public FabricaCodigos() {
    }

    public static String obtenerMes(int mes) {
        String sMes = null;
        switch (mes) {
            case 1:
                 sMes="ENERO";
                 break;
            case 2:
                sMes="FEBRERO";
                break;
            case 3:
                sMes="MARZO";
                break;
            case 4:
                sMes="ABRIL";
                break;
            case 5:
                sMes="MAYO";
                break;
            case 6:
                sMes="JUNIO";
                break;
            case 7:
                sMes="JULIO";
                break;
            case 8:
                sMes="AGOSTO";
                break;
            case 9:
                sMes="SEPTIEMBRE";
                break;
            case 10:
                sMes="OCTUBRE";
                break;
            case 11:
                sMes="NOVIEMBRE";
                break;
            case 12:
                sMes="DICIEMBRE";
                break;
        }

        return sMes;
    }
    
    public static int obtenerNumeroMes(String mes) {
        int iMes = 0;
        switch (mes) {
            case "ENERO":
                 iMes=1;
                 break;
            case "FEBRERO":
                iMes=2;
                break;
            case "MARZO":
                iMes=3;
                break;
            case "ABRIL":
                iMes=4;
                break;
            case "MAYO":
                iMes=5;
                break;
            case "JUNIO":
                iMes=6;
                break;
            case "JULIO":
                iMes=7;
                break;
            case "AGOSTO":
                iMes=8;
                break;
            case "SEPTIEMBRE":
                iMes=9;
                break;
            case "OCTUBRE":
                iMes=10;
                break;
            case "NOVIEMBRE":
                iMes=11;
                break;
            case "DICIEMBRE":
                iMes=12;
                break;
        }

        return iMes;
    }
    
    public static String obtenerCodigoProducto(int mes,int agno){
        String codigo=null;
        switch (mes) {
            case 1:
                 codigo="GC01"+agno;
                 break;
            case 2:
                codigo="GC02"+agno;
                break;
            case 3:
                codigo="GC03"+agno;
                break;
            case 4:
                codigo="GC04"+agno;
                break;
            case 5:
                codigo="GC05"+agno;
                break;
            case 6:
                codigo="GC06"+agno;
                break;
            case 7:
                codigo="GC07"+agno;
                break;
            case 8:
                codigo="GC08"+agno;
                break;
            case 9:
                codigo="GC09"+agno;
                break;
            case 10:
                codigo="GC010"+agno;
                break;
            case 11:
                codigo="GC011"+agno;
                break;
            case 12:
                codigo="GC012"+agno;
                break;
        }

        return codigo;
    }
}