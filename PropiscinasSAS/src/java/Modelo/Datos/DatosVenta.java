/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

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
public class DatosVenta{
   
    
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosVenta()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   
   public int cantidad(String idProducto){
       int cantidad =0;
        try
       {
           this.miConexion.setAutoCommit(false); 
       
       String consulta2="SELECT inventario_cantidad_total FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? AND inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta2);
                ps.setString(1,idProducto);
                ps.setInt(2,1);
                rs= ps.executeQuery();
             
                if(rs.next())
                {
                cantidad= rs.getInt("inventario_cantidad_total");
                }
                 }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return cantidad;
       
   }
 public boolean RegistrarVenta(Venta unaVenta,InventarioVenta unInventarioVenta,Documento unDocumento,String idProducto,int idUsuario){
      
        boolean agregado = false;
     
       this.mensaje=null;
     try
       {
           this.miConexion.setAutoCommit(false); 
       
           //Selecciona el ultimo id de la tabla autoincrementable
      String consulta5= "insert into documento values(null,?,?,?)";
            ps=miConexion.prepareStatement(consulta5);
            ps.setString(1,unDocumento.getNumerodocumento());
            ps.setInt(2,unDocumento.getUnTipoDocumento().getIdTipoDocumento());
            ps.setString(3,unDocumento.getObservacion());
            ps.executeUpdate();
             String consultica="select documento_id from documento where documento_numero_documento=?";
            ps=miConexion.prepareStatement(consultica);
            ps.setString(1,unDocumento.getNumerodocumento());
            rs= ps.executeQuery();
            int idDocumento=0;
            if(rs.next())
            {
               idDocumento= rs.getInt("documento_id");
            }
        String consulta2="insert into inventario_venta "
             + " values(?,?,?,?,?,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,idProducto);
            ps.setString(2,unInventarioVenta.getFecharegistro());
            ps.setDouble(3,unInventarioVenta.getCantidadTotal());
            ps.setInt(4,unInventarioVenta.getUnaUnidadMedida().getIdUnidadMedida());
            ps.setInt(5,idDocumento);
            ps.setString(6,unInventarioVenta.getObservacion());
            ps.setString(7,unInventarioVenta.getEstado());
            ps.setInt(8,idUsuario);
            
            ps.executeUpdate();
            
                                   
         
            
            String consulta3="insert into venta "
             + " values(?,?,?,?,?,?,?)"; 
            ps=miConexion.prepareStatement(consulta3);
            ps.setString(1,idProducto);      
            ps.setString(2,unaVenta.getFecharegistro());
            ps.setDouble(3,unaVenta.getCantidad());
            ps.setString(4,unaVenta.getValor());
            ps.setString(5,unaVenta.getObservacion());
            ps.setString(6,unaVenta.getEstado());
            ps.setInt(7, idUsuario);
            ps.executeUpdate();
            agregado = true;
            
            
           rs.close();
          this.miConexion.commit();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return agregado;
   }
 public int UnidadMedida(String idProducto){
     int UnidadMedida = 0;
     try{
                String Consulta= "SELECT detalle_unidad_medida FROM detalle_producto WHERE detalle_producto_producto_id=?";
                ps=miConexion.prepareStatement(Consulta);
                ps.setString(1,idProducto);
                rs= ps.executeQuery();
              
               
                if(rs.next())
                {
                UnidadMedida= rs.getInt("detalle_unidad_medida");
               
                }
         
            
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
     return UnidadMedida;
 }
             public ArrayList<Venta>listarVenta()
    {
            this.mensaje=null;
     ArrayList<Venta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,venta.*,producto.*,forma.*,unidad_medida.*,presentacion.*,usuario.* FROM venta \n" +
"                    INNER JOIN producto ON venta.venta_producto_id=producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"                    INNER JOIN usuario ON venta.venta_usuario=usuario.idUsuario\n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"                    INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"                    ORDER BY venta.venta_fecha_registro DESc";
            ps=this.miConexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                Venta unaVenta = new Venta();
                unaVenta.getUnDetalleProducto().setIdProducto(rs.getString("detalle_producto_producto_id"));
                unaVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                 unaVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                 unaVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                 unaVenta.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                  unaVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unaVenta.setFecharegistro(rs.getString("venta_fecha_registro"));
                unaVenta.setCantidad(rs.getInt("venta_cantidad"));
                unaVenta.setValor(rs.getString("venta_valor"));
                unaVenta.setEstado(rs.getString("venta_estado"));
                unaVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
               
                
                lista.add(unaVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;

    }
          public ArrayList<Venta>BuscarVenta(String buscar)
    {
            this.mensaje=null;
     ArrayList<Venta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta =
                   "SELECT detalle_producto.*,venta.*,producto.*,forma.*,unidad_medida.*,presentacion.*,usuario.* FROM venta \n" +
"                    INNER JOIN producto ON venta.venta_producto_id=producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"                    INNER JOIN usuario ON venta.venta_usuario=usuario.idUsuario\n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"                    INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
                    "WHERE producto.producto_nombre LIKE ? OR   producto.producto_id LIKE ? OR venta.venta_valor LIKE ? OR  venta.venta_cantidad LIKE ? OR forma.forma_descripcion LIKE ? OR venta_fecha_registro LIKE ? OR usuario.usuario_nombre LIKE ? OR usuario.usuario_identificacion LIKE ? ORDER BY venta.venta_fecha_registro DESC";
                    ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,buscar);
            ps.setString(7,buscar);
            ps.setString(8,buscar);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                Venta unaVenta = new Venta();
                unaVenta.getUnDetalleProducto().setIdProducto(rs.getString("detalle_producto_producto_id"));
                unaVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                 unaVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                   unaVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                 unaVenta.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                  unaVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unaVenta.setFecharegistro(rs.getString("venta_fecha_registro"));
                unaVenta.setCantidad(rs.getInt("venta_cantidad"));
                unaVenta.setValor(rs.getString("venta_valor"));
                unaVenta.setEstado(rs.getString("venta_estado"));
                unaVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
               
                
                lista.add(unaVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
            public ArrayList<Venta>BuscarVentaPorFechaYAtributosProducto(String buscar,String fecha)
    {
            this.mensaje=null;
     ArrayList<Venta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta =
                      "SELECT detalle_producto.*,venta.*,producto.*,forma.*,unidad_medida.*,presentacion.*,usuario.* FROM venta \n" +
"                    INNER JOIN producto ON venta.venta_producto_id=producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"                    INNER JOIN usuario ON venta.venta_usuario=usuario.idUsuario\n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"                    INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
                    "WHERE producto.producto_nombre LIKE ? OR   producto.producto_id LIKE ? OR venta.venta_valor LIKE ? OR  venta.venta_cantidad LIKE ? OR forma.forma_descripcion LIKE ? OR venta_fecha_registro LIKE ? OR usuario.usuario_nombre LIKE ? OR usuario.usuario_identificacion LIKE ? ORDER BY venta.venta_fecha_registro DESC";
                    ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,"%"+fecha+"%");
            ps.setString(7,buscar);
            ps.setString(8,buscar);
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                Venta unaVenta = new Venta();
                unaVenta.getUnDetalleProducto().setIdProducto(rs.getString("detalle_producto_producto_id"));
                unaVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                 unaVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                    unaVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                 unaVenta.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                  unaVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unaVenta.setFecharegistro(rs.getString("venta_fecha_registro"));
                unaVenta.setCantidad(rs.getInt("venta_cantidad"));
                unaVenta.setValor(rs.getString("venta_valor"));
                unaVenta.setEstado(rs.getString("venta_estado"));
                unaVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
               
                
                lista.add(unaVenta);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
             public ArrayList<Venta>BuscarVentaPorFecha(String fecha)
    {
            this.mensaje=null;
     ArrayList<Venta> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta =
                      "SELECT detalle_producto.*,venta.*,producto.*,forma.*,unidad_medida.*,presentacion.*,usuario.* FROM venta \n" +
"                    INNER JOIN producto ON venta.venta_producto_id=producto.producto_id \n" +
"                    INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"                    INNER JOIN usuario ON venta.venta_usuario=usuario.idUsuario\n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"                    INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
                    "WHERE venta_fecha_registro LIKE ?  ORDER BY venta.venta_fecha_registro DESC";
                    ps=this.miConexion.prepareStatement(consulta);
                    ps.setString(1,"%"+fecha+"%");
                    rs = ps.executeQuery();
            
           while(rs.next())
            {
                Venta unaVenta = new Venta();
                unaVenta.getUnDetalleProducto().setIdProducto(rs.getString("detalle_producto_producto_id"));
                unaVenta.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unaVenta.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                 unaVenta.getUnDetalleProducto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                 unaVenta.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                  unaVenta.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unaVenta.setFecharegistro(rs.getString("venta_fecha_registro"));
                unaVenta.setCantidad(rs.getInt("venta_cantidad"));
                unaVenta.setValor(rs.getString("venta_valor"));
                unaVenta.setEstado(rs.getString("venta_estado"));
                unaVenta.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unaVenta);
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