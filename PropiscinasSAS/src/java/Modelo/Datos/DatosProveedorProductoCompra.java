/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;


import Controller.Conexion;
import Modelo.Entidad.Proveedor;
import Modelo.Entidad.ProveedorProducto;
import Modelo.Entidad.ProveedorProductoCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosProveedorProductoCompra {

   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosProveedorProductoCompra()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

 public ArrayList<ProveedorProductoCompra> ListarProveedorProductoCompra()
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id ORDER BY proveedor_producto_compra.fechaRegistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
 
         public ArrayList<ProveedorProductoCompra> BuscarPorNombre(String buscar)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_nombre=? ORDER BY proveedor_producto_compra.fechaRegistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,buscar);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
          public ArrayList<ProveedorProductoCompra> BuscarPorDocumento(String buscar)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where documento_numero_documento=? ORDER BY proveedor_producto_compra.fechaRegistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,buscar);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
             public ArrayList<ProveedorProductoCompra> BuscarPorIdProducto(String buscar)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where producto_id=? ORDER BY proveedor_producto_compra.fechaRegistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,buscar);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }


   public ArrayList<ProveedorProductoCompra> BuscarPorNombreYFecha(String buscar,String fecha)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where producto_id=? and fechaRegistro like ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,buscar);
         ps.setString(2,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
  public ArrayList<ProveedorProductoCompra> BuscarPorFecha(String fecha)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where fechaRegistro like ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
  
            public ArrayList<ProveedorProductoCompra> BuscarPorProveedor(int idProveedor)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id = ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
            
                      public ArrayList<ProveedorProductoCompra> BuscarPorProveedorYFecha(int idProveedor,String fecha)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id=? and fechaRegistro like ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         ps.setString(2,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                      
                                              public ArrayList<ProveedorProductoCompra> BuscarPorProveedorYFechaYidProducto(int idProveedor,String fecha,String idProducto)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id=? and producto_id=? and fechaRegistro like ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         ps.setString(2,idProducto);
         ps.setString(3,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
          
                                           public ArrayList<ProveedorProductoCompra> BuscarPorProveedorYFechaYnumeroDocumento(int idProveedor,String fecha,String numeroDocumento)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id=? and documento_numero_documento=? and fechaRegistro like ?  ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         ps.setString(2,numeroDocumento);
         ps.setString(3,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
       public ArrayList<ProveedorProductoCompra> BuscarPorProveedorYidProducto(int idProveedor,String idProducto)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id=? and producto_id=? ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         ps.setString(2,idProducto);
        rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
       
                public ArrayList<ProveedorProductoCompra> BuscarPorProveedorYnumeroDocumento(int idProveedor,String numeroDocumento)
   {
     this.mensaje=null;
     ArrayList<ProveedorProductoCompra> lista= new ArrayList<>();
     try
     {
          String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*,documento.* FROM proveedor_producto_compra INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
        "INNER JOIN documento ON proveedor_producto_compra.proveedor_producto_compra_documento_id=documento.documento_id where proveedor_id=? and documento_numero_documento=? ORDER BY proveedor_producto_compra.fechaRegistro DESC";
    
         ps=miConexion.prepareStatement(consulta);
         ps.setInt(1,idProveedor);
         ps.setString(2,numeroDocumento);
        rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("documento_numero_documento"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProveedor().setNombre(rs.getString("proveedor_nombre"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setNombre(rs.getString("producto_nombre")); 
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unProveedorProductoCompra.setFecha(rs.getString("fechaRegistro"));
                unProveedorProductoCompra.setCompra(rs.getString("precioCompra"));
                
                lista.add(unProveedorProductoCompra);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
}