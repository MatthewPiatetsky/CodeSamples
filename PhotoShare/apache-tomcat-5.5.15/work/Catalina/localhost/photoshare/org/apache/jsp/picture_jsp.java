package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.NewCommentDao;
import photoshare.NewUserDao;
import photoshare.Picture;
import photoshare.PictureDao;
import java.util.List;

public final class picture_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/lightbox.css\" type=\"text/css\"\n");
      out.write("media=\"screen\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("     <script src=\"js/jquery-1.7.2.min.js\"\n");
      out.write("     type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("     <script src=\"js/lightbox.js\" type=\"text/javascript\"></script>\n");
      out.write("<article style=\"color:#fff;\" id=\"email\" class=\"panel\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<title>Picture </title></head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div id=\"fb-root\"></div>\n");
      out.write("<script>(function(d, s, id) {\n");
      out.write("  var js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("  if (d.getElementById(id)) return;\n");
      out.write("  js = d.createElement(s); js.id = id;\n");
      out.write("  js.src =\"//connect.facebook.net/en_US/all.js#xfbml=1&appId=135337009851354\";\n");
      out.write("  fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("}(document, 'script', 'facebook-jssdk'));</script>\n");
      out.write("\n");

int picture_id = Integer.valueOf(request.getParameter("picture_id"));

      out.write('\n');
      out.write('\n');
      out.write('\n');
PictureDao pictureDao = new PictureDao(); 
Picture picture1 = pictureDao.load(picture_id);
String requestemail = request.getUserPrincipal().getName();
String pcaption=picture1.getCaption();
NewCommentDao newCommentDao = new NewCommentDao();
String owner = newCommentDao.getOwner(picture_id);
 
      out.write("\n");
      out.write("<h1 style=\"color:green; font-weight: bold; text-decoration: underline;\">");
      out.print(
pcaption );
      out.write("</h1>\n");
      out.write("<a href=\"/photoshare/img?picture_id=");
      out.print( picture_id );
      out.write("\" rel=\"lightbox\">\n");
      out.write("            <img style=\"max-width:85%; height: auto;\"\n");
      out.write("\t    src=\"/photoshare/img?picture_id=");
      out.print( picture_id );
      out.write("\"/> </a>\n");
      out.write("\t    <br>\n");
      out.write("\n");
      out.write("<p> Hello <b><code>");
      out.print( requestemail  );
      out.write("</code></b> <br>\n");
      out.write("This picture has the id ");
      out.print( picture_id );
      out.write(" <br>\n");
      out.write("You can delete this picture, add a tag or comment or share the picture on\n");
      out.write("social media. <br> </p>\n");
      out.write("<a href=\"/photoshare/index.jsp\">Back to more photos!</a>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<h2>Albums</h2>\n");
      out.write("\n");
      out.write("<form action=\"addtoalbum.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" placeholder=\"Album Name\" name=\"album_name\" style=\"color:#000;\">\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=");
      out.print( picture_id );
      out.write(" >\n");
      out.write("    <input type=\"submit\" value=\"Add To Album!\" style=\"color:#000;\" ><br>\n");
      out.write("</form>\n");
      out.write("\n");
if((request.getUserPrincipal().getName()).equals(owner)){
      out.write("\n");
      out.write("<h2> Delete This Picture </h2>\n");
      out.write("<form action=\"delete.jsp\" method=\"post\">\n");
      out.write("<input type=\"hidden\"\n");
      out.write("    name=\"pid\" value=");
      out.print( picture_id );
      out.write(" >\n");
      out.write("    <input type=\"submit\" style=\"color:#000;\" value=\"Delete\"/>\n");
      out.write("</form>\n");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2>Tags</h2>\n");
      out.write("<form action=\"tags.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"tag_text\" style=\"color:#000;\">\n");
      out.write("    <input type=\"hidden\" name=\"email\"\n");
      out.write("    value=\"request.getUserPrincipal().getName()\"\\>\n");
      out.write("<input type=\"hidden\" name=\"picture_id\" value=\"");
      out.print( picture_id );
      out.write("\">\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Add Tag\" style=\"color:#000;\"><br/>\n");
      out.write("</form>\n");
 String tagmagic = "youshallnotpass"; 
      out.write("\n");
      out.write("<form action=\"tags.jsp\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"tag_text\" value=\"");
      out.print(tagmagic);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" name=\"email\"\n");
      out.write("    value=\"request.getUserPrincipal().getName()\"\\>\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=\"");
      out.print( picture_id );
      out.write("\">\n");
      out.write("    <input type=\"submit\" value=\"View Tags\" style=\"color:#000;\"><br/>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2>Comments</h2>\n");
if(!(request.getUserPrincipal().getName()).equals(owner)){
      out.write("\n");
      out.write("\n");
      out.write("<form action=\"comments.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"comment_text\" style=\"color:#000;\">\n");
      out.write("    <input type=\"hidden\" name=\"email\" value=\"request.getUserPrincipal().getName()\">\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=\"");
      out.print( picture_id );
      out.write("\">\n");
      out.write("    <input type=\"submit\" value=\"Add Comment\" style=\"color:#000;\"><br/>\n");
      out.write("</form>\n");
}
      out.write('\n');
 String commentmagic = "YOU SHALL NOT PASS"; 
      out.write("\n");
      out.write("<form action=\"comments.jsp\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"comment_text\" value=\"");
      out.print(commentmagic);
      out.write("\">\n");
      out.write("    <input type=\"hidden\" name=\"email\" value=\"request.getUserPrincipal().getName()\">\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=\"");
      out.print( picture_id );
      out.write("\">\n");
      out.write("    <input type=\"submit\" value=\"View Comments\" style=\"color:#000;\"><br/>\n");
      out.write("</form>\n");
NewCommentDao newCommentDao3 = new NewCommentDao();
boolean hasLiked = newCommentDao3.hasLiked(request.getUserPrincipal().getName());
      out.write("\n");
      out.write("<h2>Likes</h2>\n");
if(!hasLiked){
      out.write("\n");
      out.write("<table><tr><td>\n");
      out.write("<form action=\"likes.jsp\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"email\" value=\"");
      out.print(requestemail);
      out.write("\" style=\"color:#000;\">\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=");
      out.print( picture_id );
      out.write(" >\n");
      out.write("    <input type=\"submit\" value=\"Like!\" style=\"color:#000;\" >\n");
      out.write("</form>\n");
      out.write("</td>\n");
}
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"likes.jsp\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"email\" value=\"YOU SHALL NOT PASS\" style=\"color:#000;\">\n");
      out.write("    <input type=\"hidden\" name=\"picture_id\" value=");
      out.print( picture_id );
      out.write(" >\n");
      out.write("    <input type=\"submit\" value=\"View Likes\" style=\"color:#000;\" ><br>\n");
      out.write("</form>\n");
      out.write("</td></td></table>\n");
      out.write("<h2>Share this photo!</h2>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<a href=\"https://twitter.com/share\" class=\"twitter-share-button\"\n");
      out.write("data-text=\"Check out this photo!\">Tweet</a>\n");
      out.write("<script>!function(d,s,id){var\n");
      out.write("js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=\"//platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>\n");
      out.write("<script type=\"text/javascript\" src=\"http://www.reddit.com/static/button/button1.js\"></script>\n");
      out.write("<fb:like layout=\"standard\" width=\"450\" action=\"like\" colorscheme=\"light\" />\n");
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
