package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class IniciarSesion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    
if (session.getAttribute("idUsuario")!=null){
   response.sendRedirect("MenuPrincipal.jsp");
}else{
   session.invalidate();
}


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Iniciar Sesión</title>\n");
      out.write("    <!-- meta tags -->\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <meta name=\"keywords\" content=\"Art Sign Up Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, \n");
      out.write("\t\tFlat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design\"\n");
      out.write("    />\n");
      out.write("    <!-- /meta tags -->\n");
      out.write("    <!-- custom style sheet -->\n");
      out.write("    <link href=\"web/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <!-- /custom style sheet -->\n");
      out.write("    <!-- fontawesome css -->\n");
      out.write("\n");
      out.write("    <link href=\"web/css/fontawesome-all.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    \n");
      out.write("    <!-- /fontawesome css -->\n");
      out.write("    <!-- google fonts-->\n");
      out.write("    <link href=\"//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\"\n");
      out.write("        rel=\"stylesheet\">\n");
      out.write("    <!-- /google fonts-->\n");
      out.write("     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <script src=\"Js/IniciarSesion.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Js/RecuperarContraseña.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <h1>Pro-Piscinas del Huila S.A.S</h1>\n");
      out.write("    <div class=\" w3l-login-form\">\n");
      out.write("        <h2 style=\"color:#007bff !important;\">Inicia Sesión</h2>\n");
      out.write("       <form name=\"frmIniciarSesion\" id=\"frmIniciarSesion\" method=\"POST\" action=\"../ControllerUsuario\">\n");
      out.write("  <input type=\"hidden\" name=\"accion\" id=\"accion\" value=\"IniciarSesion\">\n");
      out.write("            <div class=\" w3l-form-group\">\n");
      out.write("                <label>Usuario:</label>\n");
      out.write("                <div class=\"group\">\n");
      out.write("                    <i class=\"fas fa-user\"></i>\n");
      out.write("                    <input type=\"text\"  id=\"txtLogin\" name=\"txtLogin\"  autocomplete=\"off\" placeholder=\"Usuario\" required=\"required\" />\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\" w3l-form-group\">\n");
      out.write("                <label>Contraseña:</label>\n");
      out.write("                <div class=\"group\">\n");
      out.write("                    <i class=\"fas fa-unlock\"></i>\n");
      out.write("                    <input id=\"txtPassword\" name=\"txtPassword\" autocomplete=\"off\" type=\"password\"  placeholder=\"Contraseña\" required=\"required\" />\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("              <div style=\"text-align: center;\" class=\"mensaje1\">\n");
      out.write("        ");

            try {
                      
                    String valor=request.getParameter("valor");
                    
                   if(valor!=null){
                        out.print("Usuario o contraseña incorrecto");
                   }
            
                } catch (Exception e) {
                    
                }
        
      out.write("\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("            <div class=\"forgot\">\n");
      out.write("                <a href=\"#\" id=\"btnRecuperar\">¿Se te olvidó tu contraseña?</a>\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("        <button type=\"submit\" name=\"btnIniciarSesion\" id=\"btnIniciarSesion\" >Iniciar sesión</button>\n");
      out.write("        </form>\n");
      out.write("        <p class=\"w3l-register-p\">¿No tienes una cuenta?<a href=\"#\" id=\"btnAbrirRegistrar\" class=\"register\">  Registrarse</a></p>\n");
      out.write("    </div>\n");
      out.write("    <footer>\n");
      out.write("        <p class=\"copyright-agileinfo\"> &copy; 2020 Pro-Piscinas del Huila S.A.S | Hecho por   <a style=\"color: #12325e;\">Eddy Santiago Obregon</a></p>\n");
      out.write("    </footer>\n");
      out.write("<div class=\"modal\" id=\"modal\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div style=\"color: white; background-color: #007bff; \"class=\"modal-header  text-white\">\n");
      out.write("                        <h4 class=\"modal-title\" >Registrarse</h4>\n");
      out.write("                        <button type=\"button\"  style=\"height: 32px;width: 82px;\" onclick=\"limpiarModal()\" class=\"text-white close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                      \n");
      out.write("                            <thead>\n");
      out.write("                                \n");
      out.write("                            </thead>\n");
      out.write("                            <form>\n");
      out.write("                                            <tr style=\"height: 40px;\">\n");
      out.write("                        <td class=\"negrita\"><font color=\"black\">Nit de la empresa</font></td>\n");
      out.write("                         <td><input  style=\"outline: auto; outline-color: dodgerblue;\" required type=\"number\" name=\"txt_Nit\"  id=\"txt_Nit\" class=\"form-control\"  required>\n");
      out.write("                         <div class=\"requerimientos\"  id=\"msjNit\" style=\"text-align: center\"></div>\n");
      out.write("                      </td>\n");
      out.write("                    </tr>\n");
      out.write("                        <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Identificacion:</font></td>\n");
      out.write("                        <td><input style=\"outline: auto;outline-color: dodgerblue;\" required class=\"form-control\"type=\"number\" id=\"txt_Identificacion\">\n");
      out.write("                          <div class=\"requerimientos\"  id=\"msjIdentificacion\" style=\"text-align: center\"></div>         \n");
      out.write("                        </td>\n");
      out.write("                    </t  <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Nombre:</font></td>\n");
      out.write("                        <td><input  style=\"outline: auto;outline-color: dodgerblue;\" required type=\"text\"  id=\"txt_Nombre\"class=\"form-control\">\n");
      out.write("                           <div class=\"requerimientos\"  id=\"msjNombre\" style=\"text-align: center\"></div>      \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                        <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Telefono</font></td>\n");
      out.write("                        <td><input  style=\"outline: auto;outline-color: dodgerblue;\" required type=\"number\"   id=\"txt_Tel\"class=\"form-control\">\n");
      out.write("                            <div class=\"requerimientos\"  id=\"msjTelefono\" style=\"text-align: center\"></div>     \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                       <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Correo</font></td>\n");
      out.write("                       <td><input   style=\"outline: auto;outline-color: dodgerblue;\" required type=\"email\" id=\"txt_Correo\" class=\"form-control\">\n");
      out.write("                           <div class=\"requerimientos\"  id=\"msjCorreo\" style=\"text-align: center\"></div>    \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                        <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Contraseña</font></td>\n");
      out.write("                       <td><input  style=\"outline: auto;outline-color: dodgerblue;\"  required type=\"password\" id=\"txt_Contrasena\" class=\"form-control\" >\n");
      out.write("                            <div class=\"requerimientos\"  id=\"msjContrasena\" style=\"text-align: center\"></div>   \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                       <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Repita la contraseña</font></td>\n");
      out.write("                       <td><input  style=\"outline: auto;outline-color: dodgerblue;\" type=\"password\"  id=\"txt_RepetirContrasena\" class=\"form-control\" >\n");
      out.write("                           <div class=\"requerimientos\"  id=\"msjRepetirContrasena\" style=\"text-align: center\"></div>    \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                      </form>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" type=\"button\" class=\"btn\" id=\"btnRegistrar\" class=\"btnRegistrar\" >Registrar</button>\n");
      out.write("                     \n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" onclick=\"limpiarModal()\" type=\"button\" class=\"btn\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("         \n");
      out.write("        </div>\n");
      out.write("          <div class=\"modal w-100\" id=\"modalRecuperClave\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div style=\"color: white; background-color: #007bff; \"class=\"modal-header  text-white\">\n");
      out.write("                        <h4  class=\"modal-title\" >Recuperar contraseña</h4>\n");
      out.write("                        <button type=\"button\"  style=\"height: 32px;width: 82px;\" onclick=\"limpiarModal()\" class=\"text-white close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                      \n");
      out.write("                            <thead>\n");
      out.write("                                \n");
      out.write("                            </thead>\n");
      out.write("                            <form>\n");
      out.write("                                         \n");
      out.write("                    \n");
      out.write("                        <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Identificacion:</font></td>\n");
      out.write("                        <td><input style=\"outline: auto;outline-color: dodgerblue;\" name=\"txtIdentificacion\" id=\"txtIdentificacion\" required class=\"form-control\"type=\"number\" id=\"txt_Identificacion\">\n");
      out.write("                          <div class=\"requerimientos\"  id=\"msjIdentificacion\" style=\"text-align: center\"></div>         \n");
      out.write("                        </td>\n");
      out.write("                    </t  <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Ingrese su correo electronico:</font></td>\n");
      out.write("                        <td><input  style=\"outline: auto;outline-color: dodgerblue;\" required type=\"text\"  itype=\"email\" name=\"txtCorreo\" id=\"txtCorreo\" class=\"form-control\">\n");
      out.write("                           <div class=\"requerimientos\"  id=\"msjNombre\" style=\"text-align: center\"></div>      \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("               \n");
      out.write("                      </form>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" type=\"button\" class=\"btn\"  id=\"btnRecuperarClaveModal\" class=\"btnRegistrar\" >Recuperar contraseña</button>\n");
      out.write("                     \n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" onclick=\"limpiarModalRecuperar()\" type=\"button\" class=\"btn\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                                              \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
