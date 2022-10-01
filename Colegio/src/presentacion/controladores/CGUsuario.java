/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controladores;

import app.ayudantes.Componentes;
import app.interfaces.IController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import negocio.GestionUsuarios;
import presentacion.vistas.VGUsuarios;

/**
 *
 * @author jorge
 */
    public class CGUsuario implements IController, KeyListener, MouseListener {

    private final VGUsuarios vista;
    private final GestionUsuarios gestor;
    private final Componentes componentes;
    private boolean esNuevo;

    public CGUsuario(VGUsuarios vista) {
        this.vista = vista;
        this.gestor = new GestionUsuarios();
        this.componentes = new Componentes(vista.panelDatos);
    }

    @Override
    public void activarVista() {
        escucharComponentes();
        estadoInicialComponentes();
        vista.setVisible(true);
    }

    @Override
    public void escucharComponentes() {
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.tablaTodos.addMouseListener(this);

    }

    @Override
    public void estadoInicialComponentes() {
        componentes.limpiarText();
        //vista.lblId.setText("");
        componentes.inhabilitarText();
        vista.tablaTodos.setEnabled(true);
        vista.btnGuardar.setEnabled(false);
        vista.btnSalir.setText("Salir");
        vista.btnNuevo.setEnabled(true);
        fillTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btnSalir == e.getSource()) {
            if (vista.btnSalir.getText().equals("Salir")) {
                vista.dispose();
            } else {
                estadoInicialComponentes();
            }

        }

        if (vista.btnNuevo == e.getSource()) {
            esNuevo = true;
            vista.btnGuardar.setEnabled(true);
            componentes.limpiarText();
            componentes.habilitarText();
            //vista.txtNombre.requestFocus();
            vista.tablaTodos.setEnabled(false);
            vista.btnSalir.setText("Cancelar");
            vista.btnNuevo.setEnabled(false);

        }

        if (vista.btnGuardar == e.getSource()) {
            boolean datosCompletos = comprobarVacios();
            if (datosCompletos) {
                llenaUsuario();
                if (esNuevo) {
                    gestor.crear();
                } else {
                    gestor.getUsuario().setRut(Integer.parseInt(vista.txtRut.getText().trim()));
                    System.out.println(gestor.getUsuario().getRut());
                    gestor.actualizar();
                }
                estadoInicialComponentes();
            } else {
                JOptionPane.showMessageDialog(null, "Faltan Datos");
                vista.txtNombre.requestFocus();

            }
        }
    }

    public void llenaUsuario() {
         gestor.getUsuario().setNombre(vista.txtNombre.getText().trim());

    }

    public void llenaText() {
        vista.txtRut.setText(String.valueOf(gestor.getUsuario().getRut()));
        vista.txtNombre.setText(gestor.getUsuario().getNombre());
        vista.txtApellido.setText(gestor.getUsuario().getApellido());
        
    }

    public boolean comprobarVacios() {
        int enBlanco = componentes.verificarText();
        return enBlanco == 0;
    }

    @Override
    public void fillCombos() {

    }

    @Override
    public void fillTabla() {
        gestor.llenaTabla(vista.tablaTodos,"");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //aMayus(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        aMayus(e);
//        Character c = e.getKeyChar();
//        if (e.getKeyCode() == 8) {
//            if (param.length() != 0) {
//                param = param.substring(0, param.length() - 1);
//            }
//        }
//        if (Character.isLetter(c)) {
//            param += c;
//        }
//        fillTabla();

    }

    private void aMayus(java.awt.event.KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.tablaTodos) {
            if (vista.tablaTodos.isEnabled()) {
                int item_sel = vista.tablaTodos.getSelectedRow();
                if (item_sel > -1) {
                    int col_sel = vista.tablaTodos.getColumnModel().getColumnIndexAtX(e.getX());
                    String tipo_btn = vista.tablaTodos.getColumnName(col_sel);
                    int id = Integer.parseInt(vista.tablaTodos.getValueAt(item_sel, 0).toString());
                    gestor.buscarPorId(id);
                    llenaText();
                    if (tipo_btn.equals("Editar")) {
                        esNuevo = false;
                        vista.btnNuevo.setEnabled(false);
                        vista.btnSalir.setText("Cancelar");
                        vista.btnGuardar.setEnabled(true);
                        componentes.habilitarText();
                        vista.txtNombre.requestFocus();
                        vista.tablaTodos.setEnabled(false);

                    }
                    if (tipo_btn.equals("Quitar")) {
                        int resp = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar el registro?", "Atención", JOptionPane.YES_NO_OPTION);
                        if (resp == 0) {
                            gestor.quitar();
                            estadoInicialComponentes();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
