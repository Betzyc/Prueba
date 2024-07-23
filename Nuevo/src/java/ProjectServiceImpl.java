
import com.soap.config.Conexion;
import com.soap.services.ProjectService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author betzy
 */
//@WebService(endpointInterface= "com.soap.services.ProjectService", targetNamespace = "http://my.org/ns/")
@WebService(serviceName = "ProjectServiceImpl", targetNamespace = "http://my.org/ns/")
public class ProjectServiceImpl implements ProjectService{

    @Override
    public String getProjectReport(int projectId) {

        StringBuilder report = new StringBuilder();
        
        try(Connection conn = Conexion.getConnection()){
            String projectQuery = "SELECT * FROM Projectos WHERE id_proyecto = ?";   
            try(PreparedStatement ps = conn.prepareStatement(projectQuery)){
               ps.setInt(1, projectId);
               try(ResultSet rs= ps.executeQuery()){
                   if (rs.next()){
                       report.append("Codigo").append(projectId).append(":\n");
                       report.append("Nombre").append(rs.getString("nombre_proyecto")).append(":\n");
                       report.append("Descripcion").append(rs.getString("descripcion_proyecto")).append(":\n");
                       report.append("Fecha de Inicio").append(rs.getDate("fecha_inicio")).append(":\n");
                       report.append("Fecha de Finalización").append(rs.getDate("fecha_fin")).append(":\n");
                       
                   } else {
                       return "Proyecto no existente";
                   }
               }
            }
            
            String taskQuery = "SELECT * FROM Tareas WHERE Iid_proyecto= ?";
            try(PreparedStatement ps = conn.prepareStatement(taskQuery)){
                   ps.setInt(1, projectId);
                   try(ResultSet rs= ps.executeQuery()){

                       int completedTask = 0;
                       int pendingTask = 0;
                       double totalTime = 0;
                       while(rs.next()){
                           String estado = rs.getString("estado");
                           if ("completada".equals(estado)){
                               completedTask++;
                           } else {
                               pendingTask++;
                           }
                           totalTime += rs.getDouble("tiempo_invertido");
                       }
                           report.append("Tareas completadas").append(completedTask).append(":\n");
                           report.append("Tareas pendientes").append(pendingTask).append(":\n");
                           report.append("Tiempo total invertido").append(totalTime).append(":\n");

                   }
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(ProjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }             
        return report.toString();
        
    }   
}
