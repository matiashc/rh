/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
public class ConexionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://54.227.40.221:3306/rh?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Connection con = DriverManager.getConnection(url, "usuariorh", "12345678");
            Statement sentencia = con.createStatement();
            String sql = "SELECT numero, nombre, localizacion FROM departamento";
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                System.out.println("el numero del departamento: " + resultado.getInt("numero"));
                System.out.println("el nombre del departamento: " + resultado.getString("nombre"));
                System.out.println("La localización del departamento: " + resultado.getString("localizacion"));
            } 
            resultado.close();
            sentencia.close();
            con.close();           
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
