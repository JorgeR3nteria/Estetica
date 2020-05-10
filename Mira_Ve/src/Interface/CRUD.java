/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;



/**
 *
 * @author jorge
 */
public interface CRUD <estetica>{ 
    
    public boolean create(estetica D);
    public estetica read (Object key);
    public boolean update (estetica D);
    public boolean delete (Object key);
    public List <estetica> readall();
    
      
}
