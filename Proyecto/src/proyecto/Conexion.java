/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.sql.*;


/**
 *
 * @author Wladimir
 */
public class Conexion {
    
    public Connection Conexion(Connection con) throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=dbEjemplo;user=Wlacho;password=wladimir";
        con = DriverManager.getConnection(connectionURL);
        
        return con;
    }
    
}
