package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DevolucionVenta_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

  


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Devolución venta</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <link href=\"Css/ListarMovimiento.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"Js/MenuPrincipal.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Js/DevolucionVenta.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <header>\n");
      out.write("<div class=\"logotipo\">\n");
      out.write("             \n");
      out.write("                    <a style=\"background-color: #007bff; position: fixed; font-family: sans-serif; border-radius: 10px;    left: 730px; color: white;  border-bottom: 40px;  padding-bottom: 10px;   padding-top: 10px;  padding-right: 10px; padding-left: 10px;\" id=\"sNombre\"></a>\n");
      out.write("                      \n");
      out.write("            \n");
      out.write("                      <img src=\"Imagenes/Pro-piscinas.png\" width=\"1300\" height=\"300\"alt=\"\">\n");
      out.write("\t\t\n");
      out.write("\t\t</div>\n");
      out.write("                    <input type=\"hidden\" name=\"Correo\" id=\"Correo\" value=\"");

                try {   
                    String correo= (String)session.getAttribute("correo");
                         out.print(correo);
                    } catch (Exception e) {
                    }
                   
      out.write("\">\n");
      out.write("\t\t<nav>\n");
      out.write("\t\t\t<ul>\n");
      out.write("                            <li><a href=\"MenuPrincipal.jsp\">Pro-Piscinas</a></li>\n");
      out.write("                            <div class=\"btn-group navuldiv\">\n");
      out.write("                                <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Producto\n");
      out.write("                                 </button>\n");
      out.write("                                 <div class=\"dropdown-menu\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"RegistrarProductoNuevo.jsp\">Registrar producto nuevo</a>\n");
      out.write("                                   \n");
      out.write("                                    <a class=\"dropdown-item\" href=\"ListarProducto.jsp\">Listar productos</a>\n");
      out.write("                                   \n");
      out.write("                                    <a class=\"dropdown-item\" href=\"EliminarProducto.jsp\">Eliminar producto</a>\n");
      out.write("                                 </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"btn-group navuldiv\">\n");
      out.write("                                 <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                 Venta\n");
      out.write("                                 </button>\n");
      out.write("                                    <div class=\"dropdown-menu\">\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"RegistrarVenta.jsp\">Registrar venta</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ListarVenta.jsp\">Listar venta</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ListarInventarioVenta.jsp\">Listar inventario venta</a>\n");
      out.write("                                        <a class=\"dropdown-item\" href=\"DevolucionVenta.jsp\">Devolución de venta</a>\n");
      out.write("                                    </div>\n");
      out.write("                            </div>\n");
      out.write("                               <div class=\"btn-group navuldiv\">\n");
      out.write("                                 <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Inventario\n");
      out.write("                                 </button>\n");
      out.write("                                    <div class=\"dropdown-menu\">\n");
      out.write("                                     <a class=\"dropdown-item\" href=\"AgregarProducto.jsp\">Registrar entrada del producto</a>\n");
      out.write("                                     <a class=\"dropdown-item\" href=\"CambioDeProductosEnInfraestructura.jsp\">Movimiento de productos</a>\n");
      out.write("                                     <a class=\"dropdown-item\" href=\"ConvertirProducto.jsp\">Convertir productos</a>\n");
      out.write("                                     <a class=\"dropdown-item\" href=\"ListarInventario.jsp\">Listar inventario datos historicos</a>\n");
      out.write("                                     <a class=\"dropdown-item\" href=\"ListarInventarioCantidadActulizada.jsp\">Listar inventario cantidad actualizada</a>\n");
      out.write("                                    </div>\n");
      out.write("                            </div>\n");
      out.write("                                                           <div class=\"btn-group navuldiv\">\n");
      out.write("                                 <button style=\"height: 40px;\"type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                  Movimiento\n");
      out.write("                                 </button>\n");
      out.write("                                    <div class=\"dropdown-menu\">\n");
      out.write("                                    \n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ListarMovimiento.jsp\">Listar movimiento</a>\n");
      out.write("            \n");
      out.write("                                    </div>\n");
      out.write("                            </div>\n");
      out.write("                            <button id=\"btnSalir\" style=\"height: 40px;margin-left: 851px;\"type=\"button\" class=\"btn btn-primary\">\n");
      out.write("                                 Salir\n");
      out.write("                                 </button>\n");
      out.write("\t\t\t\t\n");
      out.write("                                 \n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\t<section class=\"main\">\n");
      out.write("\t\t<section class=\"articles\">\n");
      out.write("\t\t\t<article>\n");
      out.write("                             <input class=\"btn btn-primary\" id=\"fecha\" type=\"date\">\n");
      out.write("                              <input autocomplete=\"off\" style=\"display: inline-grid; width: 572px; padding-top: 1px;\" placeholder=\"BUSQUEDA POR NUMERO DE DOCUMENTO O CODIGO DE PRODUCTO\" type=\"text\" id=\"txt_Buscar\" class=\"form-control txt_Buscar\">\n");
      out.write("                                \n");
      out.write("                         <select class=\"btn btn-primary\" style=\"display: inline-grid; width: 320px;\" name=\"cb_TipoDocumento\" id=\"cb_TipoDocumento\" class=\"form-control\">\n");
      out.write("                                <option value=\"0\">TODOS LOS TIPOS DE DOCUMENTOS</option>\n");
      out.write("                        </select>\n");
      out.write("                         <button style=\"\" class=\"btn btn-primary btnBuscar\" id=\"btnBuscar\" >🔎</button>\n");
      out.write("                                <button style=\"\" class=\"btn btn-primary btnBuscar\" id=\"btnListar\"><img width=\"18\" height=\"18\" src=\"Imagenes/actualizar.png\"/>\n");
      out.write("                                </button>\n");
      out.write("\t\t\t<table  style=\"width: 95% ;font-size: 12.6px;\"  id=\"tblMovimiento\" class=\"table  table-striped\" align=\"center\">\n");
      out.write("    <thead>\n");
      out.write("        <tr class=\"bg-info text-white\" >\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Codigo</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Nombre</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Fecha venta</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Cantidad</th>         \n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Tipo de documento</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">N° de documento</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Estado</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Opciones</th>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("           \n");
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
      out.write("            \n");
      out.write("\t\t\n");
      out.write("\t</section>\n");
      out.write("        \n");
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
