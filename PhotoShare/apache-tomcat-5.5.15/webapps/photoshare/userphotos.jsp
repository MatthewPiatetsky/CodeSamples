<%@ page import="photoshare.NewUserDao" %>
<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<link rel="stylesheet" href="css/style.css" />

<title>Picture </title></head>

<body>

<a href="/photoshare/index.jsp">Take me back to the main page!</a>
<a href="/photoshare/userphotos.jsp">I want to search more user photos!</a>

<%
String user_name = request.getParameter("user_name");
%>
<h2> <span class="rainbow" ><%=user_name%></span> has uploaded the
following photos! </h2>
<table>
    <tr>
        <%
            NewUserDao newUserDao = new NewUserDao();
            List<Integer> pictureIds = newUserDao.allPicturesIds(user_name);
            for (Integer pictureId : pictureIds) {
        %>
        <td>
        <a href="/photoshare/picture.jsp?picture_id=<%= pictureId%>">
          <img src="/photoshare/img?t=1&picture_id=<%= pictureId %>"/>
        </a>
        </td>
        <%
            }
        %>
    </tr>
</table>

</body>
</html>

