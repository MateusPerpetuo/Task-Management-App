# Task-Management-App

Project
This document describes a project developed inicialy during a course with some personal implementations that were missing in the course for students to complete as additional study.

The project consists of an application for managing projects and the tasks involved in these projects. The goal is to facilitate the organization and tracking of tasks for one or more projects.

## **Requirements**

The application must offer the following functionalities:

- Create, edit, delete and search projects
- Create, edit, delete and search tasks

## **Business rules**

The following business rules must be followed by the system:

- The system will not have a login system
- There will be no concept of user
- Every task must belong to a project

## **Entities**

The entities involved in the system are:

- Project: has name, tasks, creation date and update date
- Task: has name, description, status, notes, deadline, creation date and update date

### **Known errors**

- Edit Task Screen

On the Edit Task screen, there is a problem loading the data of the selected task. Although the function of updating the data is working correctly, and the project and task ids are being passed from the main screen without errors, it is not possible to fill in the fields of the edit screen with the current information from the database. When trying to do this, the screen displays an error that the project and task ids are null. 

This prevents the user from being able to view the data of the selected task but the user can still modify the task data.


## **Screens**

- Main Sceen with no tasks

  ![image](https://github.com/MateusPerpetuo/Task-Management-App/assets/129229556/676a2fe8-b86e-4a85-83fd-cb01c100057a)

- Main Screen with tasks

  ![image](https://github.com/MateusPerpetuo/Task-Management-App/assets/129229556/c6744e2c-7ed2-4ad9-ba92-e88fd32de23e)

- New Project Screen

  ![image](https://github.com/MateusPerpetuo/Task-Management-App/assets/129229556/98921497-ce03-4389-bf4e-323756f31c84)

- New Task Screen

  ![image](https://github.com/MateusPerpetuo/Task-Management-App/assets/129229556/8e33a7fb-e584-427b-96a7-cd80a1c73e09)

  


     

  

