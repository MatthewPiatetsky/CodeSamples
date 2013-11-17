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

<title>Comments </title></head>

<body>

<!-- Create Comment DAO -->
<%
    NewCommentDao newCommentDao = new NewCommentDao();
    String comment_text = request.getParameter("comment_text");
    String emailget = request.getUserPrincipal().getName();
    int pid = Integer.valueOf(request.getParameter("picture_id"));
    Integer uid = newCommentDao.getUserId(emailget);
    boolean comment = newCommentDao.create(comment_text,uid,pid);
%>

<% PictureDao pictureDao = new PictureDao(); 
Picture picture1 = pictureDao.load(pid);
String pcaption=picture1.getCaption(); %>
<h1 style="color:green; font-weight: bold; text-decoration: underline;"><%= pcaption %></h1>
            <img style="max-width:85%; height: auto;" src="/photoshare/img?picture_id=<%= pid %>"/>
	    <br>

<a href="/photoshare/picture.jsp?picture_id=<%= pid%>">Take me back to the picture page!</a>

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<br>

<h1 style="text-decoration:underline;">Comments</h1>
<table>
    <tr>
        <%
	    NewCommentDao newCommentDao1 = new NewCommentDao();
            List<String> comment_texts = newCommentDao1.allCommentText(pid);
            for (String commenttext : comment_texts) {
        %>
       <h3> <%= commenttext %></h3> <br>
        <%
           }
        %>
    </tr>
</table>


</body>
</html>

