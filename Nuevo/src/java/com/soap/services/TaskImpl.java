/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soap.services;

import com.soap.config.Conexion;
import como.soap.models.Task;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author betzy
 */
//@WebService(endpointInterface = "com.example.pmservice.TaskService")
@WebService(serviceName = "ProjectServiceImpl", targetNamespace = "http://my.org/ns/")
public class TaskImpl implements TaskService {
 @Override
    public Task getTask(int id) {
        Task task = null;
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT * FROM tasks WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    task = new Task();
                    task.setIdTarea(rs.getInt("id"));
                    task.setIdProyecto(rs.getInt("project_id"));
                    task.setNombreTarea(rs.getString("name"));
                    task.setDescripcionTarea(rs.getString("description"));
                    task.setEstadoTarea(rs.getString("status"));
                    task.setFechaFin(rs.getDate("due_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = Conexion.getConnection()) {
            String query = "SELECT * FROM tasks";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Task task = new Task();
                    task.setIdTarea(rs.getInt("id"));
                    task.setIdProyecto(rs.getInt("project_id"));
                    task.setNombreTarea(rs.getString("name"));
                    task.setDescripcionTarea(rs.getString("description"));
                    task.setEstadoTarea(rs.getString("status"));
                    task.setFechaFin(rs.getDate("due_date"));
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public boolean addTask(Task task) {
        try (Connection conn =Conexion.getConnection()) {
            String query = "INSERT INTO tasks (project_id, name, description, status, due_date) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, task.getIdProyecto());
                ps.setString(2, task.getNombreTarea());
                ps.setString(3, task.getDescripcionTarea());
                ps.setString(4, task.getEstadoTarea());
                ps.setDate(5, new java.sql.Date(task.getFechaFin().getTime()));
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTask(Task task) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "UPDATE tasks SET project_id = ?, name = ?, description = ?, status = ?, due_date = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, task.getIdProyecto());
                ps.setString(2, task.getNombreTarea());
                ps.setString(3, task.getDescripcionTarea());
                ps.setString(4, task.getEstadoTarea());
                ps.setDate(5, new java.sql.Date(task.getFechaFin().getTime()));
                ps.setInt(6, task.getIdTarea());
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTask(int id) {
        try (Connection conn = Conexion.getConnection()) {
            String query = "DELETE FROM tasks WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
