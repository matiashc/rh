/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Matias
 */
public interface DepartamentoServices {
    public int crear(DepartamentoDTO departamento);
    public List<DepartamentoDTO> consultar();
    public int actualizar(DepartamentoDTO departamento);
    public int borrar(DepartamentoDTO departaento);
    public DepartamentoDTO consultarPorID(DepartamentoDTO departamento);
    
}
