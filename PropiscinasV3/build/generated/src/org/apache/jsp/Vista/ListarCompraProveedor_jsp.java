package org.apache.jsp.Vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ListarCompraProveedor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <title>jQuery UI Autocomplete - Default functionality</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\n");
      out.write("  <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\n");
      out.write("  <script>\n");
      out.write("  $( function() {\n");
      out.write("    var availableTags = [\n");
      out.write("      \"ActionScript\",\n");
      out.write("      \"AppleScript\",\n");
      out.write("      \"Asp\",\n");
      out.write("      \"BASIC\",\n");
      out.write("      \"C\",\n");
      out.write("      \"C++\",\n");
      out.write("      \"Clojure\",\n");
      out.write("      \"COBOL\",\n");
      out.write("      \"ColdFusion\",\n");
      out.write("      \"Erlang\",\n");
      out.write("      \"Fortran\",\n");
      out.write("      \"Groovy\",\n");
      out.write("      \"Haskell\",\n");
      out.write("      \"Java\",\n");
      out.write("      \"JavaScript\",\n");
      out.write("      \"Lisp\",\n");
      out.write("      \"Perl\",\n");
      out.write("      \"PHP\",\n");
      out.write("      \"Python\",\n");
      out.write("      \"Ruby\",\n");
      out.write("      \"Scala\",\n");
      out.write("      \"Scheme\"\n");
      out.write("    ];\n");
      out.write("    $( \"#tags\" ).autocomplete({\n");
      out.write("      source: availableTags\n");
      out.write("    });\n");
      out.write("  } );\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write(" \n");
      out.write("<div class=\"ui-widget\">\n");
      out.write("  <label for=\"tags\">Tags: </label>\n");
      out.write("  <input id=\"tags\">\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("</body>\n");
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
