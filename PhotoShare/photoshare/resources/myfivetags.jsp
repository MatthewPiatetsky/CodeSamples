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

<title>My Photos by Tag </title></head>

<body style="color:#7FFF00;">

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Tags</h1>
<table>
    <tr>
        <%
            NewCommentDao commentDao = new NewCommentDao();
           int id = commentDao.getUserId(request.getUserPrincipal().getName());
	    NewTagDao newtagDao1 = new NewTagDao();
            List<String> tags = newtagDao1.myTags(id);
            string complete = "";
	    for (String tag : tags) {
	    complete+= tag + " ";
	%>

<form action="tagsearch.jsp" method="post">
<input type="text" name="tags" placeholder="Separate by spaces" style="color:#000;"> 
<input type="submit" value="Conjunctive Tag Search" style="color:#000;" /><br/>
</form>	

        <%
           }
        %>
	

    </tr>
</table>


</body>
</html>

