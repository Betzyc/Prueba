/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package como.soap.models;

import java.util.Date;

/**
 *
 * @author betzy
 */
public class Task {
    
    private int idTarea;
    private int idProyecto;
    private String nombreTarea;
    private String DescripcionTarea;
    private Date fechaFin;
    private String estadoTarea;

    public Task(int idTarea, int idProyecto, String nombreTarea, String DescripcionTarea, Date fechaFin, String estadoTarea) {
        this.idTarea = idTarea;
        this.idProyecto = idProyecto;
        this.nombreTarea = nombreTarea;
        this.DescripcionTarea = DescripcionTarea;
        this.fechaFin = fechaFin;
        this.estadoTarea = estadoTarea;
    }

    public Task() {
        
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcionTarea() {
        return DescripcionTarea;
    }

    public void setDescripcionTarea(String DescripcionTarea) {
        this.DescripcionTarea = DescripcionTarea;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

}
