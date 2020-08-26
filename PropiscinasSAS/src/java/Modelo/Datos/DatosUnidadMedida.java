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
     String consulta="select * from unidad_medida where unidad_medida_estado='A' ";
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
   
         public boolean RegistrarUnidadMedida(UnidadMedida unaUnidadMedida){
        boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
        String consulta2="insert into unidad_medida "
             + " values(null,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unaUnidadMedida.getDescripcion());
            ps.setString(2,unaUnidadMedida.getObservacion());
            ps.setString(3,unaUnidadMedida.getEstado());
            ps.executeUpdate();
           
           
           this.miConexion.commit();
           this.mensaje="unidad de medida agregada Correctamente";
           
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
  
            
        String consulta1="UPDATE unidad_medida SET unidad_medida_estado = ? WHERE unidad_medida.unidad_medida_id = ?"; 
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
           
      
           public ArrayList<UnidadMedida> ListarUnidadMedidas()
   {
     this.mensaje=null;
     ArrayList<UnidadMedida> lista= new ArrayList<>();
     String consulta="select * from unidad_medida";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {  UnidadMedida unaUnidadMedida = new UnidadMedida();
            
             unaUnidadMedida.setIdUnidadMedida(rs.getInt("unidad_medida_id"));
             unaUnidadMedida.setDescripcion(rs.getString("unidad_medida_descripcion"));
             unaUnidadMedida.setEstado(rs.getString("unidad_medida_estado"));
             lista.add(unaUnidadMedida);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
        
    
           
                       public UnidadMedida obetenerUnidadMedidaId(int id)
   {
     this.mensaje=null;
     UnidadMedida unaUnidadMedida = new UnidadMedida();
     String consulta="select * from unidad_medida where unidad_medida_id=?";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, id);
         rs= ps.executeQuery();
         while(rs.next())
         {  
            
           
             unaUnidadMedida.setEstado(rs.getString("unidad_medida_estado"));
             
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return unaUnidadMedida;
   }   
 
}