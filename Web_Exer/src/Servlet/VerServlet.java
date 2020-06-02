package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario;
import DAO.UsuarioDao;

@WebServlet("/VerServlet")
public class VerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.jsp'>Novo Cadastro</a>");
		out.println("<h1>Lista de Cadastrados</h1>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
		List<Usuario> list=UsuarioDao.getTodosCadastros();
		
		
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>Data de Nascimento</th><th>Editar</th><th>Deletar</th></tr>");
		for(Usuario e:list){
			Date date = formatUS.parse(e.getDataNascimento());
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getSenha()+"</td><td>"+e.getEmail()+"</td><td>"+sdf.format(date)+"</td><td><a href='EditarServlet?id="+e.getId()+"'>edit</a></td><td><a href='ApagarServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	
} catch (ParseException ex) {
		
		ex.printStackTrace();
	}
	}
}
