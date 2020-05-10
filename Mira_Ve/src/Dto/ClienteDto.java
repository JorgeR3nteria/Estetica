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
public class ClienteDto {
    
private int id_cliente;
private int documento;
private String nombre;
private String apellido_1;
private String apellido_2;
private Date f_nacimiento;
private String direccion;
private String correo;
private int edad;
private int telefono;

    public ClienteDto(int id_cliente, int documento, String nombre, String apellido_1, String apellido_2, Date f_nacimiento, String direccion, String correo, int edad, int telefono) {
        this.id_cliente = id_cliente;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido_1 = apellido_1;
        this.apellido_2 = apellido_2;
        this.f_nacimiento = f_nacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    

}
