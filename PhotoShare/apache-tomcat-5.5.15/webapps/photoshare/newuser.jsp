<%--
  Author: Giorgos Zervas <cs460tf@cs.bu.edu>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="photoshare.NewUserDao" %>
<jsp:useBean id="newUserBean"
             class="photoshare.NewUserBean" />
<jsp:setProperty name="newUserBean" property="*"/>

<html>
<head>

<link rel="stylesheet" href="css/style.css" />


<title>New User</title></head>

<body>
<!-- We want to show the form unless we successfully create a new user -->
<% boolean showForm = true;
   String err = null; %>

<% if (!newUserBean.getEmail().equals("")) {
     if (!newUserBean.getPassword1().equals(newUserBean.getPassword2())) {
       err = "Both password strings must match";


     }
     else if (newUserBean.getPassword1().length() < 4) {
       err = "Your password must be at least four characters long";
     }
     else {
       // We have valid inputs, try to create the user
       NewUserDao newUserDao = new NewUserDao();
       boolean success = newUserDao.create(newUserBean.getEmail(),newUserBean.getFirstName(),newUserBean.getLastName(),request.getParameter("date_of_birth"),request.getParameter("gender"),newUserBean.getPassword1(),request.getParameter("hometown_address"),request.getParameter("current_address"),request.getParameter("education_information"));
       if (success) {
         showForm = false;
       } else {
         err = "Couldn't create user (that email may already be in use)";
       }
     }
   }
%>

<% if (err != null) { %>
<font color=red><b>Error: <%= err %></b></font>
<% } %>

<% if (showForm) { %>
<h1> <span class="rainbow" style="font-weight:bold; font-size:35px;">
PHOTOSHARE! </span> </h1>

<div style="color: #fff;" class="center" id="wrapper">

<h2 style="color: #fff;">New user info</h2>
<h3 style="color: #fff;">Fields marked with an asterisk are mandatory.</h3>
<article id="email" class="panel">

<form action="newuser.jsp" method="post">
  First Name*: <input type="text" style="color:#000;" name="firstName"/><br>
  Last Name*: <input type="text" style="color:#000;" name="lastName"/><br>
  Email*: <input type="text"  style="color:#000;" name="email"/><br>
  Date of Birth*: <input type="date" style="color:#000;" name="date_of_birth"/><br>
  Gender: <input type="radio" style="color:#000;" name="gender"
  value="Male"/> Male
  <input type="radio" style="color:#000;" name="gender" value="Female"/> Female  <br>
  Hometown Address (City, State, Country): <input type="text"
  style="color:#000;" name="hometown_address"/><br>
  Current Address (City, State, Country): <input type="text"
  style="color:#000;" name="current_address"/><br>
  Education Information (School/Major): <input type="text"
  style="color:#000;" name="education_information"/><br>
  Password*: <input type="password" style="color:#000;" name="password1"/><br>
  Re-enter password*: <input type="password" style="color:#000;" name="password2"/><br>
  <input type="submit" style="color:#000;" value="Register"/><br/>
</form>
</article>
</div>
<% }
   else { %>
<h1 style="color: #fff;"> PHOTOSHARE! </h1>

<h2 style="color:#fff;">Success!</h2>

<p style="color:#fff;">A new user has been created with email <%= newUserBean.getEmail() %>.
You can now return to the <a href="login.jsp">login page</a>. </p>

<% } %>

</body>
</html>
