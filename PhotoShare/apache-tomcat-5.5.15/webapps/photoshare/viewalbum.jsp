<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.Album" %>
<%@ page import="photoshare.AlbumDao" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>View Albums</title></head>

<body>
<%
AlbumDao albumDao = new AlbumDao();
String email1 = request.getUserPrincipal().getName();
String album_name = request.getParameter("album_name");
String album_owner = albumDao.getAlbumOwner(album_name);
System.out.println("email1 " + email1 + " album_owner " + album_owner);
%>    


<h2> The Album <span class="rainbow" ><%=album_name%></span> has the following photos! </h2>
<table>
    <tr>
        <%
            List<Integer> pictureIds = albumDao.allPicturesIds(album_name);
            for (Integer pictureId : pictureIds) {
        %>
        <td>
        <a href="/photoshare/picture.jsp?picture_id=<%= pictureId%>">
          <img src="/photoshare/img?t=1&picture_id=<%= pictureId %>"/>
        </a>
        </td>
        <%
            }
        %>
    </tr>
</table>
<%if(email1.equals(album_owner)){%>
<form action="deletealbum.jsp" method="post">
    <input type="hidden" name="album_name" value="<%=album_name%>">
    <input type="submit" style="color:#000;" value="Delete Album"/>
</form>
<%}%>

<a href="/photoshare/index.jsp">Look at more photos!</a>
</body>
</html>
