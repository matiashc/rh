/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Matias
 */
public class DepartamentoDTO {
    private int numero;
    private String nombre;
    private String localizacion;

    public DepartamentoDTO(int numero, String nombre, String localizacion) {
        this.numero = numero;
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(int numero) {
        this.numero = numero;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    
    
    
    
}
