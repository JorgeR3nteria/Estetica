/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.sql.Date;

/**
 *
 * @author jorge
 */
public class NominaDto {

    private int id_nomina;
    private int id_empleado;
    private Date fec_nomina;
    private int sueldo;

    public NominaDto(int id_nomina, int id_empleado, Date fec_nomina, int sueldo) {
        this.id_nomina = id_nomina;
        this.id_empleado = id_empleado;
        this.fec_nomina = fec_nomina;
        this.sueldo = sueldo;
    }

    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFec_nomina() {
        return fec_nomina;
    }

    public void setFec_nomina(Date fec_nomina) {
        this.fec_nomina = fec_nomina;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    
    
    
    
}
