/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.NominaDto;
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
public class NominaDao implements CRUD<NominaDto>
{
    
        private static final String INSERTAR = "INSERT INTO nomina (id_nomina,id_empleado,fec_nomina,sueldo) VALUES (?,?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM nomina WHERE id_nomina=?";
        private static final String ACTUALIZAR = "UPDATE nomina SET id_empleado=?, fec_nomina=?, sueldo=? WHERE id_nomina=?";
        private static final String BORRAR = "DELETE FROM nomina WHERE id_nomina=?";
        private static final String READALL = "SELECT * FROM nomina";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
        
    @Override
    public boolean create(NominaDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_nomina());
                 stat.setInt(2, D.getId_empleado());
                 stat.setString(3, D.getFec_nomina());
                 stat.setInt(4, D.getSueldo());
                   if (stat.executeUpdate() >0)
                        {
                         return true;
                        }
                } catch (SQLException ex)   
                    {
                     Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                            con.cerrar();
                        }
                return false;
    }

    @Override
    public NominaDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        NominaDto n = null;
            try 
                {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery();
                     while (res.next())
                        {
                            n = new NominaDto(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4));
                        }
                } catch (SQLException ex)
                    {
                     Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return n;
    }

    @Override
    public boolean update(NominaDto D) 
    {
        PreparedStatement stat;
            try {
                stat = con.getConn().prepareStatement(ACTUALIZAR);
                stat.setInt(1, D.getId_empleado());
                stat.setString(2, D.getFec_nomina());
                stat.setInt(3, D.getSueldo());
                stat.setInt(4, D.getId_nomina());
                if (stat.executeUpdate() > 0) 
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return false;
    }

    @Override
    public List<NominaDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<NominaDto> nomina = new ArrayList();
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                    while (res.next()) 
                        {
                            nomina.add(new NominaDto(res.getInt(1),res.getInt(2),res.getString(3),res.getInt(4)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(NominaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return nomina;
    }
    
}
