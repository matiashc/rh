/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DepartamentoDAO;
import modelo.DepartamentoDTO;

/**
 *
 * @author Matias
 */
@WebServlet("/departamento")
public class DepartamentoController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "borrar":
                    this.borrar(req, resp);
                    break;
                case "editar":
                    this.editar(req, resp);
                    break;
                default: 
                    this.listarDepartamentos(req, resp);
            }
        }
        else
            this.listarDepartamentos(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "crear":
                    this.crear(req, resp);
                    break;
                case "modificar":
                    this.modificar(req, resp);
                    break;
                default:
                    this.listarDepartamentos(req, resp);
            }
        }
        else
            this.listarDepartamentos(req, resp);

    }

    private void listarDepartamentos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartamentoDAO dDAO = new DepartamentoDAO();
        List<DepartamentoDTO> departamentos = dDAO.consultar();
        req.setAttribute("departamentos", departamentos);
        req.getRequestDispatcher("departamento/verdepartamento.jsp").forward(req, resp);
    }

    private void crear(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int numero = Integer.parseInt(req.getParameter("numero"));
        String nombre = req.getParameter("nombre");
        String localizacion = req.getParameter("localizacion");
        DepartamentoDTO departamento = new DepartamentoDTO(numero, nombre, localizacion);
        int registros = new DepartamentoDAO().crear(departamento);
        this.listarDepartamentos(req, resp);

    }
    
    private void borrar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int numero = Integer.parseInt(req.getParameter("numero"));
        int registro = new DepartamentoDAO().borrar(new DepartamentoDTO(numero));
        this.listarDepartamentos(req, resp);        
    }
    
     private void editar(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        int numero = Integer.parseInt(req.getParameter("numero"));
        DepartamentoDTO departamentoDto = new DepartamentoDAO().consultarPorID(new DepartamentoDTO(numero));
        req.setAttribute("departamentodto", departamentoDto);
        req.getRequestDispatcher("departamento/editardepartamento.jsp").forward(req, resp);
        
    }
     
     private void modificar(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        int numero = Integer.parseInt(req.getParameter("numero"));
        String nombre = req.getParameter("nombre");
        String localizacion = req.getParameter("localizacion");
        DepartamentoDTO departamento = new DepartamentoDTO(numero, nombre, localizacion);
       int registros = new DepartamentoDAO().actualizar(departamento);     
       this.listarDepartamentos(req, resp);
    }
            
}
