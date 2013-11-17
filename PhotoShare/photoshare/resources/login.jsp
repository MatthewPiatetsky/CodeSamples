<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


<title>Photoshare Login</title></head>

<body style = "background-image: url(css/images/bg3.jpg);">
<h1> <span style="font-weight:bold; font-size:35px;
background-image:-webkit-gradient( linear, left top, right top,
color-stop(0, #f22), color-stop(0.15, #f2f), color-stop(0.3, #22f),
color-stop(0.45, #2ff), color-stop(0.6, #2f2),color-stop(0.75, #2f2),
color-stop(0.9, #ff2), color-stop(1, #f22) );
  color:transparent;
  -webkit-background-clip: text;"> PHOTOSHARE! </span> </h1>


<h2 style="color: #fff;">Please login</h2>

<div style="color: #fff;">
<form method="POST" action="j_security_check">
    <table>
        <tr><th  style="color: #fff;">Email</th><td><input type="text" name="j_username"></td></tr>
        <tr><th style="color: #fff;">Password</th><td><input type="password" name="j_password"></td>
        </tr>
        <tr><td colspan="2" align="right"><input type="submit" value="Login"/>
        </td></tr>
    </table>
</form>
</div>

<form action="newuser.jsp" method="post">
    <table>
        <tr><td colspan="2" align="right"><input type="submit"
    value="Register"/></td></tr>
    </table>
</form>

<div style="color: #fff;">
<form method="POST" action="j_security_check">
    <table>
        <input type="hidden" name="j_username" value="Anonymous"></td></tr>
        <input type="hidden" name="j_password" value="password"></td>
        </tr>
        <tr><td colspan="2" align="right"><input type="submit"
        value="Browse Anonymously"/>
        </td></tr>
    </table>
</form>
</div>


<br>
<img src="css/images/PhotoSharing.jpg">

</body>
</html>
