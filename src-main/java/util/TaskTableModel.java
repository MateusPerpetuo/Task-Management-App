/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author mateus.perpetuo
 */
    //AbstractTableModel is an implementation of models for tables
public class TaskTableModel extends AbstractTableModel {
    // String withe the columns of the table
    String[] columns = {"Name", "Description", "Deadline", " Task Completed", "Edit", "Delete"};
    
    //List with the tasks database
    List<Task> tasks = new ArrayList();
    
    // Method to display the numbe of lines in the table
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    // Method to display the numbe of columns in the table
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    // Method that displays the correct name of the collumns
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    // Method to enable a editable cell
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
        return columnIndex == 3;
    }
    
    // Method that checks the data type of each cell and returns it in the correct format
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if (tasks.isEmpty()){
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    // Method to enable editing the Check box of the 'isCompleted' column
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }
    
    // Method to determine the value that will be displayed in each column
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                // Process to extract a date string from database, parsing it into a Date object using the specified date format
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).getIsCompleted();
            case 4:
                return "";
            case 5:
                return "";
                
            default:
                return "Data not found";
            
        }
    }
    
    // Getters
    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }
    
    // Setter tasks
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
    
}
