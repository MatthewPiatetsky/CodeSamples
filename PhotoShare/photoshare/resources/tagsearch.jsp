<%@ page import="photoshare.NewTagDao" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="NewTagBean"
             class="photoshare.NewTagBean">
    <jsp:setProperty name="NewTagBean" property="*"/>
</jsp:useBean>

<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title> </title></head>

<body style="color:#7FFF00;">



<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Conjunctive Tag Search!</h1>
<table>
    <tr>
        <%  
	    String fulltags2 =request.getUserPrincipal().getName();
	    String fulltags = request.getParameter("tags");
	    System.out.println("fulltags" + fulltags);
	    String[] tagsarray = fulltags.split(" ");
	    NewTagDao newtagDao1 = new NewTagDao();
            List<Integer> picture_ids = newtagDao1.searchTags(tagsarray);
            for (int picture_id : picture_ids) {
	%>
	
          <a href="/photoshare/picture.jsp?picture_id=<%= picture_id%>">
          <img src="/photoshare/img?t=1&picture_id=<%= picture_id %>"/>

        <%
           }
        %>
	

    </tr>
</table>


</body>
</html>
