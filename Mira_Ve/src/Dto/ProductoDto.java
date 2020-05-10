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
public class ProductoDto {
    private int id_prod;
    private String nom_prod;
    private String descripcion;
    private int vlr_prod;

    public ProductoDto(int id_prod, String nombre_prod, String descripcion, int vlr_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.descripcion = descripcion;
        this.vlr_prod = vlr_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVlr_prod() {
        return vlr_prod;
    }

    public void setVlr_prod(int vlr_prod) {
        this.vlr_prod = vlr_prod;
    }

    
}
