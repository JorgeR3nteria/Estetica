/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jorge
 */
public class ServicioDto {
    
    private int id_servicio;
    private int id_tservicio;
    private String descripcion;

    public ServicioDto() {
    }

    
    public ServicioDto(int id_servicio, int id_tservicio, String descripcion) {
        this.id_servicio = id_servicio;
        this.id_tservicio = id_tservicio;
        this.descripcion = descripcion;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_tservicio() {
        return id_tservicio;
    }

    public void setId_tservicio(int id_tservicio) {
        this.id_tservicio = id_tservicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
