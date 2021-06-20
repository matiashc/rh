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
public interface EmpleadoServices {
    public int crear(EmpleadoDTO empleado);
    public List<EmpleadoDTO> consultar();
    public int actualizar(EmpleadoDTO empleado);
    public int borrar(EmpleadoDTO empleado);
    public DepartamentoDTO consultarPorID(EmpleadoDTO empleado);
    
}
