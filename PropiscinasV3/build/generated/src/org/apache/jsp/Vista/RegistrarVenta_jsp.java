package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarVenta_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  
 if (session.getAttribute("idUsuario")==null){
   response.sendRedirect("IniciarSesion.jsp");
 }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registrar venta</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <link href=\"Css/AgregarVenta.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"Js/RegistrarVenta.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("   \n");
      out.write("    function showContent() {\n");
      out.write("        element = document.getElementById(\"content\");\n");
      out.write("        \n");
      out.write("        if (check.checked) {\n");
      out.write("            element.style.display='block';\n");
      out.write("        }\n");
      out.write("        else {\n");
      out.write("            element.style.display='none';\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("    <body>\n");
      out.write("      <header>\n");
      out.write("<div class=\"logotipo\">\n");
      out.write("             \n");
      out.write("                    <a style=\"background-color: #007bff; position: fixed; font-family: sans-serif; border-radius: 10px;    left: 660px; color: white;  border-bottom: 40px;  padding-bottom: 10px;   padding-top: 10px;  padding-right: 10px; padding-left: 10px;\" id=\"sNombre\"></a>\n");
      out.write("                      \n");
      out.write("            \n");
      out.write("                      <img src=\"Imagenes/Pro-piscinas.png\" width=\"1200\" height=\"250\"alt=\"\">\n");
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
      out.write("                                    <a class=\"dropdown-item\" href=\"AgregarProducto.jsp\">Agregar producto</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"ListarProducto.jsp\">Listar productos</a>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"ConvertirProducto.jsp\">Convertir producto</a>\n");
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
      out.write("                                    \n");
      out.write("                                        <a class=\"dropdown-item\" href=\"ListarInventario.jsp\">Listar inventario datos historicos</a>\n");
      out.write("                                         <a class=\"dropdown-item\" href=\"ListarInventarioCantidadActulizada.jsp\">Listar inventario cantidad actualizada</a>\n");
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
      out.write("                            <button id=\"btnSalir\" style=\"height: 40px;margin-left: 544px;\"type=\"button\" class=\"btn btn-primary\">\n");
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
      out.write("                            <center>\n");
      out.write("                                <div id=\"formulario\">\n");
      out.write("                                    \n");
      out.write("                               \n");
      out.write("                                                   <form id=\"frmAgregar\" >\n");
      out.write("   \n");
      out.write("        <div style=\"width: 80%; border: 0 !important; color:  #472055; margin-left: 50px; align-content: center; display: table;\"  align=\"center\" >\n");
      out.write("           \n");
      out.write("            <thead >\n");
      out.write("                        \n");
      out.write("                            <tr>\n");
      out.write("                                <th  colspan=\"2\" style=\"text-align: center; margin-left: 10px\"> Registrar venta</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                     \n");
      out.write("                   \n");
      out.write("                        <input type=\"hidden\" name=\"accion\" id=\"accion\" value=\"Agregar\">\n");
      out.write("                        <script>\n");
      out.write("                            function validarNumero(e) {\n");
      out.write("    tecla = (document.all) ? e.keyCode : e.which;\n");
      out.write("    if (tecla===8) return true; \n");
      out.write("    patron =/[0-9]/;\n");
      out.write("    te = String.fromCharCode(tecla); \n");
      out.write("    return patron.test(te); \n");
      out.write(" }\n");
      out.write("                            </script>\n");
      out.write("                    \n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                        <td class=\"negrita\"><font color=\"black\">Ingrese codigo  </font><br><font color=\"black\">de barras:</font> </td>\n");
      out.write("                        <td><input style=\"border-left-width: 0px; \n");
      out.write("  \n");
      out.write("    height: 40px;\n");
      out.write("    ;\" onkeyup=\"buscarProducto()\"onkeypress=\"return validarNumero(event)\" maxlength=\"20\" type=\"text\" name=\"txt_Codigo\"  id=\"txt_Codigo\" class=\"form-control\"  required>\n");
      out.write("                         <div id=\"msjNombre\" style=\"text-align: center\"></div>                       \n");
      out.write("                      </td>\n");
      out.write("                    </tr>\n");
      out.write("               \n");
      out.write("                  \n");
      out.write("            </div>\n");
      out.write("                                                                                             \n");
      out.write("            <div style=\"width: 80%; border: 0 !important; color:  #472055; margin-left: 50px;  align-content: center; display: table;\"  align=\"center\" >\n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("                <thead>\n");
      out.write("                        \n");
      out.write("                            <tr>\n");
      out.write("                                <th  colspan=\"2\" style=\"text-align: center; margin-left: 10px\">Producto</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        \n");
      out.write("                 \n");
      out.write("\n");
      out.write("                    <tr class=\"contenedor-columna\"  style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Nombre </font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" readonly=\"readonly\"   type=\"text\" name=\"txt_Nombre\" id=\"txt_Nombre\" class=\"form-control\"  value=\"\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr  style=\" height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Forma </font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" readonly=\"readonly\"  type=\"text\" name=\"txt_forma\" id=\"txt_forma\" class=\"form-control\"  value=\"\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Unidad de medida </font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" readonly=\"readonly\"  type=\"text\" name=\"txt_UnidadMedida\" id=\"txt_UnidadMedida\" class=\"form-control\"  value=\"\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Grupo </font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" readonly=\"readonly\"  type=\"text\" name=\"txt_Grupo\" id=\"txt_Grupo\" class=\"form-control\"  value=\"\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                 \n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Presentación </font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" readonly=\"readonly\"  type=\"text\" name=\"txt_Presentacion\" id=\"txt_Presentacion\" class=\"form-control\"  value=\"\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Cantidad vendida</font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" type=\"text\" onkeypress=\"return validarNumero(event)\" name=\"txt_CantidadVendidaa\" id=\"txt_CantidadVendidaa\" class=\"form-control\"  value=\"\" required></textarea></td>\n");
      out.write("                    </tr>\n");
      out.write("                      <td class=\"negrita\"><font color=\"black\">Valor de venta</font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" type=\"text\" name=\"txt_Valor\" id=\"txt_Valor\" class=\"form-control\"  value=\"\" required></textarea></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Numero de factura</font></td>\n");
      out.write("                       <td><input style=\"height: 24.5px;\" type=\"text\" onkeypress=\"return validarNumero(event)\" name=\"txt_NumeroFactura\" id=\"txt_NumeroFactura\" class=\"form-control\"  value=\"\" required></textarea></td>\n");
      out.write("                    </tr>\n");
      out.write("                     <tr style=\"height: 40px;\">\n");
      out.write("                       <td class=\"negrita\"><font color=\"black\">Tipo de documento </font></td>\n");
      out.write("                        <td><select name=\"cb_TipoDocumento\" id=\"cb_TipoDocumento\" class=\"form-control\">\n");
      out.write("                                <option value=\"0\">Seleccione</option>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <tr  style=\"height: 10px;\">\n");
      out.write("                        <td colspan=\"2\"  style=\"text-align: center; margin-left: 10px\">\n");
      out.write("                            <input style=\"margin: 20px;\" id=\"btnAgregar\" type=\"button\" value=\"Agregar Venta\" name=\"btnAgregar\" class=\"btn btn-primary\">\n");
      out.write("                          \n");
      out.write("                        \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                            \n");
      out.write("                     \n");
      out.write("                    \n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("                               </div>                         \n");
      out.write("                        </center>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("                      <div id=\"mensaje\" style=\"text-align: center; color: black;\">\n");
      out.write("             ");

                    String mensaje = request.getParameter("mensaje");
                    if (mensaje!=null){
                        out.print(request.getParameter("mensaje"));
                    }
             
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("                            \n");
      out.write("                        </article>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<article>\n");
      out.write("\t\t\t \n");
      out.write("                            \n");
      out.write("\t\t\t<table   style=\"    width: 1200px;\n");
      out.write("    font-size: 20.6px;\n");
      out.write("display: none;\"  id=\"tblMovimiento\" class=\"table  table-striped\" align=\"center\">\n");
      out.write("    <thead>\n");
      out.write("        <tr class=\"bg-info text-white\" >\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Codigo</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Nombre</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Fecha venta</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Cantidad</th>         \n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">Tipo de documento</th>\n");
      out.write("            <th style=\"background-color: #007bff;color: #fff;\">N° de documento</th>\n");
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
      out.write("</table></article>\n");
      out.write("\t\t</section>\n");
      out.write("\t\t\n");
      out.write("\t</section>\n");
      out.write("\t<footer>\n");
      out.write("\t\t<p>Pro-piscinas 2020</p>\n");
      out.write("\t</footer>\n");
      out.write("    </body>\n");
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
