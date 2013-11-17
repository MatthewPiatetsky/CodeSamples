package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.NewUserDao;
import photoshare.PictureDao;
import photoshare.Picture;
import java.util.List;
import java.util.ArrayList;

public final class topusers_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      photoshare.NewUserBean NewTagBean = null;
      synchronized (_jspx_page_context) {
        NewTagBean = (photoshare.NewUserBean) _jspx_page_context.getAttribute("NewTagBean", PageContext.PAGE_SCOPE);
        if (NewTagBean == null){
          NewTagBean = new photoshare.NewUserBean();
          _jspx_page_context.setAttribute("NewTagBean", NewTagBean, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("NewUserBean"), request);
          out.write('\n');
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("\n");
      out.write("<title>Users </title></head>\n");
      out.write("\n");
      out.write("<body style=\"color:#7FFF00;\">\n");
      out.write("\n");
      out.write("<a href=\"/photoshare/index.jsp\">Take me back to the main page!</a>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<h1 style=\"text-decoration:underline;\">Users</h1>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        ");

	    NewUserDao newuserDao1 = new NewUserDao();
            List<String> users = newuserDao1.allUserScores();
	    if(users.size()>9){
		users = new ArrayList<String>(users.subList(0,9));
      	    }
	    for (String user : users) {
	
      out.write("\n");
      out.write("\t\n");
      out.write("        <div style=\"color:##7FFF00;\"> ");
      out.print(user);
      out.write(" </div>     \n");
      out.write("        ");

           }
        
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
