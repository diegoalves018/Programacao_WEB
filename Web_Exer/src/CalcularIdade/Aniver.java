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

			// String recebida
			String recebida = request.getParameter("dataNascimento").replaceAll("/", "").replaceAll(" ", "")
					.replaceAll("-", "");

			// Formato data: dd/mm/yyyy
			String formatado = Formatacao.formatarData(recebida);

			Date recebidaParaData = sdf.parse(formatado);

			classeData.setDataNascimento(recebidaParaData);

			// Validação
			int resultadoRgs = classeData.validaData(recebida);

			// Idade
			int idadeResultado = classeData.calculoIdade();

			// Regra
			String regras = classeData.anoRegras();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\" style=\"text-align: center\">");

			out.println("<br>");
			out.println("<br>");
			out.println("Data informada: " + formatado);
			out.println("<br>");
			out.println("<br>");
			
			if (resultadoRgs != 0) {

				String aqui = classeData.resultadoRegras(resultadoRgs);

				out.println("Descrição: " + aqui);

			} else {

				out.println("Data válida");

			}

			if (classeData.calculoIdade() == -100) {

				out.println("Erro ao calcular: " + regras);

			} else if (classeData.calculoIdade() == -1900) {

				out.println("Erro ao calcular: " + regras);

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
