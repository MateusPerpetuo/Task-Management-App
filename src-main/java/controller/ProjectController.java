/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Project;
import util.ConnectionFactory;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mateus.perpetuo
 */
public class ProjectController {
    
    // Method to create a new Project
    public void save (Project project){
        String sql = "INSERT INTO projects (" +
                "name," +
                "description," +
                "createdAT," +
                "updatedAt ) VALUES (?, ?, ?, ?) ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishihment connection with the database
            connection = ConnectionFactory.getConnection();

            //Preparinf the querry
            statement = connection.prepareStatement(sql);

            // Settin the values '?' repleaced by the statements
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.execute();


        } catch (Exception ex){
            throw new RuntimeException("Erro ao salvar o novo Projeto"
                    + ex.getMessage(), ex);
        } finally {

            // CLossing connection
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    // Method to update a Project
    public void update(Project project){
        String sql = "UPDATE projects SET name = ?, " +
                "description = ?, " +
                "createdAt = ?, " +
                "updatedAt = ? " +
                "WHERE id = ?" ;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishihment connection with the database
            connection = ConnectionFactory.getConnection();

            //Preparinf the querry
            statement = connection.prepareStatement(sql);

            // Settin the values '?' repleaced by the statements
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();


        } catch (Exception ex){
            throw new RuntimeException("Erro ao atualizar o Projeto"
                    + ex.getMessage(), ex);
        } finally {

            // Clossing connection
            ConnectionFactory.closeConnection(connection, statement);
        }



    }

    // Method to delete a Project
    public void removeById (int id) {
        String sql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishihment connection with the database
            connection = ConnectionFactory.getConnection();

            //Preparinf the querry
            statement = connection.prepareStatement(sql);

            // Settin the values '?' repleaced by the statements
            statement.setInt(1, id);
            statement.execute();


        } catch (Exception ex){
            throw new RuntimeException("Erro ao excluir o Projeto"
                    + ex.getMessage(), ex);
        } finally {
            // Clossing connection
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    // Method to get all Projects in a list
    public List<Project> getALL () {
        String sql = "SELECT * FROM projects";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {
            // Establishment connection with the database
            connection = ConnectionFactory.getConnection();

            // Preparing the carry
            statement = connection.prepareStatement(sql);

            // Value that tge query execution returns
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                 Project project = new Project();
                 project.setId(resultSet.getInt("id"));
                 project.setName(resultSet.getString("name"));
                 project.setDescription(resultSet.getString("description"));
                 project.setCreatedAt(resultSet.getDate("createdAt"));
                 project.setUpdateAt(resultSet.getDate("updatedAt"));

                 projects.add(project);

            }

        } catch (Exception ex ){
            throw new RuntimeException("Erro ao buscar os projetos"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection (connection , statement, resultSet);
        }
        return projects;
    }
    
    
}
