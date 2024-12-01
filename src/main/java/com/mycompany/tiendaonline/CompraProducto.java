package com.mycompany.tiendaonline;


import static com.mycompany.tiendaonline.ConexionBBDDJson.conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
/**
 *
 * @author Raul
 */
public class CompraProducto extends javax.swing.JFrame {

    public CompraProducto() {
        
    }
    
    public CompraProducto(String producto) {
        produ = producto;
        initComponents();   
        
        setTitle(producto);
        setSize(1370, 790);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        productoFondo.setBackground(new Color(156, 156, 156));    
        productoFondo.setBounds(750, 50, 550, 650);
        productoFondo.setLayout(new BorderLayout());
        
        this.jPanel1.add(productoFondo);
        
        // En caso de no haber iniciado sesion no estará disponible el uso del boton compra
        if (SesionIniciada.getInstance().isIniciado()){
            BotonCompra.setEnabled(true);
        }else{
            BotonCompra.setEnabled(false);
        }
        
        traerProducto();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonCompra = new javax.swing.JButton();
        TextoTitulo = new javax.swing.JLabel();
        TextoPrecio = new javax.swing.JLabel();
        TextoDescripcion1 = new javax.swing.JLabel();
        TextoCaracteristica1 = new javax.swing.JLabel();
        TextoCaracteristicas1 = new javax.swing.JLabel();
        TextoCaracteristica2 = new javax.swing.JLabel();
        TextoInventario = new javax.swing.JLabel();
        TextoCaracteristica3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BotonCompra.setBackground(new java.awt.Color(102, 102, 102));
        BotonCompra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BotonCompra.setForeground(new java.awt.Color(255, 255, 255));
        BotonCompra.setText("COMPRAR");
        BotonCompra.setBorder(null);
        BotonCompra.setBorderPainted(false);
        BotonCompra.setDefaultCapable(false);
        BotonCompra.setFocusPainted(false);
        BotonCompra.setFocusable(false);
        BotonCompra.setRequestFocusEnabled(false);
        BotonCompra.setRolloverEnabled(false);
        BotonCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCompraActionPerformed(evt);
            }
        });

        TextoTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        TextoPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextoPrecio.setText("Precio:");

        TextoDescripcion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextoDescripcion1.setText("Descripción:");

        TextoCaracteristica1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TextoCaracteristicas1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextoCaracteristicas1.setText("Caracteristicas:");

        TextoCaracteristica2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TextoInventario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TextoInventario.setText("Inventario: ");

        TextoCaracteristica3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextoDescripcion1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                            .addComponent(TextoCaracteristicas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(687, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextoCaracteristica2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextoCaracteristica1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                            .addComponent(TextoCaracteristica3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextoInventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(TextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoDescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoCaracteristicas1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoCaracteristica1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoCaracteristica2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextoCaracteristica3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(BotonCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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

    private void traerProducto(){
        
         String query = "SELECT p.id, p.nombre, p.descripcion, p.precio, p.inventario, p.categoria_nombre, " +
                       "c.nombre AS caracteristica_nombre, c.valor AS caracteristica_valor " +
                       "FROM producto p " +
                       "LEFT JOIN caracteristicas c ON p.id = c.producto_id " +
                       "WHERE p.nombre = ?;";
         
        try (PreparedStatement pst = conexion.prepareStatement(query)){

            pst.setString(1, produ);
            ResultSet rs = pst.executeQuery();
            
            int id = 0;
            String nombre = null;
            String descripcion = null;
            double precio = 0.0;
            int inventario = 0;
            String categoriaNombre = null;
            
            ArrayList<String> caracteristicas = new ArrayList<>();
            
            while (rs.next()) {
                if (id == 0) {  // Si aún no hemos asignado los datos del producto
                    id = rs.getInt("id");
                    nombre = rs.getString("nombre");
                    descripcion = rs.getString("descripcion");
                    precio = rs.getDouble("precio");
                    inventario = rs.getInt("inventario");
                    categoriaNombre = rs.getString("categoria_nombre");
                    
                    TextoTitulo.setText("<html>" +
                                    categoriaNombre + "<br><br>" + 
                                    nombre +  
                                    "</html>");
                    TextoDescripcion1.setText("Descripcion: "+descripcion);
                    TextoPrecio.setText("Precio: "+precio);

                    TextoInventario.setText("Inventario: "+ inventario);
                    
                    // Para obtener las imágenes relacionadas con el producto
                    
                    imgUrlArray.clear();

                    
                    String sql = "SELECT url " +
                                 "FROM Imagenes " +
                                 "WHERE producto_id = ?;";

                    try (PreparedStatement pst2 = conexion.prepareStatement(sql)) {
                        pst2.setInt(1, id);
                        ResultSet rs2 = pst2.executeQuery();

                        // Añadir todas las URLs de imágenes al ArrayList
                        while (rs2.next()) {
                            String url = rs2.getString("url");
                            imgUrlArray.add(url);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    String url = imgUrlArray.get(random.nextInt(imgUrlArray.size()));
                    
                    ImageIcon imagen = new ImageIcon(url);
                    Image image = imagen.getImage();
                    imagen = new ImageIcon(image); 

                    JLabel imagenProducto = new JLabel(imagen);

                    imagenProducto.setHorizontalAlignment(SwingConstants.CENTER);
                    productoFondo.add(imagenProducto, BorderLayout.CENTER);
                }

                // Obtener las características del producto
                String caracteristicaNombre = rs.getString("caracteristica_nombre");
                String caracteristicaValor = rs.getString("caracteristica_valor");

                if (caracteristicaNombre != null && caracteristicaValor != null) {
                    caracteristicas.add(caracteristicaNombre + ": " + caracteristicaValor);
                }
            }
            
            int c = 1;
            
            for (String caracteristica : caracteristicas) {
                
                switch (c) {
                    case 1:
                        TextoCaracteristica1.setText("       - "+caracteristica);
                        break;
                    case 2:
                        TextoCaracteristica2.setText("       - "+caracteristica);
                        break;
                    case 3:
                        TextoCaracteristica3.setText("       - "+caracteristica);
                        break;
                        
                }
                c++;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void BotonCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCompraActionPerformed
        
        int usuarioId = obtenerUsuarioId();
        int productoId = obtenerProductoIdeInventario(produ);
        int cantidad = 0;
        
        do{
            String cantidadStr = JOptionPane.showInputDialog("Dime la cantidad de productos que vas a comprar:");
         
            try {
                // Convierte la cadena a un entero
                cantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException e) {
                // Si ocurre una excepción, significa que no se ingresó un número válido
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }        
        }while(cantidad < 0 || cantidad>inventario);
        
        int inventarioRestante = inventario - cantidad;
        
        if (usuarioId != -1 && productoId != -1) {
            // Obtenemos la fecha actual
            java.sql.Date fechaCompra = new java.sql.Date(System.currentTimeMillis());

            String query = "INSERT INTO HistorialCompra (usuario_id, producto_id, cantidad, fecha) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pst = conexion.prepareStatement(query)) {
                pst.setInt(1, usuarioId);      
                pst.setInt(2, productoId);     
                pst.setInt(3, cantidad);       
                pst.setDate(4, fechaCompra);   

                // Ejecutar el INSERT
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Compra registrada correctamente.");
                } else {
                    System.out.println("Error al registrar la compra.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo encontrar el usuario o el producto.");
        }
        
        String sql = "UPDATE producto SET inventario = ? WHERE id = ?";
        
         try (PreparedStatement pst = conexion.prepareStatement(sql)) {
             
             pst.setInt(1, inventarioRestante);
             pst.setInt(2, productoId); 
             pst.executeUpdate();
             
         } catch (SQLException ex) {
            Logger.getLogger(CompraProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
         traerProducto();
    }//GEN-LAST:event_BotonCompraActionPerformed
    
        private int obtenerUsuarioId() {
        
        String query = "SELECT id FROM Usuario WHERE email = ?"; 
        
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            
            pst.setString(1, SesionIniciada.getEmail());
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("id");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 si no se encuentra el usuario
    }

    private int obtenerProductoIdeInventario(String nombreProducto) {
        
        String query = "SELECT id, inventario FROM Producto WHERE nombre = ?";
        
        try (PreparedStatement pst = conexion.prepareStatement(query)) {
            
            pst.setString(1, nombreProducto);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                inventario = rs.getInt("inventario");
                return id;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1; // Retorna -1 si no se encuentra el producto
    }
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompraProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraProducto().setVisible(true);
            }
        });
    }
    
        
    Random random = new Random();
    ArrayList<String> imgUrlArray = new ArrayList();
    int inventario;
    String produ;
    RoundedPanel productoFondo = new RoundedPanel(15);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCompra;
    private javax.swing.JLabel TextoCaracteristica1;
    private javax.swing.JLabel TextoCaracteristica2;
    private javax.swing.JLabel TextoCaracteristica3;
    private javax.swing.JLabel TextoCaracteristicas1;
    private javax.swing.JLabel TextoDescripcion1;
    private javax.swing.JLabel TextoInventario;
    private javax.swing.JLabel TextoPrecio;
    private javax.swing.JLabel TextoTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
