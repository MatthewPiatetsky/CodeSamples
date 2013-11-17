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

<title>Recommended Photos </title></head>

<body style="color:#7FFF00;">



<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">We think you might like these tags!</h1>
<table>
    <tr>
        <%  
	    String fulltags2 =request.getUserPrincipal().getName();
	    String fulltags = request.getParameter("tags");
	    System.out.println("fulltags" + fulltags);
	    String[] tagsarray = fulltags.split(" ");
	    NewTagDao newtagDao1 = new NewTagDao();
            List<String> recommendedTags = newtagDao1.recommendTags(tagsarray);
            for (String tag : recommendedTags) {
	    	if(!(java.util.Arrays.asList(tagsarray).contains(tag))){
	%>
	
 <a href="/photoshare/tagphotos.jsp?tag_text=<%= tag%>"><%=tag%> </a>

        <%
}
           }
        %>
	

    </tr>
</table>


</body>
</html>
