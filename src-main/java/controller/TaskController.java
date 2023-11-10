/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Task;
import util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mateus.perpetuo
 */
public class TaskController {
    
    // A method to create a new Task
    public void save ( Task task) {
        String sql = "INSERT INTO tasks ( idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishment connection with the database
            connection = ConnectionFactory.getConnection();

            // Preparing the querry
            statement =  connection.prepareStatement(sql);

            // Here the code changes the '?' for the right values to the database
            // by setting the statments
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        }catch (Exception ex){
            throw new RuntimeException(" Erro ao salvar a tarefa"
                        + ex.getMessage(), ex);
        } finally {
            // CLossing connection
            ConnectionFactory.closeConnection(connection , statement);
        }
    }

    // method that save any changes to the Task
    public void update (Task task){
        String sql = "UPDATE tasks SET idProject = ?, " +
                "name = ?, " +
                "description = ?, " +
                "completed = ?, " +
                "notes = ?, " +
                "deadline = ?, " +
                "createdAt = ?, " +
                "updatedAt = ? " +
                "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishment connection with the database
            connection = ConnectionFactory.getConnection();

            // Preparing the querry
            statement =  connection.prepareStatement(sql);

            // Here the code changes the '?' for the right values to the database
            // by setting the statments
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();

        }catch (Exception ex){
            throw new RuntimeException(" Erro ao atualizar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            // Clossing connection
            ConnectionFactory.closeConnection(connection , statement);
        }
    }

    // method that delete the tasks
    public void removeById ( int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishment connection with the database
            connection = ConnectionFactory.getConnection();

            // Preparing the querry
            statement =  connection.prepareStatement(sql);

            // Here the code changes the '?' for the right values to the database
            // by setting the statments values
            statement.setInt(1,taskId);
            statement.execute();
        } catch (Exception ex ){
            throw new RuntimeException("Erro ao deletar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            // Clossing connection
            ConnectionFactory.closeConnection(connection , statement);
        }
    }

    // method that gets all Tasks from a Project  in a list
    public List<Task> getAll (int idProject) {
        String sql = " SELECT * FROM  tasks WHERE idProject = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Task> tasks = new ArrayList<Task>();

        try {
            // Establishment connection with the database
            connection = ConnectionFactory.getConnection();
            // Preparing the querry
            statement =  connection.prepareStatement(sql);

            // Setting the value of the search filter
            statement.setInt(1 , idProject);

            // Value that the query execution returns
            resultSet = statement.executeQuery();

            while (resultSet.next()){

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));

                tasks.add(task);
            }

        } catch (Exception ex ){
            throw new RuntimeException("Erro ao inserir a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            // Clossing connection
            ConnectionFactory.closeConnection(connection , statement, resultSet);
        }
        return tasks;
    }
}
