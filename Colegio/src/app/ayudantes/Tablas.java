/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ayudantes;

//import dao.ArrendatarioDAO;
//import dao.CuentaBancoDAO;
//import dao.PropietarioDAO;
//import dao.ProveedorDAO;
//import dao.UnidadDAO;
//import dao.UsuarioDAO;
//import dto.CuentaBanco;
//import dto.Proveedor;
//import dto.Unidad;
//import dto.Usuario;
import java.awt.Component;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Administracion
 */
public class Tablas {

    public static void ajustarAnchoColumnas(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {

            int maxwidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend
                        = table.getCellRenderer(row, col);
                Object value = table.getValueAt(row, col);
                Component comp
                        = rend.getTableCellRendererComponent(table,
                                value,
                                false,
                                false,
                                row,
                                col);
                maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
            } // para fila
            TableColumn column = columnModel.getColumn(col);
            column.setPreferredWidth(maxwidth);
        } // para columnas 
        table.setRowHeight(24);

    }

    public static DefaultTableModel limpiarTabla(JTable table) {
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int fila = 0; fila < model.getRowCount() - 1; fila++) {
            model.removeRow(fila);
        }

        return model;
    }

    public static void llenaTabla(JTable tabla, Object objeto, String param) throws SQLException {
        String clase = objeto.getClass().getSimpleName();
        DefaultTableModel modelo = null;
        limpiarTabla(tabla);
        tabla.setDefaultRenderer(Object.class, new Render());
        modelo = (DefaultTableModel) tabla.getModel();
//        switch (clase) {
//            case "Propietario":
//                PropietarioDAO propietarioDao = new PropietarioDAO();
//                modelo = propietarioDao.fillTable(modelo, param);
//                break;
//            case "Arrendatario":
//                ArrendatarioDAO arrendatarioDao = new ArrendatarioDAO();
//                modelo = arrendatarioDao.fillTable(modelo, param);
//                break;
//        }
//
//        if (objeto instanceof Proveedor) {
//            ProveedorDAO objDao = new ProveedorDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//
//        if (objeto instanceof Usuario) {
//            UsuarioDAO objDao = new UsuarioDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//
//        if (objeto instanceof Unidad) {
//            UnidadDAO objDao = new UnidadDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//
//        if (objeto instanceof CuentaBanco) {
//            CuentaBancoDAO objDao = new CuentaBancoDAO();
//            modelo = objDao.fillTable(modelo, Integer.parseInt(param));
//        }

        tabla.setModel(modelo);
        ajustarAnchoColumnas(tabla);
        tabla.setRowHeight(23);

    }

    public static void llenaTablaBusqueda(JTable tabla, Object objeto, String unidad, String param) throws SQLException {
        String clase = objeto.getClass().getSimpleName();
        DefaultTableModel modelo = null;
        limpiarTabla(tabla);
        tabla.setDefaultRenderer(Object.class, new Render());
        modelo = (DefaultTableModel) tabla.getModel();
//        switch (clase) {
//            case "Propietario":
//                UnidadDAO unidadDaoP = new UnidadDAO();
//                modelo = unidadDaoP.fillTablePropietarios(modelo, unidad, param);
//                break;
//            case "Arrendatario":
//                UnidadDAO unidadDaoA = new UnidadDAO();
//                modelo = unidadDaoA.fillTableArrendatarios(modelo, unidad, param);
//                break;
//        }

//        if (objeto instanceof Proveedor) {
//            ProveedorDAO objDao = new ProveedorDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//
//        if (objeto instanceof Usuario) {
//            UsuarioDAO objDao = new UsuarioDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//
//        if (objeto instanceof Unidad) {
//            UnidadDAO objDao = new UnidadDAO();
//            modelo = objDao.fillTable(modelo, param);
//        }
//        
//        if (objeto instanceof CuentaBanco) {
//            CuentaBancoDAO objDao = new CuentaBancoDAO();
//            modelo = objDao.fillTable(modelo, Integer.parseInt(param));
//        }
        tabla.setModel(modelo);
        ajustarAnchoColumnas(tabla);
        tabla.setRowHeight(23);

    }

}
