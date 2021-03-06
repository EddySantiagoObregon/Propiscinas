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
import Modelo.Entidad.Documento;

import Modelo.Entidad.InventarioVenta;
import Modelo.Entidad.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author PAULA
 */
public class DatosInventarioVenta{
   
    
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosInventarioVenta()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   
  
             public ArrayList<InventarioVenta>listarVenta()
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id\n" +
"INNER JOIN usuario ON inventario_venta.inventario_venta_usuario=usuario.idUsuario\n" +
"INNER JOIN presentacion	ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"ORDER BY inventario_venta.inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
              public ArrayList<InventarioVenta>listarVentaPorFactura(String factura)
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id WHERE documento.documento_numero_documento=? ORDER BY inventario_venta.inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, factura);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        { 
            this.mensaje= ex.getMessage();
        }
        return lista;
}
              public boolean desactivado(int cantidad,String fecha,String codigo,int cantidadNueva){
                  boolean desactivado=false;
                  
                  try
        {
             this.miConexion.setAutoCommit(false);
              String consulta= "UPDATE inventario_venta SET inventario_venta_cantidad_total = ? where 	inventario_venta_cantidad_total=? and inventario_venta_fecha_registro=? AND inventario_venta_producto_id =?";
                ps=miConexion.prepareStatement(consulta);
                ps.setInt(1, cantidadNueva);
                ps.setInt(2,cantidad);
                ps.setString(3,fecha);
                ps.setString(4,codigo);
                ps.executeUpdate();
               
                
                 desactivado=true;
                 this.miConexion.commit();
                   }catch(SQLException ex)
        { 
            this.mensaje= ex.getMessage();
        }
                 return desactivado;
              }
              public int TipoDocumentos(String tipoDocumento){
                int idTipoDocumento=0;
                try{
                    String consulta ="SELECT tipo_documento_id FROM tipo_documento WHERE tipo_documento_descripcion=?";
                     ps=miConexion.prepareStatement(consulta);
                ps.setString(1,tipoDocumento);
                rs= ps.executeQuery();
                if(rs.next())
            {
               idTipoDocumento= rs.getInt("tipo_documento_id");
            } 
                rs.close();
            
                   }catch(SQLException ex)
        { 
            this.mensaje= ex.getMessage();
        }
                return idTipoDocumento;
              }
                   public ArrayList<InventarioVenta>buscarInventarioVenta(String buscar)
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                    INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id  \n" +
"   WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR \n" +
"   forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setString(2, buscar);
            ps.setString(3, buscar);
            ps.setString(4, buscar);
            ps.setString(5, buscar);
            ps.setString(6, buscar);
            ps.setString(7, buscar);
            ps.setString(8, buscar);
            ps.setString(9, buscar);
            ps.setString(10, buscar);
            ps.setString(11, buscar);
            ps.setString(12, buscar);
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                     public ArrayList<InventarioVenta>buscarInventarioVentaPorFecha(String fecha)
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                 INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                    INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                   INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id  " +
"   WHERE  inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, "%"+fecha+"%");
    
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                     public ArrayList<InventarioVenta>buscarInventarioVentaPorProductoYFecha(String buscar,String  fecha )
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR  "+
 "  forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setString(2, buscar);
            ps.setString(3, buscar);
            ps.setString(4, buscar);
            ps.setString(5, buscar);
            ps.setString(6, buscar);
            ps.setString(7, buscar);
            ps.setString(8, buscar);
            ps.setString(9, buscar);
            ps.setString(10, buscar);
            ps.setString(11, buscar);
            ps.setString(12, buscar);
            ps.setString(13, "%"+fecha+"%");
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}

        public ArrayList<InventarioVenta>BuscarPorTipoDocumento(int TipoDocumento)
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                   INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id  \n" +
"  WHERE tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setInt(1, TipoDocumento);
      
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
        
                public ArrayList<InventarioVenta>BuscarPorTipoDocumentoYFecha(int TipoDocumento,String fecha)
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.*  \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                   INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id  \n" +
"  WHERE tipo_documento.tipo_documento_id=? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setInt(1, TipoDocumento);
            ps.setString(2, "%"+fecha+"%");
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                
                          public ArrayList<InventarioVenta>BuscarPorProductoYTipoDocumentoYFecha(String buscar,String  fecha, int tipoDocumento )
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR  "+
 "  forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? AND tipo_documento.tipo_documento_id=? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setString(2, buscar);
            ps.setString(3, buscar);
            ps.setString(4, buscar);
            ps.setString(5, buscar);
            ps.setString(6, buscar);
            ps.setString(7, buscar);
            ps.setString(8, buscar);
            ps.setString(9, buscar);
            ps.setString(10, buscar);
            ps.setString(11, buscar);
            ps.setString(12, buscar);
            ps.setInt(13, tipoDocumento);
            ps.setString(14, "%"+fecha+"%");
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                      public ArrayList<InventarioVenta>BuscarPorProductoYTipoDocumento(String buscar,int tipoDocumento )
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + "INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id  "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? AND tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setInt(2, tipoDocumento);
         
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                      public ArrayList<InventarioVenta>BuscarPorNumeroDocumentoYTipoDocumento(String buscar,int tipoDocumento )
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.*,presentacion.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario "
                    + " INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "+
  " WHERE documento.documento_numero_documento LIKE ? AND tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setInt(2, tipoDocumento);
         
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("inventario_venta_cantidad_total"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                           public ArrayList<InventarioVenta>Productomasvendido()
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT (SELECT SUM(inventario_venta_cantidad_total))AS SUMA,producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id INNER JOIN usuario ON inventario_venta.inventario_venta_usuario=usuario.idUsuario GROUP BY inventario_venta_producto_id ORDER BY `SUMA` DESC LIMIT 3";
            ps=this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("SUMA"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                           
                                                        public ArrayList<InventarioVenta>Productomenosvendido()
    {
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT (SELECT SUM(inventario_venta_cantidad_total))AS SUMA,producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id INNER JOIN usuario ON inventario_venta.inventario_venta_usuario=usuario.idUsuario GROUP BY inventario_venta_producto_id ORDER BY `SUMA` ASC LIMIT 3";
            ps=this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("SUMA"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                                     public ArrayList<InventarioVenta>Productomasvendidohoy()
    {
        Calendar miCalendario = Calendar.getInstance();
           int dia = miCalendario.get(Calendar.DAY_OF_MONTH);
           int mes = miCalendario.get(Calendar.MONTH) + 1;
           int year = miCalendario.get(Calendar.YEAR);
               int n = mes;
        int res=0;
        int d=10;
        int cifra=0;
        do{
        res = n % d;
        cifra++;
        d=d*10;
        }while(res != n);
        ///////////////////
               int nn = dia;
        int ress=0;
        int dd=10;
        int cifraa=0;
        do{
        ress = nn % dd;
        cifraa++;
        dd=dd*10;
        }while(ress != nn);
        ///////////
        String ano = "";
       if(cifra==1&&cifraa==2){
           ano = year + "-" + "0"+mes + "-" + dia;
       }
       if(cifra==1&&cifraa==1){
           ano = year + "-" + "0"+mes + "-0" + dia;
       }
       if(cifra==2&&cifraa==2){
          ano =year + "-" + mes + "-" + dia;
       }
       if(cifra==2&&cifraa==1){
          ano =year + "-" + mes + "-0" + dia;
       }
            this.mensaje=null;
     ArrayList<InventarioVenta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
          
            String consulta = "SELECT (SELECT SUM(inventario_venta_cantidad_total))AS SUMA,producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id INNER JOIN usuario ON inventario_venta.inventario_venta_usuario=usuario.idUsuario WHERE inventario_venta.inventario_venta_fecha_registro LIKE ? GROUP BY inventario_venta_producto_id ORDER BY `SUMA` DESC LIMIT 3";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,"%"+ano+"%");
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioVenta unInventarioVenta = new InventarioVenta();
                unInventarioVenta.getUnDetalleProducto().setIdProducto(rs.getString("inventario_venta_producto_id"));
                unInventarioVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventarioVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventarioVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unInventarioVenta.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventarioVenta.setFecharegistro(rs.getString("inventario_venta_fecha_registro"));
                unInventarioVenta.setCantidadTotal(rs.getInt("SUMA"));
                unInventarioVenta.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unInventarioVenta.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unInventarioVenta.setEstado(rs.getString("inventario_venta_estado"));
                unInventarioVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventarioVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
       
}
