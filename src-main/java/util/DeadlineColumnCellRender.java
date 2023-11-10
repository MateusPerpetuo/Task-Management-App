/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author mateus.perpetuo
 */
public class DeadlineColumnCellRender extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column) {
        
        JLabel label; 
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, 
                                                                hasFocus, row, column);
        
        // Customizing
        label.setHorizontalAlignment(CENTER);
        label.setVerticalTextPosition(CENTER);
        
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        
        // Checkin is the Task is late
        if(task.getDeadline().after(new Date())){
            // if is not late the background will be green
            label.setBackground(new Color(0x52CE9E));
            
        } else {
            // If its late it will be colored as red
            label.setBackground(new Color(0xBF6262));
        }           
        return label;
    }    
}
