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
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class Cita implements ActionListener
{ //Vista.Cita V = new Vista.Cita();
    CitaE E = new CitaE();
    CitaDao A = new CitaDao();
    ClienteDao C = new ClienteDao();
    Tipo_servicioDao P = new Tipo_servicioDao();
    ServicioDao S = new ServicioDao();

    public Cita(Vista.Cita V, CitaE E, CitaDao A, ClienteDao C, Tipo_servicioDao P, ServicioDao S) 
        {
            this.A = A;
            this.C = C;
            this.E = E;
          //this.V = V;
            this.P = P;
            this.S = S;
            
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
                DefaultTableModel D = new DefaultTableModel();
                T.setModel(D);
                D.addColumn("Id_cliente");
                D.addColumn("Documento");
                D.addColumn("Nombre");
                D.addColumn("Apellido_1");
                D.addColumn("Apellido_2");
                D.addColumn("F_nacimiento");
                D.addColumn("Direccion");
                D.addColumn("Correo");
                
                Object[] columna = new Object[9];
                
                    int Reg1 = C.readall().size();
                    
                     for (int i=0; i<Reg1; i++) 
                     {
                         columna[0] = C.readall().get(i).getId_cliente();
                         columna[1] = C.readall().get(i).getDocumento();
                         columna[2] = C.readall().get(i).getNombre();
                         columna[3] = C.readall().get(i).getApellido_1();
                         columna[4] = C.readall().get(i).getApellido_2();
                         columna[5] = C.readall().get(i).getTelefono();
                         columna[6] = C.readall().get(i).getCorreo();
                         D.addRow(columna);
                         
                     }
            }
    
        public void Registro (JTable j)
            {
                DefaultTableModel D = new DefaultTableModel();
                j.setModel(D);
                D.addColumn("Id_cita");
                D.addColumn("Id_cliente");
                D.addColumn("Id_servicio");
                D.addColumn("Id_empleado");
                D.addColumn("Id_prod");
                D.addColumn("F_cita");
                D.addColumn("Hora_cita");
                
                Object[] columna = new Object[7];
                
                    int Reg2 = A.readall().size();
                    
                     for (int i=0; i<Reg2; i++) 
                     {
                         columna[0] = A.readall().get(i).getId_cita();
                         columna[1] = A.readall().get(i).getId_cliente();
                         columna[2] = A.readall().get(i).getId_servicio();
                         columna[3] = A.readall().get(i).getId_empleado();
                         columna[4] = A.readall().get(i).getId_prod();
                         columna[6] = A.readall().get(i).getHora_cita();
                         D.addRow(columna);
                     }
            }
        public void Reg1 (JTable B)
        {
                DefaultTableModel D = new DefaultTableModel();
                B.setModel(D);
                D.addColumn("Id_tservicio");
                D.addColumn("Tipo_servicio");
                Object[] columna = new Object[3];
                    int Reg3 = P.readall().size();
                        for (int i=0; i<Reg3; i++) 
                        {
                            columna[0] = P.readall().get(i).getId_tservicio();
                            columna[1] = P.readall().get(i).getT_servicio();
                            D.addRow(columna);
                        }
        }
        public void Reg2 (JTable L)
        {
            DefaultTableModel D = new DefaultTableModel();
                L.setModel(D);
                D.addColumn("Id_servicio");
                D.addColumn("Id_tservicio");
                D.addColumn("Descripcion");
                Object[] columna = new Object [4];
                    int Reg4 = S.readall().size();
                        for (int i=0; i<Reg4 ; i++) 
                            {
                                columna[0] = S.readall().get(i).getId_servicio();
                                columna[1] = S.readall().get(i).getId_tservicio();
                                columna[2] = S.readall().get(i).getDescripcion();
                                D.addRow(columna);
                            }
        }
    
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == E.RbtnAgre) 
            {
             String Id_cliente = E.txtId.getText();
             String Documento = E.txtName.getText();
             String Apellido_1 = E.txtAp1.getText();
             String Apellido_2 = E.txtAp2.getText();
             String Telefono = E.txtTel.getText();
             String Correo = E.txtHora.getText();
             SimpleDateFormat Fecha = new SimpleDateFormat("yyyy-MM-dd");
             String fecha = Fecha.format(E.Date.getDate());
             String Hora = E.txtHora.getText();
            }

    }
}
