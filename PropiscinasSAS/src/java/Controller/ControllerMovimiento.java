/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Modelo.Datos.DatosMovimiento;
import Modelo.Entidad.Movimiento;
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
@WebServlet(name = "ControllerMovimiento", urlPatterns = {"/ControllerMovimiento"})
public class ControllerMovimiento extends HttpServlet {
DatosMovimiento dMovimiento = new DatosMovimiento();
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
            out.println("<title>Servlet ControllerMovimiento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerMovimiento at " + request.getContextPath() + "</h1>");
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
            case    "listarMovimiento": listarMovimiento(request, response);
            break;
            case "BuscarMovimiento" :BuscarMovimiento(request,response);
            break;
            case "BuscarMovimientoPorFecha":BuscarMovimientoPorFecha(request,response);
            break;
            case "BuscarMovimientoPorFechaYNumeroDocumento":BuscarMovimientoPorFechaYNumeroDocumento(request,response);
            break;
            case "BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento":BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento(request,response);
            break;
            case "BuscarMovimientoTipoDocumento":BuscarMovimientoTipoDocumento(request,response);
            break;
            case "BuscarMovimientoTipoDocumentoYFecha":BuscarMovimientoTipoDocumentoYFecha(request,response);
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

    private void listarMovimiento(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
       
       ArrayList<Movimiento> lista= dMovimiento.listarMovimiento();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
        
    }
       private void BuscarMovimiento(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        String Buscar = request.getParameter("buscar");
        ArrayList<Movimiento> lista= dMovimiento.buscarMovimiento(Buscar);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
    }
        private void BuscarMovimientoPorFecha(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        String fecha = request.getParameter("fecha");
        ArrayList<Movimiento> lista= dMovimiento.BuscarMovimientoPorFecha(fecha);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);        
       out.print(json);
    }
        
         private void BuscarMovimientoPorFechaYNumeroDocumento(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        String numeroDocumento = request.getParameter("buscar");
        String fecha = request.getParameter("fecha");
        ArrayList<Movimiento> lista= dMovimiento.BuscarMovimientoPorFechaYNumeroDocumento(fecha,numeroDocumento);
        int numero = lista.size();
         if(numero==0){
            ArrayList<Movimiento> listaa= dMovimiento.BuscarMovimientoPorFechaYProductoCodigo(fecha,numeroDocumento);
             PrintWriter out= response.getWriter();
            String json= new Gson().toJson(listaa);        
            out.print(json);
        }else{
            PrintWriter out= response.getWriter();
            String json= new Gson().toJson(lista);        
            out.print(json);
        }
    }
      private void BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        response.setContentType("text/html; charset=UTF-8");
          String numeroDocumento = request.getParameter("buscar");
        String fecha = request.getParameter("fecha");
        int tipoDocumento = Integer.parseInt(request.getParameter("idTipoDocumento"));
        ArrayList<Movimiento> lista= dMovimiento.BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento(fecha,numeroDocumento,tipoDocumento);
        int numero = lista.size();
        if(numero==0){
            ArrayList<Movimiento> listaa= dMovimiento.BuscarMovimientoPorFechaYCodigoProductoYTipoDocumento(fecha,numeroDocumento,tipoDocumento);
             PrintWriter out= response.getWriter();
            String json= new Gson().toJson(listaa);        
            out.print(json);
        }else{
            PrintWriter out= response.getWriter();
            String json= new Gson().toJson(lista);        
            out.print(json);
        }
       
      }
      
              private void BuscarMovimientoTipoDocumento(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        response.setContentType("text/html; charset=UTF-8");
                
                 int tipoDocumento = Integer.parseInt(request.getParameter("idTipoDocumento"));
                 ArrayList<Movimiento> lista= dMovimiento.BuscarMovimientoTipoDocumento(tipoDocumento);
                 PrintWriter out= response.getWriter();
                 String json= new Gson().toJson(lista);        
                 out.print(json);

       
      }
              
           private void BuscarMovimientoTipoDocumentoYFecha(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        response.setContentType("text/html; charset=UTF-8");
                String fecha = request.getParameter("fecha");
                 int tipoDocumento = Integer.parseInt(request.getParameter("idTipoDocumento"));
                 ArrayList<Movimiento> lista= dMovimiento.BuscarMovimientoTipoDocumentoYFecha(fecha,tipoDocumento);
                 PrintWriter out= response.getWriter();
                 String json= new Gson().toJson(lista);        
                 out.print(json);

       
      }             

           
}
