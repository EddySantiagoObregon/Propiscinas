/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.Correo;
import Modelo.Datos.DatosUsuario;
import Modelo.Entidad.Usuario;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PAULA
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {
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
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
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
        Usuario unUsuario = new Usuario();
        String tarea= request.getParameter("accion");
        switch(tarea)
        {
            case "IniciarSesion":
                iniciarSesion(request, response);
                break;
            case "RegistrarPersona":RegistrarPersona(request,response);
            break;
             case "ActualizarPassword": actualizarPassword(request, response);
              break  ;  
             case "Nombre" : nombre(request,response);
             break;
           
    }}
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String login = request.getParameter("txtLogin");
        String password = request.getParameter("txtPassword");
        Usuario unUsuario = new Usuario();
        unUsuario.setCorreo(login);
        unUsuario.setContrasena(password);
        Usuario user= dUsuario.iniciarSesion(unUsuario);
        if(user!=null)
        {
           
               
                HttpSession session = request.getSession(true);
                session.setAttribute("idUsuario", user.getIdUsuario());
                session.setAttribute("identificacion", user.getIdentificacion());
                session.setAttribute("correo", user.getCorreo());
                session.setAttribute("telefono", user.getTelefono());
                session.setAttribute("nombre", user.getNombre());
                response.sendRedirect(request.getContextPath() + "/Vista/MenuPrincipal.jsp");   
                       
                
         
        }else
        {
            response.sendRedirect(request.getContextPath() + "/Vista/IniciarSesion.jsp?valor=x");
        }
    }
    private void RegistrarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int identificacion = Integer.parseInt(request.getParameter("txt_Identificacion"));
        String nombre = request.getParameter("txt_Nombre");
        String telefono = request.getParameter("txt_Tel");
        String correo = request.getParameter("txt_Correo");
        String contrasena = request.getParameter("txt_Contrasena");
        Usuario unUsuario = new Usuario(identificacion, nombre, telefono, correo, contrasena);
      boolean agregado = dUsuario.agregado(unUsuario);
      PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
           if(unUsuario!=null)
        {
           
               
                HttpSession session = request.getSession(true);
                session.setAttribute("idUsuario", unUsuario.getIdUsuario());
                session.setAttribute("identificacion", unUsuario.getIdentificacion());
                session.setAttribute("telefono", unUsuario.getTelefono());
                session.setAttribute("correo", unUsuario.getCorreo());
                session.setAttribute("nombre" , unUsuario.getNombre());
                        
                   
        }
    }
    private void actualizarPassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    int identifica = Integer.parseInt(request.getParameter("identificacion"));
    String correo = request.getParameter("correo");
    Usuario user = new Usuario();
    user.setIdentificacion(identifica);
    user.setCorreo(correo);
    user.genearPassword();
    boolean actualizado = dUsuario.actualizarPassword(user);
    if (actualizado){
        enviarNuevoPasswordCorreoElectronico(user);
    }
    PrintWriter out = response.getWriter();
    String json = new Gson().toJson(actualizado);
    out.print(json);
    }
    
          private void enviarNuevoPasswordCorreoElectronico(Usuario unUsuario){
         
         String correo = unUsuario.getCorreo();
         String Contraseña = unUsuario.getContrasena();
         String asunto = "Restablecimiento de contraseña - Propiscinas del Huila  S.A.S ";
         String mensaje = "Estimado(a) Usuario(a)"
                + "<br><b>Su contraseña de acceso a Propiscinas del Huila  S.A.S ha sido</b>" 
                + "<br>restablecida correctamente.</b>" 
                + "<br><b>       </b>" 
                + "<br><b>Sus datos de acceso son: </b>"
                + "<br><b>       </b>" 
                + "<br><b>Correo: </b>" + correo  
                + "<br><b>Contraseña: </b>" + Contraseña
                + "<br><b>       </b>" 
                + "<br><b>Una vez ingrese con la nueva contraseña, se sugiere realizar el cambio por      </b>"  
                + "<br><b>una contraseña de facil recordación para usted.    </b>" 
                + "<br><b>       </b>" 
                + "<br>_________________________________________________________________________________________</b>"
                 + "<br><b>       </b>" 
                 + "<br><b>Propiscinas del Huila  S.A.S</b>" 
                 + "<br><br>Inicia sesion dando click aquí http://localhost:8080/PropiscinasV3/Vista/IniciarSesion.jsp";
            
         Correo.enviarCorreo(correo, asunto, mensaje);
     }   

    private void nombre(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String correo = request.getParameter("Correo");
        Usuario unUsuario = dUsuario.nombre(correo);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unUsuario);
        out.print(json);
    }
}
