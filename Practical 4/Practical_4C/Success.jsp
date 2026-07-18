<%

String user=(String)session.getAttribute("user");

if(user==null)
{
response.sendRedirect("login.jsp");
return;
}

%>

<!DOCTYPE html>

<html>

<head>

<title>Success</title>

</head>

<body>

<h1>Login Successful</h1>

<h2>Welcome <%=user%></h2>

</body>

</html>
(error.jsp):
