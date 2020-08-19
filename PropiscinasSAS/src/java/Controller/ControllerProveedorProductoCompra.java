/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProveedorProductoCompra;
import Modelo.Entidad.Proveedor;
import Modelo.Entidad.ProveedorProductoCompra;
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
@WebServlet(name = "ControllerProveedorProductoCompra", urlPatterns = {"/ControllerProveedorProductoCompra"})
public class ControllerProveedorProductoCompra extends HttpServlet {
DatosProveedorProductoCompra dproveedorProductoCompra = new DatosProveedorProductoCompra();
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
            out.println("<title>Servlet ControllerProveedorProductoCompra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProveedorProductoCompra at " + request.getContextPath() + "</h1>");
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
         
            case "ListarProveedorProductoCompra":ListarProveedorProductoCompra(request,response);
            break;
            case "BuscarPorNombre":BuscarPorNombre(request,response);
            break;
            case "BuscarPorNombreYFecha":BuscarPorNombreYFecha(request,response);
            break;
            case "BuscarPorFecha":BuscarPorFecha(request,response);
            break;
            case "BuscarPorProveedor":BuscarPorProveedor(request,response);
            break;
            case "BuscarPorProveedorYFecha":BuscarPorProveedorYFecha(request,response);
            break;
            case "BuscarPorProveedorYFechaYidProducto":BuscarPorProveedorYFechaYidProducto(request,response);
            break;
            case "BuscarPorProveedorYidProducto":BuscarPorProveedorYidProducto(request,response);
            break;
        }
     }

 
          private void ListarProveedorProductoCompra(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
    
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.ListarProveedorProductoCompra();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
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

    private void BuscarPorNombre(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        String buscar = request.getParameter("buscar");
       ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorNombre(buscar);
        int numero = lista.size();
        if(numero==0){
           
                     ArrayList<ProveedorProductoCompra> listaa= dproveedorProductoCompra.BuscarPorDocumento(buscar);
                     int numeroo = listaa.size();
                     if(numeroo==0){
                         ArrayList<ProveedorProductoCompra> listaaa= dproveedorProductoCompra.BuscarPorIdProducto(buscar);
                         PrintWriter out = response.getWriter();
                         String json = new Gson().toJson(listaaa);
                     out.print(json);
                     }else{
                     PrintWriter out = response.getWriter();
                     String json = new Gson().toJson(listaa);
                     out.print(json); 
                     }
                    
                     
        }else{
            PrintWriter out = response.getWriter();
            String json = new Gson().toJson(lista);
            out.print(json);
        }
        
    }
 private void BuscarPorNombreYFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        String buscar = request.getParameter("buscar");
        String fecha = request.getParameter("fecha");
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorNombreYFecha(buscar,fecha);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
  private void BuscarPorFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
      
        String fecha = request.getParameter("fecha");
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorFecha(fecha);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
  
          private void BuscarPorProveedor(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
      
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorProveedor(idProveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                private void BuscarPorProveedorYFecha(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
      
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        String fecha = request.getParameter("fecha");
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorProveedorYFecha(idProveedor,fecha);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                private void BuscarPorProveedorYFechaYidProducto(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
      
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        String fecha = request.getParameter("fecha");
        String idProducto = request.getParameter("idProducto");
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorProveedorYFechaYidProducto(idProveedor,fecha,idProducto);
        int numero= lista.size();
        if(numero==0){
             ArrayList<ProveedorProductoCompra> listaa= dproveedorProductoCompra.BuscarPorProveedorYFechaYnumeroDocumento(idProveedor,fecha,idProducto);
             PrintWriter out = response.getWriter();
             String json = new Gson().toJson(listaa);
            out.print(json);
        }else{
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
        }
        }
                
                                private void BuscarPorProveedorYidProducto(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
      
        int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        String idProducto = request.getParameter("idProducto");
        ArrayList<ProveedorProductoCompra> lista= dproveedorProductoCompra.BuscarPorProveedorYidProducto(idProveedor,idProducto);
         int numero= lista.size();
        if(numero==0){
             ArrayList<ProveedorProductoCompra> listaa= dproveedorProductoCompra.BuscarPorProveedorYnumeroDocumento(idProveedor,idProducto);
             PrintWriter out = response.getWriter();
             String json = new Gson().toJson(listaa);
            out.print(json);
        }else{
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
        }
    }
}
