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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"INNER JOIN usuario ON inventario_venta.inventario_venta_usuario=usuario.idUsuario\n" +
"ORDER BY inventario_venta.inventario_venta_fecha_registro DESC";
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  WHERE documento.documento_numero_documento=? ORDER BY inventario_venta.inventario_venta_fecha_registro DESC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, factura);
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
              public boolean desactivado(int cantidad,String fecha,String codigo){
                  boolean desactivado=false;
                  try
        {
             this.miConexion.setAutoCommit(false);
              String consulta= "UPDATE inventario_venta SET inventario_venta_estado = 'I' where 	inventario_venta_cantidad_total=? and inventario_venta_fecha_registro=? AND inventario_venta_producto_id =?";
                ps=miConexion.prepareStatement(consulta);
                ps.setInt(1,cantidad);
                ps.setString(2,fecha);
                ps.setString(3,codigo);
                ps.executeUpdate();
                 String consulta2= "UPDATE venta SET venta_estado = 'I' where 	venta_cantidad=	? and venta_fecha_registro=? AND venta_producto_id  =?";
                ps=miConexion.prepareStatement(consulta2);
                ps.setInt(1,cantidad);
                ps.setString(2,fecha);
                ps.setString(3,codigo);
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                    INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  \n" +
"   WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR \n" +
"   forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? ORDER BY inventario_venta_fecha_registro";
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                 INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                    INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                   INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario " +
"   WHERE  inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, "%"+fecha+"%");
    
            
            
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR  "+
 "  forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro";
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                   INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  \n" +
"  WHERE tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setInt(1, TipoDocumento);
      
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* \n" +
"                   FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id \n" +
"                   INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id \n" +
"                    INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id \n" +
"                    INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  \n" +
"  WHERE tipo_documento.tipo_documento_id=? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setInt(1, TipoDocumento);
            ps.setString(2, "%"+fecha+"%");
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? OR producto.producto_referencia LIKE ? OR producto.producto_nombre LIKE ? OR producto.producto_abreviatura LIKE ? OR  "+
 "  forma.forma_descripcion LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ?  OR documento.documento_numero_documento LIKE ? OR forma.forma_descripcion LIKE ? OR  usuario.usuario_identificacion LIKE ? OR usuario.usuario_nombre LIKE ? OR inventario_venta_estado LIKE ? AND tipo_documento.tipo_documento_id=? AND inventario_venta_fecha_registro LIKE ? ORDER BY inventario_venta_fecha_registro";
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "+
  " WHERE inventario_venta.inventario_venta_producto_id LIKE ? AND tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setInt(2, tipoDocumento);
         
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
            String consulta = "SELECT producto.*, inventario_venta.*, detalle_producto.*, unidad_medida.*, documento.*, tipo_documento.*,forma.*,usuario.* " +
                  " FROM inventario_venta INNER JOIN producto ON inventario_venta.inventario_venta_producto_id = producto.producto_id "+
                  "  INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "+ 
                  "  INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "+
                  "  INNER JOIN documento ON inventario_venta.inventario_venta_documento = documento.documento_id "+
                  "  INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id "+
                  "  INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id "+
                  "  INNER JOIN usuario on inventario_venta.inventario_venta_usuario=usuario.idUsuario  "+
  " WHERE documento.documento_numero_documento LIKE ? AND tipo_documento.tipo_documento_id=? ORDER BY inventario_venta_fecha_registro";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1, buscar);
            ps.setInt(2, tipoDocumento);
         
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
}
