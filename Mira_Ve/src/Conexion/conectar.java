
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class conectar 
{
    public static conectar instance; //Me va a servir para el singleton
    private static Connection conn; 
            
    private conectar() throws SQLException
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estetica?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) 
            {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     public synchronized static conectar Estado()
       {
           if (instance ==null)
            {
               try {
                   instance = new conectar();
               } catch (SQLException ex) {
                   Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            return instance;
       }

    public static Connection getConn() {
        return conn;
    }
     
         public void cerrar(){
             instance = null;
         }
    }
