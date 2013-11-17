<%@ page import="photoshare.NewTagDao" %>
<%@ page import="photoshare.NewCommentDao" %>
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

<title>Recommend Photos </title></head>

<body style="color:#7FFF00;">



<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">We think you might like these photos!</h1>
<table>
    <tr>
     <%
            NewCommentDao commentDao = new NewCommentDao();
           int id = commentDao.getUserId(request.getUserPrincipal().getName());
	    NewTagDao newtagDao2 = new NewTagDao();
            List<String> tags = newtagDao2.myTagsFive(id);
            String complete = "";
	    for (String tag : tags) {
	    complete+= tag + " ";
	    }

	    String[] tagsarray = complete.split(" ");
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
