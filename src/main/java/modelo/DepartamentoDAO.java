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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class DepartamentoDAO implements DepartamentoServices {

    public static final String SQL_INSERT = "INSERT INTO departamento (numero,nombre,localizacion) VALUES (?,?,?)";
    public static final String SQL_SELECT = "SELECT numero, nombre, localizacion FROM departamento";
    public static final String SQL_UPDATE = "UPDATE departamento SET nombre = ?, localizacion = ? WHERE numero = ?";
    public static final String SQL_DELETE = "DELETE FROM departamento WHERE numero = ?";
    public static final String SQL_SELECT_BY_ID = "SELECT numero, nombre, localizacion FROM departamento WHERE numero = ?";
    public static final String SQL_CONSULTAR_BY_ID = "SELECT numero, nombre,localizacion FROM departamento WHERE numero = ?";

    @Override
    public int crear(DepartamentoDTO departamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setInt(1, departamento.getNumero());
            pstm.setString(2, departamento.getNombre());
            pstm.setString(3, departamento.getLocalizacion());
            registros = pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public List<DepartamentoDTO> consultar() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet set = null;
        List<DepartamentoDTO> departamentos = new ArrayList();
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_SELECT);
            set = pstm.executeQuery();
            while (set.next()) {
                int numero = set.getInt("numero");
                String nombre = set.getString("nombre");
                String localizacion = set.getString("localizacion");
                DepartamentoDTO departamento = new DepartamentoDTO(numero, nombre, localizacion);
                departamentos.add(departamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(set);
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return departamentos;
    }

    @Override
    public int actualizar(DepartamentoDTO departamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_UPDATE);
            pstm.setString(1, departamento.getNombre());
            pstm.setString(2, departamento.getLocalizacion());
            pstm.setInt(3, departamento.getNumero());
            registros = pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;

    }

    @Override
    public int borrar(DepartamentoDTO departamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        int registros = 0;
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setInt(1, departamento.getNumero());
            registros = pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public DepartamentoDTO consultarPorID(DepartamentoDTO departamento) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet set = null;
        DepartamentoDTO registroDepartamento = null;
        try {
            con = ConexionDatos.getConnection();
            pstm = con.prepareStatement(SQL_SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            pstm.setInt(1, departamento.getNumero());
            set = pstm.executeQuery();
            set.absolute(1);
            int numero = set.getInt("numero");
            String nombre = set.getString("nombre");
            String localizacion = set.getString("localizacion");
            registroDepartamento = new DepartamentoDTO(numero, nombre, localizacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(set);
                ConexionDatos.close(pstm);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registroDepartamento;
    }

    public DepartamentoDTO encontrar(DepartamentoDTO departamento) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionDatos.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID);
            sen.setInt(1, departamento.getNumero());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombre = res.getString("nombre");
            String localizacion = res.getString("localizacion");
            departamento.setNombre(nombre);
            departamento.setLocalizacion(localizacion);            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionDatos.close(res);
                ConexionDatos.close(sen);
                ConexionDatos.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return departamento;

    }

}
