<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.AlbumDao" %>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Logout</title></head>

<body>
<h2>Album Deleted! :( </h2>
<h3>We are very sorry to see it go!</h3>
<%
    String album_name = request.getParameter("album_name");
    AlbumDao albumDao1 = new AlbumDao();
    albumDao1.delete(album_name);

%>

<a href="/photoshare/index.jsp">Don't be sad! Look at more photos!</a>
</body>
</html>
