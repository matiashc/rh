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
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Matias
 */
public class ConexionDatos {
    public static final String JDBC_URL = "jdbc:mysql://18.212.84.93:3306/rh?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String BD_USUARIO = "usuariorh";
    public static final String BD_CLAVE = "12345678";
    
    public static DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(BD_USUARIO);
        bs.setPassword(BD_CLAVE);
        bs.setInitialSize(5);
        return bs;        
    }
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(Connection con) throws SQLException{
        con.close();
    }
    
    public static void close(Statement stm) throws SQLException{
        stm.close();
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();        
    }
    
    public static void close(PreparedStatement pstm) throws SQLException{
      pstm.close();        
    }
    
    
}
