package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<title>Photoshare Login</title></head>\n");
      out.write("\n");
      out.write("<body style = \"background-image: url(css/images/bg3.jpg);\">\n");
      out.write("<h1> <span style=\"font-weight:bold; font-size:35px;\n");
      out.write("background-image:-webkit-gradient( linear, left top, right top,\n");
      out.write("color-stop(0, #f22), color-stop(0.15, #f2f), color-stop(0.3, #22f),\n");
      out.write("color-stop(0.45, #2ff), color-stop(0.6, #2f2),color-stop(0.75, #2f2),\n");
      out.write("color-stop(0.9, #ff2), color-stop(1, #f22) );\n");
      out.write("  color:transparent;\n");
      out.write("  -webkit-background-clip: text;\"> PHOTOSHARE! </span> </h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2 style=\"color: #fff;\">Please login</h2>\n");
      out.write("\n");
      out.write("<div style=\"color: #fff;\">\n");
      out.write("<form method=\"POST\" action=\"j_security_check\">\n");
      out.write("    <table>\n");
      out.write("        <tr><th  style=\"color: #fff;\">Email</th><td><input type=\"text\" name=\"j_username\"></td></tr>\n");
      out.write("        <tr><th style=\"color: #fff;\">Password</th><td><input type=\"password\" name=\"j_password\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr><td colspan=\"2\" align=\"right\"><input type=\"submit\" value=\"Login\"/>\n");
      out.write("        </td></tr>\n");
      out.write("    </table>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<form action=\"newuser.jsp\" method=\"post\">\n");
      out.write("    <table>\n");
      out.write("        <tr><td colspan=\"2\" align=\"right\"><input type=\"submit\"\n");
      out.write("    value=\"Register\"/></td></tr>\n");
      out.write("    </table>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<div style=\"color: #fff;\">\n");
      out.write("<form method=\"POST\" action=\"j_security_check\">\n");
      out.write("    <table>\n");
      out.write("        <input type=\"hidden\" name=\"j_username\" value=\"Anonymous\"></td></tr>\n");
      out.write("        <input type=\"hidden\" name=\"j_password\" value=\"password\"></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr><td colspan=\"2\" align=\"right\"><input type=\"submit\"\n");
      out.write("        value=\"Browse Anonymously\"/>\n");
      out.write("        </td></tr>\n");
      out.write("    </table>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<img src=\"css/images/PhotoSharing.jpg\">\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
