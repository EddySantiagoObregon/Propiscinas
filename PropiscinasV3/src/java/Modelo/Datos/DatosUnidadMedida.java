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
import Modelo.Entidad.UnidadMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class DatosUnidadMedida{
   
    
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosUnidadMedida()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<UnidadMedida> ListarUnidadMedida()
   {
     this.mensaje=null;
     ArrayList<UnidadMedida> lista= new ArrayList<>();
     String consulta="select * from unidad_medida";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             UnidadMedida unaUnidadMedida= new UnidadMedida(rs.getString("unidad_medida_descripcion"));
             unaUnidadMedida.setIdUnidadMedida(rs.getInt("unidad_medida_id"));
             lista.add(unaUnidadMedida);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }

 
}