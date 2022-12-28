/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fhr.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author franc
 */
public class DtoAcercaDe {
    @NotBlank
    private String descripcion;

    public DtoAcercaDe() {
    }

    public DtoAcercaDe(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
