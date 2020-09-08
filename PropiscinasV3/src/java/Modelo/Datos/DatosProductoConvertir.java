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
import Modelo.Entidad.InventarioInfraestructura;
import Modelo.Entidad.Movimiento;
import Modelo.Entidad.ProductoConvertir;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PAULA
 */
public class DatosProductoConvertir {
     private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosProductoConvertir()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   

   public ArrayList<ProductoConvertir> ListarProductoConvertir()
   {
     this.mensaje=null;
     ArrayList<ProductoConvertir> lista= new ArrayList<>();
     String consulta="SELECT convertir_producto.*, detalle_producto.*, producto.*, grupo.*, presentacion.*, unidad_medida.*, forma.* FROM convertir_producto INNER JOIN producto ON convertir_producto.conventir_producto_galon_caneca_bulto = producto.producto_id INNER JOIN detalle_producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
            {
                ProductoConvertir unProductoConvertir = new ProductoConvertir();
                unProductoConvertir.setIdProductoConvertir(rs.getInt("producto_id"));
                unProductoConvertir.getGaloncanecabulto().setIdProducto(rs.getString("conventir_producto_galon_caneca_bulto"));
                unProductoConvertir.getBotellabolsa().setIdProducto(rs.getString("convertir_producto_botella_bolsa"));
                unProductoConvertir.getGaloncanecabulto().setNombre("producto_nombre");
                unProductoConvertir.getGaloncanecabulto().getUnaForma().setDescripcion("forma_descripcion");
                unProductoConvertir.getGaloncanecabulto().setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unProductoConvertir.getGaloncanecabulto().getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                lista.add(unProductoConvertir);
            }
             rs.close();
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
   public ArrayList<ProductoConvertir> ListarProductoConvertirCb()
   {
     this.mensaje=null;
     ArrayList<ProductoConvertir> lista= new ArrayList<>();
     String consulta="SELECT * FROM convertir_producto";
     try
     {
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
             ProductoConvertir  unProductoConvertir= new ProductoConvertir(rs.getString("convertir_producto_nombre"));
             unProductoConvertir.setIdProductoConvertir(rs.getInt("convertir_producto_id"));
             lista.add(unProductoConvertir);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
   public InventarioInfraestructura unInvenratioo(int idProductoConvertir,int idInfraestructura){
        InventarioInfraestructura unInventario = new InventarioInfraestructura(); 
       boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
           String consulta1="SELECT  conventir_producto_galon_caneca_bulto,convertir_producto_cantidad_unidad FROM convertir_producto WHERE convertir_producto_id=?";
                ps=miConexion.prepareStatement(consulta1);
                ps.setInt(1,idProductoConvertir);
                rs= ps.executeQuery();
                String idProducto="";
                int cantidadMedida=0;
                if(rs.next())
                {
                idProducto= rs.getString("conventir_producto_galon_caneca_bulto");
                cantidadMedida = rs.getInt("convertir_producto_cantidad_unidad");
                }
            String consulta2="SELECT inventario_cantidad_total FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? AND inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta2);
                ps.setString(1,idProducto);
                ps.setInt(2,idInfraestructura);
                rs= ps.executeQuery();
                int cantidadActual=0;
                if(rs.next())
                {
                cantidadActual= rs.getInt("inventario_cantidad_total");
                }
                //Falta terminar de aca para abajo
        
              if(cantidadActual>0){
       
                   
        try{
        String consulta="SELECT\n" +
"    inventario_infraestructura_cantidad_actual.*,\n" +
"    producto.*,\n" +
"    infraestructura.*,\n" +
"    infraestructura.*,\n" +
"    detalle_producto.*,\n" +
"    grupo.*,\n" +
"    forma.*,\n" +
"    presentacion.*,\n" +
"    unidad_medida.*\n" +
"FROM\n" +
"    inventario_infraestructura_cantidad_actual\n" +
"INNER JOIN producto ON inventario_infraestructura_cantidad_actual.inventario_producto_id = producto.producto_id\n" +
"INNER JOIN infraestructura ON inventario_infraestructura_cantidad_actual.inventario_infraestructura_id = infraestructura.infraestructura_id\n" +
"INNER JOIN detalle_producto ON inventario_infraestructura_cantidad_actual.inventario_producto_id = detalle_producto.detalle_producto_producto_id\n" +
"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id\n" +
"INNER JOIN forma ON detalle_producto.detalle_producto_forma_id = forma.forma_id\n" +
"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id\n" +
"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id\n" +
"WHERE\n" +
"    inventario_infraestructura_cantidad_actual.inventario_infraestructura_id = ? AND inventario_infraestructura_cantidad_actual.inventario_producto_id = ?";
   ps=this.miConexion.prepareStatement(consulta);
           
           ps.setInt(1,idInfraestructura);
           ps.setString(2,idProducto);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
               
               
                unInventario.getUnDetalleProducto().setIdProducto(rs.getString("inventario_producto_id"));
                unInventario.getUnaInfraestructura().setIdInfraestructura(rs.getInt("inventario_infraestructura_id"));
                unInventario.setCantidad(rs.getInt("inventario_cantidad_total"));
                unInventario.getUnDetalleProducto().getUnaUnidadMedida().setIdUnidadMedida(rs.getInt("unidad_medida_id"));
              
            }
             rs.close();
              
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
      
             }
         
            this.miConexion.commit();
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
       
        return unInventario;
   }
      public  String  ReturnaIdBotellaoBosa(int idProductoConvertir,int idInfraestructura){
        String idProducto = "";
            try{  
         this.miConexion.setAutoCommit(false); 
       
           String consulta1="SELECT  convertir_producto_botella_bolsa FROM convertir_producto WHERE convertir_producto_id=?";
                ps=miConexion.prepareStatement(consulta1);
                ps.setInt(1,idProductoConvertir);
                rs= ps.executeQuery();
              
               
                if(rs.next())
                {
                idProducto= rs.getString("convertir_producto_botella_bolsa");
               
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
        
        
       
        return idProducto;
   }
        public  int  RetornaCantidadMedida(int idProductoConvertir,int idInfraestructura){
        int cantidadMedida = 0;
            try{  
         this.miConexion.setAutoCommit(false); 
       
           String consulta1="SELECT  convertir_producto_cantidad_unidad FROM convertir_producto WHERE convertir_producto_id=?";
                ps=miConexion.prepareStatement(consulta1);
                ps.setInt(1,idProductoConvertir);
                rs= ps.executeQuery();
              
                
                if(rs.next())
                {
                cantidadMedida = rs.getInt("convertir_producto_cantidad_unidad");
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
        
        
       
        return cantidadMedida;
   }
          public  int  CantidadActual(String idProducto,int idInfraestructura){
        int CantidadActual = 0;
            try{  
         this.miConexion.setAutoCommit(false); 
       
         
      
            String consulta2="SELECT inventario_cantidad_total FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? AND inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta2);
                ps.setString(1,idProducto);
                ps.setInt(2,idInfraestructura);
                rs= ps.executeQuery();
        
                if(rs.next())
                {
                CantidadActual= rs.getInt("inventario_cantidad_total");
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
        
        
       
        return CantidadActual;
   }
      public Movimiento unMovimiento(int idProductoConvertir,int idInfraestructura){
            Movimiento unMovimiento = new Movimiento();
       boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
           String consulta1="SELECT  conventir_producto_galon_caneca_bulto,convertir_producto_cantidad_unidad FROM convertir_producto WHERE convertir_producto_id=?";
                ps=miConexion.prepareStatement(consulta1);
                ps.setInt(1,idProductoConvertir);
                rs= ps.executeQuery();
                String idProducto="";
                int cantidadMedida=0;
                if(rs.next())
                {
                idProducto= rs.getString("conventir_producto_galon_caneca_bulto");
                cantidadMedida = rs.getInt("convertir_producto_cantidad_unidad");
                }
            String consulta2="SELECT inventario_cantidad_total FROM inventario_infraestructura_cantidad_actual WHERE inventario_producto_id=? AND inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta2);
                ps.setString(1,idProducto);
                ps.setInt(2,idInfraestructura);
                rs= ps.executeQuery();
                int cantidadActual=0;
                if(rs.next())
                {
                cantidadActual= rs.getInt("inventario_cantidad_total");
                }
                //Falta terminar de aca para abajo
        
              if(cantidadActual>0){
       
                   
        try{
       String consulta="SELECT\n" +
"    movimiento.*,\n" +
"   infraestructura.*,\n" +
"   transaccion.*,\n" +
"   producto.*,\n" +
"   detalle_producto.*,\n" +
"   documento.*,\n" +
"   unidad_medida.*,\n" +
"  forma.*,\n" +
"   grupo.*,\n" +
"   presentacion.*,\n" +
"   tipo_documento.*\n" +
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
"INNER JOIN tipo_documento on documento.documento_tipo_documento=tipo_documento.tipo_documento_id where infraestructura.infraestructura_id=? AND producto.producto_id=?";
   ps=this.miConexion.prepareStatement(consulta);
           
           ps.setInt(1,idInfraestructura);
           ps.setString(2,idProducto);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                         
                
                unMovimiento.getUnDocumento().setNumerodocumento(rs.getString("documento_numero_documento"));
                unMovimiento.getUnDocumento().getUnTipoDocumento().setIdTipoDocumento(rs.getInt("tipo_documento_id"));
                unMovimiento.getUnDocumento().setObservacion(rs.getString("documento_observacion"));
            }
             rs.close();
              
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
      
             }
         
            this.miConexion.commit();
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
       
        return unMovimiento;
   }
      public String forma(String idProducto){
          String forma = "";
           
            try{  
 
       String Consulta = "SELECT detalle_producto.*,forma.* FROM detalle_producto INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id WHERE detalle_producto.detalle_producto_producto_id=?";
          ps=miConexion.prepareStatement(Consulta);
                ps.setString(1,idProducto);
                rs = ps.executeQuery();
                if(rs.next())
                {
                forma= rs.getString("forma_descripcion");
                
                }
          
                //Falta terminar de aca para abajo
        
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
       
    return forma;
      

}
}
