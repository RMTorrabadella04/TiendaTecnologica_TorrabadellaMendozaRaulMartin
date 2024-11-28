/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Raul
 */

// Esta clase se encarga de redondear los bordes a los Panel, simplemente para que quede más bonito

class RoundedPanel extends JPanel {
        
        // Tamaño del radio
        private int radius;

        public RoundedPanel(int radio) {
           
            this.radius=radio;
            setOpaque(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Suavizado de bordes
            g2d.setColor(getBackground());                                                                        // Establecer el color de fondo
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);         // Dibujar rectángulo con bordes redondeados
        }
    }
