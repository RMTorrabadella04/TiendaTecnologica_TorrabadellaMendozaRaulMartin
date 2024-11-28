package com.mycompany.tiendaonline;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Raul
 */

public class Main extends javax.swing.JFrame {
    
    ConexionBBDDJson conexion;

 
    public Main() throws ParseException, IOException, FileNotFoundException, SQLException {
        
        initComponents();
        
        setTitle("Tienda Online");
        setSize(1370, 790);
        
        this.conexion = new ConexionBBDDJson();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonRopa = new javax.swing.JButton();
        BotonElectronica1 = new javax.swing.JButton();
        BotonDeportes = new javax.swing.JButton();
        BotonUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SportTech & Style");

        BotonRopa.setBackground(new java.awt.Color(102, 102, 102));
        BotonRopa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BotonRopa.setForeground(new java.awt.Color(255, 255, 255));
        BotonRopa.setText("ROPA");
        BotonRopa.setToolTipText("");
        BotonRopa.setBorder(null);
        BotonRopa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonRopa.setDefaultCapable(false);
        BotonRopa.setFocusPainted(false);
        BotonRopa.setFocusable(false);
        BotonRopa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRopa.setRequestFocusEnabled(false);
        BotonRopa.setRolloverEnabled(false);
        BotonRopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRopaActionPerformed(evt);
            }
        });

        BotonElectronica1.setBackground(new java.awt.Color(102, 102, 102));
        BotonElectronica1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BotonElectronica1.setForeground(new java.awt.Color(255, 255, 255));
        BotonElectronica1.setText("ELECTRONICA");
        BotonElectronica1.setBorderPainted(false);
        BotonElectronica1.setDefaultCapable(false);
        BotonElectronica1.setFocusPainted(false);
        BotonElectronica1.setFocusable(false);
        BotonElectronica1.setRequestFocusEnabled(false);
        BotonElectronica1.setRolloverEnabled(false);
        BotonElectronica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonElectronica1ActionPerformed(evt);
            }
        });

        BotonDeportes.setBackground(new java.awt.Color(102, 102, 102));
        BotonDeportes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BotonDeportes.setForeground(new java.awt.Color(255, 255, 255));
        BotonDeportes.setText("DEPORTES");
        BotonDeportes.setBorder(null);
        BotonDeportes.setBorderPainted(false);
        BotonDeportes.setDefaultCapable(false);
        BotonDeportes.setFocusPainted(false);
        BotonDeportes.setFocusable(false);
        BotonDeportes.setRequestFocusEnabled(false);
        BotonDeportes.setRolloverEnabled(false);
        BotonDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDeportesActionPerformed(evt);
            }
        });

        BotonUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BotonUsuario.setForeground(new java.awt.Color(255, 255, 255));
        BotonUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\alumno\\Desktop\\TiendaOnline\\src\\main\\Resources\\iconouser.png")); // NOI18N
        BotonUsuario.setToolTipText("");
        BotonUsuario.setBorder(null);
        BotonUsuario.setBorderPainted(false);
        BotonUsuario.setContentAreaFilled(false);
        BotonUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonUsuario.setDefaultCapable(false);
        BotonUsuario.setFocusPainted(false);
        BotonUsuario.setFocusable(false);
        BotonUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonUsuario.setRequestFocusEnabled(false);
        BotonUsuario.setRolloverEnabled(false);
        BotonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(BotonElectronica1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(BotonDeportes, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(BotonRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonDeportes, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonElectronica1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRopaActionPerformed
        
        Categoria ventanaRopa = null;
        ventanaRopa = new Categoria("Ropa");
        
        ventanaRopa.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
                // Hago visible la ventana principal de nuevo cuando la ventana de usuarios se cierra
                
                setVisible(true);
            }
        });

        // Muestro la ventana de usuarios
        
        ventanaRopa.setVisible(true); 

        // Oculto la ventana principal
        
        setVisible(false);
    }//GEN-LAST:event_BotonRopaActionPerformed

    private void BotonElectronica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonElectronica1ActionPerformed
        Categoria ventanaElectronica = null;
        ventanaElectronica = new Categoria("Electrónica");
        
        ventanaElectronica.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
                // Hago visible la ventana principal de nuevo cuando la ventana de usuarios se cierra
                
                setVisible(true);
            }
        });

        // Muestro la ventana de usuarios
        
        ventanaElectronica.setVisible(true); 

        // Oculto la ventana principal
        
        setVisible(false);
                                        
    }//GEN-LAST:event_BotonElectronica1ActionPerformed

    private void BotonDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDeportesActionPerformed
        
        Categoria ventanaDeportes = null;
        ventanaDeportes = new Categoria("Deportes");
        
        ventanaDeportes.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
                // Hago visible la ventana principal de nuevo cuando la ventana de usuarios se cierra
                
                setVisible(true);
            }
        });

        // Muestro la ventana de usuarios
        
        ventanaDeportes.setVisible(true); 

        // Oculto la ventana principal
        
        setVisible(false);
        
    }//GEN-LAST:event_BotonDeportesActionPerformed

    private void BotonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonUsuarioActionPerformed
        
        Usuarios ventanaUsuarios = null;
        try {
            ventanaUsuarios = new Usuarios();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Añado un WindowListener para detectar el cierre de la ventana de usuarios
        
        ventanaUsuarios.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
                // Hago visible la ventana principal de nuevo cuando la ventana de usuarios se cierra
                
                setVisible(true);
            }
        });

        // Muestro la ventana de usuarios
        
        ventanaUsuarios.setVisible(true); 

        // Oculto la ventana principal
        
        setVisible(false); 
    }//GEN-LAST:event_BotonUsuarioActionPerformed
    
 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonDeportes;
    private javax.swing.JButton BotonElectronica1;
    private javax.swing.JButton BotonRopa;
    private javax.swing.JButton BotonUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
