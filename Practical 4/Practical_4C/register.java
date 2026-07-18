<%@page import="java.sql.*"%>
<%@page import="db.DBConnection"%>

<%

String msg="";

if(request.getParameter("register")!=null)
{

String username=request.getParameter("username");
String password=request.getParameter("password");

Connection con=DBConnection.getConnection();

PreparedStatement ps=con.prepareStatement(
"insert into users(username,password) values(?,?)");

ps.setString(1,username);
ps.setString(2,password);

int i=ps.executeUpdate();

if(i>0)
msg="Registration Successful!";
else
msg="Registration Failed";

}

%>

<!DOCTYPE html>

<html>

<head>

<title>Register</title>

</head>

<body>

<h2>User Registration</h2>

<form method="post">

Username

<input type="text" name="username">

<br><br>

Password

<input type="password" name="password">

<br><br>

<input type="submit" name="register" value="Register">

</form>

<br>

<%=msg%>

<br><br>

<a href="login.jsp">Go to Login</a>

</body>
</html>
