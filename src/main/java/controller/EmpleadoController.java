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
import modelo.EmpleadoDAO;
import modelo.EmpleadoDTO;

/**
 *
 * @author Matias
 */
@WebServlet("/empleado")
public class EmpleadoController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        listarEmpleados(req,resp);
        
    }
    
    private void listarEmpleados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpleadoDAO dDAO = new EmpleadoDAO();
        List<EmpleadoDTO> empleados = dDAO.consultar();
        req.setAttribute("empleados", empleados);
        req.getRequestDispatcher("empleado/verempleado.jsp").forward(req, resp);
    }
    
}
