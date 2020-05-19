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
public class Tipo_usuarioDto {
    
    private int id_tusuario;
    private String t_usuario;

    public Tipo_usuarioDto() {
    }

    public Tipo_usuarioDto(int id_tusuario, String t_usuario) {
        this.id_tusuario = id_tusuario;
        this.t_usuario = t_usuario;
    }

    public int getId_tusuario() {
        return id_tusuario;
    }

    public void setId_tusuario(int id_tusuario) {
        this.id_tusuario = id_tusuario;
    }

    public String getT_usuario() {
        return t_usuario;
    }

    public void setT_usuario(String t_usuario) {
        this.t_usuario = t_usuario;
    }

    
    
    
}
