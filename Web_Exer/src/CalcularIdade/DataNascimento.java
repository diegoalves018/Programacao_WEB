package CalcularIdade;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataNascimento {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date dataNascimento;

	public DataNascimento(Date dataNascimento) {
		super();
		this.dataNascimento = dataNascimento;
	}

	public DataNascimento() {
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int validaData(String dataRecebida) {

		String diaEmString = dataRecebida.substring(0, 2);
		String mesEmString = dataRecebida.substring(2, 4);
		String anoEmString = dataRecebida.substring(4, 8);

		Integer dia = Integer.parseInt(diaEmString);
		Integer mes = Integer.parseInt(mesEmString);
		Integer ano = Integer.parseInt(anoEmString);

		int erro = 0;

		boolean validarFevereiro = false;

		if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))) {

			validarFevereiro = true;

		}

		if (dia > 31) {

			erro = -1;

		} else if (dia <= 0) {

			erro = -2;

		} else if (mes > 12) {

			erro = -3;

		} else if (mes < 01) {

			erro = -4;

		} else if (mes == 01 || mes == 03 || mes == 05 || mes == 07 || mes == 8 || mes == 10 || mes == 12) {

			if (dia <= 31) {

				erro = 0;
			}

		} else if (mes == 04 || mes == 06 || mes == 9 || mes == 11) {

			if (dia <= 30) {

				erro = 0;

			} else {

				erro = -5;

			}

		} else if (mes == 02 || mes == 2) {

			if (validarFevereiro == true) {

				if (dia <= 29) {

					erro = 0;

				}

			} else if (validarFevereiro == false) {

				if (dia > 28) {

					erro = -6;

				} else {

					erro = 0;

				}

			}

		}

		return erro;

	}

	public Integer calculoIdade() {

		Calendar dataDigitada = Calendar.getInstance();
		dataDigitada.setTime(dataNascimento);

		Calendar hoje = Calendar.getInstance();

		int idade = hoje.get(Calendar.YEAR) - dataDigitada.get(Calendar.YEAR);

		if (dataDigitada.get(Calendar.YEAR) > hoje.get(Calendar.YEAR)) {

			idade = -404;
			
		} else if (dataDigitada.get(Calendar.YEAR) < 1900) {

			idade = -1900;
			
		}else if  
            (dataDigitada.get(Calendar.DAY_OF_MONTH) > hoje.get(Calendar.DAY_OF_MONTH) && dataDigitada.get(Calendar.MONTH) >= hoje.get(Calendar.MONTH)) {
	         idade = (hoje.get(Calendar.YEAR) - dataDigitada.get(Calendar.YEAR))-1;

		}else if
			 (dataDigitada.get(Calendar.MONTH) < hoje.get(Calendar.MONTH) || (dataDigitada.get(Calendar.MONTH) == hoje.get(Calendar.MONTH) && dataDigitada.get(Calendar.DAY_OF_MONTH) <= hoje.get(Calendar.DAY_OF_MONTH))) {
				idade = hoje.get(Calendar.YEAR) - dataDigitada.get(Calendar.YEAR);
			
		     }else {
				idade = (dataDigitada.get(Calendar.YEAR) - hoje.get(Calendar.YEAR))-1;
				
		     }	
		
		 return idade;
	}

	public String anoRegras() {

		String erro = "";

		if (calculoIdade() == -404) {

			erro = erro + "Ano informado não pode ser superior ao atual!";

		} else if (calculoIdade() == -1900) {

			erro = erro + "Não é possível calcular data que tenha ano inferior a 1900!";

		}

		return erro;

	}

	public String resultadoRegras(int resultadoRgs) {

		String resultadoErro = "";

		if (resultadoRgs == -1) {

			resultadoErro = resultadoErro + "Não existe mês com mais de 31 dias!";

		} else if (resultadoRgs == -2) {

			resultadoErro = resultadoErro + "Não existe dia menor ou igual a zero!";

		} else if (resultadoRgs == -3) {

			resultadoErro = resultadoErro + "Não existe ano com mais de 12 meses!";

		} else if (resultadoRgs == -4) {

			resultadoErro = resultadoErro + "Não existe mês menor ou igual a zero!";

		} else if (resultadoRgs == -5) {

			resultadoErro = resultadoErro + "Mês digitado vai até o dia 30!";

		} else if (resultadoRgs == -6) {

			resultadoErro = resultadoErro + "O ano digitado não é bissexto, fevereiro vai até o dia 28!";

		}

		return resultadoErro;

	}

}