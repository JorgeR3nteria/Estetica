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
public class FacturaDto {

    private int id_factura;
    private int id_cita;
    private int id_servicio;
    private int id_prod;
    private String fec_factura;
    private int vlr_tipo_servicio;

    public FacturaDto() {
    }

    public FacturaDto(int id_factura, int id_cita, int id_servicio, int id_prod, String fec_factura, int vlr_tipo_servicio) {
        this.id_factura = id_factura;
        this.id_cita = id_cita;
        this.id_servicio = id_servicio;
        this.id_prod = id_prod;
        this.fec_factura = fec_factura;
        this.vlr_tipo_servicio = vlr_tipo_servicio;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getFec_factura() {
        return fec_factura;
    }

    public void setFec_factura(String fec_factura) {
        this.fec_factura = fec_factura;
    }

    public int getVlr_tipo_servicio() {
        return vlr_tipo_servicio;
    }

    public void setVlr_tipo_servicio(int vlr_tipo_servicio) {
        this.vlr_tipo_servicio = vlr_tipo_servicio;
    }
    
}
