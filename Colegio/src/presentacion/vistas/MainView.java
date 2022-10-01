package presentacion.vistas;

import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public class MainView extends javax.swing.JFrame {

    public MainView() throws SQLException {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        itemGPropietarios = new javax.swing.JMenuItem();
        itmSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmGUsuarios = new javax.swing.JMenuItem();
        itmGRoles = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itmRespaldar = new javax.swing.JMenuItem();
        itmRestaurar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Matrículas CSCJ v1.0");
        setName("frmPrincipal"); // NOI18N
        setResizable(false);

        jMenu3.setText("Gestionar");

        itemGPropietarios.setText("Datos de Colegio");
        itemGPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGPropietariosActionPerformed(evt);
            }
        });
        jMenu3.add(itemGPropietarios);

        itmSalir.setText("Salir");
        jMenu3.add(itmSalir);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Gestión de seguridad");

        itmGUsuarios.setText("Gestión Usuarios");
        jMenu1.add(itmGUsuarios);

        itmGRoles.setText("Gestión Roles de Usuarios");
        jMenu1.add(itmGRoles);

        jMenuItem4.setText("Gestión Periodos Contables");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Gestión de seguridad");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Respaldos");

        itmRespaldar.setText("Respaldar BD");
        jMenu2.add(itmRespaldar);

        itmRestaurar.setText("Restaurar BD");
        jMenu2.add(itmRestaurar);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ayuda");

        jMenuItem6.setText("Ayuda Usuarios");
        jMenu4.add(jMenuItem6);

        jMenuItem1.setText("Requisitos del sistema");
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Manual del sistema");
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Políticas de seguridad");
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(448, Short.MAX_VALUE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemGPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGPropietariosActionPerformed
        
    }//GEN-LAST:event_itemGPropietariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem itemGPropietarios;
    public javax.swing.JMenuItem itmGRoles;
    public javax.swing.JMenuItem itmGUsuarios;
    public javax.swing.JMenuItem itmRespaldar;
    public javax.swing.JMenuItem itmRestaurar;
    public javax.swing.JMenuItem itmSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

}
