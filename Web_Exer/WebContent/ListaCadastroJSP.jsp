<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="DAO.UsuarioDao, DAO.Usuario, java.util.List, java.text.SimpleDateFormat,java.util.Date"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cadastrados em JSP</title>
</head>
<body>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");

List<Usuario> list=UsuarioDao.getTodosCadastros();
out.println("<a href='index.jsp'>Novo Cadastro</a>");
out.print("<table border='1' width='100%'");
out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>Data de Nascimento</th><th>Editar</th><th>Deletar</th></tr>");

for ( Usuario e: list){
	Date date = formatUS.parse(e.getDataNascimento());
	out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getSenha()+"</td><td>"+e.getEmail()+"</td><td>"+sdf.format(date)+"</td><td><a href='EditarServlet?id="+e.getId()+"'>edit</a></td><td><a href='ApagarServlet?id="+e.getId()+"'>delete</a></td></tr>");
}
%>

</body>
</html>