/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;

import Modelo.Entidad.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosTransaccion {
    
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosTransaccion()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<Transaccion> ListarTransaccion()
   {
     this.mensaje=null;
     ArrayList<Transaccion> lista= new ArrayList<>();
     String consulta="select * from transaccion";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Transaccion  unaTransaccion= new Transaccion(rs.getString("transaccion_descripcion"));
             unaTransaccion.setIdTransaccion(rs.getInt("transaccion_id"));
             lista.add(unaTransaccion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}
