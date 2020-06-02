<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>                 
    <style>
      #boxes {
        content: "";
        display: table;
        clear: both;
      }
      div {
        float: left;
        height: 300px;
        width: 45%;
        padding: 0 10px;
      }
      #column1 {
        background-color: #FB5000;
      }
      #column2 {
        background-color: #3DEF1E;
         width: 45%;
      } 

      h2 {
        color: #000000;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <main id="boxes">
      <div id="column1">
       <h2>Novo Cadastro</h2>
<form action="SalvarServlet" method="post">
<table>
<tr><td>Nome:</td><td><input type="text" name="nome" required="required"/></td></tr>
<tr><td>Data de Nascimento:</td><td><input type="text" name="dataNascimento" placeholder="DD-MM-YYYY" required="required"/></td></tr>
<tr><td>Senha:</td><td><input type="password" name="senha" required="required"/></td></tr>
<tr><td>E-mail:</td><td><input type="email" name="email" required="required"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Cadastrar" required="required"/></td></tr>
</table>
</form>

<br>
<a href="VerServlet">Lista de Cadastrados</a>
<br>
<a href="ListaCadastroJSP.jsp">Lista de Cadastrados em JSP</a>
</div>
      <div id="column2">
        <h2>Login</h2>
	<form action="autenticacao" method="post">
<table>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Senha:</td><td><input type="password" name="senha"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Entrar"/></td></tr>
</table>
	</form>
	</div>
    </main>
  </body>
</html>