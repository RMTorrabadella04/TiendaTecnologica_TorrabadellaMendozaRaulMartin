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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Raul
 */
public class Categoria extends javax.swing.JFrame {

    
    public Categoria(){
        
    }
    
    public Categoria(String categoria) {
        
        cate = categoria;
        
        initComponents();
        
        setTitle(categoria);
        setSize(1370, 790);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JLabel categoriaTitulo = new JLabel();
        categoriaTitulo.setText(categoria);
        categoriaTitulo.setFont(new Font("Tahoma", Font.BOLD, 36));
        categoriaTitulo.setBounds(0, 50, 1370, 100);
        categoriaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.jPanel1.add(categoriaTitulo);
        
        
        producto1.setBackground(new Color(156, 156, 156));    
        producto1.setBounds(50, 200, 350, 500);
        producto1.setLayout(new BorderLayout());
        producto1.add(verMas1, BorderLayout.SOUTH);
        textoProducto1.setHorizontalAlignment(SwingConstants.CENTER);
        producto1.add(textoProducto1, BorderLayout.CENTER);

                
        producto2.setBackground(new Color(156, 156, 156));    
        producto2.setBounds(500, 200, 350, 500);
        producto2.setLayout(new BorderLayout());
        producto2.add(verMas2, BorderLayout.SOUTH);
        textoProducto2.setHorizontalAlignment(SwingConstants.CENTER);
        producto2.add(textoProducto2, BorderLayout.CENTER);

                
        producto3.setBackground(new Color(156, 156, 156));    
        producto3.setBounds(950, 200, 350, 500);
        producto3.setLayout(new BorderLayout());
        producto3.add(verMas3, BorderLayout.SOUTH);
        textoProducto3.setHorizontalAlignment(SwingConstants.CENTER);
        producto3.add(textoProducto3, BorderLayout.CENTER);        
        
        estiloBoton(verMas1);
        estiloBoton(verMas2);
        estiloBoton(verMas3);
        
        estiloDatos(textoProducto1);
        estiloDatos(textoProducto2);
        estiloDatos(textoProducto3);
        
        datosProductos();
        
        this.jPanel1.add(producto1);
        this.jPanel1.add(producto2);
        this.jPanel1.add(producto3);
        
        
    }
    
    private void datosProductos(){
        
         String query = "SELECT nombre, " +
                        "precio, " +
                        "url " +
                        "FROM producto " +
                        "WHERE categoria_nombre = ?;";
         
         try (PreparedStatement pst = conexion.prepareStatement(query)){

            pst.setString(1, cate);
            ResultSet rs = pst.executeQuery();
            
            int c=1;

            while (rs.next()) {
                
                String productoNombre = rs.getString("nombre");
                double productosPrecio = rs.getDouble("precio");
                String productoUrl = rs.getString("url");
                
                String texto = "<html>" +
                               "Producto: " + productoNombre + "<br><br>" +  // Producto
                               "Precio: " + productosPrecio + "<br><br>" +  // Precio
                               "</html>";   
                
                ImageIcon imagen = new ImageIcon(productoUrl);
                Image image = imagen.getImage();
                imagen = new ImageIcon(image); 

                JLabel imagenProducto = new JLabel(imagen);

                imagenProducto.setHorizontalAlignment(SwingConstants.CENTER);
                
                switch (c) {
                    case 1:
                        textoProducto1.setText(texto);
                        producto1.add(imagenProducto, BorderLayout.NORTH);
                        producto1.revalidate();
                        producto1.repaint();
                        break;
                    case 2:
                        textoProducto2.setText(texto);
                        producto2.add(imagenProducto, BorderLayout.NORTH);
                        producto2.revalidate();
                        producto2.repaint();
                        break;
                    case 3:
                        textoProducto3.setText(texto);
                        imagenProducto.setHorizontalAlignment(SwingConstants.CENTER);
                        producto3.add(imagenProducto, BorderLayout.NORTH);
                        producto3.revalidate();
                        producto3.repaint();
                        break;
                        
                }
                c++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private void estiloBoton(JButton botoncito) {
        
        botoncito.setBackground(new Color(169, 169, 169));  
        botoncito.setFont(new Font("Tahoma", Font.BOLD, 16));
        botoncito.setFocusPainted(false);  
        botoncito.setBorderPainted(false); 
        botoncito.setForeground(Color.WHITE);
        botoncito.setPreferredSize(new java.awt.Dimension(350, 50));
        
    }
    
    
    private void estiloDatos(JLabel textito){
        
        textito.setFont(new Font("Tahoma", Font.BOLD, 20));
        textito.setForeground(Color.WHITE);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
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


    public static void main(String args[]) {
       
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categoria().setVisible(true);
            }
        });
    }
    
    String cate;
        
    RoundedPanel producto1 = new RoundedPanel(15);
    JButton verMas1 = new JButton("VER MÁS");
    JLabel textoProducto1 = new JLabel();
   
    RoundedPanel producto2 = new RoundedPanel(15);
    JButton verMas2 = new JButton("VER MÁS");
    JLabel textoProducto2 = new JLabel();
    
    RoundedPanel producto3 = new RoundedPanel(15);
    JButton verMas3 = new JButton("VER MÁS");
    JLabel textoProducto3 = new JLabel();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
