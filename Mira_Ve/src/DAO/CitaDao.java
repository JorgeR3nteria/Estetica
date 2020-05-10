/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Dto.CitaDto;
import Dto.NominaDto;
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
public class CitaDao implements CRUD<CitaDto>
{
        private static final String INSERTAR = "INSERT INTO cita (id_cita,id_cliente,id_servicio,id_empleado,id_prod,f_cita,hora_cita) VALUES (?,?,?,?,?,?,?)";
        private static final String LEER = "SELECT * FROM cita WHERE id_cita=?";
        private static final String BORRAR = "DELETE FROM cita WHERE id_cita=?";
        private static final String ACTUALIZAR = "UPDATE cita SET id_cliente=?, id_servicio=?, id_empleado=?, id_prod=?, f_cita=?,hora_cita=? WHERE id_cita=?";
        private static final String READALL = "SELECT * FROM cita";
        private static final conectar con = conectar.Estado();
        
    @Override
    public boolean create(CitaDto D) 
    {
        PreparedStatement stat;    
            
            try {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_cita());
                 stat.setInt(2, D.getId_cliente());
                 stat.setInt(3, D.getId_servicio());
                 stat.setInt(4, D.getId_empleado());
                 stat.setInt(5, D.getId_prod());
                 stat.setDate(6, D.getF_cita());
                 stat.setString(7, D.getHora_cita());
                 
                    if (stat.executeUpdate() > 0) 
                      {
                          return true;
                      }
            } catch (SQLException ex) 
                {
                 Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    { // Es una clausula para cerrar la conexion
                      con.cerrar();
                    }
            return false;        
    }

    @Override
    public CitaDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        CitaDto ci = null;
        
            try 
            {
             stat = con.getConn().prepareStatement(LEER);
             stat.setString(1, key.toString());
             
             res = stat.executeQuery();
             
                while (res.next()) 
                     {
                      ci = new CitaDto(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getDate(6), res.getString(7));
                     }
                      return ci;
            } catch (SQLException ex) 
                {
                 Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    {
                     con.cerrar();
                    }
            return ci;
    }

    @Override
    public boolean update(CitaDto D) 
    {
        PreparedStatement stat;
        
            try {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getId_cliente());
                 stat.setInt(2, D.getId_servicio());
                 stat.setInt(3, D.getId_empleado());
                 stat.setInt(4, D.getId_prod());
                 stat.setDate(5, D.getF_cita());
                 stat.setString(3, D.getHora_cita());
                 stat.setInt(4, D.getId_cita());
                
                    if (stat.executeUpdate() > 0 ) 
                        {
                         return true;
                        }
                    
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally
                        {
                         con.cerrar();
                        }
            return false;
    }

    @Override
    public List<CitaDto> readall() 
    {
        PreparedStatement stat;
        ArrayList<CitaDto> cita = new ArrayList();
        ResultSet res;
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                 
                    while (res.next()) 
                        {
                         cita.add(new CitaDto(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getDate(6), res.getString(7)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                          con.cerrar();
                        }
            return cita;
    }
    
}
