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
import Modelo.Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class DatosUsuario {
      private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;   
   
   public DatosUsuario()
   {
        miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   } 
    public String buscarContrasena(String correo) {
   
      String contrasena="";
       Usuario user= null;
       this.mensaje=null;
     
       String consulta="select * from usuario where usuario_correo=? ";
       try
       {
           ps=miConexion.prepareStatement(consulta);
           ps.setString(1, correo);
         
           rs = ps.executeQuery();
           if(rs.next())
           {
              
             contrasena= rs.getString("usuario_contrasena");
               
           }
           rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return contrasena;
   }
    public Usuario iniciarSesion(Usuario unUsuario) {
   
      
       Usuario user= null;
       this.mensaje=null;
     
       String consulta="select * from usuario where usuario_correo=? and usuario_contrasena=?";
       try
       {
           ps=miConexion.prepareStatement(consulta);
           ps.setString(1, unUsuario.getCorreo());
           ps.setString(2, unUsuario.getContrasena());
           rs = ps.executeQuery();
           if(rs.next())
           {
               user = new Usuario();
               user.setIdUsuario(rs.getInt("idUsuario"));
               user.setIdentificacion(rs.getInt("usuario_identificacion"));
               user.setNombre(rs.getString("usuario_nombre")); 
               user.setTelefono(rs.getString("usuario_telefono"));
               user.setCorreo(rs.getString("usuario_correo"));
               user.setContrasena(rs.getString("usuario_contrasena"));
               
           }
           rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return user;
   }
    public boolean agregado(Usuario unUsuario){
        boolean agregado= false;
        this.mensaje=null;
        try{ 
        String consulta ="insert into usuario values(null,?,?,?,?,?)";
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,unUsuario.getIdentificacion());
         ps.setString(2, unUsuario.getNombre());
         ps.setString(3, unUsuario.getTelefono());
         ps.setString(4, unUsuario.getCorreo());
         ps.setString(5, unUsuario.getContrasena());
         ps.executeUpdate();
         agregado=true;
        }catch(SQLException ex)  {
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
    public boolean actualizarPassword(Usuario unUsuario){
        boolean actualizado = false;
        this.mensaje=null;
    
                String consulta="UPDATE usuario   SET usuario_contrasena =? " 
                        +" where usuario_identificacion=? and usuario_correo=? ";
                try {
                    ps=miConexion.prepareStatement(consulta);
                    ps.setString(1,unUsuario.getContrasena());
                    ps.setInt(2,unUsuario.getIdentificacion());
                    ps.setString(3,unUsuario.getCorreo());
                    if(ps.executeUpdate()==1)
                        actualizado=true;
                }catch(SQLException ex){
                    this.mensaje=ex.getMessage();
                }
                return actualizado;
}
     public Usuario nombre(String correo){
      Usuario unUsuario = null;
      
        
        String consultica = "SELECT * FROM usuario where usuario_correo=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,correo);
        rs= ps.executeQuery();
        if(rs.next())
        {
                unUsuario = new Usuario();
                unUsuario.setIdentificacion(rs.getInt("usuario_identificacion"));
                unUsuario.setNombre(rs.getString("usuario_nombre"));
                unUsuario.setTelefono(rs.getString("usuario_telefono"));
                unUsuario.setCorreo(rs.getString("usuario_correo"));
         
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       
      
      
      
      return unUsuario;
      
  }
      public int idUsuario(String correo){
      int idUsuario=0;
        
        String consultica = "SELECT idUsuario FROM usuario where usuario_correo=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,correo);
        rs= ps.executeQuery();
        if(rs.next())
        {
                idUsuario = rs.getInt("idUsuario");
         
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       
      
      
      
      return idUsuario;
      
  }
        public boolean EditarUsuario(int identificacion,String nombre,String telefono,String correo,String correoBusqueda){
           boolean agregado = false; 
           int idUsuario=0;
          try
     {
         
          String consultica = "SELECT idUsuario FROM usuario where usuario_correo=?";
         
       
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,correoBusqueda);
        rs= ps.executeQuery();
        if(rs.next())
        {
                idUsuario = rs.getInt("idUsuario");
         
            
        }
        rs.close();
          String consulta ="UPDATE usuario SET usuario_identificacion =?,usuario_nombre =?,usuario_telefono=? ,usuario_correo=? WHERE idUsuario=?";
        ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, identificacion);
         ps.setString(2,nombre);
         ps.setString(3, telefono);
         ps.setString(4,correo);
         ps.setInt(5,idUsuario);
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
           public boolean EditarContrasena(String correo,String contrasenaVieja,String contrasenaNueva){
           boolean actualizado = false; 
           String contraseñaAntiguaMySql = "";
           int idUsuario=0;
          try
    {
         this.miConexion.setAutoCommit(false); 
          String consultica1 = "SELECT idUsuario FROM usuario where usuario_correo=?";
         
       
        ps=this.miConexion.prepareStatement(consultica1);
        ps.setString(1,correo);
        rs= ps.executeQuery();
        if(rs.next())
        {
                idUsuario = rs.getInt("idUsuario");
         
            
        }
          String consultica2 = "SELECT usuario_contrasena FROM usuario where usuario_correo=?";
         
       
        ps=this.miConexion.prepareStatement(consultica2);
        ps.setString(1,correo);
        rs= ps.executeQuery();
        if(rs.next())
        {
                contraseñaAntiguaMySql = rs.getString("usuario_contrasena");
         
            
        }
        rs.close();
        if(contrasenaVieja.equals(contraseñaAntiguaMySql)){
          String consulta ="UPDATE usuario SET usuario_contrasena=? WHERE idUsuario=?";
        ps=miConexion.prepareStatement(consulta);
         
        ps.setString(1,contrasenaNueva);
        ps.setInt(2,idUsuario);
        ps.executeUpdate();
        int si =ps.executeUpdate();
        if(si>0){
               actualizado = true;
        }
        }
        this.miConexion.commit();
  }catch(SQLException ex)
    {
         this.mensaje=ex.getMessage();
    }          
          return actualizado;
      }  
     
         public ArrayList<Usuario> ListarUsuarios()
   {
     this.mensaje=null;
     ArrayList<Usuario> lista= new ArrayList<>();
     String consulta="SELECT * FROM usuario WHERE usuario_correo NOT LIKE 'propiscinasdelhuila2020@gmail.com' ";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Usuario  unUsuario= new Usuario();
             unUsuario.setIdUsuario(rs.getInt("idUsuario"));
             unUsuario.setIdentificacion(rs.getInt("usuario_identificacion"));
             unUsuario.setNombre(rs.getString("usuario_nombre"));
             unUsuario.setTelefono(rs.getString("usuario_Telefono"));
             unUsuario.setCorreo(rs.getString("usuario_correo"));
             lista.add(unUsuario);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
         public boolean EditarUsuarioDesdeAdministrador(int identificacion,String nombre,String telefono,String correo,int idUsuario){
           boolean agregado = false; 
          
          try
     {
         
          String consulta ="UPDATE usuario SET usuario_identificacion =?,usuario_nombre =?,usuario_telefono=? ,usuario_correo=? WHERE idUsuario=?";
        ps=miConexion.prepareStatement(consulta);
         ps.setInt(1, identificacion);
         ps.setString(2,nombre);
         ps.setString(3, telefono);
         ps.setString(4,correo);
         ps.setInt(5,idUsuario);
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
             public Usuario obtenerUsuario(int idUsuario){
      Usuario unUsuario = null;
      
        
        String consultica = "SELECT * FROM usuario where idUsuario=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setInt(1,idUsuario);
        rs= ps.executeQuery();
        if(rs.next())
        {
                unUsuario = new Usuario();
                unUsuario.setIdentificacion(rs.getInt("usuario_identificacion"));
                unUsuario.setNombre(rs.getString("usuario_nombre"));
                unUsuario.setTelefono(rs.getString("usuario_telefono"));
                unUsuario.setCorreo(rs.getString("usuario_correo"));
         
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       
      
      
      
      return unUsuario;
      
  }
}
