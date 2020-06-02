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

@WebServlet("/SalvarServlet")
public class SalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		String nome=request.getParameter("nome");
		String senha=request.getParameter("senha");
		String email=request.getParameter("email");
		String recebe2 = request.getParameter("dataNascimento").replaceAll("/", "").replaceAll(" ", "")
				.replaceAll("-", "");
		
		String formatado2 = Formatacao2.formatarData2(recebe2);

		
		try {
			Date recebeParaData2 = sdf.parse(formatado2);
		

		
		
		Usuario e=new Usuario();
		e.setNome(nome);
		e.setSenha(senha);
		e.setEmail(email);
		e.setDataNascimento(sdf.format(recebeParaData2));
		if(UsuarioDao.existeUsuario(e)) {
			out.print("<p>Email já cadastrado!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}else {
		int status=UsuarioDao.save(e);
		    if(status>0){
			out.print("<p>Cadastro efetuado com sucesso!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		   }else {
			out.println("Erro! Não foi possível salvar seus dados!");   
		   }
		}
		out.close();
		
	} catch (ParseException ex) {
		
		ex.printStackTrace();
		
	}
	}
}

