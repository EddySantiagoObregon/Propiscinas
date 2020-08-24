/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.Proveedor;
import Modelo.Entidad.ProveedorProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosProveedorProducto {

   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosProveedorProducto()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   
public boolean agregado(int idProveedor,String idProducto){
       boolean agregado = false;
       int ProveedorProducto=0;
            try{  
  
                    
            this.miConexion.setAutoCommit(false);   
            
             String consulta5="SELECT proveedor_producto_proveedor_id from proveedor_producto where proveedor_producto_producto_id=? ";
               ps=miConexion.prepareStatement(consulta5);
               ps.setString(1, idProducto);
               rs = ps.executeQuery();
                         
                if(rs.next())
            {
               ProveedorProducto= rs.getInt("proveedor_producto_proveedor_id");
            } 

           
            if(ProveedorProducto==0){
            String consulta1= "insert into proveedor_producto values(null,?,?)";
            ps=miConexion.prepareStatement(consulta1);
            ps.setInt(1,idProveedor);
            ps.setString(2,idProducto);

            ps.executeUpdate();
               agregado=true;
           
           
          
           this.mensaje="Agregado correctamente ";
            }
        
         
                     this.miConexion.commit();
          
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
 public ArrayList<Proveedor> ListarProveedorProducto(String idProducto)
   {
     this.mensaje=null;
     ArrayList<Proveedor> lista= new ArrayList<>();
     String consulta=" SELECT producto.*,proveedor.*,proveedor_producto.* FROM proveedor_producto " +
" INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id " +
" INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id where producto_id=? ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1, idProducto);
         rs= ps.executeQuery();
         while(rs.next())
         {
             Proveedor  unProveedor= new Proveedor(rs.getString("proveedor_nombre"));
             unProveedor.setIdProveedor(rs.getInt("proveedor_producto_id"));
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