package CalcularIdade;
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



@WebServlet(name = "Aniver", urlPatterns = "/regra")
public class Aniver extends HttpServlet {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataNascimento classeData = new DataNascimento();

		PrintWriter out = response.getWriter();

		try {

			// Recebendo String
			String recebe = request.getParameter("dataNascimento").replaceAll("/", "").replaceAll(" ", "")
					.replaceAll("-", "");

			// Formatcao data
			String formatado = Formatacao.formatarData(recebe);

			Date recebeParaData = sdf.parse(formatado);

			classeData.setDataNascimento(recebeParaData);

			int resultadoRgs = classeData.validaData(recebe);

			// Idade
			int idadeResultado = classeData.calculoIdade();

			// Regra
			String regrasData = classeData.anoRegras();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado Do Aniversário</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\" style=\"text-align: center\">");

			out.println("<br>");
			out.println("<br>");
			out.println("Data informada: " + formatado);
			out.println("<br>");
			out.println("<br>");
			
			if (resultadoRgs != 0) {

				String regra = classeData.resultadoRegras(resultadoRgs);

				
				out.println("Erro ao calcular: " + regra);
				out.println("<a href=\"CalculoAniver.html\"> Tentar novamente </a>");
				
				
			}

			if (classeData.calculoIdade() == -404) {

				out.println("Erro ao calcular: " + regrasData);
				out.println("<a href=\"CalculoAniver.html\"> Tentar novamente </a>");
			} else if (classeData.calculoIdade() == -1900) {

				out.println("Erro ao calcular: " + regrasData);
				out.println("<a href=\"CalculoAniver.html\"> Tentar novamente </a>");
				
			} else if (resultadoRgs == 0) {

				out.println("");
				out.println("<br>");
				out.println("<br>");
				out.println("Idade: " + idadeResultado + " ano(s)" );

			}

			out.println("<div>");
			out.println("</body>");
			out.println("</html>");

			response.setContentType("text/html");

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
