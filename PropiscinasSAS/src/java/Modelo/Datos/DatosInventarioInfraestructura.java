/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;

import Controller.Conexion;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.InventarioInfraestructura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosInventarioInfraestructura {
    private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosInventarioInfraestructura()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
    public InventarioInfraestructura elegido(String id,String infraestructura)
    {
        InventarioInfraestructura unInventario = null;
            this.mensaje=null;

        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT * FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? and inventario_infraestructura_id=?";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,id);
            ps.setString(2,infraestructura);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                unInventario = new InventarioInfraestructura();
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("inventario_infraestructura_id"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
             
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
              
        
    
       return unInventario;
}
        public InventarioInfraestructura elegido2(String id,String infraestructura)
    {
        InventarioInfraestructura unInventario = null;
            this.mensaje=null;

        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT * FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? and inventario_infraestructura_id=?";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,id);
            ps.setString(2,infraestructura);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                unInventario = new InventarioInfraestructura();
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("inventario_infraestructura_id"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
             
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
              
        
    
       return unInventario;
}
    public ArrayList<InventarioInfraestructura> listaInventario(){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* "+
"FROM inventario_infraestructura " +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id " +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id " +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id " +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id " +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id " +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id " +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario " +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
          
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
    public ArrayList<InventarioInfraestructura> listaInventario(int id){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* "+
"FROM inventario_infraestructura " +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id " +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id " +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id " +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id " +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id " +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id " +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario "+                
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  where inventario_infraestructura.inventario_infraestructura_id=? ORDER BY inventario_fecha_registro DESC";
   ps=this.miConexion.prepareStatement(consulta);
      ps.setInt(1,id );
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
  
     public ArrayList<InventarioInfraestructura> listaInventarioCantidadActual(){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta=" SELECT  inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id\n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  \n" +
"ORDER BY inventario_infraestructura_cantidad_actual.inventario_cantidad_total ASC";
   ps=this.miConexion.prepareStatement(consulta);
          
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}   
      public ArrayList<InventarioInfraestructura> listaInventarioCantidadActualInfraestructura(int infraestructura){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta=" SELECT  inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual " +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id " +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id " +
"INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id " +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id " +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id " +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id " +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id WHERE infraestructura.infraestructura_id=?  ORDER BY inventario_fecha_registro DESC";
   ps=this.miConexion.prepareStatement(consulta);
          ps.setInt(1,infraestructura);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}   
     
  //Este metodo lo que hace es traer el total de todos los productos de ambas infrasestucturas unidas
          public ArrayList<InventarioInfraestructura> totalProductosInfraestructura(){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
             
        String consulta="SELECT SUM(inventario_cantidad_total) AS SUMA,inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id  INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id\n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id group by inventario_producto_id  \n" +
"ORDER BY SUMA ASC";
   ps=this.miConexion.prepareStatement(consulta);
          
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("SUMA"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
             public ArrayList<InventarioInfraestructura> totalProductosInfraestructuraYcodigo(String codigo){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
             
        String consulta="SELECT SUM(inventario_cantidad_total) AS SUMA,inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id  INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id\n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id WHERE producto.producto_id=? group by inventario_producto_id  \n" +
"ORDER BY SUMA ASC";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,codigo);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("SUMA"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                public ArrayList<InventarioInfraestructura> BuscarProductoCantidadActualPorNombreYInfraestructura(String nombre,int infraestructura){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id WHERE infraestructura.infraestructura_id=? AND producto.producto_id=?  ORDER BY inventario_fecha_registro DESC";
   ps=this.miConexion.prepareStatement(consulta);
          ps.setInt(1,infraestructura);
          ps.setString(2, nombre);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}   
                         public ArrayList<InventarioInfraestructura> BuscarProductoCantidadActualPorCodigoYInfraestructura(String codigo,int infraestructura){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id WHERE infraestructura.infraestructura_id=? AND producto.producto_id  LIKE '?'  ORDER BY inventario_fecha_registro DESC";
   ps=this.miConexion.prepareStatement(consulta);
          ps.setInt(1,infraestructura);
          ps.setString(2, codigo);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}   
          public ArrayList<InventarioInfraestructura>buscarProducto(String buscar)
    {
            this.mensaje=null;
     ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT  inventario_infraestructura_cantidad_actual.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.* \n" +
"FROM inventario_infraestructura_cantidad_actual \n" +
"INNER JOIN producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura_cantidad_actual.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura_cantidad_actual.inventario_producto_id=detalle_producto.detalle_producto_producto_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id WHERE inventario_infraestructura_cantidad_actual.inventario_producto_id LIKE ? OR producto.producto_nombre LIKE ?  OR inventario_cantidad_total LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR presentacion.presentacion_descripcion LIKE ? OR grupo.grupo_descripcion LIKE ? OR 	infraestructura.infraestructura_descripcion LIKE ?  ORDER BY inventario_fecha_registro DESC ";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,buscar);
            ps.setString(7,buscar);
         
           
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
               
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}

           public ArrayList<InventarioInfraestructura> listaInventarioPorFecha(String fecha){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* "+
"FROM inventario_infraestructura " +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id " +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id " +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id " +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id " +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id " +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id " +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario " +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  WHERE inventario_fecha_registro LIKE ? ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
           ps.setString(1,"%"+fecha+"%");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
            public ArrayList<InventarioInfraestructura> listaInventarioPorFechaYCodigo(String fecha,String codigo){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* \n" +
"FROM inventario_infraestructura \n" +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id \n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  WHERE inventario_fecha_registro LIKE ? AND inventario_infraestructura.inventario_producto_id=? ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
           ps.setString(1,"%"+fecha+"%");
           ps.setString(2,codigo);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
            
                                public ArrayList<InventarioInfraestructura> listaInventarioPorFechaYNombre(String fecha,String nombre){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* \n" +
"FROM inventario_infraestructura \n" +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id \n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  WHERE inventario_fecha_registro LIKE ? AND producto.producto_nombre=? ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
           ps.setString(1,"%"+fecha+"%");
           ps.setString(2,nombre);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
            
                          public ArrayList<InventarioInfraestructura> listaInventarioPorFechaYCodigoYInfraestructura(String fecha,String codigo,int infraestructura){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* \n" +
"FROM inventario_infraestructura \n" +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id \n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  WHERE inventario_fecha_registro LIKE ? AND inventario_infraestructura.inventario_producto_id=? AND inventario_infraestructura.inventario_infraestructura_id= ? ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
           ps.setString(1,"%"+fecha+"%");
           ps.setString(2,codigo);
           ps.setInt(3,infraestructura);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                          public ArrayList<InventarioInfraestructura> listaInventarioPorFechaYNombreYInfraestructura(String fecha,String nombrePro,int infraestructura){
        ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try{
        String consulta="SELECT  inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* \n" +
"FROM inventario_infraestructura \n" +
"INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id \n" +
"INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id \n" +
"INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario \n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id  WHERE inventario_fecha_registro LIKE ? AND producto.producto_nombre=? AND inventario_infraestructura.inventario_infraestructura_id= ? ORDER BY inventario_fecha_registro DESC ";
   ps=this.miConexion.prepareStatement(consulta);
           ps.setString(1,"%"+fecha+"%");
           ps.setString(2,nombrePro);
           ps.setInt(3,infraestructura);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
                lista.add(unInventario);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                          
                                       public ArrayList<InventarioInfraestructura>buscarInventarioDatosHistoricos(String buscar)
    {
            this.mensaje=null;
     ArrayList<InventarioInfraestructura> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT inventario_infraestructura.*, producto.*, infraestructura.*,infraestructura.*, detalle_producto.*, grupo.*,forma.*,presentacion.*,unidad_medida.*,usuario.* FROM inventario_infraestructura \n" +
"                  INNER JOIN producto on inventario_infraestructura.inventario_producto_id=producto.producto_id \n" +
"                    INNER JOIN infraestructura on inventario_infraestructura.inventario_infraestructura_id=infraestructura.infraestructura_id \n" +
"                   INNER JOIN detalle_producto on inventario_infraestructura.inventario_producto_id=detalle_producto.detalle_producto_producto_id \n" +
"                   INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id \n" +
"                    INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id \n" +
"                    INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id \n" +
"                    INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id \n" +
"                    INNER JOIN usuario ON inventario_infraestructura.inventario_usuario=usuario.idUsuario "
                    + "WHERE inventario_infraestructura.inventario_producto_id LIKE ? OR producto.producto_nombre LIKE ?  OR inventario_cantidad_total LIKE ? OR unidad_medida.unidad_medida_descripcion LIKE ? OR presentacion.presentacion_descripcion LIKE ? OR grupo.grupo_descripcion LIKE ? OR 	infraestructura.infraestructura_descripcion LIKE ?  ORDER BY inventario_fecha_registro DESC ";
            ps=this.miConexion.prepareStatement(consulta);
            ps.setString(1,buscar);
            ps.setString(2,buscar);
            ps.setString(3,buscar);
            ps.setString(4,buscar);
            ps.setString(5,buscar);
            ps.setString(6,buscar);
            ps.setString(7,buscar);
         
           
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                InventarioInfraestructura unInventario = new InventarioInfraestructura();
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.setFecha(rs.getString("inventario_fecha_registro"));
                unInventario.getUnDetalleProducto().setNombre(rs.getString("producto_nombre"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unInventario.getUnDetalleProducto().setCantidadUnidad(rs.getDouble("detalle_producto_cantidad_medida"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unInventario.getUnDetalleProducto().getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unInventario.getUnDetalleProducto().getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unInventario.getUnaInfraestructura().setDescripcion(rs.getString("infraestructura_descripcion"));
                unInventario.setObservacion(rs.getString("inventario_observacion"));
                unInventario.getUnUsuario().setNombre(rs.getString("usuario_nombre"));
               
                lista.add(unInventario);
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
