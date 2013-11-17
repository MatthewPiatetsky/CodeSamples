<%@ page import="photoshare.NewUserDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="NewTagBean"
             class="photoshare.NewUserBean">
    <jsp:setProperty name="NewUserBean" property="*"/>
</jsp:useBean>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Users </title></head>

<body style="color:#7FFF00;">

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Photos By User!</h1>
<table>
    <tr>
        <%
	    NewUserDao newuserDao1 = new NewUserDao();
            List<String> users = newuserDao1.allUsers();
            for (String user : users) {
	%>
	
        <a style="color:##7FFF00;" href="/photoshare/userphotos.jsp?user_name=<%=user%>"> <%=user%> </a>.     
        <%
           }
        %>
	

    </tr>
</table>


</body>
</html>

