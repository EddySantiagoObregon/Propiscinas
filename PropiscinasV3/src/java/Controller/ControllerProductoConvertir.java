/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProducto;
import Modelo.Datos.DatosProductoConvertir;
import Modelo.Datos.DatosUsuario;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.Documento;
import Modelo.Entidad.Infraestructura;
import Modelo.Entidad.InventarioInfraestructura;
import Modelo.Entidad.Movimiento;
import Modelo.Entidad.ProductoConvertir;
import Modelo.Entidad.TipoDocumento;
import Modelo.Entidad.Transaccion;
import Modelo.Entidad.UnidadMedida;
import Modelo.Entidad.Usuario;
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
@WebServlet(name = "ControllerProductoConvertir", urlPatterns = {"/ControllerProductoConvertir"})
public class ControllerProductoConvertir extends HttpServlet {
DatosProductoConvertir dProductoConvertir = new DatosProductoConvertir();
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
            out.println("<title>Servlet ControllerProductoConvertir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProductoConvertir at " + request.getContextPath() + "</h1>");
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
            
            case "listarProductoConvetir": listarProductoConvertir(request, response);
            break;
            case "listarProductoConvetirCb": listarProductoConvertirCb(request, response);
            break;
            case "CovertirProducto":CovertirProducto(request,response);
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
 private void listarProductoConvertir(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<ProductoConvertir> lista= dProductoConvertir.ListarProductoConvertir();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
  private void listarProductoConvertirCb(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<ProductoConvertir> lista= dProductoConvertir.ListarProductoConvertirCb();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
  private void CovertirProducto(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        String correo = request.getParameter("txt_Correo");
        int idUsuario = dUsuario.idUsuario(correo);
        Usuario unUsuario = new Usuario();
        unUsuario.setIdUsuario(idUsuario);
        int productoConvertir = Integer.parseInt(request.getParameter("cb_ProductoConvertir"));
        int infraestructura = Integer.parseInt(request.getParameter("cb_Infraestructura"));
        InventarioInfraestructura unInventario = dProductoConvertir.unInvenratioo(productoConvertir,infraestructura);
        String idProducto = unInventario.getUnDetalleProducto().getIdProducto();
        DetalleProducto unDetalleProducto = new DetalleProducto();
        unDetalleProducto.setIdProducto(idProducto);
        String fecha = obtenerFechaActual();
        int idInfraestructura= unInventario.getUnaInfraestructura().getIdInfraestructura();
        Infraestructura unaInfraestructura = new Infraestructura();
        unaInfraestructura.setIdInfraestructura(idInfraestructura);
        int idTransaccion=4;
        Transaccion unaTransaccion = new Transaccion();
        unaTransaccion.setIdTransaccion(idTransaccion);
        int cantidadExistente = unInventario.getCantidad();
        int cantidadNueva = cantidadExistente-1;
        String observacion ="ESTE  PRODUCTO SE DESCONTO  PARA CONVERTIRSE";
        InventarioInfraestructura unInventarioInfraestructura = new InventarioInfraestructura(unDetalleProducto,fecha,unaInfraestructura,cantidadNueva,observacion,unUsuario);
        int idUnidadMedida = unInventario.getUnDetalleProducto().getUnaUnidadMedida().getIdUnidadMedida();
        UnidadMedida unaUnidadMedida = new UnidadMedida();
        unaUnidadMedida.setIdUnidadMedida(idUnidadMedida);
        String estado="A";
        int numeroFactura=0;
        int idInfraestructuraDespacho = 4;
        Infraestructura unaInfraestructuraDespacho = new Infraestructura();
        unaInfraestructuraDespacho.setIdInfraestructura(idInfraestructuraDespacho);
        Movimiento unMovimientos = dProductoConvertir.unMovimiento(productoConvertir, idInfraestructura);
        String numeroDocumento = unMovimientos.getUnDocumento().getNumerodocumento();
        int idTipoDocumento = unMovimientos.getUnDocumento().getUnTipoDocumento().getIdTipoDocumento();
        TipoDocumento unTipoDocumento = new TipoDocumento();
        unTipoDocumento.setIdTipoDocumento(idTipoDocumento);
        String obsrvacionDocumento = unMovimientos.getUnDocumento().getObservacion();
        Documento unDocumento = new Documento(numeroDocumento,unTipoDocumento,obsrvacionDocumento);
        Movimiento unMovimiento = new Movimiento(unaInfraestructura, unaTransaccion, numeroFactura,unDetalleProducto, fecha, cantidadNueva,unaUnidadMedida ,unDocumento, unaInfraestructuraDespacho, observacion, estado,unUsuario);
        boolean agregado = dProducto.agregarProducto(unInventarioInfraestructura,unMovimiento,idUsuario);
        if(agregado){
              String idProductoBotella = dProductoConvertir.ReturnaIdBotellaoBosa(productoConvertir,infraestructura);
              int cantidadMedida = dProductoConvertir.RetornaCantidadMedida(productoConvertir, idInfraestructura);
              int CantidadActual = dProductoConvertir.CantidadActual(idProductoBotella, idInfraestructura);
              if(cantidadMedida==3800){
      
        DetalleProducto unDetalleProductoo = new DetalleProducto();
        unDetalleProductoo.setIdProducto(idProductoBotella);
        String fechaa = obtenerFechaActual();
        int idInfraestructuraa= unInventario.getUnaInfraestructura().getIdInfraestructura();
        Infraestructura unaInfraestructuraa = new Infraestructura();
        unaInfraestructuraa.setIdInfraestructura(idInfraestructuraa);
        int idTransaccionn=4;
        Transaccion unaTransaccionn = new Transaccion();
        unaTransaccionn.setIdTransaccion(idTransaccionn);
        int cantidadExistentee = CantidadActual;
        int cantidadNuevaa = cantidadExistentee+7;
        String observacionn ="ESTE PRODUCTO SE CONVIRTIO. SE INGRESARON 7 BOTELLAS Y SE DESCONTO 1 GALÓN";
        InventarioInfraestructura unInventarioInfraestructuraa = new InventarioInfraestructura(unDetalleProductoo,fechaa,unaInfraestructuraa,cantidadNuevaa,observacionn,unUsuario);
        int idUnidadMedidaa = 5;
        UnidadMedida unaUnidadMedidaa = new UnidadMedida();
        unaUnidadMedidaa.setIdUnidadMedida(idUnidadMedidaa);
        String estadoo="A";
        int numeroFacturaa=0;
        int idInfraestructuraDespachoo = 4;
        Infraestructura unaInfraestructuraDespachoo = new Infraestructura();
        unaInfraestructuraDespachoo.setIdInfraestructura(idInfraestructuraDespachoo);
        String numeroDocumentoo = unMovimientos.getUnDocumento().getNumerodocumento();
        int idTipoDocumentoo = unMovimientos.getUnDocumento().getUnTipoDocumento().getIdTipoDocumento();
        TipoDocumento unTipoDocumentoo = new TipoDocumento();
        unTipoDocumentoo.setIdTipoDocumento(idTipoDocumentoo);
        String obsrvacionDocumentoo = unMovimientos.getUnDocumento().getObservacion();
        Documento unDocumentoo = new Documento(numeroDocumentoo,unTipoDocumentoo,obsrvacionDocumentoo);
        Movimiento unMovimientoo = new Movimiento(unaInfraestructuraa, unaTransaccionn, numeroFacturaa,unDetalleProductoo, fechaa, 7,unaUnidadMedidaa ,unDocumentoo, unaInfraestructuraDespachoo, observacionn, estadoo,unUsuario);
        boolean agregadoo = dProducto.agregarProducto(unInventarioInfraestructuraa,unMovimientoo,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
              }else{
        String idProductoBolsa = dProductoConvertir.ReturnaIdBotellaoBosa(productoConvertir,infraestructura);
        int cantidadMedidaa = dProductoConvertir.RetornaCantidadMedida(productoConvertir, idInfraestructura);
        int CantidadActuall = dProductoConvertir.CantidadActual(idProductoBotella, idInfraestructura);
        String forma = dProductoConvertir.forma(idProducto);
        DetalleProducto unDetalleProductoo = new DetalleProducto();
        unDetalleProductoo.setIdProducto(idProductoBolsa);
        String fechaa = obtenerFechaActual();
        int idInfraestructuraa= unInventario.getUnaInfraestructura().getIdInfraestructura();
        Infraestructura unaInfraestructuraa = new Infraestructura();
        unaInfraestructuraa.setIdInfraestructura(idInfraestructuraa);
        int idTransaccionn=4;
        Transaccion unaTransaccionn = new Transaccion();
        unaTransaccionn.setIdTransaccion(idTransaccionn);
        int cantidadExistentee = CantidadActuall;
        int cantidadNuevaa = cantidadExistentee+cantidadMedidaa;
        String observacionn ="ESTE PRODUCTO SE CONVIRTIO. SE INGRESARON "+cantidadMedidaa+" BOLSAS Y SE DESCONTO 1 "+forma;
        InventarioInfraestructura unInventarioInfraestructuraa = new InventarioInfraestructura(unDetalleProductoo,fechaa,unaInfraestructuraa,cantidadNuevaa,observacionn,unUsuario);
        int idUnidadMedidaa = 5;
        UnidadMedida unaUnidadMedidaa = new UnidadMedida();
        unaUnidadMedidaa.setIdUnidadMedida(idUnidadMedidaa);
        String estadoo="A";
        int numeroFacturaa=0;
        int idInfraestructuraDespachoo = 4;
        Infraestructura unaInfraestructuraDespachoo = new Infraestructura();
        unaInfraestructuraDespachoo.setIdInfraestructura(idInfraestructuraDespachoo);
        String numeroDocumentoo = unMovimientos.getUnDocumento().getNumerodocumento();
        int idTipoDocumentoo = unMovimientos.getUnDocumento().getUnTipoDocumento().getIdTipoDocumento();
        TipoDocumento unTipoDocumentoo = new TipoDocumento();
        unTipoDocumentoo.setIdTipoDocumento(idTipoDocumentoo);
        String obsrvacionDocumentoo = unMovimientos.getUnDocumento().getObservacion();
        Documento unDocumentoo = new Documento(numeroDocumentoo,unTipoDocumentoo,obsrvacionDocumentoo);
        Movimiento unMovimientoo = new Movimiento(unaInfraestructuraa, unaTransaccionn, numeroFacturaa,unDetalleProductoo, fechaa, cantidadMedidaa,unaUnidadMedidaa ,unDocumentoo, unaInfraestructuraDespachoo, observacionn, estadoo,unUsuario);
        boolean agregadoo = dProducto.agregarProducto(unInventarioInfraestructuraa,unMovimientoo,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregadoo);
        out.print(json);
              }
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
}
