package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ImprimirEtiquetasCodigoBarras_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ImprimirCodigoBarras</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <link href=\"Css/AgregarProducto.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"Js/GenerarCodigosBarra.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Js/MenuPrincipal.js\" type=\"text/javascript\"></script>\n");
      out.write("         <script src=\"Js/jsAutocomplete.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("    <body>\n");
      out.write("       <header>\n");
      out.write("\n");
      out.write("             \n");
      out.write("                    \n");
      out.write("            \n");
      out.write("              \n");
      out.write("\t\t\n");
      out.write("\t</header>\n");
      out.write("                   <script>\n");
      out.write("                       $(function(){\n");
      out.write("                          $('#modal').modal({backdrop: 'static', keyboard: false});\n");
      out.write("                          $(\"#modal\").modal(); \n");
      out.write("                       });\n");
      out.write("                       </script>\n");
      out.write("                   \n");
      out.write("                       <div class=\"modal\" id=\"modal\" style=\"\">\n");
      out.write("           <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\" style=\"width: 702px;\n");
      out.write("    height: 697px;\n");
      out.write("    right: 98px;\n");
      out.write("    margin-top: 43px;\">\n");
      out.write("       <div style=\"color: white; background-color: #007bff; \"class=\"modal-header  text-white\">\n");
      out.write("                        <h4 class=\"modal-title\" >GENERAR CODIGOS DE BARRAS</h4>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("        <div style=\"margin-top: 0px;   padding-top: 0px;\" class=\"modal-body\">\n");
      out.write("        <form>\n");
      out.write("            <a style=\"margin-bottom: 30px;\n");
      out.write("    padding-top: 2px;\n");
      out.write("    padding-bottom: 4px;\n");
      out.write("    margin-left: 143px;\n");
      out.write("    margin-top: 44px;\" class=\"btn btn-primary btnListar\" id=\"btnGenerarTodos\"><img width=\"55\" height=\"30\" src=\"Imagenes/cod.png\"/>Generar todos los de codigos de barras</a>\n");
      out.write("          \n");
      out.write("    <a style=\"    background-color: white;\n");
      out.write("    color: #d2d2d2;\n");
      out.write("    margin-top: 1px;\n");
      out.write("    border-bottom-width: 30px;\n");
      out.write("    margin-bottom: 55px;\">_____________________________________________________________________________________________________</a>\n");
      out.write("          <div style=\"height: 60px;\" class=\"form-group\">\n");
      out.write("              <label for=\"message-text\" class=\"col-form-label\" style=\"margin-left: 190px;\n");
      out.write("    margin-top: 39px;\">Generar codigos de barra por grupo:</label>\n");
      out.write("          <select style=\"width: 360px;\n");
      out.write("    margin-left: 140px;     \n");
      out.write("  \n");
      out.write("    border-color: #d2d2d2;\" name=\"cb_Grupo\" id=\"cb_Grupo\" class=\"btn\">\n");
      out.write("                                <option value=\"0\">Seleccione</option>\n");
      out.write("\t\t\t\t\t</select> \n");
      out.write("          </div>\n");
      out.write("            <a id=\"btnGenerCodigoBarrasPorGrupo\" style=\"    margin-top: 49px;\n");
      out.write("    margin-left: 286px;\n");
      out.write("    color: white;\"class=\"btn btn-primary\">Generar</a>\n");
      out.write("      <a style=\"    background-color: white;\n");
      out.write("    color: #d2d2d2;\n");
      out.write("    margin-top: 1px;\n");
      out.write("    border-bottom-width: 30px;\n");
      out.write("    margin-bottom: 55px;\">_____________________________________________________________________________________________________</a>\n");
      out.write("    <br>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <a style=\"margin-left: 143px;\"><h6 style=\"margin-left: 194px;\">Codigo de barra independiente</h6></a>\n");
      out.write("    <a style=\"margin-left: 143px;\">Ingrese el código para generar el código de barras</a>\n");
      out.write("    <br>\n");
      out.write("    <input style=\"    width: 362px;\n");
      out.write("           margin-left: 140px; margin-bottom: 2px;\"type=\"number\" placeholder=\"INGRESE CODIGO\" id=\"txt_Codigo\" class=\"form-control\">\n");
      out.write("     <input style=\"    width: 362px;\n");
      out.write("           margin-left: 140px;\"type=\"number\" placeholder=\"CANTIDAD QUE IMPRIMIRA\" id=\"txt_Cantidad\" class=\"form-control\">\n");
      out.write("      <a id=\"btnGenerCodigoBarrasIndenpendiente\" style=\"    margin-top: 9px;\n");
      out.write("    margin-left: 286px;\n");
      out.write("    color: white;\"class=\"btn btn-primary\">Generar</a>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("       \n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("         \n");
      out.write("                     \n");
      out.write("                        <a style=\"background-color: #007bff;color: #fff;\" class=\"btn btn-primary\" href=\"ListarProducto.jsp\" type=\"button\" >Regresar</a>\n");
      out.write("                       \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\t\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
