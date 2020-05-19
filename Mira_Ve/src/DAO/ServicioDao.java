/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.ServicioDto;
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
public class ServicioDao implements CRUD<ServicioDto>
{
        private static final String INSERTAR = "INSERT INTO servicio (id_servicio,id_tservicio,descripcion) VALUES (?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM servicio WHERE id_servicio=?";
        private static final String ACTUALIZAR = "UPDATE servicio SET id_tservicio=?, descripcion=? WHERE id_servicio=?";
        private static final String BORRAR = "DELETE FROM servicio WHERE id_servicio=?";
        private static final String READALL = "SELECT * FROM servicio";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
        
    @Override
    public boolean create(ServicioDto D) 
    {
        PreparedStatement stat;
                
            try 
                {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_servicio());
                 stat.setInt(2, D.getId_tservicio());
                 stat.setString(3, D.getDescripcion());
                 if (stat.executeUpdate() > 0) 
                    {
                     return true;
                    }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return false;
    }

    @Override
    public ServicioDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        ServicioDto s=null;
            try 
                {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery();
                    while (res.next()) 
                        { 
                         s = new ServicioDto(res.getInt(1),res.getInt(2),res.getString(3));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return s;
    }

    @Override
    public boolean update(ServicioDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getId_tservicio());
                 stat.setString(2, D.getDescripcion());
                 stat.setInt(3, D.getId_servicio());
                    if (stat.executeUpdate() > 0) 
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally 
                         {
                            con.cerrar();
                         }
                return false;
                        
    }

    @Override
    public List<ServicioDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<ServicioDto> servicio = new ArrayList();
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                
                 res = stat.executeQuery();
                    while (res.next()) 
                        {
                         servicio.add(new ServicioDto(res.getInt(1),res.getInt(2),res.getString(3)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ServicioDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                         con.cerrar();
                        }
                return servicio;
    }
    
}
