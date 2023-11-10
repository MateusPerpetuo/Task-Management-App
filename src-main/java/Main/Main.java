/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import controller.ProjectController;
import controller.TaskController;
import java.util.ArrayList;
import model.Project;
import model.Task;
import java.util.Date;
import java.util.List;
/**
 *
 * @author mateus.perpetuo
 */
public class Main {
    
    public static void main(String[] args) {
        
        TaskController taskController= new TaskController();
        Task task = new Task();

               
        task.setIdProject(8);
        task.setId(10);
        
        task.setName("bbbbbbbbbbbbb");
        task.setNotes("bbbbbbbbbbbbbbbbbb");
        task.setDescription("bbbbbbbbbbbb");
        task.setIsCompleted(false);
        task.setUpdatedAt(new Date());
        task.setDeadline(new Date());
        
        taskController.update(task);
        
        System.out.println(task.getName());
        
        
    

        // System.out.println("Testandooooooooooooooo");
        
        
        }
    
}
