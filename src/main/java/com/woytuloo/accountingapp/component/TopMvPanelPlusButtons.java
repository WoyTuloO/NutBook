/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.woytuloo.accountingapp.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author wojte
 */
public class TopMvPanelPlusButtons extends javax.swing.JPanel {

    /**
     * Creates new form TopMvPanelPlusButtons
     */
    public TopMvPanelPlusButtons() {
        initComponents();
        
    }
    
    private int x,y;
    
    
    public void initMv(JFrame f){
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                x = me.getX();
                y = me.getY();
                
            }
        
        });
        
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                int newX = me.getXOnScreen() - x;        //  -14 - to cancel out the horizontal movement when frame is decorated
                int newY = me.getYOnScreen() - y;       //  -31 - to cancel out the vertical movement when frame is decorated
                f.setLocation(newX, newY);

            }
        });
    }

    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(30, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
