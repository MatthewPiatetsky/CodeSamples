<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.FriendDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Add Friend </title></head>

<body>


<%
FriendDao friendDao = new FriendDao();
String email1 = request.getUserPrincipal().getName();
String email2 = request.getParameter("email2");
boolean friend = friendDao.create(email1,email2);
String friends = friendDao.allFriends(email1);
if (friend){
%>
<h2> Congratulations! </h2>
You are now friends with <%= email2 %>!
<% } else { %>
<h3> Invalid Email! Please add a valid user! </h3>
<% } %>

<a href="/photoshare/index.jsp">Back to main page!</a>

</body>
</html>

