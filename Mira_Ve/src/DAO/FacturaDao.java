/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.FacturaDto;
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
public class FacturaDao implements CRUD<FacturaDto>
{

        private static final String INSERTAR = "INSERT INTO factura (id_factura,id_cita,id_servicio,id_prod,fec_factura,vlr_tipo_servicio) VALUES (?,?,?,?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM factura WHERE id_factura=?";
        private static final String ACTUALIZAR = "UPDATE factura SET id_cita=?, id_servicio=?, id_prod=?, fec_factura=?, vlr_tipo_servicio=? WHERE id_factura=?";
        private static final String BORRAR = "DELETE FROM factura WHERE id_factura=?";
        private static final String READALL = "SELECT * FROM factura";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
        
    @Override
    public boolean create(FacturaDto D) 
    {
        PreparedStatement stat;
            try {
                stat = con.getConn().prepareStatement(INSERTAR);
                stat.setInt(1, D.getId_factura());
                stat.setInt(2, D.getId_cita());
                stat.setInt(3, D.getId_servicio());
                stat.setInt(4, D.getId_prod());
                stat.setString(5, D.getFec_factura());
                stat.setInt(6, D.getVlr_tipo_servicio());
                    if (stat.executeUpdate() >0)
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return false;
    }

    @Override
    public FacturaDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        FacturaDto f = null;
            try {
                stat = con.getConn().prepareStatement(BUSCAR);
                stat. setString(1, key.toString());
                res = stat.executeQuery();
                    while (res.next())
                        {
                         f = new FacturaDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getInt(6));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return f;
    }

    @Override
    public boolean update(FacturaDto D) 
    {
        PreparedStatement stat;
            try {
                stat = con.getConn().prepareStatement(ACTUALIZAR);
                stat.setInt(1, D.getId_cita());
                stat.setInt(2, D.getId_servicio());
                stat.setInt(3, D.getId_prod());
                stat.setString(4, D.getFec_factura());
                stat.setInt(5, D.getVlr_tipo_servicio());
                stat.setInt(6, D.getId_factura());
                        if (stat.executeUpdate()>0)
                            {
                             return true;
                            }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                stat = con.getConn().prepareStatement(BORRAR);
                stat.setString(1, key.toString());
                    if (stat.executeUpdate() > 0)
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {
                            con.cerrar();
                        }
                return false;
    }

    @Override
    public List<FacturaDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<FacturaDto> factura = new ArrayList();
            try {
                stat = con.getConn().prepareStatement(READALL);
                res = stat.executeQuery(); 
                    while (res.next())
                        {
                            factura.add(new FacturaDto(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5),res.getInt(6)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                            {
                                con.cerrar();
                            }
                return factura;
    }
    
}
