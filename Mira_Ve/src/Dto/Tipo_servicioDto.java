/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author jorge
 */
public class Tipo_servicioDto {

    private int id_tservicio;
    private String t_servicio;

    public Tipo_servicioDto(int id_tservicio, String t_servicio) {
        this.id_tservicio = id_tservicio;
        this.t_servicio = t_servicio;
    }

    public int getId_tservicio() {
        return id_tservicio;
    }

    public void setId_tservicio(int id_tservicio) {
        this.id_tservicio = id_tservicio;
    }

    public String getT_servicio() {
        return t_servicio;
    }

    public void setT_servicio(String t_servicio) {
        this.t_servicio = t_servicio;
    }

    
    
    
}
