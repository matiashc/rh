/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Matias
 */
public class EmpleadoDTO {
    private int id;
    private String nombre;
    private Date ingreso;
    private DepartamentoDTO deparatamento;

    public EmpleadoDTO(int id, String nombre, Date ingreso, DepartamentoDTO deparatamento) {
        this.id = id;
        this.nombre = nombre;
        this.ingreso = ingreso;
        this.deparatamento = deparatamento;
    }

    public EmpleadoDTO(int id, String nombre, Date ingreso) {
        this.id = id;
        this.nombre = nombre;
        this.ingreso = ingreso;
    }

    

    
    public EmpleadoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public DepartamentoDTO getDeparatamento() {
        return deparatamento;
    }

    public void setDeparatamento(DepartamentoDTO deparatamento) {
        this.deparatamento = deparatamento;
    }

    
    
    
    
    
    
}
