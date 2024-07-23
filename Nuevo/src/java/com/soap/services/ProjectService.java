/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.soap.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author betzy
 */
@WebService
public interface ProjectService {
    
    @WebMethod
    String getProjectReport(int projectId);
    
}
