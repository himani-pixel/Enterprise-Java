<%@page import="java.sql.*"%>
<%@page import="db.DBConnection"%>

<%

if(request.getParameter("login")!=null)
{

String username=request.getParameter("username");
String password=request.getParameter("password");

Connection con=DBConnection.getConnection();

PreparedStatement ps=con.prepareStatement(

"select * from users where username=? and password=?"

);

ps.setString(1,username);
ps.setString(2,password);

ResultSet rs=ps.executeQuery();

if(rs.next())
{

session.setAttribute("user",username);

response.sendRedirect("success.jsp");

}
else
{

response.sendRedirect("error.jsp");

}

}

%>

<!DOCTYPE html>

<html>

<head>

<title>Login</title>

</head>

<body>

<h2>User Login</h2>

<form method="post">

Username

<input type="text" name="username">

<br><br>

Password

<input type="password" name="password">

<br><br>

<input type="submit" name="login" value="Login">

</form>

</body>

</html>
