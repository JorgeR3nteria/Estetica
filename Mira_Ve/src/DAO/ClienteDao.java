/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.conectar;
import Interface.CRUD;
import Modelo.ClienteDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class ClienteDao implements CRUD<ClienteDto>
{

        private static final String INSERTAR = "INSERT INTO cliente (id_cliente,documento,nombre,apellido_1,apellido_2,f_nacimiento,direccion,correo,edad,telefono) VALUES (?,?,?,?,?,?,?,?,?,?)";
        private static final String BUSCAR  = "SELECT * FROM cliente WHERE id_cliente=?";
        private static final String ACTUALIZAR = "UPDATE cliente SET documento=?, nombre=?, apellido_1=?, apellido_2=?, f_nacimiento=?, direccion=?, correo=?, edad=?, telefono=? WHERE id_cliente=?";
        private static final String BORRAR = "DELETE FROM cliente WHERE id_cliente=?";
        private static final String READALL = "SELECT * FROM cliente";
        private static final conectar con = conectar.Estado(); //Este metodo pregunta si la instancia esta creada o no
        
    @Override
    public boolean create(ClienteDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(INSERTAR);
                 stat.setInt(1, D.getId_cliente());
                 stat.setInt(2, D.getDocumento());
                 stat.setString(3, D.getNombre());
                 stat.setString(4, D.getApellido_1());
                 stat.setString(5, D.getApellido_2());
                 stat.setString(6, D.getF_nacimiento());
                 stat.setString(7, D.getDireccion());
                 stat.setString(8, D.getCorreo());
                 stat.setInt(9, D.getEdad());
                 stat.setInt(10, D.getTelefono());
                     if (stat.executeUpdate() >0)
                        {
                         return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return false;
    }

    @Override
    public ClienteDto read(Object key) 
    {
        PreparedStatement stat;
        ResultSet res;
        ClienteDto c = null;
            try 
                {
                 stat = con.getConn().prepareStatement(BUSCAR);
                 stat. setString(1, key.toString());
                 res = stat.executeQuery();
                    while (res.next())
                        {
                         c = new ClienteDto(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9),res.getInt(10));
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return c;
    }

    @Override
    public boolean update(ClienteDto D) 
    {
        PreparedStatement stat;
            try 
                {
                 stat = con.getConn().prepareStatement(ACTUALIZAR);
                 stat.setInt(1, D.getDocumento());
                 stat.setString(2, D.getNombre());
                 stat.setString(3, D.getApellido_1());
                 stat.setString(4, D.getApellido_2());
                 stat.setString(5, D.getF_nacimiento());
                 stat.setString(6, D.getDireccion());
                 stat.setString(7, D.getCorreo());
                 stat.setInt(8, D.getEdad());
                 stat.setInt(9, D.getTelefono());
                 stat.setInt(10, D.getId_cliente());
                        if (stat.executeUpdate()>0)
                        {
                            return true;
                        }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
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
                     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return false;
    }

    @Override
    public List<ClienteDto> readall() 
    {
        PreparedStatement stat;
        ResultSet res;
        ArrayList<ClienteDto> cliente = new ArrayList();
            try 
                {
                 stat = con.getConn().prepareStatement(READALL);
                 res = stat.executeQuery();
                      while (res.next())
                            {
                                cliente.add(new ClienteDto(res.getInt(1),res.getInt(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9),res.getInt(10)));
                            }
                } catch (SQLException ex) 
                    {
                     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
                    } finally 
                            {
                                con.cerrar();
                            }
                return cliente;
    }

    public String create(String Id_cliente, String Nombre, String Apellido_1, String Apellido_2, String Telefono, String Correo, SimpleDateFormat Fecha, String Hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
