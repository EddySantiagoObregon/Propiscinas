/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProveedorProducto;
import Modelo.Entidad.Producto;
import Modelo.Entidad.Proveedor;
import Modelo.Entidad.ProveedorProducto;
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
@WebServlet(name = "ControllerProveedorProducto", urlPatterns = {"/ControllerProveedorProducto"})
public class ControllerProveedorProducto extends HttpServlet {
DatosProveedorProducto dProveedorProducto = new DatosProveedorProducto();
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
            out.println("<title>Servlet ControllerProveedorProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProveedorProducto at " + request.getContextPath() + "</h1>");
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
            case "ListarProveedorProducto":ListarProveedorProducto(request,response);
            break;
            case "ListarProveedorProductos":ListarProveedorProductos(request,response);
            break;
            case "ListarProveedoresYProductosPorCodigo":ListarProveedoresYProductosPorCodigo(request,response);
            break;
            case "BuscarPorProveedoryIdProducto":ListarProveedoresYProductosPorCodigoYidProveedor(request,response);
            break;
            case "ListarProveedoresYProductosPoridProveedor":ListarProveedoresYProductosPoridProveedor(request,response);
            break;
            case "Activar":Activado(request,response);
            break;
            case "Desactivar":Desactivado(request,response);
            break;
        }
     }
 private void agregar(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
    

        String idProducto = request.getParameter("idProducto");
        int idProveedor = Integer.parseInt(request.getParameter("cb_Proveedor"));
    boolean agregado = dProveedorProducto.agregado(idProveedor,idProducto);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
 
          private void ListarProveedorProducto(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
    

        String idProducto = request.getParameter("idProducto");
    
    ArrayList<Proveedor> lista= dProveedorProducto.ListarProveedorProducto(idProducto);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
             private void ListarProveedorProductos(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
       
        ArrayList<ProveedorProducto> lista= dProveedorProducto.ListarProveedoresYProductos();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                        private void ListarProveedoresYProductosPorCodigo(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
       String codigoPro = request.getParameter("codigo");
        ArrayList<ProveedorProducto> lista= dProveedorProducto.ListarProveedoresYProductosPorCodigo(codigoPro);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                                 private void ListarProveedoresYProductosPorCodigoYidProveedor(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
       String codigoPro = request.getParameter("codigo");
       int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        ArrayList<ProveedorProducto> lista= dProveedorProducto.ListarProveedoresYProductosPorCodigoYidProveedor(codigoPro,idProveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                                                              private void ListarProveedoresYProductosPoridProveedor(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {

       int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        ArrayList<ProveedorProducto> lista= dProveedorProducto.ListarProveedoresYProductosPoridProveedor(idProveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                                                              
           private void Activado(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {

       int idProveedor = Integer.parseInt(request.getParameter("id"));
        boolean agreado= dProveedorProducto.Activado(idProveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agreado);
        out.print(json);
    }
                 private void Desactivado(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {

       int idProveedor = Integer.parseInt(request.getParameter("id"));
        boolean agreado= dProveedorProducto.Desactivado(idProveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agreado);
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

}
