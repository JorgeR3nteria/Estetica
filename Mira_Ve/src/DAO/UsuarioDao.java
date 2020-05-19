/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.UsuarioDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class UsuarioDao implements CRUD<UsuarioDto>
{

        private static final String INSERTAR = "INSERT INTO usuario (id_usuario,id_tusuario,id_empleado,usuario,contraseña) VALUES (?,?,?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM usuario WHERE id_usuario=?";
        private static final String ACTUALIZAR = "UPDATE usuario SET id_tusuario=?,id_empleado=?,usuario=?,contraseña=? WHERE id_usuario=?";
        private static final String BORRAR = "DELETE FROM usuario WHERE id_usuario=?";
        private static final String Login = "SELECT * FROM usuario WHERE usuario=? AND contraseña=?";
        private static final String READALL = "SELECT * FROM usuario";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
        
    @Override
    public boolean create(UsuarioDto D) 
    {
        PreparedStatement stat;    
            try {
                stat = con.getConn().prepareStatement(INSERTAR);
                stat.setInt(1, D.getId_usuario());
                stat.setInt(2, D.getId_tusuario());
                stat.setInt(3, D.getId_empleado());
                stat.setString(4, D.getUsuario());
                stat.setString(5, D.getContraseña());
                 
                if (stat.executeUpdate() >0)
                    {
                     return true;
                    }
                } catch (SQLException ex) 
                       {
                        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                       }finally
                            {
                             con.cerrar();
                            } 
                return false;
    }

    @Override
    public UsuarioDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        UsuarioDto u=null;
            try 
                {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery();
                    
                    while (res.next()) 
                        {                        
                         u = new UsuarioDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5));
                        }
                        return u;
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                            con.cerrar();
                        }
                return u;
                    
    }

    @Override
    public boolean update(UsuarioDto D) 
    {
        PreparedStatement stat;
            try 
               {
                stat = con.getConn().prepareStatement(ACTUALIZAR);
                stat.setInt(1, D.getId_tusuario());
                stat.setInt(2, D.getId_empleado());
                stat.setString(3, D.getUsuario());
                stat.setString(4, D.getContraseña());
                stat.setInt(5, D.getId_usuario());
                
                   if (stat.executeUpdate() > 0) 
                        {
                           return true; 
                        }
               } catch (SQLException ex) 
                    {
                     Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
               return false;
    }

    @Override
    public boolean delete(Object key) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(BORRAR);
                 stat.setString(1, key.toString());
                 
                    if (stat.executeUpdate() > 0) 
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                            con.cerrar();
                        }
                return false;
        
    }

    @Override
    public List<UsuarioDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<UsuarioDto> usuario = new ArrayList();
            try {
                stat = con.getConn().prepareStatement(READALL);
                
                res = stat.executeQuery();
                while (res.next()) 
                    {
                     usuario.add(new UsuarioDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getString(5)));
                    }
                } catch (SQLException ex) 
                        {
                         Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                        }finally 
                            {
                             con.cerrar();
                            }
                return usuario;
            
    }
    
    public static String Login (String usuario, String contraseña) {
        String mensaje=null;
        PreparedStatement stat;
        ResultSet res;
            try {
                 
                 stat = con.getConn().prepareStatement(Login);
                 stat.setString(1, usuario);
                 stat.setString(2, contraseña);
                 res = stat.executeQuery();
                    if (res.next())
                        {
                         mensaje = "Correcto";
                        }else
                            {
                             mensaje="Incorrecto";
                            }
                } catch (SQLException e) 
                    {
                        System.out.println("Error: " + e);
                    } finally
                        {
                            con.cerrar();
                        }
                return mensaje;
     }
    
}
