/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

import java.sql.Date;

/**
 *
 * @author Raul
 */
public class Compra {
    private int usuarioId;
    private int productoId;
    private String productoNombre;
    private String productoUrl;
    private int cantidad;
    private Date fecha;

    // Constructor
    public Compra(int usuarioId, int productoId, String productoNombre, String productoUrl, int cantidad, Date fecha) {
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.productoNombre = productoNombre;
        this.productoUrl = productoUrl;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Métodos getter
     public int getUsuarioId() {
        return usuarioId;
    }
    
    public int getProductoId() {
        return productoId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public String getProductoUrl() {
        return productoUrl;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }
}

