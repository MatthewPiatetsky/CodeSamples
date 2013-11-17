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

<title>Most Popular Photos </title></head>

<body style="color:#7FFF00;">

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h2 style="text-decoration:underline;">Look at the most popular photos!</h2>
        <%
	    NewCommentDao newcommentDao1 = new NewCommentDao();
            List<String> comments = newcommentDao1.mostPopular();
            for (String popularity : comments) {
	    	String[] splitStr = popularity.split("\\s+");
		int picture_id = Integer.parseInt(splitStr[0]);
		int count = Integer.parseInt(splitStr[1]);
	%>
 <a href="/photoshare/picture.jsp?picture_id=<%= picture_id%>">

 <img src="/photoshare/img?t=1&picture_id=<%= picture_id %>"/> </a> has
 popularity score <%=count%>! 
<br>
        <%
           }
        %>
	



</body>
</html>

