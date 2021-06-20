/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matias
 */
public class EmpleadoDAO implements EmpleadoServices {

    public static final String SQL_INSERT = "INSERT INTO empleado (id,nombre,ingreso,departamento) VALUES (?,?,?,?)";
    public static final String SQL_SELECT = "SELECT id, nombre, ingreso FROM empleado";
    public static final String SQL_UPDATE = "UPDATE empleado SET nombre = ?, ingreso = ?, departamento = ? WHERE id = ?";
    public static final String SQL_DELETE = "DELETE FROM empleado WHERE id = ?";
    public static final String SQL_SELECT_BY_ID = "SELECT id, nombre, ingreso, departamento FROM empleado WHERE id = ?";
    /*
    @Override
    public int crear(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setInt(1, empleado.getId());
            pstm.setString(2, empleado.getNombre());
            pstm.setDate(3, empleado.getIngreso());
            pstm.setInt(4, empleado.getDepartamento());
            registros = pstm.executeUpdate();
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }*/

    @Override
    public List<EmpleadoDTO> consultar() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet set = null;
        List<EmpleadoDTO> empleados = new ArrayList<>();
        
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_SELECT);
            set = pstm.executeQuery();
            
            while(set.next()) {
                int id = set.getInt("id");
                String nombre = set.getString("nombre");
                Date ingreso = set.getDate("ingreso");
                //int departamento = set.getInt("departamento");
                EmpleadoDTO empleado = new EmpleadoDTO(id, nombre, ingreso); 
                empleados.add(empleado);
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionDatos.close(set);
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } 
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return empleados;
    }
/*
    @Override
    public int actualizar(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_UPDATE);
            pstm.setInt(1, empleado.getId());
            pstm.setString(2, empleado.getNombre());
            pstm.setDate(3, empleado.getIngreso());
            pstm.setInt(4, empleado.getDepartamento());
            registros = pstm.executeUpdate();
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } 
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
*/
    @Override
    public int borrar(EmpleadoDTO empleado) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        
        try {    
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setInt(1, empleado.getId());
            registros = pstm.executeUpdate();
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } 
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public int crear(EmpleadoDTO empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(EmpleadoDTO empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartamentoDTO consultarPorID(EmpleadoDTO empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
