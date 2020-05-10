/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Dto.ProductoDto;
import Dto.ServicioDto;
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
public class ProductoDao implements CRUD<ProductoDto>
{
        private static final String INSERTAR = "INSERT INTO producto (id_prod,nombre,descripcion,vlr_prod) VALUES (?,?,?,?)";
        private static final String LEER = "SELECT * FROM producto WHERE id_prod=?";
        private static final String BORRAR = "DELETE FROM producto WHERE id_prod=?";
        private static final String ACTUALIZAR = "UPDATE producto SET nombre=?,descripcion=?,vlr_prod=? WHERE id_prod=?";
        private static final String READALL = "SELECT * FROM producto";
        private static final conectar con = conectar.Estado();
        
    @Override
    public boolean create(ProductoDto D) 
    {
        PreparedStatement stat;    
            
            try {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_prod());
                 stat.setString(2, D.getNom_prod());
                 stat.setString(3, D.getDescripcion());
                 stat.setInt(4, D.getVlr_prod());
                 
                    if (stat.executeUpdate() > 0) 
                      {
                          return true;
                      }
            } catch (SQLException ex) 
                {
                 Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    { // Es una clausula para cerrar la conexion
                      con.cerrar();
                    }
            return false;
    }

    @Override
    public ProductoDto read(Object key) {
        PreparedStatement stat;
        ResultSet res;
        ProductoDto p = null;
        
            try 
            {
             stat = con.getConn().prepareStatement(LEER);
             stat.setString(1, key.toString());
             
             res = stat.executeQuery();
             
                while (res.next()) 
                     {
                      p = new ProductoDto(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
                     }
                      return p;
            } catch (SQLException ex) 
                {
                 Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
                } finally
                    {
                     con.cerrar();
                    }
            return p;
    }

    @Override
    public boolean update(ProductoDto D) {
        PreparedStatement stat;
        
            try {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setString(1, D.getNom_prod());
                 stat.setString(2, D.getDescripcion());
                 stat.setInt(3, D.getVlr_prod());
                 stat.setInt(4, D.getId_prod());
                
                    if (stat.executeUpdate() > 0 ) 
                        {
                         return true;
                        }
                    
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
                    }finally
                        {
                         con.cerrar();
                        }
            return false;
    }

    @Override
    public List<ProductoDto> readall() {
        PreparedStatement stat;
        ArrayList<ProductoDto> producto = new ArrayList();
        ResultSet res;
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                 
                    while (res.next()) 
                        {
                         producto.add(new ProductoDto(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4)));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally
                        {
                          con.cerrar();
                        }
            return producto;
    }
    
}
