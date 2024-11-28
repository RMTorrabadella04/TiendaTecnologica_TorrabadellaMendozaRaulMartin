package com.mycompany.tiendaonline;

import static com.mycompany.tiendaonline.ConexionBBDDJson.conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Raul
 */

public class HistorialCompra extends javax.swing.JFrame {


    public HistorialCompra() {
        initComponents();
        
        setTitle("Historial de Compra");
        setSize(1370, 790);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        informacionHistorial.setBackground(new Color(156, 156, 156));    
        informacionHistorial.setBounds(265, 17, 807, 710);
        informacionHistorial.setLayout(new BorderLayout());
        
        infoCompras = new JLabel("");
        infoCompras.setFont(new Font("Tahoma", Font.BOLD, 24));
        infoCompras.setForeground(Color.WHITE);

        infoCompras.setHorizontalAlignment(SwingConstants.CENTER);
        informacionHistorial.add(infoCompras, BorderLayout.SOUTH);
       
        cargarHistorialConEmail();
        
        this.jPanel1.add(informacionHistorial);

    }
    
    
    private void cargarHistorialConEmail() {
        
        String email = SesionIniciada.getEmail();
        
        String query = "SELECT u.id AS usuario_id, "+
                       "p.id AS producto_id, " +
                       "p.nombre AS producto_nombre, " +
                       "p.url AS producto_url, " +
                       "hc.cantidad, " +
                       "hc.fecha " +
                       "FROM Usuario u " +
                       "INNER JOIN HistorialCompra hc ON u.id = hc.usuario_id " +
                       "INNER JOIN Producto p ON hc.producto_id = p.id " +
                       "WHERE u.email = ?;";

        compras.clear();
        
        try (PreparedStatement pst = conexion.prepareStatement(query)){

            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                int usuarioId = rs.getInt("usuario_id");
                int productoId = rs.getInt("producto_id");
                String productoNombre = rs.getString("producto_nombre");
                String productoUrl = rs.getString("producto_url");
                int cantidad = rs.getInt("cantidad");
                Date fecha = rs.getDate("fecha");
                
                compras.add(new Compra(usuarioId, productoId, productoNombre, productoUrl, cantidad, fecha));
                
                mostrarCompra();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }
    
    private void mostrarCompra() {
        
        if (compras.isEmpty()) {
            
            infoCompras.setText("No hay compras disponibles.");
            
        } else {
            
            informacionHistorial.removeAll();
            
            Compra compra = compras.get(indiceActual);

            infoCompras.setText("<html>" +
                     "ID: " + compra.getProductoId() + "<br><br>" +
                     "NOMBRE: " + compra.getProductoNombre() + "<br><br>" +
                     "CANTIDAD: " + compra.getCantidad() + "<br><br>" +
                     "FECHA: " + compra.getFecha().toString() + "<br><br>" +
                     "</html>");
            
            ImageIcon imagen = new ImageIcon(compra.getProductoUrl());
            Image image = imagen.getImage();
            imagen = new ImageIcon(image); 

            
            JLabel imagenProducto = new JLabel(imagen);
            
            imagenProducto.setHorizontalAlignment(SwingConstants.CENTER);
            
            informacionHistorial.add(imagenProducto, BorderLayout.CENTER);
            informacionHistorial.add(infoCompras, BorderLayout.SOUTH);
            
            informacionHistorial.revalidate();
            informacionHistorial.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonSiguiente = new javax.swing.JButton();
        BotonAnterior = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BotonSiguiente.setBackground(new java.awt.Color(102, 102, 102));
        BotonSiguiente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        BotonSiguiente.setText("SIGUIENTE");
        BotonSiguiente.setBorderPainted(false);
        BotonSiguiente.setDefaultCapable(false);
        BotonSiguiente.setFocusPainted(false);
        BotonSiguiente.setFocusable(false);
        BotonSiguiente.setRequestFocusEnabled(false);
        BotonSiguiente.setRolloverEnabled(false);
        BotonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSiguienteActionPerformed(evt);
            }
        });

        BotonAnterior.setBackground(new java.awt.Color(102, 102, 102));
        BotonAnterior.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonAnterior.setForeground(new java.awt.Color(255, 255, 255));
        BotonAnterior.setText("ANTERIOR");
        BotonAnterior.setBorderPainted(false);
        BotonAnterior.setDefaultCapable(false);
        BotonAnterior.setFocusPainted(false);
        BotonAnterior.setFocusable(false);
        BotonAnterior.setRequestFocusEnabled(false);
        BotonAnterior.setRolloverEnabled(false);
        BotonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(BotonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 906, Short.MAX_VALUE)
                .addComponent(BotonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
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

    private void BotonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnteriorActionPerformed
        if (indiceActual > 0) {
            indiceActual--;
            mostrarCompra();
        }
    }//GEN-LAST:event_BotonAnteriorActionPerformed

    private void BotonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSiguienteActionPerformed
        if (indiceActual < compras.size() - 1) {
            indiceActual++;
            mostrarCompra();
        }
    }//GEN-LAST:event_BotonSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(HistorialCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialCompra().setVisible(true);
            }
        });
    }
    
    RoundedPanel informacionHistorial = new RoundedPanel(15);
    int indiceActual = 0;
    ArrayList<Compra> compras = new ArrayList<>();
    JLabel infoCompras;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnterior;
    private javax.swing.JButton BotonSiguiente;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
