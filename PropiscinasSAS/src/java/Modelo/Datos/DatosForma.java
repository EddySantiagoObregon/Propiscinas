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
     String consulta="select * from forma where forma_estado='A' ";
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
        public boolean AgregarForma(Forma unaForma){
        boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
        String consulta2="insert into forma "
             + " values(null,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unaForma.getDescripcion());
            ps.setString(2,unaForma.getObcervacion());
            ps.setString(3,unaForma.getEstado());
            ps.executeUpdate();
           
           
           this.miConexion.commit();
           this.mensaje="forma  agregada Correctamente";
           
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
  
            
        String consulta1="UPDATE forma SET forma_estado = ? WHERE forma.forma_id = ?"; 
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
           
      
           public ArrayList<Forma> ListarFormas()
   {
     this.mensaje=null;
     ArrayList<Forma> lista= new ArrayList<>();
     String consulta="select * from forma";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {  Forma unaForma = new Forma();
            
             unaForma.setidForma(rs.getInt("forma_id"));
             unaForma.setDescripcion(rs.getString("forma_descripcion"));
             unaForma.setEstado(rs.getString("forma_estado"));
             lista.add(unaForma);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
        
    
           
                       public Forma obetenerFormaId(int id)
   {
     this.mensaje=null;
     Forma unaForma = new Forma ();
     String consulta="select * from forma  where forma_id=?";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, id);
         rs= ps.executeQuery();
         while(rs.next())
         {  
            
           
             unaForma.setEstado(rs.getString("forma_estado"));
             
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return unaForma;
   }   
}