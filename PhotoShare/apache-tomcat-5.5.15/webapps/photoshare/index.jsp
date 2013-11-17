<%--

--%>
<%@ page import="photoshare.Picture" %>
<%@ page import="photoshare.PictureDao" %>
<%@ page import="photoshare.NewCommentDao" %>
<%@ page import="photoshare.NewUserDao" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="imageUploadBean"
             class="photoshare.ImageUploadBean">
    <jsp:setProperty name="imageUploadBean" property="*"/>
</jsp:useBean>

<html>
<head>

<link rel="stylesheet" href="css/lightbox.css" type="text/css"
media="screen" />   
<link rel="stylesheet" href="css/style.css" />
     <script src="js/jquery-1.7.2.min.js"
     type="text/javascript"></script> 

     <script src="js/lightbox.js" type="text/javascript"></script> 
<article style="color:#fff;" id="email" class="panel">
<title>Photo Sharing</title></head>

<body style="color:#fff;">
<h1> <span class="rainbow" style="font-weight:bold; font-size:35px;"> PHOTOSHARE! </span> </h1>
<h2>Just photos, no distractions. <h2>
<%
    NewCommentDao commentDao = new NewCommentDao();
    int id = commentDao.getUserId(request.getUserPrincipal().getName());
    String name = commentDao.getUserName(id);

%>

<h5> Hello <%=name%>, click here to <a href="/photoshare/logout.jsp">log out</a> </h6>
<br>
<h2>Friends</h2>
<table> <tr><td>
<form action="addfriend.jsp" method="POST">
<input type="hidden" name"email1" value="<%=request.getUserPrincipal().getName()%>">
    <input type="text" placeholder="User's Email" name="email2" style="color:#000;">
    <input type="submit" style="color:#000;"  value="Add Friend"/><br/>
</form>
</td><td>
<form action="viewfriend.jsp" method="POST">
<input type="submit" style="color:#000;" value="View your friends!">
</form>
</td></tr> <tr><td>
<form action="topusers.jsp" enctype="multipart/form-data"
method="post">
    <input type="submit" value="View Top 10 Users" style="color:#000;" /><br/>
</form> 
</td><td>

<form action="allusers.jsp" enctype="multipart/form-data"
method="post">
    <input type="submit" value="View All Users" style="color:#000;" /><br/>
</form>

</td></tr></table>

<h2>Albums</h2>
<table> <tr> <td>
<form action="addalbum.jsp" method="post">
    <input type="text" name="album_name" style="color:#000;">
    <input type="submit" style="color:#000;" value="Create Album"/><br/>
</form>
</td> <td>
<form action="viewallalbums.jsp" method="post">
    <input type="submit" style="color:#000;" value="View All Albums"/><br/>
</form>
</td><td>
<form action="viewmyalbums.jsp" method="POST">
    <input type="hidden" name="user_id" value="<%=id%>">
    <input type="submit" style="color:#000;" value="View My Albums"/><br/>
</form>
</td>
</tr></table>


<h2>Upload a new photo</h2>

<form action="index.jsp" enctype="multipart/form-data" method="post">
    Filename: <input type="file" name="filename"/>
    Caption: <input type="text" name="caption" style="color:#000;"/>
    <input type="hidden" name="email" value="<%=request.getUserPrincipal().getName()%>">
    <input type="submit" value="Upload" style="color:#000;" /><br/>
</form>

<%
    PictureDao pictureDao = new PictureDao();
        try{
	Picture picture = imageUploadBean.upload(request);
        if (picture != null) {
            pictureDao.save(picture);
        }
    } catch (FileUploadException e) {
        e.printStackTrace();
    }
%>

<h2>All photos</h2>
<table>
	<tr>
        <%
            List<Integer> pictureIds = pictureDao.allPicturesIds();
	    int counter = 0;
            for (Integer pictureId : pictureIds) {
	    counter+=1;
	    if(counter!=0&&counter%10==0){
        %>  
	</tr><br><tr>
	<%
	}
	%>
        <td>
	<a href="/photoshare/picture.jsp?picture_id=<%= pictureId%>">
<img src="/photoshare/img?t=1&picture_id=<%= pictureId %>"/>
        </a>
        </td>
        <%
            }
        %>
</tr> </table>

<h2>Search</h2>
<table> <tr> 

<td>
<form action="searchbytagsmine.jsp" enctype="multipart/form-data"
method="post">
    <input type="submit" value="Search My Photos By Tags" style="color:#000;"
    /><br\
/>
</form> </td>


<td>
<form action="searchbytags.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Search Photos By Tags" style="color:#000;" /><br/>
</form> </td>
</tr><tr>
<td>
<form action="tagsearch.jsp" method="post">
<input type="text" name="tags" placeholder="Separate by spaces" style="color:#000;"> 
<input type="submit" value="Conjunctive Tag Search" style="color:#000;" /><br/>
</form> </td>


<td>
<form action="searchbyusers.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Search Photos By User" style="color:#000;" /><br/>
</form> </td>
</tr></table>

<h2>Featured!</h2>
<table><tr><td>
<form action="mostpopular.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Most Popular Pictures" style="color:#000;" /><br/>
</form>
</td>

<td>
<form action="mostpopulartags.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Most Popular Tags" style="color:#000;"
    /><br/>
</form>
</td>

<td>
<form action="mostpopularusers.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Most Popular Users" style="color:#000;" /><br/>
</form>
</td></tr></table>

<h2>Recommended For You</h2>
<table><tr><td>
<form action="tagfinder.jsp" enctype="multipart/form-data" method="post">
    <input type="submit" value="Photos You May Like" style="color:#000;"/><br\>
</form>
</td>


<td>
<form action="tagsearch1.jsp" method="post">
    <input type="text" name="tags" placeholder="Separate by spaces" style="color:#000;">
    <input type="submit" value="Tags You May Like" style="color:#000;"/><br/>
</form>
</td>


</article>

</body>
</html>
