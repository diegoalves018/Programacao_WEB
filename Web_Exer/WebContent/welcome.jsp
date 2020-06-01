<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>
<h1>Seja Bem-Vindo!</h1>



<%
response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp"); 
}
%>

<h2>Olá, ${username}!</h2>

<br>
<br>
<a href="VerServlet">Lista de Cadastrados</a><br>
<a href="CalculoAniverJSP.jsp">Calcular Idade</a><br>

<br>
<form action="Logout">
<input type="submit" value="Logout">

</form>

</body>
</html>