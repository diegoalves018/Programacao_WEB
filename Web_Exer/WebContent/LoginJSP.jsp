<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Login de Usuário</title>
	</head>
	<form action="autenticacao" method="post">
		<label>Login(admin):</label> 
		<input type="text" name="nomeUsuario" />
		<br />
		<label>Senha(admin):</label>
		<input type="password" name="senhaUsuario" />
		<br />
		<input type="submit" value="Entrar" />
	</form>
</html>