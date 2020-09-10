/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Datos.Correo;
import Modelo.Datos.DatosUsuario;
import Modelo.Entidad.EncriptarYDesencriptar;
import Modelo.Entidad.Usuario;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
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
             case "ActualizarDatos":ActualizarDatos(request,response);
             break;
             case "EditarContrasena":EditarContrasena(request,response);
             break;
             case "listarUsuario":ListarUsuario(request,response);
             break;
             case "obtenerUsuario":obtenerUsuario(request,response);
             break;
             case "EditarUsuario":EditarUsuario(request,response);
             break;
           
    }}
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String login = request.getParameter("txtLogin");
        String password = request.getParameter("txtPassword");

    
                   String contrasena = dUsuario.buscarContrasena(login);
    EncriptarYDesencriptar unEnctiptarYDesencriptar = new EncriptarYDesencriptar();
    String contrasenaEncriptada = unEnctiptarYDesencriptar.Desencriptar(contrasena);
  
                      if(password.equals(contrasenaEncriptada)){
   
        Usuario unUsuario = new Usuario();
        unUsuario.setCorreo(login);
        unUsuario.setContrasena(contrasena);
        Usuario user= dUsuario.iniciarSesion(unUsuario);
         
        
   
        if(user!=null)
        {
               if("propiscinasdelhuila2020@gmail.com".equals(user.getCorreo())){
                HttpSession session = request.getSession(true);
                session.setAttribute("idUsuario","900127905");
                session.setAttribute("identificacion", "Administrador");
                session.setAttribute("correo","Administrador");
                session.setAttribute("telefono","Administrador");
                session.setAttribute("nombre", "Administrador");
                response.sendRedirect(request.getContextPath() + "/Vista/AdministradorMenuPrincipal.jsp");
        }else{
               
                HttpSession session = request.getSession(true);
                session.setAttribute("idUsuario", user.getIdUsuario());
                session.setAttribute("identificacion", user.getIdentificacion());
                session.setAttribute("correo", user.getCorreo());
                session.setAttribute("telefono", user.getTelefono());
                session.setAttribute("nombre", user.getNombre());
                response.sendRedirect(request.getContextPath() + "/Vista/MenuPrincipal.jsp");  
                       
                
               }
        }else
        {
            response.sendRedirect(request.getContextPath() + "/Vista/IniciarSesion.jsp?valor=x");
        }
        }
                      else
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
        EncriptarYDesencriptar unEnctiptarYDesencriptar = new EncriptarYDesencriptar();
        Usuario unUsuarioo = new Usuario();
        unUsuarioo.genearPassword();
        String password =unUsuarioo.getContrasena();
        String contrasenaEncriptada = unEnctiptarYDesencriptar.Encriptar( password);
        Usuario unUsuario = new Usuario(identificacion, nombre, telefono, correo, contrasenaEncriptada);
        boolean agregado = dUsuario.agregado(unUsuario);
        if (agregado){
            nuevoUsuario(unUsuario,password);
        }
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    
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
    String password=user.getContrasena();
    String encrtiptar=user.getContrasena();
    EncriptarYDesencriptar unEnctiptarYDesencriptar = new EncriptarYDesencriptar();
    String contrasenaEncriptada = unEnctiptarYDesencriptar.Encriptar(encrtiptar);
    user.setContrasena(contrasenaEncriptada);
    boolean actualizado = dUsuario.actualizarPassword(user);
    if (actualizado){
        enviarNuevoPasswordCorreoElectronico(user,password);
    }
    PrintWriter out = response.getWriter();
    String json = new Gson().toJson(actualizado);
    out.print(json);
    }
    
          private void enviarNuevoPasswordCorreoElectronico(Usuario unUsuario,String password){
          Usuario unUsuarioo = dUsuario.nombre( unUsuario.getCorreo());
         String correo = "propiscinasdelhuila2020@gmail.com";
         String Contraseña = unUsuario.getContrasena();
         String asunto = "Recuperación de contraseña de un usuario - Propiscinas del Huila  S.A.S ";
         String mensaje =
                 "<br><b>la  contraseña de acceso a Propiscinas del Huila  S.A.S ha sido</b>" 
                + "<br>restablecida correctamente.</b>" 
                + "<br><b>       </b>" 
                + "<br><b>Los datos de acceso del usuario(a) " +unUsuarioo.getNombre() +"   son: </b>"
                + "<br><b>       </b>" 
                + "<br><b>Correo: </b>" + unUsuarioo.getCorreo()
                + "<br><b>Contraseña: </b>" + password
                + "<br><b>Una vez ingrese el usuario con la  contraseña, se sugiere realizar el cambio por      </b>"  
                + "<br><b>una contraseña de facil recordación .    </b>" 
                + "<br><b>       </b>" 
                + "<br>_________________________________________________________________________________________</b>"
                 + "<br><b>       </b>" 
                 + "<br><b>Propiscinas del Huila  S.A.S</b>" 
               +"<br><br><img src = 'https://fotos.subefotos.com/08f2b1e3c11d27e201e2a570ea2c2e29o.png' with='300px' height='220px'/>";
            
         Correo.enviarCorreo(correo, asunto, mensaje);
     }  
             private void nuevoUsuario(Usuario unUsuario,String password){
         
         String correo = "propiscinasdelhuila2020@gmail.com";
         String Contraseña = unUsuario.getContrasena();
         String asunto = "Usuario registrado - Propiscinas del Huila  S.A.S ";
         String mensaje =
                "<br><b>Usuario de acceso a Propiscinas del Huila  S.A.S ha sido creado</b>" 
                + "<br>los datos del usuario son.</b>" 
                + "<br><b>       </b>" 
                + "<br><b>Datos personales: </b>"
                + "<br><b>       </b>" 
                  + "<br><b>Nombre: </b>" + unUsuario.getNombre()
                  + "<br><b>Telefono: </b>" + unUsuario.getTelefono()
                 
                  + "<br><b>       </b>" 
                  + "<br><b>Datos de acceso: </b>"
                + "<br><b>Correo: </b>" + unUsuario.getCorreo()
                + "<br><b>Contraseña: </b>" + password
                + "<br><b>       </b>" 
                + "<br><b>Una vez ingrese el usuario con la  contraseña, se sugiere realizar el cambio por      </b>"  
                + "<br><b>una contraseña de facil recordación .    </b>" 
                + "<br><b>       </b>" 
                + "<br>_________________________________________________________________________________________</b>"
                 + "<br><b>       </b>" 
                 + "<br><b>Propiscinas del Huila  S.A.S</b>" 
               +"<br><br><img src = 'https://fotos.subefotos.com/08f2b1e3c11d27e201e2a570ea2c2e29o.png' with='300px' height='220px'/>";
            
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
    
            private void ActualizarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int identificacion = Integer.parseInt(request.getParameter("identificacion"));
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String correoDeBusqueda = request.getParameter("correoDeBusqueda");
        boolean agregado = dUsuario.EditarUsuario(identificacion, nombre, telefono, correo,correoDeBusqueda);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
            
                     private void EditarContrasena(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String correoDeBusqueda = request.getParameter("correoDeBusqueda");
        String contrasenaAntigua = request.getParameter("contrasenaAntigua");
        String contrasenaNueva= request.getParameter("contrasenaNueva");
        String secretKey = "0P1R2O3P4I5S6C7I8N9A0S";
          EncriptarYDesencriptar unEncriptarYDesencriptar = new EncriptarYDesencriptar();

        String contrasenaEncriptada = unEncriptarYDesencriptar.Encriptar(contrasenaAntigua);
    String contrasena = dUsuario.buscarContrasena(correoDeBusqueda);
  
    if(contrasena.equals(contrasenaEncriptada)){
        String contrasenaNuevaa = unEncriptarYDesencriptar.Encriptar(contrasenaNueva);
        boolean agregado = dUsuario.EditarContrasena(correoDeBusqueda,contrasenaEncriptada,contrasenaNuevaa);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }else{
         boolean agregado = false;
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(agregado);
        out.print(json);
    }
    }
                        private void ListarUsuario(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
       
        ArrayList<Usuario> lista = dUsuario.ListarUsuarios();
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(lista);
        out.print(json);
    }
                        
  private void obtenerUsuario(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       
       int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        Usuario unUsuario = dUsuario.obtenerUsuario(idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(unUsuario);
        out.print(json);
    }
  
          private void EditarUsuario(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
       int identificacion =  Integer.parseInt(request.getParameter("identificacion"));
       String nombre = request.getParameter("txt_Nombre");
       String telefono = request.getParameter("txt_Telefono");
       String correo = request.getParameter("txt_Correo");
       int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        boolean editado= dUsuario.EditarUsuarioDesdeAdministrador(identificacion,nombre,telefono,correo,idUsuario);
        PrintWriter out = response.getWriter();
        String json = new Gson().toJson(editado);
        out.print(json);
    }
}
