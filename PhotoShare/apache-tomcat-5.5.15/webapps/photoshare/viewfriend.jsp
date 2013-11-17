<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>View Friends</title></head>

<body>
<%
FriendDao friendDao = new FriendDao();
String email1 = request.getUserPrincipal().getName();
String friends = friendDao.allFriends(email1);
%>    


<h2> You have the following friends! </h2>
<h3> <%= friends %> </h3>

<a href="/photoshare/index.jsp">Look at more photos!</a>
</body>
</html>
