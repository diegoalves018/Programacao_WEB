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

import CalcularIdade.Formatacao2;
import DAO.Usuario;
import DAO.UsuarioDao;

@WebServlet("/EditarServlet2")
public class EditarServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nome=request.getParameter("nome");
		String senha=request.getParameter("senha");
		String email=request.getParameter("email");   
		String recebe3 = request.getParameter("dataNascimento").replaceAll("/", "").replaceAll(" ", "")
				.replaceAll("-", "");
		
		String formatado3 = Formatacao2.formatarData2(recebe3);
		
		try {
			Date recebeParaData3 = sdf.parse(formatado3);
			
		Usuario e=new Usuario();
		e.setId(id);
		e.setNome(nome);
		e.setSenha(senha);
		e.setEmail(email);
		e.setDataNascimento(sdf.format(recebeParaData3));
		
	
		int status=UsuarioDao.update(e);
		if(status>0){
			response.sendRedirect("VerServlet");
		}else{
			out.println("Erro! Não foi possível atualizar!");
		}
		
		out.close();
	
	} catch (ParseException ex) {
		
		ex.printStackTrace();
	}
	}
}

