/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author mateus.perpetuo
 */
public class ButtonColumnCellRender extends DefaultTableCellRenderer{

    private String buttonType;

    public ButtonColumnCellRender(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label; 
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, 
                                                                hasFocus, row, column);
        
        label.setHorizontalAlignment(CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/" + buttonType + ".png")));
        label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        if (buttonType == "edit"){
            label.setToolTipText("Edit this task");
        }
        if (buttonType == "delete"){
            label.setToolTipText("Delete this task");
        }        
        return label;    
    }
 
    
    // Getter and Setters   
    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }    
}
