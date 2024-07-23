/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.soap.services;

import como.soap.models.Task;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author betzy
 */
@WebService
public interface TaskService {
    
    @WebMethod
    Task getTask(int id);

    @WebMethod
    List<Task> getAllTasks();

    @WebMethod
    boolean addTask(Task task);

    @WebMethod
    boolean updateTask(Task task);

    @WebMethod
    boolean deleteTask(int id);
    
}
