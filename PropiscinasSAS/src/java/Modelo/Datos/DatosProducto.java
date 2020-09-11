/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Datos;
import Controller.Conexion;
import Modelo.Entidad.Autoincrementable;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.FuncWindows;
import Modelo.Entidad.InventarioInfraestructura;
import Modelo.Entidad.Movimiento;
import Modelo.Entidad.Producto;
import Modelo.Entidad.Usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DatosProducto{
   
    
   private Connection miConexion;
   private PreparedStatement ps;
   private ResultSet rs;
   private String mensaje;
   
   public DatosProducto()
   {
       miConexion=Conexion.getConexion();
   }
   public String getMensaje()
   {
       return mensaje;
   }
   
    public Autoincrementable numero() {
   
      
       Autoincrementable auto= null;
       this.mensaje=null;
     try
       {
           this.miConexion.setAutoCommit(false); 
       
           //Selecciona el ultimo id de la tabla autoincrementable
      String consulta="SELECT MAX(idAutoincrementable) AS idAutoincrementable FROM autoincrementable";
        ps=miConexion.prepareStatement(consulta);
           rs= ps.executeQuery();
           int idAutoincrementable=0;
           if(rs.next())
           {
              idAutoincrementable = rs.getInt("idAutoincrementable");
           }
           // si el id es 0 es porque no existe ningun dato
           if(idAutoincrementable==0){
           // Creamos un nuevo numero autoincrementable con el valor de 100
           String consulta2="insert into autoincrementable values(null,0100)";
           ps=miConexion.prepareStatement(consulta2);
           ps.executeUpdate();
           String consulta3="select * from autoincrementable where autoincrementableNumero=? ";
           ps=miConexion.prepareStatement(consulta3);
           ps.setInt(1, 0100);
           
           rs = ps.executeQuery();
           if(rs.next())
           {
               auto = new Autoincrementable();
               auto.setNumero(rs.getInt("autoincrementableNumero"));
          
          }
            
            }else{
                String consulta3="SELECT MAX(autoincrementableNumero) AS autoincrementableNumero FROM autoincrementable";
                ps=miConexion.prepareStatement(consulta3);
               rs= ps.executeQuery();
               int autoincrementableNumero=0;
               if(rs.next())
               {
              autoincrementableNumero = rs.getInt("autoincrementableNumero");
             } 
               autoincrementableNumero=autoincrementableNumero+0001;
                String consulta4="insert into autoincrementable values(null,?)";
                ps=miConexion.prepareStatement(consulta4);
                ps.setInt(1,autoincrementableNumero);
                ps.executeUpdate();
                
               String consulta5="select * from autoincrementable where autoincrementableNumero=? ";
               ps=miConexion.prepareStatement(consulta5);
               ps.setInt(1, autoincrementableNumero);
               rs = ps.executeQuery();
              if(rs.next())
              {
               auto = new Autoincrementable();
               auto.setNumero(rs.getInt("autoincrementableNumero"));
          
              }
           }
           rs.close();
          this.miConexion.commit();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return auto;
   }
     public boolean RegistrarProducto(DetalleProducto unDetalleProducto,int cancod,int si,String referencia,String productoConvertir,int productoconvertirCantidad,String generaCodigoBarra){
        boolean agregado = false;
            try{  
         this.miConexion.setAutoCommit(false); 
       
        String consulta2="insert into producto "
             + " values(?,?,?,?,?)"; 
              
            
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unDetalleProducto.getIdProducto());
            ps.setString(2,unDetalleProducto.getReferencia());
            ps.setString(3,unDetalleProducto.getNombre());
            ps.setString(4,unDetalleProducto.getAbreviatura());
            ps.setString(5,generaCodigoBarra);
            ps.executeUpdate();
            
                                   
         
            
            String consulta3="insert into detalle_producto "
             + " values(?,?,?,?,?,?,?,?)"; 
            ps=miConexion.prepareStatement(consulta3);
            ps.setString(1, unDetalleProducto.getIdProducto());      
            ps.setInt(2,unDetalleProducto.getUnGrupo().getIdGrupo());
            ps.setInt(3,unDetalleProducto.getUnaPresentacion().getIdPresentacion());
            ps.setInt(4,unDetalleProducto.getUnaForma().getidForma());
            ps.setDouble(5, unDetalleProducto.getCantidadUnidad());
            ps.setInt(6,unDetalleProducto.getUnaUnidadMedida().getIdUnidadMedida());
            ps.setString(7,unDetalleProducto.getObservacion());
            ps.setString(8,unDetalleProducto.getEstado());
            ps.executeUpdate();
            if(si>0){
                String consultica="select producto_id from producto where producto_referencia =?";
                ps=miConexion.prepareStatement(consultica);
                ps.setString(1,referencia);
                rs= ps.executeQuery();
                String idProducto="";
                if(rs.next())
                {
                idProducto= rs.getString("producto_id");
                }
                String consulta="insert into convertir_producto values(null,?,?,?,?)";
                ps=miConexion.prepareStatement(consulta);
                ps.setString(1,productoConvertir);
                ps.setInt(2,productoconvertirCantidad);
                ps.setString(3,idProducto);
                ps.setString(4, unDetalleProducto.getIdProducto()); 
                ps.executeUpdate();
            }
           
           
           this.miConexion.commit();
           this.mensaje="usuario agregado Correctamente";
           
           agregado=true;
         
                    
          
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return agregado;
   }
     public boolean repetirCod(String referencia,String fecha,int cancod){
         boolean repetir=false;
         try{  
  
            String consultica="select producto_id from producto where producto_referencia =?";
           ps=miConexion.prepareStatement(consultica);
           ps.setString(1,referencia);
           rs= ps.executeQuery();
           String idProducto="";
           if(rs.next())
           {
               idProducto= rs.getString("producto_id");
           }
       
               Document doc = new Document();
            try {
                
                String ruta= System.getProperty("user.home");
                PdfWriter pdf = PdfWriter.getInstance(doc,new FileOutputStream(ruta+"/Desktop/imprimir/"+idProducto+""+fecha+".pdf"));
                 doc.open();
                 Barcode128 code128 = new Barcode128();
                 code128.setCode(idProducto);
                 int positionx=65;
                 int positiony=750;
                 int nuevahoja=48;
                 int contador=4;
                 for (int x=1;x<=cancod;x++){
                 Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   
                   img128.setAbsolutePosition(positionx,positiony);
                  doc.add(img128);
                    positionx+=120;
                  if((x%10==(contador%10))){
                    positionx=65;
                    positiony-=65;
                    contador=contador+4;
                  }
                 if(x==nuevahoja){
                      nuevahoja+=48;
                      doc.newPage();
                      positionx=65;
                      positiony=750;
                  }
                 }
                 FuncWindows fw = new FuncWindows();
                 fw.fnOpenFileFromCMD("C:/Users/PAULA/Desktop/imprimir/"+idProducto+""+fecha+".pdf");
                 
                 doc.close();
                 
            } catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(DatosProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
         repetir=true;
         
         return repetir;
     }
private String obtenerFechaActual(){
          Calendar miCalendario = Calendar.getInstance();
           int dia = miCalendario.get(Calendar.DAY_OF_MONTH);
           int mes = miCalendario.get(Calendar.MONTH) + 1;
           int year = miCalendario.get(Calendar.YEAR);
           int hora =miCalendario.get(Calendar.HOUR_OF_DAY);
           int minutos = miCalendario.get(Calendar.MINUTE);

           String fecha = year+""+mes+""+dia+""+hora+""+minutos ;
           return fecha;
     }
    public boolean agregarProducto(InventarioInfraestructura unInventarioInfraestructura,Movimiento unMovimiento,int idUsuario){
        boolean agregado = false;
            try{  
  
     
            this.miConexion.setAutoCommit(false);   
            
           

           
            
            String consulta1= "insert into inventario_infraestructura values(null,?,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setString(2,unInventarioInfraestructura.getFecha());
            ps.setInt(3,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(4, unInventarioInfraestructura.getCantidad());
            ps.setString(5,unInventarioInfraestructura.getObservacion());
            ps.setInt(6,idUsuario);
            ps.executeUpdate();
            
            String consulta2= "select * from inventario_infraestructura_cantidad_actual where inventario_producto_id=? and inventario_infraestructura_id=?";
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setInt(2,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            rs= ps.executeQuery();
            if(rs.next())
            {
                String consulta3= "UPDATE inventario_infraestructura_cantidad_actual SET inventario_cantidad_total = ? ,inventario_fecha_registro=? where inventario_producto_id=? and inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta3);
                ps.setInt(1, unInventarioInfraestructura.getCantidad());
                ps.setString(2,unInventarioInfraestructura.getFecha());
                ps.setString(3,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
                ps.setInt(4,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
                ps.executeUpdate();
            }
            else{
             String consulta4= "insert into inventario_infraestructura_cantidad_actual values(null,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta4);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setString(2,unInventarioInfraestructura.getFecha());
            ps.setInt(3,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(4, unInventarioInfraestructura.getCantidad());
            ps.setString(5,unInventarioInfraestructura.getObservacion());
            ps.executeUpdate();
            }
            String consulta5= "insert into documento values(null,?,?,?)";
            ps=miConexion.prepareStatement(consulta5);
            ps.setString(1,unMovimiento.getUnDocumento().getNumerodocumento());
            ps.setInt(2,unMovimiento.getUnDocumento().getUnTipoDocumento().getIdTipoDocumento());
            ps.setString(3,unMovimiento.getUnDocumento().getObservacion());
            ps.executeUpdate();
               String consultica="SELECT MAX(documento_id) AS documento_id FROM documento";
            ps=miConexion.prepareStatement(consultica);
            rs= ps.executeQuery();
            int idDocumento=0;
            if(rs.next())
            {
               idDocumento= rs.getInt("documento_id");
            }
            String consulta6="insert into movimiento values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta6);
            ps.setInt(1,unMovimiento.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(2, unMovimiento.getUnaTransaccion().getIdTransaccion());
            ps.setString(3, unMovimiento.getNumerofactura());
            ps.setString(4,unMovimiento.getUnDetalleProducto().getIdProducto());
            ps.setString(5,unMovimiento.getFecharegistro());
            ps.setInt(6, unMovimiento.getCantidad());
            ps.setInt(7, unMovimiento.getUnaUnidadMedida().getIdUnidadMedida());
            ps.setInt(8,idDocumento);
            ps.setInt(9, unMovimiento.getUnaInfraestructuraDespacho().getIdInfraestructura());
            ps.setString(10,unMovimiento.getObservacion());
            ps.setString(11,unMovimiento.getEstado());
            ps.setInt(12,idUsuario);
            ps.executeUpdate();
           
            
            
           
           
           this.miConexion.commit();
           this.mensaje="usuario agregado Correctamente";
           
           agregado=true;
         
                    
          
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return agregado;
    }
    public boolean agregarProductoDevolucionVenta(InventarioInfraestructura unInventarioInfraestructura,Movimiento unMovimiento,int idUsuario){
        boolean agregado = false;
            try{  
  
     
            this.miConexion.setAutoCommit(false);   
            
           

           
            
            String consulta1= "insert into inventario_infraestructura values(null,?,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setString(2,unInventarioInfraestructura.getFecha());
            ps.setInt(3,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(4, unInventarioInfraestructura.getCantidad());
            ps.setString(5,unInventarioInfraestructura.getObservacion());
            ps.setInt(6,idUsuario);
            ps.executeUpdate();
            
            String consulta2= "select * from inventario_infraestructura_cantidad_actual where inventario_producto_id=? and inventario_infraestructura_id=?";
            ps=miConexion.prepareStatement(consulta2);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setInt(2,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            rs= ps.executeQuery();
            if(rs.next())
            {
                String consulta3= "UPDATE inventario_infraestructura_cantidad_actual SET inventario_cantidad_total = ? ,inventario_fecha_registro=? where inventario_producto_id=? and inventario_infraestructura_id=?";
                ps=miConexion.prepareStatement(consulta3);
                ps.setInt(1, unInventarioInfraestructura.getCantidad());
                ps.setString(2,unInventarioInfraestructura.getFecha());
                ps.setString(3,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
                ps.setInt(4,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
                ps.executeUpdate();
            }
            else{
             String consulta4= "insert into inventario_infraestructura_cantidad_actual values(null,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta4);
            ps.setString(1,unInventarioInfraestructura.getUnDetalleProducto().getIdProducto());
            ps.setString(2,unInventarioInfraestructura.getFecha());
            ps.setInt(3,unInventarioInfraestructura.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(4, unInventarioInfraestructura.getCantidad());
            ps.setString(5,unInventarioInfraestructura.getObservacion());
            ps.executeUpdate();
            }
            String consulta5= "insert into documento values(null,?,?,?)";
            ps=miConexion.prepareStatement(consulta5);
            ps.setString(1,unMovimiento.getUnDocumento().getNumerodocumento());
            ps.setInt(2,unMovimiento.getUnDocumento().getUnTipoDocumento().getIdTipoDocumento());
            ps.setString(3,unMovimiento.getUnDocumento().getObservacion());
            ps.executeUpdate();
             String consultica="SELECT MAX(documento_id) AS documento_id FROM documento";
            ps=miConexion.prepareStatement(consultica);
            rs= ps.executeQuery();
            int idDocumento=0;
            if(rs.next())
            {
               idDocumento= rs.getInt("documento_id");
            }
            String consulta6="insert into movimiento values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=miConexion.prepareStatement(consulta6);
            ps.setInt(1,unMovimiento.getUnaInfraestructura().getIdInfraestructura());
            ps.setInt(2, unMovimiento.getUnaTransaccion().getIdTransaccion());
            ps.setString(3, unMovimiento.getNumerofactura());
            ps.setString(4,unMovimiento.getUnDetalleProducto().getIdProducto());
            ps.setString(5,unMovimiento.getFecharegistro());
            ps.setInt(6, unMovimiento.getCantidad());
            ps.setInt(7, unMovimiento.getUnaUnidadMedida().getIdUnidadMedida());
            ps.setInt(8,idDocumento);
            ps.setInt(9, unMovimiento.getUnaInfraestructuraDespacho().getIdInfraestructura());
            ps.setString(10,unMovimiento.getObservacion());
            ps.setString(11,unMovimiento.getEstado());
            ps.setInt(12,idUsuario);
            ps.executeUpdate();
           
            
            
           
           
           this.miConexion.commit();
           this.mensaje="usuario agregado Correctamente";
           
           agregado=true;
         
                    
          
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return agregado;
    }
     public boolean agregarProvedorProductoCompra(int idProveedorProducto,String fecha,String precioCompra,int idUsuario){
        boolean agregado = false;
            try{  
  
     
            this.miConexion.setAutoCommit(false);   
              String consultica="select movimiento_documento from movimiento where movimiento.movimiento_fecha_resgistro=?";
            ps=miConexion.prepareStatement(consultica);
            ps.setString(1,fecha);
            rs= ps.executeQuery();
            int idDocumento=0;
            if(rs.next())
            {
               idDocumento= rs.getInt("movimiento_documento");
            }
              String consulta7="insert into proveedor_producto_compra values(null,?,?,?,?,?)";
              
            ps=miConexion.prepareStatement(consulta7);
            ps.setInt(1,idProveedorProducto);
            ps.setInt(2, idDocumento);
            ps.setString(3,fecha );
            ps.setString(4,precioCompra);
            ps.setInt(5,idUsuario);
            ps.executeUpdate();
           
           
           
           this.miConexion.commit();
           this.mensaje="usuario agregado Correctamente";
           
           agregado=true;
         
                    
          
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



       public ArrayList<DetalleProducto>Listar()
    {
            this.mensaje=null;
     ArrayList<DetalleProducto> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,producto.*,grupo.*,presentacion.*,forma.*,unidad_medida.* FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id where detalle_producto_estado = 'A' ORDER BY `producto`.`producto_nombre` ASC";
            ps=this.miConexion.prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                DetalleProducto unDetalleProducto = new DetalleProducto();
                unDetalleProducto.setIdProducto(rs.getString("producto_id"));
                unDetalleProducto.setReferencia(rs.getString("producto_referencia"));
                unDetalleProducto.setNombre(rs.getString("producto_nombre"));
                unDetalleProducto.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalleProducto.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalleProducto.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalleProducto.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalleProducto.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalleProducto.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalleProducto.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalleProducto.setEstado(rs.getString("detalle_producto_estado"));
                lista.add(unDetalleProducto);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
        public ArrayList<DetalleProducto>ListarProductoEliminarJSP()
    {
            this.mensaje=null;
     ArrayList<DetalleProducto> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,producto.*,grupo.*,presentacion.*,forma.*,unidad_medida.* FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id ORDER BY producto.producto_nombre ASC ";
            ps=this.miConexion.prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                DetalleProducto unDetalleProducto = new DetalleProducto();
                unDetalleProducto.setIdProducto(rs.getString("producto_id"));
                unDetalleProducto.setReferencia(rs.getString("producto_referencia"));
                unDetalleProducto.setNombre(rs.getString("producto_nombre"));
                unDetalleProducto.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalleProducto.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalleProducto.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalleProducto.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalleProducto.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalleProducto.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalleProducto.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalleProducto.setEstado(rs.getString("detalle_producto_estado"));
                lista.add(unDetalleProducto);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
            public boolean Eliminado(String id){
        boolean eliminado = false;
            try{  
  
            
        String consulta1="UPDATE detalle_producto SET detalle_producto_estado = 'I' WHERE detalle_producto.detalle_producto_producto_id = ?"; 
            this.miConexion.setAutoCommit(false);   
            
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,id);
            ps.executeUpdate();

            
                                   
         
      
           this.miConexion.commit();
    
           
           eliminado=true;
         
                    
          
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return eliminado;
    }
                        public boolean Activar(String id){
        boolean eliminado = false;
            try{  
  
            
        String consulta1="UPDATE detalle_producto SET detalle_producto_estado = 'A' WHERE detalle_producto.detalle_producto_producto_id = ?"; 
            this.miConexion.setAutoCommit(false);   
            
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,id);
            ps.executeUpdate();

            
                                   
         
      
           this.miConexion.commit();
    
           
           eliminado=true;
         
                    
          
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return eliminado;
    }
   
                public ArrayList<DetalleProducto>buscarProducto(String buscar)
    {
            this.mensaje=null;
     ArrayList<DetalleProducto> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,producto.*,grupo.*,presentacion.*,forma.*,  unidad_medida.* " 
                    +"FROM detalle_producto INNER JOIN producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "
                    +"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id "
                    +"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id "
                    + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                    +"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "
                    +"WHERE   producto_id LIKE ?  OR producto_referencia LIKE ?  OR producto_nombre LIKE ? OR producto_abreviatura LIKE ?   OR forma_descripcion=? OR grupo_descripcion LIKE ? OR presentacion_descripcion LIKE ?  OR unidad_medida_descripcion LIKE ? OR detalle_producto_observacion LIKE ?   and detalle_producto_estado = 'A' ";
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
         
         
           
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                DetalleProducto unDetalleProducto = new DetalleProducto();
                unDetalleProducto.setIdProducto(rs.getString("producto_id"));
                unDetalleProducto.setReferencia(rs.getString("producto_referencia"));
                unDetalleProducto.setNombre(rs.getString("producto_nombre"));
                unDetalleProducto.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalleProducto.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalleProducto.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalleProducto.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalleProducto.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalleProducto.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalleProducto.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalleProducto.setEstado(rs.getString("detalle_producto_estado"));
                lista.add(unDetalleProducto);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                
                                      public ArrayList<DetalleProducto>BuscarEliminarJSP(String buscar)
    {
            this.mensaje=null;
     ArrayList<DetalleProducto> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,producto.*,grupo.*,presentacion.*,forma.*,  unidad_medida.* " 
                    +"FROM detalle_producto INNER JOIN producto ON detalle_producto.detalle_producto_producto_id = producto.producto_id "
                    +"INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id = grupo.grupo_id "
                    +"INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id = presentacion.presentacion_id "
                    + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                    +"INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida = unidad_medida.unidad_medida_id "
                    +"WHERE   producto_id LIKE ?  OR producto_referencia LIKE ?  OR producto_nombre LIKE ? OR producto_abreviatura LIKE ?   OR forma_descripcion=? OR grupo_descripcion LIKE ? OR presentacion_descripcion LIKE ?  OR unidad_medida_descripcion LIKE ? OR detalle_producto_observacion LIKE ?  OR detalle_producto_estado LIKE ? ";
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
         
           
            
            
            rs = ps.executeQuery();
            
           while(rs.next())
            {
                DetalleProducto unDetalleProducto = new DetalleProducto();
                unDetalleProducto.setIdProducto(rs.getString("producto_id"));
                unDetalleProducto.setReferencia(rs.getString("producto_referencia"));
                unDetalleProducto.setNombre(rs.getString("producto_nombre"));
                unDetalleProducto.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalleProducto.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalleProducto.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalleProducto.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalleProducto.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalleProducto.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalleProducto.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalleProducto.setEstado(rs.getString("detalle_producto_estado"));
                lista.add(unDetalleProducto);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                //Este metodo se usa para obtener todos los datos del producto por el parametro idPro y mostrarle los datos obtenidos a la pestaña  modal
                   public DetalleProducto obtenerProPorId(String idPro){
        
        DetalleProducto unDetalle= null;
         boolean agregado = false;
        String consultica = "SELECT detalle_producto.*,producto.*,grupo.*,forma.*,presentacion.*,unidad_medida.* "
                 +" FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id "
                 + "INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id "
                + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                 + "INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "
                 + "INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id"
                + " WHERE detalle_producto_producto_id=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,idPro);
        rs= ps.executeQuery();
        if(rs.next())
        {
                unDetalle = new DetalleProducto();
                
                unDetalle.setIdProducto(rs.getString("producto_id"));
                unDetalle.setReferencia(rs.getString("producto_referencia"));
                unDetalle.setNombre(rs.getString("producto_nombre"));
                unDetalle.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalle.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalle.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalle.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalle.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalle.getUnaUnidadMedida().setIdUnidadMedida(rs.getInt("unidad_medida_id"));
                unDetalle.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalle.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalle.setEstado(rs.getString("detalle_producto_estado"));
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return unDetalle;
   }
                     public ArrayList<DetalleProducto>listarProductoConvertir()
    {
            this.mensaje=null;
     ArrayList<DetalleProducto> lista= new ArrayList<>();
        try
        {
            this.miConexion.setAutoCommit(false);
            String consulta = "SELECT detalle_producto.*,producto.*,grupo.*,presentacion.*,forma.*,unidad_medida.* "
                    + " FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id "
                    + "INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id "
                    + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                    + "INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "
                    + "INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id "
                    + "where detalle_producto_forma_id=2";
            ps=this.miConexion.prepareStatement(consulta);
            
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                DetalleProducto unDetalleProducto = new DetalleProducto();
                unDetalleProducto.setIdProducto(rs.getString("producto_id"));
                unDetalleProducto.setNombre(rs.getString("producto_nombre"));
                lista.add(unDetalleProducto);
            }
             rs.close();
            this.miConexion.commit();
        }catch(SQLException ex)
        {
            this.mensaje= ex.getMessage();
        }
        return lista;
}
                       public boolean codigoIgual(String id){
        boolean encontrado = false;
            try{  
  
            
        String consulta1="select * from producto where producto_id=?"; 
           
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                encontrado=true;
            }
            
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return encontrado;
    }
                       
      public boolean abreviaturaigual(String id){
        boolean encontrado = false;
            try{  
  
            
        String consulta1="select * from producto where producto_abreviatura=?"; 
           
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                encontrado=true;
            }
            
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return encontrado;
    }


         public boolean referenciaigual(String id){
        boolean encontrado = false;
            try{  
  
            
        String consulta1="select * from producto where producto_referencia=?"; 
           
            ps=miConexion.prepareStatement(consulta1);
            ps.setString(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                encontrado=true;
            }
            
       }catch(SQLException ex1)
                 {
                     this.mensaje= ex1.getMessage();
                 }
       
        return encontrado;
    }
         
  public DetalleProducto obtenerProductoBuscadoVenta(String idPro){
               DetalleProducto unDetalle= null;
         boolean agregado = false;
        String consultica = "SELECT detalle_producto.*,producto.*,grupo.*,forma.*,presentacion.*,unidad_medida.* "
                 +" FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id "
                 + "INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id "
                + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                 + "INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "
                 + "INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id"
                + " WHERE detalle_producto_producto_id=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,idPro);
        rs= ps.executeQuery();
        if(rs.next())
        {
                unDetalle = new DetalleProducto();
                
                unDetalle.setIdProducto(rs.getString("producto_id"));
                unDetalle.setReferencia(rs.getString("producto_referencia"));
                unDetalle.setNombre(rs.getString("producto_nombre"));
                unDetalle.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalle.getUnGrupo().setDescripcion(rs.getString("grupo_descripcion"));
                unDetalle.getUnaPresentacion().setDescripcion(rs.getString("presentacion_descripcion"));
                unDetalle.getUnaForma().setDescripcion(rs.getString("forma_descripcion"));
                unDetalle.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalle.getUnaUnidadMedida().setIdUnidadMedida(rs.getInt("unidad_medida_id"));
                unDetalle.getUnaUnidadMedida().setDescripcion(rs.getString("unidad_medida_descripcion"));
                unDetalle.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalle.setEstado(rs.getString("detalle_producto_estado"));
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return unDetalle;
           }
    public ArrayList<String> obtenerProducto(String producto){
        ps=null;
        rs=null;
       
       ArrayList<String>lista= new ArrayList<>();
       
         try {
             String consulta="SELECT producto_nombre FROM producto where producto_nombre like ? limit 10 " ;
              ps=miConexion.prepareStatement(consulta);   
              ps.setString(1, "%"+producto+"%");
              rs=ps.executeQuery();
              while (rs.next()) {
                lista.add(rs.getString("producto_nombre"));                 
             }          
            
               
         } catch (SQLException e) {
             
              mensaje=e.getMessage();
         }
      
       
       return lista;
     }
    public DetalleProducto obtenerProductoSeleccionado(String idPro){
               DetalleProducto unDetalle= null;
         boolean agregado = false;
        String consultica = "SELECT detalle_producto.*,producto.*,grupo.*,forma.*,presentacion.*,unidad_medida.* "
                 +" FROM detalle_producto INNER JOIN producto on detalle_producto.detalle_producto_producto_id=producto.producto_id "
                 + "INNER JOIN grupo on detalle_producto.detalle_producto_grupo_id=grupo.grupo_id "
                + "INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id "
                 + "INNER JOIN presentacion on detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id "
                 + "INNER JOIN unidad_medida on detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id"
                + " WHERE detalle_producto_producto_id=?";
         try
       {
        ps=this.miConexion.prepareStatement(consultica);
        ps.setString(1,idPro);
        rs= ps.executeQuery();
        if(rs.next())
        {
                unDetalle = new DetalleProducto();
                
                unDetalle.setIdProducto(rs.getString("producto_id"));
                unDetalle.setReferencia(rs.getString("producto_referencia"));
                unDetalle.setNombre(rs.getString("producto_nombre"));
                unDetalle.setAbreviatura(rs.getString("producto_abreviatura"));
                unDetalle.getUnGrupo().setIdGrupo(rs.getInt("grupo_id"));
                unDetalle.getUnaPresentacion().setIdPresentacion(rs.getInt("presentacion_id"));
                unDetalle.getUnaForma().setidForma(rs.getInt("forma_id"));
                unDetalle.setCantidadUnidad(rs.getInt("detalle_producto_cantidad_medida"));
                unDetalle.getUnaUnidadMedida().setIdUnidadMedida(rs.getInt("unidad_medida_id"));
                unDetalle.setObservacion(rs.getString("detalle_producto_observacion"));
                unDetalle.setEstado(rs.getString("detalle_producto_estado"));
            
        }
        rs.close();
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return unDetalle;
           }
    public boolean  Editado(String idPro,String referencia,String nombre,String abreviatura,int idGrupo,int idPresentacion,int idForma,int idUnidadMedida,double cantidadMedida,String observacion){
               DetalleProducto unDetalle= null;
         boolean editado = false;
                  try
       {

        String consulta = "UPDATE producto, detalle_producto, forma, unidad_medida, grupo, presentacion SET producto.producto_referencia = ? , producto.producto_nombre =? , producto.producto_abreviatura=? , detalle_producto.detalle_producto_grupo_id=? , detalle_producto.detalle_producto_presentacion_id=? , detalle_producto.detalle_producto_forma_id=? , detalle_producto.detalle_unidad_medida=? , detalle_producto.detalle_producto_cantidad_medida=? , detalle_producto.detalle_producto_observacion=? WHERE detalle_producto.detalle_producto_producto_id=? AND producto.producto_id = ?";
                  ps=miConexion.prepareStatement(consulta);
            ps.setString(1,referencia);
            ps.setString(2,nombre);
            ps.setString(3,abreviatura);
            ps.setInt(4,idGrupo);
            ps.setInt(5,idPresentacion);
            ps.setInt(6,idForma);
            ps.setInt(7,idUnidadMedida);
            ps.setDouble(8,cantidadMedida);
            ps.setString(9,observacion);
            ps.setString(10,idPro);
            ps.setString(11,idPro);

            ps.executeUpdate();
            editado=true;
       }catch(SQLException ex)
       {
           this.mensaje= ex.getMessage();
       }
       return editado;
           }

  
   public ArrayList<Producto> generarCodigoBarras()
   {
     this.mensaje=null;
     ArrayList<Producto> lista= new ArrayList<>();
    
     try
     {
         String consulta="SELECT (SELECT DISTINCT concat_ws(' ',producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom),producto.*,detalle_producto.*,forma.*,unidad_medida.*,presentacion.* FROM detalle_producto INNER JOIN producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id ORDER BY `producto`.`producto_nombre` ASC";
         ps=miConexion.prepareStatement(consulta);
         rs= ps.executeQuery();
         while(rs.next())
         {
               Producto unProducto = new Producto();
                 unProducto.setIdProducto(rs.getString("producto_id"));
                 unProducto.setNombre(rs.getString("(SELECT DISTINCT concat_ws(' ',producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom)"));
                
                lista.add(unProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }

   
            public ArrayList<Producto> generarCodigoBarrasPorGrupo(int idGrupo)
   {
     this.mensaje=null;
     ArrayList<Producto> lista= new ArrayList<>();
    
     try
     {
         String consultaa="SELECT (SELECT DISTINCT concat_ws(' ',producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom),producto.*,detalle_producto.*,forma.*,unidad_medida.*,presentacion.*,grupo.* FROM detalle_producto INNER JOIN producto ON detalle_producto.detalle_producto_producto_id=producto.producto_id INNER JOIN forma ON detalle_producto.detalle_producto_forma_id=forma.forma_id INNER JOIN unidad_medida ON detalle_producto.detalle_unidad_medida=unidad_medida.unidad_medida_id INNER JOIN presentacion ON detalle_producto.detalle_producto_presentacion_id=presentacion.presentacion_id INNER JOIN grupo ON detalle_producto.detalle_producto_grupo_id=grupo.grupo_id where producto_genero_codigo_barra='SI' AND grupo.grupo_id= ? ORDER BY producto.producto_nombre ASC";
         ps=miConexion.prepareStatement(consultaa);
         ps.setInt(1,idGrupo);
         rs= ps.executeQuery();
         while(rs.next())
            
         {
                 Producto unProducto = new Producto();
                 unProducto.setIdProducto(rs.getString("producto_id"));
                 unProducto.setNombre(rs.getString("(SELECT DISTINCT concat_ws(' ',producto_nombre,forma_descripcion,detalle_producto_cantidad_medida,unidad_medida_descripcion,presentacion_descripcion) as productoNom)"));
                 lista.add(unProducto);
         }
         rs.close();
                 
     }catch(SQLException ex)
     {
         this.mensaje=ex.getMessage();
     }
     
     return lista;
   }
            
}



