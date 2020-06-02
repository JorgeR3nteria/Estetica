/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import Controlador.*;
import DAO.ClienteDao;

/**
 *
 * @author jorge
 */
    public class Mira_Ve {
        
        public static void main(String[] args) {
            CitaE vista = new CitaE();
            ClienteDao cliente = new ClienteDao();
            CitaC Controlador = new CitaC(vista,cliente);
        }
     }

