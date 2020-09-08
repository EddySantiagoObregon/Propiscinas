/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.Presentacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosPresentacion {
     private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosPresentacion()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<Presentacion> ListarPresentacion()
   {
     this.mensaje=null;
     ArrayList<Presentacion> lista= new ArrayList<>();
     String consulta="select * from presentacion";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Presentacion  unaPresentacion= new Presentacion(rs.getString("presentacion_descripcion"));
             unaPresentacion.setIdPresentacion(rs.getInt("presentacion_id"));
             lista.add(unaPresentacion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
    public ArrayList<Presentacion> listarPresentacionBulto()
   {
     this.mensaje=null;
     ArrayList<Presentacion> lista= new ArrayList<>();
     String consulta="select * from presentacion where presentacion_id=5 OR presentacion_id=6";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Presentacion  unaPresentacion= new Presentacion(rs.getString("presentacion_descripcion"));
             unaPresentacion.setIdPresentacion(rs.getInt("presentacion_id"));
             lista.add(unaPresentacion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
        public ArrayList<Presentacion> listarPresentacionCaneca()
   {
     this.mensaje=null;
     ArrayList<Presentacion> lista= new ArrayList<>();
     String consulta="select * from presentacion where presentacion_id=1 OR presentacion_id=2";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Presentacion  unaPresentacion= new Presentacion(rs.getString("presentacion_descripcion"));
             unaPresentacion.setIdPresentacion(rs.getInt("presentacion_id"));
             lista.add(unaPresentacion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
           public ArrayList<Presentacion> listarPresentacionGalon()
   {
     this.mensaje=null;
     ArrayList<Presentacion> lista= new ArrayList<>();
     String consulta="select * from presentacion where presentacion_id=3";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Presentacion  unaPresentacion= new Presentacion(rs.getString("presentacion_descripcion"));
             unaPresentacion.setIdPresentacion(rs.getInt("presentacion_id"));
             lista.add(unaPresentacion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}
