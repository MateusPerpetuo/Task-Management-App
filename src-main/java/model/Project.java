/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.invoke.StringConcatFactory;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mateus.perpetuo
 */
public class Project {
    
    private int id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updateAt;

    // Constructor
    public Project(int id, String name, String description, Date createdAt, 
                    Date updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public Project (){ // This constructor set the created at as soon as a new project is created
        this.createdAt = new Date();
        this.updateAt = new Date();
    }
    
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    // Method toString
    @Override
    public String toString(){
       /*     return "Project{" +
            "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}'; */
        
            return this.name;
    }
    
    
}
