/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.Movimiento;
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
public class DatosMovimiento {
       private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosMovimiento()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

    public ArrayList<Movimiento> listarMovimiento()
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
         public  ArrayList<Movimiento> buscarMovimiento(String buscar)
    {
            this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT(SELECT infraestructura_descripcion FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho)AS DESPACHO,\n" +
"movimiento.*,\n" +
"infraestructura.*,\n" +
"transaccion.*,\n" +
"producto.*,\n" +
"detalle_producto.*,\n" +
"documento.*,\n" +
"unidad_medida.*,\n" +
"forma.*,\n" +
"grupo.*,\n" +
"presentacion.*,\n" +
"tipo_documento.*,\n" +
"usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario = usuario.idUsuario\n" +
"INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id\n" +
"WHERE\n" +
"  producto.producto_id LIKE ? OR  infraestructura.infraestructura_descripcion LIKE ? OR transaccion.transaccion_descripcion LIKE ? OR movimiento.movimiento_numero_factura LIKE ? OR producto.producto_nombre LIKE ? OR forma.forma_descripcion LIKE ? OR detalle_producto.detalle_producto_cantidad_medida LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR grupo.grupo_descripcion LIKE ? OR movimiento.movimiento_fecha_resgistro LIKE ? OR movimiento.movimiento_cantidad LIKE ? OR documento.documento_numero_documento LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ? OR movimiento.movimiento_observacion LIKE ? OR usuario.usuario_nombre = ?";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,buscar);
            ps.setString(7,buscar);
            ps.setString(8,buscar);
            ps.setString(9,buscar);
            ps.setString(10,buscar);
            ps.setString(11,buscar);
            ps.setString(12,buscar);
            ps.setString(13,buscar);
            ps.setString(14,buscar);
            ps.setString(15,buscar);
            
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("DESPACHO"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
           public ArrayList<Movimiento> BuscarMovimientoPorFecha(String fecha)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where movimiento_fecha_resgistro like ? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
           
                    public ArrayList<Movimiento> BuscarMovimientoPorFechaYNumeroDocumento(String fecha,String numeroDocumento)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where movimiento_fecha_resgistro like ? AND documento_numero_documento=? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         ps.setString(2,numeroDocumento);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                         public ArrayList<Movimiento> BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento(String fecha,String numeroDocumento,int tipoDocumento)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where movimiento_fecha_resgistro like ? AND documento_numero_documento=? AND tipo_documento_id=? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         ps.setString(2,numeroDocumento);
         ps.setInt(3,tipoDocumento);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                         
                                  public ArrayList<Movimiento> BuscarMovimientoPorFechaYCodigoProductoYTipoDocumento(String fecha,String codigoProducto,int tipoDocumento)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where movimiento_fecha_resgistro like ? AND 	movimiento_producto_id=? AND tipo_documento_id=? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         ps.setString(2,codigoProducto);
         ps.setInt(3,tipoDocumento);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                                  
                                                                            public ArrayList<Movimiento> BuscarMovimientoTipoDocumento(int tipoDocumento)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where tipo_documento_id=? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         
         ps.setInt(1,tipoDocumento);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
    
                      public ArrayList<Movimiento> BuscarMovimientoTipoDocumentoYFecha(String fecha,int tipoDocumento)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     String consulta="SELECT\n" +
"   (SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho ),\n" +
"    movimiento.*,\n" +
"    infraestructura.*,\n" +
"    transaccion.*,\n" +
"    producto.*,\n" +
"    detalle_producto.*,\n" +
"    documento.*,\n" +
"    unidad_medida.*,\n" +
"    forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"    tipo_documento.*,\n" +
"    usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario=usuario.idUsuario \n" +
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where movimiento_fecha_resgistro like ? AND tipo_documento_id=? ORDER BY movimiento.movimiento_fecha_resgistro DESC";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1,"%"+fecha+"%");
         ps.setInt(2,tipoDocumento);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("(SELECT infraestructura_descripcion AS despacho FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho )"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                      
                                public ArrayList<Movimiento> BuscarMovimientoPorFechaYProductoCodigo(String fecha,String buscar)
   {
     this.mensaje=null;
     ArrayList<Movimiento> lista= new ArrayList<>();
     try
     {
     String consulta = "SELECT(SELECT infraestructura_descripcion FROM infraestructura WHERE infraestructura_id=movimiento_infraestructura_despacho)AS DESPACHO,\n" +
"movimiento.*,\n" +
"infraestructura.*,\n" +
"transaccion.*,\n" +
"producto.*,\n" +
"detalle_producto.*,\n" +
"documento.*,\n" +
"unidad_medida.*,\n" +
"forma.*,\n" +
"grupo.*,\n" +
"presentacion.*,\n" +
"tipo_documento.*,\n" +
"usuario.*\n" +
"FROM\n" +
"    movimiento\n" +
"INNER JOIN infraestructura ON movimiento.movimiento_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN transaccion ON movimiento.movimiento_transaccion_id = transaccion.transaccion_id\n" +
"INNER JOIN producto ON movimiento.movimiento_producto_id = producto.producto_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id\n" +
"INNER JOIN documento ON movimiento.movimiento_documento = documento.documento_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id\n" +
"INNER JOIN usuario ON movimiento.movimiento_usuario = usuario.idUsuario\n" +
"INNER JOIN tipo_documento ON documento.documento_tipo_documento = tipo_documento.tipo_documento_id\n" +
"WHERE\n" +
"  producto.producto_id LIKE ? OR  infraestructura.infraestructura_descripcion LIKE ? OR transaccion.transaccion_descripcion LIKE ? OR movimiento.movimiento_numero_factura LIKE ? OR producto.producto_nombre LIKE ? OR forma.forma_descripcion LIKE ? OR detalle_producto.detalle_producto_cantidad_medida LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR grupo.grupo_descripcion LIKE ?  OR movimiento.movimiento_cantidad LIKE ? OR documento.documento_numero_documento LIKE ? OR tipo_documento.tipo_documento_descripcion LIKE ? OR movimiento.movimiento_observacion LIKE ? OR usuario.usuario_nombre = ? OR movimiento.movimiento_fecha_resgistro LIKE ?";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,buscar);
            ps.setString(7,buscar);
            ps.setString(8,buscar);
            ps.setString(9,buscar);
            ps.setString(10,buscar);
            ps.setString(11,buscar);
            ps.setString(12,buscar);
            ps.setString(13,buscar);
            ps.setString(14,buscar);
            ps.setString(15,"%"+fecha+"%");
            
         rs= ps.executeQuery();
         while(rs.next())
         {
               Movimiento unMovimiento = new Movimiento();
                unMovimiento.setIdMovimiento(rs.getInt("movimiento_id"));
                unMovimiento.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unMovimiento.getUnaTransaccion().setDescripcion(rs.getString("transaccion_descripcion"));
                unMovimiento.setNumerofactura(rs.getInt("movimiento_numero_factura"));
                unMovimiento.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unMovimiento.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unMovimiento.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unMovimiento.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unMovimiento.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unMovimiento.setFecharegistro(rs.getString("movimiento_fecha_resgistro"));
                unMovimiento.setCantidad(rs.getInt("movimiento_cantidad"));
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setDescripcion(rs.getString("tipo_documento_descripcion"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
                unMovimiento.getUnaInfraestructuraDespacho().setDescripcion(rs.getString("DESPACHO"));
                unMovimiento.setObservacion(rs.getString("movimiento_observacion"));
                unMovimiento.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unMovimiento);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
                                

}
