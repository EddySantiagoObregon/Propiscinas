/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosForma;
import Modelo.Datos.DatosGrupo;
import Modelo.Datos.DatosInfraestructura;
import Modelo.Datos.DatosPresentacion;
import Modelo.Datos.DatosProducto;
import Modelo.Datos.DatosTipoDocumento;
import Modelo.Datos.DatosTransaccion;
import Modelo.Datos.DatosUnidadMedida;
import Modelo.Datos.DatosUsuario;
import Modelo.Entidad.Autoincrementable;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.Documento;
import Modelo.Entidad.Forma;
import Modelo.Entidad.Grupo;
import Modelo.Entidad.Infraestructura;
import Modelo.Entidad.InventarioInfraestructura;
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
import Modelo.Entidad.Movimiento;
import Modelo.Entidad.Presentacion;
import Modelo.Entidad.Producto;
import Modelo.Entidad.TipoDocumento;
import Modelo.Entidad.Transaccion;
import Modelo.Entidad.UnidadMedida;
import Modelo.Entidad.Usuario;
import com.google.gson.Gson;
import com.sun.tools.ws.wsdl.document.Output;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PAULA
 */
@WebServlet(name = "ControllerProducto", urlPatterns = {"/ControllerProducto"})
public class ControllerProducto extends HttpServlet {
    DatosProducto dProducto = new DatosProducto();
    DatosGrupo dGrupo = new DatosGrupo();
    DatosPresentacion  dPresentacion = new DatosPresentacion();
    DatosUnidadMedida dUnidadMedida = new DatosUnidadMedida();
    DatosInfraestructura dInfraestructura = new DatosInfraestructura();
    DatosTransaccion dTransaccion = new DatosTransaccion();
    DatosTipoDocumento dTipoDocumento = new DatosTipoDocumento();
    DatosForma dForma = new DatosForma();
    DatosUsuario dUsuario = new DatosUsuario();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tarea = request.getParameter("accion");
        switch (tarea){
            case    "Agregar": agregar(request, response);
            break;
            case "agregar2" :agregar2(request, response);
            break;
            case "repetir": repetirCodigo(request, response);
            break;
            case "ListarGrupo": listarGrupo(request, response);
            break;
            

      
            case "ListarPresentacion": listarPresentacion(request, response);
            break;
            case "ListarUnidadMedida": listarUnidadMedida(request, response);
            break;
            case "ListarInfraestructura":listarInfraestructura(request, response);
            break;
            case "ListarTransaccion":listarTransaccion(request, response);
            break;
            case "listarDetalleProducto":listarDetalleProducto(request, response);
            break;
            case "ListarTipoDocumento": listarTipoDocumento(request, response);
            break;
            case "Eliminar":Eliminar(request, response);
            break;
            case "Buscar" :Buscar(request, response);
            break;
            case "Seleccionado":Seleccionado(request,response);
            break;
            case "AgregarProducto": AgregarProducto(request, response);
            break;
            case "listarForma" :listarForma(request,response);
            break;
            case "listarProductoConvetir" :listarProductoConvetir(request,response);
            break;
            case "codigoigual": CodigoIgual(request,response);
            break;
            case "abreviaturaigual": abreviaturaigual(request,response);
            break;
            case "referencia": referencia(request,response);
            break;
            case "Consulta":consultarProductoVenta(request,response);
            break;
            case "CambioProductosEnInfraestructuras":CambioProductosEnInfraestructuras(request,response);
            break;
            case "obtenerProductoSeleccionado":obtenerProductoSeleccionado(request,response);
            break;
            case "EditarProducto":EditarProducto(request,response);
            break;
            case "GenerarCodigoDeBarras":GenerarCodigoDeBarras(request,response);
            break;
            case "GenerarCodigoDeBarrasPorGrupo":GenerarCodigoDeBarrasPorGrupo(request,response);
            break;
            case "GenerarCodigoDeBarraIndependiente":GenerarCodigoDeBarraIndependiente(request,response);
            break;
            case "Activar":Activar(request,response);
            break;
            case "ListarProductoEliminarJSP":ListarProductoEliminarJSP(request,response);
            break;
            case "BuscarEliminarJSP":BuscarEliminarJSP(request,response);
            break;
            case "ListarInfraestructuraCambio":ListarInfraestructuraCambio(request,response);
            break;
         }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    //Este metodo es el encargado de registrar un nuevo producto 
     private void agregar(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        int si=0;
        String _referencia= "";
        Autoincrementable auto = dProducto.numero();
        int numero = auto.getNumero();
        
        String referencia= request.getParameter("txt_Referencia");
        String nombre = request.getParameter("txt_Nombre");
        String codigo="";
        
        String check=  request.getParameter("check");
        String codigoString=request.getParameter("content");
        
        
       
        String abreviatura =request.getParameter("txt_Abreviatura");
       
       
        //unDetalleProducto
        int idGrupo = Integer.parseInt(request.getParameter("cb_Grupo"));
        Grupo unGrupo= new Grupo();
        unGrupo.setIdGrupo(idGrupo);
        int idPresentacion = Integer.parseInt(request.getParameter("cb_Presentacion"));
        Presentacion unaPrecentacion= new Presentacion();
        unaPrecentacion.setIdPresentacion(idPresentacion);
        int idUnidadMedida = Integer.parseInt(request.getParameter("cb_UnidadMedida"));
        UnidadMedida unaUnidadMedida= new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        int idForma = Integer.parseInt(request.getParameter("cb_Forma"));
        Forma unaForma = new Forma();
        unaForma.setidForma(idForma);
        String observaciondellate = request.getParameter("txt_DetalleObservacion");
        String estadodetalle="A";
        int cantidadcodba=Integer.parseInt(request.getParameter("txt_cancod"));
        //Obtenemos el id del Grupo para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringidGrupo = ""+idGrupo;
        String cadenaGrupo = StringidGrupo.substring(0,1);
        int cadenaIdGrupo = Integer.parseInt(cadenaGrupo);
       
        //Obtenemos el id de la unidad de medida para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdUnidadMedida = ""+idUnidadMedida;
        String cadenaUnidadMedida = StringIdUnidadMedida.substring(0,1);
        int cadenaIdUnidadMedida = Integer.parseInt(cadenaUnidadMedida);
        //Obtenemos el id de la  presentacion  para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdPresesentacion = ""+idPresentacion;
        String cadenaPresentacion = StringIdPresesentacion.substring(0,1);
        int cadenaIdPresentacion = Integer.parseInt(cadenaPresentacion);
        //Obtenemos el id de la  presentacion  para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdForma = ""+idForma;
        String cadenaForma = StringIdForma.substring(0,1);
        int cadenaIdForma = Integer.parseInt(cadenaForma);
        String StringNumero="";
        //Convertimos en String el numero incrementable;
        int n = numero;
        int res=0;
        int d=10;
        int cifra=0;
        do{
        res = n % d;
        cifra++;
        d=d*10;
        }while(res != n);
         String contatenarCodigo="";
       if(cifra==3){
           StringNumero = "0"+numero;
           contatenarCodigo= "75090"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==4){
           StringNumero = "0"+numero;
           contatenarCodigo= "7509"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==5){
         StringNumero = ""+numero;
          contatenarCodigo= "7509"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==2){
         StringNumero = "00"+numero;
          contatenarCodigo= "75090"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }


    
        String productoConvertir="null";
      
        double cantidadUnidad=Integer.parseInt(request.getParameter("txt_cantidadUnidad"));
         int productoConvertirCantidad= 0;
         String generaCodigoBarra="";
        if(check==null){
            codigo =contatenarCodigo;
           generaCodigoBarra="SI";
        }
        else{
            codigo=codigoString;
           generaCodigoBarra="NO";
        }
       
        DetalleProducto  unDetalleProducto  = new DetalleProducto(codigo, referencia, nombre, abreviatura, unGrupo, unaPrecentacion, unaForma,cantidadUnidad, unaUnidadMedida, observaciondellate, estadodetalle);
            boolean agregado = dProducto.RegistrarProducto(unDetalleProducto,cantidadcodba,si,_referencia,productoConvertir,productoConvertirCantidad,generaCodigoBarra);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
     private void agregar2(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        Autoincrementable auto = dProducto.numero();
        int si=1;
        String _referencia= request.getParameter("_referencia");
        int numero = auto.getNumero();
        
        String referencia= request.getParameter("_txt_Referencia");
        String nombre = request.getParameter("_txt_Nombre");
        String codigo="";
        
        String check=  request.getParameter("check");
        String codigoString=request.getParameter("content");
        
        
       
        String abreviatura =request.getParameter("_txt_Abreviatura");
       
       
       
        //unDetalleProducto
        int idGrupo = Integer.parseInt(request.getParameter("_cb_Grupo"));
        Grupo unGrupo= new Grupo();
        unGrupo.setIdGrupo(idGrupo);
        int idPresentacion = Integer.parseInt(request.getParameter("_cb_Presentacion"));
        Presentacion unaPrecentacion= new Presentacion();
        unaPrecentacion.setIdPresentacion(idPresentacion);
        int idUnidadMedida = Integer.parseInt(request.getParameter("_cb_UnidadMedida"));
        UnidadMedida unaUnidadMedida= new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        int idForma = Integer.parseInt(request.getParameter("_cb_Forma"));
        Forma unaForma = new Forma();
        unaForma.setidForma(idForma);
        String observaciondellate = request.getParameter("_txt_DetalleObservacion");
        String estadodetalle="A";
        int cantidadcodba=0;
        //Obtenemos el id del Grupo para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringidGrupo = ""+idGrupo;
        String cadenaGrupo = StringidGrupo.substring(0,1);
        int cadenaIdGrupo = Integer.parseInt(cadenaGrupo);
       
        //Obtenemos el id de la unidad de medida para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdUnidadMedida = ""+idUnidadMedida;
        String cadenaUnidadMedida = StringIdUnidadMedida.substring(0,1);
        int cadenaIdUnidadMedida = Integer.parseInt(cadenaUnidadMedida);
        //Obtenemos el id de la  presentacion  para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdPresesentacion = ""+idPresentacion;
        String cadenaPresentacion = StringIdPresesentacion.substring(0,1);
        int cadenaIdPresentacion = Integer.parseInt(cadenaPresentacion);
        //Obtenemos el id de la  presentacion  para convertirlo en subString y luego lo parseamor para contatenarlo con el codigo;
        String StringIdForma = ""+idForma;
        String cadenaForma = StringIdForma.substring(0,1);
        int cadenaIdForma = Integer.parseInt(cadenaForma);
        String StringNumero="";
        String contatenarCodigo="";
        //Convertimos en String el numero incrementable;
        int n = numero;
        int res=0;
        int d=10;
        int cifra=0;
        do{
        res = n % d;
        cifra++;
        d=d*10;
        }while(res != n);
          if(cifra==3){
           StringNumero = "0"+numero;
           contatenarCodigo= "75090"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==4){
           StringNumero = "0"+numero;
           contatenarCodigo= "7509"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==5){
         StringNumero = ""+numero;
          contatenarCodigo= "7509"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }
       if(cifra==2){
         StringNumero = "00"+numero;
          contatenarCodigo= "75090"+StringNumero+cadenaIdGrupo+cadenaIdPresentacion+cadenaIdForma+cadenaIdUnidadMedida;
       }

        String nombreProductoConvertir= request.getParameter("_txt_Producto_Convertir");
        
        double cantidadUnidad=Integer.parseInt(request.getParameter("_txt_cantidadUnidad"));
        int productoConvertirCantidad= Integer.parseInt(request.getParameter("_txt_Producto_Convertir_Cantidad"));
        String generaCodigoBarra="";
        if(check==null){
            codigo =contatenarCodigo;
            generaCodigoBarra="SI";
        }
        else{
            codigo=codigoString;
            generaCodigoBarra="NO";
        }
       
        DetalleProducto  unDetalleProducto  = new DetalleProducto(codigo, referencia, nombre, abreviatura, unGrupo, unaPrecentacion, unaForma,cantidadUnidad, unaUnidadMedida, observaciondellate, estadodetalle);
            boolean agregado = dProducto.RegistrarProducto(unDetalleProducto,cantidadcodba,si,_referencia,nombreProductoConvertir,productoConvertirCantidad,generaCodigoBarra);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
   //Este metodo es el encargado de agregar la cantidad del producto
    private void AgregarProducto(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    { 
        
        String correo = request.getParameter("txt_Correo");
        int idUsuario = dUsuario.idUsuario(correo);
        Usuario unUsuario = new Usuario();
        unUsuario.setIdUsuario(idUsuario);
        String idProducto= request.getParameter("idProducto");
        DetalleProducto unDetalleProducto= new DetalleProducto();
        unDetalleProducto.setIdProducto(idProducto);
        int idInfraestructura = Integer.parseInt(request.getParameter("cb_Infraestructura"));
        Infraestructura unaInfraestructura= new Infraestructura();
        unaInfraestructura.setIdInfraestructura(idInfraestructura);
        int idTransaccion = 1;
        Transaccion unaTransaccion= new Transaccion();
        unaTransaccion.setIdTransaccion(idTransaccion);
        String observacion = request.getParameter("txt_Observacion");
        int cantidadExistente= Integer.parseInt(request.getParameter("txt_CantidadExistente"));
        int cantidadNueva = Integer.parseInt(request.getParameter("txt_Cantidad"));
        int cantidadTotal = cantidadExistente+cantidadNueva;
        String fecha = obtenerFechaActual();
        InventarioInfraestructura unInventarioInfraestructura = new InventarioInfraestructura(unDetalleProducto, fecha, unaInfraestructura, cantidadTotal,observacion,unUsuario);
        
        String estado="A";
        String numerFactura = " ";
        int idUnidadMedida = Integer.parseInt(request.getParameter("sIdUnidad"));
        UnidadMedida unaUnidadMedida= new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        int idInfraestructuraDespacho = 4;
        Infraestructura unaInfraestructuraDespacho = new  Infraestructura();
        unaInfraestructuraDespacho.setIdInfraestructura(idInfraestructuraDespacho);
        //Agrega el documento
        String numeroDocumento = request.getParameter("txt_NumeroDocumento");
        String observacionDocumento = request.getParameter("txt_ObservacionDocumento");
        int idTipoDocumento = 1;
        TipoDocumento unTipoDocumento = new  TipoDocumento();
        unTipoDocumento.setIdTipoDocumento(idTipoDocumento);
        Documento unDocumento = new  Documento(numeroDocumento, unTipoDocumento, observacionDocumento);
        Movimiento unMovimiento = new Movimiento(unaInfraestructura, unaTransaccion, numerFactura,unDetalleProducto, fecha, cantidadNueva,unaUnidadMedida ,unDocumento, unaInfraestructuraDespacho, observacion, estado,unUsuario);
       boolean agregado = dProducto.agregarProducto(unInventarioInfraestructura,unMovimiento,idUsuario);
        String precioCompra = request.getParameter("txt_ValorCompra");
        int cbProveedorProducto = Integer.parseInt(request.getParameter("cb_Proveedor"));
        int Documento = unDocumento.getIdDocumento();
        boolean agregadoo = dProducto.agregarProvedorProductoCompra(cbProveedorProducto, fecha, precioCompra, idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
//Este metodo  es el que obtiene la fecha actual del producto
      private String obtenerFechaActual(){
          Calendar miCalendario = Calendar.getInstance();
           int dia = miCalendario.get(Calendar.DAY_OF_MONTH);
           int mes = miCalendario.get(Calendar.MONTH) + 1;
           int year = miCalendario.get(Calendar.YEAR);
           int hora =miCalendario.get(Calendar.HOUR_OF_DAY);
           int minutos = miCalendario.get(Calendar.MINUTE);
           int segundos = miCalendario.get(Calendar.SECOND);
           String fecha = year + "-" + mes + "-" + dia+" "+hora+":"+minutos+":"+segundos ;
           return fecha;
     }
         private String obtenerFechaParaImprimir(){
          Calendar miCalendario = Calendar.getInstance();
           int dia = miCalendario.get(Calendar.DAY_OF_MONTH);
           int mes = miCalendario.get(Calendar.MONTH) + 1;
           int year = miCalendario.get(Calendar.YEAR);
           int hora =miCalendario.get(Calendar.HOUR_OF_DAY);
           int minutos = miCalendario.get(Calendar.MINUTE);
           int segundos = miCalendario.get(Calendar.SECOND);
           String fecha = hora+""+minutos+""+segundos ;
           return fecha;
     }
//Este metodo es el que lista el grupo para que aparezca en la vista del formulario del producto
    private void listarGrupo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Grupo> lista= dGrupo.ListarGrupo();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
//Este metodo es el que lista el sub grupo para que aparezca en la vista del formulario del producto

    
    //Este metodo es el que lista el sub grupo para que aparezca en la vista del formulario del producto
    private void listarPresentacion(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Presentacion> lista= dPresentacion.ListarPresentacion();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
      private void listarPresentacionCanenca(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Presentacion> lista= dPresentacion.listarPresentacionCaneca();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
           private void listarPresentacionGalon(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Presentacion> lista= dPresentacion.listarPresentacionGalon();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
                  private void listarPresentacionBulto(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Presentacion> lista= dPresentacion.listarPresentacionBulto();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
 //Este metodo es el que lista la unidad de medida para que aparezca en la vista del formulario del producto
    private void listarUnidadMedida(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<UnidadMedida> lista= dUnidadMedida.ListarUnidadMedida();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
//Este metodo listamos las infraestructuras 
    private void listarInfraestructura(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Infraestructura> lista= dInfraestructura.ListarInfraestructura();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
    
            //Este metodo listamos las infraestructuras 
    private void ListarInfraestructuraCambio(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       int  idInfraestructura = Integer.parseInt(request.getParameter("idInfraestructura"));
       ArrayList<Infraestructura> lista= dInfraestructura.ListarInfraestructuraCambio(idInfraestructura);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
//En este metodo listamos las trancsacciones 
    private void listarTransaccion(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Transaccion> lista= dTransaccion.ListarTransaccion();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
    //En este motodo listamos el producto 
      private void listarDetalleProducto(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<DetalleProducto> lista= dProducto.Listar();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
      
               private void ListarProductoEliminarJSP(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<DetalleProducto> lista= dProducto.ListarProductoEliminarJSP();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
      //Este metodo listamos todas las formas de producto
       private void listarForma(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Forma> lista= dForma.ListarForma();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
      //Esta metodo lo que hace es eliminar el producto , hay que hacerle algunos cambios , cambiar el delete por update a estado Inactivo.
       private void Eliminar(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String id = request.getParameter("id");
       boolean eliminado= dProducto.Eliminado(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(eliminado);
       out.print(json);
     
}
       //Activar producto
      
                  private void Activar(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String id = request.getParameter("id");
       boolean eliminado= dProducto.Activar(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(eliminado);
       out.print(json);
     
}
       //Este metodo lo que hace es buscar el producto mediante un parametro que llegue desde la vista 
       private void Buscar(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException
    {
       String buscar =request.getParameter("txt_Buscar");
       ArrayList<DetalleProducto> lista= dProducto.buscarProducto(buscar);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
       }
       
              //Buscar el prodocuto en el formulario eliminar Producto
              private void BuscarEliminarJSP(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException
    {
       String buscar =request.getParameter("txt_Buscar");
       ArrayList<DetalleProducto> lista= dProducto.BuscarEliminarJSP(buscar);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
       }
       //Este metodo  lo que hace es obtener el producto seleccionado en la vista
          private void Seleccionado(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException
    {
      
       
       String id =request.getParameter("id");
        DetalleProducto det = dProducto.obtenerProPorId(id);
        PrintWriter out= response.getWriter();
        String json = new Gson().toJson(det);
        out.print(json);
       
       
       }
          
//Listamos las opciones de tipo de documnetos que existen
    private void listarTipoDocumento(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<TipoDocumento> lista= dTipoDocumento.ListarTipoDocumento();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
//Esta metodo lo usamos para volver a repetir el codigo de barras 
    private void repetirCodigo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String referencia = request.getParameter("referencia");
       String fecha = request.getParameter("fecha");
       int cancod = Integer.parseInt(request.getParameter("cancod"));
       boolean repetido= dProducto.repetirCod(referencia,fecha,cancod);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(repetido);
       out.print(json);
     
}
//En este metodo vamos a listar los productos que se pueden convertir 
    private void listarProductoConvetir(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<DetalleProducto> lista= dProducto.listarProductoConvertir();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
    //En el formulario agregar Producto verificamos si hay un codigo igual 
      private void CodigoIgual(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String id = request.getParameter("codigo");
       boolean encontrado= dProducto.codigoIgual(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(encontrado);
       out.print(json);
     
}
      //En el formulario agregar producto verificamos si hay una abreviatura igual
                   private void abreviaturaigual(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String id = request.getParameter("abreviatura");
       boolean encontrado= dProducto.abreviaturaigual(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(encontrado);
       out.print(json);
     
}
     //En el formulario agregar producto verificamos si hay una referencia igual
    private void referencia(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String id = request.getParameter("referencia");
       boolean encontrado= dProducto.referenciaigual(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(encontrado);
       out.print(json);
}
    //En el formulario Registrar venta usamos este metodo para buscar el producto 
   private void consultarProductoVenta(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        String codigo = request.getParameter("txt_Buscar");
        DetalleProducto unDetalleProducto= dProducto.obtenerProductoBuscadoVenta(codigo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unDetalleProducto);
        out.print(json);
    }
    private void CambioProductosEnInfraestructuras(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    { 
        
        String correo = request.getParameter("txt_Correo");
        int idUsuario = dUsuario.idUsuario(correo);
        Usuario unUsuario = new Usuario();
        unUsuario.setIdUsuario(idUsuario);
          int cantidadExistenteSalida= Integer.parseInt(request.getParameter("txt_CantidadExistente"));
        int catidadEnviaraSalida = Integer.parseInt(request.getParameter("txt_Cantidad_Enviara"));
        if(catidadEnviaraSalida<=cantidadExistenteSalida){
        String idProducto= request.getParameter("idProducto");
        DetalleProducto unDetalleProductoSalida= new DetalleProducto();
        unDetalleProductoSalida.setIdProducto(idProducto);
        int idInfraestructuraSalida = Integer.parseInt(request.getParameter("cb_Infraestructura"));
        Infraestructura unaInfraestructuraSalida= new Infraestructura();
        unaInfraestructuraSalida.setIdInfraestructura(idInfraestructuraSalida);
        int idTransaccionSalida = 2;
        Transaccion unaTransaccionSalida= new Transaccion();
        unaTransaccionSalida.setIdTransaccion(idTransaccionSalida);
        String observacionInfraestructura = request.getParameter("txt_Observacion");
      
        int cantidadTotal = cantidadExistenteSalida-catidadEnviaraSalida;
        String fecha = obtenerFechaActual();
        InventarioInfraestructura unInventarioInfraestructura = new InventarioInfraestructura(unDetalleProductoSalida, fecha, unaInfraestructuraSalida, cantidadTotal,observacionInfraestructura,unUsuario);
        
        String estado="A";
        String numerFactura = "";
        int idUnidadMedida = Integer.parseInt(request.getParameter("sIdUnidad"));
        UnidadMedida unaUnidadMedida= new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        int idInfraestructuraDespachoSalida = Integer.parseInt(request.getParameter("cb_InfraestructuraCambio"));
        Infraestructura unaInfraestructuraDespachoSalida = new  Infraestructura();
        unaInfraestructuraDespachoSalida.setIdInfraestructura(idInfraestructuraDespachoSalida);
        //Agrega el documento
        String numeroDocumento = request.getParameter("txt_NumeroDocumento");
        String observacionDocumento = request.getParameter("txt_ObservacionDocumento");
        int idTipoDocumento = 2;
        TipoDocumento unTipoDocumento = new  TipoDocumento();
        unTipoDocumento.setIdTipoDocumento(idTipoDocumento);
        Documento unDocumento = new  Documento(numeroDocumento, unTipoDocumento, observacionDocumento);
        String observacion ="ENVIO DE PRODUCTOS A INFRAESTRUCTRA";
        
        
        Movimiento unMovimiento = new Movimiento(unaInfraestructuraSalida, unaTransaccionSalida, numerFactura,unDetalleProductoSalida, fecha, catidadEnviaraSalida,unaUnidadMedida ,unDocumento, unaInfraestructuraDespachoSalida, observacion, estado,unUsuario);
  
        //AgregarProducto
        boolean agregado = dProducto.agregarProducto(unInventarioInfraestructura,unMovimiento,idUsuario);
        if(agregado==true){
       
   
        int idInfraestructuraRecibe = Integer.parseInt(request.getParameter("cb_InfraestructuraCambio"));
        Infraestructura InfraestruturaRecibe= new Infraestructura();
        InfraestruturaRecibe.setIdInfraestructura(idInfraestructuraRecibe);
        int idTransaccion = 1;
        Transaccion unaTransaccion= new Transaccion();
        unaTransaccion.setIdTransaccion(idTransaccion);
        String Observacion = request.getParameter("txt_Observacion");
        int cantidadExistenteRecibe= Integer.parseInt(request.getParameter("txt_CantidadCambio"));
        int catidadEnviaraRecibe = Integer.parseInt(request.getParameter("txt_Cantidad_Enviara"));
        int cantidadTotalRecibe = cantidadExistenteRecibe+catidadEnviaraRecibe;
      InventarioInfraestructura unInventarioInfraestructuraRecibe = new InventarioInfraestructura(unDetalleProductoSalida, fecha, InfraestruturaRecibe, cantidadTotalRecibe,Observacion,unUsuario);
        String numerFacturaRecibe = " ";
        int idUnidadMedidaRecibe = Integer.parseInt(request.getParameter("sIdUnidad"));
        UnidadMedida unaUnidadMedidaRecibe= new UnidadMedida();
        unaUnidadMedidaRecibe.setIdUnidadMedida(idUnidadMedidaRecibe);
        int idInfraestructuraDespachoRecibe =4;
        Infraestructura unaInfraestructuraDespachoRecibe = new  Infraestructura();
        unaInfraestructuraDespachoRecibe.setIdInfraestructura(idInfraestructuraDespachoRecibe);
        //Agrega el documento
     
       String nombreInfraestructura = request.getParameter("nombreInfraestructura");
        String observacionRecibe ="RECIBE PRODUCTOS DE LA INFRAESTRUCTRA "+nombreInfraestructura;
        
        
        Movimiento unMovimientoRecibe = new Movimiento(InfraestruturaRecibe, unaTransaccion, numerFacturaRecibe,unDetalleProductoSalida, fecha, catidadEnviaraRecibe,unaUnidadMedidaRecibe ,unDocumento, unaInfraestructuraDespachoRecibe, observacionRecibe, estado,unUsuario);
  
        //AgregarProducto
        boolean agregadoo = dProducto.agregarProducto(unInventarioInfraestructuraRecibe,unMovimientoRecibe,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
        }else{
           PrintWriter out = response.getWriter();
           String json = new Gson().toJson(agregado);
           out.print(json);
        }
        }else{
           boolean agregado = false;
           PrintWriter out = response.getWriter();
           String json = new Gson().toJson(agregado);
           out.print(json);
        }
    }
    
               private void obtenerProductoSeleccionado(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        String codigo = request.getParameter("codigo");
        DetalleProducto unDetalleProducto= dProducto.obtenerProductoSeleccionado(codigo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unDetalleProducto);
        out.print(json);
    }
                      private void EditarProducto(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        String codigo=request.getParameter("txt_Codigo");
        String referencia= request.getParameter("txt_Referencia");
        String nombre = request.getParameter("txt_Nombre");
        String abreviatura =request.getParameter("txt_Abreviatura");
        int idGrupo = Integer.parseInt(request.getParameter("cb_Grupo"));
        int idPresentacion = Integer.parseInt(request.getParameter("cb_Presentacion"));
        int idUnidadMedida = Integer.parseInt(request.getParameter("cb_UnidadMedida"));
        int idForma = Integer.parseInt(request.getParameter("cb_Forma"));
        String observaciondellate = request.getParameter("txt_DetalleObservacion");
        double cantidadUnidad=Integer.parseInt(request.getParameter("txt_cantidadUnidad"));
        boolean agregado= dProducto.Editado(codigo, referencia, nombre, abreviatura, idGrupo, idPresentacion, idForma, idUnidadMedida,cantidadUnidad , observaciondellate);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
                                 private void GenerarCodigoDeBarras(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
      response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        ArrayList<Producto> lista= dProducto.generarCodigoBarras();
       int numero = lista.size();
       int positionx=50;
       int positiony=750;
       int nuevahoja=59;
       int contador=3;
        try  {
            try{
                Document documento = new Document();
           
                PdfWriter pdf = PdfWriter.getInstance(documento,out);
                documento.open();
                 Barcode128 code128 = new Barcode128();
                for(int x=0;x<numero;x++){
              
                 
                 code128.setCode(lista.get(x).getIdProducto());
                 
                 
                 Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   
                   img128.setAbsolutePosition(positionx,positiony);
                  documento.add(img128);
                    positionx+=130;
                  
               
                if((x%10==(contador%10))){
                    positionx=50;
                    positiony-=50;
                    contador=contador+4;
                  }
                 if(x==nuevahoja){
                      nuevahoja+=60;
                      documento.newPage();
                      positionx=50;
                      positiony=750;
                  }
                 
            } 
                documento.close();
                }catch (DocumentException ex) {
                Logger.getLogger(DatosProducto.class.getName()).log(Level.SEVERE, null, ex);
                ex.getMessage();
            }
        
        }finally{
            out.close();
        }
   
                      
}
                
                                         private void GenerarCodigoDeBarrasPorGrupo(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        
     int idGrupo = Integer.parseInt(request.getParameter("idGrupo"));
  ArrayList<Producto> lista= dProducto.generarCodigoBarrasPorGrupo(idGrupo);
       int numero = lista.size();
       int positionx=50;
                 int positiony=750;
                 int nuevahoja=59;
                 int contador=3;
                 
                             try {
                                  Document doc = new Document();
                                  
               String fecha= obtenerFechaParaImprimir();
      
                OutputStream out = response.getOutputStream();
                 String ruta= System.getProperty("user.home");
                 PdfWriter pdf = PdfWriter.getInstance(doc,out);
                 doc.open();
                for(int x=0;x<numero;x++){
              
                 Barcode128 code128 = new Barcode128();
                 code128.setCode(lista.get(x).getIdProducto());
                 
                 
                 Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   
                   img128.setAbsolutePosition(positionx,positiony);
                  doc.add(img128);
                    positionx+=130;
                  
               
                if((x%10==(contador%10))){
                    positionx=50;
                    positiony-=50;
                    contador=contador+4;
                  }
                 if(x==nuevahoja){
                      nuevahoja+=60;
                      doc.newPage();
                      positionx=50;
                      positiony=750;
                  }
                 
            } 
             
                 doc.close();
                }catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(DatosProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
                 boolean generado =false;
   
                      
}
                                                                    private void GenerarCodigoDeBarraIndependiente(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
      String codigo = request.getParameter("codigo");
      int numero= Integer.parseInt(request.getParameter("cantidad"));

       int positionx=50;
                 int positiony=750;
                 int nuevahoja=59;
                 int contador=3;
                 
                             try {
                                  Document doc = new Document();
                                  
               String fecha= obtenerFechaParaImprimir();
               String nombreCod = "CODBAR"+fecha;

                OutputStream out = response.getOutputStream();
                 String ruta= System.getProperty("user.home");
                 PdfWriter pdf = PdfWriter.getInstance(doc,out);
               doc.open();
                for(int x=0;x<numero;x++){
              
                 Barcode128 code128 = new Barcode128();
                 code128.setCode(codigo);
                 
                 Paragraph title = new Paragraph("HELLO WORD");
           
                 Image img128 = code128.createImageWithBarcode(pdf.getDirectContentUnder(), BaseColor.BLACK, BaseColor.BLACK);
                   
                   img128.setAbsolutePosition(positionx,positiony);
                 
                   doc.add(img128);
                    positionx+=130;
                  
               
                if((x%10==(contador%10))){
                    positionx=50;
                    positiony-=50;
                    contador=contador+4;
                  }
                 if(x==nuevahoja){
                      nuevahoja+=60;
                      doc.newPage();
                      positionx=50;
                      positiony=750;
                  }
                 
            } 
                doc.close();
                }catch (FileNotFoundException | DocumentException ex) {
                Logger.getLogger(DatosProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
                 boolean generado =false;
   
                      
}
                                 
}