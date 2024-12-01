package com.mycompany.tiendaonline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



/**
 *
 * @author Raul
 */

public class ConexionBBDDJson {
    
    public static String url;
    public static String usuario;
    public static String contrasenya; 
    public static Connection conexion;
    
    // Constructor
    
    public ConexionBBDDJson()  throws FileNotFoundException, ParseException, IOException, SQLException{
        
        url = "jdbc:mysql://localhost:3306/tiendaonline";
        usuario = "root";
        contrasenya = "";
        
         try {
  
            conexion = DriverManager.getConnection(url, usuario, contrasenya);
            
            System.out.println("Conexión exitosa a la base de datos!");
            
        } catch (SQLException e) {
            
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            
        }
         
        String checkUserQuery = "SELECT COUNT(*) FROM Usuario";
        
        try (PreparedStatement stmtCheckUser = conexion.prepareStatement(checkUserQuery)) {
            
            ResultSet rs = stmtCheckUser.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                
                // Si ya existen registros, no se ejecuta conectarYLeerJson()
                
                System.out.println("Datos ya existen en la base de datos, no es necesario insertar.");
                
            } else {
                
                // Si no existen datos, procede a insertar los datos del JSON
                
                conectarYLeerJson();
                
            }
        }
         
                 
        
    }
    
    // Clases de JSON y listas que contienen los datos que luego pasamos a la BBDD
    
    private void conectarYLeerJson() throws FileNotFoundException, ParseException, IOException, SQLException{
        
        JSONParser parser = new JSONParser();
        
        FileReader reader = new FileReader("src/main/Resources/tiendaOnline.json");
        
        Object obj = parser.parse(reader);
        
        JSONObject tienda = new JSONObject ((Map) obj);
        
        procesarProductos(tienda);
        
        procesarUsuarios(tienda);
        
    }
    
    // Recorre los el JSON con for each para sacar los productos que después seran añadidos a la base de datos
    
    private void procesarProductos(JSONObject obj) throws SQLException{
        
        JSONObject tiendecita = (JSONObject) obj.get("tienda");
        
        JSONArray arrayCategorias = (JSONArray) tiendecita.get("categorias");
        
        // Para recorrer todas las categorias
        
        for (Object cate : arrayCategorias){
            
            JSONObject categorias = (JSONObject) cate;
            
            JSONArray arrayProductos = (JSONArray) categorias.get("productos");
            
            String nombre = (String) categorias.get("nombre");
                       
            // Para recorrer cada producto dentro de una categoria concreta
            
            for (Object pro : arrayProductos){
                
                JSONObject productos = (JSONObject) pro;
                
                JSONObject caracteristicas = (JSONObject) productos.get("caracteristicas");
                
                JSONArray imagenesArray = (JSONArray) productos.get("imagenes");
                
                // Hacemos el insert de los datos productos del JSON a la tabla correspondiente de MySQL
                
                int idProducto = ((Long) productos.get("id")).intValue();
                
                String nombreProducto = (String) productos.get("nombre");
                
                String descripcion = (String) productos.get("descripcion");
                
                double precio = (Double) productos.get("precio");
                
                int inventario = ((Long) productos.get("inventario")).intValue();
                

                // Para hacer el insert en la BBDD
                
                String sql = "INSERT INTO Producto (id, nombre, descripcion, precio, inventario, categoria_nombre) VALUES (?, ?, ?, ?, ?, ?)";
               
                try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                    
                    stmt.setInt(1, idProducto);
                    
                    stmt.setString(2, nombreProducto);
                    
                    stmt.setString(3, descripcion);
                    
                    stmt.setDouble(4, precio);
                    
                    stmt.setInt(5, inventario);
                    
                    stmt.setString(6, nombre);

                    stmt.executeUpdate();
                    
                    System.out.println("Producto insertado correctamente.");
                    
                } catch (SQLException e) {
                    
                    System.err.println("Error al insertar el producto: " + e.getMessage());
                    
                }
                
                // Recorre las imagenes
                
                for (Object img : imagenesArray){
                    
                    String imagenUrl = (String) img;

                    // Insertamos la imagen en la tabla Imagenes
                    
                    String sqlImagen = "INSERT INTO Imagenes (producto_id, url) VALUES (?, ?)";
                    
                    try (PreparedStatement stmt = conexion.prepareStatement(sqlImagen)) {
                        
                        stmt.setInt(1, idProducto);
                        
                        stmt.setString(2, imagenUrl);

                        stmt.executeUpdate();
                        
                        System.out.println("Imagen insertada correctamente: " + imagenUrl);
                        
                    } catch (SQLException e) {
                        
                        System.err.println("Error al insertar la imagen: " + e.getMessage());
                        
                    }
                    
                }
                
                // Recorre cada caracteristica del producto
                
                for (Object carac : caracteristicas.keySet()){
                    
                    String nombreCaracteristica = (String) carac;
                    
                    String valor = (String) caracteristicas.get(nombreCaracteristica);
                    
                    String sqlCaracteristica = "INSERT INTO Caracteristicas (producto_id, nombre, valor) VALUES (?, ?, ?)";
                    
                    // Y lo guarda en la BBDD
        
                    try (PreparedStatement stmt = conexion.prepareStatement(sqlCaracteristica)) {
                        
                        stmt.setInt(1, idProducto);
                        
                        stmt.setString(2, nombreCaracteristica);
                        
                        stmt.setString(3, valor);
                        
                        stmt.executeUpdate();
                        
                        System.out.println("Característica '" + nombreCaracteristica + "' insertada correctamente.");
                        
                    } catch (SQLException e) {
                        
                        System.err.println("Error al insertar la característica: " + e.getMessage());
                        
                    }
                }
            }
        }
    }
    
    
   private void procesarUsuarios(JSONObject obj) throws SQLException{
       
       JSONObject tiendecita = (JSONObject) obj.get("tienda");
       
       JSONArray arrayUsuarios = (JSONArray) tiendecita.get("usuarios");
       
       // Para recorrer los usuarios
       
       for (Object usu: arrayUsuarios){
        
           JSONObject usuario = (JSONObject) usu;
           
           int idUsuario = ((Long) usuario.get("id")).intValue();
            
           String nombre= (String) usuario.get("nombre");
            
           String email= (String) usuario.get("email");
            
           JSONObject direccion= (JSONObject) usuario.get("direccion");
           
           Object numero = direccion.get("numero");

           // Lo convertimos a String ya que asi está en la base de datos
           String numeroDireccion = String.valueOf(numero);
            
           String sqlUsuario = "INSERT INTO Usuario (id, nombre, email, calle, numero, ciudad, pais) VALUES (?, ?, ?, ?, ?, ?, ?)";
           
            
           // Para insertarlos en la BBDD
            
           try (PreparedStatement stmt = conexion.prepareStatement(sqlUsuario)) {
                    
               stmt.setInt(1, idUsuario);
                    
               stmt.setString(2, nombre);
                    
               stmt.setString(3, email);
                    
               stmt.setString(4, (String) direccion.get("calle"));
                    
               stmt.setString(5, numeroDireccion);
                    
               stmt.setString(6, (String) direccion.get("ciudad"));
                    
               stmt.setString(7, (String) direccion.get("pais"));

               stmt.executeUpdate();
                    
               System.out.println("Usuario insertado correctamente.");
                    
           } catch (SQLException e) {
                    
               System.err.println("Error al insertar el producto: " + e.getMessage());
                    
           } 
           
           JSONArray arrayHistorialCompra = (JSONArray) usuario.get("historialCompras");
           
           // Para recorrer el Historial de Compra
           
           for (Object hc: arrayHistorialCompra){
               
               JSONObject historial = (JSONObject) hc;
               
               int idProducto = ((Long) historial.get("productoId")).intValue();
               
               int idCantidad = ((Long) historial.get("cantidad")).intValue();
               
               String fecha= (String) historial.get("fecha");
               
                java.sql.Date fechaSql = null;
                
               try {
                   
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                   
                    java.util.Date fechaUtil = formato.parse(fecha);
                    
                    fechaSql = new java.sql.Date(fechaUtil.getTime());
                    
                   
               } catch (java.text.ParseException ex) {
                  
                    Logger.getLogger(ConexionBBDDJson.class.getName()).log(Level.SEVERE, null, ex);
                   
               }
               
               String sqlHistorial = "INSERT INTO HistorialCompra (usuario_id, producto_id, cantidad, fecha) VALUES (?, ?, ?, ?)";
               
               // Para insertarlo en la BBDD

               try (PreparedStatement stmt = conexion.prepareStatement(sqlHistorial)) {
                    
                    stmt.setInt(1, idUsuario);

                    stmt.setInt(2, idProducto);

                    stmt.setInt(3, idCantidad);

                    stmt.setDate(4,fechaSql);

                    stmt.executeUpdate();

                    System.out.println("Historial de Compra insertado correctamente.");

                } catch (SQLException e) {

                    System.err.println("Error al insertar el producto: " + e.getMessage());

                }
           }
       }
   } 
}

