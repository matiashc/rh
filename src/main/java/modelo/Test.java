/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class Test {
    public static void main(String[] args) {
        DepartamentoServices d = new DepartamentoDAO();
     //   DepartamentoDTO departamento = new DepartamentoDTO(8,"Producción","Bucaramanga");
       // DepartamentoDTO dep = d.consultarPorID(departamento);
      //  System.out.println("nombre: " + dep.getNombre());
//System.out.println(d.crear(departamento));
        //d.borrar(departamento);   
        //d.actualizar(departamento);
        List<DepartamentoDTO> departamentos = new ArrayList<>();
        departamentos = d.consultar();
        for (int i=0; i<departamentos.size(); i++){
            System.out.println("el Departamento es: " + departamentos.get(i).getNombre() + "--" + departamentos.get(i).getLocalizacion());
        }
    }
    
}
