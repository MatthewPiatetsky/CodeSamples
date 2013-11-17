<%@ page import="photoshare.NewTagDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="NewTagBean"
             class="photoshare.NewTagBean">
    <jsp:setProperty name="NewTagBean" property="*"/>
</jsp:useBean>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Tags </title></head>

<body>

<!-- Create Tag DAO -->
<%
    NewTagDao newTagDao = new NewTagDao();
    String tag_text = request.getParameter("tag_text");
    String emailget = request.getUserPrincipal().getName();
    int pid = Integer.valueOf(request.getParameter("picture_id"));
    Integer uid = newTagDao.getUserId(emailget);
    boolean tagged = newTagDao.create(tag_text,uid,pid);
%>

<% PictureDao pictureDao = new PictureDao(); 
Picture picture1 = pictureDao.load(pid);
String pcaption=picture1.getCaption(); %>
<h1 style="color:green; font-weight: bold; text-decoration: underline;"><%= pcaption %></h1>
            <img style="max-width:85%; height: auto;"  src="/photoshare/img?picture_id=<%= pid %>"/>
	    <br>

<a href="/photoshare/picture.jsp?picture_id=<%= pid%>">Take me back to the picture page!</a>

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Tags</h1>
<table>
    <tr>
        <%
	    NewTagDao newtagDao1 = new NewTagDao();
            List<String> tags = newtagDao1.allTagText(pid);
            for (String tag : tags) {
	%>
	
        <%= tag    %>.     
        <%
           }
        %>
    </tr>
</table>


</body>
</html>

