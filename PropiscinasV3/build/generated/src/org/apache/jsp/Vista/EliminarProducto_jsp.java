package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EliminarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Vista/Librerias.jsp");
  }

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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>EliminarProducto</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("           <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("         <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("         <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("         <script src=\"librerias/jquery/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("         <link href=\"librerias/jquery/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("         <script src=\"librerias/jquery/external/jquery/jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("         <script src=\"librerias/jquery/external/jquery/jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("         <script src=\"Librerias/jquery/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("         <link href=\"Librerias/jquery/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("                <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel='stylesheet' href='https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css'>\n");
      out.write("        <link rel='stylesheet' href='https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css'>\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css'>\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css'>\n");
      out.write("        <link rel='stylesheet' href='https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css'>\n");
      out.write("        <link rel='stylesheet' href='https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css'>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.bootstrap4.min.js'></script>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js'></script>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js'></script>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js'></script>\n");
      out.write("        <script src='https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js'></script>       \n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <script src=\"Js/EliminarProducto.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"Css/AgregarProducto.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <header>\n");
      out.write("\t\t<div class=\"logotipo\">\n");
      out.write("                    <img src=\"Imagenes/Pro-piscinas.png\" width=\"1200\" height=\"230\"alt=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<nav>\n");
      out.write("\t\t\t<ul>\n");
      out.write("                            <div class=\"btn-group navuldiv\">\n");
      out.write("                                <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Producto\n");
      out.write("                                 </button>\n");
      out.write("                                 <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"RegistrarProductoNuevo.jsp\">Registrar producto nuevo</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"AgregarProducto.jsp\">Agregar producto</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"ListarProducto.jsp\">Listar productos</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"EliminarProducto.jsp\">Eliminar producto</a>\n");
      out.write("                                 </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"btn-group navuldiv\">\n");
      out.write("                                 <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Factura\n");
      out.write("                                 </button>\n");
      out.write("                                    <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Registrar producto nuevo</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Listar productos</a>\n");
      out.write("                                    </div>\n");
      out.write("                            </div>\n");
      out.write("                                <div class=\"btn-group navuldiv\">\n");
      out.write("                                 <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Inventario\n");
      out.write("                                 </button>\n");
      out.write("                                    <div class=\"dropdown-menu\">\n");
      out.write("                                    \n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ListarInventario.jsp\">Listar inventario datos historicos</a>\n");
      out.write("                                         <a class=\"dropdown-item\" href=\"ListarInventarioCantidadActulizada.jsp\">Listar inventario cantidad actualizada</a>\n");
      out.write("                                    </div>\n");
      out.write("                            </div>\n");
      out.write("\t\t\t\t<li><a href=\"MenuPrincipal.jsp\">Pro-Piscinas</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\t<section class=\"main\">\n");
      out.write("\t\t<section class=\"articles\">\n");
      out.write("\t\t\t<article>\n");
      out.write("                            \n");
      out.write("                                <input style=\"display: inline-grid; width: 40%\" type=\"text\" id=\"txt_Buscar\" class=\"form-control txt_Buscar\">\n");
      out.write("                                <button style=\"margin-bottom: 5px;\" class=\"btn btn-primary btnBuscar\" id=\"btnBuscar\">🔎</button>\n");
      out.write("                                <button style=\"margin-bottom: 5px;\" class=\"btn btn-primary btnBuscar\" id=\"btnListar\">Listar</button>\n");
      out.write("                         \n");
      out.write("                            \n");
      out.write("\t\t\t<table style=\"width: 90% ;font-size: 12px;\"  id=\"tblProducto\" class=\"table table-bordered\" align=\"center\">\n");
      out.write("    <thead>\n");
      out.write("        <tr class=\"bg-info text-white\" >\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Codigo</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Referencia</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Nombre</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Abreviatura</th>     \n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Grupo</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">SubGrupo</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Presentacion</th>           \n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">UnidadMedida</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Detalle observación</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Detalle Estado</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Opción</th>\n");
      out.write("         \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("         \n");
      out.write("           \n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody id=\"Container\" class=\"Container\">\n");
      out.write("        \n");
      out.write("    </tbody>\n");
      out.write("</table>\n");
      out.write("                        </article>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<article>\n");
      out.write("\t\t\t\t<h2>Este es el titulo de mi sitio web</h2>\n");
      out.write("\t\t\t\t<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed, iure corporis quod ratione dolorum non aliquam reiciendis dolores perferendis doloremque. Architecto doloremque iusto consequatur assumenda saepe voluptate minus harum, eos!</p>\n");
      out.write("\t\t\t</article>\n");
      out.write("\t\t</section>\n");
      out.write("\t\t\n");
      out.write("\t</section>\n");
      out.write("        <div class=\"modal\" id=\"modal\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div style=\"color: white; background-color: #007bff; \"class=\"modal-header  text-white\">\n");
      out.write("                        <h4 class=\"modal-title\" >Cuantos codigos de barra imprimira?</h4>\n");
      out.write("                        <button type=\"button\" class=\"text-white close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <thead>\n");
      out.write("                                \n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                   <tr>\n");
      out.write("                        <td><input type=\"number\" name=\"txt_Can\" id=\"txt_Can\" class=\"form-control\"   required>\n");
      out.write("                        \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                               \n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" type=\"button\" class=\"btn\" id=\"btnImprimir\" class=\"btnImprimir\" >Imprimir</button>\n");
      out.write("                     \n");
      out.write("                        <button style=\"background-color: #007bff;color: #fff;\" type=\"button\" class=\"btn\" data-dismiss=\"modal\">Cerrar</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("         \n");
      out.write("        </div>\n");
      out.write("\t<footer>\n");
      out.write("\t\t<p>Pro-piscinas 2020</p>\n");
      out.write("\t</footer>\n");
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
