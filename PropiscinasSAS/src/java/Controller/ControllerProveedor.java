/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosProveedor;
import Modelo.Entidad.Proveedor;
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
@WebServlet(name = "ControllerProveedor", urlPatterns = {"/ControllerProveedor"})
public class ControllerProveedor extends HttpServlet {
DatosProveedor dProveedor = new DatosProveedor();
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
            out.println("<title>Servlet ControllerProveedor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProveedor at " + request.getContextPath() + "</h1>");
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
            
            case "AgregarProveedor":AgregarProveedor(request, response);
            break;
            case "listarProveedor":listarProveedor(request,response);
            break;
            case "ListarProveedores":listarProveedores(request,response);
            break;
            case "obtenerProveedor":obtenerProveedor(request,response);
            break;
            case "EditarProveedor":EditarProveedor(request,response);
            break;
            case "buscarProveedor":buscarProveedor(request,response);
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

    private void AgregarProveedor(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       String nit = request.getParameter("txt_Nit");
       String nombre = request.getParameter("txt_Nombre");
       String telefono = request.getParameter("txt_Telefono");
       String estado = "A";
     Proveedor unProveedor = new Proveedor(nit,nombre,telefono,estado);
       boolean agregar = dProveedor.agregado(unProveedor);
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(agregar);
       out.print(json);
    }
  private void listarProveedor(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Proveedor> lista= dProveedor.ListarProveedor();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}
  private void listarProveedores(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
       ArrayList<Proveedor> lista= dProveedor.ListarProveedores();
       PrintWriter out= response.getWriter();
       String json= new Gson().toJson(lista);
       out.print(json);
     
}

    private void obtenerProveedor(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
            int Proveedor = Integer.parseInt(request.getParameter("idProveedor"));
            Proveedor unProveedor = dProveedor.obtenerProveedor(Proveedor);
            PrintWriter out= response.getWriter();
            String json= new Gson().toJson(unProveedor);
            out.print(json);
    
    }

    private void EditarProveedor(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        String nit = request.getParameter("txt_Nit");
        String numero = request.getParameter("txt_Nombre");
        String telefono = request.getParameter("txt_Telefono");
        String estado = request.getParameter("cb_Estado");
        int Proveedor = Integer.parseInt(request.getParameter("idProveedor"));
        boolean Editado = dProveedor.EditarProveedor(nit, numero, telefono,estado, Proveedor);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(Editado);
        out.print(json);
    }
    
            
    private void buscarProveedor(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        String buscar = request.getParameter("buscar");
        ArrayList<Proveedor> lista = dProveedor.buscarProveedor(buscar);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
     
}

