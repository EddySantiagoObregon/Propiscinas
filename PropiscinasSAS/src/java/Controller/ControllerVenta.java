/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import Modelo.Datos.DatosProductoConvertir;
import Modelo.Datos.DatosTipoDocumento;
import Modelo.Datos.DatosUsuario;
import Modelo.Datos.DatosVenta;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.Documento;
import Modelo.Entidad.Infraestructura;
import Modelo.Entidad.InventarioInfraestructura;
import Modelo.Entidad.InventarioVenta;
import Modelo.Entidad.Movimiento;
import Modelo.Entidad.Producto;
import Modelo.Entidad.TipoDocumento;
import Modelo.Entidad.Transaccion;
import Modelo.Entidad.UnidadMedida;
import Modelo.Entidad.Usuario;
import Modelo.Entidad.Venta;
import com.google.gson.Gson;
import java.io.IOException;
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
@WebServlet(name = "ControllerVenta", urlPatterns = {"/ControllerVenta"})
public class ControllerVenta extends HttpServlet {
DatosVenta dVenta = new DatosVenta();
DatosProducto dProducto = new DatosProducto();
DatosProductoConvertir  dProductoConvertir = new DatosProductoConvertir();
DatosTipoDocumento dTipoDocumento = new DatosTipoDocumento();
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
            out.println("<title>Servlet ControllerVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerVenta at " + request.getContextPath() + "</h1>");
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
            case    "RegistrarVenta": agregar(request, response);
            break;
            case "listarVenta": listarVenta(request,response);
            break;
            case "listarTipoDocumento":listarTipoDocumento(request, response);
            break;
            case "BuscarVenta":BuscarVenta (request,response);
            break;
            case "BuscarVentaPorProductoYFecha":BuscarVentaPorProductoYFecha(request,response);
            break;
            case "BuscarProductoPorFecha":BuscarProductoPorFecha(request, response);
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
        String correo = request.getParameter("txt_Correo");
        int idUsuario = dUsuario.idUsuario(correo);
        Usuario unUsuario = new Usuario();
        unUsuario.setIdUsuario(idUsuario);
        String IdProducto = request.getParameter("txt_Codigo"); //Se obtiene el id del producto
        int cantidadAcutal = dVenta.cantidad(IdProducto); // Consultamos la cantidadActual con id del producto
        int cantidad= Integer.parseInt(request.getParameter("txt_CantidadVendidaa")); // obtenemos el valor de la cantidad que se vendera
        if(cantidadAcutal>=cantidad){ //hacemos una condicional preguntando que la cantidad del producto en la sala de ventas es mayor o igual que cantidad que quiere vender
        DetalleProducto unDetalleProducto = new DetalleProducto();
        Producto unProducto = new Producto();
        unProducto.setIdProducto(IdProducto);
        String fecha = obtenerFechaActual(); //obtenemos la fecha actual;
        double cantidadVendida=(cantidad); // pasamos la cantidad vendida a double
        int idTipoDocumento = Integer.parseInt(request.getParameter("cb_TipoDocumento"));
        TipoDocumento unTipoDocumento = new TipoDocumento();
        unTipoDocumento.setIdTipoDocumento(idTipoDocumento);
        String numeroDocumento = request.getParameter("txt_NumeroFactura"); //numero de factura
       
         int cantidadNueva = cantidadAcutal-cantidad; // creamos una varible de la cnatidad nueva y hacemos una operacion de restar la cantidad de venta con la cantidad actual
        String observacionn ="PRODUCTO VENDIDO";
        String observacion = "REGISTRO DE VENTA, SE VENDIERON "+cantidad+" "+"Y QUEDARON "+cantidadNueva;
        Documento unDocumento = new Documento(numeroDocumento,unTipoDocumento,observacionn);
        int idUnidadMedida = dVenta.UnidadMedidaa(IdProducto); //averiguamos el id de la unidad de medida
        UnidadMedida unaUnidadMedida = new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
       
        String Estado = "A";
     
        String valor =  request.getParameter("txt_Valor");
  
        InventarioVenta unInventarioVenta = new InventarioVenta(unDetalleProducto, fecha, cantidadVendida, unaUnidadMedida, unDocumento, observacion, Estado,unUsuario);
        Venta unaVenta = new Venta(unDetalleProducto,fecha,cantidadVendida,valor,observacion,Estado,unUsuario);
        boolean agregado = dVenta.RegistrarVenta(unaVenta, unInventarioVenta,unDocumento,IdProducto,idUsuario); // Se agrega la ,el inventarioVenta,el documento.
        
         unDetalleProducto.setIdProducto(IdProducto); //Le estableces el dato de idProducto
        int idInfraestructura= 1; //idInfraestructura = sala de ventas
        Infraestructura unaInfraestructura = new Infraestructura();
        unaInfraestructura.setIdInfraestructura(idInfraestructura);
        int idTransaccion=2; // idTransaccion es igual a facuta
        Transaccion unaTransaccion = new Transaccion();
        unaTransaccion.setIdTransaccion(idTransaccion);
       
        
        
        InventarioInfraestructura unInventarioInfraestructura = new InventarioInfraestructura(unDetalleProducto,fecha,unaInfraestructura,cantidadNueva,observacion,unUsuario);
         String estado="A";
   
        int idInfraestructuraDespacho = 4; //Infrtaestructura despacho (ninguna)
        Infraestructura unaInfraestructuraDespacho = new Infraestructura();
        unaInfraestructuraDespacho.setIdInfraestructura(idInfraestructuraDespacho);
        Movimiento unMovimiento = new Movimiento(unaInfraestructura, unaTransaccion, numeroDocumento,unDetalleProducto, fecha, cantidad,unaUnidadMedida ,unDocumento, unaInfraestructuraDespacho, observacion, estado,unUsuario);
        boolean agregadoo = dProducto.agregarProducto(unInventarioInfraestructura,unMovimiento,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
       
        }else{
        boolean agregado = false;
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
        }
    }   
            
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
             private void listarVenta(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 ArrayList<Venta> lista= dVenta.listarVenta();
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                  private void listarTipoDocumento(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 ArrayList<TipoDocumento> lista= dTipoDocumento.ListarTipoDocumento();
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                  private void BuscarVenta(HttpServletRequest request , HttpServletResponse response)
                  throws ServletException,IOException{
                      String buscar = request.getParameter("buscar");
                      ArrayList<Venta> lista = dVenta.BuscarVenta(buscar);
                      PrintWriter out = response.getWriter();
                      String json = new Gson().toJson(lista);
                      out.print(json);
                  }

    private void BuscarVentaPorProductoYFecha(HttpServletRequest request , HttpServletResponse response)
                  throws ServletException,IOException{
                      String buscar = request.getParameter("buscar");
                      String fecha = request.getParameter("fecha");
                      ArrayList<Venta> lista = dVenta.BuscarVentaPorFechaYAtributosProducto(buscar,fecha);
                      PrintWriter out = response.getWriter();
                      String json = new Gson().toJson(lista);
                      out.print(json);
                  }
      private void BuscarProductoPorFecha(HttpServletRequest request , HttpServletResponse response)
                  throws ServletException,IOException{
                      String fecha = request.getParameter("fecha");
                      ArrayList<Venta> lista = dVenta.BuscarVentaPorFecha(fecha);
                      PrintWriter out = response.getWriter();
                      String json = new Gson().toJson(lista);
                      out.print(json);
                  }
            
             }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */


