/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.Tipo_productoDto;
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
public class Tipo_productoDao implements CRUD<Tipo_productoDto>{

        private static final String INSERTAR = "INSERT INTO tipo_producto (id_tproducto,tipo_producto,marca) VALUES (?,?,?))";
        private static final String BUSCAR  = "SELECT * FROM tipo_producto WHERE id_tproducto=?";
        private static final String ACTUALIZAR = "UPDATE tipo_producto SET t_producto=?, marca=? WHERE id_tproducto=?";
        private static final String BORRAR = "DELETE FROM tipo_producto WHERE id_tproducto=?";
        private static final String READALL = "SELECT * FROM tipo_producto";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
    @Override
    public boolean create(Tipo_productoDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_tproducto());
                 stat.setString(2, D.getTipo_producto());
                 stat.setString(3, D.getMarca());
                     if (stat.executeUpdate() > 0 )
                        {
                            return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
                    }  finally
                            {
                                con.cerrar();
                            }
                return false;
    }

    @Override
    public Tipo_productoDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        Tipo_productoDto tp = null;
            try {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery(); 
                     while (res.next())
                           {
                            tp = new Tipo_productoDto(res.getInt(1),res.getString(2),res.getString(3));
                           }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return tp;
    }

    @Override
    public boolean update(Tipo_productoDto D) 
    {
        PreparedStatement stat;
            try {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setString(1, D.getTipo_producto());
                 stat.setString(2, D.getMarca());
                 stat.setInt(3, D.getId_tproducto());
                    if (stat.executeUpdate()>0) 
                            {
                             return true;
                            }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                             con.cerrar();
                            }
                return false;
    }

    @Override
    public List<Tipo_productoDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<Tipo_productoDto> tipo_producto = new ArrayList();
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                      while (res.next())
                            {
                                tipo_producto.add(new Tipo_productoDto(res.getInt(1),res.getString(2),res.getString(3)));
                            }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(Tipo_productoDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                        {   
                            con.cerrar();
                        }
                return tipo_producto;
    }
    
}
