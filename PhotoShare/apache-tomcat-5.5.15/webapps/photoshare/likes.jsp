<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="NewCommentBean"
             class="photoshare.NewCommentBean">
    <jsp:setProperty name="NewCommentBean" property="*"/>
</jsp:useBean>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Likes </title></head>

<body>

<!-- Create Like  -->
<%
    NewCommentDao newCommentDao = new NewCommentDao();
    String requestemail = request.getParameter("email");
    int pid = Integer.valueOf(request.getParameter("picture_id"));
    boolean comment = newCommentDao.createLike(requestemail,pid);
%>


<a href="/photoshare/picture.jsp?picture_id=<%= pid%>">Take me back to the picture page!</a>

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Likes</h1>
<table>
    <tr>
	<h2> This photo was liked by the following people:  </h2>
        <%
	    NewCommentDao newCommentDao1 = new NewCommentDao();
            List<String> like_authors = newCommentDao1.allLikes(pid);
	    int numlikes = newCommentDao1.numLikes(pid);
            for (String author : like_authors) {
        %>
       <h3> <%= author %></h3> <br>
        <%
           }
        %>
	<h3> This photo has <%=numlikes%> likes!
    </tr>
</table>


</body>
</html>

