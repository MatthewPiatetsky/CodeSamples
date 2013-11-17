<%@ page import="photoshare.NewTagDao" %>
<%@ page import="photoshare.NewCommentDao" %>
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

<title>My Photos by Tag </title></head>

<body style="color:#7FFF00;">

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">My Photos By Tag!</h1>
<table>
    <tr>
        <%
            NewCommentDao commentDao = new NewCommentDao();
           int id = commentDao.getUserId(request.getUserPrincipal().getName());
	    NewTagDao newtagDao1 = new NewTagDao();
            List<String> tags = newtagDao1.myTags(id);
            for (String tag : tags) {
	%>
	
        <a href="/photoshare/tagphotos.jsp?tag_text=<%= tag%>"><%=tag%> </a>.     
        <%
           }
        %>
	

    </tr>
</table>


</body>
</html>

