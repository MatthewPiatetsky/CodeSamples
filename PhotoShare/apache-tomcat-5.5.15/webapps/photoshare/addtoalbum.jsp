<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.Album" %>
<%@ page import="photoshare.AlbumDao" %>
<%@ page import="java.util.List" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.NewUserDao" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Add Photo To Album </title></head>


<body>
<%
String album_name = request.getParameter("album_name");
int picture_id = Integer.valueOf(request.getParameter("picture_id"));
String owner = request.getUserPrincipal().getName();
AlbumDao albumDao = new AlbumDao();
if (owner.equals(albumDao.getAlbumOwner(album_name))){
   albumDao.addphoto(album_name,picture_id);
%>
<h2> Congratulations! </h2>
You have uploaded this picture to the album <%=album_name%>!
<% } else {
%>

<h2> Sorry! </h2>
<%=album_name%> is not one of your albums!
<% } %>
<a href="/photoshare/index.jsp">Add more photos to albums!</a>

</body>
</html>

