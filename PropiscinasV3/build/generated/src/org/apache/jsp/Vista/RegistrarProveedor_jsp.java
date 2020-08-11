package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarProveedor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>RegistrarProveedor</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap.bundle.min.js / bootstrap.bundle.js\"></script>\n");
      out.write("        <script src=\"Js/RegistrarProveedor.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"Css/AgregarProducto.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"Js/MenuPrincipal.js\" type=\"text/javascript\"></script>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <header>\n");
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
      out.write("                            <button id=\"btnSalir\" style=\"height: 40px;margin-left: 544px;\"type=\"button\" class=\"btn btn-primary\">\n");
      out.write("                                 Salir\n");
      out.write("                                 </button>\n");
      out.write("\t\t\t\t\n");
      out.write("                                 \n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("                <section class=\"main\" style=\"background-color: white;\">\n");
      out.write("\t\t\t<section class=\"full-box dashboard-contentPage\">\n");
      out.write("\t\t<!-- Content page -->\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"page-header\">\n");
      out.write("\t\t\t  <h1 style=\"margin-left: 330px;color:#007bff ;     font-size: 170%;\" class=\"text-titles\"><i style=\"margin-left: 92px;    \" class=\"zmdi zmdi-book zmdi-hc-fw\"></i>  <small >REGISTRAR NUEVO PROVEEDOR</small></h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Panel nuevo cliente-->\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"panel panel-info\">\n");
      out.write("                            <a style=\"    font-size: 1.5rem;\n");
      out.write("    color: #007bff !important;\n");
      out.write("    margin-left: 15px;\">Información basica</a>\n");
      out.write("\t\t\t\t<div class=\"panel-body\">\n");
      out.write("                   <form id=\"frmCliente\"   >\n");
      out.write("                                         \n");
      out.write("                                       \n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t\t    \t<div class=\"form-group label-floating\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<label class=\"control-label\">Nro. Identificación o nit*</label>\n");
      out.write("                              <input id=\"txt_Nit\" name=\"NrIdentificacion\" pattern=\"[a-zA-Z0-9-]{1,15}\" class=\"form-control\" type=\"text\" name=\"codigo-reg\" required=\"\" maxlength=\"15\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t    \t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t\t    \t<div class=\"form-group label-floating\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<label class=\"control-label\">Nombre  </label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<input id=\"txt_Nombre\" onkeyup=\"javascript:this.value=this.value.toUpperCase();\" name=\"txt_Nombre\"  pattern=\"[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,45}\" class=\"form-control\" type=\"text\" name=\"titulo-reg\" required=\"\" maxlength=\"45\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t    \t\t\t\t</div>\n");
      out.write("\t\t\t\t    \t\t\t\n");
      out.write("\t\t\t\t    \t\t\t\t\n");
      out.write("\t\t\t\t    \t\t\t\t\n");
      out.write("\t\t\t\t    \t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("                  </form>                             \n");
      out.write("\t\t\t\t\t\t\t<legend style=\"color: #007bff !important;\"><i class=\"zmdi zmdi-smartphone-android\"></i> &nbsp; Telefonos</legend>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-xs-12 col-sm-6\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group label-floating\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t<label class=\"control-label\" >Nro. Telefonico</label>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    \t<input id=\"txt_Telefono\"  name=\"txt_Nombre\"  pattern=\"[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]{1,45}\" class=\"form-control\" type=\"text\" name=\"titulo-reg\" required=\"\" maxlength=\"45\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t    \t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t    \t\t\t\n");
      out.write("                                                                    <br>\n");
      out.write("                                                                    \n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("                                                          \n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("                                         <div class=\"col-xs-12 col-sm-8\">           \n");
      out.write("                                        \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                                 \n");
      out.write("                              \n");
      out.write("\n");
      out.write("                                         </div>\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("                                                \n");
      out.write("\t\t\t\t\t\t<p class=\"text-center\" style=\"margin-top: 20px;\">\n");
      out.write("                         <button type=\"button\" class=\"btn btn-primary\" id=\"btnAgregarProveedor\"><i class=\"zmdi zmdi-floppy\"></i>Registrar proveedor</button>\n");
      out.write("\t\t\t\t\t    </p>\n");
      out.write("\t\t\t\t\t    <br>\n");
      out.write("\t\t\t\t\t <p class=\"text-center\" style=\"margin-top: 20px;\">\n");
      out.write("\t\t\t\t\t\t<div id=\"mensaje\">\n");
      out.write("                        \n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t  </p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("            \n");
      out.write("\t\t\n");
      out.write("\t</section>\n");
      out.write("     \n");
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
