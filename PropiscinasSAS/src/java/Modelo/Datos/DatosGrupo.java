/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;


import Controller.Conexion;
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
public class DatosGrupo {
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosGrupo()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<Grupo> ListarGrupo()
   {
     this.mensaje=null;
     ArrayList<Grupo> lista= new ArrayList<>();
     String consulta="select * from grupo";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Grupo  unGrupo= new Grupo(rs.getString("grupo_descripcion"));
             unGrupo.setIdGrupo(rs.getInt("grupo_id"));
             lista.add(unGrupo);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
    public boolean RegistrarGrupo(Grupo unGrupo){
        boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
        String consulta2="insert into grupo "
             + " values(null,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unGrupo.getDescripcion());
            ps.setString(2,unGrupo.getObcervacion());
            ps.setString(3,unGrupo.getEstado());
            ps.executeUpdate();
           
           
           this.miConexion.commit();
           this.mensaje="usuario agregado Correctamente";
           
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
  
            
        String consulta1="UPDATE grupo SET grupo_estado = ? WHERE grupo.grupo_id = ?"; 
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
           public ArrayList<Grupo> ListarGrupos()
   {
     this.mensaje=null;
     ArrayList<Grupo> lista= new ArrayList<>();
     String consulta="select * from grupo";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {  Grupo unGrupo = new Grupo();
            
             unGrupo.setIdGrupo(rs.getInt("grupo_id"));
             unGrupo.setDescripcion(rs.getString("grupo_descripcion"));
             unGrupo.setEstado(rs.getString("grupo_estado"));
             lista.add(unGrupo);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
           
                       public Grupo obetenerGrupoId(int id)
   {
     this.mensaje=null;
     Grupo unGrupo = new Grupo();
     String consulta="select * from grupo where grupo_id=?";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, id);
         rs= ps.executeQuery();
         while(rs.next())
         {  
            
           
             unGrupo.setEstado(rs.getString("grupo_estado"));
             
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return unGrupo;
   }
}
