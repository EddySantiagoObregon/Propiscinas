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
     String consulta=" SELECT proveedor.*,proveedor_producto.*,producto.*,detalle_producto.*,presentacion.*,grupo.*,forma.*,unidad_medida.*,proveedor_producto_compra.*\n" +
"FROM proveedor_producto_compra\n" +
"INNER JOIN proveedor_producto ON proveedor_producto_compra.proveedor_producto_id=proveedor_producto.proveedor_producto_id\n" +
"INNER JOIN producto ON proveedor_producto.proveedor_producto_producto_id=producto.producto_id\n" +
"INNER JOIN proveedor ON proveedor_producto.proveedor_producto_proveedor_id=proveedor.proveedor_id\n" +
"INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id\n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
              ProveedorProductoCompra unProveedorProductoCompra = new ProveedorProductoCompra();
                unProveedorProductoCompra.setIdProveedorProductoCompra(rs.getInt("proveedor_id"));
                unProveedorProductoCompra.getUnProveedorProducto().getUnProducto().setNombre(rs.getString("proveedor_nombre"));
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