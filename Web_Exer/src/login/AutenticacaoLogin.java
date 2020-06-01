package login;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UsuarioDao;

@WebServlet("/autenticacao")
public class AutenticacaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			UsuarioDao dao=new UsuarioDao();
			
			
			if(dao.check(email, senha))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username",email);
				
				response.sendRedirect("welcome.jsp");
				
			}else {
				
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("Usuário ou senha inválidos");
				out.println("<a href=\"index.jsp\"> Tentar novamente </a>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
	}

}