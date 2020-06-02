<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>

<h1>Olá, ${username}!</h1>
<%
                     String mensagem = "Bem vindo ao sistema!";
                 %>
                 <% out.println(mensagem); %>


<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp"); 
}
%>

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