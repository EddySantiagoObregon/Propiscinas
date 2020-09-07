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
            
             String consulta5="SELECT proveedor_producto_proveedor_id from proveedor_producto where proveedor_producto_producto_id=? AND proveedor_producto_proveedor_id=? ";
               ps=miConexion.prepareStatement(consulta5);
               ps.setString(1, idProducto);
               ps.setInt(2, idProveedor);
               rs = ps.executeQuery();
                         
                if(rs.next())
            {
               ProveedorProducto= rs.getInt("proveedor_producto_proveedor_id");
            } 

           
            if(ProveedorProducto==0){
            String consulta1= "insert into proveedor_producto values(null,?,?,'A')";
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
" INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id where producto_id=? and proveedor_estado='A' and proveedor_producto_estado='A' ORDER BY proveedor_nombre ASC";
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
  public ArrayList<ProveedorProducto> ListarProveedoresYProductos()
   {
     this.mensaje=null;
     ArrayList<ProveedorProducto> lista= new ArrayList<>();
     String consulta="SELECT producto.*,proveedor.*,proveedor_producto.*,forma.*,presentacion.*,unidad_medida.*,grupo.*,detalle_producto.* FROM proveedor_producto\n" +
"INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id \n" +
"INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"\n" +
"\n" +
"\n" +
"ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
          ProveedorProducto  unProveedorProducto= new ProveedorProducto();
             unProveedorProducto.setIdProveedorProducto(rs.getInt("proveedor_producto_id"));
             unProveedorProducto.getUnDetalleProducto().setIdProducto(rs.getString("producto_id"));
             unProveedorProducto.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
             unProveedorProducto.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
             unProveedorProducto.getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
             unProveedorProducto.setEstado(rs.getString("proveedor_producto_estado"));
             lista.add(unProveedorProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }

          public ArrayList<ProveedorProducto> ListarProveedoresYProductosPorCodigo(String idProducto)
   {
     this.mensaje=null;
     ArrayList<ProveedorProducto> lista= new ArrayList<>();
     String consulta="SELECT producto.*,proveedor.*,proveedor_producto.*,forma.*,presentacion.*,unidad_medida.*,grupo.*,detalle_producto.* FROM proveedor_producto\n" +
"INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id \n" +
"INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"\n" +
"\n" +
"\n" +
" WHERE producto_id=? ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1, idProducto);
         rs= ps.executeQuery();
         while(rs.next())
         {
  ProveedorProducto  unProveedorProducto= new ProveedorProducto();
             unProveedorProducto.setIdProveedorProducto(rs.getInt("proveedor_producto_id"));
             unProveedorProducto.getUnDetalleProducto().setIdProducto(rs.getString("producto_id"));
             unProveedorProducto.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
             unProveedorProducto.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
             unProveedorProducto.getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
             unProveedorProducto.setEstado(rs.getString("proveedor_producto_estado"));
             lista.add(unProveedorProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
          
          public ArrayList<ProveedorProducto> ListarProveedoresYProductosPorCodigoYidProveedor(String idProducto,int idProveedor)
   {
     this.mensaje=null;
     ArrayList<ProveedorProducto> lista= new ArrayList<>();
     String consulta="SELECT producto.*,proveedor.*,proveedor_producto.*,forma.*,presentacion.*,unidad_medida.*,grupo.*,detalle_producto.* FROM proveedor_producto\n" +
"INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id \n" +
"INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"\n" +
"\n" +
"\n" +
" WHERE producto_id=? and proveedor_id=? ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
           ps.setString(1, idProducto);
             ps.setInt(2, idProveedor);
         rs= ps.executeQuery();
         while(rs.next())
         {
           ProveedorProducto  unProveedorProducto= new ProveedorProducto();
             unProveedorProducto.setIdProveedorProducto(rs.getInt("proveedor_producto_id"));
             unProveedorProducto.getUnDetalleProducto().setIdProducto(rs.getString("producto_id"));
             unProveedorProducto.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
             unProveedorProducto.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
             unProveedorProducto.getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
             unProveedorProducto.setEstado(rs.getString("proveedor_producto_estado"));
             lista.add(unProveedorProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
            public ArrayList<ProveedorProducto> ListarProveedoresYProductosPoridProveedor(int idProveedor)
   {
     this.mensaje=null;
     ArrayList<ProveedorProducto> lista= new ArrayList<>();
     String consulta="SELECT producto.*,proveedor.*,proveedor_producto.*,forma.*,presentacion.*,unidad_medida.*,grupo.*,detalle_producto.* FROM proveedor_producto\n" +
"INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id \n" +
"INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"\n" +
"\n" +
"\n" +
" WHERE proveedor_id=? ORDER BY proveedor_nombre ASC";
     try
     {
         ps=miConexion.prepareStatement(consulta); 
             ps.setInt(1, idProveedor);
         rs= ps.executeQuery();
         while(rs.next())
         {
  ProveedorProducto  unProveedorProducto= new ProveedorProducto();
             unProveedorProducto.setIdProveedorProducto(rs.getInt("proveedor_producto_id"));
             unProveedorProducto.getUnDetalleProducto().setIdProducto(rs.getString("producto_id"));
             unProveedorProducto.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
             unProveedorProducto.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
             unProveedorProducto.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
             unProveedorProducto.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
             unProveedorProducto.getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
             unProveedorProducto.setEstado(rs.getString("proveedor_producto_estado"));
             lista.add(unProveedorProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
            
                          public boolean Desactivado(int id){
        boolean eliminado = false;
            try{  
  
            
        String consulta1="UPDATE proveedor_producto SET proveedor_producto_estado = 'I' WHERE proveedor_producto.proveedor_producto_id = ? "; 
            this.miConexion.setAutoCommit(false);   
            
            ps=miConexion.prepareStatement(consulta1);
            ps.setInt(1,id);
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
                                     public boolean Activado(int id){
        boolean Activado = false;
            try{  
  
            
        String consulta1="UPDATE proveedor_producto SET proveedor_producto_estado = 'A' WHERE proveedor_producto.proveedor_producto_id = ? "; 
            this.miConexion.setAutoCommit(false);   
            
            ps=miConexion.prepareStatement(consulta1);
            ps.setInt(1,id);
            ps.executeUpdate();

            
                                   
         
      
           this.miConexion.commit();
    
           
           Activado=true;
         
                    
          
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
        return Activado;
    }

}