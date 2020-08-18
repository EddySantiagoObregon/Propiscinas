/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.Grupo;
import Modelo.Entidad.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosProveedor {


   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosProveedor()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   
   public boolean agregado(Proveedor unProveedor){
       boolean agregado = false;
            try{  
  
     
            this.miConexion.setAutoCommit(false);   
            
           

           
            
            String consulta1= "insert into proveedor values(null,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,unProveedor.getNitProveedor());
            ps.setString(2,unProveedor.getNombre());
            ps.setString(3,unProveedor.getTelefono());
            ps.setString(4, unProveedor.getEstado());
            ps.executeUpdate();
            
          
           
           this.miConexion.commit();
           this.mensaje="Agregado correctamente ";
           
           agregado=true;
         
                    
          
       }catch(SQLException ex)
       {
         try
         {
             this.mensaje=ex.getMessage();
             this.miConexion.rollback();
         }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       }
        return agregado;
   }
      public ArrayList<Proveedor> ListarProveedor()
   {
     this.mensaje=null;
     ArrayList<Proveedor> lista= new ArrayList<>();
     String consulta="SELECT * FROM proveedor ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Proveedor  unProveedor= new Proveedor(rs.getString("proveedor_nombre"));
             unProveedor.setIdProveedor(rs.getInt("proveedor_id"));
             lista.add(unProveedor);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
         public ArrayList<Proveedor> ListarProveedores()
   {
     this.mensaje=null;
     ArrayList<Proveedor> lista= new ArrayList<>();
     String consulta="SELECT * FROM proveedor ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Proveedor  unProveedor= new Proveedor();
             unProveedor.setIdProveedor(rs.getInt("proveedor_id"));
             unProveedor.setNitProveedor(rs.getString("proveedor_nit"));
             unProveedor.setNombre(rs.getString("proveedor_nombre"));
             unProveedor.setTelefono(rs.getString("proveedor_telefono"));
             unProveedor.setEstado(rs.getString("proveedor_estado"));
             lista.add(unProveedor);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
           public Proveedor obtenerProveedor(int idProveedor)
   {
     this.mensaje=null;
     Proveedor unProveedor = null;
     String consulta="SELECT * FROM proveedor where proveedor_id=?  ";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, idProveedor);
         rs= ps.executeQuery();
         while(rs.next())
         {
             unProveedor= new Proveedor();
             unProveedor.setIdProveedor(rs.getInt("proveedor_id"));
             unProveedor.setNitProveedor(rs.getString("proveedor_nit"));
             unProveedor.setNombre(rs.getString("proveedor_nombre"));
             unProveedor.setTelefono(rs.getString("proveedor_telefono"));
             unProveedor.setEstado(rs.getString("proveedor_estado"));
           
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return unProveedor;
   }   
      public boolean EditarProveedor(String nit,String nombre,String telefono,String estado,int idProveedor){
           boolean agregado = false; 
          try
     {
         
          String consulta ="UPDATE proveedor SET proveedor_nit =?,proveedor_nombre =?,proveedor_telefono=? ,proveedor_estado=? WHERE proveedor_id=?";
        ps=miConexion.prepareStatement(consulta);
         ps.setString(1, nit);
         ps.setString(2,nombre);
         ps.setString(3, telefono);
         ps.setString(4,estado);
         ps.setInt(5,idProveedor);
         ps.executeUpdate();
         int si =ps.executeUpdate();
         if(si>0){
               agregado = true;
         }
        
  }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }          
          return agregado;
      }     
      
                public ArrayList<Proveedor> buscarProveedor(String buscar)
   {
     this.mensaje=null;
        ArrayList<Proveedor> lista= new ArrayList<>();
     String consulta="SELECT * FROM proveedor where proveedor_nombre like ?  ";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1, buscar);
         rs= ps.executeQuery();
         while(rs.next())
         {
             
             Proveedor unProveedor= new Proveedor();
             unProveedor.setIdProveedor(rs.getInt("proveedor_id"));
             unProveedor.setNitProveedor(rs.getString("proveedor_nit"));
             unProveedor.setNombre(rs.getString("proveedor_nombre"));
             unProveedor.setTelefono(rs.getString("proveedor_telefono"));
             unProveedor.setEstado(rs.getString("proveedor_estado"));
             lista.add(unProveedor);
           
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }   


}