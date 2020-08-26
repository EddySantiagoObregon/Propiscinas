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
     String consulta="select * from presentacion where presentacion_estado='A' ";
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
           
         public boolean RegistrarPresentacion(Presentacion unaPresentacion){
        boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
        String consulta2="insert into presentacion "
             + " values(null,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unaPresentacion.getDescripcion());
            ps.setString(2,unaPresentacion.getObservacion());
            ps.setString(3,unaPresentacion.getEstado());
            ps.executeUpdate();
           
           
           this.miConexion.commit();
           this.mensaje="presentacion agregada Correctamente";
           
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
           public boolean DesactivaroActivar(int id,String estado){
        boolean eliminado = false;
            try{  
  
            
        String consulta1="UPDATE presentacion SET presentacion_estado = ? WHERE presentacion.presentacion_id = ?"; 
            this.miConexion.setAutoCommit(false);   
            
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,estado);
            ps.setInt(2,id);
            ps.executeUpdate();

            
                                   
         
      
           this.miConexion.commit();
    
           
           eliminado=true;
         
                    
          
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
        return eliminado;
    }
           
      
           public ArrayList<Presentacion> ListarPresentaciones()
   {
     this.mensaje=null;
     ArrayList<Presentacion> lista= new ArrayList<>();
     String consulta="select * from presentacion";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {  Presentacion unaPresentacion = new Presentacion();
            
             unaPresentacion.setIdPresentacion(rs.getInt("presentacion_id"));
             unaPresentacion.setDescripcion(rs.getString("presentacion_descripcion"));
             unaPresentacion.setEstado(rs.getString("presentacion_estado"));
             lista.add(unaPresentacion);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
        
    
           
                       public Presentacion obetenerPresentacionId(int id)
   {
     this.mensaje=null;
     Presentacion unaPresentacion = new Presentacion();
     String consulta="select * from presentacion where presentacion_id=?";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, id);
         rs= ps.executeQuery();
         while(rs.next())
         {  
            
           
             unaPresentacion.setEstado(rs.getString("presentacion_estado"));
             
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return unaPresentacion;
   }   
}
