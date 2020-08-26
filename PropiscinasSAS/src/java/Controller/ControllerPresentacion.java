/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosPresentacion;
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
@WebServlet(name = "ControllerPresentacion", urlPatterns = {"/ControllerPresentacion"})
public class ControllerPresentacion extends HttpServlet {
DatosPresentacion dPresentacion = new DatosPresentacion();
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
            out.println("<title>Servlet ControllerPresentacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerPresentacion at " + request.getContextPath() + "</h1>");
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
      
        String tarea= request.getParameter("accion");
        switch(tarea)
        {
            case "agregar":Agregar(request, response);
            break;
            case "listar":listarPresentacion(request,response);
            break;
            case "Editar":desactivarPresentacion(request,response);
            break;
            case "obtenerPresentacion":obtenerPresentacion(request,response);
            break;
            
           
    }}
   
            
                     private void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String descripcion = request.getParameter("nombre");
        String observacion = " ";
        String estado ="A";
        Presentacion unaPresentacion = new Presentacion(descripcion, observacion, estado);
        boolean agregado = dPresentacion.RegistrarPresentacion(unaPresentacion);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
                        private void listarPresentacion(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
       
        ArrayList<Presentacion> lista = dPresentacion.ListarPresentaciones();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                                       private void desactivarPresentacion(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        int idPresentacion = Integer.parseInt(request.getParameter("id"));
        String estado  = request.getParameter("cb_Estado");
        boolean  desactivar = dPresentacion.DesactivaroActivar(idPresentacion, estado);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(desactivar);
        out.print(json);
    }
            private void obtenerPresentacion(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        int idGrupo = Integer.parseInt(request.getParameter("id"));
  
        Presentacion unaPresentacion = dPresentacion.obetenerPresentacionId(idGrupo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unaPresentacion);
        out.print(json);
    }
                        
 
  

}
