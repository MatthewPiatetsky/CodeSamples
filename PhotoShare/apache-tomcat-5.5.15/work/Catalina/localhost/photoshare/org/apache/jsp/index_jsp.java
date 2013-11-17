package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import photoshare.Picture;
import photoshare.PictureDao;
import photoshare.NewCommentDao;
import photoshare.NewUserDao;
import org.apache.commons.fileupload.FileUploadException;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      photoshare.ImageUploadBean imageUploadBean = null;
      synchronized (_jspx_page_context) {
        imageUploadBean = (photoshare.ImageUploadBean) _jspx_page_context.getAttribute("imageUploadBean", PageContext.PAGE_SCOPE);
        if (imageUploadBean == null){
          imageUploadBean = new photoshare.ImageUploadBean();
          _jspx_page_context.setAttribute("imageUploadBean", imageUploadBean, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("    ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("imageUploadBean"), request);
          out.write('\n');
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/lightbox.css\" type=\"text/css\"\n");
      out.write("media=\"screen\" />   \n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" />\n");
      out.write("     <script src=\"js/jquery-1.7.2.min.js\"\n");
      out.write("     type=\"text/javascript\"></script> \n");
      out.write("\n");
      out.write("     <script src=\"js/lightbox.js\" type=\"text/javascript\"></script> \n");
      out.write("<article style=\"color:#fff;\" id=\"email\" class=\"panel\">\n");
      out.write("<title>Photo Sharing</title></head>\n");
      out.write("\n");
      out.write("<body style=\"color:#fff;\">\n");
      out.write("<h1> <span class=\"rainbow\" style=\"font-weight:bold; font-size:35px;\"> PHOTOSHARE! </span> </h1>\n");
      out.write("<h2>Just photos, no distractions. <h2>\n");

    NewCommentDao commentDao = new NewCommentDao();
    int id = commentDao.getUserId(request.getUserPrincipal().getName());
    String name = commentDao.getUserName(id);


      out.write("\n");
      out.write("\n");
      out.write("<h5> Hello ");
      out.print(name);
      out.write(", click here to <a href=\"/photoshare/logout.jsp\">log out</a> </h6>\n");
      out.write("<br>\n");
      out.write("<h2>Friends</h2>\n");
      out.write("<table> <tr><td>\n");
      out.write("<form action=\"addfriend.jsp\" method=\"POST\">\n");
      out.write("<input type=\"hidden\" name\"email1\" value=\"");
      out.print(request.getUserPrincipal().getName());
      out.write("\">\n");
      out.write("    <input type=\"text\" placeholder=\"User's Email\" name=\"email2\" style=\"color:#000;\">\n");
      out.write("    <input type=\"submit\" style=\"color:#000;\"  value=\"Add Friend\"/><br/>\n");
      out.write("</form>\n");
      out.write("</td><td>\n");
      out.write("<form action=\"viewfriend.jsp\" method=\"POST\">\n");
      out.write("<input type=\"submit\" style=\"color:#000;\" value=\"View your friends!\">\n");
      out.write("</form>\n");
      out.write("</td></tr> <tr><td>\n");
      out.write("<form action=\"topusers.jsp\" enctype=\"multipart/form-data\"\n");
      out.write("method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"View Top 10 Users\" style=\"color:#000;\" /><br/>\n");
      out.write("</form> \n");
      out.write("</td><td>\n");
      out.write("\n");
      out.write("<form action=\"allusers.jsp\" enctype=\"multipart/form-data\"\n");
      out.write("method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"View All Users\" style=\"color:#000;\" /><br/>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</td></tr></table>\n");
      out.write("\n");
      out.write("<h2>Albums</h2>\n");
      out.write("<table> <tr> <td>\n");
      out.write("<form action=\"addalbum.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"album_name\" style=\"color:#000;\">\n");
      out.write("    <input type=\"submit\" style=\"color:#000;\" value=\"Create Album\"/><br/>\n");
      out.write("</form>\n");
      out.write("</td> <td>\n");
      out.write("<form action=\"viewallalbums.jsp\" method=\"post\">\n");
      out.write("    <input type=\"submit\" style=\"color:#000;\" value=\"View All Albums\"/><br/>\n");
      out.write("</form>\n");
      out.write("</td><td>\n");
      out.write("<form action=\"viewmyalbums.jsp\" method=\"POST\">\n");
      out.write("    <input type=\"hidden\" name=\"user_id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("    <input type=\"submit\" style=\"color:#000;\" value=\"View My Albums\"/><br/>\n");
      out.write("</form>\n");
      out.write("</td>\n");
      out.write("</tr></table>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2>Upload a new photo</h2>\n");
      out.write("\n");
      out.write("<form action=\"index.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    Filename: <input type=\"file\" name=\"filename\"/>\n");
      out.write("    Caption: <input type=\"text\" name=\"caption\" style=\"color:#000;\"/>\n");
      out.write("    <input type=\"hidden\" name=\"email\" value=\"");
      out.print(request.getUserPrincipal().getName());
      out.write("\">\n");
      out.write("    <input type=\"submit\" value=\"Upload\" style=\"color:#000;\" /><br/>\n");
      out.write("</form>\n");
      out.write("\n");

    PictureDao pictureDao = new PictureDao();
        try{
	Picture picture = imageUploadBean.upload(request);
        if (picture != null) {
            pictureDao.save(picture);
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
    }

      out.write("\n");
      out.write("\n");
      out.write("<h2>All photos</h2>\n");
      out.write("<table>\n");
      out.write("\t<tr>\n");
      out.write("        ");

            List<Integer> pictureIds = pictureDao.allPicturesIds();
	    int counter = 0;
            for (Integer pictureId : pictureIds) {
	    counter+=1;
	    if(counter!=0&&counter%10==0){
        
      out.write("  \n");
      out.write("\t</tr><br><tr>\n");
      out.write("\t");

	}
	
      out.write("\n");
      out.write("        <td>\n");
      out.write("\t<a href=\"/photoshare/picture.jsp?picture_id=");
      out.print( pictureId);
      out.write("\">\n");
      out.write("<img src=\"/photoshare/img?t=1&picture_id=");
      out.print( pictureId );
      out.write("\"/>\n");
      out.write("        </a>\n");
      out.write("        </td>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("</tr> </table>\n");
      out.write("\n");
      out.write("<h2>Search</h2>\n");
      out.write("<table> <tr> \n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"searchbytagsmine.jsp\" enctype=\"multipart/form-data\"\n");
      out.write("method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Search My Photos By Tags\" style=\"color:#000;\"\n");
      out.write("    /><br\\\n");
      out.write("/>\n");
      out.write("</form> </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"searchbytags.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Search Photos By Tags\" style=\"color:#000;\" /><br/>\n");
      out.write("</form> </td>\n");
      out.write("</tr><tr>\n");
      out.write("<td>\n");
      out.write("<form action=\"tagsearch.jsp\" method=\"post\">\n");
      out.write("<input type=\"text\" name=\"tags\" placeholder=\"Separate by spaces\" style=\"color:#000;\"> \n");
      out.write("<input type=\"submit\" value=\"Conjunctive Tag Search\" style=\"color:#000;\" /><br/>\n");
      out.write("</form> </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"searchbyusers.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Search Photos By User\" style=\"color:#000;\" /><br/>\n");
      out.write("</form> </td>\n");
      out.write("</tr></table>\n");
      out.write("\n");
      out.write("<h2>Featured!</h2>\n");
      out.write("<table><tr><td>\n");
      out.write("<form action=\"mostpopular.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Most Popular Pictures\" style=\"color:#000;\" /><br/>\n");
      out.write("</form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"mostpopulartags.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Most Popular Tags\" style=\"color:#000;\"\n");
      out.write("    /><br/>\n");
      out.write("</form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"mostpopularusers.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Most Popular Users\" style=\"color:#000;\" /><br/>\n");
      out.write("</form>\n");
      out.write("</td></tr></table>\n");
      out.write("\n");
      out.write("<h2>Recommended For You</h2>\n");
      out.write("<table><tr><td>\n");
      out.write("<form action=\"tagfinder.jsp\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("    <input type=\"submit\" value=\"Photos You May Like\" style=\"color:#000;\"/><br\\>\n");
      out.write("</form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("<td>\n");
      out.write("<form action=\"tagsearch1.jsp\" method=\"post\">\n");
      out.write("    <input type=\"text\" name=\"tags\" placeholder=\"Separate by spaces\" style=\"color:#000;\">\n");
      out.write("    <input type=\"submit\" value=\"Tags You May Like\" style=\"color:#000;\"/><br/>\n");
      out.write("</form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("</article>\n");
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
