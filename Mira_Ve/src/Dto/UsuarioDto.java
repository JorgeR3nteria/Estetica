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
public class UsuarioDto {
    private int id_usuario;
    private int id_tusuario;
    private int id_empleado;
    private String usuario;
    private String contraseña;

    public UsuarioDto(int id_usuario, int id_tusuario, int id_empleado, String usuario, String contraseña) {
        this.id_usuario = id_usuario;
        this.id_tusuario = id_tusuario;
        this.id_empleado = id_empleado;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tusuario() {
        return id_tusuario;
    }

    public void setId_tusuario(int id_tusuario) {
        this.id_tusuario = id_tusuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
