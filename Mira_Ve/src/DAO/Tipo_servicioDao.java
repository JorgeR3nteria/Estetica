/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Dto.Tipo_servicioDto;
import Dto.Tipo_usuarioDto;
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
public class Tipo_servicioDao implements CRUD<Tipo_servicioDto>{
    
        private static final String INSERTAR = "INSERT INTO tipo_servicio (id_tservicio,t_servicio) VALUES (?,?)";
        private static final String LEER = "SELECT * FROM tipo_servicio WHERE id_tservicio=?";
        private static final String BORRAR = "DELETE FROM tipo_servicio WHERE id_tservicio=?";
        private static final String ACTUALIZAR = "UPDATE tipo_servicio SET t_servicio=? WHERE id_tservicio=?";
        private static final String READALL = "SELECT * FROM tipo_servicio";
        private static final conectar con = conectar.Estado();

    @Override
    public boolean create(Tipo_servicioDto D) 
    {
        PreparedStatement stat;    
            
            try {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_tservicio());
                 stat.setString(2, D.getT_servicio());
                 
                    if (stat.executeUpdate() > 0) 
                      {
                          return true;
                      }
            } catch (SQLException ex) 
                {
                 Logger.getLogger(Tipo_servicioDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    { // Es una clausula para cerrar la conexion
                      con.cerrar();
                    }
            return false;
    }

    @Override
    public Tipo_servicioDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        Tipo_servicioDto t = null;
        
            try 
            {
             stat = con.getConn().prepareStatement(LEER);
             stat.setString(1, key.toString());
             
             res = stat.executeQuery();
             
                while (res.next()) 
                     {
                      t = new Tipo_servicioDto(res.getInt(1), res.getString(2));
                     }
                      return t;
            } catch (SQLException ex) 
                {
                 Logger.getLogger(Tipo_servicioDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    {
                     con.cerrar();
                    }
            return t;
    }

    @Override
    public boolean update(Tipo_servicioDto D) 
    {
        PreparedStatement stat;
        
            try {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setString(1, D.getT_servicio());
                 stat.setInt(2, D.getId_tservicio());
                
                    if (stat.executeUpdate() > 0 ) 
                        {
                         return true;
                        }
                    
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_servicioDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(Tipo_servicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally
                        {
                         con.cerrar();
                        }
            return false;
    }

    @Override
    public List<Tipo_servicioDto> readall() 
    {
        PreparedStatement stat;
        ArrayList<Tipo_servicioDto> tipo_servicio = new ArrayList();
        ResultSet res;
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                 
                    while (res.next()) 
                        {
                         tipo_servicio.add(new Tipo_servicioDto(res.getInt(1), res.getString(2)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_servicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                          con.cerrar();
                        }
            return tipo_servicio;
    }
    
}
