/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author mateus.perpetuo
 */
public class TextColumnCellRender extends DefaultTableCellRenderer {

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
        
        return label;
    }
}
