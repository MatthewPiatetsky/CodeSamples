<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.PictureDao" %>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Logout</title></head>

<body>
<h2>Picture Deleted! :( </h2>
<%
    String sid = request.getParameter("pid");
    int picture_id=Integer.parseInt(sid);
    PictureDao pictureDao1 = new PictureDao();
    pictureDao1.delete(picture_id);

%>

<a href="/photoshare/index.jsp">Look at more photos!</a>
</body>
</html>
