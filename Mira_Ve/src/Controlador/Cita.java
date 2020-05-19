/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DAO.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class Cita implements ActionListener
{
    FrCita V = new FrCita();
    CitaE E = new CitaE();
    CitaDao A = new CitaDao();
    ClienteDao C = new ClienteDao();

    public Cita(FrCita V, CitaE E, CitaDao A, ClienteDao C) 
        {
            this.A = A;
            this.C = C;
            this.E = E;
            this.V = V;
            
            V.RbtnAgre.addActionListener(this);
            E.RbtnAgre.addActionListener(this);
            E.JrbtnEliminar.addActionListener(this);
            E.RbtnMod.addActionListener(this);
            E.RbtnAct.addActionListener(this);
        }
    
    public void Crud() //Se inicializa el crud
        {
        
        }       
    
    public void Tabla(JTable T)
            {
                DefaultTableModel M = new DefaultTableModel();
                DefaultTableModel D = new DefaultTableModel();
                T.setModel(M);
                T.setModel(D);
                D.addColumn("Id_cliente");
                D.addColumn("Documento");
                D.addColumn("Nombre");
                D.addColumn("Apellido_1");
                D.addColumn("Apellido_2");
                D.addColumn("F_nacimiento");
                D.addColumn("Direccion");
                D.addColumn("Correo");
                M.addColumn("F_cita");
                M.addColumn("Hora_cita");
                
                Object[] columna = new Object[10];
                
                    int Reg1 = C.readall().size();
                    int Reg2 = A.readall().size();
                    
                     for (int i=0; i<Reg1; i++) {
                         for (int j=0; j<Reg2; j++) {
                             
                         }
                         columna[0] = C.readall().get(i).getId_cliente();
                         columna[1] = C.readall().get(i).getDocumento();
                         columna[2] = C.readall().get(i).getNombre();
                         columna[3] = C.readall().get(i).getApellido_1();
                         columna[4] = C.readall().get(i).getApellido_2();
                         columna[5] = C.readall().get(i).getTelefono();
                         columna[6] = C.readall().get(i).getCorreo();
                     }
            }
    
    public void actionPerformed (ActionEvent e)
    {
        
    }
}
