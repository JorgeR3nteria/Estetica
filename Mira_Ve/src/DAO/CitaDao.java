/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.CitaDto;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jorge
 */
public class CitaDao implements CRUD<CitaDto>
{

        private static final String INSERTAR = "INSERT INTO cita (id_cita,id_cliente,id_servicio,id_empleado,id_prod,f_cita,hora_cita) VALUES (?,?,?,?,?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM cita WHERE id_cita=?";
        private static final String ACTUALIZAR = "UPDATE cita SET id_cliente=?, id_servicio=?, id_empleado=?, id_prod=?, f_cita=?, hora_cita=? WHERE id_cita=?";
        private static final String BORRAR = "DELETE FROM cita WHERE id_cita=?";
        private static final String READALL = "SELECT * FROM cita";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
    @Override
    public boolean create(CitaDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getId_cita());
                 stat.setInt(2, D.getId_cliente());
                 stat.setInt(3, D.getId_servicio());
                 stat.setInt(4, D.getId_empleado());
                 stat.setInt(5, D.getId_prod());
                 stat.setString(6, D.getF_cita());
                 stat.setString(7, D.getHora_cita());
                    if (stat.executeUpdate()>0) 
                            {
                                return true;
                            }
                } catch (SQLException ex) 
                        {
                         Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                        } finally 
                                {
                                 con.cerrar();
                                }
                return false;
    }

    @Override
    public CitaDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        CitaDto cd = null;
            try 
                {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery();
                       while (res.next())
                            {
                                cd = new CitaDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getString(6),res.getString(7));
                            }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return cd;
    }

    @Override
    public boolean update(CitaDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getId_cliente());
                 stat.setInt(2, D.getId_servicio());
                 stat.setInt(3, D.getId_empleado());
                 stat.setInt(4, D.getId_prod());
                 stat.setString(5, D.getF_cita());
                 stat.setString(6, D.getHora_cita());
                 stat.setInt(7, D.getId_cita());
                 if (stat.executeUpdate()>0)
                    {
                     return true;
                    }
                } catch (SQLException ex) 
                        {
                         Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(CitaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return false;
    }

    @Override
    public List<CitaDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<CitaDto> cita = new ArrayList();
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                      while (res.next())
                            {
                             cita.add(new CitaDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getString(6),res.getString(7)));
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
