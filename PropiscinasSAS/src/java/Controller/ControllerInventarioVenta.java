/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosInventarioVenta;
import Modelo.Datos.DatosProducto;
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
@WebServlet(name = "ControllerInventarioVenta", urlPatterns = {"/ControllerInventarioVenta"})
public class ControllerInventarioVenta extends HttpServlet {

DatosInventarioVenta dInventarioVenta = new DatosInventarioVenta();
DatosVenta dVenta = new DatosVenta();
DatosProducto dProducto = new DatosProducto();
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
           
            case "listarInventarioVenta": listarInventarioVenta(request,response);
            break;
            case "listarVentaPorFactura":listarVentaPorFactura(request,response);
            break;
            case "DevolucionProductos":devolucionProductos(request,response);
            break;
            case "buscarIventarioVenata": buscarInventarioVenta(request,response);
            break;
            case "buscarInventarioVentaPorFecha":buscarInventarioVentaPorFecha(request,response);
            break;
            case "buscarInventarioVentaPorProductoYFecha":buscarInventarioVentaPorProductoYFecha(request,response);
            break;
            case "BuscarPorTipoDocumento":BuscarPorTipoDocumento(request,response);
            break;
            case "BuscarPorTipoDocumentoYFecha":BuscarPorTipoDocumentoYFecha(request,response);
            break;
            case "BuscarPorProductoYTipoDocumentoYFecha":BuscarPorProductoYTipoDocumentoYFecha(request,response);
            break;
            case "BuscarPorProductoYTipoDocumento":BuscarPorProductoYTipoDocumento(request,response);
            break;
            case "Productomasvendido":toptresproductosmasvendidos(request,response);
            break;
            case "Productomasvendidohoy":Productomasvendidohoy(request,response);
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
    
    

             private void listarInventarioVenta(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 ArrayList<InventarioVenta> lista= dInventarioVenta.listarVenta();
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                 private void listarVentaPorFactura(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 String factura = request.getParameter("factura");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.listarVentaPorFactura(factura);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                            private void buscarInventarioVenta(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 String buscar = request.getParameter("buscar");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.buscarInventarioVenta(buscar);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                            
                                                       private void buscarInventarioVentaPorFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 String fecha = request.getParameter("fecha");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.buscarInventarioVentaPorFecha(fecha);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                                                       
    private void buscarInventarioVentaPorProductoYFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 String fecha = request.getParameter("fecha");
                 String buscar = request.getParameter("buscar");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.buscarInventarioVentaPorProductoYFecha(buscar,fecha);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
    private void BuscarPorTipoDocumento(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 int TipoDocumento =Integer.parseInt(request.getParameter("TipoDocumento"));
                 ArrayList<InventarioVenta> lista= dInventarioVenta.BuscarPorTipoDocumento(TipoDocumento);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
    
                private void BuscarPorTipoDocumentoYFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 int TipoDocumento =Integer.parseInt(request.getParameter("TipoDocumento"));
                 String fecha = request.getParameter("fecha");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.BuscarPorTipoDocumentoYFecha(TipoDocumento,fecha);
                
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
                 
        }
                
                                    private void BuscarPorProductoYTipoDocumentoYFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 int TipoDocumento =Integer.parseInt(request.getParameter("TipoDocumento"));
                 String fecha = request.getParameter("fecha");
                 String buscar = request.getParameter("buscar");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.BuscarPorProductoYTipoDocumentoYFecha(buscar,fecha,TipoDocumento);
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
                         
                                                  private void BuscarPorProductoYTipoDocumento(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 int TipoDocumento =Integer.parseInt(request.getParameter("TipoDocumento"));
                 String buscar = request.getParameter("buscar");
                 ArrayList<InventarioVenta> lista= dInventarioVenta.BuscarPorProductoYTipoDocumento(buscar,TipoDocumento);
                  int numero = lista.size();
                 if(numero==0){
                     ArrayList<InventarioVenta>listaa= dInventarioVenta.BuscarPorNumeroDocumentoYTipoDocumento(buscar, TipoDocumento);
                     PrintWriter out = response.getWriter();
                     String json = new Gson().toJson(listaa);
                    out.print(json);
                 }else{
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
                 }
        }
    private void devolucionProductos(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        String correo = request.getParameter("txt_Correo");
        int idUsuario = dUsuario.idUsuario(correo);
        if(idUsuario>0){
        Usuario unUsuario = new Usuario();
        unUsuario.setIdUsuario(idUsuario);
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String fech = request.getParameter("fecha");
        String IdProducto=request.getParameter("codigo");
        String nombreTipoDocumento = request.getParameter("tipoDocumento");
        String numeroDocumento = request.getParameter("numeroDocumento");
        boolean desactivado = dInventarioVenta.desactivado(cantidad, fech, IdProducto);
        if(desactivado==true){
        int idTipoDocumento = dInventarioVenta.TipoDocumentos(nombreTipoDocumento);
        int cantidadAcutal = dVenta.cantidad(IdProducto);
        DetalleProducto unDetalleProducto = new DetalleProducto();
        Producto unProducto = new Producto();
        unProducto.setIdProducto(IdProducto);
        String fecha = obtenerFechaActual(); 
        TipoDocumento unTipoDocumento = new TipoDocumento();
        unTipoDocumento.setIdTipoDocumento(idTipoDocumento);
        String obsevacion=" ";
        Documento unDocumento = new Documento(numeroDocumento,unTipoDocumento,obsevacion);
        int idUnidadMedida = dVenta.UnidadMedida(IdProducto);
        UnidadMedida unaUnidadMedida = new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        int cantidadNueva = cantidadAcutal+cantidad; 
        String observacion = "REGISTRO DE DEVOLUCIÓN DE PRODUCTOS";
        unDetalleProducto.setIdProducto(IdProducto); 
        int idInfraestructura= 1; //idInfraestructura = sala de ventas
        Infraestructura unaInfraestructura = new Infraestructura();
        unaInfraestructura.setIdInfraestructura(idInfraestructura);
        int idTransaccion=3; // idTransaccion es igual a DEVOLUCIÓN
        Transaccion unaTransaccion = new Transaccion();
        unaTransaccion.setIdTransaccion(idTransaccion);
        String observacionn ="DEVOLUCION DEL PRODUCTO";
        InventarioInfraestructura unInventarioInfraestructura = new InventarioInfraestructura(unDetalleProducto,fecha,unaInfraestructura,cantidadNueva,observacion,unUsuario);
         String estado="A";
        int numeroFactura=Integer.parseInt(numeroDocumento);
        int idInfraestructuraDespacho = 4; //Infrtaestructura despacho (ninguna)
        Infraestructura unaInfraestructuraDespacho = new Infraestructura();
        unaInfraestructuraDespacho.setIdInfraestructura(idInfraestructuraDespacho);
        Movimiento unMovimiento = new Movimiento(unaInfraestructura, unaTransaccion, numeroFactura,unDetalleProducto, fecha, cantidad,unaUnidadMedida ,unDocumento, unaInfraestructuraDespacho, observacionn, estado,unUsuario);
        boolean agregadoo = dProducto.agregarProducto(unInventarioInfraestructura,unMovimiento,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
        }else{
        boolean agregadoo=false;
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
        }
      }else{
            boolean agregadoo=false;
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(agregadoo);
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
            
            private void toptresproductosmasvendidos(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                 ArrayList<InventarioVenta> lista= dInventarioVenta.Productomasvendido();
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
            
                       private void Productomasvendidohoy(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
                          
                 ArrayList<InventarioVenta> lista= dInventarioVenta.Productomasvendidohoy();
                 PrintWriter out = response.getWriter();
                 String json = new Gson().toJson(lista);
                 out.print(json);
        }
             }
    