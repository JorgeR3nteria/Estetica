/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author jorge
 */
public class CitaDto {

    private int id_cita;
    private int id_cliente;
    private int id_servicio;
    private int id_empleado;
    private int id_prod;
    private String f_cita;
    private String hora_cita;

   
    //Constructor con parametros

    public CitaDto() {
    }

    public CitaDto(int id_cita, int id_cliente, int id_servicio, int id_empleado, int id_prod, String f_cita, String hora_cita) {
        this.id_cita = id_cita;
        this.id_cliente = id_cliente;
        this.id_servicio = id_servicio;
        this.id_empleado = id_empleado;
        this.id_prod = id_prod;
        this.f_cita = f_cita;
        this.hora_cita = hora_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getF_cita() {
        return f_cita;
    }

    public void setF_cita(String f_cita) {
        this.f_cita = f_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }
    
    
    
    
    
    
}
