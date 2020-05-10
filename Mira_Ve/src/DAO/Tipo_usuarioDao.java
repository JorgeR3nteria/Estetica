/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Dto.Tipo_usuarioDto;
import Dto.UsuarioDto;
import Interface.CRUD;
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
public class Tipo_usuarioDao implements CRUD<Tipo_usuarioDto>
{
        private static final String INSERTAR = "INSERT INTO tipo_usuario (id_tusuario,t_usuario) VALUES (?,?)";
        private static final String LEER = "SELECT * FROM tipo_usuario WHERE id_tusuario=?";
        private static final String BORRAR = "DELETE FROM tipo_usuario WHERE id_tusuario=?";
        private static final String ACTUALIZAR = "UPDATE tipo_usuario SET t_usuario=? WHERE id_tusuario=?";
        private static final String READALL = "SELECT * FROM tipo_usuario";
        private static final conectar con = conectar.Estado();

    @Override
    public boolean create(Tipo_usuarioDto D)
    {
        PreparedStatement stat;    
            
            try {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_tusuario());
                 stat.setInt(2, D.getT_usuario());
                 
                    if (stat.executeUpdate() > 0) 
                      {
                          return true;
                      }
            } catch (SQLException ex) 
                {
                 Logger.getLogger(Tipo_usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    { // Es una clausula para cerrar la conexion
                      con.cerrar();
                    }
            return false;
    }

    @Override
    public Tipo_usuarioDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        Tipo_usuarioDto t = null;
        
            try 
            {
             stat = con.getConn().prepareStatement(LEER);
             stat.setString(1, key.toString());
             
             res = stat.executeQuery();
             
                while (res.next()) 
                     {
                      t = new Tipo_usuarioDto(res.getInt(1), res.getInt(2));
                     }
                      return t;
            } catch (SQLException ex) 
                {
                 Logger.getLogger(Tipo_usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    {
                        con.cerrar();
                    }
            return t;
    }

    @Override
    public boolean update(Tipo_usuarioDto D) 
    {
        PreparedStatement stat;
        
            try {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getT_usuario());
                 stat.setInt(2, D.getId_tusuario());
                
                    if (stat.executeUpdate() > 0 ) 
                        {
                         return true;
                        }
                    
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally
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
                 
                    if (stat.executeUpdate() >0) 
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally
                        {
                         con.cerrar();
                        }
            return false;
    }

    @Override
    public List<Tipo_usuarioDto> readall() 
    {
        PreparedStatement stat;
        ArrayList<Tipo_usuarioDto> tipo_usuario = new ArrayList();
        ResultSet res;
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                 
                    while (res.next()) 
                        {
                         tipo_usuario.add(new Tipo_usuarioDto(res.getInt(1), res.getInt(2)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                          con.cerrar();
                        }
            return tipo_usuario;
    }
    
}
