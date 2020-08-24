/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.DatosGrupo;
import Modelo.Entidad.Grupo;
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
@WebServlet(name = "ControllerGrupo", urlPatterns = {"/ControllerGrupo"})
public class ControllerGrupo extends HttpServlet {
DatosGrupo dGrupo = new DatosGrupo();
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
            out.println("<title>Servlet ControllerGrupo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerGrupo at " + request.getContextPath() + "</h1>");
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
            case "listar":listarGrupos(request,response);
            break;
            case "desactivar":desactivarGrupo(request,response);
            break;
            case "obtenerGrupo":obtenerGrupo(request,response);
            break;
            
           
    }}
   
            
                     private void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String descripcion = request.getParameter("txt_Nombre1");
        String observacion = " ";
        String estado ="A";
        Grupo unGrupo = new Grupo(descripcion, observacion, estado);
        boolean agregado = dGrupo.RegistrarGrupo(unGrupo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
                        private void listarGrupos(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
       
        ArrayList<Grupo> lista = dGrupo.ListarGrupos();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                                       private void desactivarGrupo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        int idGrupo = Integer.parseInt(request.getParameter("id"));
        String estado  = request.getParameter("estado");
        boolean  desactivar = dGrupo.DesactivaroActivar(idGrupo, estado);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(desactivar);
        out.print(json);
    }
            private void obtenerGrupo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
        int idGrupo = Integer.parseInt(request.getParameter("id"));
  
        Grupo unGrupo = dGrupo.obetenerGrupoId(idGrupo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unGrupo);
        out.print(json);
    }
                        
 
  

}
