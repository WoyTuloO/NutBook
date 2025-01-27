/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.woytuloo.accountingapp.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author wojte
 */
public class Menu extends JComponent {
    private int autoindex;
    private MenuEvent event;
    private MigLayout layout;
    private String[][] menuItems = new String [][]{
        {"Panel główny"},
        {"Faktury","Nowa Faktura", "Nowy szablon"},
        {"Archiwum"}
 
        };
    
    public Menu(){
        init();
    }
    
    private void init(){
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);
        for(int i= 0; i < menuItems.length; i++){
            addMenu(menuItems[i][0],i);
        }   
    }
    
    
    private void addMenu(String name, int index){        
        MenuItem item = new MenuItem(name, index, menuItems[index].length > 1);

        item.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(menuItems[index].length > 1){
                        if(!item.isSelected()){
                            item.setSelected(true);
                            addSubMenu(item, index, menuItems[index].length, getComponentZOrder(item));
                        }
                        else{
                            item.setSelected(false);
                            hideSubMenu(item, index);
                        }
                    }else{
                        if(getEvent() != null){
                            getEvent().selected(index, 0);
                        }
                    }
                }
        });
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int len, int zOrder){
        JPanel p = new JPanel(new MigLayout("wrap 1, fillx, gapy 0, inset 0", "fill"));
        p.setOpaque(false);
        p.setName(index + "");
        
        for(int i = 1; i< len; i++){
            MenuItem sub = new MenuItem(menuItems[index][i],i,false);
            sub.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(getEvent()!=null){
                        getEvent().selected(index, sub.getIndex());
                    }
                }
            });
            sub.initSubMenu(i, len);
            p.add(sub);
        }
        add(p, zOrder+1);
        revalidate();
}

    private void hideSubMenu(MenuItem item, int index){
        for(Component c : getComponents()){
            if(c instanceof JPanel && c.getName() != null && c.getName().equals(index + "")){
                remove(c);
                break;          
            }
        }
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(30,40,60));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }

    /**
     * @return the event
     */
    public MenuEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(MenuEvent event) {
        this.event = event;
    }
    
    
    
    
    
    
}
