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

    public class DatosAutocompletar {
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosAutocompletar()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<String> AutocompletarProveedor(String find)
   {
     this.mensaje=null;
     ArrayList<String> names= new ArrayList<>();
     String consulta="select 	proveedor_nombre from proveedor where proveedor_nombre like ? limit 10";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1, find+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
             names.add(rs.getString("proveedor_nombre"));
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return names;
   }
   public ArrayList<String> AutocompletarProducto(String find)
   {
     this.mensaje=null;
     ArrayList<String> names= new ArrayList<>();
     String consulta="SELECT (SELECT DISTINCT concat_ws(' ', producto_id, producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom),producto.*,detalle_producto.*,forma.*,unidad_medida.*,presentacion.* FROM detalle_producto\n" +
"INNER JOIN producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id WHERE  producto_nombre like ? limit 10 ";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         ps.setString(1, find+"%");
         rs= ps.executeQuery();
         while(rs.next())
         {
             names.add(rs.getString("(SELECT DISTINCT concat_ws(' ', producto_id, producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom)"));
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return names;
   }
}

