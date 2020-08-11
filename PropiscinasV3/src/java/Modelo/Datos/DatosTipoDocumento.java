/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosTipoDocumento {

   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosTipoDocumento()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<TipoDocumento> ListarTipoDocumento()
   {
     this.mensaje=null;
     ArrayList<TipoDocumento> lista= new ArrayList<>();
     String consulta="SELECT * FROM tipo_documento ORDER BY tipo_documento.tipo_documento_descripcion ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             TipoDocumento  unTipoDocumeno= new TipoDocumento(rs.getString("tipo_documento_descripcion"));
             unTipoDocumeno.setIdTipoDocumento(rs.getInt("tipo_documento_id"));
             lista.add(unTipoDocumeno);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}

