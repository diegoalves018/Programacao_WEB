package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario;
import DAO.UsuarioDao;

@WebServlet("/EditarServlet")
public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
		PrintWriter out=response.getWriter();
		out.println("<h1>Atualizar Cadastro</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		
		
		try {
				
		Usuario e=UsuarioDao.getCadastradosId(id);
		Date date = formatUS.parse(e.getDataNascimento());
		
		out.print("<form action='EditarServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Nome:</td><td><input type='text' name='nome' value='"+e.getNome()+"'/></td></tr>");
		out.print("<tr><td>Data de Nascimento:</td><td><input type='text' name='dataNascimento' value='"+sdf.format(date)+"'/></td></tr>");
		out.print("<tr><td>Senha:</td><td><input type='password' name='senha' value='"+e.getSenha()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Editar &amp; Salvar '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	
	} catch (ParseException ex) {
		
		ex.printStackTrace();
	}

	}
}
