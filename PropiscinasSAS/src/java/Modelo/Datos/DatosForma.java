/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

/**
 *
 * @author PAULA
 */

import Controller.Conexion;
import Modelo.Entidad.Forma;
import Modelo.Entidad.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosForma {
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosForma()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<Forma> ListarForma()
   {
     this.mensaje=null;
     ArrayList<Forma> lista= new ArrayList<>();
     String consulta="select * from forma";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Forma  unaForma= new Forma(rs.getString("forma_descripcion"));
             unaForma.setidForma(rs.getInt("forma_id"));
             lista.add(unaForma);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
      public ArrayList<Forma> ListarFormaConvetir()
   {
     this.mensaje=null;
     ArrayList<Forma> lista= new ArrayList<>();
     String consulta="select * from forma";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Forma  unaForma= new Forma(rs.getString("forma_descripcion"));
             unaForma.setidForma(rs.getInt("forma_id"));
             lista.add(unaForma);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}