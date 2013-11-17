<%@ page import="photoshare.FriendDao" %>
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

<title>Most Popular Users </title></head>

<body style="color:#7FFF00;">

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h2 style="text-decoration:underline;">Look at the most popular users!</h2>
        <%
	    FriendDao newfriendDao = new FriendDao();
            List<String> friends = newfriendDao.mostPopular();
            for (String popularity : friends) {
	    	String[] splitStr = popularity.split("\\s+");
		String user = splitStr[0];
		int count = Integer.parseInt(splitStr[1]);
	%>



 <a style="color:##7FFF00;"> <%=user%> </a> has <%=count%> friends! 
<br>
        <%
           }
        %>
	



</body>
</html>

