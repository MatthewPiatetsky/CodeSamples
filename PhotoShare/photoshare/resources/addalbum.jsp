<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.Album" %>
<%@ page import="photoshare.AlbumDao" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Add Album</title></head>

<body>
<h2> Congratulations! </h2>
<%
AlbumDao albumDao = new AlbumDao();
String email1 = request.getUserPrincipal().getName();
String album_name = request.getParameter("album_name");
boolean album = albumDao.create(email1,album_name);
if (album){
%>
You have created the album "<%= album_name %>"!
<% } %>

<a href="/photoshare/index.jsp">Look at more photos!</a>

</body>
</html>

