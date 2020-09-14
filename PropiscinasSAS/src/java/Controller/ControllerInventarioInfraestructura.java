/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosInventarioInfraestructura;
import Modelo.Entidad.DetalleProducto;
import Modelo.Entidad.InventarioInfraestructura;
import Modelo.Entidad.Presentacion;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PAULA
 */
@WebServlet(name = "ControllerInventarioInfraestructura", urlPatterns = {"/ControllerInventarioInfraestructura"})
public class ControllerInventarioInfraestructura extends HttpServlet {
    DatosInventarioInfraestructura dInventario =  new  DatosInventarioInfraestructura();
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
            out.println("<title>Servlet ControllerInventarioInfraestructura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerInventarioInfraestructura at " + request.getContextPath() + "</h1>");
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
            case    "Seleccionar": seleccionar(request, response);
            break;
            case    "Seleccionar2": seleccionar2(request, response);
            break;
            case  "listarInventario" :listarInventario(request,response);
            break;
            case "listarInventarioInfraestructura":listarInventarioIdInfraestructura(request,response);
            break;
            case "listarCantidadActual": listarCantidadActualizada(request,response);
            break;
             case "totalProductosInfraestructura":totalProductosInfraestructura(request,response);
            break;
             case "listarCantidadActualInfraestructura":listarCantidadActualizadaInfraestructura(request,response);
             break;
             case "BuscarCantidadActualizadaPorCodigoYInfraestructura":BuscarCantidadActualizadaPorCodigoYInfraestructura(request,response);
             break;
             case"BuscarCantidadActualizadaPorNombreYInfraestructura":BuscarCantidadActualizadaPorNombreYInfraestructura(request,response);
             break;
             case"BuscarProducto":buscarProducto(request,response);
             break;
             case"listarInventarioPorFecha":listarInventarioPorFecha(request,response);
             break;
             case "listarInventarioPorFechaYCodigo":listarInventarioPorFechaYCodigo(request,response);
             break;
             case "listarInventarioPorFechaYCodigoYInfraestructura":listarInventarioPorFechaYCodigoYInfraestructura(request, response);
             break;
             case "buscarInventarioDatosHistoricos":buscarInventarioDatosHistoricos(request,response);
             break;
             case "totalProductosInfraestructuraYcodigo":totalProductosInfraestructuraYcodigo(request,response);
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
  //Este metodo lo usamos para buscar en inventario del producto , que sera utilizado en la vista solo
  //para mostrar la cantidad que tiene el producto
    private void seleccionar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String Buscar = request.getParameter("buscar");
        String infraestructura = request.getParameter("infraestructura");
       InventarioInfraestructura inv =  dInventario.elegido(Buscar,infraestructura);
        PrintWriter out= response.getWriter();
        String json = new Gson().toJson(inv);
        out.print(json);
        
    }
     private void seleccionar2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html; charset=UTF-8");
        String Buscar = request.getParameter("buscar");
        String infraestructura = request.getParameter("infraestructura");
       InventarioInfraestructura inv =  dInventario.elegido2(Buscar,infraestructura);
        PrintWriter out= response.getWriter();
        String json = new Gson().toJson(inv);
        out.print(json);
        
    }
    
       private void listarInventario(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       ArrayList<InventarioInfraestructura> lista= dInventario.listaInventario();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
          private void listarInventarioIdInfraestructura(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       int id = Integer.parseInt(request.getParameter("infraestructura"));
       ArrayList<InventarioInfraestructura> lista= dInventario.listaInventario(id);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
       

    private void listarCantidadActualizada(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       
       ArrayList<InventarioInfraestructura> lista= dInventario.listaInventarioCantidadActual();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
         private void totalProductosInfraestructura(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
       ArrayList<InventarioInfraestructura> lista= dInventario.totalProductosInfraestructura();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
                private void totalProductosInfraestructuraYcodigo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
       String buscar = request.getParameter("buscar");
       ArrayList<InventarioInfraestructura> lista= dInventario.totalProductosInfraestructuraYcodigo(buscar);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
         private void listarCantidadActualizadaInfraestructura(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       int Infraestructura = Integer.parseInt(request.getParameter("infraestructura"));
       ArrayList<InventarioInfraestructura> lista= dInventario.listaInventarioCantidadActualInfraestructura(Infraestructura);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
              private void BuscarCantidadActualizadaPorCodigoYInfraestructura(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       String buscar = request.getParameter("buscar1");
       int Infraestructura = Integer.parseInt(request.getParameter("infraestructura"));
       ArrayList<InventarioInfraestructura> lista= dInventario.BuscarProductoCantidadActualPorCodigoYInfraestructura(buscar,Infraestructura);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
                   private void BuscarCantidadActualizadaPorNombreYInfraestructura(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       String buscar = request.getParameter("buscar1");
       int Infraestructura = Integer.parseInt(request.getParameter("infraestructura"));
       ArrayList<InventarioInfraestructura> lista= dInventario.BuscarProductoCantidadActualPorNombreYInfraestructura(buscar,Infraestructura);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }

    private void buscarProducto(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException {
        response.setContentType("text/html; charset=UTF-8");
         String buscar = request.getParameter("buscar");
      ArrayList<InventarioInfraestructura> lista= dInventario.buscarProducto(buscar);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
        private void listarInventarioPorFecha(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException {
        response.setContentType("text/html; charset=UTF-8");
         String fecha = request.getParameter("fecha");
      ArrayList<InventarioInfraestructura> lista= dInventario.listaInventarioPorFecha(fecha);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
        private void listarInventarioPorFechaYCodigo(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException {
        response.setContentType("text/html; charset=UTF-8");
         String fecha = request.getParameter("fecha");
         String codigo = request.getParameter("codigo");
      ArrayList<InventarioInfraestructura> lista= dInventario.listaInventarioPorFechaYCodigo(fecha,codigo);
      int numero = lista.size();
      if(numero==0){
          
                    ArrayList<InventarioInfraestructura> listaa= dInventario.listaInventarioPorFechaYNombre(fecha,codigo);
                    PrintWriter out= response.getWriter();
                    String json= new Gson().toJson(listaa);
                     out.print(json);
      }else{
                    PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
      }
       
    }
           private void listarInventarioPorFechaYCodigoYInfraestructura(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException {
        response.setContentType("text/html; charset=UTF-8");
         String fecha = request.getParameter("fecha");
         String codigo = request.getParameter("codigo");
         int infraesctructura = Integer.parseInt(request.getParameter("infraestructura"));
      ArrayList<InventarioInfraestructura> lista= dInventario.listaInventarioPorFechaYCodigoYInfraestructura(fecha,codigo,infraesctructura);
      int numero = lista.size();
      if(numero==0){
           ArrayList<InventarioInfraestructura> listaa= dInventario.listaInventarioPorFechaYNombreYInfraestructura(fecha,codigo,infraesctructura);
           PrintWriter out= response.getWriter();
          String json= new Gson().toJson(listaa);
          out.print(json); 
      }else{
          PrintWriter out= response.getWriter();
          String json= new Gson().toJson(lista);
          out.print(json); 
      }
      
    }
        
       private void buscarInventarioDatosHistoricos(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException,IOException {
        response.setContentType("text/html; charset=UTF-8");
       String codigo = request.getParameter("codigo");
       ArrayList<InventarioInfraestructura> lista= dInventario.buscarInventarioDatosHistoricos(codigo);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
    
}
