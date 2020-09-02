/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.Infraestructura;
import Modelo.Entidad.UnidadMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosInfraestructura {
       private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosInfraestructura()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<Infraestructura> ListarInfraestructura()
   {
     this.mensaje=null;
     ArrayList<Infraestructura> lista= new ArrayList<>();
     String consulta="SELECT * FROM `infraestructura` WHERE `infraestructura_descripcion` NOT LIKE ' ' ORDER BY `infraestructura_descripcion` ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Infraestructura unaInfraestructura= new Infraestructura(rs.getString("infraestructura_descripcion"));
             unaInfraestructura.setIdInfraestructura(rs.getInt("infraestructura_id"));
             lista.add(unaInfraestructura);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
   
           
   public ArrayList<Infraestructura> ListarInfraestructuraCambio(int idInfraestructura)
   {
     this.mensaje=null;
     ArrayList<Infraestructura> lista= new ArrayList<>();
     String consulta="SELECT * FROM infraestructura WHERE infraestructura_descripcion NOT LIKE ' ' AND infraestructura_id NOT LIKE ? ORDER BY infraestructura_descripcion ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idInfraestructura);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Infraestructura unaInfraestructura= new Infraestructura(rs.getString("infraestructura_descripcion"));
             unaInfraestructura.setIdInfraestructura(rs.getInt("infraestructura_id"));
             lista.add(unaInfraestructura);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}
